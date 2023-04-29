/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableMap;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogString;
/*      */ 
/*      */ public final class PersonalInfo extends XBean implements xbean.PersonalInfo
/*      */ {
/*      */   private String sign;
/*      */   private int gender;
/*      */   private int age;
/*      */   private long birthday;
/*      */   private int animalsign;
/*      */   private int constellation;
/*      */   private int bloodtype;
/*      */   private int occupation;
/*      */   private String school;
/*      */   private long location;
/*      */   private ArrayList<Integer> hobbies;
/*      */   private String headimage;
/*      */   private ArrayList<String> photos;
/*      */   private xbean.PraiseInfo praise;
/*      */   private HashMap<Integer, Long> refreshadvert;
/*      */   private HashMap<Integer, Long> adverts;
/*      */   private HashMap<Integer, Long> deletetimestamps;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   50 */     this.sign = "";
/*   51 */     this.gender = 0;
/*   52 */     this.age = 0;
/*   53 */     this.birthday = 0L;
/*   54 */     this.animalsign = 0;
/*   55 */     this.constellation = 0;
/*   56 */     this.bloodtype = 0;
/*   57 */     this.occupation = 0;
/*   58 */     this.school = "";
/*   59 */     this.location = 0L;
/*   60 */     this.hobbies.clear();
/*   61 */     this.headimage = "";
/*   62 */     this.photos.clear();
/*   63 */     this.praise._reset_unsafe_();
/*   64 */     this.refreshadvert.clear();
/*   65 */     this.adverts.clear();
/*   66 */     this.deletetimestamps.clear();
/*      */   }
/*      */   
/*      */   PersonalInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   71 */     super(_xp_, _vn_);
/*   72 */     this.sign = "";
/*   73 */     this.school = "";
/*   74 */     this.hobbies = new ArrayList();
/*   75 */     this.headimage = "";
/*   76 */     this.photos = new ArrayList();
/*   77 */     this.praise = new PraiseInfo(0, this, "praise");
/*   78 */     this.refreshadvert = new HashMap();
/*   79 */     this.adverts = new HashMap();
/*   80 */     this.deletetimestamps = new HashMap();
/*      */   }
/*      */   
/*      */   public PersonalInfo()
/*      */   {
/*   85 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public PersonalInfo(PersonalInfo _o_)
/*      */   {
/*   90 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   PersonalInfo(xbean.PersonalInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   95 */     super(_xp_, _vn_);
/*   96 */     if ((_o1_ instanceof PersonalInfo)) { assign((PersonalInfo)_o1_);
/*   97 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   98 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   99 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(PersonalInfo _o_) {
/*  104 */     _o_._xdb_verify_unsafe_();
/*  105 */     this.sign = _o_.sign;
/*  106 */     this.gender = _o_.gender;
/*  107 */     this.age = _o_.age;
/*  108 */     this.birthday = _o_.birthday;
/*  109 */     this.animalsign = _o_.animalsign;
/*  110 */     this.constellation = _o_.constellation;
/*  111 */     this.bloodtype = _o_.bloodtype;
/*  112 */     this.occupation = _o_.occupation;
/*  113 */     this.school = _o_.school;
/*  114 */     this.location = _o_.location;
/*  115 */     this.hobbies = new ArrayList();
/*  116 */     this.hobbies.addAll(_o_.hobbies);
/*  117 */     this.headimage = _o_.headimage;
/*  118 */     this.photos = new ArrayList();
/*  119 */     this.photos.addAll(_o_.photos);
/*  120 */     this.praise = new PraiseInfo(_o_.praise, this, "praise");
/*  121 */     this.refreshadvert = new HashMap();
/*  122 */     for (Map.Entry<Integer, Long> _e_ : _o_.refreshadvert.entrySet())
/*  123 */       this.refreshadvert.put(_e_.getKey(), _e_.getValue());
/*  124 */     this.adverts = new HashMap();
/*  125 */     for (Map.Entry<Integer, Long> _e_ : _o_.adverts.entrySet())
/*  126 */       this.adverts.put(_e_.getKey(), _e_.getValue());
/*  127 */     this.deletetimestamps = new HashMap();
/*  128 */     for (Map.Entry<Integer, Long> _e_ : _o_.deletetimestamps.entrySet()) {
/*  129 */       this.deletetimestamps.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*  134 */     this.sign = _o_.sign;
/*  135 */     this.gender = _o_.gender;
/*  136 */     this.age = _o_.age;
/*  137 */     this.birthday = _o_.birthday;
/*  138 */     this.animalsign = _o_.animalsign;
/*  139 */     this.constellation = _o_.constellation;
/*  140 */     this.bloodtype = _o_.bloodtype;
/*  141 */     this.occupation = _o_.occupation;
/*  142 */     this.school = _o_.school;
/*  143 */     this.location = _o_.location;
/*  144 */     this.hobbies = new ArrayList();
/*  145 */     this.hobbies.addAll(_o_.hobbies);
/*  146 */     this.headimage = _o_.headimage;
/*  147 */     this.photos = new ArrayList();
/*  148 */     this.photos.addAll(_o_.photos);
/*  149 */     this.praise = new PraiseInfo(_o_.praise, this, "praise");
/*  150 */     this.refreshadvert = new HashMap();
/*  151 */     for (Map.Entry<Integer, Long> _e_ : _o_.refreshadvert.entrySet())
/*  152 */       this.refreshadvert.put(_e_.getKey(), _e_.getValue());
/*  153 */     this.adverts = new HashMap();
/*  154 */     for (Map.Entry<Integer, Long> _e_ : _o_.adverts.entrySet())
/*  155 */       this.adverts.put(_e_.getKey(), _e_.getValue());
/*  156 */     this.deletetimestamps = new HashMap();
/*  157 */     for (Map.Entry<Integer, Long> _e_ : _o_.deletetimestamps.entrySet()) {
/*  158 */       this.deletetimestamps.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  164 */     _xdb_verify_unsafe_();
/*  165 */     _os_.marshal(this.sign, "UTF-16LE");
/*  166 */     _os_.marshal(this.gender);
/*  167 */     _os_.marshal(this.age);
/*  168 */     _os_.marshal(this.birthday);
/*  169 */     _os_.marshal(this.animalsign);
/*  170 */     _os_.marshal(this.constellation);
/*  171 */     _os_.marshal(this.bloodtype);
/*  172 */     _os_.marshal(this.occupation);
/*  173 */     _os_.marshal(this.school, "UTF-16LE");
/*  174 */     _os_.marshal(this.location);
/*  175 */     _os_.compact_uint32(this.hobbies.size());
/*  176 */     for (Integer _v_ : this.hobbies)
/*      */     {
/*  178 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  180 */     _os_.marshal(this.headimage, "UTF-16LE");
/*  181 */     _os_.compact_uint32(this.photos.size());
/*  182 */     for (String _v_ : this.photos)
/*      */     {
/*  184 */       _os_.marshal(_v_, "UTF-16LE");
/*      */     }
/*  186 */     this.praise.marshal(_os_);
/*  187 */     _os_.compact_uint32(this.refreshadvert.size());
/*  188 */     for (Map.Entry<Integer, Long> _e_ : this.refreshadvert.entrySet())
/*      */     {
/*  190 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  191 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*  193 */     _os_.compact_uint32(this.adverts.size());
/*  194 */     for (Map.Entry<Integer, Long> _e_ : this.adverts.entrySet())
/*      */     {
/*  196 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  197 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*  199 */     _os_.compact_uint32(this.deletetimestamps.size());
/*  200 */     for (Map.Entry<Integer, Long> _e_ : this.deletetimestamps.entrySet())
/*      */     {
/*  202 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  203 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*  205 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  211 */     _xdb_verify_unsafe_();
/*  212 */     this.sign = _os_.unmarshal_String("UTF-16LE");
/*  213 */     this.gender = _os_.unmarshal_int();
/*  214 */     this.age = _os_.unmarshal_int();
/*  215 */     this.birthday = _os_.unmarshal_long();
/*  216 */     this.animalsign = _os_.unmarshal_int();
/*  217 */     this.constellation = _os_.unmarshal_int();
/*  218 */     this.bloodtype = _os_.unmarshal_int();
/*  219 */     this.occupation = _os_.unmarshal_int();
/*  220 */     this.school = _os_.unmarshal_String("UTF-16LE");
/*  221 */     this.location = _os_.unmarshal_long();
/*  222 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  224 */       int _v_ = 0;
/*  225 */       _v_ = _os_.unmarshal_int();
/*  226 */       this.hobbies.add(Integer.valueOf(_v_));
/*      */     }
/*  228 */     this.headimage = _os_.unmarshal_String("UTF-16LE");
/*  229 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  231 */       String _v_ = "";
/*  232 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  233 */       this.photos.add(_v_);
/*      */     }
/*  235 */     this.praise.unmarshal(_os_);
/*      */     
/*  237 */     int size = _os_.uncompact_uint32();
/*  238 */     if (size >= 12)
/*      */     {
/*  240 */       this.refreshadvert = new HashMap(size * 2);
/*      */     }
/*  242 */     for (; size > 0; size--)
/*      */     {
/*  244 */       int _k_ = 0;
/*  245 */       _k_ = _os_.unmarshal_int();
/*  246 */       long _v_ = 0L;
/*  247 */       _v_ = _os_.unmarshal_long();
/*  248 */       this.refreshadvert.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  252 */     int size = _os_.uncompact_uint32();
/*  253 */     if (size >= 12)
/*      */     {
/*  255 */       this.adverts = new HashMap(size * 2);
/*      */     }
/*  257 */     for (; size > 0; size--)
/*      */     {
/*  259 */       int _k_ = 0;
/*  260 */       _k_ = _os_.unmarshal_int();
/*  261 */       long _v_ = 0L;
/*  262 */       _v_ = _os_.unmarshal_long();
/*  263 */       this.adverts.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  267 */     int size = _os_.uncompact_uint32();
/*  268 */     if (size >= 12)
/*      */     {
/*  270 */       this.deletetimestamps = new HashMap(size * 2);
/*      */     }
/*  272 */     for (; size > 0; size--)
/*      */     {
/*  274 */       int _k_ = 0;
/*  275 */       _k_ = _os_.unmarshal_int();
/*  276 */       long _v_ = 0L;
/*  277 */       _v_ = _os_.unmarshal_long();
/*  278 */       this.deletetimestamps.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*  281 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     int _size_ = 0;
/*      */     try
/*      */     {
/*  291 */       _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.sign, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  295 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  297 */     _size_ += CodedOutputStream.computeInt32Size(2, this.gender);
/*  298 */     _size_ += CodedOutputStream.computeInt32Size(3, this.age);
/*  299 */     _size_ += CodedOutputStream.computeInt64Size(4, this.birthday);
/*  300 */     _size_ += CodedOutputStream.computeInt32Size(5, this.animalsign);
/*  301 */     _size_ += CodedOutputStream.computeInt32Size(6, this.constellation);
/*  302 */     _size_ += CodedOutputStream.computeInt32Size(7, this.bloodtype);
/*  303 */     _size_ += CodedOutputStream.computeInt32Size(8, this.occupation);
/*      */     try
/*      */     {
/*  306 */       _size_ += CodedOutputStream.computeBytesSize(9, ByteString.copyFrom(this.school, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  310 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  312 */     _size_ += CodedOutputStream.computeInt64Size(10, this.location);
/*  313 */     for (Integer _v_ : this.hobbies)
/*      */     {
/*  315 */       _size_ += CodedOutputStream.computeInt32Size(11, _v_.intValue());
/*      */     }
/*      */     try
/*      */     {
/*  319 */       _size_ += CodedOutputStream.computeBytesSize(12, ByteString.copyFrom(this.headimage, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  323 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  325 */     for (String _v_ : this.photos)
/*      */     {
/*      */       try
/*      */       {
/*  329 */         _size_ += CodedOutputStream.computeBytesSize(13, ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/*  333 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */     }
/*  336 */     _size_ += CodedOutputStream.computeMessageSize(14, this.praise);
/*  337 */     for (Map.Entry<Integer, Long> _e_ : this.refreshadvert.entrySet())
/*      */     {
/*  339 */       _size_ += CodedOutputStream.computeInt32Size(16, ((Integer)_e_.getKey()).intValue());
/*  340 */       _size_ += CodedOutputStream.computeInt64Size(16, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  342 */     for (Map.Entry<Integer, Long> _e_ : this.adverts.entrySet())
/*      */     {
/*  344 */       _size_ += CodedOutputStream.computeInt32Size(17, ((Integer)_e_.getKey()).intValue());
/*  345 */       _size_ += CodedOutputStream.computeInt64Size(17, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  347 */     for (Map.Entry<Integer, Long> _e_ : this.deletetimestamps.entrySet())
/*      */     {
/*  349 */       _size_ += CodedOutputStream.computeInt32Size(18, ((Integer)_e_.getKey()).intValue());
/*  350 */       _size_ += CodedOutputStream.computeInt64Size(18, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  352 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  361 */       _output_.writeBytes(1, ByteString.copyFrom(this.sign, "UTF-16LE"));
/*  362 */       _output_.writeInt32(2, this.gender);
/*  363 */       _output_.writeInt32(3, this.age);
/*  364 */       _output_.writeInt64(4, this.birthday);
/*  365 */       _output_.writeInt32(5, this.animalsign);
/*  366 */       _output_.writeInt32(6, this.constellation);
/*  367 */       _output_.writeInt32(7, this.bloodtype);
/*  368 */       _output_.writeInt32(8, this.occupation);
/*  369 */       _output_.writeBytes(9, ByteString.copyFrom(this.school, "UTF-16LE"));
/*  370 */       _output_.writeInt64(10, this.location);
/*  371 */       for (Integer _v_ : this.hobbies)
/*      */       {
/*  373 */         _output_.writeInt32(11, _v_.intValue());
/*      */       }
/*  375 */       _output_.writeBytes(12, ByteString.copyFrom(this.headimage, "UTF-16LE"));
/*  376 */       for (String _v_ : this.photos)
/*      */       {
/*  378 */         _output_.writeBytes(13, ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */       }
/*  380 */       _output_.writeMessage(14, this.praise);
/*  381 */       for (Map.Entry<Integer, Long> _e_ : this.refreshadvert.entrySet())
/*      */       {
/*  383 */         _output_.writeInt32(16, ((Integer)_e_.getKey()).intValue());
/*  384 */         _output_.writeInt64(16, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  386 */       for (Map.Entry<Integer, Long> _e_ : this.adverts.entrySet())
/*      */       {
/*  388 */         _output_.writeInt32(17, ((Integer)_e_.getKey()).intValue());
/*  389 */         _output_.writeInt64(17, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  391 */       for (Map.Entry<Integer, Long> _e_ : this.deletetimestamps.entrySet())
/*      */       {
/*  393 */         _output_.writeInt32(18, ((Integer)_e_.getKey()).intValue());
/*  394 */         _output_.writeInt64(18, ((Long)_e_.getValue()).longValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  399 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  401 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  410 */       boolean done = false;
/*  411 */       while (!done)
/*      */       {
/*  413 */         int tag = _input_.readTag();
/*  414 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  418 */           done = true;
/*  419 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  423 */           this.sign = _input_.readBytes().toString("UTF-16LE");
/*  424 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  428 */           this.gender = _input_.readInt32();
/*  429 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  433 */           this.age = _input_.readInt32();
/*  434 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  438 */           this.birthday = _input_.readInt64();
/*  439 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  443 */           this.animalsign = _input_.readInt32();
/*  444 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  448 */           this.constellation = _input_.readInt32();
/*  449 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  453 */           this.bloodtype = _input_.readInt32();
/*  454 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  458 */           this.occupation = _input_.readInt32();
/*  459 */           break;
/*      */         
/*      */ 
/*      */         case 74: 
/*  463 */           this.school = _input_.readBytes().toString("UTF-16LE");
/*  464 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  468 */           this.location = _input_.readInt64();
/*  469 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  473 */           int _v_ = 0;
/*  474 */           _v_ = _input_.readInt32();
/*  475 */           this.hobbies.add(Integer.valueOf(_v_));
/*  476 */           break;
/*      */         
/*      */ 
/*      */         case 98: 
/*  480 */           this.headimage = _input_.readBytes().toString("UTF-16LE");
/*  481 */           break;
/*      */         
/*      */ 
/*      */         case 106: 
/*  485 */           String _v_ = "";
/*  486 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/*  487 */           this.photos.add(_v_);
/*  488 */           break;
/*      */         
/*      */ 
/*      */         case 114: 
/*  492 */           _input_.readMessage(this.praise);
/*  493 */           break;
/*      */         
/*      */ 
/*      */         case 128: 
/*  497 */           int _k_ = 0;
/*  498 */           _k_ = _input_.readInt32();
/*  499 */           int readTag = _input_.readTag();
/*  500 */           if (128 != readTag)
/*      */           {
/*  502 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  504 */           long _v_ = 0L;
/*  505 */           _v_ = _input_.readInt64();
/*  506 */           this.refreshadvert.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*  507 */           break;
/*      */         
/*      */ 
/*      */         case 136: 
/*  511 */           int _k_ = 0;
/*  512 */           _k_ = _input_.readInt32();
/*  513 */           int readTag = _input_.readTag();
/*  514 */           if (136 != readTag)
/*      */           {
/*  516 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  518 */           long _v_ = 0L;
/*  519 */           _v_ = _input_.readInt64();
/*  520 */           this.adverts.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*  521 */           break;
/*      */         
/*      */ 
/*      */         case 144: 
/*  525 */           int _k_ = 0;
/*  526 */           _k_ = _input_.readInt32();
/*  527 */           int readTag = _input_.readTag();
/*  528 */           if (144 != readTag)
/*      */           {
/*  530 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  532 */           long _v_ = 0L;
/*  533 */           _v_ = _input_.readInt64();
/*  534 */           this.deletetimestamps.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*  535 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  539 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  541 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  550 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  554 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  556 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PersonalInfo copy()
/*      */   {
/*  562 */     _xdb_verify_unsafe_();
/*  563 */     return new PersonalInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PersonalInfo toData()
/*      */   {
/*  569 */     _xdb_verify_unsafe_();
/*  570 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PersonalInfo toBean()
/*      */   {
/*  575 */     _xdb_verify_unsafe_();
/*  576 */     return new PersonalInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PersonalInfo toDataIf()
/*      */   {
/*  582 */     _xdb_verify_unsafe_();
/*  583 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PersonalInfo toBeanIf()
/*      */   {
/*  588 */     _xdb_verify_unsafe_();
/*  589 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  595 */     _xdb_verify_unsafe_();
/*  596 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getSign()
/*      */   {
/*  603 */     _xdb_verify_unsafe_();
/*  604 */     return this.sign;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getSignOctets()
/*      */   {
/*  611 */     _xdb_verify_unsafe_();
/*  612 */     return Octets.wrap(getSign(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGender()
/*      */   {
/*  619 */     _xdb_verify_unsafe_();
/*  620 */     return this.gender;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAge()
/*      */   {
/*  627 */     _xdb_verify_unsafe_();
/*  628 */     return this.age;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBirthday()
/*      */   {
/*  635 */     _xdb_verify_unsafe_();
/*  636 */     return this.birthday;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAnimalsign()
/*      */   {
/*  643 */     _xdb_verify_unsafe_();
/*  644 */     return this.animalsign;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getConstellation()
/*      */   {
/*  651 */     _xdb_verify_unsafe_();
/*  652 */     return this.constellation;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBloodtype()
/*      */   {
/*  659 */     _xdb_verify_unsafe_();
/*  660 */     return this.bloodtype;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOccupation()
/*      */   {
/*  667 */     _xdb_verify_unsafe_();
/*  668 */     return this.occupation;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getSchool()
/*      */   {
/*  675 */     _xdb_verify_unsafe_();
/*  676 */     return this.school;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getSchoolOctets()
/*      */   {
/*  683 */     _xdb_verify_unsafe_();
/*  684 */     return Octets.wrap(getSchool(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLocation()
/*      */   {
/*  691 */     _xdb_verify_unsafe_();
/*  692 */     return this.location;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getHobbies()
/*      */   {
/*  699 */     _xdb_verify_unsafe_();
/*  700 */     return Logs.logList(new LogKey(this, "hobbies"), this.hobbies);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getHobbiesAsData()
/*      */   {
/*  706 */     _xdb_verify_unsafe_();
/*      */     
/*  708 */     PersonalInfo _o_ = this;
/*  709 */     List<Integer> hobbies = new ArrayList();
/*  710 */     hobbies.addAll(_o_.hobbies);
/*  711 */     return hobbies;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getHeadimage()
/*      */   {
/*  718 */     _xdb_verify_unsafe_();
/*  719 */     return this.headimage;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getHeadimageOctets()
/*      */   {
/*  726 */     _xdb_verify_unsafe_();
/*  727 */     return Octets.wrap(getHeadimage(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<String> getPhotos()
/*      */   {
/*  734 */     _xdb_verify_unsafe_();
/*  735 */     return Logs.logList(new LogKey(this, "photos"), this.photos);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<String> getPhotosAsData()
/*      */   {
/*  741 */     _xdb_verify_unsafe_();
/*      */     
/*  743 */     PersonalInfo _o_ = this;
/*  744 */     List<String> photos = new ArrayList();
/*  745 */     photos.addAll(_o_.photos);
/*  746 */     return photos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.PraiseInfo getPraise()
/*      */   {
/*  753 */     _xdb_verify_unsafe_();
/*  754 */     return this.praise;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getRefreshadvert()
/*      */   {
/*  761 */     _xdb_verify_unsafe_();
/*  762 */     return Logs.logMap(new LogKey(this, "refreshadvert"), this.refreshadvert);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getRefreshadvertAsData()
/*      */   {
/*  769 */     _xdb_verify_unsafe_();
/*      */     
/*  771 */     PersonalInfo _o_ = this;
/*  772 */     Map<Integer, Long> refreshadvert = new HashMap();
/*  773 */     for (Map.Entry<Integer, Long> _e_ : _o_.refreshadvert.entrySet())
/*  774 */       refreshadvert.put(_e_.getKey(), _e_.getValue());
/*  775 */     return refreshadvert;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getAdverts()
/*      */   {
/*  782 */     _xdb_verify_unsafe_();
/*  783 */     return Logs.logMap(new LogKey(this, "adverts"), this.adverts);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getAdvertsAsData()
/*      */   {
/*  790 */     _xdb_verify_unsafe_();
/*      */     
/*  792 */     PersonalInfo _o_ = this;
/*  793 */     Map<Integer, Long> adverts = new HashMap();
/*  794 */     for (Map.Entry<Integer, Long> _e_ : _o_.adverts.entrySet())
/*  795 */       adverts.put(_e_.getKey(), _e_.getValue());
/*  796 */     return adverts;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getDeletetimestamps()
/*      */   {
/*  803 */     _xdb_verify_unsafe_();
/*  804 */     return Logs.logMap(new LogKey(this, "deletetimestamps"), this.deletetimestamps);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Long> getDeletetimestampsAsData()
/*      */   {
/*  811 */     _xdb_verify_unsafe_();
/*      */     
/*  813 */     PersonalInfo _o_ = this;
/*  814 */     Map<Integer, Long> deletetimestamps = new HashMap();
/*  815 */     for (Map.Entry<Integer, Long> _e_ : _o_.deletetimestamps.entrySet())
/*  816 */       deletetimestamps.put(_e_.getKey(), _e_.getValue());
/*  817 */     return deletetimestamps;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSign(String _v_)
/*      */   {
/*  824 */     _xdb_verify_unsafe_();
/*  825 */     if (null == _v_)
/*  826 */       throw new NullPointerException();
/*  827 */     Logs.logIf(new LogKey(this, "sign")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  831 */         new LogString(this, PersonalInfo.this.sign)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  835 */             PersonalInfo.this.sign = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  839 */     });
/*  840 */     this.sign = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSignOctets(Octets _v_)
/*      */   {
/*  847 */     _xdb_verify_unsafe_();
/*  848 */     setSign(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGender(int _v_)
/*      */   {
/*  855 */     _xdb_verify_unsafe_();
/*  856 */     Logs.logIf(new LogKey(this, "gender")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  860 */         new LogInt(this, PersonalInfo.this.gender)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  864 */             PersonalInfo.this.gender = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  868 */     });
/*  869 */     this.gender = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAge(int _v_)
/*      */   {
/*  876 */     _xdb_verify_unsafe_();
/*  877 */     Logs.logIf(new LogKey(this, "age")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  881 */         new LogInt(this, PersonalInfo.this.age)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  885 */             PersonalInfo.this.age = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  889 */     });
/*  890 */     this.age = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBirthday(long _v_)
/*      */   {
/*  897 */     _xdb_verify_unsafe_();
/*  898 */     Logs.logIf(new LogKey(this, "birthday")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  902 */         new xdb.logs.LogLong(this, PersonalInfo.this.birthday)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  906 */             PersonalInfo.this.birthday = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  910 */     });
/*  911 */     this.birthday = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAnimalsign(int _v_)
/*      */   {
/*  918 */     _xdb_verify_unsafe_();
/*  919 */     Logs.logIf(new LogKey(this, "animalsign")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  923 */         new LogInt(this, PersonalInfo.this.animalsign)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  927 */             PersonalInfo.this.animalsign = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  931 */     });
/*  932 */     this.animalsign = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setConstellation(int _v_)
/*      */   {
/*  939 */     _xdb_verify_unsafe_();
/*  940 */     Logs.logIf(new LogKey(this, "constellation")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  944 */         new LogInt(this, PersonalInfo.this.constellation)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  948 */             PersonalInfo.this.constellation = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  952 */     });
/*  953 */     this.constellation = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBloodtype(int _v_)
/*      */   {
/*  960 */     _xdb_verify_unsafe_();
/*  961 */     Logs.logIf(new LogKey(this, "bloodtype")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  965 */         new LogInt(this, PersonalInfo.this.bloodtype)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  969 */             PersonalInfo.this.bloodtype = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  973 */     });
/*  974 */     this.bloodtype = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOccupation(int _v_)
/*      */   {
/*  981 */     _xdb_verify_unsafe_();
/*  982 */     Logs.logIf(new LogKey(this, "occupation")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  986 */         new LogInt(this, PersonalInfo.this.occupation)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  990 */             PersonalInfo.this.occupation = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  994 */     });
/*  995 */     this.occupation = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSchool(String _v_)
/*      */   {
/* 1002 */     _xdb_verify_unsafe_();
/* 1003 */     if (null == _v_)
/* 1004 */       throw new NullPointerException();
/* 1005 */     Logs.logIf(new LogKey(this, "school")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1009 */         new LogString(this, PersonalInfo.this.school)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1013 */             PersonalInfo.this.school = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1017 */     });
/* 1018 */     this.school = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSchoolOctets(Octets _v_)
/*      */   {
/* 1025 */     _xdb_verify_unsafe_();
/* 1026 */     setSchool(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLocation(long _v_)
/*      */   {
/* 1033 */     _xdb_verify_unsafe_();
/* 1034 */     Logs.logIf(new LogKey(this, "location")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1038 */         new xdb.logs.LogLong(this, PersonalInfo.this.location)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1042 */             PersonalInfo.this.location = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1046 */     });
/* 1047 */     this.location = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHeadimage(String _v_)
/*      */   {
/* 1054 */     _xdb_verify_unsafe_();
/* 1055 */     if (null == _v_)
/* 1056 */       throw new NullPointerException();
/* 1057 */     Logs.logIf(new LogKey(this, "headimage")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1061 */         new LogString(this, PersonalInfo.this.headimage)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1065 */             PersonalInfo.this.headimage = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1069 */     });
/* 1070 */     this.headimage = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHeadimageOctets(Octets _v_)
/*      */   {
/* 1077 */     _xdb_verify_unsafe_();
/* 1078 */     setHeadimage(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/* 1084 */     _xdb_verify_unsafe_();
/* 1085 */     PersonalInfo _o_ = null;
/* 1086 */     if ((_o1_ instanceof PersonalInfo)) { _o_ = (PersonalInfo)_o1_;
/* 1087 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 1088 */       return false;
/* 1089 */     if (!this.sign.equals(_o_.sign)) return false;
/* 1090 */     if (this.gender != _o_.gender) return false;
/* 1091 */     if (this.age != _o_.age) return false;
/* 1092 */     if (this.birthday != _o_.birthday) return false;
/* 1093 */     if (this.animalsign != _o_.animalsign) return false;
/* 1094 */     if (this.constellation != _o_.constellation) return false;
/* 1095 */     if (this.bloodtype != _o_.bloodtype) return false;
/* 1096 */     if (this.occupation != _o_.occupation) return false;
/* 1097 */     if (!this.school.equals(_o_.school)) return false;
/* 1098 */     if (this.location != _o_.location) return false;
/* 1099 */     if (!this.hobbies.equals(_o_.hobbies)) return false;
/* 1100 */     if (!this.headimage.equals(_o_.headimage)) return false;
/* 1101 */     if (!this.photos.equals(_o_.photos)) return false;
/* 1102 */     if (!this.praise.equals(_o_.praise)) return false;
/* 1103 */     if (!this.refreshadvert.equals(_o_.refreshadvert)) return false;
/* 1104 */     if (!this.adverts.equals(_o_.adverts)) return false;
/* 1105 */     if (!this.deletetimestamps.equals(_o_.deletetimestamps)) return false;
/* 1106 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/* 1112 */     _xdb_verify_unsafe_();
/* 1113 */     int _h_ = 0;
/* 1114 */     _h_ += this.sign.hashCode();
/* 1115 */     _h_ += this.gender;
/* 1116 */     _h_ += this.age;
/* 1117 */     _h_ = (int)(_h_ + this.birthday);
/* 1118 */     _h_ += this.animalsign;
/* 1119 */     _h_ += this.constellation;
/* 1120 */     _h_ += this.bloodtype;
/* 1121 */     _h_ += this.occupation;
/* 1122 */     _h_ += this.school.hashCode();
/* 1123 */     _h_ = (int)(_h_ + this.location);
/* 1124 */     _h_ += this.hobbies.hashCode();
/* 1125 */     _h_ += this.headimage.hashCode();
/* 1126 */     _h_ += this.photos.hashCode();
/* 1127 */     _h_ += this.praise.hashCode();
/* 1128 */     _h_ += this.refreshadvert.hashCode();
/* 1129 */     _h_ += this.adverts.hashCode();
/* 1130 */     _h_ += this.deletetimestamps.hashCode();
/* 1131 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1137 */     _xdb_verify_unsafe_();
/* 1138 */     StringBuilder _sb_ = new StringBuilder();
/* 1139 */     _sb_.append("(");
/* 1140 */     _sb_.append("'").append(this.sign).append("'");
/* 1141 */     _sb_.append(",");
/* 1142 */     _sb_.append(this.gender);
/* 1143 */     _sb_.append(",");
/* 1144 */     _sb_.append(this.age);
/* 1145 */     _sb_.append(",");
/* 1146 */     _sb_.append(this.birthday);
/* 1147 */     _sb_.append(",");
/* 1148 */     _sb_.append(this.animalsign);
/* 1149 */     _sb_.append(",");
/* 1150 */     _sb_.append(this.constellation);
/* 1151 */     _sb_.append(",");
/* 1152 */     _sb_.append(this.bloodtype);
/* 1153 */     _sb_.append(",");
/* 1154 */     _sb_.append(this.occupation);
/* 1155 */     _sb_.append(",");
/* 1156 */     _sb_.append("'").append(this.school).append("'");
/* 1157 */     _sb_.append(",");
/* 1158 */     _sb_.append(this.location);
/* 1159 */     _sb_.append(",");
/* 1160 */     _sb_.append(this.hobbies);
/* 1161 */     _sb_.append(",");
/* 1162 */     _sb_.append("'").append(this.headimage).append("'");
/* 1163 */     _sb_.append(",");
/* 1164 */     _sb_.append(this.photos);
/* 1165 */     _sb_.append(",");
/* 1166 */     _sb_.append(this.praise);
/* 1167 */     _sb_.append(",");
/* 1168 */     _sb_.append(this.refreshadvert);
/* 1169 */     _sb_.append(",");
/* 1170 */     _sb_.append(this.adverts);
/* 1171 */     _sb_.append(",");
/* 1172 */     _sb_.append(this.deletetimestamps);
/* 1173 */     _sb_.append(")");
/* 1174 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/* 1180 */     ListenableBean lb = new ListenableBean();
/* 1181 */     lb.add(new ListenableChanged().setVarName("sign"));
/* 1182 */     lb.add(new ListenableChanged().setVarName("gender"));
/* 1183 */     lb.add(new ListenableChanged().setVarName("age"));
/* 1184 */     lb.add(new ListenableChanged().setVarName("birthday"));
/* 1185 */     lb.add(new ListenableChanged().setVarName("animalsign"));
/* 1186 */     lb.add(new ListenableChanged().setVarName("constellation"));
/* 1187 */     lb.add(new ListenableChanged().setVarName("bloodtype"));
/* 1188 */     lb.add(new ListenableChanged().setVarName("occupation"));
/* 1189 */     lb.add(new ListenableChanged().setVarName("school"));
/* 1190 */     lb.add(new ListenableChanged().setVarName("location"));
/* 1191 */     lb.add(new ListenableChanged().setVarName("hobbies"));
/* 1192 */     lb.add(new ListenableChanged().setVarName("headimage"));
/* 1193 */     lb.add(new ListenableChanged().setVarName("photos"));
/* 1194 */     lb.add(new ListenableChanged().setVarName("praise"));
/* 1195 */     lb.add(new ListenableMap().setVarName("refreshadvert"));
/* 1196 */     lb.add(new ListenableMap().setVarName("adverts"));
/* 1197 */     lb.add(new ListenableMap().setVarName("deletetimestamps"));
/* 1198 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.PersonalInfo {
/*      */     private Const() {}
/*      */     
/*      */     PersonalInfo nThis() {
/* 1205 */       return PersonalInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1211 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PersonalInfo copy()
/*      */     {
/* 1217 */       return PersonalInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PersonalInfo toData()
/*      */     {
/* 1223 */       return PersonalInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.PersonalInfo toBean()
/*      */     {
/* 1228 */       return PersonalInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PersonalInfo toDataIf()
/*      */     {
/* 1234 */       return PersonalInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.PersonalInfo toBeanIf()
/*      */     {
/* 1239 */       return PersonalInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getSign()
/*      */     {
/* 1246 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1247 */       return PersonalInfo.this.sign;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getSignOctets()
/*      */     {
/* 1254 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1255 */       return PersonalInfo.this.getSignOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGender()
/*      */     {
/* 1262 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1263 */       return PersonalInfo.this.gender;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAge()
/*      */     {
/* 1270 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1271 */       return PersonalInfo.this.age;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBirthday()
/*      */     {
/* 1278 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1279 */       return PersonalInfo.this.birthday;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAnimalsign()
/*      */     {
/* 1286 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1287 */       return PersonalInfo.this.animalsign;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getConstellation()
/*      */     {
/* 1294 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1295 */       return PersonalInfo.this.constellation;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBloodtype()
/*      */     {
/* 1302 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1303 */       return PersonalInfo.this.bloodtype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOccupation()
/*      */     {
/* 1310 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1311 */       return PersonalInfo.this.occupation;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getSchool()
/*      */     {
/* 1318 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1319 */       return PersonalInfo.this.school;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getSchoolOctets()
/*      */     {
/* 1326 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1327 */       return PersonalInfo.this.getSchoolOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLocation()
/*      */     {
/* 1334 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1335 */       return PersonalInfo.this.location;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getHobbies()
/*      */     {
/* 1342 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1343 */       return Consts.constList(PersonalInfo.this.hobbies);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getHobbiesAsData()
/*      */     {
/* 1349 */       PersonalInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1351 */       PersonalInfo _o_ = PersonalInfo.this;
/* 1352 */       List<Integer> hobbies = new ArrayList();
/* 1353 */       hobbies.addAll(_o_.hobbies);
/* 1354 */       return hobbies;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getHeadimage()
/*      */     {
/* 1361 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1362 */       return PersonalInfo.this.headimage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getHeadimageOctets()
/*      */     {
/* 1369 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1370 */       return PersonalInfo.this.getHeadimageOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<String> getPhotos()
/*      */     {
/* 1377 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1378 */       return Consts.constList(PersonalInfo.this.photos);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<String> getPhotosAsData()
/*      */     {
/* 1384 */       PersonalInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1386 */       PersonalInfo _o_ = PersonalInfo.this;
/* 1387 */       List<String> photos = new ArrayList();
/* 1388 */       photos.addAll(_o_.photos);
/* 1389 */       return photos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.PraiseInfo getPraise()
/*      */     {
/* 1396 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1397 */       return (xbean.PraiseInfo)Consts.toConst(PersonalInfo.this.praise);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getRefreshadvert()
/*      */     {
/* 1404 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1405 */       return Consts.constMap(PersonalInfo.this.refreshadvert);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getRefreshadvertAsData()
/*      */     {
/* 1412 */       PersonalInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1414 */       PersonalInfo _o_ = PersonalInfo.this;
/* 1415 */       Map<Integer, Long> refreshadvert = new HashMap();
/* 1416 */       for (Map.Entry<Integer, Long> _e_ : _o_.refreshadvert.entrySet())
/* 1417 */         refreshadvert.put(_e_.getKey(), _e_.getValue());
/* 1418 */       return refreshadvert;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getAdverts()
/*      */     {
/* 1425 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1426 */       return Consts.constMap(PersonalInfo.this.adverts);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getAdvertsAsData()
/*      */     {
/* 1433 */       PersonalInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1435 */       PersonalInfo _o_ = PersonalInfo.this;
/* 1436 */       Map<Integer, Long> adverts = new HashMap();
/* 1437 */       for (Map.Entry<Integer, Long> _e_ : _o_.adverts.entrySet())
/* 1438 */         adverts.put(_e_.getKey(), _e_.getValue());
/* 1439 */       return adverts;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getDeletetimestamps()
/*      */     {
/* 1446 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1447 */       return Consts.constMap(PersonalInfo.this.deletetimestamps);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getDeletetimestampsAsData()
/*      */     {
/* 1454 */       PersonalInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1456 */       PersonalInfo _o_ = PersonalInfo.this;
/* 1457 */       Map<Integer, Long> deletetimestamps = new HashMap();
/* 1458 */       for (Map.Entry<Integer, Long> _e_ : _o_.deletetimestamps.entrySet())
/* 1459 */         deletetimestamps.put(_e_.getKey(), _e_.getValue());
/* 1460 */       return deletetimestamps;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSign(String _v_)
/*      */     {
/* 1467 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1468 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSignOctets(Octets _v_)
/*      */     {
/* 1475 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1476 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGender(int _v_)
/*      */     {
/* 1483 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1484 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAge(int _v_)
/*      */     {
/* 1491 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1492 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBirthday(long _v_)
/*      */     {
/* 1499 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1500 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnimalsign(int _v_)
/*      */     {
/* 1507 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1508 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setConstellation(int _v_)
/*      */     {
/* 1515 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1516 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBloodtype(int _v_)
/*      */     {
/* 1523 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1524 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOccupation(int _v_)
/*      */     {
/* 1531 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1532 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSchool(String _v_)
/*      */     {
/* 1539 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1540 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSchoolOctets(Octets _v_)
/*      */     {
/* 1547 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1548 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLocation(long _v_)
/*      */     {
/* 1555 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1556 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHeadimage(String _v_)
/*      */     {
/* 1563 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1564 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHeadimageOctets(Octets _v_)
/*      */     {
/* 1571 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1572 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1578 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1579 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1585 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1586 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1592 */       return PersonalInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1598 */       return PersonalInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1604 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1605 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1611 */       return PersonalInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1617 */       return PersonalInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1623 */       PersonalInfo.this._xdb_verify_unsafe_();
/* 1624 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1630 */       return PersonalInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1636 */       return PersonalInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1642 */       return PersonalInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1648 */       return PersonalInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1654 */       return PersonalInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1660 */       return PersonalInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1666 */       return PersonalInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.PersonalInfo
/*      */   {
/*      */     private String sign;
/*      */     
/*      */     private int gender;
/*      */     
/*      */     private int age;
/*      */     
/*      */     private long birthday;
/*      */     
/*      */     private int animalsign;
/*      */     
/*      */     private int constellation;
/*      */     
/*      */     private int bloodtype;
/*      */     
/*      */     private int occupation;
/*      */     
/*      */     private String school;
/*      */     
/*      */     private long location;
/*      */     
/*      */     private ArrayList<Integer> hobbies;
/*      */     
/*      */     private String headimage;
/*      */     
/*      */     private ArrayList<String> photos;
/*      */     
/*      */     private xbean.PraiseInfo praise;
/*      */     
/*      */     private HashMap<Integer, Long> refreshadvert;
/*      */     
/*      */     private HashMap<Integer, Long> adverts;
/*      */     
/*      */     private HashMap<Integer, Long> deletetimestamps;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1710 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1715 */       this.sign = "";
/* 1716 */       this.school = "";
/* 1717 */       this.hobbies = new ArrayList();
/* 1718 */       this.headimage = "";
/* 1719 */       this.photos = new ArrayList();
/* 1720 */       this.praise = new PraiseInfo.Data();
/* 1721 */       this.refreshadvert = new HashMap();
/* 1722 */       this.adverts = new HashMap();
/* 1723 */       this.deletetimestamps = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.PersonalInfo _o1_)
/*      */     {
/* 1728 */       if ((_o1_ instanceof PersonalInfo)) { assign((PersonalInfo)_o1_);
/* 1729 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1730 */       } else if ((_o1_ instanceof PersonalInfo.Const)) assign(((PersonalInfo.Const)_o1_).nThis()); else {
/* 1731 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(PersonalInfo _o_) {
/* 1736 */       this.sign = _o_.sign;
/* 1737 */       this.gender = _o_.gender;
/* 1738 */       this.age = _o_.age;
/* 1739 */       this.birthday = _o_.birthday;
/* 1740 */       this.animalsign = _o_.animalsign;
/* 1741 */       this.constellation = _o_.constellation;
/* 1742 */       this.bloodtype = _o_.bloodtype;
/* 1743 */       this.occupation = _o_.occupation;
/* 1744 */       this.school = _o_.school;
/* 1745 */       this.location = _o_.location;
/* 1746 */       this.hobbies = new ArrayList();
/* 1747 */       this.hobbies.addAll(_o_.hobbies);
/* 1748 */       this.headimage = _o_.headimage;
/* 1749 */       this.photos = new ArrayList();
/* 1750 */       this.photos.addAll(_o_.photos);
/* 1751 */       this.praise = new PraiseInfo.Data(_o_.praise);
/* 1752 */       this.refreshadvert = new HashMap();
/* 1753 */       for (Map.Entry<Integer, Long> _e_ : _o_.refreshadvert.entrySet())
/* 1754 */         this.refreshadvert.put(_e_.getKey(), _e_.getValue());
/* 1755 */       this.adverts = new HashMap();
/* 1756 */       for (Map.Entry<Integer, Long> _e_ : _o_.adverts.entrySet())
/* 1757 */         this.adverts.put(_e_.getKey(), _e_.getValue());
/* 1758 */       this.deletetimestamps = new HashMap();
/* 1759 */       for (Map.Entry<Integer, Long> _e_ : _o_.deletetimestamps.entrySet()) {
/* 1760 */         this.deletetimestamps.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/* 1765 */       this.sign = _o_.sign;
/* 1766 */       this.gender = _o_.gender;
/* 1767 */       this.age = _o_.age;
/* 1768 */       this.birthday = _o_.birthday;
/* 1769 */       this.animalsign = _o_.animalsign;
/* 1770 */       this.constellation = _o_.constellation;
/* 1771 */       this.bloodtype = _o_.bloodtype;
/* 1772 */       this.occupation = _o_.occupation;
/* 1773 */       this.school = _o_.school;
/* 1774 */       this.location = _o_.location;
/* 1775 */       this.hobbies = new ArrayList();
/* 1776 */       this.hobbies.addAll(_o_.hobbies);
/* 1777 */       this.headimage = _o_.headimage;
/* 1778 */       this.photos = new ArrayList();
/* 1779 */       this.photos.addAll(_o_.photos);
/* 1780 */       this.praise = new PraiseInfo.Data(_o_.praise);
/* 1781 */       this.refreshadvert = new HashMap();
/* 1782 */       for (Map.Entry<Integer, Long> _e_ : _o_.refreshadvert.entrySet())
/* 1783 */         this.refreshadvert.put(_e_.getKey(), _e_.getValue());
/* 1784 */       this.adverts = new HashMap();
/* 1785 */       for (Map.Entry<Integer, Long> _e_ : _o_.adverts.entrySet())
/* 1786 */         this.adverts.put(_e_.getKey(), _e_.getValue());
/* 1787 */       this.deletetimestamps = new HashMap();
/* 1788 */       for (Map.Entry<Integer, Long> _e_ : _o_.deletetimestamps.entrySet()) {
/* 1789 */         this.deletetimestamps.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1795 */       _os_.marshal(this.sign, "UTF-16LE");
/* 1796 */       _os_.marshal(this.gender);
/* 1797 */       _os_.marshal(this.age);
/* 1798 */       _os_.marshal(this.birthday);
/* 1799 */       _os_.marshal(this.animalsign);
/* 1800 */       _os_.marshal(this.constellation);
/* 1801 */       _os_.marshal(this.bloodtype);
/* 1802 */       _os_.marshal(this.occupation);
/* 1803 */       _os_.marshal(this.school, "UTF-16LE");
/* 1804 */       _os_.marshal(this.location);
/* 1805 */       _os_.compact_uint32(this.hobbies.size());
/* 1806 */       for (Integer _v_ : this.hobbies)
/*      */       {
/* 1808 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1810 */       _os_.marshal(this.headimage, "UTF-16LE");
/* 1811 */       _os_.compact_uint32(this.photos.size());
/* 1812 */       for (String _v_ : this.photos)
/*      */       {
/* 1814 */         _os_.marshal(_v_, "UTF-16LE");
/*      */       }
/* 1816 */       this.praise.marshal(_os_);
/* 1817 */       _os_.compact_uint32(this.refreshadvert.size());
/* 1818 */       for (Map.Entry<Integer, Long> _e_ : this.refreshadvert.entrySet())
/*      */       {
/* 1820 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1821 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/* 1823 */       _os_.compact_uint32(this.adverts.size());
/* 1824 */       for (Map.Entry<Integer, Long> _e_ : this.adverts.entrySet())
/*      */       {
/* 1826 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1827 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/* 1829 */       _os_.compact_uint32(this.deletetimestamps.size());
/* 1830 */       for (Map.Entry<Integer, Long> _e_ : this.deletetimestamps.entrySet())
/*      */       {
/* 1832 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1833 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/* 1835 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1841 */       this.sign = _os_.unmarshal_String("UTF-16LE");
/* 1842 */       this.gender = _os_.unmarshal_int();
/* 1843 */       this.age = _os_.unmarshal_int();
/* 1844 */       this.birthday = _os_.unmarshal_long();
/* 1845 */       this.animalsign = _os_.unmarshal_int();
/* 1846 */       this.constellation = _os_.unmarshal_int();
/* 1847 */       this.bloodtype = _os_.unmarshal_int();
/* 1848 */       this.occupation = _os_.unmarshal_int();
/* 1849 */       this.school = _os_.unmarshal_String("UTF-16LE");
/* 1850 */       this.location = _os_.unmarshal_long();
/* 1851 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1853 */         int _v_ = 0;
/* 1854 */         _v_ = _os_.unmarshal_int();
/* 1855 */         this.hobbies.add(Integer.valueOf(_v_));
/*      */       }
/* 1857 */       this.headimage = _os_.unmarshal_String("UTF-16LE");
/* 1858 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1860 */         String _v_ = "";
/* 1861 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/* 1862 */         this.photos.add(_v_);
/*      */       }
/* 1864 */       this.praise.unmarshal(_os_);
/*      */       
/* 1866 */       int size = _os_.uncompact_uint32();
/* 1867 */       if (size >= 12)
/*      */       {
/* 1869 */         this.refreshadvert = new HashMap(size * 2);
/*      */       }
/* 1871 */       for (; size > 0; size--)
/*      */       {
/* 1873 */         int _k_ = 0;
/* 1874 */         _k_ = _os_.unmarshal_int();
/* 1875 */         long _v_ = 0L;
/* 1876 */         _v_ = _os_.unmarshal_long();
/* 1877 */         this.refreshadvert.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 1881 */       int size = _os_.uncompact_uint32();
/* 1882 */       if (size >= 12)
/*      */       {
/* 1884 */         this.adverts = new HashMap(size * 2);
/*      */       }
/* 1886 */       for (; size > 0; size--)
/*      */       {
/* 1888 */         int _k_ = 0;
/* 1889 */         _k_ = _os_.unmarshal_int();
/* 1890 */         long _v_ = 0L;
/* 1891 */         _v_ = _os_.unmarshal_long();
/* 1892 */         this.adverts.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 1896 */       int size = _os_.uncompact_uint32();
/* 1897 */       if (size >= 12)
/*      */       {
/* 1899 */         this.deletetimestamps = new HashMap(size * 2);
/*      */       }
/* 1901 */       for (; size > 0; size--)
/*      */       {
/* 1903 */         int _k_ = 0;
/* 1904 */         _k_ = _os_.unmarshal_int();
/* 1905 */         long _v_ = 0L;
/* 1906 */         _v_ = _os_.unmarshal_long();
/* 1907 */         this.deletetimestamps.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/* 1910 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1916 */       int _size_ = 0;
/*      */       try
/*      */       {
/* 1919 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.sign, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1923 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1925 */       _size_ += CodedOutputStream.computeInt32Size(2, this.gender);
/* 1926 */       _size_ += CodedOutputStream.computeInt32Size(3, this.age);
/* 1927 */       _size_ += CodedOutputStream.computeInt64Size(4, this.birthday);
/* 1928 */       _size_ += CodedOutputStream.computeInt32Size(5, this.animalsign);
/* 1929 */       _size_ += CodedOutputStream.computeInt32Size(6, this.constellation);
/* 1930 */       _size_ += CodedOutputStream.computeInt32Size(7, this.bloodtype);
/* 1931 */       _size_ += CodedOutputStream.computeInt32Size(8, this.occupation);
/*      */       try
/*      */       {
/* 1934 */         _size_ += CodedOutputStream.computeBytesSize(9, ByteString.copyFrom(this.school, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1938 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1940 */       _size_ += CodedOutputStream.computeInt64Size(10, this.location);
/* 1941 */       for (Integer _v_ : this.hobbies)
/*      */       {
/* 1943 */         _size_ += CodedOutputStream.computeInt32Size(11, _v_.intValue());
/*      */       }
/*      */       try
/*      */       {
/* 1947 */         _size_ += CodedOutputStream.computeBytesSize(12, ByteString.copyFrom(this.headimage, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1951 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1953 */       for (String _v_ : this.photos)
/*      */       {
/*      */         try
/*      */         {
/* 1957 */           _size_ += CodedOutputStream.computeBytesSize(13, ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */         }
/*      */         catch (UnsupportedEncodingException e)
/*      */         {
/* 1961 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*      */         }
/*      */       }
/* 1964 */       _size_ += CodedOutputStream.computeMessageSize(14, this.praise);
/* 1965 */       for (Map.Entry<Integer, Long> _e_ : this.refreshadvert.entrySet())
/*      */       {
/* 1967 */         _size_ += CodedOutputStream.computeInt32Size(16, ((Integer)_e_.getKey()).intValue());
/* 1968 */         _size_ += CodedOutputStream.computeInt64Size(16, ((Long)_e_.getValue()).longValue());
/*      */       }
/* 1970 */       for (Map.Entry<Integer, Long> _e_ : this.adverts.entrySet())
/*      */       {
/* 1972 */         _size_ += CodedOutputStream.computeInt32Size(17, ((Integer)_e_.getKey()).intValue());
/* 1973 */         _size_ += CodedOutputStream.computeInt64Size(17, ((Long)_e_.getValue()).longValue());
/*      */       }
/* 1975 */       for (Map.Entry<Integer, Long> _e_ : this.deletetimestamps.entrySet())
/*      */       {
/* 1977 */         _size_ += CodedOutputStream.computeInt32Size(18, ((Integer)_e_.getKey()).intValue());
/* 1978 */         _size_ += CodedOutputStream.computeInt64Size(18, ((Long)_e_.getValue()).longValue());
/*      */       }
/* 1980 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1988 */         _output_.writeBytes(1, ByteString.copyFrom(this.sign, "UTF-16LE"));
/* 1989 */         _output_.writeInt32(2, this.gender);
/* 1990 */         _output_.writeInt32(3, this.age);
/* 1991 */         _output_.writeInt64(4, this.birthday);
/* 1992 */         _output_.writeInt32(5, this.animalsign);
/* 1993 */         _output_.writeInt32(6, this.constellation);
/* 1994 */         _output_.writeInt32(7, this.bloodtype);
/* 1995 */         _output_.writeInt32(8, this.occupation);
/* 1996 */         _output_.writeBytes(9, ByteString.copyFrom(this.school, "UTF-16LE"));
/* 1997 */         _output_.writeInt64(10, this.location);
/* 1998 */         for (Integer _v_ : this.hobbies)
/*      */         {
/* 2000 */           _output_.writeInt32(11, _v_.intValue());
/*      */         }
/* 2002 */         _output_.writeBytes(12, ByteString.copyFrom(this.headimage, "UTF-16LE"));
/* 2003 */         for (String _v_ : this.photos)
/*      */         {
/* 2005 */           _output_.writeBytes(13, ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */         }
/* 2007 */         _output_.writeMessage(14, this.praise);
/* 2008 */         for (Map.Entry<Integer, Long> _e_ : this.refreshadvert.entrySet())
/*      */         {
/* 2010 */           _output_.writeInt32(16, ((Integer)_e_.getKey()).intValue());
/* 2011 */           _output_.writeInt64(16, ((Long)_e_.getValue()).longValue());
/*      */         }
/* 2013 */         for (Map.Entry<Integer, Long> _e_ : this.adverts.entrySet())
/*      */         {
/* 2015 */           _output_.writeInt32(17, ((Integer)_e_.getKey()).intValue());
/* 2016 */           _output_.writeInt64(17, ((Long)_e_.getValue()).longValue());
/*      */         }
/* 2018 */         for (Map.Entry<Integer, Long> _e_ : this.deletetimestamps.entrySet())
/*      */         {
/* 2020 */           _output_.writeInt32(18, ((Integer)_e_.getKey()).intValue());
/* 2021 */           _output_.writeInt64(18, ((Long)_e_.getValue()).longValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2026 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2028 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2036 */         boolean done = false;
/* 2037 */         while (!done)
/*      */         {
/* 2039 */           int tag = _input_.readTag();
/* 2040 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 2044 */             done = true;
/* 2045 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/* 2049 */             this.sign = _input_.readBytes().toString("UTF-16LE");
/* 2050 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 2054 */             this.gender = _input_.readInt32();
/* 2055 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 2059 */             this.age = _input_.readInt32();
/* 2060 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 2064 */             this.birthday = _input_.readInt64();
/* 2065 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 2069 */             this.animalsign = _input_.readInt32();
/* 2070 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 2074 */             this.constellation = _input_.readInt32();
/* 2075 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 2079 */             this.bloodtype = _input_.readInt32();
/* 2080 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 2084 */             this.occupation = _input_.readInt32();
/* 2085 */             break;
/*      */           
/*      */ 
/*      */           case 74: 
/* 2089 */             this.school = _input_.readBytes().toString("UTF-16LE");
/* 2090 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 2094 */             this.location = _input_.readInt64();
/* 2095 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 2099 */             int _v_ = 0;
/* 2100 */             _v_ = _input_.readInt32();
/* 2101 */             this.hobbies.add(Integer.valueOf(_v_));
/* 2102 */             break;
/*      */           
/*      */ 
/*      */           case 98: 
/* 2106 */             this.headimage = _input_.readBytes().toString("UTF-16LE");
/* 2107 */             break;
/*      */           
/*      */ 
/*      */           case 106: 
/* 2111 */             String _v_ = "";
/* 2112 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 2113 */             this.photos.add(_v_);
/* 2114 */             break;
/*      */           
/*      */ 
/*      */           case 114: 
/* 2118 */             _input_.readMessage(this.praise);
/* 2119 */             break;
/*      */           
/*      */ 
/*      */           case 128: 
/* 2123 */             int _k_ = 0;
/* 2124 */             _k_ = _input_.readInt32();
/* 2125 */             int readTag = _input_.readTag();
/* 2126 */             if (128 != readTag)
/*      */             {
/* 2128 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2130 */             long _v_ = 0L;
/* 2131 */             _v_ = _input_.readInt64();
/* 2132 */             this.refreshadvert.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 2133 */             break;
/*      */           
/*      */ 
/*      */           case 136: 
/* 2137 */             int _k_ = 0;
/* 2138 */             _k_ = _input_.readInt32();
/* 2139 */             int readTag = _input_.readTag();
/* 2140 */             if (136 != readTag)
/*      */             {
/* 2142 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2144 */             long _v_ = 0L;
/* 2145 */             _v_ = _input_.readInt64();
/* 2146 */             this.adverts.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 2147 */             break;
/*      */           
/*      */ 
/*      */           case 144: 
/* 2151 */             int _k_ = 0;
/* 2152 */             _k_ = _input_.readInt32();
/* 2153 */             int readTag = _input_.readTag();
/* 2154 */             if (144 != readTag)
/*      */             {
/* 2156 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2158 */             long _v_ = 0L;
/* 2159 */             _v_ = _input_.readInt64();
/* 2160 */             this.deletetimestamps.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 2161 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 2165 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 2167 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 2176 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2180 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2182 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PersonalInfo copy()
/*      */     {
/* 2188 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PersonalInfo toData()
/*      */     {
/* 2194 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.PersonalInfo toBean()
/*      */     {
/* 2199 */       return new PersonalInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PersonalInfo toDataIf()
/*      */     {
/* 2205 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.PersonalInfo toBeanIf()
/*      */     {
/* 2210 */       return new PersonalInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2216 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 2220 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 2224 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 2228 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 2232 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 2236 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 2240 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getSign()
/*      */     {
/* 2247 */       return this.sign;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getSignOctets()
/*      */     {
/* 2254 */       return Octets.wrap(getSign(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGender()
/*      */     {
/* 2261 */       return this.gender;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAge()
/*      */     {
/* 2268 */       return this.age;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBirthday()
/*      */     {
/* 2275 */       return this.birthday;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAnimalsign()
/*      */     {
/* 2282 */       return this.animalsign;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getConstellation()
/*      */     {
/* 2289 */       return this.constellation;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBloodtype()
/*      */     {
/* 2296 */       return this.bloodtype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOccupation()
/*      */     {
/* 2303 */       return this.occupation;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getSchool()
/*      */     {
/* 2310 */       return this.school;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getSchoolOctets()
/*      */     {
/* 2317 */       return Octets.wrap(getSchool(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLocation()
/*      */     {
/* 2324 */       return this.location;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getHobbies()
/*      */     {
/* 2331 */       return this.hobbies;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getHobbiesAsData()
/*      */     {
/* 2338 */       return this.hobbies;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getHeadimage()
/*      */     {
/* 2345 */       return this.headimage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getHeadimageOctets()
/*      */     {
/* 2352 */       return Octets.wrap(getHeadimage(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<String> getPhotos()
/*      */     {
/* 2359 */       return this.photos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<String> getPhotosAsData()
/*      */     {
/* 2366 */       return this.photos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.PraiseInfo getPraise()
/*      */     {
/* 2373 */       return this.praise;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getRefreshadvert()
/*      */     {
/* 2380 */       return this.refreshadvert;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getRefreshadvertAsData()
/*      */     {
/* 2387 */       return this.refreshadvert;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getAdverts()
/*      */     {
/* 2394 */       return this.adverts;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getAdvertsAsData()
/*      */     {
/* 2401 */       return this.adverts;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getDeletetimestamps()
/*      */     {
/* 2408 */       return this.deletetimestamps;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Long> getDeletetimestampsAsData()
/*      */     {
/* 2415 */       return this.deletetimestamps;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSign(String _v_)
/*      */     {
/* 2422 */       if (null == _v_)
/* 2423 */         throw new NullPointerException();
/* 2424 */       this.sign = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSignOctets(Octets _v_)
/*      */     {
/* 2431 */       setSign(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGender(int _v_)
/*      */     {
/* 2438 */       this.gender = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAge(int _v_)
/*      */     {
/* 2445 */       this.age = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBirthday(long _v_)
/*      */     {
/* 2452 */       this.birthday = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnimalsign(int _v_)
/*      */     {
/* 2459 */       this.animalsign = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setConstellation(int _v_)
/*      */     {
/* 2466 */       this.constellation = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBloodtype(int _v_)
/*      */     {
/* 2473 */       this.bloodtype = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOccupation(int _v_)
/*      */     {
/* 2480 */       this.occupation = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSchool(String _v_)
/*      */     {
/* 2487 */       if (null == _v_)
/* 2488 */         throw new NullPointerException();
/* 2489 */       this.school = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSchoolOctets(Octets _v_)
/*      */     {
/* 2496 */       setSchool(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLocation(long _v_)
/*      */     {
/* 2503 */       this.location = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHeadimage(String _v_)
/*      */     {
/* 2510 */       if (null == _v_)
/* 2511 */         throw new NullPointerException();
/* 2512 */       this.headimage = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHeadimageOctets(Octets _v_)
/*      */     {
/* 2519 */       setHeadimage(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 2525 */       if (!(_o1_ instanceof Data)) return false;
/* 2526 */       Data _o_ = (Data)_o1_;
/* 2527 */       if (!this.sign.equals(_o_.sign)) return false;
/* 2528 */       if (this.gender != _o_.gender) return false;
/* 2529 */       if (this.age != _o_.age) return false;
/* 2530 */       if (this.birthday != _o_.birthday) return false;
/* 2531 */       if (this.animalsign != _o_.animalsign) return false;
/* 2532 */       if (this.constellation != _o_.constellation) return false;
/* 2533 */       if (this.bloodtype != _o_.bloodtype) return false;
/* 2534 */       if (this.occupation != _o_.occupation) return false;
/* 2535 */       if (!this.school.equals(_o_.school)) return false;
/* 2536 */       if (this.location != _o_.location) return false;
/* 2537 */       if (!this.hobbies.equals(_o_.hobbies)) return false;
/* 2538 */       if (!this.headimage.equals(_o_.headimage)) return false;
/* 2539 */       if (!this.photos.equals(_o_.photos)) return false;
/* 2540 */       if (!this.praise.equals(_o_.praise)) return false;
/* 2541 */       if (!this.refreshadvert.equals(_o_.refreshadvert)) return false;
/* 2542 */       if (!this.adverts.equals(_o_.adverts)) return false;
/* 2543 */       if (!this.deletetimestamps.equals(_o_.deletetimestamps)) return false;
/* 2544 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 2550 */       int _h_ = 0;
/* 2551 */       _h_ += this.sign.hashCode();
/* 2552 */       _h_ += this.gender;
/* 2553 */       _h_ += this.age;
/* 2554 */       _h_ = (int)(_h_ + this.birthday);
/* 2555 */       _h_ += this.animalsign;
/* 2556 */       _h_ += this.constellation;
/* 2557 */       _h_ += this.bloodtype;
/* 2558 */       _h_ += this.occupation;
/* 2559 */       _h_ += this.school.hashCode();
/* 2560 */       _h_ = (int)(_h_ + this.location);
/* 2561 */       _h_ += this.hobbies.hashCode();
/* 2562 */       _h_ += this.headimage.hashCode();
/* 2563 */       _h_ += this.photos.hashCode();
/* 2564 */       _h_ += this.praise.hashCode();
/* 2565 */       _h_ += this.refreshadvert.hashCode();
/* 2566 */       _h_ += this.adverts.hashCode();
/* 2567 */       _h_ += this.deletetimestamps.hashCode();
/* 2568 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2574 */       StringBuilder _sb_ = new StringBuilder();
/* 2575 */       _sb_.append("(");
/* 2576 */       _sb_.append("'").append(this.sign).append("'");
/* 2577 */       _sb_.append(",");
/* 2578 */       _sb_.append(this.gender);
/* 2579 */       _sb_.append(",");
/* 2580 */       _sb_.append(this.age);
/* 2581 */       _sb_.append(",");
/* 2582 */       _sb_.append(this.birthday);
/* 2583 */       _sb_.append(",");
/* 2584 */       _sb_.append(this.animalsign);
/* 2585 */       _sb_.append(",");
/* 2586 */       _sb_.append(this.constellation);
/* 2587 */       _sb_.append(",");
/* 2588 */       _sb_.append(this.bloodtype);
/* 2589 */       _sb_.append(",");
/* 2590 */       _sb_.append(this.occupation);
/* 2591 */       _sb_.append(",");
/* 2592 */       _sb_.append("'").append(this.school).append("'");
/* 2593 */       _sb_.append(",");
/* 2594 */       _sb_.append(this.location);
/* 2595 */       _sb_.append(",");
/* 2596 */       _sb_.append(this.hobbies);
/* 2597 */       _sb_.append(",");
/* 2598 */       _sb_.append("'").append(this.headimage).append("'");
/* 2599 */       _sb_.append(",");
/* 2600 */       _sb_.append(this.photos);
/* 2601 */       _sb_.append(",");
/* 2602 */       _sb_.append(this.praise);
/* 2603 */       _sb_.append(",");
/* 2604 */       _sb_.append(this.refreshadvert);
/* 2605 */       _sb_.append(",");
/* 2606 */       _sb_.append(this.adverts);
/* 2607 */       _sb_.append(",");
/* 2608 */       _sb_.append(this.deletetimestamps);
/* 2609 */       _sb_.append(")");
/* 2610 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PersonalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */