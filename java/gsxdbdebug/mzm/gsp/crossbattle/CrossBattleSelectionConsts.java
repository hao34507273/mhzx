/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class CrossBattleSelectionConsts implements Marshal
/*     */ {
/*     */   public GetKnockOutContext _getselectioncontext;
/*     */   public GetKnockOutContext_CheckPanelReq _getladderrankrangedonecontext_clientreq;
/*     */   public GetKnockOutContext_GetSpecialFightZoneStage _getselectioncontext_getspecialfightzonestage;
/*     */   public GetKnockOutContext_CreatePrepareWorld _getselectioncontext_createprepareworld;
/*     */   public GetKnockOutContext_ReportFightResult _getknockoutcontext_reportfightresult;
/*     */   public SingleFightResult _singlefightresult;
/*     */   public CalFightResult _calfightresult;
/*     */   public GetKnockOutContext_GetStageBetInfo _getselectioncontext_getstagebetinfo;
/*     */   public GetKnockOutContext_GetFightZoneInfo _getselectioncontext_getfightzoneinfo;
/*     */   public GetKnockOutContext_BetInKnockout _getselectioncontext_betinselection;
/*     */   public GetKnockOutContext_SettleStageBet _getselectioncontext_settlestagebet;
/*     */   public GetKnockOutContext_SettleRoleStageBet _getselectioncontext_settlerolestagebet;
/*     */   public CrossBattleFightType _crossbattlefighttype;
/*     */   public NormalResultRet _normalresultret;
/*     */   public GetKnockOutContext_NotifyFightResult _getknockoutcontext_notifyfightresult;
/*     */   public GetFightStageCorpsIdList_NotifyKnockOutCorpsId _getfightstagecorpsidlist_notifyknockoutcorpsid;
/*     */   public GetFightStageCorpsIdList_Award _getfightstagecorpsidlist_award;
/*     */   public GetFightStageCorpsIdList _getfightstagecorpsidlist;
/*     */   public GetKnockOutContext_Award _getknockoutcontext_award;
/*     */   public GetKnockOutContext_Refresh _getknockoutcontext_refresh;
/*     */   public GetKnockOutContext_FinalServerAward _getknockoutcontext_finalserveraward;
/*     */   public GetKnockOutContext_GetFinalHistoryFightInfo _getknockoutcontext_getfinalhistoryfightinfo;
/*     */   public GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo _getknockoutcontext_getfinalhistorytopthreecorpsinfo;
/*     */   public GetKnockOutContext_GetFinalChampionCorpsInfo _getknockoutcontext_getfinalchampioncorpsinfo;
/*     */   public GetFightStageEndCorpsInfo _getfightstageendcorpsinfo;
/*     */   public GetFightStageEndCorpsInfo_FinalHistory _getfightstageendcorpsinfo_finalhistory;
/*     */   public GetFightStageEndCorpsInfo_MapChampionStatue _getfightstageendcorpsinfo_mapchampionstatue;
/*     */   
/*     */   public CrossBattleSelectionConsts()
/*     */   {
/*  38 */     this._getselectioncontext = new GetKnockOutContext();
/*  39 */     this._getladderrankrangedonecontext_clientreq = new GetKnockOutContext_CheckPanelReq();
/*  40 */     this._getselectioncontext_getspecialfightzonestage = new GetKnockOutContext_GetSpecialFightZoneStage();
/*  41 */     this._getselectioncontext_createprepareworld = new GetKnockOutContext_CreatePrepareWorld();
/*  42 */     this._getknockoutcontext_reportfightresult = new GetKnockOutContext_ReportFightResult();
/*  43 */     this._singlefightresult = new SingleFightResult();
/*  44 */     this._calfightresult = new CalFightResult();
/*  45 */     this._getselectioncontext_getstagebetinfo = new GetKnockOutContext_GetStageBetInfo();
/*  46 */     this._getselectioncontext_getfightzoneinfo = new GetKnockOutContext_GetFightZoneInfo();
/*  47 */     this._getselectioncontext_betinselection = new GetKnockOutContext_BetInKnockout();
/*  48 */     this._getselectioncontext_settlestagebet = new GetKnockOutContext_SettleStageBet();
/*  49 */     this._getselectioncontext_settlerolestagebet = new GetKnockOutContext_SettleRoleStageBet();
/*  50 */     this._crossbattlefighttype = new CrossBattleFightType();
/*  51 */     this._normalresultret = new NormalResultRet();
/*  52 */     this._getknockoutcontext_notifyfightresult = new GetKnockOutContext_NotifyFightResult();
/*  53 */     this._getfightstagecorpsidlist_notifyknockoutcorpsid = new GetFightStageCorpsIdList_NotifyKnockOutCorpsId();
/*  54 */     this._getfightstagecorpsidlist_award = new GetFightStageCorpsIdList_Award();
/*  55 */     this._getfightstagecorpsidlist = new GetFightStageCorpsIdList();
/*  56 */     this._getknockoutcontext_award = new GetKnockOutContext_Award();
/*  57 */     this._getknockoutcontext_refresh = new GetKnockOutContext_Refresh();
/*  58 */     this._getknockoutcontext_finalserveraward = new GetKnockOutContext_FinalServerAward();
/*  59 */     this._getknockoutcontext_getfinalhistoryfightinfo = new GetKnockOutContext_GetFinalHistoryFightInfo();
/*  60 */     this._getknockoutcontext_getfinalhistorytopthreecorpsinfo = new GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo();
/*  61 */     this._getknockoutcontext_getfinalchampioncorpsinfo = new GetKnockOutContext_GetFinalChampionCorpsInfo();
/*  62 */     this._getfightstageendcorpsinfo = new GetFightStageEndCorpsInfo();
/*  63 */     this._getfightstageendcorpsinfo_finalhistory = new GetFightStageEndCorpsInfo_FinalHistory();
/*  64 */     this._getfightstageendcorpsinfo_mapchampionstatue = new GetFightStageEndCorpsInfo_MapChampionStatue();
/*     */   }
/*     */   
/*     */   public CrossBattleSelectionConsts(GetKnockOutContext __getselectioncontext_, GetKnockOutContext_CheckPanelReq __getladderrankrangedonecontext_clientreq_, GetKnockOutContext_GetSpecialFightZoneStage __getselectioncontext_getspecialfightzonestage_, GetKnockOutContext_CreatePrepareWorld __getselectioncontext_createprepareworld_, GetKnockOutContext_ReportFightResult __getknockoutcontext_reportfightresult_, SingleFightResult __singlefightresult_, CalFightResult __calfightresult_, GetKnockOutContext_GetStageBetInfo __getselectioncontext_getstagebetinfo_, GetKnockOutContext_GetFightZoneInfo __getselectioncontext_getfightzoneinfo_, GetKnockOutContext_BetInKnockout __getselectioncontext_betinselection_, GetKnockOutContext_SettleStageBet __getselectioncontext_settlestagebet_, GetKnockOutContext_SettleRoleStageBet __getselectioncontext_settlerolestagebet_, CrossBattleFightType __crossbattlefighttype_, NormalResultRet __normalresultret_, GetKnockOutContext_NotifyFightResult __getknockoutcontext_notifyfightresult_, GetFightStageCorpsIdList_NotifyKnockOutCorpsId __getfightstagecorpsidlist_notifyknockoutcorpsid_, GetFightStageCorpsIdList_Award __getfightstagecorpsidlist_award_, GetFightStageCorpsIdList __getfightstagecorpsidlist_, GetKnockOutContext_Award __getknockoutcontext_award_, GetKnockOutContext_Refresh __getknockoutcontext_refresh_, GetKnockOutContext_FinalServerAward __getknockoutcontext_finalserveraward_, GetKnockOutContext_GetFinalHistoryFightInfo __getknockoutcontext_getfinalhistoryfightinfo_, GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo __getknockoutcontext_getfinalhistorytopthreecorpsinfo_, GetKnockOutContext_GetFinalChampionCorpsInfo __getknockoutcontext_getfinalchampioncorpsinfo_, GetFightStageEndCorpsInfo __getfightstageendcorpsinfo_, GetFightStageEndCorpsInfo_FinalHistory __getfightstageendcorpsinfo_finalhistory_, GetFightStageEndCorpsInfo_MapChampionStatue __getfightstageendcorpsinfo_mapchampionstatue_) {
/*  68 */     this._getselectioncontext = __getselectioncontext_;
/*  69 */     this._getladderrankrangedonecontext_clientreq = __getladderrankrangedonecontext_clientreq_;
/*  70 */     this._getselectioncontext_getspecialfightzonestage = __getselectioncontext_getspecialfightzonestage_;
/*  71 */     this._getselectioncontext_createprepareworld = __getselectioncontext_createprepareworld_;
/*  72 */     this._getknockoutcontext_reportfightresult = __getknockoutcontext_reportfightresult_;
/*  73 */     this._singlefightresult = __singlefightresult_;
/*  74 */     this._calfightresult = __calfightresult_;
/*  75 */     this._getselectioncontext_getstagebetinfo = __getselectioncontext_getstagebetinfo_;
/*  76 */     this._getselectioncontext_getfightzoneinfo = __getselectioncontext_getfightzoneinfo_;
/*  77 */     this._getselectioncontext_betinselection = __getselectioncontext_betinselection_;
/*  78 */     this._getselectioncontext_settlestagebet = __getselectioncontext_settlestagebet_;
/*  79 */     this._getselectioncontext_settlerolestagebet = __getselectioncontext_settlerolestagebet_;
/*  80 */     this._crossbattlefighttype = __crossbattlefighttype_;
/*  81 */     this._normalresultret = __normalresultret_;
/*  82 */     this._getknockoutcontext_notifyfightresult = __getknockoutcontext_notifyfightresult_;
/*  83 */     this._getfightstagecorpsidlist_notifyknockoutcorpsid = __getfightstagecorpsidlist_notifyknockoutcorpsid_;
/*  84 */     this._getfightstagecorpsidlist_award = __getfightstagecorpsidlist_award_;
/*  85 */     this._getfightstagecorpsidlist = __getfightstagecorpsidlist_;
/*  86 */     this._getknockoutcontext_award = __getknockoutcontext_award_;
/*  87 */     this._getknockoutcontext_refresh = __getknockoutcontext_refresh_;
/*  88 */     this._getknockoutcontext_finalserveraward = __getknockoutcontext_finalserveraward_;
/*  89 */     this._getknockoutcontext_getfinalhistoryfightinfo = __getknockoutcontext_getfinalhistoryfightinfo_;
/*  90 */     this._getknockoutcontext_getfinalhistorytopthreecorpsinfo = __getknockoutcontext_getfinalhistorytopthreecorpsinfo_;
/*  91 */     this._getknockoutcontext_getfinalchampioncorpsinfo = __getknockoutcontext_getfinalchampioncorpsinfo_;
/*  92 */     this._getfightstageendcorpsinfo = __getfightstageendcorpsinfo_;
/*  93 */     this._getfightstageendcorpsinfo_finalhistory = __getfightstageendcorpsinfo_finalhistory_;
/*  94 */     this._getfightstageendcorpsinfo_mapchampionstatue = __getfightstageendcorpsinfo_mapchampionstatue_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  98 */     if (!this._getselectioncontext._validator_()) return false;
/*  99 */     if (!this._getladderrankrangedonecontext_clientreq._validator_()) return false;
/* 100 */     if (!this._getselectioncontext_getspecialfightzonestage._validator_()) return false;
/* 101 */     if (!this._getselectioncontext_createprepareworld._validator_()) return false;
/* 102 */     if (!this._getknockoutcontext_reportfightresult._validator_()) return false;
/* 103 */     if (!this._singlefightresult._validator_()) return false;
/* 104 */     if (!this._calfightresult._validator_()) return false;
/* 105 */     if (!this._getselectioncontext_getstagebetinfo._validator_()) return false;
/* 106 */     if (!this._getselectioncontext_getfightzoneinfo._validator_()) return false;
/* 107 */     if (!this._getselectioncontext_betinselection._validator_()) return false;
/* 108 */     if (!this._getselectioncontext_settlestagebet._validator_()) return false;
/* 109 */     if (!this._getselectioncontext_settlerolestagebet._validator_()) return false;
/* 110 */     if (!this._crossbattlefighttype._validator_()) return false;
/* 111 */     if (!this._normalresultret._validator_()) return false;
/* 112 */     if (!this._getknockoutcontext_notifyfightresult._validator_()) return false;
/* 113 */     if (!this._getfightstagecorpsidlist_notifyknockoutcorpsid._validator_()) return false;
/* 114 */     if (!this._getfightstagecorpsidlist_award._validator_()) return false;
/* 115 */     if (!this._getfightstagecorpsidlist._validator_()) return false;
/* 116 */     if (!this._getknockoutcontext_award._validator_()) return false;
/* 117 */     if (!this._getknockoutcontext_refresh._validator_()) return false;
/* 118 */     if (!this._getknockoutcontext_finalserveraward._validator_()) return false;
/* 119 */     if (!this._getknockoutcontext_getfinalhistoryfightinfo._validator_()) return false;
/* 120 */     if (!this._getknockoutcontext_getfinalhistorytopthreecorpsinfo._validator_()) return false;
/* 121 */     if (!this._getknockoutcontext_getfinalchampioncorpsinfo._validator_()) return false;
/* 122 */     if (!this._getfightstageendcorpsinfo._validator_()) return false;
/* 123 */     if (!this._getfightstageendcorpsinfo_finalhistory._validator_()) return false;
/* 124 */     if (!this._getfightstageendcorpsinfo_mapchampionstatue._validator_()) return false;
/* 125 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 129 */     _os_.marshal(this._getselectioncontext);
/* 130 */     _os_.marshal(this._getladderrankrangedonecontext_clientreq);
/* 131 */     _os_.marshal(this._getselectioncontext_getspecialfightzonestage);
/* 132 */     _os_.marshal(this._getselectioncontext_createprepareworld);
/* 133 */     _os_.marshal(this._getknockoutcontext_reportfightresult);
/* 134 */     _os_.marshal(this._singlefightresult);
/* 135 */     _os_.marshal(this._calfightresult);
/* 136 */     _os_.marshal(this._getselectioncontext_getstagebetinfo);
/* 137 */     _os_.marshal(this._getselectioncontext_getfightzoneinfo);
/* 138 */     _os_.marshal(this._getselectioncontext_betinselection);
/* 139 */     _os_.marshal(this._getselectioncontext_settlestagebet);
/* 140 */     _os_.marshal(this._getselectioncontext_settlerolestagebet);
/* 141 */     _os_.marshal(this._crossbattlefighttype);
/* 142 */     _os_.marshal(this._normalresultret);
/* 143 */     _os_.marshal(this._getknockoutcontext_notifyfightresult);
/* 144 */     _os_.marshal(this._getfightstagecorpsidlist_notifyknockoutcorpsid);
/* 145 */     _os_.marshal(this._getfightstagecorpsidlist_award);
/* 146 */     _os_.marshal(this._getfightstagecorpsidlist);
/* 147 */     _os_.marshal(this._getknockoutcontext_award);
/* 148 */     _os_.marshal(this._getknockoutcontext_refresh);
/* 149 */     _os_.marshal(this._getknockoutcontext_finalserveraward);
/* 150 */     _os_.marshal(this._getknockoutcontext_getfinalhistoryfightinfo);
/* 151 */     _os_.marshal(this._getknockoutcontext_getfinalhistorytopthreecorpsinfo);
/* 152 */     _os_.marshal(this._getknockoutcontext_getfinalchampioncorpsinfo);
/* 153 */     _os_.marshal(this._getfightstageendcorpsinfo);
/* 154 */     _os_.marshal(this._getfightstageendcorpsinfo_finalhistory);
/* 155 */     _os_.marshal(this._getfightstageendcorpsinfo_mapchampionstatue);
/* 156 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 160 */     this._getselectioncontext.unmarshal(_os_);
/* 161 */     this._getladderrankrangedonecontext_clientreq.unmarshal(_os_);
/* 162 */     this._getselectioncontext_getspecialfightzonestage.unmarshal(_os_);
/* 163 */     this._getselectioncontext_createprepareworld.unmarshal(_os_);
/* 164 */     this._getknockoutcontext_reportfightresult.unmarshal(_os_);
/* 165 */     this._singlefightresult.unmarshal(_os_);
/* 166 */     this._calfightresult.unmarshal(_os_);
/* 167 */     this._getselectioncontext_getstagebetinfo.unmarshal(_os_);
/* 168 */     this._getselectioncontext_getfightzoneinfo.unmarshal(_os_);
/* 169 */     this._getselectioncontext_betinselection.unmarshal(_os_);
/* 170 */     this._getselectioncontext_settlestagebet.unmarshal(_os_);
/* 171 */     this._getselectioncontext_settlerolestagebet.unmarshal(_os_);
/* 172 */     this._crossbattlefighttype.unmarshal(_os_);
/* 173 */     this._normalresultret.unmarshal(_os_);
/* 174 */     this._getknockoutcontext_notifyfightresult.unmarshal(_os_);
/* 175 */     this._getfightstagecorpsidlist_notifyknockoutcorpsid.unmarshal(_os_);
/* 176 */     this._getfightstagecorpsidlist_award.unmarshal(_os_);
/* 177 */     this._getfightstagecorpsidlist.unmarshal(_os_);
/* 178 */     this._getknockoutcontext_award.unmarshal(_os_);
/* 179 */     this._getknockoutcontext_refresh.unmarshal(_os_);
/* 180 */     this._getknockoutcontext_finalserveraward.unmarshal(_os_);
/* 181 */     this._getknockoutcontext_getfinalhistoryfightinfo.unmarshal(_os_);
/* 182 */     this._getknockoutcontext_getfinalhistorytopthreecorpsinfo.unmarshal(_os_);
/* 183 */     this._getknockoutcontext_getfinalchampioncorpsinfo.unmarshal(_os_);
/* 184 */     this._getfightstageendcorpsinfo.unmarshal(_os_);
/* 185 */     this._getfightstageendcorpsinfo_finalhistory.unmarshal(_os_);
/* 186 */     this._getfightstageendcorpsinfo_mapchampionstatue.unmarshal(_os_);
/* 187 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 191 */     if (_o1_ == this) return true;
/* 192 */     if ((_o1_ instanceof CrossBattleSelectionConsts)) {
/* 193 */       CrossBattleSelectionConsts _o_ = (CrossBattleSelectionConsts)_o1_;
/* 194 */       if (!this._getselectioncontext.equals(_o_._getselectioncontext)) return false;
/* 195 */       if (!this._getladderrankrangedonecontext_clientreq.equals(_o_._getladderrankrangedonecontext_clientreq)) return false;
/* 196 */       if (!this._getselectioncontext_getspecialfightzonestage.equals(_o_._getselectioncontext_getspecialfightzonestage)) return false;
/* 197 */       if (!this._getselectioncontext_createprepareworld.equals(_o_._getselectioncontext_createprepareworld)) return false;
/* 198 */       if (!this._getknockoutcontext_reportfightresult.equals(_o_._getknockoutcontext_reportfightresult)) return false;
/* 199 */       if (!this._singlefightresult.equals(_o_._singlefightresult)) return false;
/* 200 */       if (!this._calfightresult.equals(_o_._calfightresult)) return false;
/* 201 */       if (!this._getselectioncontext_getstagebetinfo.equals(_o_._getselectioncontext_getstagebetinfo)) return false;
/* 202 */       if (!this._getselectioncontext_getfightzoneinfo.equals(_o_._getselectioncontext_getfightzoneinfo)) return false;
/* 203 */       if (!this._getselectioncontext_betinselection.equals(_o_._getselectioncontext_betinselection)) return false;
/* 204 */       if (!this._getselectioncontext_settlestagebet.equals(_o_._getselectioncontext_settlestagebet)) return false;
/* 205 */       if (!this._getselectioncontext_settlerolestagebet.equals(_o_._getselectioncontext_settlerolestagebet)) return false;
/* 206 */       if (!this._crossbattlefighttype.equals(_o_._crossbattlefighttype)) return false;
/* 207 */       if (!this._normalresultret.equals(_o_._normalresultret)) return false;
/* 208 */       if (!this._getknockoutcontext_notifyfightresult.equals(_o_._getknockoutcontext_notifyfightresult)) return false;
/* 209 */       if (!this._getfightstagecorpsidlist_notifyknockoutcorpsid.equals(_o_._getfightstagecorpsidlist_notifyknockoutcorpsid)) return false;
/* 210 */       if (!this._getfightstagecorpsidlist_award.equals(_o_._getfightstagecorpsidlist_award)) return false;
/* 211 */       if (!this._getfightstagecorpsidlist.equals(_o_._getfightstagecorpsidlist)) return false;
/* 212 */       if (!this._getknockoutcontext_award.equals(_o_._getknockoutcontext_award)) return false;
/* 213 */       if (!this._getknockoutcontext_refresh.equals(_o_._getknockoutcontext_refresh)) return false;
/* 214 */       if (!this._getknockoutcontext_finalserveraward.equals(_o_._getknockoutcontext_finalserveraward)) return false;
/* 215 */       if (!this._getknockoutcontext_getfinalhistoryfightinfo.equals(_o_._getknockoutcontext_getfinalhistoryfightinfo)) return false;
/* 216 */       if (!this._getknockoutcontext_getfinalhistorytopthreecorpsinfo.equals(_o_._getknockoutcontext_getfinalhistorytopthreecorpsinfo)) return false;
/* 217 */       if (!this._getknockoutcontext_getfinalchampioncorpsinfo.equals(_o_._getknockoutcontext_getfinalchampioncorpsinfo)) return false;
/* 218 */       if (!this._getfightstageendcorpsinfo.equals(_o_._getfightstageendcorpsinfo)) return false;
/* 219 */       if (!this._getfightstageendcorpsinfo_finalhistory.equals(_o_._getfightstageendcorpsinfo_finalhistory)) return false;
/* 220 */       if (!this._getfightstageendcorpsinfo_mapchampionstatue.equals(_o_._getfightstageendcorpsinfo_mapchampionstatue)) return false;
/* 221 */       return true;
/*     */     }
/* 223 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 227 */     int _h_ = 0;
/* 228 */     _h_ += this._getselectioncontext.hashCode();
/* 229 */     _h_ += this._getladderrankrangedonecontext_clientreq.hashCode();
/* 230 */     _h_ += this._getselectioncontext_getspecialfightzonestage.hashCode();
/* 231 */     _h_ += this._getselectioncontext_createprepareworld.hashCode();
/* 232 */     _h_ += this._getknockoutcontext_reportfightresult.hashCode();
/* 233 */     _h_ += this._singlefightresult.hashCode();
/* 234 */     _h_ += this._calfightresult.hashCode();
/* 235 */     _h_ += this._getselectioncontext_getstagebetinfo.hashCode();
/* 236 */     _h_ += this._getselectioncontext_getfightzoneinfo.hashCode();
/* 237 */     _h_ += this._getselectioncontext_betinselection.hashCode();
/* 238 */     _h_ += this._getselectioncontext_settlestagebet.hashCode();
/* 239 */     _h_ += this._getselectioncontext_settlerolestagebet.hashCode();
/* 240 */     _h_ += this._crossbattlefighttype.hashCode();
/* 241 */     _h_ += this._normalresultret.hashCode();
/* 242 */     _h_ += this._getknockoutcontext_notifyfightresult.hashCode();
/* 243 */     _h_ += this._getfightstagecorpsidlist_notifyknockoutcorpsid.hashCode();
/* 244 */     _h_ += this._getfightstagecorpsidlist_award.hashCode();
/* 245 */     _h_ += this._getfightstagecorpsidlist.hashCode();
/* 246 */     _h_ += this._getknockoutcontext_award.hashCode();
/* 247 */     _h_ += this._getknockoutcontext_refresh.hashCode();
/* 248 */     _h_ += this._getknockoutcontext_finalserveraward.hashCode();
/* 249 */     _h_ += this._getknockoutcontext_getfinalhistoryfightinfo.hashCode();
/* 250 */     _h_ += this._getknockoutcontext_getfinalhistorytopthreecorpsinfo.hashCode();
/* 251 */     _h_ += this._getknockoutcontext_getfinalchampioncorpsinfo.hashCode();
/* 252 */     _h_ += this._getfightstageendcorpsinfo.hashCode();
/* 253 */     _h_ += this._getfightstageendcorpsinfo_finalhistory.hashCode();
/* 254 */     _h_ += this._getfightstageendcorpsinfo_mapchampionstatue.hashCode();
/* 255 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 259 */     StringBuilder _sb_ = new StringBuilder();
/* 260 */     _sb_.append("(");
/* 261 */     _sb_.append(this._getselectioncontext).append(",");
/* 262 */     _sb_.append(this._getladderrankrangedonecontext_clientreq).append(",");
/* 263 */     _sb_.append(this._getselectioncontext_getspecialfightzonestage).append(",");
/* 264 */     _sb_.append(this._getselectioncontext_createprepareworld).append(",");
/* 265 */     _sb_.append(this._getknockoutcontext_reportfightresult).append(",");
/* 266 */     _sb_.append(this._singlefightresult).append(",");
/* 267 */     _sb_.append(this._calfightresult).append(",");
/* 268 */     _sb_.append(this._getselectioncontext_getstagebetinfo).append(",");
/* 269 */     _sb_.append(this._getselectioncontext_getfightzoneinfo).append(",");
/* 270 */     _sb_.append(this._getselectioncontext_betinselection).append(",");
/* 271 */     _sb_.append(this._getselectioncontext_settlestagebet).append(",");
/* 272 */     _sb_.append(this._getselectioncontext_settlerolestagebet).append(",");
/* 273 */     _sb_.append(this._crossbattlefighttype).append(",");
/* 274 */     _sb_.append(this._normalresultret).append(",");
/* 275 */     _sb_.append(this._getknockoutcontext_notifyfightresult).append(",");
/* 276 */     _sb_.append(this._getfightstagecorpsidlist_notifyknockoutcorpsid).append(",");
/* 277 */     _sb_.append(this._getfightstagecorpsidlist_award).append(",");
/* 278 */     _sb_.append(this._getfightstagecorpsidlist).append(",");
/* 279 */     _sb_.append(this._getknockoutcontext_award).append(",");
/* 280 */     _sb_.append(this._getknockoutcontext_refresh).append(",");
/* 281 */     _sb_.append(this._getknockoutcontext_finalserveraward).append(",");
/* 282 */     _sb_.append(this._getknockoutcontext_getfinalhistoryfightinfo).append(",");
/* 283 */     _sb_.append(this._getknockoutcontext_getfinalhistorytopthreecorpsinfo).append(",");
/* 284 */     _sb_.append(this._getknockoutcontext_getfinalchampioncorpsinfo).append(",");
/* 285 */     _sb_.append(this._getfightstageendcorpsinfo).append(",");
/* 286 */     _sb_.append(this._getfightstageendcorpsinfo_finalhistory).append(",");
/* 287 */     _sb_.append(this._getfightstageendcorpsinfo_mapchampionstatue).append(",");
/* 288 */     _sb_.append(")");
/* 289 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CrossBattleSelectionConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */