package com.hospitaliq;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshuawilkosz on 20/4/17.
 */
public class ParseComments {

    public static final String END_MULTI_DELIMINATOR = "\\*";
    public static final String START_MULTI_DELIMINATOR = "/*";
    public static final String SINGLE_DELLIMINATOR = "//";

    public static final String[] parsedFile =
            {
                    "hello_world() /* timothy",
                    "still a cooment *\\ true() /* testing \\* code /* test ",
                    " asdfaf *\\ x = z234 // hello",
                    "hello_world()",
                    "x = y = c // capture this /* and this *\\"
            };

    public static void main(String[] args)
    {
        List<String> comments = new ArrayList<>();

        int j;
        Comments comment = new Comments();

        for(int i=0; i<parsedFile.length; i++)
        {
            j=0; // start of word
            char[] characters = parsedFile[i].toCharArray();

            while(j< characters.length)
            {
                comment.parse(characters[j++]);
            }

            comment.newLine();
        }
    }

    public static class Comments
    {
        public char[] buffer = new char[4];
        public int size = 0;

        public List<String> comments;
        public StringBuilder stringBuffer;

        public Comments(){
            comments = new ArrayList<>();
            stringBuffer = new StringBuilder();
        }

        public void parse(char c)
        {
            if(c == '/')
            {
                if(isComment())
                {
                    addCharToStringBuffer(c);
                }
                else
                {
                    addCharToBuffer(c);
                }
            }
            else if (c == '*')

            if(isComment())
            {

            }
        }

        public void addCharToBuffer(char c)
        {
            buffer[size] = c;
            size++;
        }

        public void addCharToStringBuffer(char c)
        {
            stringBuffer.append(c);
        }

        public void newLine()
        {
            if(isSingle())
            {
                wipeBuffer();
                comments.add(stringBuffer.toString());
                stringBuffer.setLength(0);
            }
        }

        public boolean isComment()
        {
            return size == 2;
        }

        public boolean isSingle()
        {
            return size > 2 && buffer[0] == '/' && buffer[1] == '/';
        }

        public boolean isMulti()
        {
            return size > 2 && buffer[0] == '/' && buffer[1] == '*';
        }

        public void wipeBuffer()
        {
            for(int i=0; i<buffer.length; i++)
            {
                buffer[i] = (char)-1;
            }
            size = 0;
        }
    }
}
