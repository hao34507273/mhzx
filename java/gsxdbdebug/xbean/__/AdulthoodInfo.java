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
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableMap;
/*      */ import xdb.logs.LogFloat;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class AdulthoodInfo
/*      */   extends XBean
/*      */   implements xbean.AdulthoodInfo
/*      */ {
/*      */   private int occupation;
/*      */   private HashMap<Integer, Integer> aptitudeinitmap;
/*      */   private HashMap<Integer, Integer> aptitudechangemap;
/*      */   private int useaptitudeitemcount;
/*      */   private int usegrowthitemcount;
/*      */   private HashMap<Integer, Integer> occupationskill2value;
/*      */   private ArrayList<Integer> fightskills;
/*      */   private ArrayList<Integer> skillbookskills;
/*      */   private int specialskillid;
/*      */   private HashMap<Integer, Integer> basepropset;
/*      */   private HashMap<Integer, Integer> basepropmap;
/*      */   private int potentialpoint;
/*      */   private int hp;
/*      */   private int mp;
/*      */   private float grow;
/*      */   private int unlockskillposnum;
/*      */   private int modelcfgid;
/*      */   private int character;
/*      */   private HashMap<Integer, xbean.Item> equipitem;
/*      */   private HashMap<Integer, xbean.Item> equippetitem;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   56 */     this.occupation = -1;
/*   57 */     this.aptitudeinitmap.clear();
/*   58 */     this.aptitudechangemap.clear();
/*   59 */     this.useaptitudeitemcount = 0;
/*   60 */     this.usegrowthitemcount = 0;
/*   61 */     this.occupationskill2value.clear();
/*   62 */     this.fightskills.clear();
/*   63 */     this.skillbookskills.clear();
/*   64 */     this.specialskillid = 0;
/*   65 */     this.basepropset.clear();
/*   66 */     this.basepropmap.clear();
/*   67 */     this.potentialpoint = 0;
/*   68 */     this.hp = 0;
/*   69 */     this.mp = 0;
/*   70 */     this.grow = 0.0F;
/*   71 */     this.unlockskillposnum = 0;
/*   72 */     this.modelcfgid = 0;
/*   73 */     this.character = 0;
/*   74 */     this.equipitem.clear();
/*   75 */     this.equippetitem.clear();
/*      */   }
/*      */   
/*      */   AdulthoodInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   80 */     super(_xp_, _vn_);
/*   81 */     this.occupation = -1;
/*   82 */     this.aptitudeinitmap = new HashMap();
/*   83 */     this.aptitudechangemap = new HashMap();
/*   84 */     this.occupationskill2value = new HashMap();
/*   85 */     this.fightskills = new ArrayList();
/*   86 */     this.skillbookskills = new ArrayList();
/*   87 */     this.basepropset = new HashMap();
/*   88 */     this.basepropmap = new HashMap();
/*   89 */     this.unlockskillposnum = 0;
/*   90 */     this.equipitem = new HashMap();
/*   91 */     this.equippetitem = new HashMap();
/*      */   }
/*      */   
/*      */   public AdulthoodInfo()
/*      */   {
/*   96 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public AdulthoodInfo(AdulthoodInfo _o_)
/*      */   {
/*  101 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   AdulthoodInfo(xbean.AdulthoodInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*  106 */     super(_xp_, _vn_);
/*  107 */     if ((_o1_ instanceof AdulthoodInfo)) { assign((AdulthoodInfo)_o1_);
/*  108 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  109 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  110 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(AdulthoodInfo _o_) {
/*  115 */     _o_._xdb_verify_unsafe_();
/*  116 */     this.occupation = _o_.occupation;
/*  117 */     this.aptitudeinitmap = new HashMap();
/*  118 */     for (Map.Entry<Integer, Integer> _e_ : _o_.aptitudeinitmap.entrySet())
/*  119 */       this.aptitudeinitmap.put(_e_.getKey(), _e_.getValue());
/*  120 */     this.aptitudechangemap = new HashMap();
/*  121 */     for (Map.Entry<Integer, Integer> _e_ : _o_.aptitudechangemap.entrySet())
/*  122 */       this.aptitudechangemap.put(_e_.getKey(), _e_.getValue());
/*  123 */     this.useaptitudeitemcount = _o_.useaptitudeitemcount;
/*  124 */     this.usegrowthitemcount = _o_.usegrowthitemcount;
/*  125 */     this.occupationskill2value = new HashMap();
/*  126 */     for (Map.Entry<Integer, Integer> _e_ : _o_.occupationskill2value.entrySet())
/*  127 */       this.occupationskill2value.put(_e_.getKey(), _e_.getValue());
/*  128 */     this.fightskills = new ArrayList();
/*  129 */     this.fightskills.addAll(_o_.fightskills);
/*  130 */     this.skillbookskills = new ArrayList();
/*  131 */     this.skillbookskills.addAll(_o_.skillbookskills);
/*  132 */     this.specialskillid = _o_.specialskillid;
/*  133 */     this.basepropset = new HashMap();
/*  134 */     for (Map.Entry<Integer, Integer> _e_ : _o_.basepropset.entrySet())
/*  135 */       this.basepropset.put(_e_.getKey(), _e_.getValue());
/*  136 */     this.basepropmap = new HashMap();
/*  137 */     for (Map.Entry<Integer, Integer> _e_ : _o_.basepropmap.entrySet())
/*  138 */       this.basepropmap.put(_e_.getKey(), _e_.getValue());
/*  139 */     this.potentialpoint = _o_.potentialpoint;
/*  140 */     this.hp = _o_.hp;
/*  141 */     this.mp = _o_.mp;
/*  142 */     this.grow = _o_.grow;
/*  143 */     this.unlockskillposnum = _o_.unlockskillposnum;
/*  144 */     this.modelcfgid = _o_.modelcfgid;
/*  145 */     this.character = _o_.character;
/*  146 */     this.equipitem = new HashMap();
/*  147 */     for (Map.Entry<Integer, xbean.Item> _e_ : _o_.equipitem.entrySet())
/*  148 */       this.equipitem.put(_e_.getKey(), new Item((xbean.Item)_e_.getValue(), this, "equipitem"));
/*  149 */     this.equippetitem = new HashMap();
/*  150 */     for (Map.Entry<Integer, xbean.Item> _e_ : _o_.equippetitem.entrySet()) {
/*  151 */       this.equippetitem.put(_e_.getKey(), new Item((xbean.Item)_e_.getValue(), this, "equippetitem"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*  156 */     this.occupation = _o_.occupation;
/*  157 */     this.aptitudeinitmap = new HashMap();
/*  158 */     for (Map.Entry<Integer, Integer> _e_ : _o_.aptitudeinitmap.entrySet())
/*  159 */       this.aptitudeinitmap.put(_e_.getKey(), _e_.getValue());
/*  160 */     this.aptitudechangemap = new HashMap();
/*  161 */     for (Map.Entry<Integer, Integer> _e_ : _o_.aptitudechangemap.entrySet())
/*  162 */       this.aptitudechangemap.put(_e_.getKey(), _e_.getValue());
/*  163 */     this.useaptitudeitemcount = _o_.useaptitudeitemcount;
/*  164 */     this.usegrowthitemcount = _o_.usegrowthitemcount;
/*  165 */     this.occupationskill2value = new HashMap();
/*  166 */     for (Map.Entry<Integer, Integer> _e_ : _o_.occupationskill2value.entrySet())
/*  167 */       this.occupationskill2value.put(_e_.getKey(), _e_.getValue());
/*  168 */     this.fightskills = new ArrayList();
/*  169 */     this.fightskills.addAll(_o_.fightskills);
/*  170 */     this.skillbookskills = new ArrayList();
/*  171 */     this.skillbookskills.addAll(_o_.skillbookskills);
/*  172 */     this.specialskillid = _o_.specialskillid;
/*  173 */     this.basepropset = new HashMap();
/*  174 */     for (Map.Entry<Integer, Integer> _e_ : _o_.basepropset.entrySet())
/*  175 */       this.basepropset.put(_e_.getKey(), _e_.getValue());
/*  176 */     this.basepropmap = new HashMap();
/*  177 */     for (Map.Entry<Integer, Integer> _e_ : _o_.basepropmap.entrySet())
/*  178 */       this.basepropmap.put(_e_.getKey(), _e_.getValue());
/*  179 */     this.potentialpoint = _o_.potentialpoint;
/*  180 */     this.hp = _o_.hp;
/*  181 */     this.mp = _o_.mp;
/*  182 */     this.grow = _o_.grow;
/*  183 */     this.unlockskillposnum = _o_.unlockskillposnum;
/*  184 */     this.modelcfgid = _o_.modelcfgid;
/*  185 */     this.character = _o_.character;
/*  186 */     this.equipitem = new HashMap();
/*  187 */     for (Map.Entry<Integer, xbean.Item> _e_ : _o_.equipitem.entrySet())
/*  188 */       this.equipitem.put(_e_.getKey(), new Item((xbean.Item)_e_.getValue(), this, "equipitem"));
/*  189 */     this.equippetitem = new HashMap();
/*  190 */     for (Map.Entry<Integer, xbean.Item> _e_ : _o_.equippetitem.entrySet()) {
/*  191 */       this.equippetitem.put(_e_.getKey(), new Item((xbean.Item)_e_.getValue(), this, "equippetitem"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  197 */     _xdb_verify_unsafe_();
/*  198 */     _os_.marshal(this.occupation);
/*  199 */     _os_.compact_uint32(this.aptitudeinitmap.size());
/*  200 */     for (Map.Entry<Integer, Integer> _e_ : this.aptitudeinitmap.entrySet())
/*      */     {
/*  202 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  203 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  205 */     _os_.compact_uint32(this.aptitudechangemap.size());
/*  206 */     for (Map.Entry<Integer, Integer> _e_ : this.aptitudechangemap.entrySet())
/*      */     {
/*  208 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  209 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  211 */     _os_.marshal(this.useaptitudeitemcount);
/*  212 */     _os_.marshal(this.usegrowthitemcount);
/*  213 */     _os_.compact_uint32(this.occupationskill2value.size());
/*  214 */     for (Map.Entry<Integer, Integer> _e_ : this.occupationskill2value.entrySet())
/*      */     {
/*  216 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  217 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  219 */     _os_.compact_uint32(this.fightskills.size());
/*  220 */     for (Integer _v_ : this.fightskills)
/*      */     {
/*  222 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  224 */     _os_.compact_uint32(this.skillbookskills.size());
/*  225 */     for (Integer _v_ : this.skillbookskills)
/*      */     {
/*  227 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  229 */     _os_.marshal(this.specialskillid);
/*  230 */     _os_.compact_uint32(this.basepropset.size());
/*  231 */     for (Map.Entry<Integer, Integer> _e_ : this.basepropset.entrySet())
/*      */     {
/*  233 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  234 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  236 */     _os_.compact_uint32(this.basepropmap.size());
/*  237 */     for (Map.Entry<Integer, Integer> _e_ : this.basepropmap.entrySet())
/*      */     {
/*  239 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  240 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  242 */     _os_.marshal(this.potentialpoint);
/*  243 */     _os_.marshal(this.hp);
/*  244 */     _os_.marshal(this.mp);
/*  245 */     _os_.marshal(this.grow);
/*  246 */     _os_.marshal(this.unlockskillposnum);
/*  247 */     _os_.marshal(this.modelcfgid);
/*  248 */     _os_.marshal(this.character);
/*  249 */     _os_.compact_uint32(this.equipitem.size());
/*  250 */     for (Map.Entry<Integer, xbean.Item> _e_ : this.equipitem.entrySet())
/*      */     {
/*  252 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  253 */       ((xbean.Item)_e_.getValue()).marshal(_os_);
/*      */     }
/*  255 */     _os_.compact_uint32(this.equippetitem.size());
/*  256 */     for (Map.Entry<Integer, xbean.Item> _e_ : this.equippetitem.entrySet())
/*      */     {
/*  258 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  259 */       ((xbean.Item)_e_.getValue()).marshal(_os_);
/*      */     }
/*  261 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     this.occupation = _os_.unmarshal_int();
/*      */     
/*  270 */     int size = _os_.uncompact_uint32();
/*  271 */     if (size >= 12)
/*      */     {
/*  273 */       this.aptitudeinitmap = new HashMap(size * 2);
/*      */     }
/*  275 */     for (; size > 0; size--)
/*      */     {
/*  277 */       int _k_ = 0;
/*  278 */       _k_ = _os_.unmarshal_int();
/*  279 */       int _v_ = 0;
/*  280 */       _v_ = _os_.unmarshal_int();
/*  281 */       this.aptitudeinitmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  285 */     int size = _os_.uncompact_uint32();
/*  286 */     if (size >= 12)
/*      */     {
/*  288 */       this.aptitudechangemap = new HashMap(size * 2);
/*      */     }
/*  290 */     for (; size > 0; size--)
/*      */     {
/*  292 */       int _k_ = 0;
/*  293 */       _k_ = _os_.unmarshal_int();
/*  294 */       int _v_ = 0;
/*  295 */       _v_ = _os_.unmarshal_int();
/*  296 */       this.aptitudechangemap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  299 */     this.useaptitudeitemcount = _os_.unmarshal_int();
/*  300 */     this.usegrowthitemcount = _os_.unmarshal_int();
/*      */     
/*  302 */     int size = _os_.uncompact_uint32();
/*  303 */     if (size >= 12)
/*      */     {
/*  305 */       this.occupationskill2value = new HashMap(size * 2);
/*      */     }
/*  307 */     for (; size > 0; size--)
/*      */     {
/*  309 */       int _k_ = 0;
/*  310 */       _k_ = _os_.unmarshal_int();
/*  311 */       int _v_ = 0;
/*  312 */       _v_ = _os_.unmarshal_int();
/*  313 */       this.occupationskill2value.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  316 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  318 */       int _v_ = 0;
/*  319 */       _v_ = _os_.unmarshal_int();
/*  320 */       this.fightskills.add(Integer.valueOf(_v_));
/*      */     }
/*  322 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  324 */       int _v_ = 0;
/*  325 */       _v_ = _os_.unmarshal_int();
/*  326 */       this.skillbookskills.add(Integer.valueOf(_v_));
/*      */     }
/*  328 */     this.specialskillid = _os_.unmarshal_int();
/*      */     
/*  330 */     int size = _os_.uncompact_uint32();
/*  331 */     if (size >= 12)
/*      */     {
/*  333 */       this.basepropset = new HashMap(size * 2);
/*      */     }
/*  335 */     for (; size > 0; size--)
/*      */     {
/*  337 */       int _k_ = 0;
/*  338 */       _k_ = _os_.unmarshal_int();
/*  339 */       int _v_ = 0;
/*  340 */       _v_ = _os_.unmarshal_int();
/*  341 */       this.basepropset.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  345 */     int size = _os_.uncompact_uint32();
/*  346 */     if (size >= 12)
/*      */     {
/*  348 */       this.basepropmap = new HashMap(size * 2);
/*      */     }
/*  350 */     for (; size > 0; size--)
/*      */     {
/*  352 */       int _k_ = 0;
/*  353 */       _k_ = _os_.unmarshal_int();
/*  354 */       int _v_ = 0;
/*  355 */       _v_ = _os_.unmarshal_int();
/*  356 */       this.basepropmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  359 */     this.potentialpoint = _os_.unmarshal_int();
/*  360 */     this.hp = _os_.unmarshal_int();
/*  361 */     this.mp = _os_.unmarshal_int();
/*  362 */     this.grow = _os_.unmarshal_float();
/*  363 */     this.unlockskillposnum = _os_.unmarshal_int();
/*  364 */     this.modelcfgid = _os_.unmarshal_int();
/*  365 */     this.character = _os_.unmarshal_int();
/*      */     
/*  367 */     int size = _os_.uncompact_uint32();
/*  368 */     if (size >= 12)
/*      */     {
/*  370 */       this.equipitem = new HashMap(size * 2);
/*      */     }
/*  372 */     for (; size > 0; size--)
/*      */     {
/*  374 */       int _k_ = 0;
/*  375 */       _k_ = _os_.unmarshal_int();
/*  376 */       xbean.Item _v_ = new Item(0, this, "equipitem");
/*  377 */       _v_.unmarshal(_os_);
/*  378 */       this.equipitem.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  382 */     int size = _os_.uncompact_uint32();
/*  383 */     if (size >= 12)
/*      */     {
/*  385 */       this.equippetitem = new HashMap(size * 2);
/*      */     }
/*  387 */     for (; size > 0; size--)
/*      */     {
/*  389 */       int _k_ = 0;
/*  390 */       _k_ = _os_.unmarshal_int();
/*  391 */       xbean.Item _v_ = new Item(0, this, "equippetitem");
/*  392 */       _v_.unmarshal(_os_);
/*  393 */       this.equippetitem.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  396 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  402 */     _xdb_verify_unsafe_();
/*  403 */     int _size_ = 0;
/*  404 */     _size_ += CodedOutputStream.computeInt32Size(1, this.occupation);
/*  405 */     for (Map.Entry<Integer, Integer> _e_ : this.aptitudeinitmap.entrySet())
/*      */     {
/*  407 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  408 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  410 */     for (Map.Entry<Integer, Integer> _e_ : this.aptitudechangemap.entrySet())
/*      */     {
/*  412 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  413 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  415 */     _size_ += CodedOutputStream.computeInt32Size(4, this.useaptitudeitemcount);
/*  416 */     _size_ += CodedOutputStream.computeInt32Size(5, this.usegrowthitemcount);
/*  417 */     for (Map.Entry<Integer, Integer> _e_ : this.occupationskill2value.entrySet())
/*      */     {
/*  419 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  420 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  422 */     for (Integer _v_ : this.fightskills)
/*      */     {
/*  424 */       _size_ += CodedOutputStream.computeInt32Size(7, _v_.intValue());
/*      */     }
/*  426 */     for (Integer _v_ : this.skillbookskills)
/*      */     {
/*  428 */       _size_ += CodedOutputStream.computeInt32Size(8, _v_.intValue());
/*      */     }
/*  430 */     _size_ += CodedOutputStream.computeInt32Size(9, this.specialskillid);
/*  431 */     for (Map.Entry<Integer, Integer> _e_ : this.basepropset.entrySet())
/*      */     {
/*  433 */       _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getKey()).intValue());
/*  434 */       _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  436 */     for (Map.Entry<Integer, Integer> _e_ : this.basepropmap.entrySet())
/*      */     {
/*  438 */       _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getKey()).intValue());
/*  439 */       _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  441 */     _size_ += CodedOutputStream.computeInt32Size(12, this.potentialpoint);
/*  442 */     _size_ += CodedOutputStream.computeInt32Size(13, this.hp);
/*  443 */     _size_ += CodedOutputStream.computeInt32Size(14, this.mp);
/*  444 */     _size_ += CodedOutputStream.computeFloatSize(15, this.grow);
/*  445 */     _size_ += CodedOutputStream.computeInt32Size(16, this.unlockskillposnum);
/*  446 */     _size_ += CodedOutputStream.computeInt32Size(17, this.modelcfgid);
/*  447 */     _size_ += CodedOutputStream.computeInt32Size(18, this.character);
/*  448 */     for (Map.Entry<Integer, xbean.Item> _e_ : this.equipitem.entrySet())
/*      */     {
/*  450 */       _size_ += CodedOutputStream.computeInt32Size(19, ((Integer)_e_.getKey()).intValue());
/*  451 */       _size_ += CodedOutputStream.computeMessageSize(19, (Message)_e_.getValue());
/*      */     }
/*  453 */     for (Map.Entry<Integer, xbean.Item> _e_ : this.equippetitem.entrySet())
/*      */     {
/*  455 */       _size_ += CodedOutputStream.computeInt32Size(20, ((Integer)_e_.getKey()).intValue());
/*  456 */       _size_ += CodedOutputStream.computeMessageSize(20, (Message)_e_.getValue());
/*      */     }
/*  458 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  467 */       _output_.writeInt32(1, this.occupation);
/*  468 */       for (Map.Entry<Integer, Integer> _e_ : this.aptitudeinitmap.entrySet())
/*      */       {
/*  470 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  471 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  473 */       for (Map.Entry<Integer, Integer> _e_ : this.aptitudechangemap.entrySet())
/*      */       {
/*  475 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  476 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  478 */       _output_.writeInt32(4, this.useaptitudeitemcount);
/*  479 */       _output_.writeInt32(5, this.usegrowthitemcount);
/*  480 */       for (Map.Entry<Integer, Integer> _e_ : this.occupationskill2value.entrySet())
/*      */       {
/*  482 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  483 */         _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  485 */       for (Integer _v_ : this.fightskills)
/*      */       {
/*  487 */         _output_.writeInt32(7, _v_.intValue());
/*      */       }
/*  489 */       for (Integer _v_ : this.skillbookskills)
/*      */       {
/*  491 */         _output_.writeInt32(8, _v_.intValue());
/*      */       }
/*  493 */       _output_.writeInt32(9, this.specialskillid);
/*  494 */       for (Map.Entry<Integer, Integer> _e_ : this.basepropset.entrySet())
/*      */       {
/*  496 */         _output_.writeInt32(10, ((Integer)_e_.getKey()).intValue());
/*  497 */         _output_.writeInt32(10, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  499 */       for (Map.Entry<Integer, Integer> _e_ : this.basepropmap.entrySet())
/*      */       {
/*  501 */         _output_.writeInt32(11, ((Integer)_e_.getKey()).intValue());
/*  502 */         _output_.writeInt32(11, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  504 */       _output_.writeInt32(12, this.potentialpoint);
/*  505 */       _output_.writeInt32(13, this.hp);
/*  506 */       _output_.writeInt32(14, this.mp);
/*  507 */       _output_.writeFloat(15, this.grow);
/*  508 */       _output_.writeInt32(16, this.unlockskillposnum);
/*  509 */       _output_.writeInt32(17, this.modelcfgid);
/*  510 */       _output_.writeInt32(18, this.character);
/*  511 */       for (Map.Entry<Integer, xbean.Item> _e_ : this.equipitem.entrySet())
/*      */       {
/*  513 */         _output_.writeInt32(19, ((Integer)_e_.getKey()).intValue());
/*  514 */         _output_.writeMessage(19, (Message)_e_.getValue());
/*      */       }
/*  516 */       for (Map.Entry<Integer, xbean.Item> _e_ : this.equippetitem.entrySet())
/*      */       {
/*  518 */         _output_.writeInt32(20, ((Integer)_e_.getKey()).intValue());
/*  519 */         _output_.writeMessage(20, (Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  524 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  526 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  532 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  535 */       boolean done = false;
/*  536 */       while (!done)
/*      */       {
/*  538 */         int tag = _input_.readTag();
/*  539 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  543 */           done = true;
/*  544 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  548 */           this.occupation = _input_.readInt32();
/*  549 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  553 */           int _k_ = 0;
/*  554 */           _k_ = _input_.readInt32();
/*  555 */           int readTag = _input_.readTag();
/*  556 */           if (16 != readTag)
/*      */           {
/*  558 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  560 */           int _v_ = 0;
/*  561 */           _v_ = _input_.readInt32();
/*  562 */           this.aptitudeinitmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  563 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  567 */           int _k_ = 0;
/*  568 */           _k_ = _input_.readInt32();
/*  569 */           int readTag = _input_.readTag();
/*  570 */           if (24 != readTag)
/*      */           {
/*  572 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  574 */           int _v_ = 0;
/*  575 */           _v_ = _input_.readInt32();
/*  576 */           this.aptitudechangemap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  577 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  581 */           this.useaptitudeitemcount = _input_.readInt32();
/*  582 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  586 */           this.usegrowthitemcount = _input_.readInt32();
/*  587 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  591 */           int _k_ = 0;
/*  592 */           _k_ = _input_.readInt32();
/*  593 */           int readTag = _input_.readTag();
/*  594 */           if (48 != readTag)
/*      */           {
/*  596 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  598 */           int _v_ = 0;
/*  599 */           _v_ = _input_.readInt32();
/*  600 */           this.occupationskill2value.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  601 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  605 */           int _v_ = 0;
/*  606 */           _v_ = _input_.readInt32();
/*  607 */           this.fightskills.add(Integer.valueOf(_v_));
/*  608 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  612 */           int _v_ = 0;
/*  613 */           _v_ = _input_.readInt32();
/*  614 */           this.skillbookskills.add(Integer.valueOf(_v_));
/*  615 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  619 */           this.specialskillid = _input_.readInt32();
/*  620 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  624 */           int _k_ = 0;
/*  625 */           _k_ = _input_.readInt32();
/*  626 */           int readTag = _input_.readTag();
/*  627 */           if (80 != readTag)
/*      */           {
/*  629 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  631 */           int _v_ = 0;
/*  632 */           _v_ = _input_.readInt32();
/*  633 */           this.basepropset.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  634 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  638 */           int _k_ = 0;
/*  639 */           _k_ = _input_.readInt32();
/*  640 */           int readTag = _input_.readTag();
/*  641 */           if (88 != readTag)
/*      */           {
/*  643 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  645 */           int _v_ = 0;
/*  646 */           _v_ = _input_.readInt32();
/*  647 */           this.basepropmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  648 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  652 */           this.potentialpoint = _input_.readInt32();
/*  653 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  657 */           this.hp = _input_.readInt32();
/*  658 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  662 */           this.mp = _input_.readInt32();
/*  663 */           break;
/*      */         
/*      */ 
/*      */         case 125: 
/*  667 */           this.grow = _input_.readFloat();
/*  668 */           break;
/*      */         
/*      */ 
/*      */         case 128: 
/*  672 */           this.unlockskillposnum = _input_.readInt32();
/*  673 */           break;
/*      */         
/*      */ 
/*      */         case 136: 
/*  677 */           this.modelcfgid = _input_.readInt32();
/*  678 */           break;
/*      */         
/*      */ 
/*      */         case 144: 
/*  682 */           this.character = _input_.readInt32();
/*  683 */           break;
/*      */         
/*      */ 
/*      */         case 152: 
/*  687 */           int _k_ = 0;
/*  688 */           _k_ = _input_.readInt32();
/*  689 */           int readTag = _input_.readTag();
/*  690 */           if (154 != readTag)
/*      */           {
/*  692 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  694 */           xbean.Item _v_ = new Item(0, this, "equipitem");
/*  695 */           _input_.readMessage(_v_);
/*  696 */           this.equipitem.put(Integer.valueOf(_k_), _v_);
/*  697 */           break;
/*      */         
/*      */ 
/*      */         case 160: 
/*  701 */           int _k_ = 0;
/*  702 */           _k_ = _input_.readInt32();
/*  703 */           int readTag = _input_.readTag();
/*  704 */           if (162 != readTag)
/*      */           {
/*  706 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  708 */           xbean.Item _v_ = new Item(0, this, "equippetitem");
/*  709 */           _input_.readMessage(_v_);
/*  710 */           this.equippetitem.put(Integer.valueOf(_k_), _v_);
/*  711 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  715 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  717 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  726 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  730 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  732 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AdulthoodInfo copy()
/*      */   {
/*  738 */     _xdb_verify_unsafe_();
/*  739 */     return new AdulthoodInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AdulthoodInfo toData()
/*      */   {
/*  745 */     _xdb_verify_unsafe_();
/*  746 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AdulthoodInfo toBean()
/*      */   {
/*  751 */     _xdb_verify_unsafe_();
/*  752 */     return new AdulthoodInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AdulthoodInfo toDataIf()
/*      */   {
/*  758 */     _xdb_verify_unsafe_();
/*  759 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AdulthoodInfo toBeanIf()
/*      */   {
/*  764 */     _xdb_verify_unsafe_();
/*  765 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  771 */     _xdb_verify_unsafe_();
/*  772 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOccupation()
/*      */   {
/*  779 */     _xdb_verify_unsafe_();
/*  780 */     return this.occupation;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getAptitudeinitmap()
/*      */   {
/*  787 */     _xdb_verify_unsafe_();
/*  788 */     return Logs.logMap(new LogKey(this, "aptitudeinitmap"), this.aptitudeinitmap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getAptitudeinitmapAsData()
/*      */   {
/*  795 */     _xdb_verify_unsafe_();
/*      */     
/*  797 */     AdulthoodInfo _o_ = this;
/*  798 */     Map<Integer, Integer> aptitudeinitmap = new HashMap();
/*  799 */     for (Map.Entry<Integer, Integer> _e_ : _o_.aptitudeinitmap.entrySet())
/*  800 */       aptitudeinitmap.put(_e_.getKey(), _e_.getValue());
/*  801 */     return aptitudeinitmap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getAptitudechangemap()
/*      */   {
/*  808 */     _xdb_verify_unsafe_();
/*  809 */     return Logs.logMap(new LogKey(this, "aptitudechangemap"), this.aptitudechangemap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getAptitudechangemapAsData()
/*      */   {
/*  816 */     _xdb_verify_unsafe_();
/*      */     
/*  818 */     AdulthoodInfo _o_ = this;
/*  819 */     Map<Integer, Integer> aptitudechangemap = new HashMap();
/*  820 */     for (Map.Entry<Integer, Integer> _e_ : _o_.aptitudechangemap.entrySet())
/*  821 */       aptitudechangemap.put(_e_.getKey(), _e_.getValue());
/*  822 */     return aptitudechangemap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getUseaptitudeitemcount()
/*      */   {
/*  829 */     _xdb_verify_unsafe_();
/*  830 */     return this.useaptitudeitemcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getUsegrowthitemcount()
/*      */   {
/*  837 */     _xdb_verify_unsafe_();
/*  838 */     return this.usegrowthitemcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getOccupationskill2value()
/*      */   {
/*  845 */     _xdb_verify_unsafe_();
/*  846 */     return Logs.logMap(new LogKey(this, "occupationskill2value"), this.occupationskill2value);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getOccupationskill2valueAsData()
/*      */   {
/*  853 */     _xdb_verify_unsafe_();
/*      */     
/*  855 */     AdulthoodInfo _o_ = this;
/*  856 */     Map<Integer, Integer> occupationskill2value = new HashMap();
/*  857 */     for (Map.Entry<Integer, Integer> _e_ : _o_.occupationskill2value.entrySet())
/*  858 */       occupationskill2value.put(_e_.getKey(), _e_.getValue());
/*  859 */     return occupationskill2value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getFightskills()
/*      */   {
/*  866 */     _xdb_verify_unsafe_();
/*  867 */     return Logs.logList(new LogKey(this, "fightskills"), this.fightskills);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getFightskillsAsData()
/*      */   {
/*  873 */     _xdb_verify_unsafe_();
/*      */     
/*  875 */     AdulthoodInfo _o_ = this;
/*  876 */     List<Integer> fightskills = new ArrayList();
/*  877 */     fightskills.addAll(_o_.fightskills);
/*  878 */     return fightskills;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getSkillbookskills()
/*      */   {
/*  885 */     _xdb_verify_unsafe_();
/*  886 */     return Logs.logList(new LogKey(this, "skillbookskills"), this.skillbookskills);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getSkillbookskillsAsData()
/*      */   {
/*  892 */     _xdb_verify_unsafe_();
/*      */     
/*  894 */     AdulthoodInfo _o_ = this;
/*  895 */     List<Integer> skillbookskills = new ArrayList();
/*  896 */     skillbookskills.addAll(_o_.skillbookskills);
/*  897 */     return skillbookskills;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSpecialskillid()
/*      */   {
/*  904 */     _xdb_verify_unsafe_();
/*  905 */     return this.specialskillid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBasepropset()
/*      */   {
/*  912 */     _xdb_verify_unsafe_();
/*  913 */     return Logs.logMap(new LogKey(this, "basepropset"), this.basepropset);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBasepropsetAsData()
/*      */   {
/*  920 */     _xdb_verify_unsafe_();
/*      */     
/*  922 */     AdulthoodInfo _o_ = this;
/*  923 */     Map<Integer, Integer> basepropset = new HashMap();
/*  924 */     for (Map.Entry<Integer, Integer> _e_ : _o_.basepropset.entrySet())
/*  925 */       basepropset.put(_e_.getKey(), _e_.getValue());
/*  926 */     return basepropset;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBasepropmap()
/*      */   {
/*  933 */     _xdb_verify_unsafe_();
/*  934 */     return Logs.logMap(new LogKey(this, "basepropmap"), this.basepropmap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBasepropmapAsData()
/*      */   {
/*  941 */     _xdb_verify_unsafe_();
/*      */     
/*  943 */     AdulthoodInfo _o_ = this;
/*  944 */     Map<Integer, Integer> basepropmap = new HashMap();
/*  945 */     for (Map.Entry<Integer, Integer> _e_ : _o_.basepropmap.entrySet())
/*  946 */       basepropmap.put(_e_.getKey(), _e_.getValue());
/*  947 */     return basepropmap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPotentialpoint()
/*      */   {
/*  954 */     _xdb_verify_unsafe_();
/*  955 */     return this.potentialpoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHp()
/*      */   {
/*  962 */     _xdb_verify_unsafe_();
/*  963 */     return this.hp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMp()
/*      */   {
/*  970 */     _xdb_verify_unsafe_();
/*  971 */     return this.mp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public float getGrow()
/*      */   {
/*  978 */     _xdb_verify_unsafe_();
/*  979 */     return this.grow;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getUnlockskillposnum()
/*      */   {
/*  986 */     _xdb_verify_unsafe_();
/*  987 */     return this.unlockskillposnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getModelcfgid()
/*      */   {
/*  994 */     _xdb_verify_unsafe_();
/*  995 */     return this.modelcfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCharacter()
/*      */   {
/* 1002 */     _xdb_verify_unsafe_();
/* 1003 */     return this.character;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.Item> getEquipitem()
/*      */   {
/* 1010 */     _xdb_verify_unsafe_();
/* 1011 */     return Logs.logMap(new LogKey(this, "equipitem"), this.equipitem);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.Item> getEquipitemAsData()
/*      */   {
/* 1018 */     _xdb_verify_unsafe_();
/*      */     
/* 1020 */     AdulthoodInfo _o_ = this;
/* 1021 */     Map<Integer, xbean.Item> equipitem = new HashMap();
/* 1022 */     for (Map.Entry<Integer, xbean.Item> _e_ : _o_.equipitem.entrySet())
/* 1023 */       equipitem.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/* 1024 */     return equipitem;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.Item> getEquippetitem()
/*      */   {
/* 1031 */     _xdb_verify_unsafe_();
/* 1032 */     return Logs.logMap(new LogKey(this, "equippetitem"), this.equippetitem);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.Item> getEquippetitemAsData()
/*      */   {
/* 1039 */     _xdb_verify_unsafe_();
/*      */     
/* 1041 */     AdulthoodInfo _o_ = this;
/* 1042 */     Map<Integer, xbean.Item> equippetitem = new HashMap();
/* 1043 */     for (Map.Entry<Integer, xbean.Item> _e_ : _o_.equippetitem.entrySet())
/* 1044 */       equippetitem.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/* 1045 */     return equippetitem;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOccupation(int _v_)
/*      */   {
/* 1052 */     _xdb_verify_unsafe_();
/* 1053 */     Logs.logIf(new LogKey(this, "occupation")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1057 */         new LogInt(this, AdulthoodInfo.this.occupation)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1061 */             AdulthoodInfo.this.occupation = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1065 */     });
/* 1066 */     this.occupation = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUseaptitudeitemcount(int _v_)
/*      */   {
/* 1073 */     _xdb_verify_unsafe_();
/* 1074 */     Logs.logIf(new LogKey(this, "useaptitudeitemcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1078 */         new LogInt(this, AdulthoodInfo.this.useaptitudeitemcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1082 */             AdulthoodInfo.this.useaptitudeitemcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1086 */     });
/* 1087 */     this.useaptitudeitemcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUsegrowthitemcount(int _v_)
/*      */   {
/* 1094 */     _xdb_verify_unsafe_();
/* 1095 */     Logs.logIf(new LogKey(this, "usegrowthitemcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1099 */         new LogInt(this, AdulthoodInfo.this.usegrowthitemcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1103 */             AdulthoodInfo.this.usegrowthitemcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1107 */     });
/* 1108 */     this.usegrowthitemcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSpecialskillid(int _v_)
/*      */   {
/* 1115 */     _xdb_verify_unsafe_();
/* 1116 */     Logs.logIf(new LogKey(this, "specialskillid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1120 */         new LogInt(this, AdulthoodInfo.this.specialskillid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1124 */             AdulthoodInfo.this.specialskillid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1128 */     });
/* 1129 */     this.specialskillid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPotentialpoint(int _v_)
/*      */   {
/* 1136 */     _xdb_verify_unsafe_();
/* 1137 */     Logs.logIf(new LogKey(this, "potentialpoint")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1141 */         new LogInt(this, AdulthoodInfo.this.potentialpoint)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1145 */             AdulthoodInfo.this.potentialpoint = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1149 */     });
/* 1150 */     this.potentialpoint = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHp(int _v_)
/*      */   {
/* 1157 */     _xdb_verify_unsafe_();
/* 1158 */     Logs.logIf(new LogKey(this, "hp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1162 */         new LogInt(this, AdulthoodInfo.this.hp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1166 */             AdulthoodInfo.this.hp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1170 */     });
/* 1171 */     this.hp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMp(int _v_)
/*      */   {
/* 1178 */     _xdb_verify_unsafe_();
/* 1179 */     Logs.logIf(new LogKey(this, "mp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1183 */         new LogInt(this, AdulthoodInfo.this.mp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1187 */             AdulthoodInfo.this.mp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1191 */     });
/* 1192 */     this.mp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGrow(float _v_)
/*      */   {
/* 1199 */     _xdb_verify_unsafe_();
/* 1200 */     Logs.logIf(new LogKey(this, "grow")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1204 */         new LogFloat(this, AdulthoodInfo.this.grow)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1208 */             AdulthoodInfo.this.grow = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1212 */     });
/* 1213 */     this.grow = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUnlockskillposnum(int _v_)
/*      */   {
/* 1220 */     _xdb_verify_unsafe_();
/* 1221 */     Logs.logIf(new LogKey(this, "unlockskillposnum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1225 */         new LogInt(this, AdulthoodInfo.this.unlockskillposnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1229 */             AdulthoodInfo.this.unlockskillposnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1233 */     });
/* 1234 */     this.unlockskillposnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setModelcfgid(int _v_)
/*      */   {
/* 1241 */     _xdb_verify_unsafe_();
/* 1242 */     Logs.logIf(new LogKey(this, "modelcfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1246 */         new LogInt(this, AdulthoodInfo.this.modelcfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1250 */             AdulthoodInfo.this.modelcfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1254 */     });
/* 1255 */     this.modelcfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCharacter(int _v_)
/*      */   {
/* 1262 */     _xdb_verify_unsafe_();
/* 1263 */     Logs.logIf(new LogKey(this, "character")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1267 */         new LogInt(this, AdulthoodInfo.this.character)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1271 */             AdulthoodInfo.this.character = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1275 */     });
/* 1276 */     this.character = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/* 1282 */     _xdb_verify_unsafe_();
/* 1283 */     AdulthoodInfo _o_ = null;
/* 1284 */     if ((_o1_ instanceof AdulthoodInfo)) { _o_ = (AdulthoodInfo)_o1_;
/* 1285 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 1286 */       return false;
/* 1287 */     if (this.occupation != _o_.occupation) return false;
/* 1288 */     if (!this.aptitudeinitmap.equals(_o_.aptitudeinitmap)) return false;
/* 1289 */     if (!this.aptitudechangemap.equals(_o_.aptitudechangemap)) return false;
/* 1290 */     if (this.useaptitudeitemcount != _o_.useaptitudeitemcount) return false;
/* 1291 */     if (this.usegrowthitemcount != _o_.usegrowthitemcount) return false;
/* 1292 */     if (!this.occupationskill2value.equals(_o_.occupationskill2value)) return false;
/* 1293 */     if (!this.fightskills.equals(_o_.fightskills)) return false;
/* 1294 */     if (!this.skillbookskills.equals(_o_.skillbookskills)) return false;
/* 1295 */     if (this.specialskillid != _o_.specialskillid) return false;
/* 1296 */     if (!this.basepropset.equals(_o_.basepropset)) return false;
/* 1297 */     if (!this.basepropmap.equals(_o_.basepropmap)) return false;
/* 1298 */     if (this.potentialpoint != _o_.potentialpoint) return false;
/* 1299 */     if (this.hp != _o_.hp) return false;
/* 1300 */     if (this.mp != _o_.mp) return false;
/* 1301 */     if (this.grow != _o_.grow) return false;
/* 1302 */     if (this.unlockskillposnum != _o_.unlockskillposnum) return false;
/* 1303 */     if (this.modelcfgid != _o_.modelcfgid) return false;
/* 1304 */     if (this.character != _o_.character) return false;
/* 1305 */     if (!this.equipitem.equals(_o_.equipitem)) return false;
/* 1306 */     if (!this.equippetitem.equals(_o_.equippetitem)) return false;
/* 1307 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/* 1313 */     _xdb_verify_unsafe_();
/* 1314 */     int _h_ = 0;
/* 1315 */     _h_ += this.occupation;
/* 1316 */     _h_ += this.aptitudeinitmap.hashCode();
/* 1317 */     _h_ += this.aptitudechangemap.hashCode();
/* 1318 */     _h_ += this.useaptitudeitemcount;
/* 1319 */     _h_ += this.usegrowthitemcount;
/* 1320 */     _h_ += this.occupationskill2value.hashCode();
/* 1321 */     _h_ += this.fightskills.hashCode();
/* 1322 */     _h_ += this.skillbookskills.hashCode();
/* 1323 */     _h_ += this.specialskillid;
/* 1324 */     _h_ += this.basepropset.hashCode();
/* 1325 */     _h_ += this.basepropmap.hashCode();
/* 1326 */     _h_ += this.potentialpoint;
/* 1327 */     _h_ += this.hp;
/* 1328 */     _h_ += this.mp;
/* 1329 */     _h_ = (int)(_h_ + this.grow);
/* 1330 */     _h_ += this.unlockskillposnum;
/* 1331 */     _h_ += this.modelcfgid;
/* 1332 */     _h_ += this.character;
/* 1333 */     _h_ += this.equipitem.hashCode();
/* 1334 */     _h_ += this.equippetitem.hashCode();
/* 1335 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1341 */     _xdb_verify_unsafe_();
/* 1342 */     StringBuilder _sb_ = new StringBuilder();
/* 1343 */     _sb_.append("(");
/* 1344 */     _sb_.append(this.occupation);
/* 1345 */     _sb_.append(",");
/* 1346 */     _sb_.append(this.aptitudeinitmap);
/* 1347 */     _sb_.append(",");
/* 1348 */     _sb_.append(this.aptitudechangemap);
/* 1349 */     _sb_.append(",");
/* 1350 */     _sb_.append(this.useaptitudeitemcount);
/* 1351 */     _sb_.append(",");
/* 1352 */     _sb_.append(this.usegrowthitemcount);
/* 1353 */     _sb_.append(",");
/* 1354 */     _sb_.append(this.occupationskill2value);
/* 1355 */     _sb_.append(",");
/* 1356 */     _sb_.append(this.fightskills);
/* 1357 */     _sb_.append(",");
/* 1358 */     _sb_.append(this.skillbookskills);
/* 1359 */     _sb_.append(",");
/* 1360 */     _sb_.append(this.specialskillid);
/* 1361 */     _sb_.append(",");
/* 1362 */     _sb_.append(this.basepropset);
/* 1363 */     _sb_.append(",");
/* 1364 */     _sb_.append(this.basepropmap);
/* 1365 */     _sb_.append(",");
/* 1366 */     _sb_.append(this.potentialpoint);
/* 1367 */     _sb_.append(",");
/* 1368 */     _sb_.append(this.hp);
/* 1369 */     _sb_.append(",");
/* 1370 */     _sb_.append(this.mp);
/* 1371 */     _sb_.append(",");
/* 1372 */     _sb_.append(this.grow);
/* 1373 */     _sb_.append(",");
/* 1374 */     _sb_.append(this.unlockskillposnum);
/* 1375 */     _sb_.append(",");
/* 1376 */     _sb_.append(this.modelcfgid);
/* 1377 */     _sb_.append(",");
/* 1378 */     _sb_.append(this.character);
/* 1379 */     _sb_.append(",");
/* 1380 */     _sb_.append(this.equipitem);
/* 1381 */     _sb_.append(",");
/* 1382 */     _sb_.append(this.equippetitem);
/* 1383 */     _sb_.append(")");
/* 1384 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/* 1390 */     ListenableBean lb = new ListenableBean();
/* 1391 */     lb.add(new ListenableChanged().setVarName("occupation"));
/* 1392 */     lb.add(new ListenableMap().setVarName("aptitudeinitmap"));
/* 1393 */     lb.add(new ListenableMap().setVarName("aptitudechangemap"));
/* 1394 */     lb.add(new ListenableChanged().setVarName("useaptitudeitemcount"));
/* 1395 */     lb.add(new ListenableChanged().setVarName("usegrowthitemcount"));
/* 1396 */     lb.add(new ListenableMap().setVarName("occupationskill2value"));
/* 1397 */     lb.add(new ListenableChanged().setVarName("fightskills"));
/* 1398 */     lb.add(new ListenableChanged().setVarName("skillbookskills"));
/* 1399 */     lb.add(new ListenableChanged().setVarName("specialskillid"));
/* 1400 */     lb.add(new ListenableMap().setVarName("basepropset"));
/* 1401 */     lb.add(new ListenableMap().setVarName("basepropmap"));
/* 1402 */     lb.add(new ListenableChanged().setVarName("potentialpoint"));
/* 1403 */     lb.add(new ListenableChanged().setVarName("hp"));
/* 1404 */     lb.add(new ListenableChanged().setVarName("mp"));
/* 1405 */     lb.add(new ListenableChanged().setVarName("grow"));
/* 1406 */     lb.add(new ListenableChanged().setVarName("unlockskillposnum"));
/* 1407 */     lb.add(new ListenableChanged().setVarName("modelcfgid"));
/* 1408 */     lb.add(new ListenableChanged().setVarName("character"));
/* 1409 */     lb.add(new ListenableMap().setVarName("equipitem"));
/* 1410 */     lb.add(new ListenableMap().setVarName("equippetitem"));
/* 1411 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.AdulthoodInfo {
/*      */     private Const() {}
/*      */     
/*      */     AdulthoodInfo nThis() {
/* 1418 */       return AdulthoodInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1424 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AdulthoodInfo copy()
/*      */     {
/* 1430 */       return AdulthoodInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AdulthoodInfo toData()
/*      */     {
/* 1436 */       return AdulthoodInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.AdulthoodInfo toBean()
/*      */     {
/* 1441 */       return AdulthoodInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AdulthoodInfo toDataIf()
/*      */     {
/* 1447 */       return AdulthoodInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.AdulthoodInfo toBeanIf()
/*      */     {
/* 1452 */       return AdulthoodInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOccupation()
/*      */     {
/* 1459 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1460 */       return AdulthoodInfo.this.occupation;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAptitudeinitmap()
/*      */     {
/* 1467 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1468 */       return Consts.constMap(AdulthoodInfo.this.aptitudeinitmap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAptitudeinitmapAsData()
/*      */     {
/* 1475 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1477 */       AdulthoodInfo _o_ = AdulthoodInfo.this;
/* 1478 */       Map<Integer, Integer> aptitudeinitmap = new HashMap();
/* 1479 */       for (Map.Entry<Integer, Integer> _e_ : _o_.aptitudeinitmap.entrySet())
/* 1480 */         aptitudeinitmap.put(_e_.getKey(), _e_.getValue());
/* 1481 */       return aptitudeinitmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAptitudechangemap()
/*      */     {
/* 1488 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1489 */       return Consts.constMap(AdulthoodInfo.this.aptitudechangemap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAptitudechangemapAsData()
/*      */     {
/* 1496 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1498 */       AdulthoodInfo _o_ = AdulthoodInfo.this;
/* 1499 */       Map<Integer, Integer> aptitudechangemap = new HashMap();
/* 1500 */       for (Map.Entry<Integer, Integer> _e_ : _o_.aptitudechangemap.entrySet())
/* 1501 */         aptitudechangemap.put(_e_.getKey(), _e_.getValue());
/* 1502 */       return aptitudechangemap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUseaptitudeitemcount()
/*      */     {
/* 1509 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1510 */       return AdulthoodInfo.this.useaptitudeitemcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUsegrowthitemcount()
/*      */     {
/* 1517 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1518 */       return AdulthoodInfo.this.usegrowthitemcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOccupationskill2value()
/*      */     {
/* 1525 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1526 */       return Consts.constMap(AdulthoodInfo.this.occupationskill2value);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOccupationskill2valueAsData()
/*      */     {
/* 1533 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1535 */       AdulthoodInfo _o_ = AdulthoodInfo.this;
/* 1536 */       Map<Integer, Integer> occupationskill2value = new HashMap();
/* 1537 */       for (Map.Entry<Integer, Integer> _e_ : _o_.occupationskill2value.entrySet())
/* 1538 */         occupationskill2value.put(_e_.getKey(), _e_.getValue());
/* 1539 */       return occupationskill2value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getFightskills()
/*      */     {
/* 1546 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1547 */       return Consts.constList(AdulthoodInfo.this.fightskills);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getFightskillsAsData()
/*      */     {
/* 1553 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1555 */       AdulthoodInfo _o_ = AdulthoodInfo.this;
/* 1556 */       List<Integer> fightskills = new ArrayList();
/* 1557 */       fightskills.addAll(_o_.fightskills);
/* 1558 */       return fightskills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getSkillbookskills()
/*      */     {
/* 1565 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1566 */       return Consts.constList(AdulthoodInfo.this.skillbookskills);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getSkillbookskillsAsData()
/*      */     {
/* 1572 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1574 */       AdulthoodInfo _o_ = AdulthoodInfo.this;
/* 1575 */       List<Integer> skillbookskills = new ArrayList();
/* 1576 */       skillbookskills.addAll(_o_.skillbookskills);
/* 1577 */       return skillbookskills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSpecialskillid()
/*      */     {
/* 1584 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1585 */       return AdulthoodInfo.this.specialskillid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasepropset()
/*      */     {
/* 1592 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1593 */       return Consts.constMap(AdulthoodInfo.this.basepropset);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasepropsetAsData()
/*      */     {
/* 1600 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1602 */       AdulthoodInfo _o_ = AdulthoodInfo.this;
/* 1603 */       Map<Integer, Integer> basepropset = new HashMap();
/* 1604 */       for (Map.Entry<Integer, Integer> _e_ : _o_.basepropset.entrySet())
/* 1605 */         basepropset.put(_e_.getKey(), _e_.getValue());
/* 1606 */       return basepropset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasepropmap()
/*      */     {
/* 1613 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1614 */       return Consts.constMap(AdulthoodInfo.this.basepropmap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasepropmapAsData()
/*      */     {
/* 1621 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1623 */       AdulthoodInfo _o_ = AdulthoodInfo.this;
/* 1624 */       Map<Integer, Integer> basepropmap = new HashMap();
/* 1625 */       for (Map.Entry<Integer, Integer> _e_ : _o_.basepropmap.entrySet())
/* 1626 */         basepropmap.put(_e_.getKey(), _e_.getValue());
/* 1627 */       return basepropmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPotentialpoint()
/*      */     {
/* 1634 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1635 */       return AdulthoodInfo.this.potentialpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHp()
/*      */     {
/* 1642 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1643 */       return AdulthoodInfo.this.hp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMp()
/*      */     {
/* 1650 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1651 */       return AdulthoodInfo.this.mp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getGrow()
/*      */     {
/* 1658 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1659 */       return AdulthoodInfo.this.grow;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUnlockskillposnum()
/*      */     {
/* 1666 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1667 */       return AdulthoodInfo.this.unlockskillposnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getModelcfgid()
/*      */     {
/* 1674 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1675 */       return AdulthoodInfo.this.modelcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCharacter()
/*      */     {
/* 1682 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1683 */       return AdulthoodInfo.this.character;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Item> getEquipitem()
/*      */     {
/* 1690 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1691 */       return Consts.constMap(AdulthoodInfo.this.equipitem);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Item> getEquipitemAsData()
/*      */     {
/* 1698 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1700 */       AdulthoodInfo _o_ = AdulthoodInfo.this;
/* 1701 */       Map<Integer, xbean.Item> equipitem = new HashMap();
/* 1702 */       for (Map.Entry<Integer, xbean.Item> _e_ : _o_.equipitem.entrySet())
/* 1703 */         equipitem.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/* 1704 */       return equipitem;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Item> getEquippetitem()
/*      */     {
/* 1711 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1712 */       return Consts.constMap(AdulthoodInfo.this.equippetitem);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Item> getEquippetitemAsData()
/*      */     {
/* 1719 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1721 */       AdulthoodInfo _o_ = AdulthoodInfo.this;
/* 1722 */       Map<Integer, xbean.Item> equippetitem = new HashMap();
/* 1723 */       for (Map.Entry<Integer, xbean.Item> _e_ : _o_.equippetitem.entrySet())
/* 1724 */         equippetitem.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/* 1725 */       return equippetitem;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOccupation(int _v_)
/*      */     {
/* 1732 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1733 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUseaptitudeitemcount(int _v_)
/*      */     {
/* 1740 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1741 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUsegrowthitemcount(int _v_)
/*      */     {
/* 1748 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1749 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSpecialskillid(int _v_)
/*      */     {
/* 1756 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1757 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPotentialpoint(int _v_)
/*      */     {
/* 1764 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1765 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHp(int _v_)
/*      */     {
/* 1772 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1773 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMp(int _v_)
/*      */     {
/* 1780 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1781 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrow(float _v_)
/*      */     {
/* 1788 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1789 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUnlockskillposnum(int _v_)
/*      */     {
/* 1796 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1797 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setModelcfgid(int _v_)
/*      */     {
/* 1804 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1805 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCharacter(int _v_)
/*      */     {
/* 1812 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1813 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1819 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1820 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1826 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1827 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1833 */       return AdulthoodInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1839 */       return AdulthoodInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1845 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1846 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1852 */       return AdulthoodInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1858 */       return AdulthoodInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1864 */       AdulthoodInfo.this._xdb_verify_unsafe_();
/* 1865 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1871 */       return AdulthoodInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1877 */       return AdulthoodInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1883 */       return AdulthoodInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1889 */       return AdulthoodInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1895 */       return AdulthoodInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1901 */       return AdulthoodInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1907 */       return AdulthoodInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.AdulthoodInfo
/*      */   {
/*      */     private int occupation;
/*      */     
/*      */     private HashMap<Integer, Integer> aptitudeinitmap;
/*      */     
/*      */     private HashMap<Integer, Integer> aptitudechangemap;
/*      */     
/*      */     private int useaptitudeitemcount;
/*      */     
/*      */     private int usegrowthitemcount;
/*      */     
/*      */     private HashMap<Integer, Integer> occupationskill2value;
/*      */     
/*      */     private ArrayList<Integer> fightskills;
/*      */     
/*      */     private ArrayList<Integer> skillbookskills;
/*      */     
/*      */     private int specialskillid;
/*      */     
/*      */     private HashMap<Integer, Integer> basepropset;
/*      */     
/*      */     private HashMap<Integer, Integer> basepropmap;
/*      */     
/*      */     private int potentialpoint;
/*      */     
/*      */     private int hp;
/*      */     
/*      */     private int mp;
/*      */     
/*      */     private float grow;
/*      */     
/*      */     private int unlockskillposnum;
/*      */     
/*      */     private int modelcfgid;
/*      */     
/*      */     private int character;
/*      */     
/*      */     private HashMap<Integer, xbean.Item> equipitem;
/*      */     
/*      */     private HashMap<Integer, xbean.Item> equippetitem;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1957 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1962 */       this.occupation = -1;
/* 1963 */       this.aptitudeinitmap = new HashMap();
/* 1964 */       this.aptitudechangemap = new HashMap();
/* 1965 */       this.occupationskill2value = new HashMap();
/* 1966 */       this.fightskills = new ArrayList();
/* 1967 */       this.skillbookskills = new ArrayList();
/* 1968 */       this.basepropset = new HashMap();
/* 1969 */       this.basepropmap = new HashMap();
/* 1970 */       this.unlockskillposnum = 0;
/* 1971 */       this.equipitem = new HashMap();
/* 1972 */       this.equippetitem = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.AdulthoodInfo _o1_)
/*      */     {
/* 1977 */       if ((_o1_ instanceof AdulthoodInfo)) { assign((AdulthoodInfo)_o1_);
/* 1978 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1979 */       } else if ((_o1_ instanceof AdulthoodInfo.Const)) assign(((AdulthoodInfo.Const)_o1_).nThis()); else {
/* 1980 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(AdulthoodInfo _o_) {
/* 1985 */       this.occupation = _o_.occupation;
/* 1986 */       this.aptitudeinitmap = new HashMap();
/* 1987 */       for (Map.Entry<Integer, Integer> _e_ : _o_.aptitudeinitmap.entrySet())
/* 1988 */         this.aptitudeinitmap.put(_e_.getKey(), _e_.getValue());
/* 1989 */       this.aptitudechangemap = new HashMap();
/* 1990 */       for (Map.Entry<Integer, Integer> _e_ : _o_.aptitudechangemap.entrySet())
/* 1991 */         this.aptitudechangemap.put(_e_.getKey(), _e_.getValue());
/* 1992 */       this.useaptitudeitemcount = _o_.useaptitudeitemcount;
/* 1993 */       this.usegrowthitemcount = _o_.usegrowthitemcount;
/* 1994 */       this.occupationskill2value = new HashMap();
/* 1995 */       for (Map.Entry<Integer, Integer> _e_ : _o_.occupationskill2value.entrySet())
/* 1996 */         this.occupationskill2value.put(_e_.getKey(), _e_.getValue());
/* 1997 */       this.fightskills = new ArrayList();
/* 1998 */       this.fightskills.addAll(_o_.fightskills);
/* 1999 */       this.skillbookskills = new ArrayList();
/* 2000 */       this.skillbookskills.addAll(_o_.skillbookskills);
/* 2001 */       this.specialskillid = _o_.specialskillid;
/* 2002 */       this.basepropset = new HashMap();
/* 2003 */       for (Map.Entry<Integer, Integer> _e_ : _o_.basepropset.entrySet())
/* 2004 */         this.basepropset.put(_e_.getKey(), _e_.getValue());
/* 2005 */       this.basepropmap = new HashMap();
/* 2006 */       for (Map.Entry<Integer, Integer> _e_ : _o_.basepropmap.entrySet())
/* 2007 */         this.basepropmap.put(_e_.getKey(), _e_.getValue());
/* 2008 */       this.potentialpoint = _o_.potentialpoint;
/* 2009 */       this.hp = _o_.hp;
/* 2010 */       this.mp = _o_.mp;
/* 2011 */       this.grow = _o_.grow;
/* 2012 */       this.unlockskillposnum = _o_.unlockskillposnum;
/* 2013 */       this.modelcfgid = _o_.modelcfgid;
/* 2014 */       this.character = _o_.character;
/* 2015 */       this.equipitem = new HashMap();
/* 2016 */       for (Map.Entry<Integer, xbean.Item> _e_ : _o_.equipitem.entrySet())
/* 2017 */         this.equipitem.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/* 2018 */       this.equippetitem = new HashMap();
/* 2019 */       for (Map.Entry<Integer, xbean.Item> _e_ : _o_.equippetitem.entrySet()) {
/* 2020 */         this.equippetitem.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/* 2025 */       this.occupation = _o_.occupation;
/* 2026 */       this.aptitudeinitmap = new HashMap();
/* 2027 */       for (Map.Entry<Integer, Integer> _e_ : _o_.aptitudeinitmap.entrySet())
/* 2028 */         this.aptitudeinitmap.put(_e_.getKey(), _e_.getValue());
/* 2029 */       this.aptitudechangemap = new HashMap();
/* 2030 */       for (Map.Entry<Integer, Integer> _e_ : _o_.aptitudechangemap.entrySet())
/* 2031 */         this.aptitudechangemap.put(_e_.getKey(), _e_.getValue());
/* 2032 */       this.useaptitudeitemcount = _o_.useaptitudeitemcount;
/* 2033 */       this.usegrowthitemcount = _o_.usegrowthitemcount;
/* 2034 */       this.occupationskill2value = new HashMap();
/* 2035 */       for (Map.Entry<Integer, Integer> _e_ : _o_.occupationskill2value.entrySet())
/* 2036 */         this.occupationskill2value.put(_e_.getKey(), _e_.getValue());
/* 2037 */       this.fightskills = new ArrayList();
/* 2038 */       this.fightskills.addAll(_o_.fightskills);
/* 2039 */       this.skillbookskills = new ArrayList();
/* 2040 */       this.skillbookskills.addAll(_o_.skillbookskills);
/* 2041 */       this.specialskillid = _o_.specialskillid;
/* 2042 */       this.basepropset = new HashMap();
/* 2043 */       for (Map.Entry<Integer, Integer> _e_ : _o_.basepropset.entrySet())
/* 2044 */         this.basepropset.put(_e_.getKey(), _e_.getValue());
/* 2045 */       this.basepropmap = new HashMap();
/* 2046 */       for (Map.Entry<Integer, Integer> _e_ : _o_.basepropmap.entrySet())
/* 2047 */         this.basepropmap.put(_e_.getKey(), _e_.getValue());
/* 2048 */       this.potentialpoint = _o_.potentialpoint;
/* 2049 */       this.hp = _o_.hp;
/* 2050 */       this.mp = _o_.mp;
/* 2051 */       this.grow = _o_.grow;
/* 2052 */       this.unlockskillposnum = _o_.unlockskillposnum;
/* 2053 */       this.modelcfgid = _o_.modelcfgid;
/* 2054 */       this.character = _o_.character;
/* 2055 */       this.equipitem = new HashMap();
/* 2056 */       for (Map.Entry<Integer, xbean.Item> _e_ : _o_.equipitem.entrySet())
/* 2057 */         this.equipitem.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/* 2058 */       this.equippetitem = new HashMap();
/* 2059 */       for (Map.Entry<Integer, xbean.Item> _e_ : _o_.equippetitem.entrySet()) {
/* 2060 */         this.equippetitem.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2066 */       _os_.marshal(this.occupation);
/* 2067 */       _os_.compact_uint32(this.aptitudeinitmap.size());
/* 2068 */       for (Map.Entry<Integer, Integer> _e_ : this.aptitudeinitmap.entrySet())
/*      */       {
/* 2070 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2071 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2073 */       _os_.compact_uint32(this.aptitudechangemap.size());
/* 2074 */       for (Map.Entry<Integer, Integer> _e_ : this.aptitudechangemap.entrySet())
/*      */       {
/* 2076 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2077 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2079 */       _os_.marshal(this.useaptitudeitemcount);
/* 2080 */       _os_.marshal(this.usegrowthitemcount);
/* 2081 */       _os_.compact_uint32(this.occupationskill2value.size());
/* 2082 */       for (Map.Entry<Integer, Integer> _e_ : this.occupationskill2value.entrySet())
/*      */       {
/* 2084 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2085 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2087 */       _os_.compact_uint32(this.fightskills.size());
/* 2088 */       for (Integer _v_ : this.fightskills)
/*      */       {
/* 2090 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 2092 */       _os_.compact_uint32(this.skillbookskills.size());
/* 2093 */       for (Integer _v_ : this.skillbookskills)
/*      */       {
/* 2095 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 2097 */       _os_.marshal(this.specialskillid);
/* 2098 */       _os_.compact_uint32(this.basepropset.size());
/* 2099 */       for (Map.Entry<Integer, Integer> _e_ : this.basepropset.entrySet())
/*      */       {
/* 2101 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2102 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2104 */       _os_.compact_uint32(this.basepropmap.size());
/* 2105 */       for (Map.Entry<Integer, Integer> _e_ : this.basepropmap.entrySet())
/*      */       {
/* 2107 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2108 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2110 */       _os_.marshal(this.potentialpoint);
/* 2111 */       _os_.marshal(this.hp);
/* 2112 */       _os_.marshal(this.mp);
/* 2113 */       _os_.marshal(this.grow);
/* 2114 */       _os_.marshal(this.unlockskillposnum);
/* 2115 */       _os_.marshal(this.modelcfgid);
/* 2116 */       _os_.marshal(this.character);
/* 2117 */       _os_.compact_uint32(this.equipitem.size());
/* 2118 */       for (Map.Entry<Integer, xbean.Item> _e_ : this.equipitem.entrySet())
/*      */       {
/* 2120 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2121 */         ((xbean.Item)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2123 */       _os_.compact_uint32(this.equippetitem.size());
/* 2124 */       for (Map.Entry<Integer, xbean.Item> _e_ : this.equippetitem.entrySet())
/*      */       {
/* 2126 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2127 */         ((xbean.Item)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2129 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2135 */       this.occupation = _os_.unmarshal_int();
/*      */       
/* 2137 */       int size = _os_.uncompact_uint32();
/* 2138 */       if (size >= 12)
/*      */       {
/* 2140 */         this.aptitudeinitmap = new HashMap(size * 2);
/*      */       }
/* 2142 */       for (; size > 0; size--)
/*      */       {
/* 2144 */         int _k_ = 0;
/* 2145 */         _k_ = _os_.unmarshal_int();
/* 2146 */         int _v_ = 0;
/* 2147 */         _v_ = _os_.unmarshal_int();
/* 2148 */         this.aptitudeinitmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 2152 */       int size = _os_.uncompact_uint32();
/* 2153 */       if (size >= 12)
/*      */       {
/* 2155 */         this.aptitudechangemap = new HashMap(size * 2);
/*      */       }
/* 2157 */       for (; size > 0; size--)
/*      */       {
/* 2159 */         int _k_ = 0;
/* 2160 */         _k_ = _os_.unmarshal_int();
/* 2161 */         int _v_ = 0;
/* 2162 */         _v_ = _os_.unmarshal_int();
/* 2163 */         this.aptitudechangemap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 2166 */       this.useaptitudeitemcount = _os_.unmarshal_int();
/* 2167 */       this.usegrowthitemcount = _os_.unmarshal_int();
/*      */       
/* 2169 */       int size = _os_.uncompact_uint32();
/* 2170 */       if (size >= 12)
/*      */       {
/* 2172 */         this.occupationskill2value = new HashMap(size * 2);
/*      */       }
/* 2174 */       for (; size > 0; size--)
/*      */       {
/* 2176 */         int _k_ = 0;
/* 2177 */         _k_ = _os_.unmarshal_int();
/* 2178 */         int _v_ = 0;
/* 2179 */         _v_ = _os_.unmarshal_int();
/* 2180 */         this.occupationskill2value.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 2183 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 2185 */         int _v_ = 0;
/* 2186 */         _v_ = _os_.unmarshal_int();
/* 2187 */         this.fightskills.add(Integer.valueOf(_v_));
/*      */       }
/* 2189 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 2191 */         int _v_ = 0;
/* 2192 */         _v_ = _os_.unmarshal_int();
/* 2193 */         this.skillbookskills.add(Integer.valueOf(_v_));
/*      */       }
/* 2195 */       this.specialskillid = _os_.unmarshal_int();
/*      */       
/* 2197 */       int size = _os_.uncompact_uint32();
/* 2198 */       if (size >= 12)
/*      */       {
/* 2200 */         this.basepropset = new HashMap(size * 2);
/*      */       }
/* 2202 */       for (; size > 0; size--)
/*      */       {
/* 2204 */         int _k_ = 0;
/* 2205 */         _k_ = _os_.unmarshal_int();
/* 2206 */         int _v_ = 0;
/* 2207 */         _v_ = _os_.unmarshal_int();
/* 2208 */         this.basepropset.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 2212 */       int size = _os_.uncompact_uint32();
/* 2213 */       if (size >= 12)
/*      */       {
/* 2215 */         this.basepropmap = new HashMap(size * 2);
/*      */       }
/* 2217 */       for (; size > 0; size--)
/*      */       {
/* 2219 */         int _k_ = 0;
/* 2220 */         _k_ = _os_.unmarshal_int();
/* 2221 */         int _v_ = 0;
/* 2222 */         _v_ = _os_.unmarshal_int();
/* 2223 */         this.basepropmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 2226 */       this.potentialpoint = _os_.unmarshal_int();
/* 2227 */       this.hp = _os_.unmarshal_int();
/* 2228 */       this.mp = _os_.unmarshal_int();
/* 2229 */       this.grow = _os_.unmarshal_float();
/* 2230 */       this.unlockskillposnum = _os_.unmarshal_int();
/* 2231 */       this.modelcfgid = _os_.unmarshal_int();
/* 2232 */       this.character = _os_.unmarshal_int();
/*      */       
/* 2234 */       int size = _os_.uncompact_uint32();
/* 2235 */       if (size >= 12)
/*      */       {
/* 2237 */         this.equipitem = new HashMap(size * 2);
/*      */       }
/* 2239 */       for (; size > 0; size--)
/*      */       {
/* 2241 */         int _k_ = 0;
/* 2242 */         _k_ = _os_.unmarshal_int();
/* 2243 */         xbean.Item _v_ = Pod.newItemData();
/* 2244 */         _v_.unmarshal(_os_);
/* 2245 */         this.equipitem.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2249 */       int size = _os_.uncompact_uint32();
/* 2250 */       if (size >= 12)
/*      */       {
/* 2252 */         this.equippetitem = new HashMap(size * 2);
/*      */       }
/* 2254 */       for (; size > 0; size--)
/*      */       {
/* 2256 */         int _k_ = 0;
/* 2257 */         _k_ = _os_.unmarshal_int();
/* 2258 */         xbean.Item _v_ = Pod.newItemData();
/* 2259 */         _v_.unmarshal(_os_);
/* 2260 */         this.equippetitem.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 2263 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 2269 */       int _size_ = 0;
/* 2270 */       _size_ += CodedOutputStream.computeInt32Size(1, this.occupation);
/* 2271 */       for (Map.Entry<Integer, Integer> _e_ : this.aptitudeinitmap.entrySet())
/*      */       {
/* 2273 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 2274 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2276 */       for (Map.Entry<Integer, Integer> _e_ : this.aptitudechangemap.entrySet())
/*      */       {
/* 2278 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 2279 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2281 */       _size_ += CodedOutputStream.computeInt32Size(4, this.useaptitudeitemcount);
/* 2282 */       _size_ += CodedOutputStream.computeInt32Size(5, this.usegrowthitemcount);
/* 2283 */       for (Map.Entry<Integer, Integer> _e_ : this.occupationskill2value.entrySet())
/*      */       {
/* 2285 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/* 2286 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2288 */       for (Integer _v_ : this.fightskills)
/*      */       {
/* 2290 */         _size_ += CodedOutputStream.computeInt32Size(7, _v_.intValue());
/*      */       }
/* 2292 */       for (Integer _v_ : this.skillbookskills)
/*      */       {
/* 2294 */         _size_ += CodedOutputStream.computeInt32Size(8, _v_.intValue());
/*      */       }
/* 2296 */       _size_ += CodedOutputStream.computeInt32Size(9, this.specialskillid);
/* 2297 */       for (Map.Entry<Integer, Integer> _e_ : this.basepropset.entrySet())
/*      */       {
/* 2299 */         _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getKey()).intValue());
/* 2300 */         _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2302 */       for (Map.Entry<Integer, Integer> _e_ : this.basepropmap.entrySet())
/*      */       {
/* 2304 */         _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getKey()).intValue());
/* 2305 */         _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2307 */       _size_ += CodedOutputStream.computeInt32Size(12, this.potentialpoint);
/* 2308 */       _size_ += CodedOutputStream.computeInt32Size(13, this.hp);
/* 2309 */       _size_ += CodedOutputStream.computeInt32Size(14, this.mp);
/* 2310 */       _size_ += CodedOutputStream.computeFloatSize(15, this.grow);
/* 2311 */       _size_ += CodedOutputStream.computeInt32Size(16, this.unlockskillposnum);
/* 2312 */       _size_ += CodedOutputStream.computeInt32Size(17, this.modelcfgid);
/* 2313 */       _size_ += CodedOutputStream.computeInt32Size(18, this.character);
/* 2314 */       for (Map.Entry<Integer, xbean.Item> _e_ : this.equipitem.entrySet())
/*      */       {
/* 2316 */         _size_ += CodedOutputStream.computeInt32Size(19, ((Integer)_e_.getKey()).intValue());
/* 2317 */         _size_ += CodedOutputStream.computeMessageSize(19, (Message)_e_.getValue());
/*      */       }
/* 2319 */       for (Map.Entry<Integer, xbean.Item> _e_ : this.equippetitem.entrySet())
/*      */       {
/* 2321 */         _size_ += CodedOutputStream.computeInt32Size(20, ((Integer)_e_.getKey()).intValue());
/* 2322 */         _size_ += CodedOutputStream.computeMessageSize(20, (Message)_e_.getValue());
/*      */       }
/* 2324 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2332 */         _output_.writeInt32(1, this.occupation);
/* 2333 */         for (Map.Entry<Integer, Integer> _e_ : this.aptitudeinitmap.entrySet())
/*      */         {
/* 2335 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 2336 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2338 */         for (Map.Entry<Integer, Integer> _e_ : this.aptitudechangemap.entrySet())
/*      */         {
/* 2340 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 2341 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2343 */         _output_.writeInt32(4, this.useaptitudeitemcount);
/* 2344 */         _output_.writeInt32(5, this.usegrowthitemcount);
/* 2345 */         for (Map.Entry<Integer, Integer> _e_ : this.occupationskill2value.entrySet())
/*      */         {
/* 2347 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/* 2348 */           _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2350 */         for (Integer _v_ : this.fightskills)
/*      */         {
/* 2352 */           _output_.writeInt32(7, _v_.intValue());
/*      */         }
/* 2354 */         for (Integer _v_ : this.skillbookskills)
/*      */         {
/* 2356 */           _output_.writeInt32(8, _v_.intValue());
/*      */         }
/* 2358 */         _output_.writeInt32(9, this.specialskillid);
/* 2359 */         for (Map.Entry<Integer, Integer> _e_ : this.basepropset.entrySet())
/*      */         {
/* 2361 */           _output_.writeInt32(10, ((Integer)_e_.getKey()).intValue());
/* 2362 */           _output_.writeInt32(10, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2364 */         for (Map.Entry<Integer, Integer> _e_ : this.basepropmap.entrySet())
/*      */         {
/* 2366 */           _output_.writeInt32(11, ((Integer)_e_.getKey()).intValue());
/* 2367 */           _output_.writeInt32(11, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2369 */         _output_.writeInt32(12, this.potentialpoint);
/* 2370 */         _output_.writeInt32(13, this.hp);
/* 2371 */         _output_.writeInt32(14, this.mp);
/* 2372 */         _output_.writeFloat(15, this.grow);
/* 2373 */         _output_.writeInt32(16, this.unlockskillposnum);
/* 2374 */         _output_.writeInt32(17, this.modelcfgid);
/* 2375 */         _output_.writeInt32(18, this.character);
/* 2376 */         for (Map.Entry<Integer, xbean.Item> _e_ : this.equipitem.entrySet())
/*      */         {
/* 2378 */           _output_.writeInt32(19, ((Integer)_e_.getKey()).intValue());
/* 2379 */           _output_.writeMessage(19, (Message)_e_.getValue());
/*      */         }
/* 2381 */         for (Map.Entry<Integer, xbean.Item> _e_ : this.equippetitem.entrySet())
/*      */         {
/* 2383 */           _output_.writeInt32(20, ((Integer)_e_.getKey()).intValue());
/* 2384 */           _output_.writeMessage(20, (Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2389 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2391 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2399 */         boolean done = false;
/* 2400 */         while (!done)
/*      */         {
/* 2402 */           int tag = _input_.readTag();
/* 2403 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 2407 */             done = true;
/* 2408 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 2412 */             this.occupation = _input_.readInt32();
/* 2413 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 2417 */             int _k_ = 0;
/* 2418 */             _k_ = _input_.readInt32();
/* 2419 */             int readTag = _input_.readTag();
/* 2420 */             if (16 != readTag)
/*      */             {
/* 2422 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2424 */             int _v_ = 0;
/* 2425 */             _v_ = _input_.readInt32();
/* 2426 */             this.aptitudeinitmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2427 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 2431 */             int _k_ = 0;
/* 2432 */             _k_ = _input_.readInt32();
/* 2433 */             int readTag = _input_.readTag();
/* 2434 */             if (24 != readTag)
/*      */             {
/* 2436 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2438 */             int _v_ = 0;
/* 2439 */             _v_ = _input_.readInt32();
/* 2440 */             this.aptitudechangemap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2441 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 2445 */             this.useaptitudeitemcount = _input_.readInt32();
/* 2446 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 2450 */             this.usegrowthitemcount = _input_.readInt32();
/* 2451 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 2455 */             int _k_ = 0;
/* 2456 */             _k_ = _input_.readInt32();
/* 2457 */             int readTag = _input_.readTag();
/* 2458 */             if (48 != readTag)
/*      */             {
/* 2460 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2462 */             int _v_ = 0;
/* 2463 */             _v_ = _input_.readInt32();
/* 2464 */             this.occupationskill2value.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2465 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 2469 */             int _v_ = 0;
/* 2470 */             _v_ = _input_.readInt32();
/* 2471 */             this.fightskills.add(Integer.valueOf(_v_));
/* 2472 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 2476 */             int _v_ = 0;
/* 2477 */             _v_ = _input_.readInt32();
/* 2478 */             this.skillbookskills.add(Integer.valueOf(_v_));
/* 2479 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 2483 */             this.specialskillid = _input_.readInt32();
/* 2484 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 2488 */             int _k_ = 0;
/* 2489 */             _k_ = _input_.readInt32();
/* 2490 */             int readTag = _input_.readTag();
/* 2491 */             if (80 != readTag)
/*      */             {
/* 2493 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2495 */             int _v_ = 0;
/* 2496 */             _v_ = _input_.readInt32();
/* 2497 */             this.basepropset.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2498 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 2502 */             int _k_ = 0;
/* 2503 */             _k_ = _input_.readInt32();
/* 2504 */             int readTag = _input_.readTag();
/* 2505 */             if (88 != readTag)
/*      */             {
/* 2507 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2509 */             int _v_ = 0;
/* 2510 */             _v_ = _input_.readInt32();
/* 2511 */             this.basepropmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2512 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 2516 */             this.potentialpoint = _input_.readInt32();
/* 2517 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 2521 */             this.hp = _input_.readInt32();
/* 2522 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 2526 */             this.mp = _input_.readInt32();
/* 2527 */             break;
/*      */           
/*      */ 
/*      */           case 125: 
/* 2531 */             this.grow = _input_.readFloat();
/* 2532 */             break;
/*      */           
/*      */ 
/*      */           case 128: 
/* 2536 */             this.unlockskillposnum = _input_.readInt32();
/* 2537 */             break;
/*      */           
/*      */ 
/*      */           case 136: 
/* 2541 */             this.modelcfgid = _input_.readInt32();
/* 2542 */             break;
/*      */           
/*      */ 
/*      */           case 144: 
/* 2546 */             this.character = _input_.readInt32();
/* 2547 */             break;
/*      */           
/*      */ 
/*      */           case 152: 
/* 2551 */             int _k_ = 0;
/* 2552 */             _k_ = _input_.readInt32();
/* 2553 */             int readTag = _input_.readTag();
/* 2554 */             if (154 != readTag)
/*      */             {
/* 2556 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2558 */             xbean.Item _v_ = Pod.newItemData();
/* 2559 */             _input_.readMessage(_v_);
/* 2560 */             this.equipitem.put(Integer.valueOf(_k_), _v_);
/* 2561 */             break;
/*      */           
/*      */ 
/*      */           case 160: 
/* 2565 */             int _k_ = 0;
/* 2566 */             _k_ = _input_.readInt32();
/* 2567 */             int readTag = _input_.readTag();
/* 2568 */             if (162 != readTag)
/*      */             {
/* 2570 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2572 */             xbean.Item _v_ = Pod.newItemData();
/* 2573 */             _input_.readMessage(_v_);
/* 2574 */             this.equippetitem.put(Integer.valueOf(_k_), _v_);
/* 2575 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 2579 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 2581 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 2590 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2594 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2596 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AdulthoodInfo copy()
/*      */     {
/* 2602 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AdulthoodInfo toData()
/*      */     {
/* 2608 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.AdulthoodInfo toBean()
/*      */     {
/* 2613 */       return new AdulthoodInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AdulthoodInfo toDataIf()
/*      */     {
/* 2619 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.AdulthoodInfo toBeanIf()
/*      */     {
/* 2624 */       return new AdulthoodInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2630 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 2634 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 2638 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 2642 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 2646 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 2650 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 2654 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOccupation()
/*      */     {
/* 2661 */       return this.occupation;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAptitudeinitmap()
/*      */     {
/* 2668 */       return this.aptitudeinitmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAptitudeinitmapAsData()
/*      */     {
/* 2675 */       return this.aptitudeinitmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAptitudechangemap()
/*      */     {
/* 2682 */       return this.aptitudechangemap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAptitudechangemapAsData()
/*      */     {
/* 2689 */       return this.aptitudechangemap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUseaptitudeitemcount()
/*      */     {
/* 2696 */       return this.useaptitudeitemcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUsegrowthitemcount()
/*      */     {
/* 2703 */       return this.usegrowthitemcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOccupationskill2value()
/*      */     {
/* 2710 */       return this.occupationskill2value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOccupationskill2valueAsData()
/*      */     {
/* 2717 */       return this.occupationskill2value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getFightskills()
/*      */     {
/* 2724 */       return this.fightskills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getFightskillsAsData()
/*      */     {
/* 2731 */       return this.fightskills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getSkillbookskills()
/*      */     {
/* 2738 */       return this.skillbookskills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getSkillbookskillsAsData()
/*      */     {
/* 2745 */       return this.skillbookskills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSpecialskillid()
/*      */     {
/* 2752 */       return this.specialskillid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasepropset()
/*      */     {
/* 2759 */       return this.basepropset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasepropsetAsData()
/*      */     {
/* 2766 */       return this.basepropset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasepropmap()
/*      */     {
/* 2773 */       return this.basepropmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasepropmapAsData()
/*      */     {
/* 2780 */       return this.basepropmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPotentialpoint()
/*      */     {
/* 2787 */       return this.potentialpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHp()
/*      */     {
/* 2794 */       return this.hp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMp()
/*      */     {
/* 2801 */       return this.mp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getGrow()
/*      */     {
/* 2808 */       return this.grow;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUnlockskillposnum()
/*      */     {
/* 2815 */       return this.unlockskillposnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getModelcfgid()
/*      */     {
/* 2822 */       return this.modelcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCharacter()
/*      */     {
/* 2829 */       return this.character;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Item> getEquipitem()
/*      */     {
/* 2836 */       return this.equipitem;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Item> getEquipitemAsData()
/*      */     {
/* 2843 */       return this.equipitem;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Item> getEquippetitem()
/*      */     {
/* 2850 */       return this.equippetitem;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Item> getEquippetitemAsData()
/*      */     {
/* 2857 */       return this.equippetitem;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOccupation(int _v_)
/*      */     {
/* 2864 */       this.occupation = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUseaptitudeitemcount(int _v_)
/*      */     {
/* 2871 */       this.useaptitudeitemcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUsegrowthitemcount(int _v_)
/*      */     {
/* 2878 */       this.usegrowthitemcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSpecialskillid(int _v_)
/*      */     {
/* 2885 */       this.specialskillid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPotentialpoint(int _v_)
/*      */     {
/* 2892 */       this.potentialpoint = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHp(int _v_)
/*      */     {
/* 2899 */       this.hp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMp(int _v_)
/*      */     {
/* 2906 */       this.mp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrow(float _v_)
/*      */     {
/* 2913 */       this.grow = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUnlockskillposnum(int _v_)
/*      */     {
/* 2920 */       this.unlockskillposnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setModelcfgid(int _v_)
/*      */     {
/* 2927 */       this.modelcfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCharacter(int _v_)
/*      */     {
/* 2934 */       this.character = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 2940 */       if (!(_o1_ instanceof Data)) return false;
/* 2941 */       Data _o_ = (Data)_o1_;
/* 2942 */       if (this.occupation != _o_.occupation) return false;
/* 2943 */       if (!this.aptitudeinitmap.equals(_o_.aptitudeinitmap)) return false;
/* 2944 */       if (!this.aptitudechangemap.equals(_o_.aptitudechangemap)) return false;
/* 2945 */       if (this.useaptitudeitemcount != _o_.useaptitudeitemcount) return false;
/* 2946 */       if (this.usegrowthitemcount != _o_.usegrowthitemcount) return false;
/* 2947 */       if (!this.occupationskill2value.equals(_o_.occupationskill2value)) return false;
/* 2948 */       if (!this.fightskills.equals(_o_.fightskills)) return false;
/* 2949 */       if (!this.skillbookskills.equals(_o_.skillbookskills)) return false;
/* 2950 */       if (this.specialskillid != _o_.specialskillid) return false;
/* 2951 */       if (!this.basepropset.equals(_o_.basepropset)) return false;
/* 2952 */       if (!this.basepropmap.equals(_o_.basepropmap)) return false;
/* 2953 */       if (this.potentialpoint != _o_.potentialpoint) return false;
/* 2954 */       if (this.hp != _o_.hp) return false;
/* 2955 */       if (this.mp != _o_.mp) return false;
/* 2956 */       if (this.grow != _o_.grow) return false;
/* 2957 */       if (this.unlockskillposnum != _o_.unlockskillposnum) return false;
/* 2958 */       if (this.modelcfgid != _o_.modelcfgid) return false;
/* 2959 */       if (this.character != _o_.character) return false;
/* 2960 */       if (!this.equipitem.equals(_o_.equipitem)) return false;
/* 2961 */       if (!this.equippetitem.equals(_o_.equippetitem)) return false;
/* 2962 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 2968 */       int _h_ = 0;
/* 2969 */       _h_ += this.occupation;
/* 2970 */       _h_ += this.aptitudeinitmap.hashCode();
/* 2971 */       _h_ += this.aptitudechangemap.hashCode();
/* 2972 */       _h_ += this.useaptitudeitemcount;
/* 2973 */       _h_ += this.usegrowthitemcount;
/* 2974 */       _h_ += this.occupationskill2value.hashCode();
/* 2975 */       _h_ += this.fightskills.hashCode();
/* 2976 */       _h_ += this.skillbookskills.hashCode();
/* 2977 */       _h_ += this.specialskillid;
/* 2978 */       _h_ += this.basepropset.hashCode();
/* 2979 */       _h_ += this.basepropmap.hashCode();
/* 2980 */       _h_ += this.potentialpoint;
/* 2981 */       _h_ += this.hp;
/* 2982 */       _h_ += this.mp;
/* 2983 */       _h_ = (int)(_h_ + this.grow);
/* 2984 */       _h_ += this.unlockskillposnum;
/* 2985 */       _h_ += this.modelcfgid;
/* 2986 */       _h_ += this.character;
/* 2987 */       _h_ += this.equipitem.hashCode();
/* 2988 */       _h_ += this.equippetitem.hashCode();
/* 2989 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2995 */       StringBuilder _sb_ = new StringBuilder();
/* 2996 */       _sb_.append("(");
/* 2997 */       _sb_.append(this.occupation);
/* 2998 */       _sb_.append(",");
/* 2999 */       _sb_.append(this.aptitudeinitmap);
/* 3000 */       _sb_.append(",");
/* 3001 */       _sb_.append(this.aptitudechangemap);
/* 3002 */       _sb_.append(",");
/* 3003 */       _sb_.append(this.useaptitudeitemcount);
/* 3004 */       _sb_.append(",");
/* 3005 */       _sb_.append(this.usegrowthitemcount);
/* 3006 */       _sb_.append(",");
/* 3007 */       _sb_.append(this.occupationskill2value);
/* 3008 */       _sb_.append(",");
/* 3009 */       _sb_.append(this.fightskills);
/* 3010 */       _sb_.append(",");
/* 3011 */       _sb_.append(this.skillbookskills);
/* 3012 */       _sb_.append(",");
/* 3013 */       _sb_.append(this.specialskillid);
/* 3014 */       _sb_.append(",");
/* 3015 */       _sb_.append(this.basepropset);
/* 3016 */       _sb_.append(",");
/* 3017 */       _sb_.append(this.basepropmap);
/* 3018 */       _sb_.append(",");
/* 3019 */       _sb_.append(this.potentialpoint);
/* 3020 */       _sb_.append(",");
/* 3021 */       _sb_.append(this.hp);
/* 3022 */       _sb_.append(",");
/* 3023 */       _sb_.append(this.mp);
/* 3024 */       _sb_.append(",");
/* 3025 */       _sb_.append(this.grow);
/* 3026 */       _sb_.append(",");
/* 3027 */       _sb_.append(this.unlockskillposnum);
/* 3028 */       _sb_.append(",");
/* 3029 */       _sb_.append(this.modelcfgid);
/* 3030 */       _sb_.append(",");
/* 3031 */       _sb_.append(this.character);
/* 3032 */       _sb_.append(",");
/* 3033 */       _sb_.append(this.equipitem);
/* 3034 */       _sb_.append(",");
/* 3035 */       _sb_.append(this.equippetitem);
/* 3036 */       _sb_.append(")");
/* 3037 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AdulthoodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */