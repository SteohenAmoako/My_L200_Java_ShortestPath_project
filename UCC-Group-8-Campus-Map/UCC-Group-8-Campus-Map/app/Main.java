package app;

public class Main {
    public static Map graph = new Map();

    public static void main(String[] args) {

        Locations mainGate = new Locations("Main Gate");
        Locations KNH = new Locations("Kwame Nkrumah Hall");
        Locations VH = new Locations("Valco Hall");
        Locations NAB = new Locations(" New Administration");
        Locations SJL = new Locations("Sam Jonah Library");
        Locations ST = new Locations("Shuttle Terminal");
        Locations CR = new Locations("Casford Round About");
        Locations SDS = new Locations("School Of Development Studies");
        Locations CALC = new Locations("Calc");
        Locations NEC = new Locations("New Examination Center");
        Locations CDE = new Locations("College of Distance Education");
        Locations NLT = new Locations("New Lecture Theatre");
        Locations AAT = new Locations("Amissah Arthur Theatre");
        Locations SWL = new Locations("Sandwitch Lecture Theatre");
        Locations ScM = new Locations("Science Market");
        Locations SB = new Locations("Science Block");
        Locations S_Hall = new Locations("Superannuation Hall");
        Locations SRC = new Locations("SRC Hall");
        Locations Old_Site = new Locations("OLD SITE");

        graph.addVertex(mainGate);
        graph.addVertex(CR);
        graph.addVertex(VH);
        graph.addVertex(NAB);
        graph.addVertex(SJL);
        graph.addVertex(ST);
        graph.addVertex(SDS);
        graph.addVertex(CALC);
        graph.addVertex(NEC);
        graph.addVertex(CDE);
        graph.addVertex(NLT);
        graph.addVertex(AAT);
        graph.addVertex(SWL);
        graph.addVertex(ScM);
        graph.addVertex(SB);
        graph.addVertex(S_Hall);
        graph.addVertex(SRC);
        graph.addVertex(Old_Site);



        graph.addEdge(new Extent(mainGate, KNH, 500));
        graph.addEdge(new Extent(mainGate, VH, 450));
        graph.addEdge(new Extent(mainGate, CR, 900));
        graph.addEdge(new Extent(mainGate, NAB, 1300,960));

        graph.addEdge(new Extent(KNH, SDS, 1500));
        graph.addEdge(new Extent(KNH, NEC, 1800));
        graph.addEdge(new Extent(KNH, NAB, 1200));

        graph.addEdge(new Extent(VH, ScM, 1600));
        graph.addEdge(new Extent(VH, SDS, 1500));
        graph.addEdge(new Extent(VH, CDE, 2100));

        graph.addEdge(new Extent(CR, Old_Site, 1800));
        graph.addEdge(new Extent(CR, SJL, 650));

        graph.addEdge(new Extent(NAB, SDS, 550));
        graph.addEdge(new Extent(NAB, ST, 220));

        graph.addEdge(new Extent(SJL, NLT, 1100));
        graph.addEdge(new Extent(SJL, SB, 350));

        graph.addEdge(new Extent(ST, ScM, 300));
        graph.addEdge(new Extent(ST, AAT, 700,20));

        graph.addEdge(new Extent(SDS, NLT, 1000,720));
        graph.addEdge(new Extent(SDS, CDE, 900,660));

        graph.addEdge(new Extent(CALC, NEC, 280,180));
        graph.addEdge(new Extent(CALC, AAT, 500,360));

        graph.addEdge(new Extent(NEC, SB, 650, 540));

        graph.addEdge(new Extent(CDE, SRC, 2100,1560));
        graph.addEdge(new Extent(CDE, Old_Site, 3000,2280));

        graph.addEdge(new Extent(NLT, S_Hall, 1800,1380));
        graph.addEdge(new Extent(NLT, SRC, 2000,1560));

        graph.addEdge(new Extent(AAT, SWL, 750,660 ));

        graph.addEdge(new Extent(SWL, S_Hall, 2500,1980));

        graph.addEdge(new Extent(ScM, SRC, 2600,1920));
        graph.addEdge(new Extent(SB, S_Hall, 2200,1620));
        graph.addEdge(new Extent(SRC, S_Hall, 120,100));

        graph.addEdge(new Extent(mainGate, ScM, 1700,1260));
        graph.addEdge(new Extent(mainGate, SDS, 2000));

        graph.addEdge(new Extent(KNH, Old_Site, 2700,2040));
        graph.addEdge(new Extent(KNH, S_Hall, 3400,2520));

        graph.addEdge(new Extent(VH, ST, 1400,1020));

        graph.addEdge(new Extent(CR, VH, 850,600));

        graph.addEdge(new Extent(NAB, ScM, 400,300));

        graph.addEdge(new Extent(SJL, S_Hall, 2100,1620));

        graph.addEdge(new Extent(ST, NEC, 700,480));

        graph.addEdge(new Extent(SDS, SJL, 450,360));

        graph.addEdge(new Extent(CALC, Old_Site, 2500,1860));

        graph.addEdge(new Extent(NEC, SDS, 650,480));

        graph.addEdge(new Extent(CDE, SDS, 900,660));

        graph.addEdge(new Extent(NLT, KNH, 2200,1620));

        graph.addEdge(new Extent(AAT, NLT, 900,660));

        graph.addEdge(new Extent(SWL, KNH, 2200,1740));

        graph.addEdge(new Extent(ScM, Old_Site, 2000,1500));

        graph.addEdge(new Extent(SB, Old_Site, 2300,1680));

        graph.addEdge(new Extent(S_Hall, ScM, 2300,1740));

        graph.addEdge(new Extent(SRC, KNH, 3400,2460));


        new UserInterface();

    }
}