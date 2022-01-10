# Konstruct

Konstruct is a java library designed to evaluate strings by using defined variables and functions. This project allows for easy and powerful customization for string values a user may configure or output.

# Examples

Using the default settings within the `:addons` subproject things such as `[round(calc(5 / 3 * 4), 2)]` -> `6.667`, `[get(3,one,two,three,four)]` -> `four` are all possible, and only a taste of what Konstruct can do. New functions and variables can be defined very easily and referenced quickly. 

Other examples:

```
Input: Cool calculator! [calc((5 / 3)^3 / 4 + 3)]
Output: Cool calculator! 3.0462962962962963

Input: Integral thing: [calc({integral})]
Output: Integral thing: 3.1415920928388927

Input: Round: [round([calc(7 / 3 * 2)],1)]
Output: Round: 4.7

Input: I really like the [get(2, first, second, third)] option!
Ooutput: I really like the second option!
```

Functions can be nested infinitely and reference variables.

# Use

In `build.gradle` declare the following repository:

```
url 'https://jitpack.io'
```

Then for dependencies add:

```
implementation 'com.github.DarkKronicle.Konstruct:core:<version>'

// Add this if you want access to the prebuilt functions
implementation 'com.github.DarkKronicle.Konstruct:addons:<version>'
```

# Credits

For addons the following libraries are used for more functionality:

- [MathXParser](http://mathparser.org)

Code & Mastermind: DarkKronicle