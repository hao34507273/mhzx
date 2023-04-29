/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
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
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogObject;
/*      */ import xdb.logs.LogString;
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class Pet
/*      */   extends XBean
/*      */   implements xbean.Pet
/*      */ {
/*      */   private long id;
/*      */   private int templateid;
/*      */   private String petname;
/*      */   private int level;
/*      */   private int hp;
/*      */   private int mp;
/*      */   private int exp;
/*      */   private int life;
/*      */   private HashMap<Integer, Integer> basicproperty;
/*      */   private boolean isautospecialpoint;
/*      */   private HashMap<Integer, Integer> autospecialpointcase;
/*      */   private int potentialpoint;
/*      */   private xbean.Aptitude aptitude;
/*      */   private float grow;
/*      */   private int rememberskillid;
/*      */   private xbean.PetEquipBag equipbag;
/*      */   private LinkedList<xbean.PetSkill> skilllist;
/*      */   private int isbinded;
/*      */   private int yaoli;
/*      */   private long marketbuytime;
/*      */   private int lianguitemusenum;
/*      */   private int growitemusenum;
/*      */   private int fanshengunbianyinum;
/*      */   private int stagelevel;
/*      */   private long changeyaolitime;
/*      */   private int extramodelcfgid;
/*      */   private xbean.PetSoulBag soulbag;
/*      */   private ArrayList<Integer> ownextramodelcfgids;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   72 */     this.id = 0L;
/*   73 */     this.templateid = 0;
/*   74 */     this.petname = "";
/*   75 */     this.level = 0;
/*   76 */     this.hp = 0;
/*   77 */     this.mp = 0;
/*   78 */     this.exp = 0;
/*   79 */     this.life = 0;
/*   80 */     this.basicproperty.clear();
/*   81 */     this.isautospecialpoint = false;
/*   82 */     this.autospecialpointcase.clear();
/*   83 */     this.potentialpoint = 0;
/*   84 */     this.aptitude._reset_unsafe_();
/*   85 */     this.grow = 0.0F;
/*   86 */     this.rememberskillid = 0;
/*   87 */     this.equipbag._reset_unsafe_();
/*   88 */     this.skilllist.clear();
/*   89 */     this.isbinded = 0;
/*   90 */     this.yaoli = 0;
/*   91 */     this.marketbuytime = 0L;
/*   92 */     this.lianguitemusenum = 0;
/*   93 */     this.growitemusenum = 0;
/*   94 */     this.fanshengunbianyinum = 0;
/*   95 */     this.stagelevel = 0;
/*   96 */     this.changeyaolitime = 0L;
/*   97 */     this.extramodelcfgid = 0;
/*   98 */     this.soulbag._reset_unsafe_();
/*   99 */     this.ownextramodelcfgids.clear();
/*      */   }
/*      */   
/*      */   Pet(int __, XBean _xp_, String _vn_)
/*      */   {
/*  104 */     super(_xp_, _vn_);
/*  105 */     this.petname = "";
/*  106 */     this.basicproperty = new HashMap();
/*  107 */     this.autospecialpointcase = new HashMap();
/*  108 */     this.aptitude = new Aptitude(0, this, "aptitude");
/*  109 */     this.equipbag = new PetEquipBag(0, this, "equipbag");
/*  110 */     this.skilllist = new LinkedList();
/*  111 */     this.marketbuytime = 0L;
/*  112 */     this.lianguitemusenum = 0;
/*  113 */     this.growitemusenum = 0;
/*  114 */     this.extramodelcfgid = 0;
/*  115 */     this.soulbag = new PetSoulBag(0, this, "soulbag");
/*  116 */     this.ownextramodelcfgids = new ArrayList();
/*      */   }
/*      */   
/*      */   public Pet()
/*      */   {
/*  121 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Pet(Pet _o_)
/*      */   {
/*  126 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Pet(xbean.Pet _o1_, XBean _xp_, String _vn_)
/*      */   {
/*  131 */     super(_xp_, _vn_);
/*  132 */     if ((_o1_ instanceof Pet)) { assign((Pet)_o1_);
/*  133 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  134 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  135 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Pet _o_) {
/*  140 */     _o_._xdb_verify_unsafe_();
/*  141 */     this.id = _o_.id;
/*  142 */     this.templateid = _o_.templateid;
/*  143 */     this.petname = _o_.petname;
/*  144 */     this.level = _o_.level;
/*  145 */     this.hp = _o_.hp;
/*  146 */     this.mp = _o_.mp;
/*  147 */     this.exp = _o_.exp;
/*  148 */     this.life = _o_.life;
/*  149 */     this.basicproperty = new HashMap();
/*  150 */     for (Map.Entry<Integer, Integer> _e_ : _o_.basicproperty.entrySet())
/*  151 */       this.basicproperty.put(_e_.getKey(), _e_.getValue());
/*  152 */     this.isautospecialpoint = _o_.isautospecialpoint;
/*  153 */     this.autospecialpointcase = new HashMap();
/*  154 */     for (Map.Entry<Integer, Integer> _e_ : _o_.autospecialpointcase.entrySet())
/*  155 */       this.autospecialpointcase.put(_e_.getKey(), _e_.getValue());
/*  156 */     this.potentialpoint = _o_.potentialpoint;
/*  157 */     this.aptitude = new Aptitude(_o_.aptitude, this, "aptitude");
/*  158 */     this.grow = _o_.grow;
/*  159 */     this.rememberskillid = _o_.rememberskillid;
/*  160 */     this.equipbag = new PetEquipBag(_o_.equipbag, this, "equipbag");
/*  161 */     this.skilllist = new LinkedList();
/*  162 */     for (xbean.PetSkill _v_ : _o_.skilllist)
/*  163 */       this.skilllist.add(new PetSkill(_v_, this, "skilllist"));
/*  164 */     this.isbinded = _o_.isbinded;
/*  165 */     this.yaoli = _o_.yaoli;
/*  166 */     this.marketbuytime = _o_.marketbuytime;
/*  167 */     this.lianguitemusenum = _o_.lianguitemusenum;
/*  168 */     this.growitemusenum = _o_.growitemusenum;
/*  169 */     this.fanshengunbianyinum = _o_.fanshengunbianyinum;
/*  170 */     this.stagelevel = _o_.stagelevel;
/*  171 */     this.changeyaolitime = _o_.changeyaolitime;
/*  172 */     this.extramodelcfgid = _o_.extramodelcfgid;
/*  173 */     this.soulbag = new PetSoulBag(_o_.soulbag, this, "soulbag");
/*  174 */     this.ownextramodelcfgids = new ArrayList();
/*  175 */     this.ownextramodelcfgids.addAll(_o_.ownextramodelcfgids);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  180 */     this.id = _o_.id;
/*  181 */     this.templateid = _o_.templateid;
/*  182 */     this.petname = _o_.petname;
/*  183 */     this.level = _o_.level;
/*  184 */     this.hp = _o_.hp;
/*  185 */     this.mp = _o_.mp;
/*  186 */     this.exp = _o_.exp;
/*  187 */     this.life = _o_.life;
/*  188 */     this.basicproperty = new HashMap();
/*  189 */     for (Map.Entry<Integer, Integer> _e_ : _o_.basicproperty.entrySet())
/*  190 */       this.basicproperty.put(_e_.getKey(), _e_.getValue());
/*  191 */     this.isautospecialpoint = _o_.isautospecialpoint;
/*  192 */     this.autospecialpointcase = new HashMap();
/*  193 */     for (Map.Entry<Integer, Integer> _e_ : _o_.autospecialpointcase.entrySet())
/*  194 */       this.autospecialpointcase.put(_e_.getKey(), _e_.getValue());
/*  195 */     this.potentialpoint = _o_.potentialpoint;
/*  196 */     this.aptitude = new Aptitude(_o_.aptitude, this, "aptitude");
/*  197 */     this.grow = _o_.grow;
/*  198 */     this.rememberskillid = _o_.rememberskillid;
/*  199 */     this.equipbag = new PetEquipBag(_o_.equipbag, this, "equipbag");
/*  200 */     this.skilllist = new LinkedList();
/*  201 */     for (xbean.PetSkill _v_ : _o_.skilllist)
/*  202 */       this.skilllist.add(new PetSkill(_v_, this, "skilllist"));
/*  203 */     this.isbinded = _o_.isbinded;
/*  204 */     this.yaoli = _o_.yaoli;
/*  205 */     this.marketbuytime = _o_.marketbuytime;
/*  206 */     this.lianguitemusenum = _o_.lianguitemusenum;
/*  207 */     this.growitemusenum = _o_.growitemusenum;
/*  208 */     this.fanshengunbianyinum = _o_.fanshengunbianyinum;
/*  209 */     this.stagelevel = _o_.stagelevel;
/*  210 */     this.changeyaolitime = _o_.changeyaolitime;
/*  211 */     this.extramodelcfgid = _o_.extramodelcfgid;
/*  212 */     this.soulbag = new PetSoulBag(_o_.soulbag, this, "soulbag");
/*  213 */     this.ownextramodelcfgids = new ArrayList();
/*  214 */     this.ownextramodelcfgids.addAll(_o_.ownextramodelcfgids);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  220 */     _xdb_verify_unsafe_();
/*  221 */     _os_.marshal(this.id);
/*  222 */     _os_.marshal(this.templateid);
/*  223 */     _os_.marshal(this.petname, "UTF-16LE");
/*  224 */     _os_.marshal(this.level);
/*  225 */     _os_.marshal(this.hp);
/*  226 */     _os_.marshal(this.mp);
/*  227 */     _os_.marshal(this.exp);
/*  228 */     _os_.marshal(this.life);
/*  229 */     _os_.compact_uint32(this.basicproperty.size());
/*  230 */     for (Map.Entry<Integer, Integer> _e_ : this.basicproperty.entrySet())
/*      */     {
/*  232 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  233 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  235 */     _os_.marshal(this.isautospecialpoint);
/*  236 */     _os_.compact_uint32(this.autospecialpointcase.size());
/*  237 */     for (Map.Entry<Integer, Integer> _e_ : this.autospecialpointcase.entrySet())
/*      */     {
/*  239 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  240 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  242 */     _os_.marshal(this.potentialpoint);
/*  243 */     this.aptitude.marshal(_os_);
/*  244 */     _os_.marshal(this.grow);
/*  245 */     _os_.marshal(this.rememberskillid);
/*  246 */     this.equipbag.marshal(_os_);
/*  247 */     _os_.compact_uint32(this.skilllist.size());
/*  248 */     for (xbean.PetSkill _v_ : this.skilllist)
/*      */     {
/*  250 */       _v_.marshal(_os_);
/*      */     }
/*  252 */     _os_.marshal(this.isbinded);
/*  253 */     _os_.marshal(this.yaoli);
/*  254 */     _os_.marshal(this.marketbuytime);
/*  255 */     _os_.marshal(this.lianguitemusenum);
/*  256 */     _os_.marshal(this.growitemusenum);
/*  257 */     _os_.marshal(this.fanshengunbianyinum);
/*  258 */     _os_.marshal(this.stagelevel);
/*  259 */     _os_.marshal(this.changeyaolitime);
/*  260 */     _os_.marshal(this.extramodelcfgid);
/*  261 */     this.soulbag.marshal(_os_);
/*  262 */     _os_.compact_uint32(this.ownextramodelcfgids.size());
/*  263 */     for (Integer _v_ : this.ownextramodelcfgids)
/*      */     {
/*  265 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  267 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  273 */     _xdb_verify_unsafe_();
/*  274 */     this.id = _os_.unmarshal_long();
/*  275 */     this.templateid = _os_.unmarshal_int();
/*  276 */     this.petname = _os_.unmarshal_String("UTF-16LE");
/*  277 */     this.level = _os_.unmarshal_int();
/*  278 */     this.hp = _os_.unmarshal_int();
/*  279 */     this.mp = _os_.unmarshal_int();
/*  280 */     this.exp = _os_.unmarshal_int();
/*  281 */     this.life = _os_.unmarshal_int();
/*      */     
/*  283 */     int size = _os_.uncompact_uint32();
/*  284 */     if (size >= 12)
/*      */     {
/*  286 */       this.basicproperty = new HashMap(size * 2);
/*      */     }
/*  288 */     for (; size > 0; size--)
/*      */     {
/*  290 */       int _k_ = 0;
/*  291 */       _k_ = _os_.unmarshal_int();
/*  292 */       int _v_ = 0;
/*  293 */       _v_ = _os_.unmarshal_int();
/*  294 */       this.basicproperty.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  297 */     this.isautospecialpoint = _os_.unmarshal_boolean();
/*      */     
/*  299 */     int size = _os_.uncompact_uint32();
/*  300 */     if (size >= 12)
/*      */     {
/*  302 */       this.autospecialpointcase = new HashMap(size * 2);
/*      */     }
/*  304 */     for (; size > 0; size--)
/*      */     {
/*  306 */       int _k_ = 0;
/*  307 */       _k_ = _os_.unmarshal_int();
/*  308 */       int _v_ = 0;
/*  309 */       _v_ = _os_.unmarshal_int();
/*  310 */       this.autospecialpointcase.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  313 */     this.potentialpoint = _os_.unmarshal_int();
/*  314 */     this.aptitude.unmarshal(_os_);
/*  315 */     this.grow = _os_.unmarshal_float();
/*  316 */     this.rememberskillid = _os_.unmarshal_int();
/*  317 */     this.equipbag.unmarshal(_os_);
/*  318 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  320 */       xbean.PetSkill _v_ = new PetSkill(0, this, "skilllist");
/*  321 */       _v_.unmarshal(_os_);
/*  322 */       this.skilllist.add(_v_);
/*      */     }
/*  324 */     this.isbinded = _os_.unmarshal_int();
/*  325 */     this.yaoli = _os_.unmarshal_int();
/*  326 */     this.marketbuytime = _os_.unmarshal_long();
/*  327 */     this.lianguitemusenum = _os_.unmarshal_int();
/*  328 */     this.growitemusenum = _os_.unmarshal_int();
/*  329 */     this.fanshengunbianyinum = _os_.unmarshal_int();
/*  330 */     this.stagelevel = _os_.unmarshal_int();
/*  331 */     this.changeyaolitime = _os_.unmarshal_long();
/*  332 */     this.extramodelcfgid = _os_.unmarshal_int();
/*  333 */     this.soulbag.unmarshal(_os_);
/*  334 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  336 */       int _v_ = 0;
/*  337 */       _v_ = _os_.unmarshal_int();
/*  338 */       this.ownextramodelcfgids.add(Integer.valueOf(_v_));
/*      */     }
/*  340 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*  347 */     int _size_ = 0;
/*  348 */     _size_ += CodedOutputStream.computeInt64Size(1, this.id);
/*  349 */     _size_ += CodedOutputStream.computeInt32Size(2, this.templateid);
/*      */     try
/*      */     {
/*  352 */       _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.petname, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  356 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  358 */     _size_ += CodedOutputStream.computeInt32Size(4, this.level);
/*  359 */     _size_ += CodedOutputStream.computeInt32Size(5, this.hp);
/*  360 */     _size_ += CodedOutputStream.computeInt32Size(6, this.mp);
/*  361 */     _size_ += CodedOutputStream.computeInt32Size(7, this.exp);
/*  362 */     _size_ += CodedOutputStream.computeInt32Size(8, this.life);
/*  363 */     for (Map.Entry<Integer, Integer> _e_ : this.basicproperty.entrySet())
/*      */     {
/*  365 */       _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getKey()).intValue());
/*  366 */       _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  368 */     _size_ += CodedOutputStream.computeBoolSize(10, this.isautospecialpoint);
/*  369 */     for (Map.Entry<Integer, Integer> _e_ : this.autospecialpointcase.entrySet())
/*      */     {
/*  371 */       _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getKey()).intValue());
/*  372 */       _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  374 */     _size_ += CodedOutputStream.computeInt32Size(12, this.potentialpoint);
/*  375 */     _size_ += CodedOutputStream.computeMessageSize(13, this.aptitude);
/*  376 */     _size_ += CodedOutputStream.computeFloatSize(14, this.grow);
/*  377 */     _size_ += CodedOutputStream.computeInt32Size(15, this.rememberskillid);
/*  378 */     _size_ += CodedOutputStream.computeMessageSize(16, this.equipbag);
/*  379 */     for (xbean.PetSkill _v_ : this.skilllist)
/*      */     {
/*  381 */       _size_ += CodedOutputStream.computeMessageSize(17, _v_);
/*      */     }
/*  383 */     _size_ += CodedOutputStream.computeInt32Size(18, this.isbinded);
/*  384 */     _size_ += CodedOutputStream.computeInt32Size(19, this.yaoli);
/*  385 */     _size_ += CodedOutputStream.computeInt64Size(20, this.marketbuytime);
/*  386 */     _size_ += CodedOutputStream.computeInt32Size(21, this.lianguitemusenum);
/*  387 */     _size_ += CodedOutputStream.computeInt32Size(22, this.growitemusenum);
/*  388 */     _size_ += CodedOutputStream.computeInt32Size(23, this.fanshengunbianyinum);
/*  389 */     _size_ += CodedOutputStream.computeInt32Size(24, this.stagelevel);
/*  390 */     _size_ += CodedOutputStream.computeInt64Size(25, this.changeyaolitime);
/*  391 */     _size_ += CodedOutputStream.computeInt32Size(26, this.extramodelcfgid);
/*  392 */     _size_ += CodedOutputStream.computeMessageSize(27, this.soulbag);
/*  393 */     for (Integer _v_ : this.ownextramodelcfgids)
/*      */     {
/*  395 */       _size_ += CodedOutputStream.computeInt32Size(28, _v_.intValue());
/*      */     }
/*  397 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  406 */       _output_.writeInt64(1, this.id);
/*  407 */       _output_.writeInt32(2, this.templateid);
/*  408 */       _output_.writeBytes(3, ByteString.copyFrom(this.petname, "UTF-16LE"));
/*  409 */       _output_.writeInt32(4, this.level);
/*  410 */       _output_.writeInt32(5, this.hp);
/*  411 */       _output_.writeInt32(6, this.mp);
/*  412 */       _output_.writeInt32(7, this.exp);
/*  413 */       _output_.writeInt32(8, this.life);
/*  414 */       for (Map.Entry<Integer, Integer> _e_ : this.basicproperty.entrySet())
/*      */       {
/*  416 */         _output_.writeInt32(9, ((Integer)_e_.getKey()).intValue());
/*  417 */         _output_.writeInt32(9, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  419 */       _output_.writeBool(10, this.isautospecialpoint);
/*  420 */       for (Map.Entry<Integer, Integer> _e_ : this.autospecialpointcase.entrySet())
/*      */       {
/*  422 */         _output_.writeInt32(11, ((Integer)_e_.getKey()).intValue());
/*  423 */         _output_.writeInt32(11, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  425 */       _output_.writeInt32(12, this.potentialpoint);
/*  426 */       _output_.writeMessage(13, this.aptitude);
/*  427 */       _output_.writeFloat(14, this.grow);
/*  428 */       _output_.writeInt32(15, this.rememberskillid);
/*  429 */       _output_.writeMessage(16, this.equipbag);
/*  430 */       for (xbean.PetSkill _v_ : this.skilllist)
/*      */       {
/*  432 */         _output_.writeMessage(17, _v_);
/*      */       }
/*  434 */       _output_.writeInt32(18, this.isbinded);
/*  435 */       _output_.writeInt32(19, this.yaoli);
/*  436 */       _output_.writeInt64(20, this.marketbuytime);
/*  437 */       _output_.writeInt32(21, this.lianguitemusenum);
/*  438 */       _output_.writeInt32(22, this.growitemusenum);
/*  439 */       _output_.writeInt32(23, this.fanshengunbianyinum);
/*  440 */       _output_.writeInt32(24, this.stagelevel);
/*  441 */       _output_.writeInt64(25, this.changeyaolitime);
/*  442 */       _output_.writeInt32(26, this.extramodelcfgid);
/*  443 */       _output_.writeMessage(27, this.soulbag);
/*  444 */       for (Integer _v_ : this.ownextramodelcfgids)
/*      */       {
/*  446 */         _output_.writeInt32(28, _v_.intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  451 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  453 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  462 */       boolean done = false;
/*  463 */       while (!done)
/*      */       {
/*  465 */         int tag = _input_.readTag();
/*  466 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  470 */           done = true;
/*  471 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  475 */           this.id = _input_.readInt64();
/*  476 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  480 */           this.templateid = _input_.readInt32();
/*  481 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  485 */           this.petname = _input_.readBytes().toString("UTF-16LE");
/*  486 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  490 */           this.level = _input_.readInt32();
/*  491 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  495 */           this.hp = _input_.readInt32();
/*  496 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  500 */           this.mp = _input_.readInt32();
/*  501 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  505 */           this.exp = _input_.readInt32();
/*  506 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  510 */           this.life = _input_.readInt32();
/*  511 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  515 */           int _k_ = 0;
/*  516 */           _k_ = _input_.readInt32();
/*  517 */           int readTag = _input_.readTag();
/*  518 */           if (72 != readTag)
/*      */           {
/*  520 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  522 */           int _v_ = 0;
/*  523 */           _v_ = _input_.readInt32();
/*  524 */           this.basicproperty.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  525 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  529 */           this.isautospecialpoint = _input_.readBool();
/*  530 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  534 */           int _k_ = 0;
/*  535 */           _k_ = _input_.readInt32();
/*  536 */           int readTag = _input_.readTag();
/*  537 */           if (88 != readTag)
/*      */           {
/*  539 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  541 */           int _v_ = 0;
/*  542 */           _v_ = _input_.readInt32();
/*  543 */           this.autospecialpointcase.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  544 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  548 */           this.potentialpoint = _input_.readInt32();
/*  549 */           break;
/*      */         
/*      */ 
/*      */         case 106: 
/*  553 */           _input_.readMessage(this.aptitude);
/*  554 */           break;
/*      */         
/*      */ 
/*      */         case 117: 
/*  558 */           this.grow = _input_.readFloat();
/*  559 */           break;
/*      */         
/*      */ 
/*      */         case 120: 
/*  563 */           this.rememberskillid = _input_.readInt32();
/*  564 */           break;
/*      */         
/*      */ 
/*      */         case 130: 
/*  568 */           _input_.readMessage(this.equipbag);
/*  569 */           break;
/*      */         
/*      */ 
/*      */         case 138: 
/*  573 */           xbean.PetSkill _v_ = new PetSkill(0, this, "skilllist");
/*  574 */           _input_.readMessage(_v_);
/*  575 */           this.skilllist.add(_v_);
/*  576 */           break;
/*      */         
/*      */ 
/*      */         case 144: 
/*  580 */           this.isbinded = _input_.readInt32();
/*  581 */           break;
/*      */         
/*      */ 
/*      */         case 152: 
/*  585 */           this.yaoli = _input_.readInt32();
/*  586 */           break;
/*      */         
/*      */ 
/*      */         case 160: 
/*  590 */           this.marketbuytime = _input_.readInt64();
/*  591 */           break;
/*      */         
/*      */ 
/*      */         case 168: 
/*  595 */           this.lianguitemusenum = _input_.readInt32();
/*  596 */           break;
/*      */         
/*      */ 
/*      */         case 176: 
/*  600 */           this.growitemusenum = _input_.readInt32();
/*  601 */           break;
/*      */         
/*      */ 
/*      */         case 184: 
/*  605 */           this.fanshengunbianyinum = _input_.readInt32();
/*  606 */           break;
/*      */         
/*      */ 
/*      */         case 192: 
/*  610 */           this.stagelevel = _input_.readInt32();
/*  611 */           break;
/*      */         
/*      */ 
/*      */         case 200: 
/*  615 */           this.changeyaolitime = _input_.readInt64();
/*  616 */           break;
/*      */         
/*      */ 
/*      */         case 208: 
/*  620 */           this.extramodelcfgid = _input_.readInt32();
/*  621 */           break;
/*      */         
/*      */ 
/*      */         case 218: 
/*  625 */           _input_.readMessage(this.soulbag);
/*  626 */           break;
/*      */         
/*      */ 
/*      */         case 224: 
/*  630 */           int _v_ = 0;
/*  631 */           _v_ = _input_.readInt32();
/*  632 */           this.ownextramodelcfgids.add(Integer.valueOf(_v_));
/*  633 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  637 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  639 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  648 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  652 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  654 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Pet copy()
/*      */   {
/*  660 */     _xdb_verify_unsafe_();
/*  661 */     return new Pet(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Pet toData()
/*      */   {
/*  667 */     _xdb_verify_unsafe_();
/*  668 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Pet toBean()
/*      */   {
/*  673 */     _xdb_verify_unsafe_();
/*  674 */     return new Pet(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Pet toDataIf()
/*      */   {
/*  680 */     _xdb_verify_unsafe_();
/*  681 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Pet toBeanIf()
/*      */   {
/*  686 */     _xdb_verify_unsafe_();
/*  687 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  693 */     _xdb_verify_unsafe_();
/*  694 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getId()
/*      */   {
/*  701 */     _xdb_verify_unsafe_();
/*  702 */     return this.id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTemplateid()
/*      */   {
/*  709 */     _xdb_verify_unsafe_();
/*  710 */     return this.templateid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getPetname()
/*      */   {
/*  717 */     _xdb_verify_unsafe_();
/*  718 */     return this.petname;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getPetnameOctets()
/*      */   {
/*  725 */     _xdb_verify_unsafe_();
/*  726 */     return Octets.wrap(getPetname(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLevel()
/*      */   {
/*  733 */     _xdb_verify_unsafe_();
/*  734 */     return this.level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHp()
/*      */   {
/*  741 */     _xdb_verify_unsafe_();
/*  742 */     return this.hp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMp()
/*      */   {
/*  749 */     _xdb_verify_unsafe_();
/*  750 */     return this.mp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getExp()
/*      */   {
/*  757 */     _xdb_verify_unsafe_();
/*  758 */     return this.exp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLife()
/*      */   {
/*  765 */     _xdb_verify_unsafe_();
/*  766 */     return this.life;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBasicproperty()
/*      */   {
/*  773 */     _xdb_verify_unsafe_();
/*  774 */     return Logs.logMap(new LogKey(this, "basicproperty"), this.basicproperty);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBasicpropertyAsData()
/*      */   {
/*  781 */     _xdb_verify_unsafe_();
/*      */     
/*  783 */     Pet _o_ = this;
/*  784 */     Map<Integer, Integer> basicproperty = new HashMap();
/*  785 */     for (Map.Entry<Integer, Integer> _e_ : _o_.basicproperty.entrySet())
/*  786 */       basicproperty.put(_e_.getKey(), _e_.getValue());
/*  787 */     return basicproperty;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIsautospecialpoint()
/*      */   {
/*  794 */     _xdb_verify_unsafe_();
/*  795 */     return this.isautospecialpoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getAutospecialpointcase()
/*      */   {
/*  802 */     _xdb_verify_unsafe_();
/*  803 */     return Logs.logMap(new LogKey(this, "autospecialpointcase"), this.autospecialpointcase);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getAutospecialpointcaseAsData()
/*      */   {
/*  810 */     _xdb_verify_unsafe_();
/*      */     
/*  812 */     Pet _o_ = this;
/*  813 */     Map<Integer, Integer> autospecialpointcase = new HashMap();
/*  814 */     for (Map.Entry<Integer, Integer> _e_ : _o_.autospecialpointcase.entrySet())
/*  815 */       autospecialpointcase.put(_e_.getKey(), _e_.getValue());
/*  816 */     return autospecialpointcase;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPotentialpoint()
/*      */   {
/*  823 */     _xdb_verify_unsafe_();
/*  824 */     return this.potentialpoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.Aptitude getAptitude()
/*      */   {
/*  831 */     _xdb_verify_unsafe_();
/*  832 */     return this.aptitude;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public float getGrow()
/*      */   {
/*  839 */     _xdb_verify_unsafe_();
/*  840 */     return this.grow;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRememberskillid()
/*      */   {
/*  847 */     _xdb_verify_unsafe_();
/*  848 */     return this.rememberskillid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.PetEquipBag getEquipbag()
/*      */   {
/*  855 */     _xdb_verify_unsafe_();
/*  856 */     return this.equipbag;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.PetSkill> getSkilllist()
/*      */   {
/*  863 */     _xdb_verify_unsafe_();
/*  864 */     return Logs.logList(new LogKey(this, "skilllist"), this.skilllist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.PetSkill> getSkilllistAsData()
/*      */   {
/*  870 */     _xdb_verify_unsafe_();
/*      */     
/*  872 */     Pet _o_ = this;
/*  873 */     List<xbean.PetSkill> skilllist = new LinkedList();
/*  874 */     for (xbean.PetSkill _v_ : _o_.skilllist)
/*  875 */       skilllist.add(new PetSkill.Data(_v_));
/*  876 */     return skilllist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getIsbinded()
/*      */   {
/*  883 */     _xdb_verify_unsafe_();
/*  884 */     return this.isbinded;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getYaoli()
/*      */   {
/*  891 */     _xdb_verify_unsafe_();
/*  892 */     return this.yaoli;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMarketbuytime()
/*      */   {
/*  899 */     _xdb_verify_unsafe_();
/*  900 */     return this.marketbuytime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLianguitemusenum()
/*      */   {
/*  907 */     _xdb_verify_unsafe_();
/*  908 */     return this.lianguitemusenum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGrowitemusenum()
/*      */   {
/*  915 */     _xdb_verify_unsafe_();
/*  916 */     return this.growitemusenum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFanshengunbianyinum()
/*      */   {
/*  923 */     _xdb_verify_unsafe_();
/*  924 */     return this.fanshengunbianyinum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStagelevel()
/*      */   {
/*  931 */     _xdb_verify_unsafe_();
/*  932 */     return this.stagelevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getChangeyaolitime()
/*      */   {
/*  939 */     _xdb_verify_unsafe_();
/*  940 */     return this.changeyaolitime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getExtramodelcfgid()
/*      */   {
/*  947 */     _xdb_verify_unsafe_();
/*  948 */     return this.extramodelcfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.PetSoulBag getSoulbag()
/*      */   {
/*  955 */     _xdb_verify_unsafe_();
/*  956 */     return this.soulbag;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getOwnextramodelcfgids()
/*      */   {
/*  963 */     _xdb_verify_unsafe_();
/*  964 */     return Logs.logList(new LogKey(this, "ownextramodelcfgids"), this.ownextramodelcfgids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getOwnextramodelcfgidsAsData()
/*      */   {
/*  970 */     _xdb_verify_unsafe_();
/*      */     
/*  972 */     Pet _o_ = this;
/*  973 */     List<Integer> ownextramodelcfgids = new ArrayList();
/*  974 */     ownextramodelcfgids.addAll(_o_.ownextramodelcfgids);
/*  975 */     return ownextramodelcfgids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setId(long _v_)
/*      */   {
/*  982 */     _xdb_verify_unsafe_();
/*  983 */     Logs.logIf(new LogKey(this, "id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  987 */         new LogLong(this, Pet.this.id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  991 */             Pet.this.id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  995 */     });
/*  996 */     this.id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTemplateid(int _v_)
/*      */   {
/* 1003 */     _xdb_verify_unsafe_();
/* 1004 */     Logs.logIf(new LogKey(this, "templateid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1008 */         new LogInt(this, Pet.this.templateid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1012 */             Pet.this.templateid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1016 */     });
/* 1017 */     this.templateid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPetname(String _v_)
/*      */   {
/* 1024 */     _xdb_verify_unsafe_();
/* 1025 */     if (null == _v_)
/* 1026 */       throw new NullPointerException();
/* 1027 */     Logs.logIf(new LogKey(this, "petname")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1031 */         new LogString(this, Pet.this.petname)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1035 */             Pet.this.petname = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1039 */     });
/* 1040 */     this.petname = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPetnameOctets(Octets _v_)
/*      */   {
/* 1047 */     _xdb_verify_unsafe_();
/* 1048 */     setPetname(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevel(int _v_)
/*      */   {
/* 1055 */     _xdb_verify_unsafe_();
/* 1056 */     Logs.logIf(new LogKey(this, "level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1060 */         new LogInt(this, Pet.this.level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1064 */             Pet.this.level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1068 */     });
/* 1069 */     this.level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHp(int _v_)
/*      */   {
/* 1076 */     _xdb_verify_unsafe_();
/* 1077 */     Logs.logIf(new LogKey(this, "hp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1081 */         new LogInt(this, Pet.this.hp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1085 */             Pet.this.hp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1089 */     });
/* 1090 */     this.hp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMp(int _v_)
/*      */   {
/* 1097 */     _xdb_verify_unsafe_();
/* 1098 */     Logs.logIf(new LogKey(this, "mp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1102 */         new LogInt(this, Pet.this.mp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1106 */             Pet.this.mp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1110 */     });
/* 1111 */     this.mp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExp(int _v_)
/*      */   {
/* 1118 */     _xdb_verify_unsafe_();
/* 1119 */     Logs.logIf(new LogKey(this, "exp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1123 */         new LogInt(this, Pet.this.exp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1127 */             Pet.this.exp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1131 */     });
/* 1132 */     this.exp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLife(int _v_)
/*      */   {
/* 1139 */     _xdb_verify_unsafe_();
/* 1140 */     Logs.logIf(new LogKey(this, "life")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1144 */         new LogInt(this, Pet.this.life)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1148 */             Pet.this.life = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1152 */     });
/* 1153 */     this.life = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIsautospecialpoint(boolean _v_)
/*      */   {
/* 1160 */     _xdb_verify_unsafe_();
/* 1161 */     Logs.logIf(new LogKey(this, "isautospecialpoint")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1165 */         new LogObject(this, Boolean.valueOf(Pet.this.isautospecialpoint))
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1169 */             Pet.this.isautospecialpoint = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/* 1173 */     });
/* 1174 */     this.isautospecialpoint = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPotentialpoint(int _v_)
/*      */   {
/* 1181 */     _xdb_verify_unsafe_();
/* 1182 */     Logs.logIf(new LogKey(this, "potentialpoint")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1186 */         new LogInt(this, Pet.this.potentialpoint)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1190 */             Pet.this.potentialpoint = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1194 */     });
/* 1195 */     this.potentialpoint = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGrow(float _v_)
/*      */   {
/* 1202 */     _xdb_verify_unsafe_();
/* 1203 */     Logs.logIf(new LogKey(this, "grow")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1207 */         new LogFloat(this, Pet.this.grow)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1211 */             Pet.this.grow = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1215 */     });
/* 1216 */     this.grow = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRememberskillid(int _v_)
/*      */   {
/* 1223 */     _xdb_verify_unsafe_();
/* 1224 */     Logs.logIf(new LogKey(this, "rememberskillid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1228 */         new LogInt(this, Pet.this.rememberskillid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1232 */             Pet.this.rememberskillid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1236 */     });
/* 1237 */     this.rememberskillid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIsbinded(int _v_)
/*      */   {
/* 1244 */     _xdb_verify_unsafe_();
/* 1245 */     Logs.logIf(new LogKey(this, "isbinded")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1249 */         new LogInt(this, Pet.this.isbinded)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1253 */             Pet.this.isbinded = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1257 */     });
/* 1258 */     this.isbinded = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setYaoli(int _v_)
/*      */   {
/* 1265 */     _xdb_verify_unsafe_();
/* 1266 */     Logs.logIf(new LogKey(this, "yaoli")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1270 */         new LogInt(this, Pet.this.yaoli)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1274 */             Pet.this.yaoli = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1278 */     });
/* 1279 */     this.yaoli = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMarketbuytime(long _v_)
/*      */   {
/* 1286 */     _xdb_verify_unsafe_();
/* 1287 */     Logs.logIf(new LogKey(this, "marketbuytime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1291 */         new LogLong(this, Pet.this.marketbuytime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1295 */             Pet.this.marketbuytime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1299 */     });
/* 1300 */     this.marketbuytime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLianguitemusenum(int _v_)
/*      */   {
/* 1307 */     _xdb_verify_unsafe_();
/* 1308 */     Logs.logIf(new LogKey(this, "lianguitemusenum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1312 */         new LogInt(this, Pet.this.lianguitemusenum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1316 */             Pet.this.lianguitemusenum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1320 */     });
/* 1321 */     this.lianguitemusenum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGrowitemusenum(int _v_)
/*      */   {
/* 1328 */     _xdb_verify_unsafe_();
/* 1329 */     Logs.logIf(new LogKey(this, "growitemusenum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1333 */         new LogInt(this, Pet.this.growitemusenum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1337 */             Pet.this.growitemusenum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1341 */     });
/* 1342 */     this.growitemusenum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFanshengunbianyinum(int _v_)
/*      */   {
/* 1349 */     _xdb_verify_unsafe_();
/* 1350 */     Logs.logIf(new LogKey(this, "fanshengunbianyinum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1354 */         new LogInt(this, Pet.this.fanshengunbianyinum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1358 */             Pet.this.fanshengunbianyinum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1362 */     });
/* 1363 */     this.fanshengunbianyinum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStagelevel(int _v_)
/*      */   {
/* 1370 */     _xdb_verify_unsafe_();
/* 1371 */     Logs.logIf(new LogKey(this, "stagelevel")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1375 */         new LogInt(this, Pet.this.stagelevel)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1379 */             Pet.this.stagelevel = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1383 */     });
/* 1384 */     this.stagelevel = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChangeyaolitime(long _v_)
/*      */   {
/* 1391 */     _xdb_verify_unsafe_();
/* 1392 */     Logs.logIf(new LogKey(this, "changeyaolitime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1396 */         new LogLong(this, Pet.this.changeyaolitime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1400 */             Pet.this.changeyaolitime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1404 */     });
/* 1405 */     this.changeyaolitime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExtramodelcfgid(int _v_)
/*      */   {
/* 1412 */     _xdb_verify_unsafe_();
/* 1413 */     Logs.logIf(new LogKey(this, "extramodelcfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1417 */         new LogInt(this, Pet.this.extramodelcfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1421 */             Pet.this.extramodelcfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1425 */     });
/* 1426 */     this.extramodelcfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/* 1432 */     _xdb_verify_unsafe_();
/* 1433 */     Pet _o_ = null;
/* 1434 */     if ((_o1_ instanceof Pet)) { _o_ = (Pet)_o1_;
/* 1435 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 1436 */       return false;
/* 1437 */     if (this.id != _o_.id) return false;
/* 1438 */     if (this.templateid != _o_.templateid) return false;
/* 1439 */     if (!this.petname.equals(_o_.petname)) return false;
/* 1440 */     if (this.level != _o_.level) return false;
/* 1441 */     if (this.hp != _o_.hp) return false;
/* 1442 */     if (this.mp != _o_.mp) return false;
/* 1443 */     if (this.exp != _o_.exp) return false;
/* 1444 */     if (this.life != _o_.life) return false;
/* 1445 */     if (!this.basicproperty.equals(_o_.basicproperty)) return false;
/* 1446 */     if (this.isautospecialpoint != _o_.isautospecialpoint) return false;
/* 1447 */     if (!this.autospecialpointcase.equals(_o_.autospecialpointcase)) return false;
/* 1448 */     if (this.potentialpoint != _o_.potentialpoint) return false;
/* 1449 */     if (!this.aptitude.equals(_o_.aptitude)) return false;
/* 1450 */     if (this.grow != _o_.grow) return false;
/* 1451 */     if (this.rememberskillid != _o_.rememberskillid) return false;
/* 1452 */     if (!this.equipbag.equals(_o_.equipbag)) return false;
/* 1453 */     if (!this.skilllist.equals(_o_.skilllist)) return false;
/* 1454 */     if (this.isbinded != _o_.isbinded) return false;
/* 1455 */     if (this.yaoli != _o_.yaoli) return false;
/* 1456 */     if (this.marketbuytime != _o_.marketbuytime) return false;
/* 1457 */     if (this.lianguitemusenum != _o_.lianguitemusenum) return false;
/* 1458 */     if (this.growitemusenum != _o_.growitemusenum) return false;
/* 1459 */     if (this.fanshengunbianyinum != _o_.fanshengunbianyinum) return false;
/* 1460 */     if (this.stagelevel != _o_.stagelevel) return false;
/* 1461 */     if (this.changeyaolitime != _o_.changeyaolitime) return false;
/* 1462 */     if (this.extramodelcfgid != _o_.extramodelcfgid) return false;
/* 1463 */     if (!this.soulbag.equals(_o_.soulbag)) return false;
/* 1464 */     if (!this.ownextramodelcfgids.equals(_o_.ownextramodelcfgids)) return false;
/* 1465 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/* 1471 */     _xdb_verify_unsafe_();
/* 1472 */     int _h_ = 0;
/* 1473 */     _h_ = (int)(_h_ + this.id);
/* 1474 */     _h_ += this.templateid;
/* 1475 */     _h_ += this.petname.hashCode();
/* 1476 */     _h_ += this.level;
/* 1477 */     _h_ += this.hp;
/* 1478 */     _h_ += this.mp;
/* 1479 */     _h_ += this.exp;
/* 1480 */     _h_ += this.life;
/* 1481 */     _h_ += this.basicproperty.hashCode();
/* 1482 */     _h_ += (this.isautospecialpoint ? 1231 : 1237);
/* 1483 */     _h_ += this.autospecialpointcase.hashCode();
/* 1484 */     _h_ += this.potentialpoint;
/* 1485 */     _h_ += this.aptitude.hashCode();
/* 1486 */     _h_ = (int)(_h_ + this.grow);
/* 1487 */     _h_ += this.rememberskillid;
/* 1488 */     _h_ += this.equipbag.hashCode();
/* 1489 */     _h_ += this.skilllist.hashCode();
/* 1490 */     _h_ += this.isbinded;
/* 1491 */     _h_ += this.yaoli;
/* 1492 */     _h_ = (int)(_h_ + this.marketbuytime);
/* 1493 */     _h_ += this.lianguitemusenum;
/* 1494 */     _h_ += this.growitemusenum;
/* 1495 */     _h_ += this.fanshengunbianyinum;
/* 1496 */     _h_ += this.stagelevel;
/* 1497 */     _h_ = (int)(_h_ + this.changeyaolitime);
/* 1498 */     _h_ += this.extramodelcfgid;
/* 1499 */     _h_ += this.soulbag.hashCode();
/* 1500 */     _h_ += this.ownextramodelcfgids.hashCode();
/* 1501 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1507 */     _xdb_verify_unsafe_();
/* 1508 */     StringBuilder _sb_ = new StringBuilder();
/* 1509 */     _sb_.append("(");
/* 1510 */     _sb_.append(this.id);
/* 1511 */     _sb_.append(",");
/* 1512 */     _sb_.append(this.templateid);
/* 1513 */     _sb_.append(",");
/* 1514 */     _sb_.append("'").append(this.petname).append("'");
/* 1515 */     _sb_.append(",");
/* 1516 */     _sb_.append(this.level);
/* 1517 */     _sb_.append(",");
/* 1518 */     _sb_.append(this.hp);
/* 1519 */     _sb_.append(",");
/* 1520 */     _sb_.append(this.mp);
/* 1521 */     _sb_.append(",");
/* 1522 */     _sb_.append(this.exp);
/* 1523 */     _sb_.append(",");
/* 1524 */     _sb_.append(this.life);
/* 1525 */     _sb_.append(",");
/* 1526 */     _sb_.append(this.basicproperty);
/* 1527 */     _sb_.append(",");
/* 1528 */     _sb_.append(this.isautospecialpoint);
/* 1529 */     _sb_.append(",");
/* 1530 */     _sb_.append(this.autospecialpointcase);
/* 1531 */     _sb_.append(",");
/* 1532 */     _sb_.append(this.potentialpoint);
/* 1533 */     _sb_.append(",");
/* 1534 */     _sb_.append(this.aptitude);
/* 1535 */     _sb_.append(",");
/* 1536 */     _sb_.append(this.grow);
/* 1537 */     _sb_.append(",");
/* 1538 */     _sb_.append(this.rememberskillid);
/* 1539 */     _sb_.append(",");
/* 1540 */     _sb_.append(this.equipbag);
/* 1541 */     _sb_.append(",");
/* 1542 */     _sb_.append(this.skilllist);
/* 1543 */     _sb_.append(",");
/* 1544 */     _sb_.append(this.isbinded);
/* 1545 */     _sb_.append(",");
/* 1546 */     _sb_.append(this.yaoli);
/* 1547 */     _sb_.append(",");
/* 1548 */     _sb_.append(this.marketbuytime);
/* 1549 */     _sb_.append(",");
/* 1550 */     _sb_.append(this.lianguitemusenum);
/* 1551 */     _sb_.append(",");
/* 1552 */     _sb_.append(this.growitemusenum);
/* 1553 */     _sb_.append(",");
/* 1554 */     _sb_.append(this.fanshengunbianyinum);
/* 1555 */     _sb_.append(",");
/* 1556 */     _sb_.append(this.stagelevel);
/* 1557 */     _sb_.append(",");
/* 1558 */     _sb_.append(this.changeyaolitime);
/* 1559 */     _sb_.append(",");
/* 1560 */     _sb_.append(this.extramodelcfgid);
/* 1561 */     _sb_.append(",");
/* 1562 */     _sb_.append(this.soulbag);
/* 1563 */     _sb_.append(",");
/* 1564 */     _sb_.append(this.ownextramodelcfgids);
/* 1565 */     _sb_.append(")");
/* 1566 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/* 1572 */     ListenableBean lb = new ListenableBean();
/* 1573 */     lb.add(new ListenableChanged().setVarName("id"));
/* 1574 */     lb.add(new ListenableChanged().setVarName("templateid"));
/* 1575 */     lb.add(new ListenableChanged().setVarName("petname"));
/* 1576 */     lb.add(new ListenableChanged().setVarName("level"));
/* 1577 */     lb.add(new ListenableChanged().setVarName("hp"));
/* 1578 */     lb.add(new ListenableChanged().setVarName("mp"));
/* 1579 */     lb.add(new ListenableChanged().setVarName("exp"));
/* 1580 */     lb.add(new ListenableChanged().setVarName("life"));
/* 1581 */     lb.add(new ListenableMap().setVarName("basicproperty"));
/* 1582 */     lb.add(new ListenableChanged().setVarName("isautospecialpoint"));
/* 1583 */     lb.add(new ListenableMap().setVarName("autospecialpointcase"));
/* 1584 */     lb.add(new ListenableChanged().setVarName("potentialpoint"));
/* 1585 */     lb.add(new ListenableChanged().setVarName("aptitude"));
/* 1586 */     lb.add(new ListenableChanged().setVarName("grow"));
/* 1587 */     lb.add(new ListenableChanged().setVarName("rememberskillid"));
/* 1588 */     lb.add(new ListenableChanged().setVarName("equipbag"));
/* 1589 */     lb.add(new ListenableChanged().setVarName("skilllist"));
/* 1590 */     lb.add(new ListenableChanged().setVarName("isbinded"));
/* 1591 */     lb.add(new ListenableChanged().setVarName("yaoli"));
/* 1592 */     lb.add(new ListenableChanged().setVarName("marketbuytime"));
/* 1593 */     lb.add(new ListenableChanged().setVarName("lianguitemusenum"));
/* 1594 */     lb.add(new ListenableChanged().setVarName("growitemusenum"));
/* 1595 */     lb.add(new ListenableChanged().setVarName("fanshengunbianyinum"));
/* 1596 */     lb.add(new ListenableChanged().setVarName("stagelevel"));
/* 1597 */     lb.add(new ListenableChanged().setVarName("changeyaolitime"));
/* 1598 */     lb.add(new ListenableChanged().setVarName("extramodelcfgid"));
/* 1599 */     lb.add(new ListenableChanged().setVarName("soulbag"));
/* 1600 */     lb.add(new ListenableChanged().setVarName("ownextramodelcfgids"));
/* 1601 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Pet {
/*      */     private Const() {}
/*      */     
/*      */     Pet nThis() {
/* 1608 */       return Pet.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1614 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Pet copy()
/*      */     {
/* 1620 */       return Pet.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Pet toData()
/*      */     {
/* 1626 */       return Pet.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Pet toBean()
/*      */     {
/* 1631 */       return Pet.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Pet toDataIf()
/*      */     {
/* 1637 */       return Pet.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Pet toBeanIf()
/*      */     {
/* 1642 */       return Pet.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getId()
/*      */     {
/* 1649 */       Pet.this._xdb_verify_unsafe_();
/* 1650 */       return Pet.this.id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTemplateid()
/*      */     {
/* 1657 */       Pet.this._xdb_verify_unsafe_();
/* 1658 */       return Pet.this.templateid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getPetname()
/*      */     {
/* 1665 */       Pet.this._xdb_verify_unsafe_();
/* 1666 */       return Pet.this.petname;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getPetnameOctets()
/*      */     {
/* 1673 */       Pet.this._xdb_verify_unsafe_();
/* 1674 */       return Pet.this.getPetnameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/* 1681 */       Pet.this._xdb_verify_unsafe_();
/* 1682 */       return Pet.this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHp()
/*      */     {
/* 1689 */       Pet.this._xdb_verify_unsafe_();
/* 1690 */       return Pet.this.hp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMp()
/*      */     {
/* 1697 */       Pet.this._xdb_verify_unsafe_();
/* 1698 */       return Pet.this.mp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExp()
/*      */     {
/* 1705 */       Pet.this._xdb_verify_unsafe_();
/* 1706 */       return Pet.this.exp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLife()
/*      */     {
/* 1713 */       Pet.this._xdb_verify_unsafe_();
/* 1714 */       return Pet.this.life;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasicproperty()
/*      */     {
/* 1721 */       Pet.this._xdb_verify_unsafe_();
/* 1722 */       return Consts.constMap(Pet.this.basicproperty);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasicpropertyAsData()
/*      */     {
/* 1729 */       Pet.this._xdb_verify_unsafe_();
/*      */       
/* 1731 */       Pet _o_ = Pet.this;
/* 1732 */       Map<Integer, Integer> basicproperty = new HashMap();
/* 1733 */       for (Map.Entry<Integer, Integer> _e_ : _o_.basicproperty.entrySet())
/* 1734 */         basicproperty.put(_e_.getKey(), _e_.getValue());
/* 1735 */       return basicproperty;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsautospecialpoint()
/*      */     {
/* 1742 */       Pet.this._xdb_verify_unsafe_();
/* 1743 */       return Pet.this.isautospecialpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAutospecialpointcase()
/*      */     {
/* 1750 */       Pet.this._xdb_verify_unsafe_();
/* 1751 */       return Consts.constMap(Pet.this.autospecialpointcase);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAutospecialpointcaseAsData()
/*      */     {
/* 1758 */       Pet.this._xdb_verify_unsafe_();
/*      */       
/* 1760 */       Pet _o_ = Pet.this;
/* 1761 */       Map<Integer, Integer> autospecialpointcase = new HashMap();
/* 1762 */       for (Map.Entry<Integer, Integer> _e_ : _o_.autospecialpointcase.entrySet())
/* 1763 */         autospecialpointcase.put(_e_.getKey(), _e_.getValue());
/* 1764 */       return autospecialpointcase;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPotentialpoint()
/*      */     {
/* 1771 */       Pet.this._xdb_verify_unsafe_();
/* 1772 */       return Pet.this.potentialpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.Aptitude getAptitude()
/*      */     {
/* 1779 */       Pet.this._xdb_verify_unsafe_();
/* 1780 */       return (xbean.Aptitude)Consts.toConst(Pet.this.aptitude);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getGrow()
/*      */     {
/* 1787 */       Pet.this._xdb_verify_unsafe_();
/* 1788 */       return Pet.this.grow;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRememberskillid()
/*      */     {
/* 1795 */       Pet.this._xdb_verify_unsafe_();
/* 1796 */       return Pet.this.rememberskillid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.PetEquipBag getEquipbag()
/*      */     {
/* 1803 */       Pet.this._xdb_verify_unsafe_();
/* 1804 */       return (xbean.PetEquipBag)Consts.toConst(Pet.this.equipbag);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetSkill> getSkilllist()
/*      */     {
/* 1811 */       Pet.this._xdb_verify_unsafe_();
/* 1812 */       return Consts.constList(Pet.this.skilllist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.PetSkill> getSkilllistAsData()
/*      */     {
/* 1818 */       Pet.this._xdb_verify_unsafe_();
/*      */       
/* 1820 */       Pet _o_ = Pet.this;
/* 1821 */       List<xbean.PetSkill> skilllist = new LinkedList();
/* 1822 */       for (xbean.PetSkill _v_ : _o_.skilllist)
/* 1823 */         skilllist.add(new PetSkill.Data(_v_));
/* 1824 */       return skilllist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIsbinded()
/*      */     {
/* 1831 */       Pet.this._xdb_verify_unsafe_();
/* 1832 */       return Pet.this.isbinded;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getYaoli()
/*      */     {
/* 1839 */       Pet.this._xdb_verify_unsafe_();
/* 1840 */       return Pet.this.yaoli;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMarketbuytime()
/*      */     {
/* 1847 */       Pet.this._xdb_verify_unsafe_();
/* 1848 */       return Pet.this.marketbuytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLianguitemusenum()
/*      */     {
/* 1855 */       Pet.this._xdb_verify_unsafe_();
/* 1856 */       return Pet.this.lianguitemusenum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGrowitemusenum()
/*      */     {
/* 1863 */       Pet.this._xdb_verify_unsafe_();
/* 1864 */       return Pet.this.growitemusenum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFanshengunbianyinum()
/*      */     {
/* 1871 */       Pet.this._xdb_verify_unsafe_();
/* 1872 */       return Pet.this.fanshengunbianyinum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStagelevel()
/*      */     {
/* 1879 */       Pet.this._xdb_verify_unsafe_();
/* 1880 */       return Pet.this.stagelevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getChangeyaolitime()
/*      */     {
/* 1887 */       Pet.this._xdb_verify_unsafe_();
/* 1888 */       return Pet.this.changeyaolitime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExtramodelcfgid()
/*      */     {
/* 1895 */       Pet.this._xdb_verify_unsafe_();
/* 1896 */       return Pet.this.extramodelcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.PetSoulBag getSoulbag()
/*      */     {
/* 1903 */       Pet.this._xdb_verify_unsafe_();
/* 1904 */       return (xbean.PetSoulBag)Consts.toConst(Pet.this.soulbag);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getOwnextramodelcfgids()
/*      */     {
/* 1911 */       Pet.this._xdb_verify_unsafe_();
/* 1912 */       return Consts.constList(Pet.this.ownextramodelcfgids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getOwnextramodelcfgidsAsData()
/*      */     {
/* 1918 */       Pet.this._xdb_verify_unsafe_();
/*      */       
/* 1920 */       Pet _o_ = Pet.this;
/* 1921 */       List<Integer> ownextramodelcfgids = new ArrayList();
/* 1922 */       ownextramodelcfgids.addAll(_o_.ownextramodelcfgids);
/* 1923 */       return ownextramodelcfgids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setId(long _v_)
/*      */     {
/* 1930 */       Pet.this._xdb_verify_unsafe_();
/* 1931 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTemplateid(int _v_)
/*      */     {
/* 1938 */       Pet.this._xdb_verify_unsafe_();
/* 1939 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPetname(String _v_)
/*      */     {
/* 1946 */       Pet.this._xdb_verify_unsafe_();
/* 1947 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPetnameOctets(Octets _v_)
/*      */     {
/* 1954 */       Pet.this._xdb_verify_unsafe_();
/* 1955 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 1962 */       Pet.this._xdb_verify_unsafe_();
/* 1963 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHp(int _v_)
/*      */     {
/* 1970 */       Pet.this._xdb_verify_unsafe_();
/* 1971 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMp(int _v_)
/*      */     {
/* 1978 */       Pet.this._xdb_verify_unsafe_();
/* 1979 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExp(int _v_)
/*      */     {
/* 1986 */       Pet.this._xdb_verify_unsafe_();
/* 1987 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLife(int _v_)
/*      */     {
/* 1994 */       Pet.this._xdb_verify_unsafe_();
/* 1995 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsautospecialpoint(boolean _v_)
/*      */     {
/* 2002 */       Pet.this._xdb_verify_unsafe_();
/* 2003 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPotentialpoint(int _v_)
/*      */     {
/* 2010 */       Pet.this._xdb_verify_unsafe_();
/* 2011 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrow(float _v_)
/*      */     {
/* 2018 */       Pet.this._xdb_verify_unsafe_();
/* 2019 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRememberskillid(int _v_)
/*      */     {
/* 2026 */       Pet.this._xdb_verify_unsafe_();
/* 2027 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsbinded(int _v_)
/*      */     {
/* 2034 */       Pet.this._xdb_verify_unsafe_();
/* 2035 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setYaoli(int _v_)
/*      */     {
/* 2042 */       Pet.this._xdb_verify_unsafe_();
/* 2043 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMarketbuytime(long _v_)
/*      */     {
/* 2050 */       Pet.this._xdb_verify_unsafe_();
/* 2051 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLianguitemusenum(int _v_)
/*      */     {
/* 2058 */       Pet.this._xdb_verify_unsafe_();
/* 2059 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrowitemusenum(int _v_)
/*      */     {
/* 2066 */       Pet.this._xdb_verify_unsafe_();
/* 2067 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFanshengunbianyinum(int _v_)
/*      */     {
/* 2074 */       Pet.this._xdb_verify_unsafe_();
/* 2075 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStagelevel(int _v_)
/*      */     {
/* 2082 */       Pet.this._xdb_verify_unsafe_();
/* 2083 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChangeyaolitime(long _v_)
/*      */     {
/* 2090 */       Pet.this._xdb_verify_unsafe_();
/* 2091 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExtramodelcfgid(int _v_)
/*      */     {
/* 2098 */       Pet.this._xdb_verify_unsafe_();
/* 2099 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 2105 */       Pet.this._xdb_verify_unsafe_();
/* 2106 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 2112 */       Pet.this._xdb_verify_unsafe_();
/* 2113 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 2119 */       return Pet.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2125 */       return Pet.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2131 */       Pet.this._xdb_verify_unsafe_();
/* 2132 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 2138 */       return Pet.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2144 */       return Pet.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2150 */       Pet.this._xdb_verify_unsafe_();
/* 2151 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 2157 */       return Pet.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2163 */       return Pet.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 2169 */       return Pet.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 2175 */       return Pet.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 2181 */       return Pet.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 2187 */       return Pet.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2193 */       return Pet.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Pet
/*      */   {
/*      */     private long id;
/*      */     
/*      */     private int templateid;
/*      */     
/*      */     private String petname;
/*      */     
/*      */     private int level;
/*      */     
/*      */     private int hp;
/*      */     
/*      */     private int mp;
/*      */     
/*      */     private int exp;
/*      */     
/*      */     private int life;
/*      */     
/*      */     private HashMap<Integer, Integer> basicproperty;
/*      */     
/*      */     private boolean isautospecialpoint;
/*      */     
/*      */     private HashMap<Integer, Integer> autospecialpointcase;
/*      */     
/*      */     private int potentialpoint;
/*      */     
/*      */     private xbean.Aptitude aptitude;
/*      */     
/*      */     private float grow;
/*      */     
/*      */     private int rememberskillid;
/*      */     
/*      */     private xbean.PetEquipBag equipbag;
/*      */     
/*      */     private LinkedList<xbean.PetSkill> skilllist;
/*      */     
/*      */     private int isbinded;
/*      */     
/*      */     private int yaoli;
/*      */     
/*      */     private long marketbuytime;
/*      */     
/*      */     private int lianguitemusenum;
/*      */     
/*      */     private int growitemusenum;
/*      */     
/*      */     private int fanshengunbianyinum;
/*      */     
/*      */     private int stagelevel;
/*      */     
/*      */     private long changeyaolitime;
/*      */     
/*      */     private int extramodelcfgid;
/*      */     
/*      */     private xbean.PetSoulBag soulbag;
/*      */     
/*      */     private ArrayList<Integer> ownextramodelcfgids;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 2259 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 2264 */       this.petname = "";
/* 2265 */       this.basicproperty = new HashMap();
/* 2266 */       this.autospecialpointcase = new HashMap();
/* 2267 */       this.aptitude = new Aptitude.Data();
/* 2268 */       this.equipbag = new PetEquipBag.Data();
/* 2269 */       this.skilllist = new LinkedList();
/* 2270 */       this.marketbuytime = 0L;
/* 2271 */       this.lianguitemusenum = 0;
/* 2272 */       this.growitemusenum = 0;
/* 2273 */       this.extramodelcfgid = 0;
/* 2274 */       this.soulbag = new PetSoulBag.Data();
/* 2275 */       this.ownextramodelcfgids = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.Pet _o1_)
/*      */     {
/* 2280 */       if ((_o1_ instanceof Pet)) { assign((Pet)_o1_);
/* 2281 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 2282 */       } else if ((_o1_ instanceof Pet.Const)) assign(((Pet.Const)_o1_).nThis()); else {
/* 2283 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Pet _o_) {
/* 2288 */       this.id = _o_.id;
/* 2289 */       this.templateid = _o_.templateid;
/* 2290 */       this.petname = _o_.petname;
/* 2291 */       this.level = _o_.level;
/* 2292 */       this.hp = _o_.hp;
/* 2293 */       this.mp = _o_.mp;
/* 2294 */       this.exp = _o_.exp;
/* 2295 */       this.life = _o_.life;
/* 2296 */       this.basicproperty = new HashMap();
/* 2297 */       for (Map.Entry<Integer, Integer> _e_ : _o_.basicproperty.entrySet())
/* 2298 */         this.basicproperty.put(_e_.getKey(), _e_.getValue());
/* 2299 */       this.isautospecialpoint = _o_.isautospecialpoint;
/* 2300 */       this.autospecialpointcase = new HashMap();
/* 2301 */       for (Map.Entry<Integer, Integer> _e_ : _o_.autospecialpointcase.entrySet())
/* 2302 */         this.autospecialpointcase.put(_e_.getKey(), _e_.getValue());
/* 2303 */       this.potentialpoint = _o_.potentialpoint;
/* 2304 */       this.aptitude = new Aptitude.Data(_o_.aptitude);
/* 2305 */       this.grow = _o_.grow;
/* 2306 */       this.rememberskillid = _o_.rememberskillid;
/* 2307 */       this.equipbag = new PetEquipBag.Data(_o_.equipbag);
/* 2308 */       this.skilllist = new LinkedList();
/* 2309 */       for (xbean.PetSkill _v_ : _o_.skilllist)
/* 2310 */         this.skilllist.add(new PetSkill.Data(_v_));
/* 2311 */       this.isbinded = _o_.isbinded;
/* 2312 */       this.yaoli = _o_.yaoli;
/* 2313 */       this.marketbuytime = _o_.marketbuytime;
/* 2314 */       this.lianguitemusenum = _o_.lianguitemusenum;
/* 2315 */       this.growitemusenum = _o_.growitemusenum;
/* 2316 */       this.fanshengunbianyinum = _o_.fanshengunbianyinum;
/* 2317 */       this.stagelevel = _o_.stagelevel;
/* 2318 */       this.changeyaolitime = _o_.changeyaolitime;
/* 2319 */       this.extramodelcfgid = _o_.extramodelcfgid;
/* 2320 */       this.soulbag = new PetSoulBag.Data(_o_.soulbag);
/* 2321 */       this.ownextramodelcfgids = new ArrayList();
/* 2322 */       this.ownextramodelcfgids.addAll(_o_.ownextramodelcfgids);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 2327 */       this.id = _o_.id;
/* 2328 */       this.templateid = _o_.templateid;
/* 2329 */       this.petname = _o_.petname;
/* 2330 */       this.level = _o_.level;
/* 2331 */       this.hp = _o_.hp;
/* 2332 */       this.mp = _o_.mp;
/* 2333 */       this.exp = _o_.exp;
/* 2334 */       this.life = _o_.life;
/* 2335 */       this.basicproperty = new HashMap();
/* 2336 */       for (Map.Entry<Integer, Integer> _e_ : _o_.basicproperty.entrySet())
/* 2337 */         this.basicproperty.put(_e_.getKey(), _e_.getValue());
/* 2338 */       this.isautospecialpoint = _o_.isautospecialpoint;
/* 2339 */       this.autospecialpointcase = new HashMap();
/* 2340 */       for (Map.Entry<Integer, Integer> _e_ : _o_.autospecialpointcase.entrySet())
/* 2341 */         this.autospecialpointcase.put(_e_.getKey(), _e_.getValue());
/* 2342 */       this.potentialpoint = _o_.potentialpoint;
/* 2343 */       this.aptitude = new Aptitude.Data(_o_.aptitude);
/* 2344 */       this.grow = _o_.grow;
/* 2345 */       this.rememberskillid = _o_.rememberskillid;
/* 2346 */       this.equipbag = new PetEquipBag.Data(_o_.equipbag);
/* 2347 */       this.skilllist = new LinkedList();
/* 2348 */       for (xbean.PetSkill _v_ : _o_.skilllist)
/* 2349 */         this.skilllist.add(new PetSkill.Data(_v_));
/* 2350 */       this.isbinded = _o_.isbinded;
/* 2351 */       this.yaoli = _o_.yaoli;
/* 2352 */       this.marketbuytime = _o_.marketbuytime;
/* 2353 */       this.lianguitemusenum = _o_.lianguitemusenum;
/* 2354 */       this.growitemusenum = _o_.growitemusenum;
/* 2355 */       this.fanshengunbianyinum = _o_.fanshengunbianyinum;
/* 2356 */       this.stagelevel = _o_.stagelevel;
/* 2357 */       this.changeyaolitime = _o_.changeyaolitime;
/* 2358 */       this.extramodelcfgid = _o_.extramodelcfgid;
/* 2359 */       this.soulbag = new PetSoulBag.Data(_o_.soulbag);
/* 2360 */       this.ownextramodelcfgids = new ArrayList();
/* 2361 */       this.ownextramodelcfgids.addAll(_o_.ownextramodelcfgids);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2367 */       _os_.marshal(this.id);
/* 2368 */       _os_.marshal(this.templateid);
/* 2369 */       _os_.marshal(this.petname, "UTF-16LE");
/* 2370 */       _os_.marshal(this.level);
/* 2371 */       _os_.marshal(this.hp);
/* 2372 */       _os_.marshal(this.mp);
/* 2373 */       _os_.marshal(this.exp);
/* 2374 */       _os_.marshal(this.life);
/* 2375 */       _os_.compact_uint32(this.basicproperty.size());
/* 2376 */       for (Map.Entry<Integer, Integer> _e_ : this.basicproperty.entrySet())
/*      */       {
/* 2378 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2379 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2381 */       _os_.marshal(this.isautospecialpoint);
/* 2382 */       _os_.compact_uint32(this.autospecialpointcase.size());
/* 2383 */       for (Map.Entry<Integer, Integer> _e_ : this.autospecialpointcase.entrySet())
/*      */       {
/* 2385 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2386 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2388 */       _os_.marshal(this.potentialpoint);
/* 2389 */       this.aptitude.marshal(_os_);
/* 2390 */       _os_.marshal(this.grow);
/* 2391 */       _os_.marshal(this.rememberskillid);
/* 2392 */       this.equipbag.marshal(_os_);
/* 2393 */       _os_.compact_uint32(this.skilllist.size());
/* 2394 */       for (xbean.PetSkill _v_ : this.skilllist)
/*      */       {
/* 2396 */         _v_.marshal(_os_);
/*      */       }
/* 2398 */       _os_.marshal(this.isbinded);
/* 2399 */       _os_.marshal(this.yaoli);
/* 2400 */       _os_.marshal(this.marketbuytime);
/* 2401 */       _os_.marshal(this.lianguitemusenum);
/* 2402 */       _os_.marshal(this.growitemusenum);
/* 2403 */       _os_.marshal(this.fanshengunbianyinum);
/* 2404 */       _os_.marshal(this.stagelevel);
/* 2405 */       _os_.marshal(this.changeyaolitime);
/* 2406 */       _os_.marshal(this.extramodelcfgid);
/* 2407 */       this.soulbag.marshal(_os_);
/* 2408 */       _os_.compact_uint32(this.ownextramodelcfgids.size());
/* 2409 */       for (Integer _v_ : this.ownextramodelcfgids)
/*      */       {
/* 2411 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 2413 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2419 */       this.id = _os_.unmarshal_long();
/* 2420 */       this.templateid = _os_.unmarshal_int();
/* 2421 */       this.petname = _os_.unmarshal_String("UTF-16LE");
/* 2422 */       this.level = _os_.unmarshal_int();
/* 2423 */       this.hp = _os_.unmarshal_int();
/* 2424 */       this.mp = _os_.unmarshal_int();
/* 2425 */       this.exp = _os_.unmarshal_int();
/* 2426 */       this.life = _os_.unmarshal_int();
/*      */       
/* 2428 */       int size = _os_.uncompact_uint32();
/* 2429 */       if (size >= 12)
/*      */       {
/* 2431 */         this.basicproperty = new HashMap(size * 2);
/*      */       }
/* 2433 */       for (; size > 0; size--)
/*      */       {
/* 2435 */         int _k_ = 0;
/* 2436 */         _k_ = _os_.unmarshal_int();
/* 2437 */         int _v_ = 0;
/* 2438 */         _v_ = _os_.unmarshal_int();
/* 2439 */         this.basicproperty.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 2442 */       this.isautospecialpoint = _os_.unmarshal_boolean();
/*      */       
/* 2444 */       int size = _os_.uncompact_uint32();
/* 2445 */       if (size >= 12)
/*      */       {
/* 2447 */         this.autospecialpointcase = new HashMap(size * 2);
/*      */       }
/* 2449 */       for (; size > 0; size--)
/*      */       {
/* 2451 */         int _k_ = 0;
/* 2452 */         _k_ = _os_.unmarshal_int();
/* 2453 */         int _v_ = 0;
/* 2454 */         _v_ = _os_.unmarshal_int();
/* 2455 */         this.autospecialpointcase.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 2458 */       this.potentialpoint = _os_.unmarshal_int();
/* 2459 */       this.aptitude.unmarshal(_os_);
/* 2460 */       this.grow = _os_.unmarshal_float();
/* 2461 */       this.rememberskillid = _os_.unmarshal_int();
/* 2462 */       this.equipbag.unmarshal(_os_);
/* 2463 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 2465 */         xbean.PetSkill _v_ = Pod.newPetSkillData();
/* 2466 */         _v_.unmarshal(_os_);
/* 2467 */         this.skilllist.add(_v_);
/*      */       }
/* 2469 */       this.isbinded = _os_.unmarshal_int();
/* 2470 */       this.yaoli = _os_.unmarshal_int();
/* 2471 */       this.marketbuytime = _os_.unmarshal_long();
/* 2472 */       this.lianguitemusenum = _os_.unmarshal_int();
/* 2473 */       this.growitemusenum = _os_.unmarshal_int();
/* 2474 */       this.fanshengunbianyinum = _os_.unmarshal_int();
/* 2475 */       this.stagelevel = _os_.unmarshal_int();
/* 2476 */       this.changeyaolitime = _os_.unmarshal_long();
/* 2477 */       this.extramodelcfgid = _os_.unmarshal_int();
/* 2478 */       this.soulbag.unmarshal(_os_);
/* 2479 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 2481 */         int _v_ = 0;
/* 2482 */         _v_ = _os_.unmarshal_int();
/* 2483 */         this.ownextramodelcfgids.add(Integer.valueOf(_v_));
/*      */       }
/* 2485 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 2491 */       int _size_ = 0;
/* 2492 */       _size_ += CodedOutputStream.computeInt64Size(1, this.id);
/* 2493 */       _size_ += CodedOutputStream.computeInt32Size(2, this.templateid);
/*      */       try
/*      */       {
/* 2496 */         _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.petname, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2500 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 2502 */       _size_ += CodedOutputStream.computeInt32Size(4, this.level);
/* 2503 */       _size_ += CodedOutputStream.computeInt32Size(5, this.hp);
/* 2504 */       _size_ += CodedOutputStream.computeInt32Size(6, this.mp);
/* 2505 */       _size_ += CodedOutputStream.computeInt32Size(7, this.exp);
/* 2506 */       _size_ += CodedOutputStream.computeInt32Size(8, this.life);
/* 2507 */       for (Map.Entry<Integer, Integer> _e_ : this.basicproperty.entrySet())
/*      */       {
/* 2509 */         _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getKey()).intValue());
/* 2510 */         _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2512 */       _size_ += CodedOutputStream.computeBoolSize(10, this.isautospecialpoint);
/* 2513 */       for (Map.Entry<Integer, Integer> _e_ : this.autospecialpointcase.entrySet())
/*      */       {
/* 2515 */         _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getKey()).intValue());
/* 2516 */         _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 2518 */       _size_ += CodedOutputStream.computeInt32Size(12, this.potentialpoint);
/* 2519 */       _size_ += CodedOutputStream.computeMessageSize(13, this.aptitude);
/* 2520 */       _size_ += CodedOutputStream.computeFloatSize(14, this.grow);
/* 2521 */       _size_ += CodedOutputStream.computeInt32Size(15, this.rememberskillid);
/* 2522 */       _size_ += CodedOutputStream.computeMessageSize(16, this.equipbag);
/* 2523 */       for (xbean.PetSkill _v_ : this.skilllist)
/*      */       {
/* 2525 */         _size_ += CodedOutputStream.computeMessageSize(17, _v_);
/*      */       }
/* 2527 */       _size_ += CodedOutputStream.computeInt32Size(18, this.isbinded);
/* 2528 */       _size_ += CodedOutputStream.computeInt32Size(19, this.yaoli);
/* 2529 */       _size_ += CodedOutputStream.computeInt64Size(20, this.marketbuytime);
/* 2530 */       _size_ += CodedOutputStream.computeInt32Size(21, this.lianguitemusenum);
/* 2531 */       _size_ += CodedOutputStream.computeInt32Size(22, this.growitemusenum);
/* 2532 */       _size_ += CodedOutputStream.computeInt32Size(23, this.fanshengunbianyinum);
/* 2533 */       _size_ += CodedOutputStream.computeInt32Size(24, this.stagelevel);
/* 2534 */       _size_ += CodedOutputStream.computeInt64Size(25, this.changeyaolitime);
/* 2535 */       _size_ += CodedOutputStream.computeInt32Size(26, this.extramodelcfgid);
/* 2536 */       _size_ += CodedOutputStream.computeMessageSize(27, this.soulbag);
/* 2537 */       for (Integer _v_ : this.ownextramodelcfgids)
/*      */       {
/* 2539 */         _size_ += CodedOutputStream.computeInt32Size(28, _v_.intValue());
/*      */       }
/* 2541 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2549 */         _output_.writeInt64(1, this.id);
/* 2550 */         _output_.writeInt32(2, this.templateid);
/* 2551 */         _output_.writeBytes(3, ByteString.copyFrom(this.petname, "UTF-16LE"));
/* 2552 */         _output_.writeInt32(4, this.level);
/* 2553 */         _output_.writeInt32(5, this.hp);
/* 2554 */         _output_.writeInt32(6, this.mp);
/* 2555 */         _output_.writeInt32(7, this.exp);
/* 2556 */         _output_.writeInt32(8, this.life);
/* 2557 */         for (Map.Entry<Integer, Integer> _e_ : this.basicproperty.entrySet())
/*      */         {
/* 2559 */           _output_.writeInt32(9, ((Integer)_e_.getKey()).intValue());
/* 2560 */           _output_.writeInt32(9, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2562 */         _output_.writeBool(10, this.isautospecialpoint);
/* 2563 */         for (Map.Entry<Integer, Integer> _e_ : this.autospecialpointcase.entrySet())
/*      */         {
/* 2565 */           _output_.writeInt32(11, ((Integer)_e_.getKey()).intValue());
/* 2566 */           _output_.writeInt32(11, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 2568 */         _output_.writeInt32(12, this.potentialpoint);
/* 2569 */         _output_.writeMessage(13, this.aptitude);
/* 2570 */         _output_.writeFloat(14, this.grow);
/* 2571 */         _output_.writeInt32(15, this.rememberskillid);
/* 2572 */         _output_.writeMessage(16, this.equipbag);
/* 2573 */         for (xbean.PetSkill _v_ : this.skilllist)
/*      */         {
/* 2575 */           _output_.writeMessage(17, _v_);
/*      */         }
/* 2577 */         _output_.writeInt32(18, this.isbinded);
/* 2578 */         _output_.writeInt32(19, this.yaoli);
/* 2579 */         _output_.writeInt64(20, this.marketbuytime);
/* 2580 */         _output_.writeInt32(21, this.lianguitemusenum);
/* 2581 */         _output_.writeInt32(22, this.growitemusenum);
/* 2582 */         _output_.writeInt32(23, this.fanshengunbianyinum);
/* 2583 */         _output_.writeInt32(24, this.stagelevel);
/* 2584 */         _output_.writeInt64(25, this.changeyaolitime);
/* 2585 */         _output_.writeInt32(26, this.extramodelcfgid);
/* 2586 */         _output_.writeMessage(27, this.soulbag);
/* 2587 */         for (Integer _v_ : this.ownextramodelcfgids)
/*      */         {
/* 2589 */           _output_.writeInt32(28, _v_.intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2594 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2596 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2604 */         boolean done = false;
/* 2605 */         while (!done)
/*      */         {
/* 2607 */           int tag = _input_.readTag();
/* 2608 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 2612 */             done = true;
/* 2613 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 2617 */             this.id = _input_.readInt64();
/* 2618 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 2622 */             this.templateid = _input_.readInt32();
/* 2623 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/* 2627 */             this.petname = _input_.readBytes().toString("UTF-16LE");
/* 2628 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 2632 */             this.level = _input_.readInt32();
/* 2633 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 2637 */             this.hp = _input_.readInt32();
/* 2638 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 2642 */             this.mp = _input_.readInt32();
/* 2643 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 2647 */             this.exp = _input_.readInt32();
/* 2648 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 2652 */             this.life = _input_.readInt32();
/* 2653 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 2657 */             int _k_ = 0;
/* 2658 */             _k_ = _input_.readInt32();
/* 2659 */             int readTag = _input_.readTag();
/* 2660 */             if (72 != readTag)
/*      */             {
/* 2662 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2664 */             int _v_ = 0;
/* 2665 */             _v_ = _input_.readInt32();
/* 2666 */             this.basicproperty.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2667 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 2671 */             this.isautospecialpoint = _input_.readBool();
/* 2672 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 2676 */             int _k_ = 0;
/* 2677 */             _k_ = _input_.readInt32();
/* 2678 */             int readTag = _input_.readTag();
/* 2679 */             if (88 != readTag)
/*      */             {
/* 2681 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2683 */             int _v_ = 0;
/* 2684 */             _v_ = _input_.readInt32();
/* 2685 */             this.autospecialpointcase.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 2686 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 2690 */             this.potentialpoint = _input_.readInt32();
/* 2691 */             break;
/*      */           
/*      */ 
/*      */           case 106: 
/* 2695 */             _input_.readMessage(this.aptitude);
/* 2696 */             break;
/*      */           
/*      */ 
/*      */           case 117: 
/* 2700 */             this.grow = _input_.readFloat();
/* 2701 */             break;
/*      */           
/*      */ 
/*      */           case 120: 
/* 2705 */             this.rememberskillid = _input_.readInt32();
/* 2706 */             break;
/*      */           
/*      */ 
/*      */           case 130: 
/* 2710 */             _input_.readMessage(this.equipbag);
/* 2711 */             break;
/*      */           
/*      */ 
/*      */           case 138: 
/* 2715 */             xbean.PetSkill _v_ = Pod.newPetSkillData();
/* 2716 */             _input_.readMessage(_v_);
/* 2717 */             this.skilllist.add(_v_);
/* 2718 */             break;
/*      */           
/*      */ 
/*      */           case 144: 
/* 2722 */             this.isbinded = _input_.readInt32();
/* 2723 */             break;
/*      */           
/*      */ 
/*      */           case 152: 
/* 2727 */             this.yaoli = _input_.readInt32();
/* 2728 */             break;
/*      */           
/*      */ 
/*      */           case 160: 
/* 2732 */             this.marketbuytime = _input_.readInt64();
/* 2733 */             break;
/*      */           
/*      */ 
/*      */           case 168: 
/* 2737 */             this.lianguitemusenum = _input_.readInt32();
/* 2738 */             break;
/*      */           
/*      */ 
/*      */           case 176: 
/* 2742 */             this.growitemusenum = _input_.readInt32();
/* 2743 */             break;
/*      */           
/*      */ 
/*      */           case 184: 
/* 2747 */             this.fanshengunbianyinum = _input_.readInt32();
/* 2748 */             break;
/*      */           
/*      */ 
/*      */           case 192: 
/* 2752 */             this.stagelevel = _input_.readInt32();
/* 2753 */             break;
/*      */           
/*      */ 
/*      */           case 200: 
/* 2757 */             this.changeyaolitime = _input_.readInt64();
/* 2758 */             break;
/*      */           
/*      */ 
/*      */           case 208: 
/* 2762 */             this.extramodelcfgid = _input_.readInt32();
/* 2763 */             break;
/*      */           
/*      */ 
/*      */           case 218: 
/* 2767 */             _input_.readMessage(this.soulbag);
/* 2768 */             break;
/*      */           
/*      */ 
/*      */           case 224: 
/* 2772 */             int _v_ = 0;
/* 2773 */             _v_ = _input_.readInt32();
/* 2774 */             this.ownextramodelcfgids.add(Integer.valueOf(_v_));
/* 2775 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 2779 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 2781 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 2790 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2794 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2796 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Pet copy()
/*      */     {
/* 2802 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Pet toData()
/*      */     {
/* 2808 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Pet toBean()
/*      */     {
/* 2813 */       return new Pet(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Pet toDataIf()
/*      */     {
/* 2819 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Pet toBeanIf()
/*      */     {
/* 2824 */       return new Pet(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2830 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 2834 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 2838 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 2842 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 2846 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 2850 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 2854 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getId()
/*      */     {
/* 2861 */       return this.id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTemplateid()
/*      */     {
/* 2868 */       return this.templateid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getPetname()
/*      */     {
/* 2875 */       return this.petname;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getPetnameOctets()
/*      */     {
/* 2882 */       return Octets.wrap(getPetname(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/* 2889 */       return this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHp()
/*      */     {
/* 2896 */       return this.hp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMp()
/*      */     {
/* 2903 */       return this.mp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExp()
/*      */     {
/* 2910 */       return this.exp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLife()
/*      */     {
/* 2917 */       return this.life;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasicproperty()
/*      */     {
/* 2924 */       return this.basicproperty;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasicpropertyAsData()
/*      */     {
/* 2931 */       return this.basicproperty;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsautospecialpoint()
/*      */     {
/* 2938 */       return this.isautospecialpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAutospecialpointcase()
/*      */     {
/* 2945 */       return this.autospecialpointcase;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAutospecialpointcaseAsData()
/*      */     {
/* 2952 */       return this.autospecialpointcase;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPotentialpoint()
/*      */     {
/* 2959 */       return this.potentialpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.Aptitude getAptitude()
/*      */     {
/* 2966 */       return this.aptitude;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getGrow()
/*      */     {
/* 2973 */       return this.grow;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRememberskillid()
/*      */     {
/* 2980 */       return this.rememberskillid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.PetEquipBag getEquipbag()
/*      */     {
/* 2987 */       return this.equipbag;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetSkill> getSkilllist()
/*      */     {
/* 2994 */       return this.skilllist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PetSkill> getSkilllistAsData()
/*      */     {
/* 3001 */       return this.skilllist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIsbinded()
/*      */     {
/* 3008 */       return this.isbinded;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getYaoli()
/*      */     {
/* 3015 */       return this.yaoli;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMarketbuytime()
/*      */     {
/* 3022 */       return this.marketbuytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLianguitemusenum()
/*      */     {
/* 3029 */       return this.lianguitemusenum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGrowitemusenum()
/*      */     {
/* 3036 */       return this.growitemusenum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFanshengunbianyinum()
/*      */     {
/* 3043 */       return this.fanshengunbianyinum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStagelevel()
/*      */     {
/* 3050 */       return this.stagelevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getChangeyaolitime()
/*      */     {
/* 3057 */       return this.changeyaolitime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExtramodelcfgid()
/*      */     {
/* 3064 */       return this.extramodelcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.PetSoulBag getSoulbag()
/*      */     {
/* 3071 */       return this.soulbag;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getOwnextramodelcfgids()
/*      */     {
/* 3078 */       return this.ownextramodelcfgids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getOwnextramodelcfgidsAsData()
/*      */     {
/* 3085 */       return this.ownextramodelcfgids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setId(long _v_)
/*      */     {
/* 3092 */       this.id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTemplateid(int _v_)
/*      */     {
/* 3099 */       this.templateid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPetname(String _v_)
/*      */     {
/* 3106 */       if (null == _v_)
/* 3107 */         throw new NullPointerException();
/* 3108 */       this.petname = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPetnameOctets(Octets _v_)
/*      */     {
/* 3115 */       setPetname(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 3122 */       this.level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHp(int _v_)
/*      */     {
/* 3129 */       this.hp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMp(int _v_)
/*      */     {
/* 3136 */       this.mp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExp(int _v_)
/*      */     {
/* 3143 */       this.exp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLife(int _v_)
/*      */     {
/* 3150 */       this.life = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsautospecialpoint(boolean _v_)
/*      */     {
/* 3157 */       this.isautospecialpoint = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPotentialpoint(int _v_)
/*      */     {
/* 3164 */       this.potentialpoint = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrow(float _v_)
/*      */     {
/* 3171 */       this.grow = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRememberskillid(int _v_)
/*      */     {
/* 3178 */       this.rememberskillid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsbinded(int _v_)
/*      */     {
/* 3185 */       this.isbinded = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setYaoli(int _v_)
/*      */     {
/* 3192 */       this.yaoli = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMarketbuytime(long _v_)
/*      */     {
/* 3199 */       this.marketbuytime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLianguitemusenum(int _v_)
/*      */     {
/* 3206 */       this.lianguitemusenum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrowitemusenum(int _v_)
/*      */     {
/* 3213 */       this.growitemusenum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFanshengunbianyinum(int _v_)
/*      */     {
/* 3220 */       this.fanshengunbianyinum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStagelevel(int _v_)
/*      */     {
/* 3227 */       this.stagelevel = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChangeyaolitime(long _v_)
/*      */     {
/* 3234 */       this.changeyaolitime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExtramodelcfgid(int _v_)
/*      */     {
/* 3241 */       this.extramodelcfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 3247 */       if (!(_o1_ instanceof Data)) return false;
/* 3248 */       Data _o_ = (Data)_o1_;
/* 3249 */       if (this.id != _o_.id) return false;
/* 3250 */       if (this.templateid != _o_.templateid) return false;
/* 3251 */       if (!this.petname.equals(_o_.petname)) return false;
/* 3252 */       if (this.level != _o_.level) return false;
/* 3253 */       if (this.hp != _o_.hp) return false;
/* 3254 */       if (this.mp != _o_.mp) return false;
/* 3255 */       if (this.exp != _o_.exp) return false;
/* 3256 */       if (this.life != _o_.life) return false;
/* 3257 */       if (!this.basicproperty.equals(_o_.basicproperty)) return false;
/* 3258 */       if (this.isautospecialpoint != _o_.isautospecialpoint) return false;
/* 3259 */       if (!this.autospecialpointcase.equals(_o_.autospecialpointcase)) return false;
/* 3260 */       if (this.potentialpoint != _o_.potentialpoint) return false;
/* 3261 */       if (!this.aptitude.equals(_o_.aptitude)) return false;
/* 3262 */       if (this.grow != _o_.grow) return false;
/* 3263 */       if (this.rememberskillid != _o_.rememberskillid) return false;
/* 3264 */       if (!this.equipbag.equals(_o_.equipbag)) return false;
/* 3265 */       if (!this.skilllist.equals(_o_.skilllist)) return false;
/* 3266 */       if (this.isbinded != _o_.isbinded) return false;
/* 3267 */       if (this.yaoli != _o_.yaoli) return false;
/* 3268 */       if (this.marketbuytime != _o_.marketbuytime) return false;
/* 3269 */       if (this.lianguitemusenum != _o_.lianguitemusenum) return false;
/* 3270 */       if (this.growitemusenum != _o_.growitemusenum) return false;
/* 3271 */       if (this.fanshengunbianyinum != _o_.fanshengunbianyinum) return false;
/* 3272 */       if (this.stagelevel != _o_.stagelevel) return false;
/* 3273 */       if (this.changeyaolitime != _o_.changeyaolitime) return false;
/* 3274 */       if (this.extramodelcfgid != _o_.extramodelcfgid) return false;
/* 3275 */       if (!this.soulbag.equals(_o_.soulbag)) return false;
/* 3276 */       if (!this.ownextramodelcfgids.equals(_o_.ownextramodelcfgids)) return false;
/* 3277 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 3283 */       int _h_ = 0;
/* 3284 */       _h_ = (int)(_h_ + this.id);
/* 3285 */       _h_ += this.templateid;
/* 3286 */       _h_ += this.petname.hashCode();
/* 3287 */       _h_ += this.level;
/* 3288 */       _h_ += this.hp;
/* 3289 */       _h_ += this.mp;
/* 3290 */       _h_ += this.exp;
/* 3291 */       _h_ += this.life;
/* 3292 */       _h_ += this.basicproperty.hashCode();
/* 3293 */       _h_ += (this.isautospecialpoint ? 1231 : 1237);
/* 3294 */       _h_ += this.autospecialpointcase.hashCode();
/* 3295 */       _h_ += this.potentialpoint;
/* 3296 */       _h_ += this.aptitude.hashCode();
/* 3297 */       _h_ = (int)(_h_ + this.grow);
/* 3298 */       _h_ += this.rememberskillid;
/* 3299 */       _h_ += this.equipbag.hashCode();
/* 3300 */       _h_ += this.skilllist.hashCode();
/* 3301 */       _h_ += this.isbinded;
/* 3302 */       _h_ += this.yaoli;
/* 3303 */       _h_ = (int)(_h_ + this.marketbuytime);
/* 3304 */       _h_ += this.lianguitemusenum;
/* 3305 */       _h_ += this.growitemusenum;
/* 3306 */       _h_ += this.fanshengunbianyinum;
/* 3307 */       _h_ += this.stagelevel;
/* 3308 */       _h_ = (int)(_h_ + this.changeyaolitime);
/* 3309 */       _h_ += this.extramodelcfgid;
/* 3310 */       _h_ += this.soulbag.hashCode();
/* 3311 */       _h_ += this.ownextramodelcfgids.hashCode();
/* 3312 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 3318 */       StringBuilder _sb_ = new StringBuilder();
/* 3319 */       _sb_.append("(");
/* 3320 */       _sb_.append(this.id);
/* 3321 */       _sb_.append(",");
/* 3322 */       _sb_.append(this.templateid);
/* 3323 */       _sb_.append(",");
/* 3324 */       _sb_.append("'").append(this.petname).append("'");
/* 3325 */       _sb_.append(",");
/* 3326 */       _sb_.append(this.level);
/* 3327 */       _sb_.append(",");
/* 3328 */       _sb_.append(this.hp);
/* 3329 */       _sb_.append(",");
/* 3330 */       _sb_.append(this.mp);
/* 3331 */       _sb_.append(",");
/* 3332 */       _sb_.append(this.exp);
/* 3333 */       _sb_.append(",");
/* 3334 */       _sb_.append(this.life);
/* 3335 */       _sb_.append(",");
/* 3336 */       _sb_.append(this.basicproperty);
/* 3337 */       _sb_.append(",");
/* 3338 */       _sb_.append(this.isautospecialpoint);
/* 3339 */       _sb_.append(",");
/* 3340 */       _sb_.append(this.autospecialpointcase);
/* 3341 */       _sb_.append(",");
/* 3342 */       _sb_.append(this.potentialpoint);
/* 3343 */       _sb_.append(",");
/* 3344 */       _sb_.append(this.aptitude);
/* 3345 */       _sb_.append(",");
/* 3346 */       _sb_.append(this.grow);
/* 3347 */       _sb_.append(",");
/* 3348 */       _sb_.append(this.rememberskillid);
/* 3349 */       _sb_.append(",");
/* 3350 */       _sb_.append(this.equipbag);
/* 3351 */       _sb_.append(",");
/* 3352 */       _sb_.append(this.skilllist);
/* 3353 */       _sb_.append(",");
/* 3354 */       _sb_.append(this.isbinded);
/* 3355 */       _sb_.append(",");
/* 3356 */       _sb_.append(this.yaoli);
/* 3357 */       _sb_.append(",");
/* 3358 */       _sb_.append(this.marketbuytime);
/* 3359 */       _sb_.append(",");
/* 3360 */       _sb_.append(this.lianguitemusenum);
/* 3361 */       _sb_.append(",");
/* 3362 */       _sb_.append(this.growitemusenum);
/* 3363 */       _sb_.append(",");
/* 3364 */       _sb_.append(this.fanshengunbianyinum);
/* 3365 */       _sb_.append(",");
/* 3366 */       _sb_.append(this.stagelevel);
/* 3367 */       _sb_.append(",");
/* 3368 */       _sb_.append(this.changeyaolitime);
/* 3369 */       _sb_.append(",");
/* 3370 */       _sb_.append(this.extramodelcfgid);
/* 3371 */       _sb_.append(",");
/* 3372 */       _sb_.append(this.soulbag);
/* 3373 */       _sb_.append(",");
/* 3374 */       _sb_.append(this.ownextramodelcfgids);
/* 3375 */       _sb_.append(")");
/* 3376 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Pet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */