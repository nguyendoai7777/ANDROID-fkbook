package com.example.fkbook.ui.screens.home

enum class OnlineMode {
    Offline,
    Online,
    Livestream
}
enum class ActiveMode {
    None,
    Livestream
}

data class FeedItemData(
    val avatar: String,
    val media: String,
    val onlineMode: OnlineMode,
    val activeMode: ActiveMode,
    val useName: String
)

const val IMG = "https://scontent.fhan5-2.fna.fbcdn.net/v/t39.30808-6/328926784_528880985748265_2259476952235013463_n.jpg?stp=dst-jpg_s280x280&_nc_cat=104&ccb=1-7&_nc_sid=365331&_nc_ohc=Se6FFIzkwoMAX846prA&_nc_ht=scontent.fhan5-2.fna&oh=00_AfCpqMBYXNNpUc2uSnFB3f_-VEFNgYcRobP3NjBMy_9jig&oe=63E0B6BE"
const val V_AVATAR = "https://scontent.fhan5-11.fna.fbcdn.net/v/t39.30808-1/315143844_2456003087874227_1199592774718030853_n.jpg?stp=cp0_dst-jpg_p40x40&_nc_cat=103&ccb=1-7&_nc_sid=7206a8&_nc_ohc=iouKXoA0oLMAX-_uB05&_nc_ht=scontent.fhan5-11.fna&oh=00_AfBEK48MtS9tP2lrpG8DTZPUCd03CLLZylfn7IHnjuLFyQ&oe=63E1E4D9"


val FeedList = listOf(
    FeedItemData(
        "https://scontent.fsgn13-3.fna.fbcdn.net/v/t39.30808-1/315143844_2456003087874227_1199592774718030853_n.jpg?stp=cp0_dst-jpg_p60x60&_nc_cat=103&ccb=1-7&_nc_sid=7206a8&_nc_ohc=iouKXoA0oLMAX_h6vnA&_nc_ht=scontent.fsgn13-3.fna&oh=00_AfArEaUFSEH88Qkj5bpKGESZR5Vf60A1PRXloEWE9FSXUw&oe=63E1E4D9",
        "https://scontent.fhan5-11.fna.fbcdn.net/v/t39.30808-6/328275595_743292690336691_897429437630836666_n.jpg?stp=dst-jpg_s280x280&_nc_cat=100&ccb=1-7&_nc_sid=365331&_nc_ohc=_JdV2WL13vAAX9tu5yU&_nc_ht=scontent.fhan5-11.fna&oh=00_AfBwwtmayzFRgDYrVN1dkG5uKk6TVfGBioiLnx-3IdqcKQ&oe=63E259A4",
        OnlineMode.Livestream,
        ActiveMode.Livestream,
        "User Name"
    ),
    FeedItemData(
        "https://scontent.fhan5-2.fna.fbcdn.net/v/t39.30808-6/328926784_528880985748265_2259476952235013463_n.jpg?stp=dst-jpg_s280x280&_nc_cat=104&ccb=1-7&_nc_sid=365331&_nc_ohc=Se6FFIzkwoMAX846prA&_nc_ht=scontent.fhan5-2.fna&oh=00_AfCpqMBYXNNpUc2uSnFB3f_-VEFNgYcRobP3NjBMy_9jig&oe=63E0B6BE",
        "https://scontent.fhan5-10.fna.fbcdn.net/v/t15.5256-10/327157435_151335144388885_6062093640904209371_n.jpg?stp=dst-jpg_s280x280&_nc_cat=101&ccb=1-7&_nc_sid=ad6a45&_nc_ohc=nhZf4PmCbpcAX8XD9Ea&_nc_ht=scontent.fhan5-10.fna&oh=00_AfCAtVu5rcgF4sBbjYy2Z85G9sG6L9yrN1kWAvZX3HxhoA&oe=63E21911",
        OnlineMode.Online,
        ActiveMode.None,
        "User Name"
    ),
    FeedItemData(
        "https://scontent.fhan5-2.fna.fbcdn.net/v/t1.6435-1/169511403_491560082032539_195800604174637899_n.jpg?stp=cp0_dst-jpg_p40x40&_nc_cat=102&ccb=1-7&_nc_sid=7206a8&_nc_ohc=q1U7eSV5c34AX9P6Yly&_nc_ht=scontent.fhan5-2.fna&oh=00_AfAoxpq57kM-oJvyfNKIDKXqcL2stqjx7KCnkEZIm6pMxw&oe=6403FD3B",
        "https://scontent.fhan5-2.fna.fbcdn.net/v/t39.30808-6/328926784_528880985748265_2259476952235013463_n.jpg?stp=dst-jpg_s280x280&_nc_cat=104&ccb=1-7&_nc_sid=365331&_nc_ohc=Se6FFIzkwoMAX846prA&_nc_ht=scontent.fhan5-2.fna&oh=00_AfCpqMBYXNNpUc2uSnFB3f_-VEFNgYcRobP3NjBMy_9jig&oe=63E0B6BE",
        OnlineMode.Offline,
        ActiveMode.None,
        "User Name"
    ),
    FeedItemData(
        "https://scontent.fhan5-10.fna.fbcdn.net/v/t39.30808-1/272993845_694262428378267_1078871131643364573_n.jpg?stp=cp0_dst-jpg_p40x40&_nc_cat=101&ccb=1-7&_nc_sid=7206a8&_nc_ohc=3_5acuVeek0AX8B_Gj-&_nc_ht=scontent.fhan5-10.fna&oh=00_AfAZmtyLnl3SozEgLVqBjkahhB8JOP1DZUndC0O5RIDu_Q&oe=63E0AF82",
        "https://scontent.fhan5-8.fna.fbcdn.net/v/t15.5256-10/321309134_222808980115775_2896011581309095783_n.jpg?stp=dst-jpg_s280x280&_nc_cat=108&ccb=1-7&_nc_sid=ad6a45&_nc_ohc=I_bhYYuVBCYAX_D1gJl&_nc_ht=scontent.fhan5-8.fna&oh=00_AfAjCUSIN_LtETnoMZ7soW7p9fwteY5XzdeOYnBKKHdSYA&oe=63E27C4F",
        OnlineMode.Offline,
        ActiveMode.None,
        "User Name"
    ),
    FeedItemData(
        "https://scontent.fhan5-2.fna.fbcdn.net/v/t1.18169-1/12049600_405299279668262_6291642664012147695_n.jpg?stp=cp0_dst-jpg_p40x40&_nc_cat=102&ccb=1-7&_nc_sid=7206a8&_nc_ohc=tSfpjxdqth8AX-NL7hM&_nc_ht=scontent.fhan5-2.fna&oh=00_AfBPvwquhXtCNN2t1FzE92bBTwUy8MsZ5SyXoWATfiRL8g&oe=64043169",
        "https://scontent.fhan5-1.fna.fbcdn.net/v/t15.5256-10/328731272_1118180272192386_8362609339078977231_n.jpg?stp=dst-jpg_s280x280&_nc_cat=105&ccb=1-7&_nc_sid=ad6a45&_nc_ohc=oOQXZGgxFxMAX_GmDi7&_nc_ht=scontent.fhan5-1.fna&oh=00_AfD4l0WBW7B03PtAzmN8uRUIShNb4GKldjUWnkXf7O56AQ&oe=63E17858",
        OnlineMode.Offline,
        ActiveMode.None,
        "User Name"
    ),
)