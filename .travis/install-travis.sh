
# Install gcc6 (6.4.0-2 on Mac OS) for Travis builds

if [[ "$TRAVIS_OS_NAME" == "linux" ]]; then
  sudo apt-get install -qq g++-6 && sudo update-alternatives --install /usr/bin/g++ g++ /usr/bin/g++-6 90;
  curl -sL -o ~/bin/gimme https://raw.githubusercontent.com/travis-ci/gimme/master/gimme
  chmod +x ~/bin/gimme

  mkdir swig_build && \
  cd swig_build && \
  wget http://prdownloads.sourceforge.net/swig/swig-3.0.12.tar.gz && \
  tar -zxf swig-3.0.12.tar.gz && \
  cd swig-3.0.12 && \
  sudo ./configure --prefix=/usr && \
  sudo make && \
  sudo make install && \
  cd ../../ && \
  sudo rm -rf swig_build
fi

if [[ "$TRAVIS_OS_NAME" == "osx" ]]; then
  echo 'Updating packages database'
  brew update
  echo 'Available versions (gcc)'
  brew list --versions gcc
  echo 'Creating gcc@64 formula'
  cd "$(brew --repository)/Library/Taps/homebrew/homebrew-core"
  git show 42d31bba7772fb01f9ba442d9ee98b33a6e7a055:Formula/gcc\@6.rb > Formula/gcc\@6.rb
  echo 'Installing gcc@6 (6.4.0-2)'
  brew install gcc\@6 || brew link --overwrite gcc\@6
  echo 'Installing gimme'
  brew install swig;
  brew install gimme;
  
fi

cd $TRAVIS_BUILD_DIR

