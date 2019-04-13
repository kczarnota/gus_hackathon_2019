package com.example.konrad.gus_hackathon_2019.net.bdlapi.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ClassToCategoriesMaps {
    static Random generator = new Random();
    public static final String[] CLASSES = new String[] {
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

    static final Map<String, String[]> CLASS_TO_EUROSTAT_CODE_MAP = new HashMap<String, String[]>() {
        {
            put("person", new String[]{"proj_15nalexp?precision=1&sex=M&age=Y15", "proj_15nalexp?precision=1&sex=F&age=Y15"});
            put("bicycle", new int[]{"hlth_ehis_pe9i?precision=1&sex=T&physact=MV_AERO&quantile=TOTAL&age=Y15-24"});
            put("car", new String[]{"road_eqs_carage?precision=1&age=Y10-20", "road_eqs_carmot?precision=1&mot_nrg=DIE", "road_eqs_carmot?precision=1&mot_nrg=PET"});
            put("motorbike", new String[]{"tran_r_vehst?precision=1&vehicle=MOTO"});
            put("aeroplane", new String[]{"tran_r_avpa_om?tra_meas=PAS_CRD&precision=1", "avia_eq_arc_typ?precision=1&airc_cat=PAS"});
            put("bus", new String[]{"tran_r_vehst?precision=1&vehicle=BUS_TOT"});
            put("train", new String[]{"ttr00003?precision=1"});
            put("truck", new String[]{"tran_r_vehst?precision=1&vehicle=TRL_STRL"});
            put("boat", new String[]{"ttr00009?precision=1&direct=TOTAL"});
            put("traffic light", new String[]{"road_tf_veh?precision=1&regisveh=D005&vehicle=CAR"});
            put("bench", new String[]{"for_area_efa"});
            put("bird", new String[]{"tag00043?precision=1"});
            put("horse", new String[]{"ilc_scp03?precision=1&acl00=AC525&age=Y16-24"});
            put("sheep", new String[]{"tag00017?precision=1"});
            put("cow", new String[]{"apro_mt_lscatl?precision=1&animals=A2300", "apro_mk_pobta?milkitem=PRO&precision=1&dairyprod=D1100DU"});
            put("backpack", new String[]{"tin00185?precision=1&duration=N1-3&partner=WORLD"});
            put("sports ball", new String[]{"ilc_scp03?precision=1&sex=T&acl00=AC525&isced11=TOTAL&frequenc=GE1&age=Y16-24"});
            put("baseball bat", new String[]{"ilc_scp03?precision=1&sex=T&acl00=AC525&isced11=TOTAL&frequenc=GE1&age=Y16-24"});
            put("surfboard", new String[]{"hlth_ehis_pe9e?precision=1&sex=T&physact=MV_MSC&isced11=TOTAL&age=Y15-19"});
            put("tennis racket", new String[]{"hlth_ehis_pe9e?precision=1&sex=T&physact=MV_MSC&isced11=TOTAL&age=Y15-19"});
            put("bottle", new String[]{"apro_mk_cola?precision=1&dairyprod=D2100"});
            put("wine glass", new String[]{"tag00121?precision=1&crops=W1100"});
            put("cup", new String[]{"apro_mk_pobta?milkitem=PRO&precision=1&dairyprod=D5400"});
        }
    };
    public static int bdlVariableFromClass(int classId) {
        int[] variableIds = CLASS_TO_BDL_VARIABLE_MAP.get(CLASSES[classId]);
        if(variableIds != null) {
            int index = generator.nextInt() % variableIds.length;
            return variableIds[index];
        }
        else {
            return 0;
        }
    }

    public static String eurostatUrlFromClass(int classId) {
        String[] urls = CLASS_TO_EUROSTAT_CODE_MAP.get(CLASSES[classId]);
        if(urls != null) {
            int index = generator.nextInt() % urls.length;
            return urls[index];
        }
        else {
            return null;
        }
    }
}
