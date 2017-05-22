<%
String test1 = "Test1";
String test2 = "Test2";
String test3 = "Test3";
java.util.List<String> test =
new java.util.ArrayList<String>();
test.add(test1);
test.add(test2);
test.add(test3);
session.setAttribute("test", test);
%>
${test.size()}