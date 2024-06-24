package com.example.jogodaforca

val allWords =
    setOf(
        "animal",
        "auto",
        "anecdote",
        "alphabet",
        "all",
        "awesome",
        "arise",
        "balloon",
        "basket",
        "bench",
        "best",
        "birthday",
        "book",
        "briefcase",
        "camera",
        "camping",
        "candle",
        "cat",
        "cauliflower",
        "chat",
        "children",
        "class",
        "classic",
        "classroom",
        "coffee",
        "colorful",
        "cookie",
        "creative",
        "cruise",
        "dance",
        "daytime",
        "dinosaur",
        "doorknob",
        "dine",
        "dream",
        "dusk",
        "eating",
        "elephant",
        "emerald",
        "eerie",
        "electric",
        "finish",
        "flowers",
        "follow",
        "fox",
        "frame",
        "free",
        "frequent",
        "funnel",
        "green",
        "guitar",
        "grocery",
        "glass",
        "great",
        "giggle",
        "haircut",
        "half",
        "homemade",
        "happen",
        "honey",
        "hurry",
        "hundred",
        "ice",
        "igloo",
        "invest",
        "invite",
        "icon",
        "introduce",
        "joke",
        "jovial",
        "journal",
        "jump",
        "join",
        "kangaroo",
        "keyboard",
        "kitchen",
        "koala",
        "kind",
        "kaleidoscope",
        "landscape",
        "late",
        "laugh",
        "learning",
        "lemon",
        "letter",
        "lily",
        "magazine",
        "marine",
        "marshmallow",
        "maze",
        "meditate",
        "melody",
        "minute",
        "monument",
        "moon",
        "motorcycle",
        "mountain",
        "music",
        "north",
        "nose",
        "night",
        "name",
        "never",
        "negotiate",
        "number",
        "opposite",
        "octopus",
        "oak",
        "order",
        "open",
        "polar",
        "pack",
        "painting",
        "person",
        "picnic",
        "pillow",
        "pizza",
        "podcast",
        "presentation",
        "puppy",
        "puzzle",
        "recipe",
        "release",
        "restaurant",
        "revolve",
        "rewind",
        "room",
        "run",
        "secret",
        "seed",
        "ship",
        "shirt",
        "should",
        "small",
        "spaceship",
        "stargazing",
        "skill",
        "street",
        "style",
        "sunrise",
        "taxi",
        "tidy",
        "timer",
        "together",
        "tooth",
        "tourist",
        "travel",
        "truck",
        "under",
        "useful",
        "unicorn",
        "unique",
        "uplift",
        "uniform",
        "vase",
        "violin",
        "visitor",
        "vision",
        "volume",
        "view",
        "walrus",
        "wander",
        "world",
        "winter",
        "well",
        "whirlwind",
        "x-ray",
        "xylophone",
        "yoga",
        "yogurt",
        "yoyo",
        "you",
        "year",
        "yummy",
        "zebra",
        "zigzag",
        "zoology",
        "zone",
        "zeal"
    )

val wordHints = listOf(
    "Creature",        // animal
    "Object",        // auto
    "Event",         // anecdote
    "Concept",       // alphabet
    "General",       // all
    "Adjective",     // awesome
    "Verb",          // arise
    "Object",        // balloon
    "Object",        // basket
    "Object",        // bench
    "Adjective",     // best
    "Event",         // birthday
    "Object",        // book
    "Object",        // briefcase
    "Object",        // camera
    "Activity",      // camping
    "Object",        // candle
    "Animal",        // cat
    "Vegetable",     // cauliflower
    "Action",        // chat
    "People",        // children
    "Group",         // class
    "Adjective",     // classic
    "Place",         // classroom
    "Beverage",      // coffee
    "Adjective",     // colorful
    "Food",          // cookie
    "Adjective",     // creative
    "Event",         // cruise
    "Action",        // dance
    "Time",          // daytime
    "Animal",        // dinosaur
    "Object",        // doorknob
    "Action",        // dine
    "Action",        // dream
    "Time",          // dusk
    "Action",        // eating
    "Animal",        // elephant
    "Object",        // emerald
    "Adjective",     // eerie
    "Adjective",     // electric
    "Action",        // finish
    "Object",        // flowers
    "Action",        // follow
    "Animal",        // fox
    "Object",        // frame
    "Adjective",     // free
    "Adjective",     // frequent
    "Object",        // funnel
    "Color",         // green
    "Instrument",    // guitar
    "Place",         // grocery
    "Object",        // glass
    "Adjective",     // great
    "Action",        // giggle
    "Instrument",    // haircut
    "Quantity",      // half
    "Adjective",     // homemade
    "Action",        // happen
    "Food",          // honey
    "Action",        // hurry
    "Number",        // hundred
    "State",         // ice
    "Object",        // igloo
    "Action",        // invest
    "Action",        // invite
    "Object",        // icon
    "Action",        // introduce
    "Action",        // joke
    "Adjective",     // jovial
    "Object",        // journal
    "Action",        // jump
    "Action",        // join
    "Animal",        // kangaroo
    "Object",        // keyboard
    "Place",         // kitchen
    "Animal",        // koala
    "Adjective",     // kind
    "Object",        // kaleidoscope
    "Place",         // landscape
    "Time",          // late
    "Action",        // laugh
    "Action",        // learning
    "Fruit",         // lemon
    "Object",        // letter
    "Object",        // lily
    "Object",        // magazine
    "Adjective",     // marine
    "Food",          // marshmallow
    "Object",        // maze
    "Action",        // meditate
    "Object",        // melody
    "Time",          // minute
    "Object",        // monument
    "Object",        // moon
    "Object",        // motorcycle
    "Place",         // mountain
    "Art",           // music
    "Direction",     // north
    "Body part",     // nose
    "Time",          // night
    "Object",        // name
    "Adverb",        // never
    "Action",        // negotiate
    "Object",        // number
    "Relation",      // opposite
    "Animal",        // octopus
    "Object",        // oak
    "Action",        // order
    "Action",        // open
    "Adjective",     // polar
    "Action",        // pack
    "Object",        // painting
    "Individual",    // person
    "Activity",      // picnic
    "Object",        // pillow
    "Food",          // pizza
    "Media",         // podcast
    "Event",         // presentation
    "Animal",        // puppy
    "Game",          // puzzle
    "Guide",         // recipe
    "Action",        // release
    "Place",         // restaurant
    "Action",        // revolve
    "Action",        // rewind
    "Place",         // room
    "Action",        // run
    "Hidden",        // secret
    "Object",        // seed
    "Transport",     // ship
    "Clothing",      // shirt
    "Action",        // should
    "Size",          // small
    "Transport",     // spaceship
    "Activity",      // stargazing
    "Talent",        // skill
    "Place",         // street
    "Fashion",       // style
    "Time",          // sunrise
    "Transport",     // taxi
    "Adjective",     // tidy
    "Object",        // timer
    "Togetherness",  // together
    "Body part",     // tooth
    "Person",        // tourist
    "Action",        // travel
    "Transport",     // truck
    "Preposition",   // under
    "Adjective",     // useful
    "Mythical",      // unicorn
    "Adjective",     // unique
    "Action",        // uplift
    "Clothing",      // uniform
    "Object",        // vase
    "Instrument",    // violin
    "Person",        // visitor
    "Vision",        // vision
    "Measurement",   // volume
    "Sight",         // view
    "Animal",        // walrus
    "Action",        // wander
    "Planet",        // world
    "Season",        // winter
    "Adjective",     // well
    "Weather",       // whirlwind
    "Medical",       // x-ray
    "Instrument",    // xylophone
    "Exercise",      // yoga
    "Food",          // yogurt
    "Toy",           // yoyo
    "Pronoun",       // you
    "Time",          // year
    "Adjective",     // yummy
    "Animal",        // zebra
    "Pattern",       // zigzag
    "Study",         // zoology
    "Area"           // zone
)

