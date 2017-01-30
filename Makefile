all:
	javac -cp json-20160810.jar NearbySearchExample.java

run:
	java -cp .:json-20160810.jar NearbySearchExample

clean:
	rm -fr *.class
