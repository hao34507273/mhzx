/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xbean.Pod;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableMap;
/*      */ 
/*      */ public final class SkillResult extends XBean implements xbean.SkillResult
/*      */ {
/*      */   private HashMap<Integer, Integer> skillkillcountinfight;
/*      */   private HashMap<Integer, Integer> skilltargetismaininfight;
/*      */   private HashMap<Integer, Integer> skillkillreborncountinfight;
/*      */   private HashMap<Integer, Integer> skillbedodgecountinfight;
/*      */   private HashMap<Integer, Integer> skillcriticalcountinround;
/*      */   private HashMap<Integer, Integer> skillkillcountinround;
/*      */   private HashMap<Integer, Integer> skilltargethplesscountinfight;
/*      */   private HashMap<Integer, xbean.SkillResultKillMonsterInfo> killmonster;
/*      */   private HashMap<Integer, Integer> skillfailedcountinfight;
/*      */   private HashMap<Integer, xbean.SkillReleaseRoundInfos> skillreleaseroundsinfight;
/*      */   private HashMap<Integer, xbean.SkillResultAttackTimes> skillattacktimesinfight;
/*      */   private HashMap<Integer, xbean.SkillResultHitMains> skillhitmaintargetinfight;
/*      */   private HashMap<Integer, xbean.SkillBuffResult> skillbuffinfight;
/*      */   private HashMap<Integer, xbean.SkillMirrorInfo> skillmirrorinfoinfight;
/*      */   private ArrayList<xbean.SkillShareDamageKillInfo> skillandsharedamagekillinfight;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   46 */     this.skillkillcountinfight.clear();
/*   47 */     this.skilltargetismaininfight.clear();
/*   48 */     this.skillkillreborncountinfight.clear();
/*   49 */     this.skillbedodgecountinfight.clear();
/*   50 */     this.skillcriticalcountinround.clear();
/*   51 */     this.skillkillcountinround.clear();
/*   52 */     this.skilltargethplesscountinfight.clear();
/*   53 */     this.killmonster.clear();
/*   54 */     this.skillfailedcountinfight.clear();
/*   55 */     this.skillreleaseroundsinfight.clear();
/*   56 */     this.skillattacktimesinfight.clear();
/*   57 */     this.skillhitmaintargetinfight.clear();
/*   58 */     this.skillbuffinfight.clear();
/*   59 */     this.skillmirrorinfoinfight.clear();
/*   60 */     this.skillandsharedamagekillinfight.clear();
/*      */   }
/*      */   
/*      */   SkillResult(int __, XBean _xp_, String _vn_)
/*      */   {
/*   65 */     super(_xp_, _vn_);
/*   66 */     this.skillkillcountinfight = new HashMap();
/*   67 */     this.skilltargetismaininfight = new HashMap();
/*   68 */     this.skillkillreborncountinfight = new HashMap();
/*   69 */     this.skillbedodgecountinfight = new HashMap();
/*   70 */     this.skillcriticalcountinround = new HashMap();
/*   71 */     this.skillkillcountinround = new HashMap();
/*   72 */     this.skilltargethplesscountinfight = new HashMap();
/*   73 */     this.killmonster = new HashMap();
/*   74 */     this.skillfailedcountinfight = new HashMap();
/*   75 */     this.skillreleaseroundsinfight = new HashMap();
/*   76 */     this.skillattacktimesinfight = new HashMap();
/*   77 */     this.skillhitmaintargetinfight = new HashMap();
/*   78 */     this.skillbuffinfight = new HashMap();
/*   79 */     this.skillmirrorinfoinfight = new HashMap();
/*   80 */     this.skillandsharedamagekillinfight = new ArrayList();
/*      */   }
/*      */   
/*      */   public SkillResult()
/*      */   {
/*   85 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public SkillResult(SkillResult _o_)
/*      */   {
/*   90 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   SkillResult(xbean.SkillResult _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   95 */     super(_xp_, _vn_);
/*   96 */     if ((_o1_ instanceof SkillResult)) { assign((SkillResult)_o1_);
/*   97 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   98 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   99 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(SkillResult _o_) {
/*  104 */     _o_._xdb_verify_unsafe_();
/*  105 */     this.skillkillcountinfight = new HashMap();
/*  106 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillcountinfight.entrySet())
/*  107 */       this.skillkillcountinfight.put(_e_.getKey(), _e_.getValue());
/*  108 */     this.skilltargetismaininfight = new HashMap();
/*  109 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skilltargetismaininfight.entrySet())
/*  110 */       this.skilltargetismaininfight.put(_e_.getKey(), _e_.getValue());
/*  111 */     this.skillkillreborncountinfight = new HashMap();
/*  112 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillreborncountinfight.entrySet())
/*  113 */       this.skillkillreborncountinfight.put(_e_.getKey(), _e_.getValue());
/*  114 */     this.skillbedodgecountinfight = new HashMap();
/*  115 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillbedodgecountinfight.entrySet())
/*  116 */       this.skillbedodgecountinfight.put(_e_.getKey(), _e_.getValue());
/*  117 */     this.skillcriticalcountinround = new HashMap();
/*  118 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillcriticalcountinround.entrySet())
/*  119 */       this.skillcriticalcountinround.put(_e_.getKey(), _e_.getValue());
/*  120 */     this.skillkillcountinround = new HashMap();
/*  121 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillcountinround.entrySet())
/*  122 */       this.skillkillcountinround.put(_e_.getKey(), _e_.getValue());
/*  123 */     this.skilltargethplesscountinfight = new HashMap();
/*  124 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skilltargethplesscountinfight.entrySet())
/*  125 */       this.skilltargethplesscountinfight.put(_e_.getKey(), _e_.getValue());
/*  126 */     this.killmonster = new HashMap();
/*  127 */     for (Map.Entry<Integer, xbean.SkillResultKillMonsterInfo> _e_ : _o_.killmonster.entrySet())
/*  128 */       this.killmonster.put(_e_.getKey(), new SkillResultKillMonsterInfo((xbean.SkillResultKillMonsterInfo)_e_.getValue(), this, "killmonster"));
/*  129 */     this.skillfailedcountinfight = new HashMap();
/*  130 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillfailedcountinfight.entrySet())
/*  131 */       this.skillfailedcountinfight.put(_e_.getKey(), _e_.getValue());
/*  132 */     this.skillreleaseroundsinfight = new HashMap();
/*  133 */     for (Map.Entry<Integer, xbean.SkillReleaseRoundInfos> _e_ : _o_.skillreleaseroundsinfight.entrySet())
/*  134 */       this.skillreleaseroundsinfight.put(_e_.getKey(), new SkillReleaseRoundInfos((xbean.SkillReleaseRoundInfos)_e_.getValue(), this, "skillreleaseroundsinfight"));
/*  135 */     this.skillattacktimesinfight = new HashMap();
/*  136 */     for (Map.Entry<Integer, xbean.SkillResultAttackTimes> _e_ : _o_.skillattacktimesinfight.entrySet())
/*  137 */       this.skillattacktimesinfight.put(_e_.getKey(), new SkillResultAttackTimes((xbean.SkillResultAttackTimes)_e_.getValue(), this, "skillattacktimesinfight"));
/*  138 */     this.skillhitmaintargetinfight = new HashMap();
/*  139 */     for (Map.Entry<Integer, xbean.SkillResultHitMains> _e_ : _o_.skillhitmaintargetinfight.entrySet())
/*  140 */       this.skillhitmaintargetinfight.put(_e_.getKey(), new SkillResultHitMains((xbean.SkillResultHitMains)_e_.getValue(), this, "skillhitmaintargetinfight"));
/*  141 */     this.skillbuffinfight = new HashMap();
/*  142 */     for (Map.Entry<Integer, xbean.SkillBuffResult> _e_ : _o_.skillbuffinfight.entrySet())
/*  143 */       this.skillbuffinfight.put(_e_.getKey(), new SkillBuffResult((xbean.SkillBuffResult)_e_.getValue(), this, "skillbuffinfight"));
/*  144 */     this.skillmirrorinfoinfight = new HashMap();
/*  145 */     for (Map.Entry<Integer, xbean.SkillMirrorInfo> _e_ : _o_.skillmirrorinfoinfight.entrySet())
/*  146 */       this.skillmirrorinfoinfight.put(_e_.getKey(), new SkillMirrorInfo((xbean.SkillMirrorInfo)_e_.getValue(), this, "skillmirrorinfoinfight"));
/*  147 */     this.skillandsharedamagekillinfight = new ArrayList();
/*  148 */     for (xbean.SkillShareDamageKillInfo _v_ : _o_.skillandsharedamagekillinfight) {
/*  149 */       this.skillandsharedamagekillinfight.add(new SkillShareDamageKillInfo(_v_, this, "skillandsharedamagekillinfight"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*  154 */     this.skillkillcountinfight = new HashMap();
/*  155 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillcountinfight.entrySet())
/*  156 */       this.skillkillcountinfight.put(_e_.getKey(), _e_.getValue());
/*  157 */     this.skilltargetismaininfight = new HashMap();
/*  158 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skilltargetismaininfight.entrySet())
/*  159 */       this.skilltargetismaininfight.put(_e_.getKey(), _e_.getValue());
/*  160 */     this.skillkillreborncountinfight = new HashMap();
/*  161 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillreborncountinfight.entrySet())
/*  162 */       this.skillkillreborncountinfight.put(_e_.getKey(), _e_.getValue());
/*  163 */     this.skillbedodgecountinfight = new HashMap();
/*  164 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillbedodgecountinfight.entrySet())
/*  165 */       this.skillbedodgecountinfight.put(_e_.getKey(), _e_.getValue());
/*  166 */     this.skillcriticalcountinround = new HashMap();
/*  167 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillcriticalcountinround.entrySet())
/*  168 */       this.skillcriticalcountinround.put(_e_.getKey(), _e_.getValue());
/*  169 */     this.skillkillcountinround = new HashMap();
/*  170 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillcountinround.entrySet())
/*  171 */       this.skillkillcountinround.put(_e_.getKey(), _e_.getValue());
/*  172 */     this.skilltargethplesscountinfight = new HashMap();
/*  173 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skilltargethplesscountinfight.entrySet())
/*  174 */       this.skilltargethplesscountinfight.put(_e_.getKey(), _e_.getValue());
/*  175 */     this.killmonster = new HashMap();
/*  176 */     for (Map.Entry<Integer, xbean.SkillResultKillMonsterInfo> _e_ : _o_.killmonster.entrySet())
/*  177 */       this.killmonster.put(_e_.getKey(), new SkillResultKillMonsterInfo((xbean.SkillResultKillMonsterInfo)_e_.getValue(), this, "killmonster"));
/*  178 */     this.skillfailedcountinfight = new HashMap();
/*  179 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillfailedcountinfight.entrySet())
/*  180 */       this.skillfailedcountinfight.put(_e_.getKey(), _e_.getValue());
/*  181 */     this.skillreleaseroundsinfight = new HashMap();
/*  182 */     for (Map.Entry<Integer, xbean.SkillReleaseRoundInfos> _e_ : _o_.skillreleaseroundsinfight.entrySet())
/*  183 */       this.skillreleaseroundsinfight.put(_e_.getKey(), new SkillReleaseRoundInfos((xbean.SkillReleaseRoundInfos)_e_.getValue(), this, "skillreleaseroundsinfight"));
/*  184 */     this.skillattacktimesinfight = new HashMap();
/*  185 */     for (Map.Entry<Integer, xbean.SkillResultAttackTimes> _e_ : _o_.skillattacktimesinfight.entrySet())
/*  186 */       this.skillattacktimesinfight.put(_e_.getKey(), new SkillResultAttackTimes((xbean.SkillResultAttackTimes)_e_.getValue(), this, "skillattacktimesinfight"));
/*  187 */     this.skillhitmaintargetinfight = new HashMap();
/*  188 */     for (Map.Entry<Integer, xbean.SkillResultHitMains> _e_ : _o_.skillhitmaintargetinfight.entrySet())
/*  189 */       this.skillhitmaintargetinfight.put(_e_.getKey(), new SkillResultHitMains((xbean.SkillResultHitMains)_e_.getValue(), this, "skillhitmaintargetinfight"));
/*  190 */     this.skillbuffinfight = new HashMap();
/*  191 */     for (Map.Entry<Integer, xbean.SkillBuffResult> _e_ : _o_.skillbuffinfight.entrySet())
/*  192 */       this.skillbuffinfight.put(_e_.getKey(), new SkillBuffResult((xbean.SkillBuffResult)_e_.getValue(), this, "skillbuffinfight"));
/*  193 */     this.skillmirrorinfoinfight = new HashMap();
/*  194 */     for (Map.Entry<Integer, xbean.SkillMirrorInfo> _e_ : _o_.skillmirrorinfoinfight.entrySet())
/*  195 */       this.skillmirrorinfoinfight.put(_e_.getKey(), new SkillMirrorInfo((xbean.SkillMirrorInfo)_e_.getValue(), this, "skillmirrorinfoinfight"));
/*  196 */     this.skillandsharedamagekillinfight = new ArrayList();
/*  197 */     for (xbean.SkillShareDamageKillInfo _v_ : _o_.skillandsharedamagekillinfight) {
/*  198 */       this.skillandsharedamagekillinfight.add(new SkillShareDamageKillInfo(_v_, this, "skillandsharedamagekillinfight"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  204 */     _xdb_verify_unsafe_();
/*  205 */     _os_.compact_uint32(this.skillkillcountinfight.size());
/*  206 */     for (Map.Entry<Integer, Integer> _e_ : this.skillkillcountinfight.entrySet())
/*      */     {
/*  208 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  209 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  211 */     _os_.compact_uint32(this.skilltargetismaininfight.size());
/*  212 */     for (Map.Entry<Integer, Integer> _e_ : this.skilltargetismaininfight.entrySet())
/*      */     {
/*  214 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  215 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  217 */     _os_.compact_uint32(this.skillkillreborncountinfight.size());
/*  218 */     for (Map.Entry<Integer, Integer> _e_ : this.skillkillreborncountinfight.entrySet())
/*      */     {
/*  220 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  221 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  223 */     _os_.compact_uint32(this.skillbedodgecountinfight.size());
/*  224 */     for (Map.Entry<Integer, Integer> _e_ : this.skillbedodgecountinfight.entrySet())
/*      */     {
/*  226 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  227 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  229 */     _os_.compact_uint32(this.skillcriticalcountinround.size());
/*  230 */     for (Map.Entry<Integer, Integer> _e_ : this.skillcriticalcountinround.entrySet())
/*      */     {
/*  232 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  233 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  235 */     _os_.compact_uint32(this.skillkillcountinround.size());
/*  236 */     for (Map.Entry<Integer, Integer> _e_ : this.skillkillcountinround.entrySet())
/*      */     {
/*  238 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  239 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  241 */     _os_.compact_uint32(this.skilltargethplesscountinfight.size());
/*  242 */     for (Map.Entry<Integer, Integer> _e_ : this.skilltargethplesscountinfight.entrySet())
/*      */     {
/*  244 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  245 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  247 */     _os_.compact_uint32(this.killmonster.size());
/*  248 */     for (Map.Entry<Integer, xbean.SkillResultKillMonsterInfo> _e_ : this.killmonster.entrySet())
/*      */     {
/*  250 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  251 */       ((xbean.SkillResultKillMonsterInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  253 */     _os_.compact_uint32(this.skillfailedcountinfight.size());
/*  254 */     for (Map.Entry<Integer, Integer> _e_ : this.skillfailedcountinfight.entrySet())
/*      */     {
/*  256 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  257 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  259 */     _os_.compact_uint32(this.skillreleaseroundsinfight.size());
/*  260 */     for (Map.Entry<Integer, xbean.SkillReleaseRoundInfos> _e_ : this.skillreleaseroundsinfight.entrySet())
/*      */     {
/*  262 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  263 */       ((xbean.SkillReleaseRoundInfos)_e_.getValue()).marshal(_os_);
/*      */     }
/*  265 */     _os_.compact_uint32(this.skillattacktimesinfight.size());
/*  266 */     for (Map.Entry<Integer, xbean.SkillResultAttackTimes> _e_ : this.skillattacktimesinfight.entrySet())
/*      */     {
/*  268 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  269 */       ((xbean.SkillResultAttackTimes)_e_.getValue()).marshal(_os_);
/*      */     }
/*  271 */     _os_.compact_uint32(this.skillhitmaintargetinfight.size());
/*  272 */     for (Map.Entry<Integer, xbean.SkillResultHitMains> _e_ : this.skillhitmaintargetinfight.entrySet())
/*      */     {
/*  274 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  275 */       ((xbean.SkillResultHitMains)_e_.getValue()).marshal(_os_);
/*      */     }
/*  277 */     _os_.compact_uint32(this.skillbuffinfight.size());
/*  278 */     for (Map.Entry<Integer, xbean.SkillBuffResult> _e_ : this.skillbuffinfight.entrySet())
/*      */     {
/*  280 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  281 */       ((xbean.SkillBuffResult)_e_.getValue()).marshal(_os_);
/*      */     }
/*  283 */     _os_.compact_uint32(this.skillmirrorinfoinfight.size());
/*  284 */     for (Map.Entry<Integer, xbean.SkillMirrorInfo> _e_ : this.skillmirrorinfoinfight.entrySet())
/*      */     {
/*  286 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  287 */       ((xbean.SkillMirrorInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  289 */     _os_.compact_uint32(this.skillandsharedamagekillinfight.size());
/*  290 */     for (xbean.SkillShareDamageKillInfo _v_ : this.skillandsharedamagekillinfight)
/*      */     {
/*  292 */       _v_.marshal(_os_);
/*      */     }
/*  294 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*      */     
/*  302 */     int size = _os_.uncompact_uint32();
/*  303 */     if (size >= 12)
/*      */     {
/*  305 */       this.skillkillcountinfight = new HashMap(size * 2);
/*      */     }
/*  307 */     for (; size > 0; size--)
/*      */     {
/*  309 */       int _k_ = 0;
/*  310 */       _k_ = _os_.unmarshal_int();
/*  311 */       int _v_ = 0;
/*  312 */       _v_ = _os_.unmarshal_int();
/*  313 */       this.skillkillcountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  317 */     int size = _os_.uncompact_uint32();
/*  318 */     if (size >= 12)
/*      */     {
/*  320 */       this.skilltargetismaininfight = new HashMap(size * 2);
/*      */     }
/*  322 */     for (; size > 0; size--)
/*      */     {
/*  324 */       int _k_ = 0;
/*  325 */       _k_ = _os_.unmarshal_int();
/*  326 */       int _v_ = 0;
/*  327 */       _v_ = _os_.unmarshal_int();
/*  328 */       this.skilltargetismaininfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  332 */     int size = _os_.uncompact_uint32();
/*  333 */     if (size >= 12)
/*      */     {
/*  335 */       this.skillkillreborncountinfight = new HashMap(size * 2);
/*      */     }
/*  337 */     for (; size > 0; size--)
/*      */     {
/*  339 */       int _k_ = 0;
/*  340 */       _k_ = _os_.unmarshal_int();
/*  341 */       int _v_ = 0;
/*  342 */       _v_ = _os_.unmarshal_int();
/*  343 */       this.skillkillreborncountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  347 */     int size = _os_.uncompact_uint32();
/*  348 */     if (size >= 12)
/*      */     {
/*  350 */       this.skillbedodgecountinfight = new HashMap(size * 2);
/*      */     }
/*  352 */     for (; size > 0; size--)
/*      */     {
/*  354 */       int _k_ = 0;
/*  355 */       _k_ = _os_.unmarshal_int();
/*  356 */       int _v_ = 0;
/*  357 */       _v_ = _os_.unmarshal_int();
/*  358 */       this.skillbedodgecountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  362 */     int size = _os_.uncompact_uint32();
/*  363 */     if (size >= 12)
/*      */     {
/*  365 */       this.skillcriticalcountinround = new HashMap(size * 2);
/*      */     }
/*  367 */     for (; size > 0; size--)
/*      */     {
/*  369 */       int _k_ = 0;
/*  370 */       _k_ = _os_.unmarshal_int();
/*  371 */       int _v_ = 0;
/*  372 */       _v_ = _os_.unmarshal_int();
/*  373 */       this.skillcriticalcountinround.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  377 */     int size = _os_.uncompact_uint32();
/*  378 */     if (size >= 12)
/*      */     {
/*  380 */       this.skillkillcountinround = new HashMap(size * 2);
/*      */     }
/*  382 */     for (; size > 0; size--)
/*      */     {
/*  384 */       int _k_ = 0;
/*  385 */       _k_ = _os_.unmarshal_int();
/*  386 */       int _v_ = 0;
/*  387 */       _v_ = _os_.unmarshal_int();
/*  388 */       this.skillkillcountinround.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  392 */     int size = _os_.uncompact_uint32();
/*  393 */     if (size >= 12)
/*      */     {
/*  395 */       this.skilltargethplesscountinfight = new HashMap(size * 2);
/*      */     }
/*  397 */     for (; size > 0; size--)
/*      */     {
/*  399 */       int _k_ = 0;
/*  400 */       _k_ = _os_.unmarshal_int();
/*  401 */       int _v_ = 0;
/*  402 */       _v_ = _os_.unmarshal_int();
/*  403 */       this.skilltargethplesscountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  407 */     int size = _os_.uncompact_uint32();
/*  408 */     if (size >= 12)
/*      */     {
/*  410 */       this.killmonster = new HashMap(size * 2);
/*      */     }
/*  412 */     for (; size > 0; size--)
/*      */     {
/*  414 */       int _k_ = 0;
/*  415 */       _k_ = _os_.unmarshal_int();
/*  416 */       xbean.SkillResultKillMonsterInfo _v_ = new SkillResultKillMonsterInfo(0, this, "killmonster");
/*  417 */       _v_.unmarshal(_os_);
/*  418 */       this.killmonster.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  422 */     int size = _os_.uncompact_uint32();
/*  423 */     if (size >= 12)
/*      */     {
/*  425 */       this.skillfailedcountinfight = new HashMap(size * 2);
/*      */     }
/*  427 */     for (; size > 0; size--)
/*      */     {
/*  429 */       int _k_ = 0;
/*  430 */       _k_ = _os_.unmarshal_int();
/*  431 */       int _v_ = 0;
/*  432 */       _v_ = _os_.unmarshal_int();
/*  433 */       this.skillfailedcountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  437 */     int size = _os_.uncompact_uint32();
/*  438 */     if (size >= 12)
/*      */     {
/*  440 */       this.skillreleaseroundsinfight = new HashMap(size * 2);
/*      */     }
/*  442 */     for (; size > 0; size--)
/*      */     {
/*  444 */       int _k_ = 0;
/*  445 */       _k_ = _os_.unmarshal_int();
/*  446 */       xbean.SkillReleaseRoundInfos _v_ = new SkillReleaseRoundInfos(0, this, "skillreleaseroundsinfight");
/*  447 */       _v_.unmarshal(_os_);
/*  448 */       this.skillreleaseroundsinfight.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  452 */     int size = _os_.uncompact_uint32();
/*  453 */     if (size >= 12)
/*      */     {
/*  455 */       this.skillattacktimesinfight = new HashMap(size * 2);
/*      */     }
/*  457 */     for (; size > 0; size--)
/*      */     {
/*  459 */       int _k_ = 0;
/*  460 */       _k_ = _os_.unmarshal_int();
/*  461 */       xbean.SkillResultAttackTimes _v_ = new SkillResultAttackTimes(0, this, "skillattacktimesinfight");
/*  462 */       _v_.unmarshal(_os_);
/*  463 */       this.skillattacktimesinfight.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  467 */     int size = _os_.uncompact_uint32();
/*  468 */     if (size >= 12)
/*      */     {
/*  470 */       this.skillhitmaintargetinfight = new HashMap(size * 2);
/*      */     }
/*  472 */     for (; size > 0; size--)
/*      */     {
/*  474 */       int _k_ = 0;
/*  475 */       _k_ = _os_.unmarshal_int();
/*  476 */       xbean.SkillResultHitMains _v_ = new SkillResultHitMains(0, this, "skillhitmaintargetinfight");
/*  477 */       _v_.unmarshal(_os_);
/*  478 */       this.skillhitmaintargetinfight.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  482 */     int size = _os_.uncompact_uint32();
/*  483 */     if (size >= 12)
/*      */     {
/*  485 */       this.skillbuffinfight = new HashMap(size * 2);
/*      */     }
/*  487 */     for (; size > 0; size--)
/*      */     {
/*  489 */       int _k_ = 0;
/*  490 */       _k_ = _os_.unmarshal_int();
/*  491 */       xbean.SkillBuffResult _v_ = new SkillBuffResult(0, this, "skillbuffinfight");
/*  492 */       _v_.unmarshal(_os_);
/*  493 */       this.skillbuffinfight.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  497 */     int size = _os_.uncompact_uint32();
/*  498 */     if (size >= 12)
/*      */     {
/*  500 */       this.skillmirrorinfoinfight = new HashMap(size * 2);
/*      */     }
/*  502 */     for (; size > 0; size--)
/*      */     {
/*  504 */       int _k_ = 0;
/*  505 */       _k_ = _os_.unmarshal_int();
/*  506 */       xbean.SkillMirrorInfo _v_ = new SkillMirrorInfo(0, this, "skillmirrorinfoinfight");
/*  507 */       _v_.unmarshal(_os_);
/*  508 */       this.skillmirrorinfoinfight.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  511 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  513 */       xbean.SkillShareDamageKillInfo _v_ = new SkillShareDamageKillInfo(0, this, "skillandsharedamagekillinfight");
/*  514 */       _v_.unmarshal(_os_);
/*  515 */       this.skillandsharedamagekillinfight.add(_v_);
/*      */     }
/*  517 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  523 */     _xdb_verify_unsafe_();
/*  524 */     int _size_ = 0;
/*  525 */     for (Map.Entry<Integer, Integer> _e_ : this.skillkillcountinfight.entrySet())
/*      */     {
/*  527 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  528 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  530 */     for (Map.Entry<Integer, Integer> _e_ : this.skilltargetismaininfight.entrySet())
/*      */     {
/*  532 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  533 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  535 */     for (Map.Entry<Integer, Integer> _e_ : this.skillkillreborncountinfight.entrySet())
/*      */     {
/*  537 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  538 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  540 */     for (Map.Entry<Integer, Integer> _e_ : this.skillbedodgecountinfight.entrySet())
/*      */     {
/*  542 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  543 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  545 */     for (Map.Entry<Integer, Integer> _e_ : this.skillcriticalcountinround.entrySet())
/*      */     {
/*  547 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  548 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  550 */     for (Map.Entry<Integer, Integer> _e_ : this.skillkillcountinround.entrySet())
/*      */     {
/*  552 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  553 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  555 */     for (Map.Entry<Integer, Integer> _e_ : this.skilltargethplesscountinfight.entrySet())
/*      */     {
/*  557 */       _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/*  558 */       _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  560 */     for (Map.Entry<Integer, xbean.SkillResultKillMonsterInfo> _e_ : this.killmonster.entrySet())
/*      */     {
/*  562 */       _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getKey()).intValue());
/*  563 */       _size_ += CodedOutputStream.computeMessageSize(8, (Message)_e_.getValue());
/*      */     }
/*  565 */     for (Map.Entry<Integer, Integer> _e_ : this.skillfailedcountinfight.entrySet())
/*      */     {
/*  567 */       _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getKey()).intValue());
/*  568 */       _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  570 */     for (Map.Entry<Integer, xbean.SkillReleaseRoundInfos> _e_ : this.skillreleaseroundsinfight.entrySet())
/*      */     {
/*  572 */       _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getKey()).intValue());
/*  573 */       _size_ += CodedOutputStream.computeMessageSize(10, (Message)_e_.getValue());
/*      */     }
/*  575 */     for (Map.Entry<Integer, xbean.SkillResultAttackTimes> _e_ : this.skillattacktimesinfight.entrySet())
/*      */     {
/*  577 */       _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getKey()).intValue());
/*  578 */       _size_ += CodedOutputStream.computeMessageSize(11, (Message)_e_.getValue());
/*      */     }
/*  580 */     for (Map.Entry<Integer, xbean.SkillResultHitMains> _e_ : this.skillhitmaintargetinfight.entrySet())
/*      */     {
/*  582 */       _size_ += CodedOutputStream.computeInt32Size(12, ((Integer)_e_.getKey()).intValue());
/*  583 */       _size_ += CodedOutputStream.computeMessageSize(12, (Message)_e_.getValue());
/*      */     }
/*  585 */     for (Map.Entry<Integer, xbean.SkillBuffResult> _e_ : this.skillbuffinfight.entrySet())
/*      */     {
/*  587 */       _size_ += CodedOutputStream.computeInt32Size(13, ((Integer)_e_.getKey()).intValue());
/*  588 */       _size_ += CodedOutputStream.computeMessageSize(13, (Message)_e_.getValue());
/*      */     }
/*  590 */     for (Map.Entry<Integer, xbean.SkillMirrorInfo> _e_ : this.skillmirrorinfoinfight.entrySet())
/*      */     {
/*  592 */       _size_ += CodedOutputStream.computeInt32Size(14, ((Integer)_e_.getKey()).intValue());
/*  593 */       _size_ += CodedOutputStream.computeMessageSize(14, (Message)_e_.getValue());
/*      */     }
/*  595 */     for (xbean.SkillShareDamageKillInfo _v_ : this.skillandsharedamagekillinfight)
/*      */     {
/*  597 */       _size_ += CodedOutputStream.computeMessageSize(15, _v_);
/*      */     }
/*  599 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  605 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  608 */       for (Map.Entry<Integer, Integer> _e_ : this.skillkillcountinfight.entrySet())
/*      */       {
/*  610 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  611 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  613 */       for (Map.Entry<Integer, Integer> _e_ : this.skilltargetismaininfight.entrySet())
/*      */       {
/*  615 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  616 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  618 */       for (Map.Entry<Integer, Integer> _e_ : this.skillkillreborncountinfight.entrySet())
/*      */       {
/*  620 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  621 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  623 */       for (Map.Entry<Integer, Integer> _e_ : this.skillbedodgecountinfight.entrySet())
/*      */       {
/*  625 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  626 */         _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  628 */       for (Map.Entry<Integer, Integer> _e_ : this.skillcriticalcountinround.entrySet())
/*      */       {
/*  630 */         _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  631 */         _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  633 */       for (Map.Entry<Integer, Integer> _e_ : this.skillkillcountinround.entrySet())
/*      */       {
/*  635 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  636 */         _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  638 */       for (Map.Entry<Integer, Integer> _e_ : this.skilltargethplesscountinfight.entrySet())
/*      */       {
/*  640 */         _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/*  641 */         _output_.writeInt32(7, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  643 */       for (Map.Entry<Integer, xbean.SkillResultKillMonsterInfo> _e_ : this.killmonster.entrySet())
/*      */       {
/*  645 */         _output_.writeInt32(8, ((Integer)_e_.getKey()).intValue());
/*  646 */         _output_.writeMessage(8, (Message)_e_.getValue());
/*      */       }
/*  648 */       for (Map.Entry<Integer, Integer> _e_ : this.skillfailedcountinfight.entrySet())
/*      */       {
/*  650 */         _output_.writeInt32(9, ((Integer)_e_.getKey()).intValue());
/*  651 */         _output_.writeInt32(9, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  653 */       for (Map.Entry<Integer, xbean.SkillReleaseRoundInfos> _e_ : this.skillreleaseroundsinfight.entrySet())
/*      */       {
/*  655 */         _output_.writeInt32(10, ((Integer)_e_.getKey()).intValue());
/*  656 */         _output_.writeMessage(10, (Message)_e_.getValue());
/*      */       }
/*  658 */       for (Map.Entry<Integer, xbean.SkillResultAttackTimes> _e_ : this.skillattacktimesinfight.entrySet())
/*      */       {
/*  660 */         _output_.writeInt32(11, ((Integer)_e_.getKey()).intValue());
/*  661 */         _output_.writeMessage(11, (Message)_e_.getValue());
/*      */       }
/*  663 */       for (Map.Entry<Integer, xbean.SkillResultHitMains> _e_ : this.skillhitmaintargetinfight.entrySet())
/*      */       {
/*  665 */         _output_.writeInt32(12, ((Integer)_e_.getKey()).intValue());
/*  666 */         _output_.writeMessage(12, (Message)_e_.getValue());
/*      */       }
/*  668 */       for (Map.Entry<Integer, xbean.SkillBuffResult> _e_ : this.skillbuffinfight.entrySet())
/*      */       {
/*  670 */         _output_.writeInt32(13, ((Integer)_e_.getKey()).intValue());
/*  671 */         _output_.writeMessage(13, (Message)_e_.getValue());
/*      */       }
/*  673 */       for (Map.Entry<Integer, xbean.SkillMirrorInfo> _e_ : this.skillmirrorinfoinfight.entrySet())
/*      */       {
/*  675 */         _output_.writeInt32(14, ((Integer)_e_.getKey()).intValue());
/*  676 */         _output_.writeMessage(14, (Message)_e_.getValue());
/*      */       }
/*  678 */       for (xbean.SkillShareDamageKillInfo _v_ : this.skillandsharedamagekillinfight)
/*      */       {
/*  680 */         _output_.writeMessage(15, _v_);
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  685 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  687 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  693 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  696 */       boolean done = false;
/*  697 */       while (!done)
/*      */       {
/*  699 */         int tag = _input_.readTag();
/*  700 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  704 */           done = true;
/*  705 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  709 */           int _k_ = 0;
/*  710 */           _k_ = _input_.readInt32();
/*  711 */           int readTag = _input_.readTag();
/*  712 */           if (8 != readTag)
/*      */           {
/*  714 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  716 */           int _v_ = 0;
/*  717 */           _v_ = _input_.readInt32();
/*  718 */           this.skillkillcountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  719 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  723 */           int _k_ = 0;
/*  724 */           _k_ = _input_.readInt32();
/*  725 */           int readTag = _input_.readTag();
/*  726 */           if (16 != readTag)
/*      */           {
/*  728 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  730 */           int _v_ = 0;
/*  731 */           _v_ = _input_.readInt32();
/*  732 */           this.skilltargetismaininfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  733 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  737 */           int _k_ = 0;
/*  738 */           _k_ = _input_.readInt32();
/*  739 */           int readTag = _input_.readTag();
/*  740 */           if (24 != readTag)
/*      */           {
/*  742 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  744 */           int _v_ = 0;
/*  745 */           _v_ = _input_.readInt32();
/*  746 */           this.skillkillreborncountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  747 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  751 */           int _k_ = 0;
/*  752 */           _k_ = _input_.readInt32();
/*  753 */           int readTag = _input_.readTag();
/*  754 */           if (32 != readTag)
/*      */           {
/*  756 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  758 */           int _v_ = 0;
/*  759 */           _v_ = _input_.readInt32();
/*  760 */           this.skillbedodgecountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  761 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  765 */           int _k_ = 0;
/*  766 */           _k_ = _input_.readInt32();
/*  767 */           int readTag = _input_.readTag();
/*  768 */           if (40 != readTag)
/*      */           {
/*  770 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  772 */           int _v_ = 0;
/*  773 */           _v_ = _input_.readInt32();
/*  774 */           this.skillcriticalcountinround.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  775 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  779 */           int _k_ = 0;
/*  780 */           _k_ = _input_.readInt32();
/*  781 */           int readTag = _input_.readTag();
/*  782 */           if (48 != readTag)
/*      */           {
/*  784 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  786 */           int _v_ = 0;
/*  787 */           _v_ = _input_.readInt32();
/*  788 */           this.skillkillcountinround.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  789 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  793 */           int _k_ = 0;
/*  794 */           _k_ = _input_.readInt32();
/*  795 */           int readTag = _input_.readTag();
/*  796 */           if (56 != readTag)
/*      */           {
/*  798 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  800 */           int _v_ = 0;
/*  801 */           _v_ = _input_.readInt32();
/*  802 */           this.skilltargethplesscountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  803 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  807 */           int _k_ = 0;
/*  808 */           _k_ = _input_.readInt32();
/*  809 */           int readTag = _input_.readTag();
/*  810 */           if (66 != readTag)
/*      */           {
/*  812 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  814 */           xbean.SkillResultKillMonsterInfo _v_ = new SkillResultKillMonsterInfo(0, this, "killmonster");
/*  815 */           _input_.readMessage(_v_);
/*  816 */           this.killmonster.put(Integer.valueOf(_k_), _v_);
/*  817 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  821 */           int _k_ = 0;
/*  822 */           _k_ = _input_.readInt32();
/*  823 */           int readTag = _input_.readTag();
/*  824 */           if (72 != readTag)
/*      */           {
/*  826 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  828 */           int _v_ = 0;
/*  829 */           _v_ = _input_.readInt32();
/*  830 */           this.skillfailedcountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  831 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  835 */           int _k_ = 0;
/*  836 */           _k_ = _input_.readInt32();
/*  837 */           int readTag = _input_.readTag();
/*  838 */           if (82 != readTag)
/*      */           {
/*  840 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  842 */           xbean.SkillReleaseRoundInfos _v_ = new SkillReleaseRoundInfos(0, this, "skillreleaseroundsinfight");
/*  843 */           _input_.readMessage(_v_);
/*  844 */           this.skillreleaseroundsinfight.put(Integer.valueOf(_k_), _v_);
/*  845 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  849 */           int _k_ = 0;
/*  850 */           _k_ = _input_.readInt32();
/*  851 */           int readTag = _input_.readTag();
/*  852 */           if (90 != readTag)
/*      */           {
/*  854 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  856 */           xbean.SkillResultAttackTimes _v_ = new SkillResultAttackTimes(0, this, "skillattacktimesinfight");
/*  857 */           _input_.readMessage(_v_);
/*  858 */           this.skillattacktimesinfight.put(Integer.valueOf(_k_), _v_);
/*  859 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  863 */           int _k_ = 0;
/*  864 */           _k_ = _input_.readInt32();
/*  865 */           int readTag = _input_.readTag();
/*  866 */           if (98 != readTag)
/*      */           {
/*  868 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  870 */           xbean.SkillResultHitMains _v_ = new SkillResultHitMains(0, this, "skillhitmaintargetinfight");
/*  871 */           _input_.readMessage(_v_);
/*  872 */           this.skillhitmaintargetinfight.put(Integer.valueOf(_k_), _v_);
/*  873 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  877 */           int _k_ = 0;
/*  878 */           _k_ = _input_.readInt32();
/*  879 */           int readTag = _input_.readTag();
/*  880 */           if (106 != readTag)
/*      */           {
/*  882 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  884 */           xbean.SkillBuffResult _v_ = new SkillBuffResult(0, this, "skillbuffinfight");
/*  885 */           _input_.readMessage(_v_);
/*  886 */           this.skillbuffinfight.put(Integer.valueOf(_k_), _v_);
/*  887 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  891 */           int _k_ = 0;
/*  892 */           _k_ = _input_.readInt32();
/*  893 */           int readTag = _input_.readTag();
/*  894 */           if (114 != readTag)
/*      */           {
/*  896 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  898 */           xbean.SkillMirrorInfo _v_ = new SkillMirrorInfo(0, this, "skillmirrorinfoinfight");
/*  899 */           _input_.readMessage(_v_);
/*  900 */           this.skillmirrorinfoinfight.put(Integer.valueOf(_k_), _v_);
/*  901 */           break;
/*      */         
/*      */ 
/*      */         case 122: 
/*  905 */           xbean.SkillShareDamageKillInfo _v_ = new SkillShareDamageKillInfo(0, this, "skillandsharedamagekillinfight");
/*  906 */           _input_.readMessage(_v_);
/*  907 */           this.skillandsharedamagekillinfight.add(_v_);
/*  908 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  912 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  914 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  923 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  927 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  929 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SkillResult copy()
/*      */   {
/*  935 */     _xdb_verify_unsafe_();
/*  936 */     return new SkillResult(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SkillResult toData()
/*      */   {
/*  942 */     _xdb_verify_unsafe_();
/*  943 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SkillResult toBean()
/*      */   {
/*  948 */     _xdb_verify_unsafe_();
/*  949 */     return new SkillResult(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SkillResult toDataIf()
/*      */   {
/*  955 */     _xdb_verify_unsafe_();
/*  956 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SkillResult toBeanIf()
/*      */   {
/*  961 */     _xdb_verify_unsafe_();
/*  962 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  968 */     _xdb_verify_unsafe_();
/*  969 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkillkillcountinfight()
/*      */   {
/*  976 */     _xdb_verify_unsafe_();
/*  977 */     return Logs.logMap(new LogKey(this, "skillkillcountinfight"), this.skillkillcountinfight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkillkillcountinfightAsData()
/*      */   {
/*  984 */     _xdb_verify_unsafe_();
/*      */     
/*  986 */     SkillResult _o_ = this;
/*  987 */     Map<Integer, Integer> skillkillcountinfight = new HashMap();
/*  988 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillcountinfight.entrySet())
/*  989 */       skillkillcountinfight.put(_e_.getKey(), _e_.getValue());
/*  990 */     return skillkillcountinfight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkilltargetismaininfight()
/*      */   {
/*  997 */     _xdb_verify_unsafe_();
/*  998 */     return Logs.logMap(new LogKey(this, "skilltargetismaininfight"), this.skilltargetismaininfight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkilltargetismaininfightAsData()
/*      */   {
/* 1005 */     _xdb_verify_unsafe_();
/*      */     
/* 1007 */     SkillResult _o_ = this;
/* 1008 */     Map<Integer, Integer> skilltargetismaininfight = new HashMap();
/* 1009 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skilltargetismaininfight.entrySet())
/* 1010 */       skilltargetismaininfight.put(_e_.getKey(), _e_.getValue());
/* 1011 */     return skilltargetismaininfight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkillkillreborncountinfight()
/*      */   {
/* 1018 */     _xdb_verify_unsafe_();
/* 1019 */     return Logs.logMap(new LogKey(this, "skillkillreborncountinfight"), this.skillkillreborncountinfight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkillkillreborncountinfightAsData()
/*      */   {
/* 1026 */     _xdb_verify_unsafe_();
/*      */     
/* 1028 */     SkillResult _o_ = this;
/* 1029 */     Map<Integer, Integer> skillkillreborncountinfight = new HashMap();
/* 1030 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillreborncountinfight.entrySet())
/* 1031 */       skillkillreborncountinfight.put(_e_.getKey(), _e_.getValue());
/* 1032 */     return skillkillreborncountinfight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkillbedodgecountinfight()
/*      */   {
/* 1039 */     _xdb_verify_unsafe_();
/* 1040 */     return Logs.logMap(new LogKey(this, "skillbedodgecountinfight"), this.skillbedodgecountinfight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkillbedodgecountinfightAsData()
/*      */   {
/* 1047 */     _xdb_verify_unsafe_();
/*      */     
/* 1049 */     SkillResult _o_ = this;
/* 1050 */     Map<Integer, Integer> skillbedodgecountinfight = new HashMap();
/* 1051 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillbedodgecountinfight.entrySet())
/* 1052 */       skillbedodgecountinfight.put(_e_.getKey(), _e_.getValue());
/* 1053 */     return skillbedodgecountinfight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkillcriticalcountinround()
/*      */   {
/* 1060 */     _xdb_verify_unsafe_();
/* 1061 */     return Logs.logMap(new LogKey(this, "skillcriticalcountinround"), this.skillcriticalcountinround);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkillcriticalcountinroundAsData()
/*      */   {
/* 1068 */     _xdb_verify_unsafe_();
/*      */     
/* 1070 */     SkillResult _o_ = this;
/* 1071 */     Map<Integer, Integer> skillcriticalcountinround = new HashMap();
/* 1072 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillcriticalcountinround.entrySet())
/* 1073 */       skillcriticalcountinround.put(_e_.getKey(), _e_.getValue());
/* 1074 */     return skillcriticalcountinround;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkillkillcountinround()
/*      */   {
/* 1081 */     _xdb_verify_unsafe_();
/* 1082 */     return Logs.logMap(new LogKey(this, "skillkillcountinround"), this.skillkillcountinround);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkillkillcountinroundAsData()
/*      */   {
/* 1089 */     _xdb_verify_unsafe_();
/*      */     
/* 1091 */     SkillResult _o_ = this;
/* 1092 */     Map<Integer, Integer> skillkillcountinround = new HashMap();
/* 1093 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillcountinround.entrySet())
/* 1094 */       skillkillcountinround.put(_e_.getKey(), _e_.getValue());
/* 1095 */     return skillkillcountinround;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkilltargethplesscountinfight()
/*      */   {
/* 1102 */     _xdb_verify_unsafe_();
/* 1103 */     return Logs.logMap(new LogKey(this, "skilltargethplesscountinfight"), this.skilltargethplesscountinfight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkilltargethplesscountinfightAsData()
/*      */   {
/* 1110 */     _xdb_verify_unsafe_();
/*      */     
/* 1112 */     SkillResult _o_ = this;
/* 1113 */     Map<Integer, Integer> skilltargethplesscountinfight = new HashMap();
/* 1114 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skilltargethplesscountinfight.entrySet())
/* 1115 */       skilltargethplesscountinfight.put(_e_.getKey(), _e_.getValue());
/* 1116 */     return skilltargethplesscountinfight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SkillResultKillMonsterInfo> getKillmonster()
/*      */   {
/* 1123 */     _xdb_verify_unsafe_();
/* 1124 */     return Logs.logMap(new LogKey(this, "killmonster"), this.killmonster);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SkillResultKillMonsterInfo> getKillmonsterAsData()
/*      */   {
/* 1131 */     _xdb_verify_unsafe_();
/*      */     
/* 1133 */     SkillResult _o_ = this;
/* 1134 */     Map<Integer, xbean.SkillResultKillMonsterInfo> killmonster = new HashMap();
/* 1135 */     for (Map.Entry<Integer, xbean.SkillResultKillMonsterInfo> _e_ : _o_.killmonster.entrySet())
/* 1136 */       killmonster.put(_e_.getKey(), new SkillResultKillMonsterInfo.Data((xbean.SkillResultKillMonsterInfo)_e_.getValue()));
/* 1137 */     return killmonster;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkillfailedcountinfight()
/*      */   {
/* 1144 */     _xdb_verify_unsafe_();
/* 1145 */     return Logs.logMap(new LogKey(this, "skillfailedcountinfight"), this.skillfailedcountinfight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSkillfailedcountinfightAsData()
/*      */   {
/* 1152 */     _xdb_verify_unsafe_();
/*      */     
/* 1154 */     SkillResult _o_ = this;
/* 1155 */     Map<Integer, Integer> skillfailedcountinfight = new HashMap();
/* 1156 */     for (Map.Entry<Integer, Integer> _e_ : _o_.skillfailedcountinfight.entrySet())
/* 1157 */       skillfailedcountinfight.put(_e_.getKey(), _e_.getValue());
/* 1158 */     return skillfailedcountinfight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SkillReleaseRoundInfos> getSkillreleaseroundsinfight()
/*      */   {
/* 1165 */     _xdb_verify_unsafe_();
/* 1166 */     return Logs.logMap(new LogKey(this, "skillreleaseroundsinfight"), this.skillreleaseroundsinfight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SkillReleaseRoundInfos> getSkillreleaseroundsinfightAsData()
/*      */   {
/* 1173 */     _xdb_verify_unsafe_();
/*      */     
/* 1175 */     SkillResult _o_ = this;
/* 1176 */     Map<Integer, xbean.SkillReleaseRoundInfos> skillreleaseroundsinfight = new HashMap();
/* 1177 */     for (Map.Entry<Integer, xbean.SkillReleaseRoundInfos> _e_ : _o_.skillreleaseroundsinfight.entrySet())
/* 1178 */       skillreleaseroundsinfight.put(_e_.getKey(), new SkillReleaseRoundInfos.Data((xbean.SkillReleaseRoundInfos)_e_.getValue()));
/* 1179 */     return skillreleaseroundsinfight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SkillResultAttackTimes> getSkillattacktimesinfight()
/*      */   {
/* 1186 */     _xdb_verify_unsafe_();
/* 1187 */     return Logs.logMap(new LogKey(this, "skillattacktimesinfight"), this.skillattacktimesinfight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SkillResultAttackTimes> getSkillattacktimesinfightAsData()
/*      */   {
/* 1194 */     _xdb_verify_unsafe_();
/*      */     
/* 1196 */     SkillResult _o_ = this;
/* 1197 */     Map<Integer, xbean.SkillResultAttackTimes> skillattacktimesinfight = new HashMap();
/* 1198 */     for (Map.Entry<Integer, xbean.SkillResultAttackTimes> _e_ : _o_.skillattacktimesinfight.entrySet())
/* 1199 */       skillattacktimesinfight.put(_e_.getKey(), new SkillResultAttackTimes.Data((xbean.SkillResultAttackTimes)_e_.getValue()));
/* 1200 */     return skillattacktimesinfight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SkillResultHitMains> getSkillhitmaintargetinfight()
/*      */   {
/* 1207 */     _xdb_verify_unsafe_();
/* 1208 */     return Logs.logMap(new LogKey(this, "skillhitmaintargetinfight"), this.skillhitmaintargetinfight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SkillResultHitMains> getSkillhitmaintargetinfightAsData()
/*      */   {
/* 1215 */     _xdb_verify_unsafe_();
/*      */     
/* 1217 */     SkillResult _o_ = this;
/* 1218 */     Map<Integer, xbean.SkillResultHitMains> skillhitmaintargetinfight = new HashMap();
/* 1219 */     for (Map.Entry<Integer, xbean.SkillResultHitMains> _e_ : _o_.skillhitmaintargetinfight.entrySet())
/* 1220 */       skillhitmaintargetinfight.put(_e_.getKey(), new SkillResultHitMains.Data((xbean.SkillResultHitMains)_e_.getValue()));
/* 1221 */     return skillhitmaintargetinfight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SkillBuffResult> getSkillbuffinfight()
/*      */   {
/* 1228 */     _xdb_verify_unsafe_();
/* 1229 */     return Logs.logMap(new LogKey(this, "skillbuffinfight"), this.skillbuffinfight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SkillBuffResult> getSkillbuffinfightAsData()
/*      */   {
/* 1236 */     _xdb_verify_unsafe_();
/*      */     
/* 1238 */     SkillResult _o_ = this;
/* 1239 */     Map<Integer, xbean.SkillBuffResult> skillbuffinfight = new HashMap();
/* 1240 */     for (Map.Entry<Integer, xbean.SkillBuffResult> _e_ : _o_.skillbuffinfight.entrySet())
/* 1241 */       skillbuffinfight.put(_e_.getKey(), new SkillBuffResult.Data((xbean.SkillBuffResult)_e_.getValue()));
/* 1242 */     return skillbuffinfight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SkillMirrorInfo> getSkillmirrorinfoinfight()
/*      */   {
/* 1249 */     _xdb_verify_unsafe_();
/* 1250 */     return Logs.logMap(new LogKey(this, "skillmirrorinfoinfight"), this.skillmirrorinfoinfight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.SkillMirrorInfo> getSkillmirrorinfoinfightAsData()
/*      */   {
/* 1257 */     _xdb_verify_unsafe_();
/*      */     
/* 1259 */     SkillResult _o_ = this;
/* 1260 */     Map<Integer, xbean.SkillMirrorInfo> skillmirrorinfoinfight = new HashMap();
/* 1261 */     for (Map.Entry<Integer, xbean.SkillMirrorInfo> _e_ : _o_.skillmirrorinfoinfight.entrySet())
/* 1262 */       skillmirrorinfoinfight.put(_e_.getKey(), new SkillMirrorInfo.Data((xbean.SkillMirrorInfo)_e_.getValue()));
/* 1263 */     return skillmirrorinfoinfight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.SkillShareDamageKillInfo> getSkillandsharedamagekillinfight()
/*      */   {
/* 1270 */     _xdb_verify_unsafe_();
/* 1271 */     return Logs.logList(new LogKey(this, "skillandsharedamagekillinfight"), this.skillandsharedamagekillinfight);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.SkillShareDamageKillInfo> getSkillandsharedamagekillinfightAsData()
/*      */   {
/* 1277 */     _xdb_verify_unsafe_();
/*      */     
/* 1279 */     SkillResult _o_ = this;
/* 1280 */     List<xbean.SkillShareDamageKillInfo> skillandsharedamagekillinfight = new ArrayList();
/* 1281 */     for (xbean.SkillShareDamageKillInfo _v_ : _o_.skillandsharedamagekillinfight)
/* 1282 */       skillandsharedamagekillinfight.add(new SkillShareDamageKillInfo.Data(_v_));
/* 1283 */     return skillandsharedamagekillinfight;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/* 1289 */     _xdb_verify_unsafe_();
/* 1290 */     SkillResult _o_ = null;
/* 1291 */     if ((_o1_ instanceof SkillResult)) { _o_ = (SkillResult)_o1_;
/* 1292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 1293 */       return false;
/* 1294 */     if (!this.skillkillcountinfight.equals(_o_.skillkillcountinfight)) return false;
/* 1295 */     if (!this.skilltargetismaininfight.equals(_o_.skilltargetismaininfight)) return false;
/* 1296 */     if (!this.skillkillreborncountinfight.equals(_o_.skillkillreborncountinfight)) return false;
/* 1297 */     if (!this.skillbedodgecountinfight.equals(_o_.skillbedodgecountinfight)) return false;
/* 1298 */     if (!this.skillcriticalcountinround.equals(_o_.skillcriticalcountinround)) return false;
/* 1299 */     if (!this.skillkillcountinround.equals(_o_.skillkillcountinround)) return false;
/* 1300 */     if (!this.skilltargethplesscountinfight.equals(_o_.skilltargethplesscountinfight)) return false;
/* 1301 */     if (!this.killmonster.equals(_o_.killmonster)) return false;
/* 1302 */     if (!this.skillfailedcountinfight.equals(_o_.skillfailedcountinfight)) return false;
/* 1303 */     if (!this.skillreleaseroundsinfight.equals(_o_.skillreleaseroundsinfight)) return false;
/* 1304 */     if (!this.skillattacktimesinfight.equals(_o_.skillattacktimesinfight)) return false;
/* 1305 */     if (!this.skillhitmaintargetinfight.equals(_o_.skillhitmaintargetinfight)) return false;
/* 1306 */     if (!this.skillbuffinfight.equals(_o_.skillbuffinfight)) return false;
/* 1307 */     if (!this.skillmirrorinfoinfight.equals(_o_.skillmirrorinfoinfight)) return false;
/* 1308 */     if (!this.skillandsharedamagekillinfight.equals(_o_.skillandsharedamagekillinfight)) return false;
/* 1309 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/* 1315 */     _xdb_verify_unsafe_();
/* 1316 */     int _h_ = 0;
/* 1317 */     _h_ += this.skillkillcountinfight.hashCode();
/* 1318 */     _h_ += this.skilltargetismaininfight.hashCode();
/* 1319 */     _h_ += this.skillkillreborncountinfight.hashCode();
/* 1320 */     _h_ += this.skillbedodgecountinfight.hashCode();
/* 1321 */     _h_ += this.skillcriticalcountinround.hashCode();
/* 1322 */     _h_ += this.skillkillcountinround.hashCode();
/* 1323 */     _h_ += this.skilltargethplesscountinfight.hashCode();
/* 1324 */     _h_ += this.killmonster.hashCode();
/* 1325 */     _h_ += this.skillfailedcountinfight.hashCode();
/* 1326 */     _h_ += this.skillreleaseroundsinfight.hashCode();
/* 1327 */     _h_ += this.skillattacktimesinfight.hashCode();
/* 1328 */     _h_ += this.skillhitmaintargetinfight.hashCode();
/* 1329 */     _h_ += this.skillbuffinfight.hashCode();
/* 1330 */     _h_ += this.skillmirrorinfoinfight.hashCode();
/* 1331 */     _h_ += this.skillandsharedamagekillinfight.hashCode();
/* 1332 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1338 */     _xdb_verify_unsafe_();
/* 1339 */     StringBuilder _sb_ = new StringBuilder();
/* 1340 */     _sb_.append("(");
/* 1341 */     _sb_.append(this.skillkillcountinfight);
/* 1342 */     _sb_.append(",");
/* 1343 */     _sb_.append(this.skilltargetismaininfight);
/* 1344 */     _sb_.append(",");
/* 1345 */     _sb_.append(this.skillkillreborncountinfight);
/* 1346 */     _sb_.append(",");
/* 1347 */     _sb_.append(this.skillbedodgecountinfight);
/* 1348 */     _sb_.append(",");
/* 1349 */     _sb_.append(this.skillcriticalcountinround);
/* 1350 */     _sb_.append(",");
/* 1351 */     _sb_.append(this.skillkillcountinround);
/* 1352 */     _sb_.append(",");
/* 1353 */     _sb_.append(this.skilltargethplesscountinfight);
/* 1354 */     _sb_.append(",");
/* 1355 */     _sb_.append(this.killmonster);
/* 1356 */     _sb_.append(",");
/* 1357 */     _sb_.append(this.skillfailedcountinfight);
/* 1358 */     _sb_.append(",");
/* 1359 */     _sb_.append(this.skillreleaseroundsinfight);
/* 1360 */     _sb_.append(",");
/* 1361 */     _sb_.append(this.skillattacktimesinfight);
/* 1362 */     _sb_.append(",");
/* 1363 */     _sb_.append(this.skillhitmaintargetinfight);
/* 1364 */     _sb_.append(",");
/* 1365 */     _sb_.append(this.skillbuffinfight);
/* 1366 */     _sb_.append(",");
/* 1367 */     _sb_.append(this.skillmirrorinfoinfight);
/* 1368 */     _sb_.append(",");
/* 1369 */     _sb_.append(this.skillandsharedamagekillinfight);
/* 1370 */     _sb_.append(")");
/* 1371 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/* 1377 */     ListenableBean lb = new ListenableBean();
/* 1378 */     lb.add(new ListenableMap().setVarName("skillkillcountinfight"));
/* 1379 */     lb.add(new ListenableMap().setVarName("skilltargetismaininfight"));
/* 1380 */     lb.add(new ListenableMap().setVarName("skillkillreborncountinfight"));
/* 1381 */     lb.add(new ListenableMap().setVarName("skillbedodgecountinfight"));
/* 1382 */     lb.add(new ListenableMap().setVarName("skillcriticalcountinround"));
/* 1383 */     lb.add(new ListenableMap().setVarName("skillkillcountinround"));
/* 1384 */     lb.add(new ListenableMap().setVarName("skilltargethplesscountinfight"));
/* 1385 */     lb.add(new ListenableMap().setVarName("killmonster"));
/* 1386 */     lb.add(new ListenableMap().setVarName("skillfailedcountinfight"));
/* 1387 */     lb.add(new ListenableMap().setVarName("skillreleaseroundsinfight"));
/* 1388 */     lb.add(new ListenableMap().setVarName("skillattacktimesinfight"));
/* 1389 */     lb.add(new ListenableMap().setVarName("skillhitmaintargetinfight"));
/* 1390 */     lb.add(new ListenableMap().setVarName("skillbuffinfight"));
/* 1391 */     lb.add(new ListenableMap().setVarName("skillmirrorinfoinfight"));
/* 1392 */     lb.add(new ListenableChanged().setVarName("skillandsharedamagekillinfight"));
/* 1393 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.SkillResult {
/*      */     private Const() {}
/*      */     
/*      */     SkillResult nThis() {
/* 1400 */       return SkillResult.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1406 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SkillResult copy()
/*      */     {
/* 1412 */       return SkillResult.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SkillResult toData()
/*      */     {
/* 1418 */       return SkillResult.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.SkillResult toBean()
/*      */     {
/* 1423 */       return SkillResult.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SkillResult toDataIf()
/*      */     {
/* 1429 */       return SkillResult.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.SkillResult toBeanIf()
/*      */     {
/* 1434 */       return SkillResult.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillkillcountinfight()
/*      */     {
/* 1441 */       SkillResult.this._xdb_verify_unsafe_();
/* 1442 */       return Consts.constMap(SkillResult.this.skillkillcountinfight);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillkillcountinfightAsData()
/*      */     {
/* 1449 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1451 */       SkillResult _o_ = SkillResult.this;
/* 1452 */       Map<Integer, Integer> skillkillcountinfight = new HashMap();
/* 1453 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillcountinfight.entrySet())
/* 1454 */         skillkillcountinfight.put(_e_.getKey(), _e_.getValue());
/* 1455 */       return skillkillcountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkilltargetismaininfight()
/*      */     {
/* 1462 */       SkillResult.this._xdb_verify_unsafe_();
/* 1463 */       return Consts.constMap(SkillResult.this.skilltargetismaininfight);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkilltargetismaininfightAsData()
/*      */     {
/* 1470 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1472 */       SkillResult _o_ = SkillResult.this;
/* 1473 */       Map<Integer, Integer> skilltargetismaininfight = new HashMap();
/* 1474 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skilltargetismaininfight.entrySet())
/* 1475 */         skilltargetismaininfight.put(_e_.getKey(), _e_.getValue());
/* 1476 */       return skilltargetismaininfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillkillreborncountinfight()
/*      */     {
/* 1483 */       SkillResult.this._xdb_verify_unsafe_();
/* 1484 */       return Consts.constMap(SkillResult.this.skillkillreborncountinfight);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillkillreborncountinfightAsData()
/*      */     {
/* 1491 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1493 */       SkillResult _o_ = SkillResult.this;
/* 1494 */       Map<Integer, Integer> skillkillreborncountinfight = new HashMap();
/* 1495 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillreborncountinfight.entrySet())
/* 1496 */         skillkillreborncountinfight.put(_e_.getKey(), _e_.getValue());
/* 1497 */       return skillkillreborncountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillbedodgecountinfight()
/*      */     {
/* 1504 */       SkillResult.this._xdb_verify_unsafe_();
/* 1505 */       return Consts.constMap(SkillResult.this.skillbedodgecountinfight);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillbedodgecountinfightAsData()
/*      */     {
/* 1512 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1514 */       SkillResult _o_ = SkillResult.this;
/* 1515 */       Map<Integer, Integer> skillbedodgecountinfight = new HashMap();
/* 1516 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillbedodgecountinfight.entrySet())
/* 1517 */         skillbedodgecountinfight.put(_e_.getKey(), _e_.getValue());
/* 1518 */       return skillbedodgecountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillcriticalcountinround()
/*      */     {
/* 1525 */       SkillResult.this._xdb_verify_unsafe_();
/* 1526 */       return Consts.constMap(SkillResult.this.skillcriticalcountinround);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillcriticalcountinroundAsData()
/*      */     {
/* 1533 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1535 */       SkillResult _o_ = SkillResult.this;
/* 1536 */       Map<Integer, Integer> skillcriticalcountinround = new HashMap();
/* 1537 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillcriticalcountinround.entrySet())
/* 1538 */         skillcriticalcountinround.put(_e_.getKey(), _e_.getValue());
/* 1539 */       return skillcriticalcountinround;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillkillcountinround()
/*      */     {
/* 1546 */       SkillResult.this._xdb_verify_unsafe_();
/* 1547 */       return Consts.constMap(SkillResult.this.skillkillcountinround);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillkillcountinroundAsData()
/*      */     {
/* 1554 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1556 */       SkillResult _o_ = SkillResult.this;
/* 1557 */       Map<Integer, Integer> skillkillcountinround = new HashMap();
/* 1558 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillcountinround.entrySet())
/* 1559 */         skillkillcountinround.put(_e_.getKey(), _e_.getValue());
/* 1560 */       return skillkillcountinround;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkilltargethplesscountinfight()
/*      */     {
/* 1567 */       SkillResult.this._xdb_verify_unsafe_();
/* 1568 */       return Consts.constMap(SkillResult.this.skilltargethplesscountinfight);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkilltargethplesscountinfightAsData()
/*      */     {
/* 1575 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1577 */       SkillResult _o_ = SkillResult.this;
/* 1578 */       Map<Integer, Integer> skilltargethplesscountinfight = new HashMap();
/* 1579 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skilltargethplesscountinfight.entrySet())
/* 1580 */         skilltargethplesscountinfight.put(_e_.getKey(), _e_.getValue());
/* 1581 */       return skilltargethplesscountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillResultKillMonsterInfo> getKillmonster()
/*      */     {
/* 1588 */       SkillResult.this._xdb_verify_unsafe_();
/* 1589 */       return Consts.constMap(SkillResult.this.killmonster);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillResultKillMonsterInfo> getKillmonsterAsData()
/*      */     {
/* 1596 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1598 */       SkillResult _o_ = SkillResult.this;
/* 1599 */       Map<Integer, xbean.SkillResultKillMonsterInfo> killmonster = new HashMap();
/* 1600 */       for (Map.Entry<Integer, xbean.SkillResultKillMonsterInfo> _e_ : _o_.killmonster.entrySet())
/* 1601 */         killmonster.put(_e_.getKey(), new SkillResultKillMonsterInfo.Data((xbean.SkillResultKillMonsterInfo)_e_.getValue()));
/* 1602 */       return killmonster;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillfailedcountinfight()
/*      */     {
/* 1609 */       SkillResult.this._xdb_verify_unsafe_();
/* 1610 */       return Consts.constMap(SkillResult.this.skillfailedcountinfight);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillfailedcountinfightAsData()
/*      */     {
/* 1617 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1619 */       SkillResult _o_ = SkillResult.this;
/* 1620 */       Map<Integer, Integer> skillfailedcountinfight = new HashMap();
/* 1621 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillfailedcountinfight.entrySet())
/* 1622 */         skillfailedcountinfight.put(_e_.getKey(), _e_.getValue());
/* 1623 */       return skillfailedcountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillReleaseRoundInfos> getSkillreleaseroundsinfight()
/*      */     {
/* 1630 */       SkillResult.this._xdb_verify_unsafe_();
/* 1631 */       return Consts.constMap(SkillResult.this.skillreleaseroundsinfight);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillReleaseRoundInfos> getSkillreleaseroundsinfightAsData()
/*      */     {
/* 1638 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1640 */       SkillResult _o_ = SkillResult.this;
/* 1641 */       Map<Integer, xbean.SkillReleaseRoundInfos> skillreleaseroundsinfight = new HashMap();
/* 1642 */       for (Map.Entry<Integer, xbean.SkillReleaseRoundInfos> _e_ : _o_.skillreleaseroundsinfight.entrySet())
/* 1643 */         skillreleaseroundsinfight.put(_e_.getKey(), new SkillReleaseRoundInfos.Data((xbean.SkillReleaseRoundInfos)_e_.getValue()));
/* 1644 */       return skillreleaseroundsinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillResultAttackTimes> getSkillattacktimesinfight()
/*      */     {
/* 1651 */       SkillResult.this._xdb_verify_unsafe_();
/* 1652 */       return Consts.constMap(SkillResult.this.skillattacktimesinfight);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillResultAttackTimes> getSkillattacktimesinfightAsData()
/*      */     {
/* 1659 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1661 */       SkillResult _o_ = SkillResult.this;
/* 1662 */       Map<Integer, xbean.SkillResultAttackTimes> skillattacktimesinfight = new HashMap();
/* 1663 */       for (Map.Entry<Integer, xbean.SkillResultAttackTimes> _e_ : _o_.skillattacktimesinfight.entrySet())
/* 1664 */         skillattacktimesinfight.put(_e_.getKey(), new SkillResultAttackTimes.Data((xbean.SkillResultAttackTimes)_e_.getValue()));
/* 1665 */       return skillattacktimesinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillResultHitMains> getSkillhitmaintargetinfight()
/*      */     {
/* 1672 */       SkillResult.this._xdb_verify_unsafe_();
/* 1673 */       return Consts.constMap(SkillResult.this.skillhitmaintargetinfight);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillResultHitMains> getSkillhitmaintargetinfightAsData()
/*      */     {
/* 1680 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1682 */       SkillResult _o_ = SkillResult.this;
/* 1683 */       Map<Integer, xbean.SkillResultHitMains> skillhitmaintargetinfight = new HashMap();
/* 1684 */       for (Map.Entry<Integer, xbean.SkillResultHitMains> _e_ : _o_.skillhitmaintargetinfight.entrySet())
/* 1685 */         skillhitmaintargetinfight.put(_e_.getKey(), new SkillResultHitMains.Data((xbean.SkillResultHitMains)_e_.getValue()));
/* 1686 */       return skillhitmaintargetinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillBuffResult> getSkillbuffinfight()
/*      */     {
/* 1693 */       SkillResult.this._xdb_verify_unsafe_();
/* 1694 */       return Consts.constMap(SkillResult.this.skillbuffinfight);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillBuffResult> getSkillbuffinfightAsData()
/*      */     {
/* 1701 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1703 */       SkillResult _o_ = SkillResult.this;
/* 1704 */       Map<Integer, xbean.SkillBuffResult> skillbuffinfight = new HashMap();
/* 1705 */       for (Map.Entry<Integer, xbean.SkillBuffResult> _e_ : _o_.skillbuffinfight.entrySet())
/* 1706 */         skillbuffinfight.put(_e_.getKey(), new SkillBuffResult.Data((xbean.SkillBuffResult)_e_.getValue()));
/* 1707 */       return skillbuffinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillMirrorInfo> getSkillmirrorinfoinfight()
/*      */     {
/* 1714 */       SkillResult.this._xdb_verify_unsafe_();
/* 1715 */       return Consts.constMap(SkillResult.this.skillmirrorinfoinfight);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillMirrorInfo> getSkillmirrorinfoinfightAsData()
/*      */     {
/* 1722 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1724 */       SkillResult _o_ = SkillResult.this;
/* 1725 */       Map<Integer, xbean.SkillMirrorInfo> skillmirrorinfoinfight = new HashMap();
/* 1726 */       for (Map.Entry<Integer, xbean.SkillMirrorInfo> _e_ : _o_.skillmirrorinfoinfight.entrySet())
/* 1727 */         skillmirrorinfoinfight.put(_e_.getKey(), new SkillMirrorInfo.Data((xbean.SkillMirrorInfo)_e_.getValue()));
/* 1728 */       return skillmirrorinfoinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.SkillShareDamageKillInfo> getSkillandsharedamagekillinfight()
/*      */     {
/* 1735 */       SkillResult.this._xdb_verify_unsafe_();
/* 1736 */       return Consts.constList(SkillResult.this.skillandsharedamagekillinfight);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.SkillShareDamageKillInfo> getSkillandsharedamagekillinfightAsData()
/*      */     {
/* 1742 */       SkillResult.this._xdb_verify_unsafe_();
/*      */       
/* 1744 */       SkillResult _o_ = SkillResult.this;
/* 1745 */       List<xbean.SkillShareDamageKillInfo> skillandsharedamagekillinfight = new ArrayList();
/* 1746 */       for (xbean.SkillShareDamageKillInfo _v_ : _o_.skillandsharedamagekillinfight)
/* 1747 */         skillandsharedamagekillinfight.add(new SkillShareDamageKillInfo.Data(_v_));
/* 1748 */       return skillandsharedamagekillinfight;
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1754 */       SkillResult.this._xdb_verify_unsafe_();
/* 1755 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1761 */       SkillResult.this._xdb_verify_unsafe_();
/* 1762 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1768 */       return SkillResult.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1774 */       return SkillResult.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1780 */       SkillResult.this._xdb_verify_unsafe_();
/* 1781 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1787 */       return SkillResult.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1793 */       return SkillResult.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1799 */       SkillResult.this._xdb_verify_unsafe_();
/* 1800 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1806 */       return SkillResult.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1812 */       return SkillResult.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1818 */       return SkillResult.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1824 */       return SkillResult.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1830 */       return SkillResult.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1836 */       return SkillResult.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1842 */       return SkillResult.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.SkillResult
/*      */   {
/*      */     private HashMap<Integer, Integer> skillkillcountinfight;
/*      */     
/*      */     private HashMap<Integer, Integer> skilltargetismaininfight;
/*      */     
/*      */     private HashMap<Integer, Integer> skillkillreborncountinfight;
/*      */     
/*      */     private HashMap<Integer, Integer> skillbedodgecountinfight;
/*      */     
/*      */     private HashMap<Integer, Integer> skillcriticalcountinround;
/*      */     
/*      */     private HashMap<Integer, Integer> skillkillcountinround;
/*      */     
/*      */     private HashMap<Integer, Integer> skilltargethplesscountinfight;
/*      */     
/*      */     private HashMap<Integer, xbean.SkillResultKillMonsterInfo> killmonster;
/*      */     
/*      */     private HashMap<Integer, Integer> skillfailedcountinfight;
/*      */     
/*      */     private HashMap<Integer, xbean.SkillReleaseRoundInfos> skillreleaseroundsinfight;
/*      */     
/*      */     private HashMap<Integer, xbean.SkillResultAttackTimes> skillattacktimesinfight;
/*      */     
/*      */     private HashMap<Integer, xbean.SkillResultHitMains> skillhitmaintargetinfight;
/*      */     
/*      */     private HashMap<Integer, xbean.SkillBuffResult> skillbuffinfight;
/*      */     
/*      */     private HashMap<Integer, xbean.SkillMirrorInfo> skillmirrorinfoinfight;
/*      */     
/*      */     private ArrayList<xbean.SkillShareDamageKillInfo> skillandsharedamagekillinfight;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1882 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1887 */       this.skillkillcountinfight = new HashMap();
/* 1888 */       this.skilltargetismaininfight = new HashMap();
/* 1889 */       this.skillkillreborncountinfight = new HashMap();
/* 1890 */       this.skillbedodgecountinfight = new HashMap();
/* 1891 */       this.skillcriticalcountinround = new HashMap();
/* 1892 */       this.skillkillcountinround = new HashMap();
/* 1893 */       this.skilltargethplesscountinfight = new HashMap();
/* 1894 */       this.killmonster = new HashMap();
/* 1895 */       this.skillfailedcountinfight = new HashMap();
/* 1896 */       this.skillreleaseroundsinfight = new HashMap();
/* 1897 */       this.skillattacktimesinfight = new HashMap();
/* 1898 */       this.skillhitmaintargetinfight = new HashMap();
/* 1899 */       this.skillbuffinfight = new HashMap();
/* 1900 */       this.skillmirrorinfoinfight = new HashMap();
/* 1901 */       this.skillandsharedamagekillinfight = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.SkillResult _o1_)
/*      */     {
/* 1906 */       if ((_o1_ instanceof SkillResult)) { assign((SkillResult)_o1_);
/* 1907 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1908 */       } else if ((_o1_ instanceof SkillResult.Const)) assign(((SkillResult.Const)_o1_).nThis()); else {
/* 1909 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(SkillResult _o_) {
/* 1914 */       this.skillkillcountinfight = new HashMap();
/* 1915 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillcountinfight.entrySet())
/* 1916 */         this.skillkillcountinfight.put(_e_.getKey(), _e_.getValue());
/* 1917 */       this.skilltargetismaininfight = new HashMap();
/* 1918 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skilltargetismaininfight.entrySet())
/* 1919 */         this.skilltargetismaininfight.put(_e_.getKey(), _e_.getValue());
/* 1920 */       this.skillkillreborncountinfight = new HashMap();
/* 1921 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillreborncountinfight.entrySet())
/* 1922 */         this.skillkillreborncountinfight.put(_e_.getKey(), _e_.getValue());
/* 1923 */       this.skillbedodgecountinfight = new HashMap();
/* 1924 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillbedodgecountinfight.entrySet())
/* 1925 */         this.skillbedodgecountinfight.put(_e_.getKey(), _e_.getValue());
/* 1926 */       this.skillcriticalcountinround = new HashMap();
/* 1927 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillcriticalcountinround.entrySet())
/* 1928 */         this.skillcriticalcountinround.put(_e_.getKey(), _e_.getValue());
/* 1929 */       this.skillkillcountinround = new HashMap();
/* 1930 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillcountinround.entrySet())
/* 1931 */         this.skillkillcountinround.put(_e_.getKey(), _e_.getValue());
/* 1932 */       this.skilltargethplesscountinfight = new HashMap();
/* 1933 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skilltargethplesscountinfight.entrySet())
/* 1934 */         this.skilltargethplesscountinfight.put(_e_.getKey(), _e_.getValue());
/* 1935 */       this.killmonster = new HashMap();
/* 1936 */       for (Map.Entry<Integer, xbean.SkillResultKillMonsterInfo> _e_ : _o_.killmonster.entrySet())
/* 1937 */         this.killmonster.put(_e_.getKey(), new SkillResultKillMonsterInfo.Data((xbean.SkillResultKillMonsterInfo)_e_.getValue()));
/* 1938 */       this.skillfailedcountinfight = new HashMap();
/* 1939 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillfailedcountinfight.entrySet())
/* 1940 */         this.skillfailedcountinfight.put(_e_.getKey(), _e_.getValue());
/* 1941 */       this.skillreleaseroundsinfight = new HashMap();
/* 1942 */       for (Map.Entry<Integer, xbean.SkillReleaseRoundInfos> _e_ : _o_.skillreleaseroundsinfight.entrySet())
/* 1943 */         this.skillreleaseroundsinfight.put(_e_.getKey(), new SkillReleaseRoundInfos.Data((xbean.SkillReleaseRoundInfos)_e_.getValue()));
/* 1944 */       this.skillattacktimesinfight = new HashMap();
/* 1945 */       for (Map.Entry<Integer, xbean.SkillResultAttackTimes> _e_ : _o_.skillattacktimesinfight.entrySet())
/* 1946 */         this.skillattacktimesinfight.put(_e_.getKey(), new SkillResultAttackTimes.Data((xbean.SkillResultAttackTimes)_e_.getValue()));
/* 1947 */       this.skillhitmaintargetinfight = new HashMap();
/* 1948 */       for (Map.Entry<Integer, xbean.SkillResultHitMains> _e_ : _o_.skillhitmaintargetinfight.entrySet())
/* 1949 */         this.skillhitmaintargetinfight.put(_e_.getKey(), new SkillResultHitMains.Data((xbean.SkillResultHitMains)_e_.getValue()));
/* 1950 */       this.skillbuffinfight = new HashMap();
/* 1951 */       for (Map.Entry<Integer, xbean.SkillBuffResult> _e_ : _o_.skillbuffinfight.entrySet())
/* 1952 */         this.skillbuffinfight.put(_e_.getKey(), new SkillBuffResult.Data((xbean.SkillBuffResult)_e_.getValue()));
/* 1953 */       this.skillmirrorinfoinfight = new HashMap();
/* 1954 */       for (Map.Entry<Integer, xbean.SkillMirrorInfo> _e_ : _o_.skillmirrorinfoinfight.entrySet())
/* 1955 */         this.skillmirrorinfoinfight.put(_e_.getKey(), new SkillMirrorInfo.Data((xbean.SkillMirrorInfo)_e_.getValue()));
/* 1956 */       this.skillandsharedamagekillinfight = new ArrayList();
/* 1957 */       for (xbean.SkillShareDamageKillInfo _v_ : _o_.skillandsharedamagekillinfight) {
/* 1958 */         this.skillandsharedamagekillinfight.add(new SkillShareDamageKillInfo.Data(_v_));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/* 1963 */       this.skillkillcountinfight = new HashMap();
/* 1964 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillcountinfight.entrySet())
/* 1965 */         this.skillkillcountinfight.put(_e_.getKey(), _e_.getValue());
/* 1966 */       this.skilltargetismaininfight = new HashMap();
/* 1967 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skilltargetismaininfight.entrySet())
/* 1968 */         this.skilltargetismaininfight.put(_e_.getKey(), _e_.getValue());
/* 1969 */       this.skillkillreborncountinfight = new HashMap();
/* 1970 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillreborncountinfight.entrySet())
/* 1971 */         this.skillkillreborncountinfight.put(_e_.getKey(), _e_.getValue());
/* 1972 */       this.skillbedodgecountinfight = new HashMap();
/* 1973 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillbedodgecountinfight.entrySet())
/* 1974 */         this.skillbedodgecountinfight.put(_e_.getKey(), _e_.getValue());
/* 1975 */       this.skillcriticalcountinround = new HashMap();
/* 1976 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillcriticalcountinround.entrySet())
/* 1977 */         this.skillcriticalcountinround.put(_e_.getKey(), _e_.getValue());
/* 1978 */       this.skillkillcountinround = new HashMap();
/* 1979 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillkillcountinround.entrySet())
/* 1980 */         this.skillkillcountinround.put(_e_.getKey(), _e_.getValue());
/* 1981 */       this.skilltargethplesscountinfight = new HashMap();
/* 1982 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skilltargethplesscountinfight.entrySet())
/* 1983 */         this.skilltargethplesscountinfight.put(_e_.getKey(), _e_.getValue());
/* 1984 */       this.killmonster = new HashMap();
/* 1985 */       for (Map.Entry<Integer, xbean.SkillResultKillMonsterInfo> _e_ : _o_.killmonster.entrySet())
/* 1986 */         this.killmonster.put(_e_.getKey(), new SkillResultKillMonsterInfo.Data((xbean.SkillResultKillMonsterInfo)_e_.getValue()));
/* 1987 */       this.skillfailedcountinfight = new HashMap();
/* 1988 */       for (Map.Entry<Integer, Integer> _e_ : _o_.skillfailedcountinfight.entrySet())
/* 1989 */         this.skillfailedcountinfight.put(_e_.getKey(), _e_.getValue());
/* 1990 */       this.skillreleaseroundsinfight = new HashMap();
/* 1991 */       for (Map.Entry<Integer, xbean.SkillReleaseRoundInfos> _e_ : _o_.skillreleaseroundsinfight.entrySet())
/* 1992 */         this.skillreleaseroundsinfight.put(_e_.getKey(), new SkillReleaseRoundInfos.Data((xbean.SkillReleaseRoundInfos)_e_.getValue()));
/* 1993 */       this.skillattacktimesinfight = new HashMap();
/* 1994 */       for (Map.Entry<Integer, xbean.SkillResultAttackTimes> _e_ : _o_.skillattacktimesinfight.entrySet())
/* 1995 */         this.skillattacktimesinfight.put(_e_.getKey(), new SkillResultAttackTimes.Data((xbean.SkillResultAttackTimes)_e_.getValue()));
/* 1996 */       this.skillhitmaintargetinfight = new HashMap();
/* 1997 */       for (Map.Entry<Integer, xbean.SkillResultHitMains> _e_ : _o_.skillhitmaintargetinfight.entrySet())
/* 1998 */         this.skillhitmaintargetinfight.put(_e_.getKey(), new SkillResultHitMains.Data((xbean.SkillResultHitMains)_e_.getValue()));
/* 1999 */       this.skillbuffinfight = new HashMap();
/* 2000 */       for (Map.Entry<Integer, xbean.SkillBuffResult> _e_ : _o_.skillbuffinfight.entrySet())
/* 2001 */         this.skillbuffinfight.put(_e_.getKey(), new SkillBuffResult.Data((xbean.SkillBuffResult)_e_.getValue()));
/* 2002 */       this.skillmirrorinfoinfight = new HashMap();
/* 2003 */       for (Map.Entry<Integer, xbean.SkillMirrorInfo> _e_ : _o_.skillmirrorinfoinfight.entrySet())
/* 2004 */         this.skillmirrorinfoinfight.put(_e_.getKey(), new SkillMirrorInfo.Data((xbean.SkillMirrorInfo)_e_.getValue()));
/* 2005 */       this.skillandsharedamagekillinfight = new ArrayList();
/* 2006 */       for (xbean.SkillShareDamageKillInfo _v_ : _o_.skillandsharedamagekillinfight) {
/* 2007 */         this.skillandsharedamagekillinfight.add(new SkillShareDamageKillInfo.Data(_v_));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2013 */       _os_.compact_uint32(this.skillkillcountinfight.size());
/* 2014 */       for (Map.Entry<Integer, Integer> _e_ : this.skillkillcountinfight.entrySet())
/*      */       {
/* 2016 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2017 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2019 */       _os_.compact_uint32(this.skilltargetismaininfight.size());
/* 2020 */       for (Map.Entry<Integer, Integer> _e_ : this.skilltargetismaininfight.entrySet())
/*      */       {
/* 2022 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2023 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2025 */       _os_.compact_uint32(this.skillkillreborncountinfight.size());
/* 2026 */       for (Map.Entry<Integer, Integer> _e_ : this.skillkillreborncountinfight.entrySet())
/*      */       {
/* 2028 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2029 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2031 */       _os_.compact_uint32(this.skillbedodgecountinfight.size());
/* 2032 */       for (Map.Entry<Integer, Integer> _e_ : this.skillbedodgecountinfight.entrySet())
/*      */       {
/* 2034 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2035 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2037 */       _os_.compact_uint32(this.skillcriticalcountinround.size());
/* 2038 */       for (Map.Entry<Integer, Integer> _e_ : this.skillcriticalcountinround.entrySet())
/*      */       {
/* 2040 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2041 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2043 */       _os_.compact_uint32(this.skillkillcountinround.size());
/* 2044 */       for (Map.Entry<Integer, Integer> _e_ : this.skillkillcountinround.entrySet())
/*      */       {
/* 2046 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2047 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2049 */       _os_.compact_uint32(this.skilltargethplesscountinfight.size());
/* 2050 */       for (Map.Entry<Integer, Integer> _e_ : this.skilltargethplesscountinfight.entrySet())
/*      */       {
/* 2052 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2053 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2055 */       _os_.compact_uint32(this.killmonster.size());
/* 2056 */       for (Map.Entry<Integer, xbean.SkillResultKillMonsterInfo> _e_ : this.killmonster.entrySet())
/*      */       {
/* 2058 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2059 */         ((xbean.SkillResultKillMonsterInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2061 */       _os_.compact_uint32(this.skillfailedcountinfight.size());
/* 2062 */       for (Map.Entry<Integer, Integer> _e_ : this.skillfailedcountinfight.entrySet())
/*      */       {
/* 2064 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2065 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2067 */       _os_.compact_uint32(this.skillreleaseroundsinfight.size());
/* 2068 */       for (Map.Entry<Integer, xbean.SkillReleaseRoundInfos> _e_ : this.skillreleaseroundsinfight.entrySet())
/*      */       {
/* 2070 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2071 */         ((xbean.SkillReleaseRoundInfos)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2073 */       _os_.compact_uint32(this.skillattacktimesinfight.size());
/* 2074 */       for (Map.Entry<Integer, xbean.SkillResultAttackTimes> _e_ : this.skillattacktimesinfight.entrySet())
/*      */       {
/* 2076 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2077 */         ((xbean.SkillResultAttackTimes)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2079 */       _os_.compact_uint32(this.skillhitmaintargetinfight.size());
/* 2080 */       for (Map.Entry<Integer, xbean.SkillResultHitMains> _e_ : this.skillhitmaintargetinfight.entrySet())
/*      */       {
/* 2082 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2083 */         ((xbean.SkillResultHitMains)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2085 */       _os_.compact_uint32(this.skillbuffinfight.size());
/* 2086 */       for (Map.Entry<Integer, xbean.SkillBuffResult> _e_ : this.skillbuffinfight.entrySet())
/*      */       {
/* 2088 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2089 */         ((xbean.SkillBuffResult)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2091 */       _os_.compact_uint32(this.skillmirrorinfoinfight.size());
/* 2092 */       for (Map.Entry<Integer, xbean.SkillMirrorInfo> _e_ : this.skillmirrorinfoinfight.entrySet())
/*      */       {
/* 2094 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2095 */         ((xbean.SkillMirrorInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2097 */       _os_.compact_uint32(this.skillandsharedamagekillinfight.size());
/* 2098 */       for (xbean.SkillShareDamageKillInfo _v_ : this.skillandsharedamagekillinfight)
/*      */       {
/* 2100 */         _v_.marshal(_os_);
/*      */       }
/* 2102 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2109 */       int size = _os_.uncompact_uint32();
/* 2110 */       if (size >= 12)
/*      */       {
/* 2112 */         this.skillkillcountinfight = new HashMap(size * 2);
/*      */       }
/* 2114 */       for (; size > 0; size--)
/*      */       {
/* 2116 */         int _k_ = 0;
/* 2117 */         _k_ = _os_.unmarshal_int();
/* 2118 */         int _v_ = 0;
/* 2119 */         _v_ = _os_.unmarshal_int();
/* 2120 */         this.skillkillcountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 2124 */       int size = _os_.uncompact_uint32();
/* 2125 */       if (size >= 12)
/*      */       {
/* 2127 */         this.skilltargetismaininfight = new HashMap(size * 2);
/*      */       }
/* 2129 */       for (; size > 0; size--)
/*      */       {
/* 2131 */         int _k_ = 0;
/* 2132 */         _k_ = _os_.unmarshal_int();
/* 2133 */         int _v_ = 0;
/* 2134 */         _v_ = _os_.unmarshal_int();
/* 2135 */         this.skilltargetismaininfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 2139 */       int size = _os_.uncompact_uint32();
/* 2140 */       if (size >= 12)
/*      */       {
/* 2142 */         this.skillkillreborncountinfight = new HashMap(size * 2);
/*      */       }
/* 2144 */       for (; size > 0; size--)
/*      */       {
/* 2146 */         int _k_ = 0;
/* 2147 */         _k_ = _os_.unmarshal_int();
/* 2148 */         int _v_ = 0;
/* 2149 */         _v_ = _os_.unmarshal_int();
/* 2150 */         this.skillkillreborncountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 2154 */       int size = _os_.uncompact_uint32();
/* 2155 */       if (size >= 12)
/*      */       {
/* 2157 */         this.skillbedodgecountinfight = new HashMap(size * 2);
/*      */       }
/* 2159 */       for (; size > 0; size--)
/*      */       {
/* 2161 */         int _k_ = 0;
/* 2162 */         _k_ = _os_.unmarshal_int();
/* 2163 */         int _v_ = 0;
/* 2164 */         _v_ = _os_.unmarshal_int();
/* 2165 */         this.skillbedodgecountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 2169 */       int size = _os_.uncompact_uint32();
/* 2170 */       if (size >= 12)
/*      */       {
/* 2172 */         this.skillcriticalcountinround = new HashMap(size * 2);
/*      */       }
/* 2174 */       for (; size > 0; size--)
/*      */       {
/* 2176 */         int _k_ = 0;
/* 2177 */         _k_ = _os_.unmarshal_int();
/* 2178 */         int _v_ = 0;
/* 2179 */         _v_ = _os_.unmarshal_int();
/* 2180 */         this.skillcriticalcountinround.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 2184 */       int size = _os_.uncompact_uint32();
/* 2185 */       if (size >= 12)
/*      */       {
/* 2187 */         this.skillkillcountinround = new HashMap(size * 2);
/*      */       }
/* 2189 */       for (; size > 0; size--)
/*      */       {
/* 2191 */         int _k_ = 0;
/* 2192 */         _k_ = _os_.unmarshal_int();
/* 2193 */         int _v_ = 0;
/* 2194 */         _v_ = _os_.unmarshal_int();
/* 2195 */         this.skillkillcountinround.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 2199 */       int size = _os_.uncompact_uint32();
/* 2200 */       if (size >= 12)
/*      */       {
/* 2202 */         this.skilltargethplesscountinfight = new HashMap(size * 2);
/*      */       }
/* 2204 */       for (; size > 0; size--)
/*      */       {
/* 2206 */         int _k_ = 0;
/* 2207 */         _k_ = _os_.unmarshal_int();
/* 2208 */         int _v_ = 0;
/* 2209 */         _v_ = _os_.unmarshal_int();
/* 2210 */         this.skilltargethplesscountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 2214 */       int size = _os_.uncompact_uint32();
/* 2215 */       if (size >= 12)
/*      */       {
/* 2217 */         this.killmonster = new HashMap(size * 2);
/*      */       }
/* 2219 */       for (; size > 0; size--)
/*      */       {
/* 2221 */         int _k_ = 0;
/* 2222 */         _k_ = _os_.unmarshal_int();
/* 2223 */         xbean.SkillResultKillMonsterInfo _v_ = Pod.newSkillResultKillMonsterInfoData();
/* 2224 */         _v_.unmarshal(_os_);
/* 2225 */         this.killmonster.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2229 */       int size = _os_.uncompact_uint32();
/* 2230 */       if (size >= 12)
/*      */       {
/* 2232 */         this.skillfailedcountinfight = new HashMap(size * 2);
/*      */       }
/* 2234 */       for (; size > 0; size--)
/*      */       {
/* 2236 */         int _k_ = 0;
/* 2237 */         _k_ = _os_.unmarshal_int();
/* 2238 */         int _v_ = 0;
/* 2239 */         _v_ = _os_.unmarshal_int();
/* 2240 */         this.skillfailedcountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 2244 */       int size = _os_.uncompact_uint32();
/* 2245 */       if (size >= 12)
/*      */       {
/* 2247 */         this.skillreleaseroundsinfight = new HashMap(size * 2);
/*      */       }
/* 2249 */       for (; size > 0; size--)
/*      */       {
/* 2251 */         int _k_ = 0;
/* 2252 */         _k_ = _os_.unmarshal_int();
/* 2253 */         xbean.SkillReleaseRoundInfos _v_ = Pod.newSkillReleaseRoundInfosData();
/* 2254 */         _v_.unmarshal(_os_);
/* 2255 */         this.skillreleaseroundsinfight.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2259 */       int size = _os_.uncompact_uint32();
/* 2260 */       if (size >= 12)
/*      */       {
/* 2262 */         this.skillattacktimesinfight = new HashMap(size * 2);
/*      */       }
/* 2264 */       for (; size > 0; size--)
/*      */       {
/* 2266 */         int _k_ = 0;
/* 2267 */         _k_ = _os_.unmarshal_int();
/* 2268 */         xbean.SkillResultAttackTimes _v_ = Pod.newSkillResultAttackTimesData();
/* 2269 */         _v_.unmarshal(_os_);
/* 2270 */         this.skillattacktimesinfight.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2274 */       int size = _os_.uncompact_uint32();
/* 2275 */       if (size >= 12)
/*      */       {
/* 2277 */         this.skillhitmaintargetinfight = new HashMap(size * 2);
/*      */       }
/* 2279 */       for (; size > 0; size--)
/*      */       {
/* 2281 */         int _k_ = 0;
/* 2282 */         _k_ = _os_.unmarshal_int();
/* 2283 */         xbean.SkillResultHitMains _v_ = Pod.newSkillResultHitMainsData();
/* 2284 */         _v_.unmarshal(_os_);
/* 2285 */         this.skillhitmaintargetinfight.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2289 */       int size = _os_.uncompact_uint32();
/* 2290 */       if (size >= 12)
/*      */       {
/* 2292 */         this.skillbuffinfight = new HashMap(size * 2);
/*      */       }
/* 2294 */       for (; size > 0; size--)
/*      */       {
/* 2296 */         int _k_ = 0;
/* 2297 */         _k_ = _os_.unmarshal_int();
/* 2298 */         xbean.SkillBuffResult _v_ = Pod.newSkillBuffResultData();
/* 2299 */         _v_.unmarshal(_os_);
/* 2300 */         this.skillbuffinfight.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2304 */       int size = _os_.uncompact_uint32();
/* 2305 */       if (size >= 12)
/*      */       {
/* 2307 */         this.skillmirrorinfoinfight = new HashMap(size * 2);
/*      */       }
/* 2309 */       for (; size > 0; size--)
/*      */       {
/* 2311 */         int _k_ = 0;
/* 2312 */         _k_ = _os_.unmarshal_int();
/* 2313 */         xbean.SkillMirrorInfo _v_ = Pod.newSkillMirrorInfoData();
/* 2314 */         _v_.unmarshal(_os_);
/* 2315 */         this.skillmirrorinfoinfight.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 2318 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 2320 */         xbean.SkillShareDamageKillInfo _v_ = Pod.newSkillShareDamageKillInfoData();
/* 2321 */         _v_.unmarshal(_os_);
/* 2322 */         this.skillandsharedamagekillinfight.add(_v_);
/*      */       }
/* 2324 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 2330 */       int _size_ = 0;
/* 2331 */       for (Map.Entry<Integer, Integer> _e_ : this.skillkillcountinfight.entrySet())
/*      */       {
/* 2333 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 2334 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2336 */       for (Map.Entry<Integer, Integer> _e_ : this.skilltargetismaininfight.entrySet())
/*      */       {
/* 2338 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 2339 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2341 */       for (Map.Entry<Integer, Integer> _e_ : this.skillkillreborncountinfight.entrySet())
/*      */       {
/* 2343 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 2344 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2346 */       for (Map.Entry<Integer, Integer> _e_ : this.skillbedodgecountinfight.entrySet())
/*      */       {
/* 2348 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/* 2349 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2351 */       for (Map.Entry<Integer, Integer> _e_ : this.skillcriticalcountinround.entrySet())
/*      */       {
/* 2353 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/* 2354 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2356 */       for (Map.Entry<Integer, Integer> _e_ : this.skillkillcountinround.entrySet())
/*      */       {
/* 2358 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/* 2359 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2361 */       for (Map.Entry<Integer, Integer> _e_ : this.skilltargethplesscountinfight.entrySet())
/*      */       {
/* 2363 */         _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/* 2364 */         _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2366 */       for (Map.Entry<Integer, xbean.SkillResultKillMonsterInfo> _e_ : this.killmonster.entrySet())
/*      */       {
/* 2368 */         _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getKey()).intValue());
/* 2369 */         _size_ += CodedOutputStream.computeMessageSize(8, (Message)_e_.getValue());
/*      */       }
/* 2371 */       for (Map.Entry<Integer, Integer> _e_ : this.skillfailedcountinfight.entrySet())
/*      */       {
/* 2373 */         _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getKey()).intValue());
/* 2374 */         _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2376 */       for (Map.Entry<Integer, xbean.SkillReleaseRoundInfos> _e_ : this.skillreleaseroundsinfight.entrySet())
/*      */       {
/* 2378 */         _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getKey()).intValue());
/* 2379 */         _size_ += CodedOutputStream.computeMessageSize(10, (Message)_e_.getValue());
/*      */       }
/* 2381 */       for (Map.Entry<Integer, xbean.SkillResultAttackTimes> _e_ : this.skillattacktimesinfight.entrySet())
/*      */       {
/* 2383 */         _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getKey()).intValue());
/* 2384 */         _size_ += CodedOutputStream.computeMessageSize(11, (Message)_e_.getValue());
/*      */       }
/* 2386 */       for (Map.Entry<Integer, xbean.SkillResultHitMains> _e_ : this.skillhitmaintargetinfight.entrySet())
/*      */       {
/* 2388 */         _size_ += CodedOutputStream.computeInt32Size(12, ((Integer)_e_.getKey()).intValue());
/* 2389 */         _size_ += CodedOutputStream.computeMessageSize(12, (Message)_e_.getValue());
/*      */       }
/* 2391 */       for (Map.Entry<Integer, xbean.SkillBuffResult> _e_ : this.skillbuffinfight.entrySet())
/*      */       {
/* 2393 */         _size_ += CodedOutputStream.computeInt32Size(13, ((Integer)_e_.getKey()).intValue());
/* 2394 */         _size_ += CodedOutputStream.computeMessageSize(13, (Message)_e_.getValue());
/*      */       }
/* 2396 */       for (Map.Entry<Integer, xbean.SkillMirrorInfo> _e_ : this.skillmirrorinfoinfight.entrySet())
/*      */       {
/* 2398 */         _size_ += CodedOutputStream.computeInt32Size(14, ((Integer)_e_.getKey()).intValue());
/* 2399 */         _size_ += CodedOutputStream.computeMessageSize(14, (Message)_e_.getValue());
/*      */       }
/* 2401 */       for (xbean.SkillShareDamageKillInfo _v_ : this.skillandsharedamagekillinfight)
/*      */       {
/* 2403 */         _size_ += CodedOutputStream.computeMessageSize(15, _v_);
/*      */       }
/* 2405 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2413 */         for (Map.Entry<Integer, Integer> _e_ : this.skillkillcountinfight.entrySet())
/*      */         {
/* 2415 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 2416 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2418 */         for (Map.Entry<Integer, Integer> _e_ : this.skilltargetismaininfight.entrySet())
/*      */         {
/* 2420 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 2421 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2423 */         for (Map.Entry<Integer, Integer> _e_ : this.skillkillreborncountinfight.entrySet())
/*      */         {
/* 2425 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 2426 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2428 */         for (Map.Entry<Integer, Integer> _e_ : this.skillbedodgecountinfight.entrySet())
/*      */         {
/* 2430 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/* 2431 */           _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2433 */         for (Map.Entry<Integer, Integer> _e_ : this.skillcriticalcountinround.entrySet())
/*      */         {
/* 2435 */           _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/* 2436 */           _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2438 */         for (Map.Entry<Integer, Integer> _e_ : this.skillkillcountinround.entrySet())
/*      */         {
/* 2440 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/* 2441 */           _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2443 */         for (Map.Entry<Integer, Integer> _e_ : this.skilltargethplesscountinfight.entrySet())
/*      */         {
/* 2445 */           _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/* 2446 */           _output_.writeInt32(7, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2448 */         for (Map.Entry<Integer, xbean.SkillResultKillMonsterInfo> _e_ : this.killmonster.entrySet())
/*      */         {
/* 2450 */           _output_.writeInt32(8, ((Integer)_e_.getKey()).intValue());
/* 2451 */           _output_.writeMessage(8, (Message)_e_.getValue());
/*      */         }
/* 2453 */         for (Map.Entry<Integer, Integer> _e_ : this.skillfailedcountinfight.entrySet())
/*      */         {
/* 2455 */           _output_.writeInt32(9, ((Integer)_e_.getKey()).intValue());
/* 2456 */           _output_.writeInt32(9, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2458 */         for (Map.Entry<Integer, xbean.SkillReleaseRoundInfos> _e_ : this.skillreleaseroundsinfight.entrySet())
/*      */         {
/* 2460 */           _output_.writeInt32(10, ((Integer)_e_.getKey()).intValue());
/* 2461 */           _output_.writeMessage(10, (Message)_e_.getValue());
/*      */         }
/* 2463 */         for (Map.Entry<Integer, xbean.SkillResultAttackTimes> _e_ : this.skillattacktimesinfight.entrySet())
/*      */         {
/* 2465 */           _output_.writeInt32(11, ((Integer)_e_.getKey()).intValue());
/* 2466 */           _output_.writeMessage(11, (Message)_e_.getValue());
/*      */         }
/* 2468 */         for (Map.Entry<Integer, xbean.SkillResultHitMains> _e_ : this.skillhitmaintargetinfight.entrySet())
/*      */         {
/* 2470 */           _output_.writeInt32(12, ((Integer)_e_.getKey()).intValue());
/* 2471 */           _output_.writeMessage(12, (Message)_e_.getValue());
/*      */         }
/* 2473 */         for (Map.Entry<Integer, xbean.SkillBuffResult> _e_ : this.skillbuffinfight.entrySet())
/*      */         {
/* 2475 */           _output_.writeInt32(13, ((Integer)_e_.getKey()).intValue());
/* 2476 */           _output_.writeMessage(13, (Message)_e_.getValue());
/*      */         }
/* 2478 */         for (Map.Entry<Integer, xbean.SkillMirrorInfo> _e_ : this.skillmirrorinfoinfight.entrySet())
/*      */         {
/* 2480 */           _output_.writeInt32(14, ((Integer)_e_.getKey()).intValue());
/* 2481 */           _output_.writeMessage(14, (Message)_e_.getValue());
/*      */         }
/* 2483 */         for (xbean.SkillShareDamageKillInfo _v_ : this.skillandsharedamagekillinfight)
/*      */         {
/* 2485 */           _output_.writeMessage(15, _v_);
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2490 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2492 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2500 */         boolean done = false;
/* 2501 */         while (!done)
/*      */         {
/* 2503 */           int tag = _input_.readTag();
/* 2504 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 2508 */             done = true;
/* 2509 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 2513 */             int _k_ = 0;
/* 2514 */             _k_ = _input_.readInt32();
/* 2515 */             int readTag = _input_.readTag();
/* 2516 */             if (8 != readTag)
/*      */             {
/* 2518 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2520 */             int _v_ = 0;
/* 2521 */             _v_ = _input_.readInt32();
/* 2522 */             this.skillkillcountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2523 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 2527 */             int _k_ = 0;
/* 2528 */             _k_ = _input_.readInt32();
/* 2529 */             int readTag = _input_.readTag();
/* 2530 */             if (16 != readTag)
/*      */             {
/* 2532 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2534 */             int _v_ = 0;
/* 2535 */             _v_ = _input_.readInt32();
/* 2536 */             this.skilltargetismaininfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2537 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 2541 */             int _k_ = 0;
/* 2542 */             _k_ = _input_.readInt32();
/* 2543 */             int readTag = _input_.readTag();
/* 2544 */             if (24 != readTag)
/*      */             {
/* 2546 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2548 */             int _v_ = 0;
/* 2549 */             _v_ = _input_.readInt32();
/* 2550 */             this.skillkillreborncountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2551 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 2555 */             int _k_ = 0;
/* 2556 */             _k_ = _input_.readInt32();
/* 2557 */             int readTag = _input_.readTag();
/* 2558 */             if (32 != readTag)
/*      */             {
/* 2560 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2562 */             int _v_ = 0;
/* 2563 */             _v_ = _input_.readInt32();
/* 2564 */             this.skillbedodgecountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2565 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 2569 */             int _k_ = 0;
/* 2570 */             _k_ = _input_.readInt32();
/* 2571 */             int readTag = _input_.readTag();
/* 2572 */             if (40 != readTag)
/*      */             {
/* 2574 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2576 */             int _v_ = 0;
/* 2577 */             _v_ = _input_.readInt32();
/* 2578 */             this.skillcriticalcountinround.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2579 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 2583 */             int _k_ = 0;
/* 2584 */             _k_ = _input_.readInt32();
/* 2585 */             int readTag = _input_.readTag();
/* 2586 */             if (48 != readTag)
/*      */             {
/* 2588 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2590 */             int _v_ = 0;
/* 2591 */             _v_ = _input_.readInt32();
/* 2592 */             this.skillkillcountinround.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2593 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 2597 */             int _k_ = 0;
/* 2598 */             _k_ = _input_.readInt32();
/* 2599 */             int readTag = _input_.readTag();
/* 2600 */             if (56 != readTag)
/*      */             {
/* 2602 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2604 */             int _v_ = 0;
/* 2605 */             _v_ = _input_.readInt32();
/* 2606 */             this.skilltargethplesscountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2607 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 2611 */             int _k_ = 0;
/* 2612 */             _k_ = _input_.readInt32();
/* 2613 */             int readTag = _input_.readTag();
/* 2614 */             if (66 != readTag)
/*      */             {
/* 2616 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2618 */             xbean.SkillResultKillMonsterInfo _v_ = Pod.newSkillResultKillMonsterInfoData();
/* 2619 */             _input_.readMessage(_v_);
/* 2620 */             this.killmonster.put(Integer.valueOf(_k_), _v_);
/* 2621 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 2625 */             int _k_ = 0;
/* 2626 */             _k_ = _input_.readInt32();
/* 2627 */             int readTag = _input_.readTag();
/* 2628 */             if (72 != readTag)
/*      */             {
/* 2630 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2632 */             int _v_ = 0;
/* 2633 */             _v_ = _input_.readInt32();
/* 2634 */             this.skillfailedcountinfight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2635 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 2639 */             int _k_ = 0;
/* 2640 */             _k_ = _input_.readInt32();
/* 2641 */             int readTag = _input_.readTag();
/* 2642 */             if (82 != readTag)
/*      */             {
/* 2644 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2646 */             xbean.SkillReleaseRoundInfos _v_ = Pod.newSkillReleaseRoundInfosData();
/* 2647 */             _input_.readMessage(_v_);
/* 2648 */             this.skillreleaseroundsinfight.put(Integer.valueOf(_k_), _v_);
/* 2649 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 2653 */             int _k_ = 0;
/* 2654 */             _k_ = _input_.readInt32();
/* 2655 */             int readTag = _input_.readTag();
/* 2656 */             if (90 != readTag)
/*      */             {
/* 2658 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2660 */             xbean.SkillResultAttackTimes _v_ = Pod.newSkillResultAttackTimesData();
/* 2661 */             _input_.readMessage(_v_);
/* 2662 */             this.skillattacktimesinfight.put(Integer.valueOf(_k_), _v_);
/* 2663 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 2667 */             int _k_ = 0;
/* 2668 */             _k_ = _input_.readInt32();
/* 2669 */             int readTag = _input_.readTag();
/* 2670 */             if (98 != readTag)
/*      */             {
/* 2672 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2674 */             xbean.SkillResultHitMains _v_ = Pod.newSkillResultHitMainsData();
/* 2675 */             _input_.readMessage(_v_);
/* 2676 */             this.skillhitmaintargetinfight.put(Integer.valueOf(_k_), _v_);
/* 2677 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 2681 */             int _k_ = 0;
/* 2682 */             _k_ = _input_.readInt32();
/* 2683 */             int readTag = _input_.readTag();
/* 2684 */             if (106 != readTag)
/*      */             {
/* 2686 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2688 */             xbean.SkillBuffResult _v_ = Pod.newSkillBuffResultData();
/* 2689 */             _input_.readMessage(_v_);
/* 2690 */             this.skillbuffinfight.put(Integer.valueOf(_k_), _v_);
/* 2691 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 2695 */             int _k_ = 0;
/* 2696 */             _k_ = _input_.readInt32();
/* 2697 */             int readTag = _input_.readTag();
/* 2698 */             if (114 != readTag)
/*      */             {
/* 2700 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2702 */             xbean.SkillMirrorInfo _v_ = Pod.newSkillMirrorInfoData();
/* 2703 */             _input_.readMessage(_v_);
/* 2704 */             this.skillmirrorinfoinfight.put(Integer.valueOf(_k_), _v_);
/* 2705 */             break;
/*      */           
/*      */ 
/*      */           case 122: 
/* 2709 */             xbean.SkillShareDamageKillInfo _v_ = Pod.newSkillShareDamageKillInfoData();
/* 2710 */             _input_.readMessage(_v_);
/* 2711 */             this.skillandsharedamagekillinfight.add(_v_);
/* 2712 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 2716 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 2718 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 2727 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2731 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2733 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SkillResult copy()
/*      */     {
/* 2739 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SkillResult toData()
/*      */     {
/* 2745 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.SkillResult toBean()
/*      */     {
/* 2750 */       return new SkillResult(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SkillResult toDataIf()
/*      */     {
/* 2756 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.SkillResult toBeanIf()
/*      */     {
/* 2761 */       return new SkillResult(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2767 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 2771 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 2775 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 2779 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 2783 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 2787 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 2791 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillkillcountinfight()
/*      */     {
/* 2798 */       return this.skillkillcountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillkillcountinfightAsData()
/*      */     {
/* 2805 */       return this.skillkillcountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkilltargetismaininfight()
/*      */     {
/* 2812 */       return this.skilltargetismaininfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkilltargetismaininfightAsData()
/*      */     {
/* 2819 */       return this.skilltargetismaininfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillkillreborncountinfight()
/*      */     {
/* 2826 */       return this.skillkillreborncountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillkillreborncountinfightAsData()
/*      */     {
/* 2833 */       return this.skillkillreborncountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillbedodgecountinfight()
/*      */     {
/* 2840 */       return this.skillbedodgecountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillbedodgecountinfightAsData()
/*      */     {
/* 2847 */       return this.skillbedodgecountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillcriticalcountinround()
/*      */     {
/* 2854 */       return this.skillcriticalcountinround;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillcriticalcountinroundAsData()
/*      */     {
/* 2861 */       return this.skillcriticalcountinround;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillkillcountinround()
/*      */     {
/* 2868 */       return this.skillkillcountinround;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillkillcountinroundAsData()
/*      */     {
/* 2875 */       return this.skillkillcountinround;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkilltargethplesscountinfight()
/*      */     {
/* 2882 */       return this.skilltargethplesscountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkilltargethplesscountinfightAsData()
/*      */     {
/* 2889 */       return this.skilltargethplesscountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillResultKillMonsterInfo> getKillmonster()
/*      */     {
/* 2896 */       return this.killmonster;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillResultKillMonsterInfo> getKillmonsterAsData()
/*      */     {
/* 2903 */       return this.killmonster;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillfailedcountinfight()
/*      */     {
/* 2910 */       return this.skillfailedcountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSkillfailedcountinfightAsData()
/*      */     {
/* 2917 */       return this.skillfailedcountinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillReleaseRoundInfos> getSkillreleaseroundsinfight()
/*      */     {
/* 2924 */       return this.skillreleaseroundsinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillReleaseRoundInfos> getSkillreleaseroundsinfightAsData()
/*      */     {
/* 2931 */       return this.skillreleaseroundsinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillResultAttackTimes> getSkillattacktimesinfight()
/*      */     {
/* 2938 */       return this.skillattacktimesinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillResultAttackTimes> getSkillattacktimesinfightAsData()
/*      */     {
/* 2945 */       return this.skillattacktimesinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillResultHitMains> getSkillhitmaintargetinfight()
/*      */     {
/* 2952 */       return this.skillhitmaintargetinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillResultHitMains> getSkillhitmaintargetinfightAsData()
/*      */     {
/* 2959 */       return this.skillhitmaintargetinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillBuffResult> getSkillbuffinfight()
/*      */     {
/* 2966 */       return this.skillbuffinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillBuffResult> getSkillbuffinfightAsData()
/*      */     {
/* 2973 */       return this.skillbuffinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillMirrorInfo> getSkillmirrorinfoinfight()
/*      */     {
/* 2980 */       return this.skillmirrorinfoinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.SkillMirrorInfo> getSkillmirrorinfoinfightAsData()
/*      */     {
/* 2987 */       return this.skillmirrorinfoinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.SkillShareDamageKillInfo> getSkillandsharedamagekillinfight()
/*      */     {
/* 2994 */       return this.skillandsharedamagekillinfight;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.SkillShareDamageKillInfo> getSkillandsharedamagekillinfightAsData()
/*      */     {
/* 3001 */       return this.skillandsharedamagekillinfight;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 3007 */       if (!(_o1_ instanceof Data)) return false;
/* 3008 */       Data _o_ = (Data)_o1_;
/* 3009 */       if (!this.skillkillcountinfight.equals(_o_.skillkillcountinfight)) return false;
/* 3010 */       if (!this.skilltargetismaininfight.equals(_o_.skilltargetismaininfight)) return false;
/* 3011 */       if (!this.skillkillreborncountinfight.equals(_o_.skillkillreborncountinfight)) return false;
/* 3012 */       if (!this.skillbedodgecountinfight.equals(_o_.skillbedodgecountinfight)) return false;
/* 3013 */       if (!this.skillcriticalcountinround.equals(_o_.skillcriticalcountinround)) return false;
/* 3014 */       if (!this.skillkillcountinround.equals(_o_.skillkillcountinround)) return false;
/* 3015 */       if (!this.skilltargethplesscountinfight.equals(_o_.skilltargethplesscountinfight)) return false;
/* 3016 */       if (!this.killmonster.equals(_o_.killmonster)) return false;
/* 3017 */       if (!this.skillfailedcountinfight.equals(_o_.skillfailedcountinfight)) return false;
/* 3018 */       if (!this.skillreleaseroundsinfight.equals(_o_.skillreleaseroundsinfight)) return false;
/* 3019 */       if (!this.skillattacktimesinfight.equals(_o_.skillattacktimesinfight)) return false;
/* 3020 */       if (!this.skillhitmaintargetinfight.equals(_o_.skillhitmaintargetinfight)) return false;
/* 3021 */       if (!this.skillbuffinfight.equals(_o_.skillbuffinfight)) return false;
/* 3022 */       if (!this.skillmirrorinfoinfight.equals(_o_.skillmirrorinfoinfight)) return false;
/* 3023 */       if (!this.skillandsharedamagekillinfight.equals(_o_.skillandsharedamagekillinfight)) return false;
/* 3024 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 3030 */       int _h_ = 0;
/* 3031 */       _h_ += this.skillkillcountinfight.hashCode();
/* 3032 */       _h_ += this.skilltargetismaininfight.hashCode();
/* 3033 */       _h_ += this.skillkillreborncountinfight.hashCode();
/* 3034 */       _h_ += this.skillbedodgecountinfight.hashCode();
/* 3035 */       _h_ += this.skillcriticalcountinround.hashCode();
/* 3036 */       _h_ += this.skillkillcountinround.hashCode();
/* 3037 */       _h_ += this.skilltargethplesscountinfight.hashCode();
/* 3038 */       _h_ += this.killmonster.hashCode();
/* 3039 */       _h_ += this.skillfailedcountinfight.hashCode();
/* 3040 */       _h_ += this.skillreleaseroundsinfight.hashCode();
/* 3041 */       _h_ += this.skillattacktimesinfight.hashCode();
/* 3042 */       _h_ += this.skillhitmaintargetinfight.hashCode();
/* 3043 */       _h_ += this.skillbuffinfight.hashCode();
/* 3044 */       _h_ += this.skillmirrorinfoinfight.hashCode();
/* 3045 */       _h_ += this.skillandsharedamagekillinfight.hashCode();
/* 3046 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 3052 */       StringBuilder _sb_ = new StringBuilder();
/* 3053 */       _sb_.append("(");
/* 3054 */       _sb_.append(this.skillkillcountinfight);
/* 3055 */       _sb_.append(",");
/* 3056 */       _sb_.append(this.skilltargetismaininfight);
/* 3057 */       _sb_.append(",");
/* 3058 */       _sb_.append(this.skillkillreborncountinfight);
/* 3059 */       _sb_.append(",");
/* 3060 */       _sb_.append(this.skillbedodgecountinfight);
/* 3061 */       _sb_.append(",");
/* 3062 */       _sb_.append(this.skillcriticalcountinround);
/* 3063 */       _sb_.append(",");
/* 3064 */       _sb_.append(this.skillkillcountinround);
/* 3065 */       _sb_.append(",");
/* 3066 */       _sb_.append(this.skilltargethplesscountinfight);
/* 3067 */       _sb_.append(",");
/* 3068 */       _sb_.append(this.killmonster);
/* 3069 */       _sb_.append(",");
/* 3070 */       _sb_.append(this.skillfailedcountinfight);
/* 3071 */       _sb_.append(",");
/* 3072 */       _sb_.append(this.skillreleaseroundsinfight);
/* 3073 */       _sb_.append(",");
/* 3074 */       _sb_.append(this.skillattacktimesinfight);
/* 3075 */       _sb_.append(",");
/* 3076 */       _sb_.append(this.skillhitmaintargetinfight);
/* 3077 */       _sb_.append(",");
/* 3078 */       _sb_.append(this.skillbuffinfight);
/* 3079 */       _sb_.append(",");
/* 3080 */       _sb_.append(this.skillmirrorinfoinfight);
/* 3081 */       _sb_.append(",");
/* 3082 */       _sb_.append(this.skillandsharedamagekillinfight);
/* 3083 */       _sb_.append(")");
/* 3084 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SkillResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */