/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;

/**
 * @author DrMabulle
 *
 */
public enum Talents implements Serializable
{

    AbriVegetal("Abri végétal", Attributs.CHA, true, false, 0, 167),
    AcrobatiesEnSelle("Acrobaties en selle", Attributs.DEX, false, false, 0, 168),
    AffolementTroupeaux("Affolement des troupeaux", Attributs.VOL, true, false, 0, 168),
    AlterationArmeTir("Altération d'une arme de tir", Attributs.PER, true, false, 1, 168),
    AmeliorationLame("Amélioration de lame", Attributs.PER, true, true, 0, 168),
    AmeliorationArmure("Amélioration d'armure", Attributs.PER, true, true, 0, 168),
    AnalyseCreature("Analyse de créature", Attributs.PER, true, false, 1, 169),
    AnalyseIndices("Analyse des indices", Attributs.PER, true, false, 1, 169),
    AnimationObjet("Animation d'objet", Attributs.VOL, true, true, 0, 169),
    Anticipation("Anticipation", Attributs.PER, false, false, 1, 170),
    AppelMonture("Appel de monture", Attributs.VOL, true, false, 1, 170),
    Apprivoisement("Apprivoisement", Attributs.CHA, true, false, 0, 170),
    ApprocheSurprise("Approche surprise", Attributs.VOL, false, true, 0, 170),
    ArcVent("Arc de vent", Attributs.STR, false, true, 0, 170),
    ArmeCorporelle("Arme corporelle", Attributs.STR, false, true, 0, 171),
    ArmeEtheree("Arme éthérée", Attributs.DEX, true, false, 2, 171),
    ArmesJet("Armes de jet", Attributs.DEX, true, false, 0, 171),
    ArmesMelee("Armes de mêlée", Attributs.DEX, true, false, 0, 171),
    ArmesTir("Armes de tir", Attributs.DEX, true, false, 0, 171),
    ArmureTellurique("Armure tellurique", Attributs.VOL, true, true, 0, 171),
    AttaqueAcrobatique("Attaque acrobatique", Attributs.DEX, false, false, 1, 171),
    AttaqueAnnoncee("Attaque annoncée", Attributs.DEX, true, false, 1, 171),
    AttaqueAstrale("Attaque astrale", Attributs.VOL, true, false, 1, 172),

    // additionner le rang de l'attaque critique à l'attaque normale en cas de réussite Excellente
    AttaqueCritique("Attaque critique", Attributs.NUL, false, true, false, 0, 172),

    AttaqueDecisive("Attaque décisive", Attributs.PER, false, true, 1, 172),
    AttaqueMatrices("Attaque de matrices", Attributs.VOL, false, false, 1, 172),
    AttaqueCobra("Attaque du cobra", Attributs.DEX, false, false, 1, 172),
    AttaqueBalancier("Attaque en balancier", Attributs.DEX, true, false, 1, 172),
    AttaqueEnchainee("Attaque enchaînée", Attributs.DEX, false, false, 1, 172),

    // liée au type d'attaque choisi => effort ou karma éventuels
    AttaqueCourse("Attaque en course", Attributs.DEX, true, false, 0, 173),

    // effort = 1 par attaque
    AttaqueMultiple("Attaque multiple", Attributs.DEX, true, true, 1, 173),

    AttaquePlongeante("Attaque plongeante", Attributs.STR, false, false, 1, 173),
    AttaqueSurprise("Attaque surprise", Attributs.STR, false, false, 1, 173),
    AttaqueTornade("Attaque tornade", Attributs.DEX, true, false, 2, 173),
    AttaqueTournoyante("Attaque tournoyante", Attributs.DEX, true, true, 0, 173),
    AuraProtectrice("Aura protectrice", Attributs.VOL, true, false, 2, 173),

    // 1 point d'effort par tour
    BarriereLames("Barrière de lames", Attributs.DEX, true, false, 1, 173),

    BondLezard("Bond de lézard", Attributs.STR, false, true, 0, 174),
    Cameleon("Caméléon", Attributs.VOL, false, true, 1, 174),
    CercleInvocation("Cercle d'invocation", Attributs.VOL, true, true, 0, 174),
    ChantEmouvant("Chant émouvant", Attributs.CHA, true, false, 0, 174),
    ChantProtection("Chant de protection", Attributs.VOL, false, true, 1, 175),
    ChargeDevastatrice("Charge dévastatrice", Attributs.STR, false, false, 0, 175),

    // effort = 1 par attaque
    ChargeMultiple("Charge multiple", Attributs.DEX, true, true, 1, 175),

    ChargeTerrifiante("Charge terrifiante", Attributs.VOL, false, false, 2, 175),
    ChutePlume("Chute de plume", Attributs.VOL, true, false, 0, 176),

    // bonus de rang en déf sociale et magique contre la peur et l'intimidation
    CoeurLion("Coeur de lion", Attributs.VOL, false, false, false, 0, 176),

    CombatMainsNues("Combat à mains nues", Attributs.DEX, true, false, 0, 176),
    Commandement("Commandement", Attributs.CHA, true, true, 0, 176),
    CommandementAnimaux("Commandement des animaux", Attributs.CHA, true, true, 0, 176),
    ConfrontationHorreur("Confrontation d'horreur", Attributs.CHA, true, true, 5, 176),
    ConstitutionBestiale("Constitution bestiale", Attributs.END, false, true, 0, 176),
    ContreMalediction("Contre-malédiction", Attributs.VOL, true, false, 1, 177),
    ControleAdversaires("Contrôle des adversaires", Attributs.DEX, true, false, 0, 177),
    ControleTemperature("Contrôle de la température", Attributs.VOL, true, false, 1, 177),
    CoupBouclier("Coup de bouclier", Attributs.STR, false, false, 1, 177),
    CoupPiedRapide("Coup de pied rapide", Attributs.DEX, false, false, 1, 177),
    CoupDevastateur("Coup dévastateur", Attributs.STR, false, true, 1, 177),
    CreationFleches("Création de flèches", Attributs.VOL, true, true, 0, 178),
    CriGuerre("Cri de guerre", Attributs.CHA, false, false, 1, 178),
    Crochetage("Crochetage", Attributs.DEX, true, false, 0, 178),
    DanseAirs("Danse des airs", Attributs.DEX, false, false, 1, 178),
    DanseEaux("Danse des eaux", Attributs.CHA, true, true, 0, 178),

    // effort = 1 par attaque
    DechainementGriffes("Déchaînement de griffes", Attributs.DEX, true, true, 1, 178),

    DefenseAmelioree("Défense améliorée", Attributs.DEX, true, true, 1, 179),
    DefenseTournoyante("Défense tournoyante", Attributs.DEX, false, false, 1, 179),
    DefiChampion("Défi du champion", Attributs.CHA, true, true, 0, 179),
    DeguisementMagique("Déguisement magique", Attributs.PER, true, true, 0, 179),
    DeplacementSilencieux("Déplacement silencieux", Attributs.DEX, false, false, 0, 179),

    // voir livre : pièges magiques : karma obligatoire
    DesarmocagePieges("Désamorçage des pièges", Attributs.DEX, true, false, 1, 180),

    Desarconnement("Désarçonnement", Attributs.STR, false, false, 0, 180),
    Desarmement("Désarmement", Attributs.DEX, true, false, 1, 180),
    DestructionAme("Destruction d'âme", Attributs.VOL, false, true, 1, 180),
    DestructionArme("Destruction d'arme", Attributs.STR, false, true, 0, 180),
    DetectionVie("Détection de la vie", Attributs.PER, false, false, 1, 180),
    DetectionOr("Détection de l'or", Attributs.PER, true, true, 0, 180),
    DetectionArmes("Détection des armes", Attributs.PER, true, false, 1, 181),
    DetectionArmesMagiques("Détection des armes magiques", Attributs.PER, true, false, 1, 181),
    DetectionDefautsArmure("Détection des défauts d'armure", Attributs.PER, false, false, 0, 181),
    DetectionPieges("Détection des pièges", Attributs.PER, true, false, 1, 181),
    DetectionMensonges("Détection des mensonges", Attributs.PER, true, false, 1, 181),
    DetectionInfluence("Détection d'influence", Attributs.PER, true, true, 0, 181),
    DetectionPoison("Détection du poison", Attributs.PER, false, false, 1, 181),
    DeteriorationArme("Détérioration d'arme", Attributs.VOL, true, true, 0, 182),
    Determination("Détermination", Attributs.VOL, false, false, 1, 182),
    DeuxiemeArme("Deuxième arme", Attributs.DEX, false, false, 1, 182),
    DeuxiemeAttaque("Deuxième attaque", Attributs.DEX, false, true, 1, 182),
    DeuxiemeChance("Deuxième chance", Attributs.VOL, false, true, 1, 182),
    DeviationProjectiles("Déviation de projectiles", Attributs.VOL, true, true, 0, 182),
    DissimulationArme("Dissimulation d'arme", Attributs.DEX, true, false, 1, 183),
    Distraction("Distraction", Attributs.CHA, true, false, 1, 183),
    DominationAnimaux("Domination des animaux", Attributs.VOL, true, false, 1, 183),
    DominationFleches("Domination des flèches", Attributs.VOL, true, false, 1, 183),

    // une langue par rang, effort à chaque lancer (logique mais souligné dans le bouquin)
    DonLangues("Don des langues", Attributs.PER, false, false, 1, 183),

    Dressage("Dressage", Attributs.CHA, true, false, 0, 184),
    DressageMonture("Dressage de monture", Attributs.CHA, true, true, 0, 184),
    EmpruntSensoriel("Emprunt sensoriel", Attributs.VOL, true, false, 0, 184),

    // LONGEVITE (ici appelée Endurance ???) recalcul PV
    Endurance("Endurance", Attributs.NUL, false, false, false, 0, 184),

    EnduranceFroid("Endurance au froid", Attributs.END, false, false, 0, 185),

    // LONGEVITE de la monture : recalcul PV de la monture...
    EnduranceMonture("Endurance de la monture", Attributs.NUL, true, false, false, 0, 185),

    Endurcissement("Endurcissement", Attributs.VOL, true, false, 0, 185),
    EndurcissementAutrui("Endurcissement d'autrui", Attributs.VOL, true, false, 0, 185),
    Enracinement("Enracinement", Attributs.STR, false, false, 1, 185),
    Escalade("Escalade", Attributs.DEX, true, false, 0, 185),
    Escamotage("Escamotage", Attributs.DEX, true, true, 0, 186),
    EspritGuetteur("Esprit guetteur", Attributs.PER, true, true, 0, 186),
    EspritLion("Esprit du lion", Attributs.NUL, false, false, false, 0, 2),
    Esquive("Esquive", Attributs.DEX, false, false, 1, 186),
    EsquivePieges("Esquive des pièges", Attributs.DEX, false, false, 1, 186),
    ExtensionTrame("extension de trame", Attributs.PER, true, false, 1, 186),
    FauxSemblants("Faux semblants", Attributs.NUL, false, false, false, 1, 186),
    FlecheDirection("Flèche de direction", Attributs.PER, true, true, 2, 187),
    FlecheEnflammee("Flèche enflammée", Attributs.VOL, false, true, 2, 187),
    FlecheHurlante("Flèche hurlante", Attributs.CHA, true, false, 1, 187),
    Griffes("Griffes", Attributs.STR, false, true, 0, 187),
    GuerisonFeu("Guérison par le feu", Attributs.VOL, true, false, 0, 187),
    GuideElementaire("Guide élémentaire", Attributs.PER, true, true, 0, 188),
    HacheTonnerre("Hache du tonnerre", Attributs.STR, false, false, 1, 188),
    HistoireArmes("Histoire des armes", Attributs.PER, true, true, 0, 188),
    HistoireObjets("Histoire des objets", Attributs.PER, true, false, 0, 188),
    Hurlement("Hurlement", Attributs.CHA, true, false, 1, 189),
    Hypnose("Hypnose", Attributs.CHA, true, false, 1, 189),
    ImitationVoix("Imitation de voix", Attributs.PER, false, false, 0, 189),
    ImmobilisationElementaire("Immobilisation d'élémentaire", Attributs.VOL, true, false, 1, 189),
    ImmobilisationEsprit("Immobilisation d'esprit", Attributs.VOL, true, false, 1, 189),
    ImpressionDurable("Impression durable", Attributs.CHA, false, true, 0, 190),
    Incantation("Incantation", Attributs.PER, true, false, 0, 190),
    Invocation("Invocation", Attributs.PER, true, true, 0, 190),
    JugementSang("Jugement du sang", Attributs.PER, true, true, 0, 190),
    LangageVent("Langage du vent", Attributs.PER, false, false, 1, 190),
    LangueEsprits("Langue des esprits", Attributs.PER, false, true, 1, 191),
    LanguesElementaires("Langues élémentaires", Attributs.PER, false, true, 1, 191),
    LectureEcriture("Lecture et écriture", Attributs.PER, true, false, 1, 191),
    LectureEcritureMagie("Lecture et écriture de la magie", Attributs.PER, true, false, 0, 192),
    LectureLevres("Lecture sur les lèvres", Attributs.CHA, true, true, 1, 192),
    LienTelepathique("Lien télépathique", Attributs.PER, true, false, 1, 192),
    LocalisationTireur("Localisation de tireur", Attributs.PER, false, false, 1, 192),
    LocalisationEcho("Localisation par écho", Attributs.PER, true, false, 1, 192),
    MaintienFilament("Maintien de filament", Attributs.VOL, false, false, 1, 193),
    ManipulationFoules("Manipulation de foules", Attributs.VOL, true, false, 1, 193),
    Manoeuvre("Manoeuvre", Attributs.DEX, true, false, 0, 193),
    Marchandage("Marchandage", Attributs.CHA, true, false, 0, 193),

    // effort que si montée... (voir livre, mais pas important ici)
    MarcheVents("Marche des vents", Attributs.DEX, false, false, 1, 193),

    MarmonnementSibyllins("Marmonnements sibyllins", Attributs.CHA, true, true, 0, 194),
    MarqueMystique("Marque mystique", Attributs.PER, true, false, 1, 194),
    MarqueParalysante("Marque paralysante", Attributs.CHA, true, false, 1, 194),

    // METAMATRICE
    MatriceAmelioree("Matrice améliorée", Attributs.NUL, false, false, false, 0, 194),

    MatriceSort("Matrice de sort", Attributs.NUL, false, false, false, 0, 194),
    MatricePartagee("Matrice partagée", Attributs.NUL, false, false, false, 0, 195),
    MatriceRenforcee("Matrice renforcée", Attributs.NUL, false, false, false, 0, 195),

    MemoireImages("Mémoire des images", Attributs.PER, true, true, 0, 195),
    MemoireLivresque("Mémoire livresque", Attributs.VOL, true, true, 0, 195),

    // rang = bonus d'attaque pour la monture (effort pour qui ??)
    MontureAgressive("Monture agressive", Attributs.NUL, false, false, 1, 195),

    MontureSpectrale("Monture spectrale", Attributs.PER, true, false, 1, 195),
    MortFeinte("Mort feinte", Attributs.VOL, false, false, 1, 196),

    // 1 effort / minute !
    Multilinguisme("Multilinguisme", Attributs.PER, true, false, 1, 196),

    NavigationAerienne("Navigation aérienne", Attributs.VOL, true, false, 0, 196),
    NegociationCreatureInvoquee("Négociation avec créature invoquée", Attributs.CHA, true, false, 1, 196),
    OeilAigle("Oeil d'aigle", Attributs.PER, false, false, 0, 197),
    OndeMentale("Onde mentale", Attributs.VOL, true, true, 0, 197),
    OrdreEmpathique("Ordre empathique", Attributs.VOL, false, false, 0, 197),

    // l'activation du spectre nécessite une action, 1 effort à chaque test (logique)
    ParadeSpectrale("Parade spectrale", Attributs.PER, false, false, 1, 197),

    PartageSang("partage du sang", Attributs.END, true, true, 0, 197),
    PatteVelours("patte de velours", Attributs.DEX, false, false, 1, 198),

    // résultats = bonus seuil mort/inconscience, armure physique ou défense magique... il faut ajouter un bouton "arrêt" pour signifier la fin de l'activation
    PeauBois("Peau de bois", Attributs.END, true, true, 0, 198),
    PeauPierre("Peau de pierre", Attributs.END, true, true, 0, 198),
    PeauTellurique("Peau tellurique", Attributs.END, true, true, 0, 198),

    PenseeSecrete("Pensée secrète", Attributs.VOL, true, true, 0, 198),
    PerceArmure("Perce-armure", Attributs.NUL, false, true, false, 1, 198),
    PerfectionnementArmure("Perfectionnement d'armure", Attributs.PER, true, false, 2, 198),
    PerfectionnementLame("Perfectionnement de lame", Attributs.PER, true, false, 1, 199),

    // bonus à l'attaque de la monture
    Pietinement("Piétinement", Attributs.NUL, false, false, false, 1, 200),

    Pistage("Pistage", Attributs.PER, true, false, 1, 200),

    // 1 point d'effort à chaque fois que quelque chose est entreposé ou retiré de la poche (en plus de la création de la poche)
    PocheAstrale("Poche astrale", Attributs.PER, true, false, 1, 200),

    // ARGH !!!
    Polyvalence("Polyvalence", Attributs.NUL, false, false, false, 0, 200),

    PossessionAnimal("Possession d'animal", Attributs.VOL, true, false, 2, 200),

    // bonus au résultat d'un autre talent (dont la durée > 1 minute), et dépense d'un point de karma (mais pas de jet)
    PremierCerclePerfection("Premier cercle de perfection", Attributs.NUL, false, true, false, 0, 201),

    PremiereImpression("Première impression", Attributs.CHA, true, false, 0, 201),
    ProjectionAstrale("Projection astrale", Attributs.VOL, true, true, 0, 201),
    ProtectionContreMetal("Protection contre le métal", Attributs.PER, true, true, 0, 202),
    ProtectionMonture("Protection de monture", Attributs.VOL, false, false, 1, 202),
    PurificationFroid("Purification par le froid", Attributs.VOL, true, false, 0, 202),

    // QUESTEURS !!
    Questeur("Questeur", Attributs.NUL, false, false, 0, 202),

    // 1 point d'effort si pas vu par ses amis
    Ralliement("Ralliement", Attributs.CHA, true, true, 0, 202),

    RappelFleches("Rappel des flèches", Attributs.PER, true, false, 1, 202),
    Recel("Recel", Attributs.CHA, true, false, 0, 202),
    Reconstitution("Reconstitution", Attributs.PER, true, true, 0, 202),

    // se substitue à la CON pour les jets de récup
    RecuperationBestiale("Récupération bestiale", Attributs.END, true, false, false, 0, 203),

    RegardFroid("Regard froid", Attributs.CHA, true, false, 1, 203),
    RegardTerrifiant("Regard terrifiant", Attributs.VOL, true, true, 0, 203),
    RegardTerrifiantMaitre("Regard terrifiant du maître", Attributs.CHA, true, true, 0, 203),
    RejetResponsabilite("Rejet de responsabilité", Attributs.CHA, true, true, 1, 203),
    RemodelageObjet("Remodelage d'objet", Attributs.VOL, true, false, 2, 203),

    ResistancePoison("Résistance au poison", Attributs.END, false, false, 0, 204),
    RevelationDefautsArmure("Révélation des défauts d'armure", Attributs.PER, true, false, 2, 204),
    Ricochet("Ricochet", Attributs.DEX, true, false, 1, 204),
    Riposte("Riposte", Attributs.DEX, false, false, 2, 204),
    RireEncourageant("Rire encourageant", Attributs.CHA, true, true, 0, 204),
    RituelKarma("Rituel de karma", Attributs.NUL, false, false, false, 0, 204),
    RituelMaitreFantome("Rituel du maître fantôme", Attributs.PER, true, true, 2, 205),
    RugissementGuerre("Rugissement de guerre", Attributs.CHA, false, false, 1, 205),

    // remplace et coûte un test de récup
    SangFeu("Sang de feu", Attributs.END, true, false, 0, 205),

    SangFroid("Sang-froid", Attributs.VOL, false, false, 1, 205),
    Sarcasmes("Sarcasmes", Attributs.CHA, false, false, 1, 206),
    SautGeant("Saut de géant", Attributs.DEX, false, false, 1, 206),
    SensAnimal("Sens animal", Attributs.PER, true, false, 1, 206),
    SensSerrures("Sens des serrures", Attributs.PER, true, false, 1, 206),

    // possibilité d'augmenter la durée sur 1 an => 1 pt de dommage permanent
    SensEmpathique("Sens empathique", Attributs.CHA, false, false, 1, 206),

    // remplace et coûte un test de récup
    SoinCompagnonAnimal("Soin de compagnon animal", Attributs.END, true, false, 0, 206),

    SortieGracieuse("Sortie gracieuse", Attributs.CHA, true, false, 0, 207),
    SourireRavageur("Sourire ravageur", Attributs.CHA, true, false, 0, 207),
    SouvenirsLivresques("Souvenirs livresques", Attributs.PER, true, false, 1, 207),
    Sprint("Sprint", Attributs.DEX, false, false, 1, 207),
    Stabilite("Stabilité", Attributs.STR, false, false, 0, 207),

    // Maître des animaux 4e C : choisit entre regard terrifiant du maître et symbole animal. SA : donne un bonus/malus à un attribut
    SymboleAnimal("Symbole animal", Attributs.PER, true, false, 0, 208),

    TenueSelle("Tenue en selle", Attributs.STR, false, false, 0, 208),
    TerreFlottante("Terre flottante", Attributs.VOL, true, true, 0, 208),
    TirAvertissement("Tir d'avertissement", Attributs.CHA, false, false, 0, 208),
    TirAveugle("Tir en aveugle", Attributs.PER, false, true, 0, 208),
    TirImpressionnant("Tir impressionnant", Attributs.DEX, true, false, 1, 209),
    TirInfaillible("Tir infaillible", Attributs.DEX, true, true, 0, 209),

    // effort = 1 par attaque
    TirMultiple("Tir multiple", Attributs.DEX, true, false, 1, 209),
    TirRapide("Tir rapide", Attributs.DEX, false, false, 1, 209),

    //TissageFilament("Tissage de filament", Attributs.PER, true, false, 0, 209),
    TissageArcher("Tissage de flèche", Attributs.PER, true, false, 0, 209),
    TissageCavalier("Tissage de cavalier", Attributs.PER, true, false, 0, 209),
    TissageEclaireur("Tissage d'éclaireur", Attributs.PER, true, false, 0, 209),
    TissageEcumeurCiel("Tissage du ciel", Attributs.PER, true, false, 0, 209),
    TissageElementaliste("Elémentalisme", Attributs.PER, true, false, 0, 209),
    TissageForgeron("Forge de filament", Attributs.PER, true, false, 0, 209),
    TissageGuerrier("Tissage de guerre", Attributs.PER, true, false, 0, 209),
    TissageIllusionniste("Illusionisme", Attributs.PER, true, false, 0, 209),
    TissageMaitreArmes("Tissage d'arme", Attributs.PER, true, false, 0, 209),
    TissageMaitreAnimaux("Tissage d'animaux", Attributs.PER, true, false, 0, 209),
    TissageNavigateurCiel("Tissage des airs", Attributs.PER, true, false, 0, 209),
    TissageNecromancien("Nécromancie", Attributs.PER, true, false, 0, 209),
    TissageSorcier("Sorcellerie", Attributs.PER, true, false, 0, 209),
    TissageTroubadour("Tissage d'histoire", Attributs.PER, true, false, 0, 209),
    TissageVoleur("Tissage de voleur", Attributs.PER, true, false, 0, 209),

    TissageMultiple("Tissage multiple", Attributs.PER, false, false, 1, 209),
    ToileAstrale("Toile astrale", Attributs.STR, false, false, 1, 210),

    // création trame temporaire pour un attribut... voir livre, test contre attribut
    TrameAttribut("Trame d'attribut", Attributs.PER, true, true, 1, 210),

    // amélioration d'un talent, test contre DM
    TramageTalent("Tramage de talent", Attributs.PER, true, true, 3, 210),

    // bonus sur l'effet d'un sort
    TrameEffet("Trame d'effet", Attributs.PER, false, false, 1, 210),

    // bonus incantation, test contre tissage ou réharmonisation
    TrameIncantation("Trame d'incantation", Attributs.PER, true, false, 1, 210),

    TransfertBlessure("Transfert de blessure", Attributs.VOL, false, true, 0, 210),

    // remplace et coûte un test de récup, que pendant la mort
    UltimeSursaut("Ultime sursaut", Attributs.END, false, false, 0, 211),

    Venin("Venin", Attributs.END, false, true, 0, 211),

    // 2 pts dommage permanent ne pouvant être soigné avant la fin du talent
    VerrouCristallinSort("Verrou cristallin de sort", Attributs.PER, true, false, 0, 211),

    VisageMiroir("Visage miroir", Attributs.PER, false, false, 0, 211),
    VisionAstrale("Vision astrale", Attributs.PER, false, false, 1, 212),
    VisionVeritable("Vision véritable", Attributs.NUL, false, false, false, 0, 212),

    // récup bonus : incrémenter PV
    Vitalite("Vitalité", Attributs.END, true, true, 0, 212),

    // bonus initiative
    VivaciteTigre("Vivacité du tigre", Attributs.NUL, false, false, false, 1, 212),

    // bonus initiative et ignore les malus d'armure
    ViveLame("Vive lame", Attributs.DEX, false, false, 2, 212),

    VoixBarde("Voix de barde", Attributs.CHA, true, false, 1, 212),
    VolTire("Vol à la tire", Attributs.DEX, true, false, 0, 212),
    VolonteFer("Volonté de fer", Attributs.VOL, false, false, 1, 212);


    private final Attributs attribut;
    private final int effort;
    private final boolean isAction;
    private final boolean isKarmaMandatory;
    private final boolean isRollable;
    private final String label;
    private final int page;
    /**
     * @param label
     * @param attribut
     * @param isAction
     * @param isKarmaMandatory
     * @param page
     */
    private Talents(final String label, final Attributs attribut,
            final boolean isAction, final boolean isKarmaMandatory, final boolean isRollable,
            final int effort, final int page)
    {
        this.label = label;
        this.attribut = attribut;
        this.isAction = isAction;
        this.isKarmaMandatory = isKarmaMandatory;
        this.isRollable = isRollable;
        this.effort = effort;
        this.page = page;
    }
    /**
     * @param label
     * @param attribut
     * @param isAction
     * @param isKarmaMandatory
     * @param page
     */
    private Talents(final String label, final Attributs attribut,
            final boolean isAction, final boolean isKarmaMandatory,
            final int effort, final int page)
    {
        this.label = label;
        this.attribut = attribut;
        this.isAction = isAction;
        this.isKarmaMandatory = isKarmaMandatory;
        this.isRollable = true;
        this.effort = effort;
        this.page = page;
    }
    /**
     * @return the attribut
     */
    public Attributs getAttribut()
    {
        return attribut;
    }
    /**
     * @return the effort
     */
    public int getEffort()
    {
        return effort;
    }
    /**
     * @return the label
     */
    public String getLabel()
    {
        return label;
    }
    /**
     * @return the page
     */
    public int getPage()
    {
        return page;
    }
    /**
     * @return the isAction
     */
    public boolean isAction()
    {
        return isAction;
    }
    /**
     * @return the isKarmaMandatory
     */
    public boolean isKarmaMandatory()
    {
        return isKarmaMandatory;
    }
    /**
     * @return the isRollable
     */
    public boolean isRollable()
    {
        return isRollable;
    }

    @Override
    public String toString()
    {
        return label;
    }


}
