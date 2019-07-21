		  echo 'Updating packages database'
		  brew update
		  echo 'Available versions (gcc)'
		  brew list --versions gcc
		  echo 'Creating gcc@64 formula'
		  cd "$(brew --repository)/Library/Taps/homebrew/homebrew-core"
		  git show 42d31bba7772fb01f9ba442d9ee98b33a6e7a055:Formula/gcc\@6.rb > Formula/gcc\@6.rb
		  echo 'Installing gcc@6 (6.4.0-2)'
		  brew install gcc\@6 || brew link --overwrite gcc\@6

		  echo 'Creating swig@3.0.12 formula';
		  cd "$(brew --repository)/Library/Taps/homebrew/homebrew-core";
		  git show 42d31bba7772fb01f9ba442d9ee98b33a6e7a055:Formula/swig.rb | grep -v 'fails_with' > Formula/swig.rb;
  echo 'Installing swig@3.0.12 (3.0.12)';
  brew install swig || brew link --overwrite swig;
  echo 'Installing gimme'
  brew install gimme;
