# glasswrapper
An Android Studio project which builds a plug-in that modifies the UnityPlayerNativeActivity and creates a launcher and tutorial activity for making a Glassware game

You should be able to just import the repo directly into Android studio, either by File -> Import Project, or File -> Import from Version Control.

You shouldn't need to modify much, but you will definitely have to refactor the package name to match your own app's package name as specified in the Unity Player settings.  You probably also want to modify the tutorial phrases in app/res/strings.xml to provide instructions to your game.

Of course I'd like to avoid all of these things, and let you just drop the same .aar file into any Unity project and specify these changes externally. That would be my first priority on the roadmap for this project.
