package MountEverestPathFindingTests;

import MountEverestPathFinding.Everest;
import MountEverestPathFinding.WayPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MountEverestPathFindingTests {
    private Everest everest;

    @BeforeEach
    void init() {
        everest = new Everest();
    }

    @Test
    void testEverestMap() {
        int[][] matrix = new int[14][14];

        matrix[0][0] = 19234;
        matrix[0][1] = 20191;
        matrix[0][2] = 21433;
        matrix[0][3] = 22111;
        matrix[0][4] = 20192;
        matrix[0][5] = 19202;
        matrix[0][6] = 23844;
        matrix[0][7] = 23924;
        matrix[0][8] = 23454;
        matrix[0][9] = 23975;
        matrix[0][10] = 22844;
        matrix[0][11] = 22893;
        matrix[0][12] = 22783;
        matrix[0][13] = 21383;

        matrix[1][0] = 19483;
        matrix[1][1] = 20532;
        matrix[1][2] = 21075;
        matrix[1][3] = 22844;
        matrix[1][4] = 22938;
        matrix[1][5] = 20192;
        matrix[1][6] = 24297;
        matrix[1][7] = 24753;
        matrix[1][8] = 23854;
        matrix[1][9] = 24850;
        matrix[1][10] = 24039;
        matrix[1][11] = 23953;
        matrix[1][12] = 20193;
        matrix[1][13] = 21927;

        matrix[2][0] = 18976;
        matrix[2][1] = 20983;
        matrix[2][2] = 22000;
        matrix[2][3] = 22013;
        matrix[2][4] = 22145;
        matrix[2][5] = 20192;
        matrix[2][6] = 25119;
        matrix[2][7] = 25822;
        matrix[2][8] = 24945;
        matrix[2][9] = 24858;
        matrix[2][10] = 23949;
        matrix[2][11] = 21934;
        matrix[2][12] = 19843;
        matrix[2][13] = 21834;

        matrix[3][0] = 19283;
        matrix[3][1] = 19749;
        matrix[3][2] = 20192;
        matrix[3][3] = 21942;
        matrix[3][4] = 23493;
        matrix[3][5] = 22893;
        matrix[3][6] = 24854;
        matrix[3][7] = 24949;
        matrix[3][8] = 23912;
        matrix[3][9] = 22182;
        matrix[3][10] = 22067;
        matrix[3][11] = 21342;
        matrix[3][12] = 19303;
        matrix[3][13] = 20743;

        matrix[4][0] = 18563;
        matrix[4][1] = 17838;
        matrix[4][2] = 19384;
        matrix[4][3] = 20948;
        matrix[4][4] = 22345;
        matrix[4][5] = 24001;
        matrix[4][6] = 26033;
        matrix[4][7] = 26013;
        matrix[4][8] = 25834;
        matrix[4][9] = 23822;
        matrix[4][10] = 22384;
        matrix[4][11] = 20938;
        matrix[4][12] = 20955;
        matrix[4][13] = 20483;

        matrix[5][0] = 18355;
        matrix[5][1] = 18972;
        matrix[5][2] = 21094;
        matrix[5][3] = 22384;
        matrix[5][4] = 23811;
        matrix[5][5] = 24910;
        matrix[5][6] = 26999;
        matrix[5][7] = 27943;
        matrix[5][8] = 26843;
        matrix[5][9] = 22873;
        matrix[5][10] = 23933;
        matrix[5][11] = 21484;
        matrix[5][12] = 21831;
        matrix[5][13] = 20943;

        matrix[6][0] = 17202;
        matrix[6][1] = 18394;
        matrix[6][2] = 19842;
        matrix[6][3] = 21944;
        matrix[6][4] = 23954;
        matrix[6][5] = 26920;
        matrix[6][6] = 27001;
        matrix[6][7] = 26984;
        matrix[6][8] = 26789;
        matrix[6][9] = 23483;
        matrix[6][10] = 22019;
        matrix[6][11] = 21000;
        matrix[6][12] = 21392;
        matrix[6][13] = 21019;

        matrix[7][0] = 17000;
        matrix[7][1] = 19183;
        matrix[7][2] = 18234;
        matrix[7][3] = 21478;
        matrix[7][4] = 23754;
        matrix[7][5] = 27911;
        matrix[7][6] = 27998;
        matrix[7][7] = 27191;
        matrix[7][8] = 27392;
        matrix[7][9] = 25904;
        matrix[7][10] = 24584;
        matrix[7][11] = 22984;
        matrix[7][12] = 22209;
        matrix[7][13] = 21084;

        matrix[8][0] = 17101;
        matrix[8][1] = 18374;
        matrix[8][2] = 1800;
        matrix[8][3] = 21845;
        matrix[8][4] = 24955;
        matrix[8][5] = 28764;
        matrix[8][6] = 28870;
        matrix[8][7] = 27984;
        matrix[8][8] = 27443;
        matrix[8][9] = 26439;
        matrix[8][10] = 25922;
        matrix[8][11] = 23949;
        matrix[8][12] = 20192;
        matrix[8][13] = 21843;

        matrix[9][0] = 17202;
        matrix[9][1] = 18233;
        matrix[9][2] = 21344;
        matrix[9][3] = 20494;
        matrix[9][4] = 24593;
        matrix[9][5] = 28191;
        matrix[9][6] = 29000;
        matrix[9][7] = 28937;
        matrix[9][8] = 28475;
        matrix[9][9] = 26593;
        matrix[9][10] = 25928;
        matrix[9][11] = 24292;
        matrix[9][12] = 22339;
        matrix[9][13] = 21939;

        //
        matrix[10][0] = 17462;
        matrix[10][1] = 19284;
        matrix[10][2] = 22493;
        matrix[10][3] = 23544;
        matrix[10][4] = 24855;
        matrix[10][5] = 27594;
        matrix[10][6] = 28294;
        matrix[10][7] = 28912;
        matrix[10][8] = 28749;
        matrix[10][9] = 27311;
        matrix[10][10] = 26393;
        matrix[10][11] = 24893;
        matrix[10][12] = 20192;
        matrix[10][13] = 20192;

        matrix[11][0] = 17023;
        matrix[11][1] = 19383;
        matrix[11][2] = 20129;
        matrix[11][3] = 22918;
        matrix[11][4] = 23583;
        matrix[11][5] = 24593;
        matrix[11][6] = 27374;
        matrix[11][7] = 28422;
        matrix[11][8] = 27933;
        matrix[11][9] = 27483;
        matrix[11][10] = 25987;
        matrix[11][11] = 24192;
        matrix[11][12] = 22303;
        matrix[11][13] = 21829;

        matrix[12][0] = 18020;
        matrix[12][1] = 18275;
        matrix[12][2] = 19383;
        matrix[12][3] = 24033;
        matrix[12][4] = 24369;
        matrix[12][5] = 24563;
        matrix[12][6] = 28030;
        matrix[12][7] = 28010;
        matrix[12][8] = 27484;
        matrix[12][9] = 28043;
        matrix[12][10] = 28000;
        matrix[12][11] = 26002;
        matrix[12][12] = 26043;
        matrix[12][13] = 23929;

        matrix[12][0] = 18102;
        matrix[12][1] = 19442;
        matrix[12][2] = 22455;
        matrix[12][3] = 23233;
        matrix[12][4] = 25822;
        matrix[12][5] = 26003;
        matrix[12][6] = 25293;
        matrix[12][7] = 27810;
        matrix[12][8] = 27433;
        matrix[12][9] = 26918;
        matrix[12][10] = 27192;
        matrix[12][11] = 27901;
        matrix[12][12] = 25901;
        matrix[12][13] = 24922;

        WayPoint[][] map = everest.convertMatrixToMap(matrix);
        everest.findPathFromRandomPointToFinish(map, map[9][6]);
    }
}
