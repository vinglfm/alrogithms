package com.algorithms.parser;

import com.algorithms.function.ConstructFunction;
import com.algorithms.constructor.DefaultTreeConstructor;
import com.algorithms.constructor.TreeConstructor;
import com.algorithms.model.Tree;
import com.algorithms.validator.TreeDataValidator;
import com.algorithms.validator.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileParser {

    private static final int CURRENT_NODE_POSITION = 0;
    private static final int LEFT_NODE_POSITION = 1;
    private static final int RIGHT_NODE_POSITION = 2;

    private static final String DELIMITER = ",";
    private static final String EMPTY_NODE = "#";

    private static final String ALLOWED_REGEX = "[a-zA-Z#,]+";
    private static final Validator<String> dataFormatValidator = new TreeDataValidator(ALLOWED_REGEX);

    public static Tree buildTree(InputStreamReader reader) {

        if(reader == null) {
            throw new IllegalArgumentException("reader shouldn't be null.");
        }

        TreeConstructor treeConstructor = new DefaultTreeConstructor();

        parserFile(reader,
                (current, left, right) -> {treeConstructor.addNode(current, left, right);});

        return treeConstructor.getRoot();
    }

    private static void parserFile(InputStreamReader reader, ConstructFunction<String, String,String> constructTreeFunction) {
        try (BufferedReader bis = new BufferedReader(reader)) {

            String line;
            while ((line = bis.readLine()) != null) {
                validate(line);

                String[] nodes = line.split(DELIMITER);
                validateNodes(nodes);

                constructTreeFunction.apply(nodes[CURRENT_NODE_POSITION],
                        replaceEmptyNode(nodes[LEFT_NODE_POSITION]), replaceEmptyNode(nodes[RIGHT_NODE_POSITION]));

            }

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static void validateNodes(String[] nodes) {
        if(nodes.length != 3) {
            throw new InvalidTreeFormatException("Line has to contain only 3 nodes.");
        }

        if (isEmptyNode(nodes[CURRENT_NODE_POSITION])) {
            throw new InvalidTreeFormatException("Current node couldn't be empty.");
        }
    }

    private static String replaceEmptyNode(String data) {
        return isEmptyNode(data) ? null : data;
    }

    private static boolean isEmptyNode(String data) {
        return EMPTY_NODE.equals(data);
    }

    private static void validate(String line) {
        dataFormatValidator.validate(line);
    }
}
