/**
 *
 */
package fr.android.earthdawn.character.enums;

import fr.android.earthdawn.R;

/**
 * @author DrMabulle
 *
 */
public enum Talents
{
    AbriVegetal(R.string.AbriVegetal, Attributes.CHA, true, false, 0, 167),
    AcrobatiesEnSelle(R.string.AcrobatiesEnSelle, Attributes.DEX, false, false, 0, 168),
    AffolementTroupeaux(R.string.AffolementTroupeaux, Attributes.VOL, true, false, 0, 168),
    AlterationArmeTir(R.string.AlterationArmeTir, Attributes.PER, true, false, 1, 168),
    AmeliorationLame(R.string.AmeliorationLame, Attributes.PER, true, true, 0, 168),
    AmeliorationArmure(R.string.AmeliorationArmure, Attributes.PER, true, true, 0, 168),
    AnalyseCreature(R.string.AnalyseCreature, Attributes.PER, true, false, 1, 169),
    AnalyseIndices(R.string.AnalyseIndices, Attributes.PER, true, false, 1, 169),
    AnimationObjet(R.string.AnimationObjet, Attributes.VOL, true, true, 0, 169),
    Anticipation(R.string.Anticipation, Attributes.PER, false, false, 1, 170),
    AppelMonture(R.string.AppelMonture, Attributes.VOL, true, false, 1, 170),
    Apprivoisement(R.string.Apprivoisement, Attributes.CHA, true, false, 0, 170),
    ApprocheSurprise(R.string.ApprocheSurprise, Attributes.VOL, false, true, 0, 170),
    ArcVent(R.string.ArcVent, Attributes.STR, false, true, 0, 170),
    ArmeCorporelle(R.string.ArmeCorporelle, Attributes.STR, false, true, 0, 171),
    ArmeEtheree(R.string.ArmeEtheree, Attributes.DEX, true, false, 2, 171),
    ArmesJet(R.string.ArmesJet, Attributes.DEX, true, false, 0, 171),
    ArmesMelee(R.string.ArmesMelee, Attributes.DEX, true, false, 0, 171),
    ArmesTir(R.string.ArmesTir, Attributes.DEX, true, false, 0, 171),
    ArmureTellurique(R.string.ArmureTellurique, Attributes.VOL, true, true, 0, 171),
    AttaqueAcrobatique(R.string.AttaqueAcrobatique, Attributes.DEX, false, false, 1, 171),
    AttaqueAnnoncee(R.string.AttaqueAnnoncee, Attributes.DEX, true, false, 1, 171),
    AttaqueAstrale(R.string.AttaqueAstrale, Attributes.VOL, true, false, 1, 172),

    // additionner le rang de l'attaque critique à l'attaque normale en cas de réussite Excellente
    AttaqueCritique(R.string.AttaqueCritique, Attributes.NUL, false, true, false, 0, 172),

    AttaqueDecisive(R.string.AttaqueDecisive, Attributes.PER, false, true, 1, 172),
    AttaqueMatrices(R.string.AttaqueMatrices, Attributes.VOL, false, false, 1, 172),
    AttaqueCobra(R.string.AttaqueCobra, Attributes.DEX, false, false, 1, 172),
    AttaqueBalancier(R.string.AttaqueBalancier, Attributes.DEX, true, false, 1, 172),
    AttaqueEnchainee(R.string.AttaqueEnchainee, Attributes.DEX, false, false, 1, 172),

    // liée au type d'attaque choisi => effort ou karma éventuels
    AttaqueCourse(R.string.AttaqueCourse, Attributes.DEX, true, false, 0, 173),

    // effort = 1 par attaque
    AttaqueMultiple(R.string.AttaqueMultiple, Attributes.DEX, true, true, 1, 173),

    AttaquePlongeante(R.string.AttaquePlongeante, Attributes.STR, false, false, 1, 173),
    AttaqueSurprise(R.string.AttaqueSurprise, Attributes.STR, false, false, 1, 173),
    AttaqueTornade(R.string.AttaqueTornade, Attributes.DEX, true, false, 2, 173),
    AttaqueTournoyante(R.string.AttaqueTournoyante, Attributes.DEX, true, true, 0, 173),
    AuraProtectrice(R.string.AuraProtectrice, Attributes.VOL, true, false, 2, 173),

    // 1 point d'effort par tour
    BarriereLames(R.string.BarriereLames, Attributes.DEX, true, false, 1, 173),

    BondLezard(R.string.BondLezard, Attributes.STR, false, true, 0, 174),
    Cameleon(R.string.Cameleon, Attributes.VOL, false, true, 1, 174),
    CercleInvocation(R.string.CercleInvocation, Attributes.VOL, true, true, 0, 174),
    ChantEmouvant(R.string.ChantEmouvant, Attributes.CHA, true, false, 0, 174),
    ChantProtection(R.string.ChantProtection, Attributes.VOL, false, true, 1, 175),
    ChargeDevastatrice(R.string.ChargeDevastatrice, Attributes.STR, false, false, 0, 175),

    // effort = 1 par attaque
    ChargeMultiple(R.string.ChargeMultiple, Attributes.DEX, true, true, 1, 175),

    ChargeTerrifiante(R.string.ChargeTerrifiante, Attributes.VOL, false, false, 2, 175),
    ChutePlume(R.string.ChutePlume, Attributes.VOL, true, false, 0, 176),

    // bonus de rang en déf sociale et magique contre la peur et l'intimidation
    CoeurLion(R.string.CoeurLion, Attributes.VOL, false, false, false, 0, 176),

    CombatMainsNues(R.string.CombatMainsNues, Attributes.DEX, true, false, 0, 176),
    Commandement(R.string.Commandement, Attributes.CHA, true, true, 0, 176),
    CommandementAnimaux(R.string.CommandementAnimaux, Attributes.CHA, true, true, 0, 176),
    ConfrontationHorreur(R.string.ConfrontationHorreur, Attributes.CHA, true, true, 5, 176),
    ConstitutionBestiale(R.string.ConstitutionBestiale, Attributes.END, false, true, 0, 176),
    ContreMalediction(R.string.ContreMalediction, Attributes.VOL, true, false, 1, 177),
    ControleAdversaires(R.string.ControleAdversaires, Attributes.DEX, true, false, 0, 177),
    ControleCorporel(R.string.ControleCorporel, Attributes.STR, false, false, 1, 262),
    ControleTemperature(R.string.ControleTemperature, Attributes.VOL, true, false, 1, 177),
    CoupBouclier(R.string.CoupBouclier, Attributes.STR, false, false, 1, 177),
    CoupPiedRapide(R.string.CoupPiedRapide, Attributes.DEX, false, false, 1, 177),
    CoupDevastateur(R.string.CoupDevastateur, Attributes.STR, false, true, 1, 177),
    CreationFleches(R.string.CreationFleches, Attributes.VOL, true, true, 0, 178),
    CriGuerre(R.string.CriGuerre, Attributes.CHA, false, false, 1, 178),
    Crochetage(R.string.Crochetage, Attributes.DEX, true, false, 0, 178),
    DanseAirs(R.string.DanseAirs, Attributes.DEX, false, false, false, 1, 178),
    DanseEaux(R.string.DanseEaux, Attributes.CHA, true, true, 0, 178),

    // effort = 1 par attaque
    DechainementGriffes(R.string.DechainementGriffes, Attributes.DEX, true, true, 1, 178),

    DefenseAmelioree(R.string.DefenseAmelioree, Attributes.DEX, true, true, 1, 179),
    DefenseTournoyante(R.string.DefenseTournoyante, Attributes.DEX, false, false, 1, 179),
    DefiChampion(R.string.DefiChampion, Attributes.CHA, true, true, 0, 179),
    DeguisementMagique(R.string.DeguisementMagique, Attributes.PER, true, true, 0, 179),
    DeplacementSilencieux(R.string.DeplacementSilencieux, Attributes.DEX, false, false, 0, 179),

    // voir livre : pièges magiques : karma obligatoire
    DesarmocagePieges(R.string.DesarmocagePieges, Attributes.DEX, true, false, 1, 180),

    Desarconnement(R.string.Desarconnement, Attributes.STR, false, false, 0, 180),
    Desarmement(R.string.Desarmement, Attributes.DEX, true, false, 1, 180),
    DestructionAme(R.string.DestructionAme, Attributes.VOL, false, true, 1, 180),
    DestructionArme(R.string.DestructionArme, Attributes.STR, false, true, 0, 180),
    DetectionVie(R.string.DetectionVie, Attributes.PER, false, false, 1, 180),
    DetectionOr(R.string.DetectionOr, Attributes.PER, true, true, 0, 180),
    DetectionArmes(R.string.DetectionArmes, Attributes.PER, true, false, 1, 181),
    DetectionArmesMagiques(R.string.DetectionArmesMagiques, Attributes.PER, true, false, 1, 181),
    DetectionDefautsArmure(R.string.DetectionDefautsArmure, Attributes.PER, false, false, 0, 181),
    DetectionPieges(R.string.DetectionPieges, Attributes.PER, true, false, 1, 181),
    DetectionMensonges(R.string.DetectionMensonges, Attributes.PER, true, false, 1, 181),
    DetectionInfluence(R.string.DetectionInfluence, Attributes.PER, true, true, 0, 181),
    DetectionPoison(R.string.DetectionPoison, Attributes.PER, false, false, 1, 181),
    DeteriorationArme(R.string.DeteriorationArme, Attributes.VOL, true, true, 0, 182),
    Determination(R.string.Determination, Attributes.VOL, false, false, 1, 182),
    DeuxiemeArme(R.string.DeuxiemeArme, Attributes.DEX, false, false, 1, 182),
    DeuxiemeAttaque(R.string.DeuxiemeAttaque, Attributes.DEX, false, true, 1, 182),
    DeuxiemeChance(R.string.DeuxiemeChance, Attributes.VOL, false, true, 1, 182),
    DeviationProjectiles(R.string.DeviationProjectiles, Attributes.VOL, true, true, 0, 182),
    DissimulationArme(R.string.DissimulationArme, Attributes.DEX, true, false, 1, 183),
    Distraction(R.string.Distraction, Attributes.CHA, true, false, 1, 183),
    DominationAnimaux(R.string.DominationAnimaux, Attributes.VOL, true, false, 1, 183),
    DominationFleches(R.string.DominationFleches, Attributes.VOL, true, false, 1, 183),

    // une langue par rang, effort à chaque lancer (logique mais souligné dans le bouquin)
    DonLangues(R.string.DonLangues, Attributes.PER, false, false, 1, 183),

    Dressage(R.string.Dressage, Attributes.CHA, true, false, 0, 184),
    DressageMonture(R.string.DressageMonture, Attributes.CHA, true, true, 0, 184),
    EmpruntSensoriel(R.string.EmpruntSensoriel, Attributes.VOL, true, false, 0, 184),

    // LONGEVITE (ici appelée Endurance ???) recalcul PV
    Endurance(R.string.Endurance, Attributes.NUL, false, false, false, 0, 184),

    EnduranceFroid(R.string.EnduranceFroid, Attributes.END, false, false, 0, 185),

    // LONGEVITE de la monture : recalcul PV de la monture...
    EnduranceMonture(R.string.EnduranceMonture, Attributes.NUL, true, false, false, 0, 185),

    Endurcissement(R.string.Endurcissement, Attributes.VOL, true, false, 0, 185),
    EndurcissementAutrui(R.string.EndurcissementAutrui, Attributes.VOL, true, false, 0, 185),
    Enracinement(R.string.Enracinement, Attributes.STR, false, false, 1, 185),
    Escalade(R.string.Escalade, Attributes.DEX, true, false, 0, 185),
    Escamotage(R.string.Escamotage, Attributes.DEX, true, true, 0, 186),
    EspritGuetteur(R.string.EspritGuetteur, Attributes.PER, true, true, 0, 186),
    EspritLion(R.string.EspritLion, Attributes.NUL, false, false, false, 0, 2),
    Esquive(R.string.Esquive, Attributes.DEX, false, false, 1, 186),
    EsquivePieges(R.string.EsquivePieges, Attributes.DEX, false, false, 1, 186),
    ExtensionTrame(R.string.ExtensionTrame, Attributes.PER, true, false, 1, 186),
    FauxSemblants(R.string.FauxSemblants, Attributes.NUL, false, false, false, 1, 186),
    FlecheDirection(R.string.FlecheDirection, Attributes.PER, true, true, 2, 187),
    FlecheEnflammee(R.string.FlecheEnflammee, Attributes.VOL, false, true, 2, 187),
    FlecheHurlante(R.string.FlecheHurlante, Attributes.CHA, true, false, 1, 187),
    Griffes(R.string.Griffes, Attributes.STR, false, true, 0, 187),
    GuerisonFeu(R.string.GuerisonFeu, Attributes.VOL, true, false, 0, 187),
    GuideElementaire(R.string.GuideElementaire, Attributes.PER, true, true, 0, 188),
    HacheTonnerre(R.string.HacheTonnerre, Attributes.STR, false, false, 1, 188),
    HistoireArmes(R.string.HistoireArmes, Attributes.PER, true, true, 0, 188),
    HistoireObjets(R.string.HistoireObjets, Attributes.PER, true, true, 0, 188),
    Hurlement(R.string.Hurlement, Attributes.CHA, true, false, 1, 189),
    Hypnose(R.string.Hypnose, Attributes.CHA, true, false, 1, 189),
    ImitationVoix(R.string.ImitationVoix, Attributes.PER, false, false, 0, 189),
    ImmobilisationElementaire(R.string.ImmobilisationElementaire, Attributes.VOL, true, false, 1, 189),
    ImmobilisationEsprit(R.string.ImmobilisationEsprit, Attributes.VOL, true, false, 1, 189),
    ImpressionDurable(R.string.ImpressionDurable, Attributes.CHA, false, true, 0, 190),
    Incantation(R.string.Incantation, Attributes.PER, true, false, 0, 190),
    Invocation(R.string.Invocation, Attributes.PER, true, true, 0, 190),
    JugementSang(R.string.JugementSang, Attributes.PER, true, true, 0, 190),
    LangageVent(R.string.LangageVent, Attributes.PER, false, false, 1, 190),
    LangueEsprits(R.string.LangueEsprits, Attributes.PER, false, true, 1, 191),
    LanguesElementaires(R.string.LanguesElementaires, Attributes.PER, false, true, 1, 191),
    LectureEcriture(R.string.LectureEcriture, Attributes.PER, true, false, 1, 191),
    LectureEcritureMagie(R.string.LectureEcritureMagie, Attributes.PER, true, false, 0, 192),
    LectureLevres(R.string.LectureLevres, Attributes.CHA, true, true, 1, 192),
    LienTelepathique(R.string.LienTelepathique, Attributes.PER, true, false, 1, 192),
    LienTellurique(R.string.LienTellurique, Attributes.END, true, false, 0, 268),
    LocalisationTireur(R.string.LocalisationTireur, Attributes.PER, false, false, 1, 192),
    LocalisationEcho(R.string.LocalisationEcho, Attributes.PER, true, false, 1, 192),
    MaintienFilament(R.string.MaintienFilament, Attributes.VOL, false, false, 1, 193),
    ManipulationFoules(R.string.ManipulationFoules, Attributes.VOL, true, false, 1, 193),
    Manoeuvre(R.string.Manoeuvre, Attributes.DEX, true, false, 0, 193),
    Marchandage(R.string.Marchandage, Attributes.CHA, true, false, 0, 193),

    // effort que si montée... (voir livre, mais pas important ici)
    MarcheVents(R.string.MarcheVents, Attributes.DEX, false, false, 1, 193),

    MarmonnementSibyllins(R.string.MarmonnementSibyllins, Attributes.CHA, true, true, 0, 194),
    MarqueMystique(R.string.MarqueMystique, Attributes.PER, true, false, 1, 194),
    MarqueParalysante(R.string.MarqueParalysante, Attributes.CHA, true, false, 1, 194),

    // METAMATRICE
    MatriceAmelioree(R.string.MatriceAmelioree, Attributes.NUL, false, false, false, 0, 194),

    MatriceSort(R.string.MatriceSort, Attributes.NUL, false, false, false, 0, 194),
    MatricePartagee(R.string.MatricePartagee, Attributes.NUL, false, false, false, 0, 195),
    MatriceRenforcee(R.string.MatriceRenforcee, Attributes.NUL, false, false, false, 0, 195),

    MemoireImages(R.string.MemoireImages, Attributes.PER, true, true, 0, 195),
    MemoireLivresque(R.string.MemoireLivresque, Attributes.VOL, true, true, 0, 195),

    // rang = bonus d'attaque pour la monture (effort pour qui ??)
    MontureAgressive(R.string.MontureAgressive, Attributes.NUL, false, false, 1, 195),

    MontureSpectrale(R.string.MontureSpectrale, Attributes.PER, true, false, 1, 195),
    MortFeinte(R.string.MortFeinte, Attributes.VOL, false, false, 1, 196),

    // 1 effort / minute !
    Multilinguisme(R.string.Multilinguisme, Attributes.PER, true, false, 1, 196),

    NavigationAerienne(R.string.NavigationAerienne, Attributes.VOL, true, false, 0, 196),
    NegociationCreatureInvoquee(R.string.NegociationCreatureInvoquee, Attributes.CHA, true, false, 1, 196),
    OeilAigle(R.string.OeilAigle, Attributes.PER, false, false, 0, 197),
    OndeMentale(R.string.OndeMentale, Attributes.VOL, true, true, 0, 197),
    OrdreEmpathique(R.string.OrdreEmpathique, Attributes.VOL, false, false, 0, 197),

    // l'activation du spectre nécessite une action, 1 effort à chaque test (logique)
    ParadeSpectrale(R.string.ParadeSpectrale, Attributes.PER, false, false, 1, 197),

    PartageSang(R.string.PartageSang, Attributes.END, true, true, 0, 197),
    PatteVelours(R.string.PatteVelours, Attributes.DEX, false, false, 1, 198),

    // résultats = bonus seuil mort/inconscience, armure physique ou défense magique... il faut ajouter un bouton "arrêt" pour signifier la fin de l'activation
    PeauArgile(R.string.PeauArgile, Attributes.END, true, true, 0, 269),
    PeauBois(R.string.PeauBois, Attributes.END, true, true, 0, 198),
    PeauPierre(R.string.PeauPierre, Attributes.END, true, true, 0, 198),
    PeauTellurique(R.string.PeauTellurique, Attributes.END, true, true, 0, 198),

    PenseeSecrete(R.string.PenseeSecrete, Attributes.VOL, true, true, 0, 198),
    PerceArmure(R.string.PerceArmure, Attributes.NUL, false, true, false, 1, 198),
    PerfectionnementArmure(R.string.PerfectionnementArmure, Attributes.PER, true, false, 2, 198),
    PerfectionnementLame(R.string.PerfectionnementLame, Attributes.PER, true, false, 1, 199),

    // bonus à l'attaque de la monture
    Pietinement(R.string.Pietinement, Attributes.NUL, false, false, false, 1, 200),

    Pistage(R.string.Pistage, Attributes.PER, true, false, 1, 200),

    // 1 point d'effort à chaque fois que quelque chose est entreposé ou retiré de la poche (en plus de la création de la poche)
    PocheAstrale(R.string.PocheAstrale, Attributes.PER, true, false, 1, 200),

    // ARGH !!!
    Polyvalence(R.string.Polyvalence, Attributes.NUL, false, false, false, 0, 200),

    PossessionAnimal(R.string.PossessionAnimal, Attributes.VOL, true, false, 2, 200),

    // bonus au résultat d'un autre talent (dont la durée > 1 minute), et dépense d'un point de karma (mais pas de jet)
    PremierCerclePerfection(R.string.PremierCerclePerfection, Attributes.NUL, false, true, false, 0, 201),

    PremiereImpression(R.string.PremiereImpression, Attributes.CHA, true, false, 0, 201),
    ProjectionAstrale(R.string.ProjectionAstrale, Attributes.VOL, true, true, 0, 201),
    ProtectionContreMetal(R.string.ProtectionContreMetal, Attributes.PER, true, true, 0, 202),
    ProtectionMonture(R.string.ProtectionMonture, Attributes.VOL, false, false, 1, 202),
    PurificationFroid(R.string.PurificationFroid, Attributes.VOL, true, false, 0, 202),

    // QUESTEURS !!
    Questeur(R.string.Questeur, Attributes.NUL, false, false, 0, 202),

    // 1 point d'effort si pas vu par ses amis
    Ralliement(R.string.Ralliement, Attributes.CHA, true, true, 0, 202),

    RappelFleches(R.string.RappelFleches, Attributes.PER, true, false, 1, 202),
    Recel(R.string.Recel, Attributes.CHA, true, false, 0, 202),
    Reconstitution(R.string.Reconstitution, Attributes.PER, true, true, 0, 202),

    // se substitue à la CON pour les jets de récup
    RecuperationBestiale(R.string.RecuperationBestiale, Attributes.END, true, false, false, 0, 203),

    RegardFroid(R.string.RegardFroid, Attributes.CHA, true, false, 1, 203),
    RegardTerrifiant(R.string.RegardTerrifiant, Attributes.VOL, true, true, 0, 203),
    RegardTerrifiantMaitre(R.string.RegardTerrifiantMaitre, Attributes.CHA, true, true, 0, 203),
    RejetResponsabilite(R.string.RejetResponsabilite, Attributes.CHA, true, true, 1, 203),
    RemodelageObjet(R.string.RemodelageObjet, Attributes.VOL, true, false, 2, 203),

    ResistancePoison(R.string.ResistancePoison, Attributes.END, false, false, 0, 204),
    RevelationDefautsArmure(R.string.RevelationDefautsArmure, Attributes.PER, true, false, 2, 204),
    Ricochet(R.string.Ricochet, Attributes.DEX, true, false, 1, 204),
    Riposte(R.string.Riposte, Attributes.DEX, false, false, 2, 204),
    RireEncourageant(R.string.RireEncourageant, Attributes.CHA, true, true, 0, 204),
    RituelKarma(R.string.RituelKarma, Attributes.NUL, false, false, false, 0, 204),
    RituelMaitreFantome(R.string.RituelMaitreFantome, Attributes.PER, true, true, 2, 205),
    RugissementGuerre(R.string.RugissementGuerre, Attributes.CHA, false, false, 1, 205),

    // remplace et coûte un test de récup
    SangFeu(R.string.SangFeu, Attributes.END, true, false, 0, 205),

    SangFroid(R.string.SangFroid, Attributes.VOL, false, false, 1, 205),
    Sarcasmes(R.string.Sarcasmes, Attributes.CHA, false, false, 1, 206),
    SautGeant(R.string.SautGeant, Attributes.DEX, false, false, 1, 206),
    SensAnimal(R.string.SensAnimal, Attributes.PER, true, false, 1, 206),
    SensSerrures(R.string.SensSerrures, Attributes.PER, true, false, 1, 206),

    // possibilité d'augmenter la durée sur 1 an => 1 pt de dommage permanent
    SensEmpathique(R.string.SensEmpathique, Attributes.CHA, false, false, 1, 206),

    // remplace et coûte un test de récup
    SoinCompagnonAnimal(R.string.SoinCompagnonAnimal, Attributes.END, true, false, 0, 206),

    SortieGracieuse(R.string.SortieGracieuse, Attributes.CHA, true, false, 0, 207),
    SourireRavageur(R.string.SourireRavageur, Attributes.CHA, true, false, 0, 207),
    SouvenirsLivresques(R.string.SouvenirsLivresques, Attributes.PER, true, false, 1, 207),
    Sprint(R.string.Sprint, Attributes.DEX, false, false, 1, 207),
    Stabilite(R.string.Stabilite, Attributes.STR, false, false, 0, 207),

    // Maître des animaux 4e C : choisit entre regard terrifiant du maître et symbole animal. SA : donne un bonus/malus à un attribut
    SymboleAnimal(R.string.SymboleAnimal, Attributes.PER, true, false, 0, 208),

    TenueSelle(R.string.TenueSelle, Attributes.STR, false, false, 0, 208),
    TerreFlottante(R.string.TerreFlottante, Attributes.VOL, true, true, 0, 208),
    TirAvertissement(R.string.TirAvertissement, Attributes.CHA, false, false, 0, 208),
    TirAveugle(R.string.TirAveugle, Attributes.PER, false, true, 0, 208),
    TirImpressionnant(R.string.TirImpressionnant, Attributes.DEX, true, false, 1, 209),
    TirInfaillible(R.string.TirInfaillible, Attributes.DEX, true, true, 0, 209),

    // effort = 1 par attaque
    TirMultiple(R.string.TirMultiple, Attributes.DEX, true, false, 1, 209),
    TirRapide(R.string.TirRapide, Attributes.DEX, false, false, 1, 209),

    //TissageFilament("Tissage de filament", Attributs.PER, true, false, 0, 209),
    TissageArcher(R.string.TissageArcher, Attributes.PER, true, false, 0, 209),
    TissageCavalier(R.string.TissageCavalier, Attributes.PER, true, false, 0, 209),
    TissageEclaireur(R.string.TissageEclaireur, Attributes.PER, true, false, 0, 209),
    TissageEcumeurCiel(R.string.TissageEcumeurCiel, Attributes.PER, true, false, 0, 209),
    TissageElementaliste(R.string.TissageElementaliste, Attributes.PER, true, false, 0, 209),
    TissageForgeron(R.string.TissageForgeron, Attributes.PER, true, false, 0, 209),
    TissageGuerrier(R.string.TissageGuerrier, Attributes.PER, true, false, 0, 209),
    TissageIllusionniste(R.string.TissageIllusionniste, Attributes.PER, true, false, 0, 209),
    TissageMaitreArmes(R.string.TissageMaitreArmes, Attributes.PER, true, false, 0, 209),
    TissageMaitreAnimaux(R.string.TissageMaitreAnimaux, Attributes.PER, true, false, 0, 209),
    TissageNavigateurCiel(R.string.TissageNavigateurCiel, Attributes.PER, true, false, 0, 209),
    TissageNecromancien(R.string.TissageNecromancien, Attributes.PER, true, false, 0, 209),
    TissagePurificateur(R.string.TissagePurificateur, Attributes.PER, true, false, 0, 245),
    TissageSorcier(R.string.TissageSorcier, Attributes.PER, true, false, 0, 209),
    TissageTroubadour(R.string.TissageTroubadour, Attributes.PER, true, false, 0, 209),
    TissageVoleur(R.string.TissageVoleur, Attributes.PER, true, false, 0, 209),

    TissageMultiple(R.string.TissageMultiple, Attributes.PER, false, false, 1, 209),
    ToileAstrale(R.string.ToileAstrale, Attributes.STR, false, false, 1, 210),

    // création trame temporaire pour un attribut... voir livre, test contre attribut
    TrameAttribut(R.string.TrameAttribut, Attributes.PER, true, true, 1, 210),

    // amélioration d'un talent, test contre DM
    TramageTalent(R.string.TramageTalent, Attributes.PER, true, true, 3, 210),

    // bonus sur l'effet d'un sort
    TrameEffet(R.string.TrameEffet, Attributes.PER, false, false, 1, 210),

    // bonus incantation, test contre tissage ou réharmonisation
    TrameIncantation(R.string.TrameIncantation, Attributes.PER, true, false, 1, 210),

    TransfertBlessure(R.string.TransfertBlessure, Attributes.VOL, false, true, 0, 210),

    // remplace et coûte un test de récup, que pendant la mort
    UltimeSursaut(R.string.UltimeSursaut, Attributes.END, false, false, 0, 211),

    Venin(R.string.Venin, Attributes.END, false, true, 0, 211),

    // 2 pts dommage permanent ne pouvant être soigné avant la fin du talent
    VerrouCristallinSort(R.string.VerrouCristallinSort, Attributes.PER, true, false, 0, 211),

    VisageMiroir(R.string.VisageMiroir, Attributes.PER, false, false, 0, 211),
    VisionAstrale(R.string.VisionAstrale, Attributes.PER, false, false, 1, 212),
    VisionVeritable(R.string.VisionVeritable, Attributes.NUL, false, false, false, 0, 212),

    // récup bonus : incrémenter PV
    Vitalite(R.string.Vitalite, Attributes.END, true, true, 0, 212),

    // bonus initiative
    VivaciteTigre(R.string.VivaciteTigre, Attributes.NUL, false, false, false, 1, 212),

    // bonus initiative et ignore les malus d'armure
    ViveLame(R.string.ViveLame, Attributes.DEX, false, false, 2, 212),

    VoixBarde(R.string.VoixBarde, Attributes.CHA, true, false, 1, 212),
    VolTire(R.string.VolTire, Attributes.DEX, true, false, 0, 212),
    VolonteFer(R.string.VolonteFer, Attributes.VOL, false, false, 1, 212),


    // Nouveau talents

    ArmeSpirituelle(R.string.ArmeSpirituelle, Attributes.NUL, true, false, false, 1, 260),
    ArmureSpirituelle(R.string.ArmureSpirituelle, Attributes.NUL, true, false, false, 1, 260),
    AugureEvasion(R.string.AugureEvasion, Attributes.PER, true, false, 1, 261),
    Bourdonnement(R.string.Bourdonnement, Attributes.DEX, true, false, 0, 261),
    CommunicationSylvestre(R.string.CommunicationSylvestre, Attributes.PER, true, false, 0, 261),
    CommunicationVolatile(R.string.CommunicationVolatile, Attributes.PER, true, true, 0, 261),
    CoupPourCoup(R.string.CoupPourCoup, Attributes.VOL, true, true, 0, 262),
    CreationFetiche(R.string.CreationFetiche, Attributes.PER, true, false, 1, 262),
    CriJustice(R.string.CriJustice, Attributes.CHA, true, true, 0, 263),
    DanseCaudale(R.string.DanseCaudale, Attributes.DEX, false, false, 1, 263),
    DanseDistraction(R.string.DanseDistraction, Attributes.CHA, true, false, 1, 263),
    DanseVent(R.string.DanseVent, Attributes.PER, false, false, 1, 264),
    DeguisementAstral(R.string.DeguisementAstral, Attributes.VOL, true, true, 0, 264),
    DetectionDirection(R.string.DetectionDirection, Attributes.PER, true, true, 2, 264),
    DetectionLiberte(R.string.DetectionLiberte, Attributes.PER, true, false, 1, 264),
    DetectionPrisonniers(R.string.DetectionPrisonniers, Attributes.PER, true, true, 0, 265),
    DetectionDanger(R.string.DetectionDanger, Attributes.PER, true, false, 1, 265),
    Diplomatie(R.string.Diplomatie, Attributes.CHA, true, false, 0, 265),
    DiscretionImpossible(R.string.DiscretionImpossible, Attributes.VOL, true, true, 0, 265),
    DissipationInfluence(R.string.DissipationInfluence, Attributes.VOL, true, true, 0, 265),
    Eloquence(R.string.Eloquence, Attributes.CHA, true, false, 0, 265),
    Envolee(R.string.Envolee, Attributes.DEX, false, false, 0, 266),
    EspritLibre(R.string.EspritLibre, Attributes.CHA, true, false, 0, 266),
    Etiquette(R.string.Etiquette, Attributes.CHA, true, false, 0, 266),
    Evaluation(R.string.Evaluation, Attributes.PER, true, false, 0, 266),
    Evasion(R.string.Evasion, Attributes.DEX, true, false, 1, 266),
    FeticheAmeliore(R.string.FeticheAmeliore, Attributes.NUL, false, false, false, 0, 267),
    FeticheSort(R.string.FeticheSort, Attributes.NUL, false, false, false, 0, 267),
    FetichePartage(R.string.FetichePartage, Attributes.NUL, false, false, false, 0, 267),
    FeticheRenforce(R.string.FeticheRenforce, Attributes.NUL, false, false, false, 0, 267),
    FiletProtection(R.string.FiletProtection, Attributes.DEX, false, false, 1, 267),
    FlecheTracante(R.string.FlecheTracante, Attributes.PER, false, false, 0, 267),
    GuerisonEsclaves(R.string.GuerisonEsclaves, Attributes.VOL, true, true, 1, 267),
    MenottesFictives(R.string.MenottesFictives, Attributes.DEX, true, false, 0, 268),
    Morphisme(R.string.Morphisme, Attributes.NUL, false, false, false, 1, 268),
    Natation(R.string.Natation, Attributes.STR, true, false, 0, 268),
    Performance(R.string.Performance, Attributes.CHA, false, true, 1, 269),
    PilotageNavire(R.string.PilotageNavire, Attributes.VOL, true, false, 0, 269),
    PistageOlfactif(R.string.PistageOlfactif, Attributes.PER, true, false, 0, 269),
    PulsionLiberte(R.string.PulsionLiberte, Attributes.VOL, true, true, 0, 269),
    Quarantaine(R.string.Quarantaine, Attributes.PER, false, false, 1, 270),
    Recherche(R.string.Recherche, Attributes.PER, true, false, 0, 270),
    StabiliteAerienne(R.string.StabiliteAerienne, Attributes.STR, false, false, 1, 270),
    Survie(R.string.Survie, Attributes.PER, true, false, 0, 270),
    TransportSylvestre(R.string.TransportSylvestre, Attributes.VOL, true, true, 1, 270),
    Vigilance(R.string.Vigilance, Attributes.PER, true, false, 1, 271),
    VolArrache(R.string.VolArrache, Attributes.DEX, true, false, 1, 271),


    TissageChaman(R.string.TissageChaman, Attributes.PER, true, false, 0, 209),
    TissageChasseurHorreurs(R.string.TissageChasseurHorreurs, Attributes.PER, true, false, 0, 209),
    TissageDanseurCaudal(R.string.TissageDanseurCaudal, Attributes.PER, true, false, 0, 209),
    TissageDanseurVent(R.string.TissageDanseurVent, Attributes.PER, true, false, 0, 209),
    TissageEclaireurVent(R.string.TissageEclaireurVent, Attributes.PER, true, false, 0, 209),
    TissageEruditExplorateur(R.string.TissageEruditExplorateur, Attributes.PER, true, false, 0, 209),
    TissageGardienBois(R.string.TissageGardienBois, Attributes.PER, true, false, 0, 209),
    TissageGuerrierBanni(R.string.TissageGuerrierBanni, Attributes.PER, true, false, 0, 209),
    TissageLiberateur(R.string.TissageLiberateur, Attributes.PER, true, false, 0, 209),
    TissageMaitreVent(R.string.TissageMaitreVent, Attributes.PER, true, false, 0, 209),
    TissageMenestrel(R.string.TissageMenestrel, Attributes.PER, true, false, 0, 209),
    TissageMessager(R.string.TissageMessager, Attributes.PER, true, false, 0, 209),
    TissageSoldatFleuve(R.string.TissageSoldatFleuve, Attributes.PER, true, false, 0, 209);


    private final Attributes attribut;
    private final int strain;
    private final boolean action;
    private final boolean karmaMandatory;
    private final boolean rollable;
    private final int label;
    private final int page;
    /**
     * @param aLabel
     * @param aAttribut
     * @param isAction
     * @param isKarmaMandatory
     * @param aPage
     */
    private Talents(final int aLabel, final Attributes aAttribut,
            final boolean isAction, final boolean isKarmaMandatory, final boolean isRollable,
            final int aStrain, final int aPage)
    {
        this.label = aLabel;
        this.attribut = aAttribut;
        this.action = isAction;
        this.karmaMandatory = isKarmaMandatory;
        this.rollable = isRollable;
        this.strain = aStrain;
        this.page = aPage;
    }
    /**
     * @param aLabel
     * @param aAttribut
     * @param isAction
     * @param isKarmaMandatory
     * @param aPage
     */
    private Talents(final int aLabel, final Attributes aAttribut,
            final boolean isAction, final boolean isKarmaMandatory,
            final int aStrain, final int aPage)
    {
        this.label = aLabel;
        this.attribut = aAttribut;
        this.action = isAction;
        this.karmaMandatory = isKarmaMandatory;
        this.rollable = true;
        this.strain = aStrain;
        this.page = aPage;
    }
    /**
     * @return the attribut
     */
    public Attributes getAttribut()
    {
        return attribut;
    }
    /**
     * @return the effort
     */
    public int getStrain()
    {
        return strain;
    }
    /**
     * @return the label
     */
    public int getLabel()
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
        return action;
    }
    /**
     * @return the isKarmaMandatory
     */
    public boolean isKarmaMandatory()
    {
        return karmaMandatory;
    }
    /**
     * @return the isRollable
     */
    public boolean isRollable()
    {
        return rollable;
    }

    public static Talents findByLabel(final int aLabel)
    {
        for (final Talents talent : Talents.values())
        {
            if (talent.label == aLabel)
            {
                return talent;
            }
        }
        return null;
    }
}
