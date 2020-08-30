import os
import time

while True:
	os.system("git pull && git merge")
	os.system("git add .")
	os.system("git commit  -m \"commit\"")
	os.system("git push origin -u master")
	time.sleep(60*60*12)
