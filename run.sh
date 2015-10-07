#!/bin/bash
#java -cp bin uml.UmlGenerator java.util.{ArrayList,HashMap,HashSet,LinkedList,Queue,Stack,Deque} > ~/test/uml.dot && dot ~/test/uml.dot -Tsvg -o ~/test/uml.svg && open ~/test/uml.svg

#java -cp bin uml.UmlGenerator java.util.{ArrayList,LinkedList,Queue,Stack,Deque} > ~/test/uml.dot && dot ~/test/uml.dot -Tsvg -o ~/test/uml.svg && open ~/test/uml.svg

java -cp bin uml.UmlGenerator "$@" > ~/test/uml.dot && dot ~/test/uml.dot -Tsvg -o ~/test/uml.svg && open ~/test/uml.svg
