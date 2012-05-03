/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;

import fr.android.earthdawn.R;

/**
 * @author DrMabulle
 *
 */
public enum Talents implements Serializable
{

    AbriVegetal(R.string.AbriVegetal, Attributs.CHA, true, false, 0, 167),
    AcrobatiesEnSelle(R.string.AcrobatiesEnSelle, Attributs.DEX, false, false, 0, 168),
    AffolementTroupeaux(R.string.AffolementTroupeaux, Attributs.VOL, true, false, 0, 168),
    AlterationArmeTir(R.string.AlterationArmeTir, Attributs.PER, true, false, 1, 168),
    AmeliorationLame(R.string.AmeliorationLame, Attributs.PER, true, true, 0, 168),
    AmeliorationArmure(R.string.AmeliorationArmure, Attributs.PER, true, true, 0, 168),
    AnalyseCreature(R.string.AnalyseCreature, Attributs.PER, true, false, 1, 169),
    AnalyseIndices(R.string.AnalyseIndices, Attributs.PER, true, false, 1, 169),
    AnimationObjet(R.string.AnimationObjet, Attributs.VOL, true, true, 0, 169),
    Anticipation(R.string.Anticipation, Attributs.PER, false, false, 1, 170),
    AppelMonture(R.string.AppelMonture, Attributs.VOL, true, false, 1, 170),
    Apprivoisement(R.string.Apprivoisement, Attributs.CHA, true, false, 0, 170),
    ApprocheSurprise(R.string.ApprocheSurprise, Attributs.VOL, false, true, 0, 170),
    ArcVent(R.string.ArcVent, Attributs.STR, false, true, 0, 170),
    ArmeCorporelle(R.string.ArmeCorporelle, Attributs.STR, false, true, 0, 171),
    ArmeEtheree(R.string.ArmeEtheree, Attributs.DEX, true, false, 2, 171),
    ArmesJet(R.string.ArmesJet, Attributs.DEX, true, false, 0, 171),
    ArmesMelee(R.string.ArmesMelee, Attributs.DEX, true, false, 0, 171),
    ArmesTir(R.string.ArmesTir, Attributs.DEX, true, false, 0, 171),
    ArmureTellurique(R.string.ArmureTellurique, Attributs.VOL, true, true, 0, 171),
    AttaqueAcrobatique(R.string.AttaqueAcrobatique, Attributs.DEX, false, false, 1, 171),
    AttaqueAnnoncee(R.string.AttaqueAnnoncee, Attributs.DEX, true, false, 1, 171),
    AttaqueAstrale(R.string.AttaqueAstrale, Attributs.VOL, true, false, 1, 172),

    // additionner le rang de l'attaque critique à l'attaque normale en cas de réussite Excellente
    AttaqueCritique(R.string.AttaqueCritique, Attributs.NUL, false, true, false, 0, 172),

    AttaqueDecisive(R.string.AttaqueDecisive, Attributs.PER, false, true, 1, 172),
    AttaqueMatrices(R.string.AttaqueMatrices, Attributs.VOL, false, false, 1, 172),
    AttaqueCobra(R.string.AttaqueCobra, Attributs.DEX, false, false, 1, 172),
    AttaqueBalancier(R.string.AttaqueBalancier, Attributs.DEX, true, false, 1, 172),
    AttaqueEnchainee(R.string.AttaqueEnchainee, Attributs.DEX, false, false, 1, 172),

    // liée au type d'attaque choisi => effort ou karma éventuels
    AttaqueCourse(R.string.AttaqueCourse, Attributs.DEX, true, false, 0, 173),

    // effort = 1 par attaque
    AttaqueMultiple(R.string.AttaqueMultiple, Attributs.DEX, true, true, 1, 173),

    AttaquePlongeante(R.string.AttaquePlongeante, Attributs.STR, false, false, 1, 173),
    AttaqueSurprise(R.string.AttaqueSurprise, Attributs.STR, false, false, 1, 173),
    AttaqueTornade(R.string.AttaqueTornade, Attributs.DEX, true, false, 2, 173),
    AttaqueTournoyante(R.string.AttaqueTournoyante, Attributs.DEX, true, true, 0, 173),
    AuraProtectrice(R.string.AuraProtectrice, Attributs.VOL, true, false, 2, 173),

    // 1 point d'effort par tour
    BarriereLames(R.string.BarriereLames, Attributs.DEX, true, false, 1, 173),

    BondLezard(R.string.BondLezard, Attributs.STR, false, true, 0, 174),
    Cameleon(R.string.Cameleon, Attributs.VOL, false, true, 1, 174),
    CercleInvocation(R.string.CercleInvocation, Attributs.VOL, true, true, 0, 174),
    ChantEmouvant(R.string.ChantEmouvant, Attributs.CHA, true, false, 0, 174),
    ChantProtection(R.string.ChantProtection, Attributs.VOL, false, true, 1, 175),
    ChargeDevastatrice(R.string.ChargeDevastatrice, Attributs.STR, false, false, 0, 175),

    // effort = 1 par attaque
    ChargeMultiple(R.string.ChargeMultiple, Attributs.DEX, true, true, 1, 175),

    ChargeTerrifiante(R.string.ChargeTerrifiante, Attributs.VOL, false, false, 2, 175),
    ChutePlume(R.string.ChutePlume, Attributs.VOL, true, false, 0, 176),

    // bonus de rang en déf sociale et magique contre la peur et l'intimidation
    CoeurLion(R.string.CoeurLion, Attributs.VOL, false, false, false, 0, 176),

    CombatMainsNues(R.string.CombatMainsNues, Attributs.DEX, true, false, 0, 176),
    Commandement(R.string.Commandement, Attributs.CHA, true, true, 0, 176),
    CommandementAnimaux(R.string.CommandementAnimaux, Attributs.CHA, true, true, 0, 176),
    ConfrontationHorreur(R.string.ConfrontationHorreur, Attributs.CHA, true, true, 5, 176),
    ConstitutionBestiale(R.string.ConstitutionBestiale, Attributs.END, false, true, 0, 176),
    ContreMalediction(R.string.ContreMalediction, Attributs.VOL, true, false, 1, 177),
    ControleAdversaires(R.string.ControleAdversaires, Attributs.DEX, true, false, 0, 177),
    ControleCorporel(R.string.ControleCorporel, Attributs.STR, false, false, 1, 262),
    ControleTemperature(R.string.ControleTemperature, Attributs.VOL, true, false, 1, 177),
    CoupBouclier(R.string.CoupBouclier, Attributs.STR, false, false, 1, 177),
    CoupPiedRapide(R.string.CoupPiedRapide, Attributs.DEX, false, false, 1, 177),
    CoupDevastateur(R.string.CoupDevastateur, Attributs.STR, false, true, 1, 177),
    CreationFleches(R.string.CreationFleches, Attributs.VOL, true, true, 0, 178),
    CriGuerre(R.string.CriGuerre, Attributs.CHA, false, false, 1, 178),
    Crochetage(R.string.Crochetage, Attributs.DEX, true, false, 0, 178),
    DanseAirs(R.string.DanseAirs, Attributs.DEX, false, false, 1, 178),
    DanseEaux(R.string.DanseEaux, Attributs.CHA, true, true, 0, 178),

    // effort = 1 par attaque
    DechainementGriffes(R.string.DechainementGriffes, Attributs.DEX, true, true, 1, 178),

    DefenseAmelioree(R.string.DefenseAmelioree, Attributs.DEX, true, true, 1, 179),
    DefenseTournoyante(R.string.DefenseTournoyante, Attributs.DEX, false, false, 1, 179),
    DefiChampion(R.string.DefiChampion, Attributs.CHA, true, true, 0, 179),
    DeguisementMagique(R.string.DeguisementMagique, Attributs.PER, true, true, 0, 179),
    DeplacementSilencieux(R.string.DeplacementSilencieux, Attributs.DEX, false, false, 0, 179),

    // voir livre : pièges magiques : karma obligatoire
    DesarmocagePieges(R.string.DesarmocagePieges, Attributs.DEX, true, false, 1, 180),

    Desarconnement(R.string.Desarconnement, Attributs.STR, false, false, 0, 180),
    Desarmement(R.string.Desarmement, Attributs.DEX, true, false, 1, 180),
    DestructionAme(R.string.DestructionAme, Attributs.VOL, false, true, 1, 180),
    DestructionArme(R.string.DestructionArme, Attributs.STR, false, true, 0, 180),
    DetectionVie(R.string.DetectionVie, Attributs.PER, false, false, 1, 180),
    DetectionOr(R.string.DetectionOr, Attributs.PER, true, true, 0, 180),
    DetectionArmes(R.string.DetectionArmes, Attributs.PER, true, false, 1, 181),
    DetectionArmesMagiques(R.string.DetectionArmesMagiques, Attributs.PER, true, false, 1, 181),
    DetectionDefautsArmure(R.string.DetectionDefautsArmure, Attributs.PER, false, false, 0, 181),
    DetectionPieges(R.string.DetectionPieges, Attributs.PER, true, false, 1, 181),
    DetectionMensonges(R.string.DetectionMensonges, Attributs.PER, true, false, 1, 181),
    DetectionInfluence(R.string.DetectionInfluence, Attributs.PER, true, true, 0, 181),
    DetectionPoison(R.string.DetectionPoison, Attributs.PER, false, false, 1, 181),
    DeteriorationArme(R.string.DeteriorationArme, Attributs.VOL, true, true, 0, 182),
    Determination(R.string.Determination, Attributs.VOL, false, false, 1, 182),
    DeuxiemeArme(R.string.DeuxiemeArme, Attributs.DEX, false, false, 1, 182),
    DeuxiemeAttaque(R.string.DeuxiemeAttaque, Attributs.DEX, false, true, 1, 182),
    DeuxiemeChance(R.string.DeuxiemeChance, Attributs.VOL, false, true, 1, 182),
    DeviationProjectiles(R.string.DeviationProjectiles, Attributs.VOL, true, true, 0, 182),
    DissimulationArme(R.string.DissimulationArme, Attributs.DEX, true, false, 1, 183),
    Distraction(R.string.Distraction, Attributs.CHA, true, false, 1, 183),
    DominationAnimaux(R.string.DominationAnimaux, Attributs.VOL, true, false, 1, 183),
    DominationFleches(R.string.DominationFleches, Attributs.VOL, true, false, 1, 183),

    // une langue par rang, effort à chaque lancer (logique mais souligné dans le bouquin)
    DonLangues(R.string.DonLangues, Attributs.PER, false, false, 1, 183),

    Dressage(R.string.Dressage, Attributs.CHA, true, false, 0, 184),
    DressageMonture(R.string.DressageMonture, Attributs.CHA, true, true, 0, 184),
    EmpruntSensoriel(R.string.EmpruntSensoriel, Attributs.VOL, true, false, 0, 184),

    // LONGEVITE (ici appelée Endurance ???) recalcul PV
    Endurance(R.string.Endurance, Attributs.NUL, false, false, false, 0, 184),

    EnduranceFroid(R.string.EnduranceFroid, Attributs.END, false, false, 0, 185),

    // LONGEVITE de la monture : recalcul PV de la monture...
    EnduranceMonture(R.string.EnduranceMonture, Attributs.NUL, true, false, false, 0, 185),

    Endurcissement(R.string.Endurcissement, Attributs.VOL, true, false, 0, 185),
    EndurcissementAutrui(R.string.EndurcissementAutrui, Attributs.VOL, true, false, 0, 185),
    Enracinement(R.string.Enracinement, Attributs.STR, false, false, 1, 185),
    Escalade(R.string.Escalade, Attributs.DEX, true, false, 0, 185),
    Escamotage(R.string.Escamotage, Attributs.DEX, true, true, 0, 186),
    EspritGuetteur(R.string.EspritGuetteur, Attributs.PER, true, true, 0, 186),
    EspritLion(R.string.EspritLion, Attributs.NUL, false, false, false, 0, 2),
    Esquive(R.string.Esquive, Attributs.DEX, false, false, 1, 186),
    EsquivePieges(R.string.EsquivePieges, Attributs.DEX, false, false, 1, 186),
    ExtensionTrame(R.string.ExtensionTrame, Attributs.PER, true, false, 1, 186),
    FauxSemblants(R.string.FauxSemblants, Attributs.NUL, false, false, false, 1, 186),
    FlecheDirection(R.string.FlecheDirection, Attributs.PER, true, true, 2, 187),
    FlecheEnflammee(R.string.FlecheEnflammee, Attributs.VOL, false, true, 2, 187),
    FlecheHurlante(R.string.FlecheHurlante, Attributs.CHA, true, false, 1, 187),
    Griffes(R.string.Griffes, Attributs.STR, false, true, 0, 187),
    GuerisonFeu(R.string.GuerisonFeu, Attributs.VOL, true, false, 0, 187),
    GuideElementaire(R.string.GuideElementaire, Attributs.PER, true, true, 0, 188),
    HacheTonnerre(R.string.HacheTonnerre, Attributs.STR, false, false, 1, 188),
    HistoireArmes(R.string.HistoireArmes, Attributs.PER, true, true, 0, 188),
    HistoireObjets(R.string.HistoireObjets, Attributs.PER, true, true, 0, 188),
    Hurlement(R.string.Hurlement, Attributs.CHA, true, false, 1, 189),
    Hypnose(R.string.Hypnose, Attributs.CHA, true, false, 1, 189),
    ImitationVoix(R.string.ImitationVoix, Attributs.PER, false, false, 0, 189),
    ImmobilisationElementaire(R.string.ImmobilisationElementaire, Attributs.VOL, true, false, 1, 189),
    ImmobilisationEsprit(R.string.ImmobilisationEsprit, Attributs.VOL, true, false, 1, 189),
    ImpressionDurable(R.string.ImpressionDurable, Attributs.CHA, false, true, 0, 190),
    Incantation(R.string.Incantation, Attributs.PER, true, false, 0, 190),
    Invocation(R.string.Invocation, Attributs.PER, true, true, 0, 190),
    JugementSang(R.string.JugementSang, Attributs.PER, true, true, 0, 190),
    LangageVent(R.string.LangageVent, Attributs.PER, false, false, 1, 190),
    LangueEsprits(R.string.LangueEsprits, Attributs.PER, false, true, 1, 191),
    LanguesElementaires(R.string.LanguesElementaires, Attributs.PER, false, true, 1, 191),
    LectureEcriture(R.string.LectureEcriture, Attributs.PER, true, false, 1, 191),
    LectureEcritureMagie(R.string.LectureEcritureMagie, Attributs.PER, true, false, 0, 192),
    LectureLevres(R.string.LectureLevres, Attributs.CHA, true, true, 1, 192),
    LienTelepathique(R.string.LienTelepathique, Attributs.PER, true, false, 1, 192),
    LienTellurique(R.string.LienTellurique, Attributs.END, true, false, 0, 268),
    LocalisationTireur(R.string.LocalisationTireur, Attributs.PER, false, false, 1, 192),
    LocalisationEcho(R.string.LocalisationEcho, Attributs.PER, true, false, 1, 192),
    MaintienFilament(R.string.MaintienFilament, Attributs.VOL, false, false, 1, 193),
    ManipulationFoules(R.string.ManipulationFoules, Attributs.VOL, true, false, 1, 193),
    Manoeuvre(R.string.Manoeuvre, Attributs.DEX, true, false, 0, 193),
    Marchandage(R.string.Marchandage, Attributs.CHA, true, false, 0, 193),

    // effort que si montée... (voir livre, mais pas important ici)
    MarcheVents(R.string.MarcheVents, Attributs.DEX, false, false, 1, 193),

    MarmonnementSibyllins(R.string.MarmonnementSibyllins, Attributs.CHA, true, true, 0, 194),
    MarqueMystique(R.string.MarqueMystique, Attributs.PER, true, false, 1, 194),
    MarqueParalysante(R.string.MarqueParalysante, Attributs.CHA, true, false, 1, 194),

    // METAMATRICE
    MatriceAmelioree(R.string.MatriceAmelioree, Attributs.NUL, false, false, false, 0, 194),

    MatriceSort(R.string.MatriceSort, Attributs.NUL, false, false, false, 0, 194),
    MatricePartagee(R.string.MatricePartagee, Attributs.NUL, false, false, false, 0, 195),
    MatriceRenforcee(R.string.MatriceRenforcee, Attributs.NUL, false, false, false, 0, 195),

    MemoireImages(R.string.MemoireImages, Attributs.PER, true, true, 0, 195),
    MemoireLivresque(R.string.MemoireLivresque, Attributs.VOL, true, true, 0, 195),

    // rang = bonus d'attaque pour la monture (effort pour qui ??)
    MontureAgressive(R.string.MontureAgressive, Attributs.NUL, false, false, 1, 195),

    MontureSpectrale(R.string.MontureSpectrale, Attributs.PER, true, false, 1, 195),
    MortFeinte(R.string.MortFeinte, Attributs.VOL, false, false, 1, 196),

    // 1 effort / minute !
    Multilinguisme(R.string.Multilinguisme, Attributs.PER, true, false, 1, 196),

    NavigationAerienne(R.string.NavigationAerienne, Attributs.VOL, true, false, 0, 196),
    NegociationCreatureInvoquee(R.string.NegociationCreatureInvoquee, Attributs.CHA, true, false, 1, 196),
    OeilAigle(R.string.OeilAigle, Attributs.PER, false, false, 0, 197),
    OndeMentale(R.string.OndeMentale, Attributs.VOL, true, true, 0, 197),
    OrdreEmpathique(R.string.OrdreEmpathique, Attributs.VOL, false, false, 0, 197),

    // l'activation du spectre nécessite une action, 1 effort à chaque test (logique)
    ParadeSpectrale(R.string.ParadeSpectrale, Attributs.PER, false, false, 1, 197),

    PartageSang(R.string.PartageSang, Attributs.END, true, true, 0, 197),
    PatteVelours(R.string.PatteVelours, Attributs.DEX, false, false, 1, 198),

    // résultats = bonus seuil mort/inconscience, armure physique ou défense magique... il faut ajouter un bouton "arrêt" pour signifier la fin de l'activation
    PeauArgile(R.string.PeauArgile, Attributs.END, true, true, 0, 269),
    PeauBois(R.string.PeauBois, Attributs.END, true, true, 0, 198),
    PeauPierre(R.string.PeauPierre, Attributs.END, true, true, 0, 198),
    PeauTellurique(R.string.PeauTellurique, Attributs.END, true, true, 0, 198),

    PenseeSecrete(R.string.PenseeSecrete, Attributs.VOL, true, true, 0, 198),
    PerceArmure(R.string.PerceArmure, Attributs.NUL, false, true, false, 1, 198),
    PerfectionnementArmure(R.string.PerfectionnementArmure, Attributs.PER, true, false, 2, 198),
    PerfectionnementLame(R.string.PerfectionnementLame, Attributs.PER, true, false, 1, 199),

    // bonus à l'attaque de la monture
    Pietinement(R.string.Pietinement, Attributs.NUL, false, false, false, 1, 200),

    Pistage(R.string.Pistage, Attributs.PER, true, false, 1, 200),

    // 1 point d'effort à chaque fois que quelque chose est entreposé ou retiré de la poche (en plus de la création de la poche)
    PocheAstrale(R.string.PocheAstrale, Attributs.PER, true, false, 1, 200),

    // ARGH !!!
    Polyvalence(R.string.Polyvalence, Attributs.NUL, false, false, false, 0, 200),

    PossessionAnimal(R.string.PossessionAnimal, Attributs.VOL, true, false, 2, 200),

    // bonus au résultat d'un autre talent (dont la durée > 1 minute), et dépense d'un point de karma (mais pas de jet)
    PremierCerclePerfection(R.string.PremierCerclePerfection, Attributs.NUL, false, true, false, 0, 201),

    PremiereImpression(R.string.PremiereImpression, Attributs.CHA, true, false, 0, 201),
    ProjectionAstrale(R.string.ProjectionAstrale, Attributs.VOL, true, true, 0, 201),
    ProtectionContreMetal(R.string.ProtectionContreMetal, Attributs.PER, true, true, 0, 202),
    ProtectionMonture(R.string.ProtectionMonture, Attributs.VOL, false, false, 1, 202),
    PurificationFroid(R.string.PurificationFroid, Attributs.VOL, true, false, 0, 202),

    // QUESTEURS !!
    Questeur(R.string.Questeur, Attributs.NUL, false, false, 0, 202),

    // 1 point d'effort si pas vu par ses amis
    Ralliement(R.string.Ralliement, Attributs.CHA, true, true, 0, 202),

    RappelFleches(R.string.RappelFleches, Attributs.PER, true, false, 1, 202),
    Recel(R.string.Recel, Attributs.CHA, true, false, 0, 202),
    Reconstitution(R.string.Reconstitution, Attributs.PER, true, true, 0, 202),

    // se substitue à la CON pour les jets de récup
    RecuperationBestiale(R.string.RecuperationBestiale, Attributs.END, true, false, false, 0, 203),

    RegardFroid(R.string.RegardFroid, Attributs.CHA, true, false, 1, 203),
    RegardTerrifiant(R.string.RegardTerrifiant, Attributs.VOL, true, true, 0, 203),
    RegardTerrifiantMaitre(R.string.RegardTerrifiantMaitre, Attributs.CHA, true, true, 0, 203),
    RejetResponsabilite(R.string.RejetResponsabilite, Attributs.CHA, true, true, 1, 203),
    RemodelageObjet(R.string.RemodelageObjet, Attributs.VOL, true, false, 2, 203),

    ResistancePoison(R.string.ResistancePoison, Attributs.END, false, false, 0, 204),
    RevelationDefautsArmure(R.string.RevelationDefautsArmure, Attributs.PER, true, false, 2, 204),
    Ricochet(R.string.Ricochet, Attributs.DEX, true, false, 1, 204),
    Riposte(R.string.Riposte, Attributs.DEX, false, false, 2, 204),
    RireEncourageant(R.string.RireEncourageant, Attributs.CHA, true, true, 0, 204),
    RituelKarma(R.string.RituelKarma, Attributs.NUL, false, false, false, 0, 204),
    RituelMaitreFantome(R.string.RituelMaitreFantome, Attributs.PER, true, true, 2, 205),
    RugissementGuerre(R.string.RugissementGuerre, Attributs.CHA, false, false, 1, 205),

    // remplace et coûte un test de récup
    SangFeu(R.string.SangFeu, Attributs.END, true, false, 0, 205),

    SangFroid(R.string.SangFroid, Attributs.VOL, false, false, 1, 205),
    Sarcasmes(R.string.Sarcasmes, Attributs.CHA, false, false, 1, 206),
    SautGeant(R.string.SautGeant, Attributs.DEX, false, false, 1, 206),
    SensAnimal(R.string.SensAnimal, Attributs.PER, true, false, 1, 206),
    SensSerrures(R.string.SensSerrures, Attributs.PER, true, false, 1, 206),

    // possibilité d'augmenter la durée sur 1 an => 1 pt de dommage permanent
    SensEmpathique(R.string.SensEmpathique, Attributs.CHA, false, false, 1, 206),

    // remplace et coûte un test de récup
    SoinCompagnonAnimal(R.string.SoinCompagnonAnimal, Attributs.END, true, false, 0, 206),

    SortieGracieuse(R.string.SortieGracieuse, Attributs.CHA, true, false, 0, 207),
    SourireRavageur(R.string.SourireRavageur, Attributs.CHA, true, false, 0, 207),
    SouvenirsLivresques(R.string.SouvenirsLivresques, Attributs.PER, true, false, 1, 207),
    Sprint(R.string.Sprint, Attributs.DEX, false, false, 1, 207),
    Stabilite(R.string.Stabilite, Attributs.STR, false, false, 0, 207),

    // Maître des animaux 4e C : choisit entre regard terrifiant du maître et symbole animal. SA : donne un bonus/malus à un attribut
    SymboleAnimal(R.string.SymboleAnimal, Attributs.PER, true, false, 0, 208),

    TenueSelle(R.string.TenueSelle, Attributs.STR, false, false, 0, 208),
    TerreFlottante(R.string.TerreFlottante, Attributs.VOL, true, true, 0, 208),
    TirAvertissement(R.string.TirAvertissement, Attributs.CHA, false, false, 0, 208),
    TirAveugle(R.string.TirAveugle, Attributs.PER, false, true, 0, 208),
    TirImpressionnant(R.string.TirImpressionnant, Attributs.DEX, true, false, 1, 209),
    TirInfaillible(R.string.TirInfaillible, Attributs.DEX, true, true, 0, 209),

    // effort = 1 par attaque
    TirMultiple(R.string.TirMultiple, Attributs.DEX, true, false, 1, 209),
    TirRapide(R.string.TirRapide, Attributs.DEX, false, false, 1, 209),

    //TissageFilament("Tissage de filament", Attributs.PER, true, false, 0, 209),
    TissageArcher(R.string.TissageArcher, Attributs.PER, true, false, 0, 209),
    TissageCavalier(R.string.TissageCavalier, Attributs.PER, true, false, 0, 209),
    TissageEclaireur(R.string.TissageEclaireur, Attributs.PER, true, false, 0, 209),
    TissageEcumeurCiel(R.string.TissageEcumeurCiel, Attributs.PER, true, false, 0, 209),
    TissageElementaliste(R.string.TissageElementaliste, Attributs.PER, true, false, 0, 209),
    TissageForgeron(R.string.TissageForgeron, Attributs.PER, true, false, 0, 209),
    TissageGuerrier(R.string.TissageGuerrier, Attributs.PER, true, false, 0, 209),
    TissageIllusionniste(R.string.TissageIllusionniste, Attributs.PER, true, false, 0, 209),
    TissageMaitreArmes(R.string.TissageMaitreArmes, Attributs.PER, true, false, 0, 209),
    TissageMaitreAnimaux(R.string.TissageMaitreAnimaux, Attributs.PER, true, false, 0, 209),
    TissageNavigateurCiel(R.string.TissageNavigateurCiel, Attributs.PER, true, false, 0, 209),
    TissageNecromancien(R.string.TissageNecromancien, Attributs.PER, true, false, 0, 209),
    TissagePurificateur(R.string.TissagePurificateur, Attributs.PER, true, false, 0, 245),
    TissageSorcier(R.string.TissageSorcier, Attributs.PER, true, false, 0, 209),
    TissageTroubadour(R.string.TissageTroubadour, Attributs.PER, true, false, 0, 209),
    TissageVoleur(R.string.TissageVoleur, Attributs.PER, true, false, 0, 209),

    TissageMultiple(R.string.TissageMultiple, Attributs.PER, false, false, 1, 209),
    ToileAstrale(R.string.ToileAstrale, Attributs.STR, false, false, 1, 210),

    // création trame temporaire pour un attribut... voir livre, test contre attribut
    TrameAttribut(R.string.TrameAttribut, Attributs.PER, true, true, 1, 210),

    // amélioration d'un talent, test contre DM
    TramageTalent(R.string.TramageTalent, Attributs.PER, true, true, 3, 210),

    // bonus sur l'effet d'un sort
    TrameEffet(R.string.TrameEffet, Attributs.PER, false, false, 1, 210),

    // bonus incantation, test contre tissage ou réharmonisation
    TrameIncantation(R.string.TrameIncantation, Attributs.PER, true, false, 1, 210),

    TransfertBlessure(R.string.TransfertBlessure, Attributs.VOL, false, true, 0, 210),

    // remplace et coûte un test de récup, que pendant la mort
    UltimeSursaut(R.string.UltimeSursaut, Attributs.END, false, false, 0, 211),

    Venin(R.string.Venin, Attributs.END, false, true, 0, 211),

    // 2 pts dommage permanent ne pouvant être soigné avant la fin du talent
    VerrouCristallinSort(R.string.VerrouCristallinSort, Attributs.PER, true, false, 0, 211),

    VisageMiroir(R.string.VisageMiroir, Attributs.PER, false, false, 0, 211),
    VisionAstrale(R.string.VisionAstrale, Attributs.PER, false, false, 1, 212),
    VisionVeritable(R.string.VisionVeritable, Attributs.NUL, false, false, false, 0, 212),

    // récup bonus : incrémenter PV
    Vitalite(R.string.Vitalite, Attributs.END, true, true, 0, 212),

    // bonus initiative
    VivaciteTigre(R.string.VivaciteTigre, Attributs.NUL, false, false, false, 1, 212),

    // bonus initiative et ignore les malus d'armure
    ViveLame(R.string.ViveLame, Attributs.DEX, false, false, 2, 212),

    VoixBarde(R.string.VoixBarde, Attributs.CHA, true, false, 1, 212),
    VolTire(R.string.VolTire, Attributs.DEX, true, false, 0, 212),
    VolonteFer(R.string.VolonteFer, Attributs.VOL, false, false, 1, 212),


    // Nouveau talents

    ArmeSpirituelle(R.string.ArmeSpirituelle, Attributs.NUL, true, false, false, 1, 260),
    ArmureSpirituelle(R.string.ArmureSpirituelle, Attributs.NUL, true, false, false, 1, 260),
    AugureEvasion(R.string.AugureEvasion, Attributs.PER, true, false, 1, 261),
    Bourdonnement(R.string.Bourdonnement, Attributs.DEX, true, false, 0, 261),
    CommunicationSylvestre(R.string.CommunicationSylvestre, Attributs.PER, true, false, 0, 261),
    CommunicationVolatile(R.string.CommunicationVolatile, Attributs.PER, true, true, 0, 261),
    CoupPourCoup(R.string.CoupPourCoup, Attributs.VOL, true, true, 0, 262),
    CreationFetiche(R.string.CreationFetiche, Attributs.PER, true, false, 1, 262),
    CriJustice(R.string.CriJustice, Attributs.CHA, true, true, 0, 263),
    DanseCaudale(R.string.DanseCaudale, Attributs.DEX, false, false, 1, 263),
    DanseDistraction(R.string.DanseDistraction, Attributs.CHA, true, false, 1, 263),
    DanseVent(R.string.DanseVent, Attributs.PER, false, false, 1, 264),
    DeguisementAstral(R.string.DeguisementAstral, Attributs.VOL, true, true, 0, 264),
    DetectionDirection(R.string.DetectionDirection, Attributs.PER, true, true, 2, 264),
    DetectionLiberte(R.string.DetectionLiberte, Attributs.PER, true, false, 1, 264),
    DetectionPrisonniers(R.string.DetectionPrisonniers, Attributs.PER, true, true, 0, 265),
    DetectionDanger(R.string.DetectionDanger, Attributs.PER, true, false, 1, 265),
    Diplomatie(R.string.Diplomatie, Attributs.CHA, true, false, 0, 265),
    DiscretionImpossible(R.string.DiscretionImpossible, Attributs.VOL, true, true, 0, 265),
    DissipationInfluence(R.string.DissipationInfluence, Attributs.VOL, true, true, 0, 265),
    Eloquence(R.string.Eloquence, Attributs.CHA, true, false, 0, 265),
    Envolee(R.string.Envolee, Attributs.DEX, false, false, 0, 266),
    EspritLibre(R.string.EspritLibre, Attributs.CHA, true, false, 0, 266),
    Etiquette(R.string.Etiquette, Attributs.CHA, true, false, 0, 266),
    Evaluation(R.string.Evaluation, Attributs.PER, true, false, 0, 266),
    Evasion(R.string.Evasion, Attributs.DEX, true, false, 1, 266),
    FeticheAmeliore(R.string.FeticheAmeliore, Attributs.NUL, false, false, false, 0, 267),
    FeticheSort(R.string.FeticheSort, Attributs.NUL, false, false, false, 0, 267),
    FetichePartage(R.string.FetichePartage, Attributs.NUL, false, false, false, 0, 267),
    FeticheRenforce(R.string.FeticheRenforce, Attributs.NUL, false, false, false, 0, 267),
    FiletProtection(R.string.FiletProtection, Attributs.DEX, false, false, 1, 267),
    FlecheTracante(R.string.FlecheTracante, Attributs.PER, false, false, 0, 267),
    GuerisonEsclaves(R.string.GuerisonEsclaves, Attributs.VOL, true, true, 1, 267),
    MenottesFictives(R.string.MenottesFictives, Attributs.DEX, true, false, 0, 268),
    Morphisme(R.string.Morphisme, Attributs.NUL, false, false, false, 1, 268),
    Natation(R.string.Natation, Attributs.STR, true, false, 0, 268),
    Performance(R.string.Performance, Attributs.CHA, false, true, 1, 269),
    PilotageNavire(R.string.PilotageNavire, Attributs.VOL, true, false, 0, 269),
    PistageOlfactif(R.string.PistageOlfactif, Attributs.PER, true, false, 0, 269),
    PulsionLiberte(R.string.PulsionLiberte, Attributs.VOL, true, true, 0, 269),
    Quarantaine(R.string.Quarantaine, Attributs.PER, false, false, 1, 270),
    Recherche(R.string.Recherche, Attributs.PER, true, false, 0, 270),
    StabiliteAerienne(R.string.StabiliteAerienne, Attributs.STR, false, false, 1, 270),
    Survie(R.string.Survie, Attributs.PER, true, false, 0, 270),
    TransportSylvestre(R.string.TransportSylvestre, Attributs.VOL, true, true, 1, 270),
    Vigilance(R.string.Vigilance, Attributs.PER, true, false, 1, 271),
    VolArrache(R.string.VolArrache, Attributs.DEX, true, false, 1, 271),


    TissageChaman(R.string.TissageChaman, Attributs.PER, true, false, 0, 209),
    TissageChasseurHorreurs(R.string.TissageChasseurHorreurs, Attributs.PER, true, false, 0, 209),
    TissageDanseurCaudal(R.string.TissageDanseurCaudal, Attributs.PER, true, false, 0, 209),
    TissageDanseurVent(R.string.TissageDanseurVent, Attributs.PER, true, false, 0, 209),
    TissageEclaireurVent(R.string.TissageEclaireurVent, Attributs.PER, true, false, 0, 209),
    TissageEruditExplorateur(R.string.TissageEruditExplorateur, Attributs.PER, true, false, 0, 209),
    TissageGardienBois(R.string.TissageGardienBois, Attributs.PER, true, false, 0, 209),
    TissageGuerrierBanni(R.string.TissageGuerrierBanni, Attributs.PER, true, false, 0, 209),
    TissageLiberateur(R.string.TissageLiberateur, Attributs.PER, true, false, 0, 209),
    TissageMaitreVent(R.string.TissageMaitreVent, Attributs.PER, true, false, 0, 209),
    TissageMenestrel(R.string.TissageMenestrel, Attributs.PER, true, false, 0, 209),
    TissageMessager(R.string.TissageMessager, Attributs.PER, true, false, 0, 209),
    TissageSoldatFleuve(R.string.TissageSoldatFleuve, Attributs.PER, true, false, 0, 209);


    private final Attributs attribut;
    private final int strain;
    private final boolean isAction;
    private final boolean isKarmaMandatory;
    private final boolean isRollable;
    private final int label;
    private final int page;
    /**
     * @param label
     * @param attribut
     * @param isAction
     * @param isKarmaMandatory
     * @param page
     */
    private Talents(final int label, final Attributs attribut,
            final boolean isAction, final boolean isKarmaMandatory, final boolean isRollable,
            final int aStrain, final int page)
    {
        this.label = label;
        this.attribut = attribut;
        this.isAction = isAction;
        this.isKarmaMandatory = isKarmaMandatory;
        this.isRollable = isRollable;
        this.strain = aStrain;
        this.page = page;
    }
    /**
     * @param label
     * @param attribut
     * @param isAction
     * @param isKarmaMandatory
     * @param page
     */
    private Talents(final int label, final Attributs attribut,
            final boolean isAction, final boolean isKarmaMandatory,
            final int aStrain, final int page)
    {
        this.label = label;
        this.attribut = attribut;
        this.isAction = isAction;
        this.isKarmaMandatory = isKarmaMandatory;
        this.isRollable = true;
        this.strain = aStrain;
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
