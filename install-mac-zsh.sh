# add a bash function to the Oh My ZSH shell file to run the blorp interpreter from the command line
echo "
function blorp {
  java -jar ~/IdeaProjects/blorp/target/blorp.jar $1
}
" >> ~/.zshrc
