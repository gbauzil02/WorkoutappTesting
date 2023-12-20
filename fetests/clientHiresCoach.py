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
login.send_keys('tClient@gmail.com')
#Enter Password
passWord = (driver.find_element("xpath",'/html/body/div[1]/div/div/div/form/div[2]/input'))
passWord.send_keys('computer')
#Login Button
(driver.find_element("xpath",'/html/body/div[1]/div/div/div/form/button').click())
time.sleep(2)


#Hire New Coach Page
(driver.find_element("xpath",'/html/body/div/div/div[4]/a[3]/button').click())
time.sleep(1)
driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
#View Coach Profile
(driver.find_element("xpath",'/html/body/div/div/div[2]/div[2]/div[3]/a').click())
time.sleep(1)
driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")

#Request New Coach Button
(driver.find_element("xpath",'/html/body/div/div/div/div[2]/div[5]/button[2]').click())
time.sleep(1)

#Confirm New Coach Button
(driver.find_element("xpath",'/html/body/div/div/div/div[2]/div[6]/div/button[1]').click())
time.sleep(1)