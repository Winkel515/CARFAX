# CARFAX

Data Structure and Algorithm course assignment

<h2>Useful git commands</h2>

<b>To push your code to github:</b>
<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;git add .
  <br />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;git commit -am "Your Message"
  <br />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;git push
  <br />
  
<b>To get new code from github:</b>
<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;git pull
  <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>Important: You should git pull every time you open your IDE in case that any changes have been made else you'll be working with old code</i>

<b>To create a new branch:</b>
<br />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;git checkout -b branchname
  <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>Tip: Don't forget to push your branch so I can see it on github</i>
 
<b>To move between branches:</b>
<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;git checkout branchname
  
<b>To delete a branch:</b>
  <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;delete locally: git branch -d branchname
  <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;delete from github: git push origin --delete branchname 
  <br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>Tip: You can also delete the branch on github using the website</i>

<h2>Rules:</h2>

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1- Add javadoc comments whenever you add a method. Describe in sufficient detail the parameters and the return value.
     Comment the inner working of the method step by step. This will make it easier to find bugs in the implementation of the method
  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2- Do not create everything in a single class. If a class is too bloated, try to seperate it into smaller classes.
     Don't forget to document the newly added class.
  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3- In case of merge conflicts, contact me to resolve it together. DO NOT RESOLVE THE CONFLICT YOURSELF (unless it is trivial).
  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4- It would be preferable if you branched off the master branch for adding new features. This will reduce the headache of when encoutering a bug.
  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5- If you add debugging code inside a method, mark it with a //TODO comment so that we can remove it easily later.
     IDE's have a feature to find //TODO comments.
 
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6- If there is a missing part in the implementation of a method, add a //TODO comment with a description of what needs to be done.
