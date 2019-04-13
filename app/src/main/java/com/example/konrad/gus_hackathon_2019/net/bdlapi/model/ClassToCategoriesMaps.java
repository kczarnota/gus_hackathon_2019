package com.example.konrad.gus_hackathon_2019.net.bdlapi.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ClassToCategoriesMaps {
    static Random generator = new Random();
    static final String[] CLASSES = new String[] {
            "person",
            "bicycle",
            "car",
            "motorbike",
            "aeroplane",
            "bus",
            "train",
            "truck",
            "boat",
            "traffic light",
            "fire hydrant",
            "stop sign",
            "parking meter",
            "bench",
            "bird",
            "cat",
            "dog",
            "horse",
            "sheep",
            "cow",
            "elephant",
            "bear",
            "zebra",
            "giraffe",
            "backpack",
            "umbrella",
            "handbag",
            "tie",
            "suitcase",
            "frisbee",
            "skis",
            "snowboard",
            "sports ball",
            "kite",
            "baseball bat",
            "baseball glove",
            "skateboard",
            "surfboard",
            "tennis racket",
            "bottle",
            "wine glass",
            "cup",
            "fork",
            "knife",
            "spoon",
            "bowl",
            "banana",
            "apple",
            "sandwich",
            "orange",
            "broccoli",
            "carrot",
            "hot dog",
            "pizza",
            "donut",
            "cake",
            "chair",
            "sofa",
            "pottedplant",
            "bed",
            "diningtable",
            "toilet",
            "tvmonitor",
            "laptop",
            "mouse",
            "remote",
            "keyboard",
            "cell phone",
            "microwave",
            "oven",
            "toaster",
            "sink",
            "refrigerator",
            "book",
            "clock",
            "vase",
            "scissors",
            "teddy bear",
            "hair drier",
            "toothbrush"
    };

    static final Map<String, int[]> CLASS_TO_BDL_VARIABLE_MAP = new HashMap<String, int[]>() {
        {
                put("person", new int[]{105836, 105837, 35039});
                put("bicycle", new int[]{288080, 80640, 80614});
                put("car", new int[]{4670, 4671, 7849});
                put("motorbike", new int[]{4668, 32560, 54819});
                put("aeroplane", new int[]{7859, 7860, 7864});
                put("bus", new int[]{32555, 453917, 400358});
                put("train", new int[]{4737});
                put("truck", new int[]{4683, 4684});
                put("boat", new int[]{567296, 567295});
                put("traffic light", new int[]{60523, 54640});
                put("fire hydrant", new int[]{2111, 151909});
                put("bench", new int[]{73847});
                put("bird", new int[]{300399, 64119});
                put("horse", new int[]{65492});
                put("sheep", new int[]{64111});
                put("cow", new int[]{4409, 46535});
                put("backpack", new int[]{51972, 10158, 52044});
                put("handbag", new int[]{58964, 148216});
                put("tie", new int[]{5009, 64428});
                put("suitcase", new int[]{65810, 5010});
                put("skis", new int[]{80534});
                put("snowboard", new int[]{80533});
                put("sports ball", new int[]{80598});
                put("kite", new int[]{80554});
                put("baseball bat", new int[]{80605});
                put("baseball glove", new int[]{80605});
                put("surfboard", new int[]{80549});
                put("tennis racket", new int[]{80651});
                put("bottle", new int[]{5003, 8265});
                put("wine glass", new int[]{5002});
                put("cup", new int[]{4997});
                put("fork", new int[]{64542, 64543});
                put("knife", new int[]{64544, 64545});
                put("spoon", new int[]{64544, 64545});
                put("bowl", new int[]{64542, 64543});
                put("banana", new int[]{63189});
                put("apple", new int[]{283874});
                put("sandwich", new int[]{4949, 8262});
                put("orange", new int[]{63189});
                put("carrot", new int[]{4987});
                put("hot dog", new int[]{386927});
                put("pizza", new int[]{4916});
                put("donut", new int[]{4989});
                put("cake", new int[]{60, 61});
                put("pottedplant", new int[]{4385});
                put("bed", new int[]{40941});
                put("toilet", new int[]{ 5032});
                put("tvmonitor", new int[]{63176});
                put("laptop", new int[]{63180});
                put("mouse", new int[]{63180, 60200});
                put("remote", new int[]{394538});
                put("keyboard", new int[]{283834});
                put("cell phone", new int[]{475605});
                put("microwave", new int[]{63173});
                put("refrigerator", new int[]{63170});
                put("book", new int[]{1235, 1234});
                put("clock", new int[]{8903});
                put("scissors", new int[]{394533});
                put("teddy bear", new int[]{5193});
                put("hair drier", new int[]{5085, 5084});
                put("toothbrush", new int[]{394539});
            }
        };
    public static int bdlVariableFromClass(int classId) {
        int[] variableIds = CLASS_TO_BDL_VARIABLE_MAP.get(CLASSES[classId]);
        if(variableIds != null) {
            int index = generator.nextInt() % variableIds.length;
            return variableIds[index];
        }
        else {
            return 148551; //cinemas
        }
    }
}
