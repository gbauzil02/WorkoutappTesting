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
time.sleep(3)

#Switch To Clients Page
(driver.find_element("xpath",'/html/body/div[1]/div/nav/div[2]/a[5]').click())
time.sleep(1)

#Accept Client
(driver.find_element("xpath",'/html/body/div[1]/div/div[2]/div/div[2]/button[1]').click())
time.sleep(2)

