package com.example.photoprofileui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.rememberImagePainter
import com.example.photoprofileui.ui.theme.Purple200
import com.example.photoprofileui.ui.theme.Shapes


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ApplicationNavigation()
        }
    }
}

@Composable
fun ApplicationNavigation(userProfile: List<UserData> = userProfileList) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "user_list") {
        composable("user_list") {
            UserListScreen(userProfile = userProfile, navController)
        }

        composable(route = "user_details/{userId}",
            arguments = listOf(navArgument("userId") {
                type = NavType.IntType
            })) {navBackStackEntry ->
            UserDetailScreen(navBackStackEntry.arguments!!.getInt("userId"),navController)
        }
    }
}

// MAIN Screen
@Composable
fun UserListScreen(userProfile: List<UserData>, navigation: NavHostController?) {
    Scaffold(
        topBar = {
            TopBar()
//            navigation?.navigateUp()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Gray
                )

                .padding(horizontal = 23.dp, vertical = 10.dp)
        ) {
            items(userProfile) { index ->
                ProfileCard(userDetails = index) {
                    navigation?.navigate("user_details/${index.id}")
                }
            }
        }
    }
}

@Composable
fun ProfileCard(userDetails: UserData, clickEvent: () -> Unit) {//
    Column(
        modifier = Modifier
            .padding(top = 12.dp)
            .clickable {
                clickEvent.invoke()
            }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            shape = Shapes.medium
        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .size(72.dp)
            ) {
                PhotoProfile(
                    userDetails.drawableId,
                    userDetails.onineStatus,
                )

                ContentProfile(
                    userName = userDetails.userName,
                    onlineStatus = userDetails.onineStatus,
                )
            }
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        modifier = Modifier.background(
            color = Purple200,
        ),

    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_home_24),
            contentDescription = "Home Icon",
            modifier = Modifier
                .padding(start = 10.dp)
                .size(35.dp)
        )

        Text(
            text = "User List Screen",
            color = White,
            modifier = Modifier.padding(start = 90.dp),
            fontSize = 20.sp // dddddd
        )

    }
}

// TODO Photo
@Composable
fun PhotoProfile(
    userPhoto: String,
    onlineStatus: Boolean,
    size: Dp = 80.dp, // card size
) { // userPhoto: Int, onlineStatus: Boolean

    Card(
        shape = RoundedCornerShape(100),
        border = BorderStroke(
            width = 2.dp,
            color = if (onlineStatus) Green else Red,
        ),
        modifier = Modifier
            .size(size)
    ) {
        Image(
            painter = rememberImagePainter(
                data = userPhoto,
            ),
            contentDescription = "hfh",
            modifier = Modifier
                .size(80.dp),
            contentScale = ContentScale.Crop

        )
    }
}

// TODO Content
@Composable
fun ContentProfile(
    userName: String,
    onlineStatus: Boolean,
    paddingTop: Dp = 13.dp,
    startPadding: Dp = 30.dp,
    inBetweenPadding: Dp = 3.dp,
    onlineStatusFontSize: Int = 18,
    userContentSize: Int = 24,
) { //userName: String, onlineStatus: Boolean
    Column(
        modifier = Modifier
            .padding(start = startPadding, top = paddingTop),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = userName,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier,
            fontWeight = FontWeight.Bold,
            fontSize = userContentSize.sp
        )
        Text(
            text = if (onlineStatus) "Active now" else "Offline",
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(inBetweenPadding)
//                .alpha(1.2f),
            ,
            fontWeight = FontWeight.Medium,
            fontSize = onlineStatusFontSize.sp,
            color = Color.Gray
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UserListScreen(
        userProfileList,
        null
    )
}

@Composable
fun UserDetailScreen(userId : Int,navigation: NavHostController?) {
    val userProfile = userProfileList.first{  // First
        userData -> userId == userData.id
    }

    Scaffold(
        topBar = {
            AppBarDetails(navigation = navigation)
//            navigation?.navigateUp()
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PhotoProfile(
                userPhoto = userProfile.drawableId,
                onlineStatus = userProfile.onineStatus,
                size = 200.dp
            )

            ContentProfile(
                userName = userProfile.userName,
                onlineStatus = userProfile.onineStatus,
                paddingTop = 20.dp,
                startPadding = 15.dp,
                inBetweenPadding = 5.dp,
                onlineStatusFontSize = 23,
                userContentSize = 30
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserListDetailPreview() {
//    UserDetailScreen()
}