from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
import time
import os
from selenium.webdriver.support.ui import Select

# Set up Chrome options
chrome_options = Options()
chrome_options.add_argument("--start-maximized")
current_directory = os.getcwd()
chrome_driver_path = os.path.join(current_directory, 'chromedriver')

driver = webdriver.Chrome(executable_path=chrome_driver_path, options=chrome_options)
driver.get("http://localhost:3000")

#Login
(driver.find_element("xpath",'/html/body/div/div/nav/div[2]/a[6]').click())
#Enter Password
login = (driver.find_element("xpath",'/html/body/div[1]/div/div/div/form/div[1]/input'))
login.send_keys('test2@gmail.com')
#Enter Password
passWord = (driver.find_element("xpath",'/html/body/div[1]/div/div/div/form/div[2]/input'))
passWord.send_keys('computer')
#Login Button
(driver.find_element("xpath",'/html/body/div[1]/div/div/div/form/button').click())
time.sleep(2)

#CreateWorkout Button
(driver.find_element("xpath",'/html/body/div/div/div[3]/a/button').click())
#MyWorkout Button
(driver.find_element("xpath",'/html/body/div/div/header/div/a[1]/button').click())
#CreateWorkout2 Button
(driver.find_element("xpath",'/html/body/div[1]/div/div/div/div[1]/button[2]').click())
time.sleep(1)

#Enter Session Name
sName = (driver.find_element("xpath",'/html/body/div[3]/div/div/form/input'))
sName.send_keys('Workoutplan Test 1')
time.sleep(1)
#Add Exercise Button
(driver.find_element("xpath",'/html/body/div[3]/div/div/form/button').click())
#Select Exercise Dropdown
(driver.find_element("xpath",'/html/body/div[3]/div/div/form/div[1]/select').click())
#Enter Exercise
sExercise = (driver.find_element("xpath",'/html/body/div[3]/div/div/form/div[1]/select'))
select = Select(sExercise)
select.select_by_visible_text("Cable Cross")

#Enter sets
sets = (driver.find_element("xpath",'/html/body/div[3]/div/div/form/div[1]/input[1]'))
sets.send_keys('3')
#Enter reps
reps = (driver.find_element("xpath",'/html/body/div[3]/div/div/form/div[1]/input[2]'))
reps.send_keys('3')
time.sleep(1)
#Submit WorkoutPlan Button
(driver.find_element("xpath",'/html/body/div[3]/div/div/form/div[2]/button[1]').click())
time.sleep(1)




