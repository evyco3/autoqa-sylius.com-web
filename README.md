# Sylius.com Test Automation Framework

## Overview

This project is a Java-based test automation framework designed for testing specific scenarios on the Sylius.com website. It utilizes Selenium WebDriver for browser automation.

## Features

- Automated tests for various scenarios on the Sylius.com website.
- Developed using the Java programming language.
- Utilizes Selenium WebDriver for browser automation.

## Configuration

The project uses a configuration file located at `src/main/resources/config/config.properties` to manage settings such as implicit time, page load time, URL, browser type, etc.

## Data Providers

The project includes Excel data providers to supply test data for various scenarios. Data files are located in the `src/main/resources` directory.

## Drivers

The framework supports different browser types (Chrome, Firefox, Edge) through driver managers located in the `co.il.evy.framework.drivers.manager` package.

## Pages

Page objects representing different pages of the Sylius.com website are located in the `co.il.evy.framework.pages.frontend` package.

## Factory Class

The factory class responsible for creating page objects is located in the `co.il.evy.framework.pages.factory` package.

## Utilities

The `co.il.evy.framework.utils` package contains utility classes for logging, assertions, attachment handling, and execution handling.


## Test Cases

Feel free to **create your own tests or use the tests that are implemented in the project**.
