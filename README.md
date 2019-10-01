# AAD-TEAPOT-ANDROI

Teapot is your personal hub for tracking your favorite teas! Teapot provides you with a means of organizing teas you love and teas you want to try by allowing you to save and remove teas of your choice. You can look at your most recently added tea, you also have a number of options for sorting your teas and can even filter them based on your favorites. Teapot has a timer feature for steeping your tea to help you achieve optimal flavor. It also sends you notifications to remind you that it is tea time. Bottoms up!    
 

Title bar:
Resources: @string/recently_added
Tea Card:
Image
Tea name
Tea description
Tea ingredients
More Info button:
Color: #6200ee
String: @android:color/darker_gray
Favorite image button:
Resources: @drawable/ic_favorite_boarder_dark, @drawable/ic_favorite_dark
Menu actions:
Navigate to AddTeaActivity
Navigate to TimerActivity
Navigate to TeaListActivity
Navigate to SettingsActivity
 
 

  Floating action button (FAB):
Adds a new tea.
Color: R.color.colorAccent
Icon: R.drawable.ic_add
Menu actions:
Filters tea by favorite.
Navigates to Settings screen.
List item:
The name of the tea
Text Size: 16sp
Text Color: color/primary_text_light
The country of origin
Text Size: 14sp
Text Color: color/secondary_text_dark
The steep time
 
 

  Save button:
Icon: R.drawble.ic_save
Background color: R.color.colorAccent
Up navigation button navigates to the Main screen.  Tea Type input:
Spinner
Allows user to choose between green tea, black tea, and herbal tea.
Tea Name input:
Required for saving.
Allows user to add tea name.
Description input:
Optional for saving.
Allows user to add description.
Tea Origin input:
Optional for saving.
Allows user to add place of origin.
Ingredients input:
Optional for saving.
Allows user to add ingredients.
Steep Time input:
Optional for saving.
Integer
Allows user to add steep time.
Caffeine Level input:
Optional for saving.
String
Allows user to add caffeine level.
 
 

  Detail screen
Collapsing toolbar with photo and tea name
Tea description
Divider color : @android:color/darker_gray
Country of origin icon: R.drawable.ic_location
Steep time:
String: R.string.steep_time_minutes 
Icon: R.drawable.ic_timer
Ingredients:
Icon R.drawable.ic_outline_list
Tea type
Caffeine level
 
 
  Timer
Custom SteepProgress view displays the countdown timer.
Reset and Start buttons.
Up navigation button navigates to the Detail screen.  

   
Toggle setting that enables or disables tea-time notification. A change in the setting immediately reschedules or cancels the notification.
Setting to change the sort order of answers that the Main screen shows.
 Up navigation button navigates to the Main screen.  

 
  Sort order list preference  
Entries: @array/sort_oder Entry Values: @array/sort_oder_value
Default option (sort by name)
Tea Type
Caffeine Level
 
 
  
Small icon: R.drawable.ic_cup
Content Title: R.string.notification_title
Content text: R.string.notification_message
 When the user taps a notification, TeaDetailActivity is launched.  

1. Define a local database model and data access object (DAO) using the schema app/schemas/tea.json for the data structure.
Use the SortUtils helper class.
Use the getSortedTeas method from the DataRepository to create a sortable rawquery for the teas in the list.
Populate initial content into the database from res/raw/sample_teas.json
2. Display a card showing the tea most recently added to the list in the MainActivity. The card should update when a new tea is added.  3. Create a list-item layout for the RecyclerView using ConstraintLayout.  4. Bind LiveData to the RecyclerView list item using the paging library.  5. Create a notification in WorkManager that shows a notification to users once a day with a random tea and on click opens TeaDetailActivity.
Use RANDOM() when constructing your query to return random data.
6. Address the following comment form our QA team:
"When I view TeaDetailActivity and click on the favorite icon in the menu nothing happens."
7. Implement a custom SteepProgress view in TimerActivity and display a time of 4:00 minutes when launched from MainActivity.  8. Write a UI test to validate that clicking on the Filter by Favorites icon in the toolbar updates the RecyclerView.
