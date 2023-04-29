/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
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
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class ChildInfo extends XBean implements xbean.ChildInfo
/*      */ {
/*      */   private long own_role_id;
/*      */   private int child_period;
/*      */   private String child_name;
/*      */   private int child_gender;
/*      */   private long another_parent_role_id;
/*      */   private xbean.BabyPeriodInfo baby_period_info;
/*      */   private xbean.ChildhoodInfo childhood_info;
/*      */   private int home_state;
/*      */   private HashMap<Integer, xbean.DressedInfo> dressed;
/*      */   private long carry_role_id;
/*      */   private ArrayList<xbean.AdulthoodInfo> adulthood_info;
/*      */   private int position_x;
/*      */   private int position_y;
/*      */   private boolean is_discard;
/*      */   private long discard_time;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   46 */     this.own_role_id = 0L;
/*   47 */     this.child_period = 0;
/*   48 */     this.child_name = "";
/*   49 */     this.child_gender = 0;
/*   50 */     this.another_parent_role_id = 0L;
/*   51 */     this.baby_period_info._reset_unsafe_();
/*   52 */     this.childhood_info._reset_unsafe_();
/*   53 */     this.home_state = 0;
/*   54 */     this.dressed.clear();
/*   55 */     this.carry_role_id = -1L;
/*   56 */     this.adulthood_info.clear();
/*   57 */     this.position_x = -1;
/*   58 */     this.position_y = -1;
/*   59 */     this.is_discard = false;
/*   60 */     this.discard_time = 0L;
/*      */   }
/*      */   
/*      */   ChildInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   65 */     super(_xp_, _vn_);
/*   66 */     this.child_name = "";
/*   67 */     this.baby_period_info = new BabyPeriodInfo(0, this, "baby_period_info");
/*   68 */     this.childhood_info = new ChildhoodInfo(0, this, "childhood_info");
/*   69 */     this.dressed = new HashMap();
/*   70 */     this.carry_role_id = -1L;
/*   71 */     this.adulthood_info = new ArrayList();
/*   72 */     this.position_x = -1;
/*   73 */     this.position_y = -1;
/*   74 */     this.is_discard = false;
/*      */   }
/*      */   
/*      */   public ChildInfo()
/*      */   {
/*   79 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ChildInfo(ChildInfo _o_)
/*      */   {
/*   84 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ChildInfo(xbean.ChildInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   89 */     super(_xp_, _vn_);
/*   90 */     if ((_o1_ instanceof ChildInfo)) { assign((ChildInfo)_o1_);
/*   91 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   92 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   93 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ChildInfo _o_) {
/*   98 */     _o_._xdb_verify_unsafe_();
/*   99 */     this.own_role_id = _o_.own_role_id;
/*  100 */     this.child_period = _o_.child_period;
/*  101 */     this.child_name = _o_.child_name;
/*  102 */     this.child_gender = _o_.child_gender;
/*  103 */     this.another_parent_role_id = _o_.another_parent_role_id;
/*  104 */     this.baby_period_info = new BabyPeriodInfo(_o_.baby_period_info, this, "baby_period_info");
/*  105 */     this.childhood_info = new ChildhoodInfo(_o_.childhood_info, this, "childhood_info");
/*  106 */     this.home_state = _o_.home_state;
/*  107 */     this.dressed = new HashMap();
/*  108 */     for (Map.Entry<Integer, xbean.DressedInfo> _e_ : _o_.dressed.entrySet())
/*  109 */       this.dressed.put(_e_.getKey(), new DressedInfo((xbean.DressedInfo)_e_.getValue(), this, "dressed"));
/*  110 */     this.carry_role_id = _o_.carry_role_id;
/*  111 */     this.adulthood_info = new ArrayList();
/*  112 */     for (xbean.AdulthoodInfo _v_ : _o_.adulthood_info)
/*  113 */       this.adulthood_info.add(new AdulthoodInfo(_v_, this, "adulthood_info"));
/*  114 */     this.position_x = _o_.position_x;
/*  115 */     this.position_y = _o_.position_y;
/*  116 */     this.is_discard = _o_.is_discard;
/*  117 */     this.discard_time = _o_.discard_time;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  122 */     this.own_role_id = _o_.own_role_id;
/*  123 */     this.child_period = _o_.child_period;
/*  124 */     this.child_name = _o_.child_name;
/*  125 */     this.child_gender = _o_.child_gender;
/*  126 */     this.another_parent_role_id = _o_.another_parent_role_id;
/*  127 */     this.baby_period_info = new BabyPeriodInfo(_o_.baby_period_info, this, "baby_period_info");
/*  128 */     this.childhood_info = new ChildhoodInfo(_o_.childhood_info, this, "childhood_info");
/*  129 */     this.home_state = _o_.home_state;
/*  130 */     this.dressed = new HashMap();
/*  131 */     for (Map.Entry<Integer, xbean.DressedInfo> _e_ : _o_.dressed.entrySet())
/*  132 */       this.dressed.put(_e_.getKey(), new DressedInfo((xbean.DressedInfo)_e_.getValue(), this, "dressed"));
/*  133 */     this.carry_role_id = _o_.carry_role_id;
/*  134 */     this.adulthood_info = new ArrayList();
/*  135 */     for (xbean.AdulthoodInfo _v_ : _o_.adulthood_info)
/*  136 */       this.adulthood_info.add(new AdulthoodInfo(_v_, this, "adulthood_info"));
/*  137 */     this.position_x = _o_.position_x;
/*  138 */     this.position_y = _o_.position_y;
/*  139 */     this.is_discard = _o_.is_discard;
/*  140 */     this.discard_time = _o_.discard_time;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  146 */     _xdb_verify_unsafe_();
/*  147 */     _os_.marshal(this.own_role_id);
/*  148 */     _os_.marshal(this.child_period);
/*  149 */     _os_.marshal(this.child_name, "UTF-16LE");
/*  150 */     _os_.marshal(this.child_gender);
/*  151 */     _os_.marshal(this.another_parent_role_id);
/*  152 */     this.baby_period_info.marshal(_os_);
/*  153 */     this.childhood_info.marshal(_os_);
/*  154 */     _os_.marshal(this.home_state);
/*  155 */     _os_.compact_uint32(this.dressed.size());
/*  156 */     for (Map.Entry<Integer, xbean.DressedInfo> _e_ : this.dressed.entrySet())
/*      */     {
/*  158 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  159 */       ((xbean.DressedInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  161 */     _os_.marshal(this.carry_role_id);
/*  162 */     _os_.compact_uint32(this.adulthood_info.size());
/*  163 */     for (xbean.AdulthoodInfo _v_ : this.adulthood_info)
/*      */     {
/*  165 */       _v_.marshal(_os_);
/*      */     }
/*  167 */     _os_.marshal(this.position_x);
/*  168 */     _os_.marshal(this.position_y);
/*  169 */     _os_.marshal(this.is_discard);
/*  170 */     _os_.marshal(this.discard_time);
/*  171 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  177 */     _xdb_verify_unsafe_();
/*  178 */     this.own_role_id = _os_.unmarshal_long();
/*  179 */     this.child_period = _os_.unmarshal_int();
/*  180 */     this.child_name = _os_.unmarshal_String("UTF-16LE");
/*  181 */     this.child_gender = _os_.unmarshal_int();
/*  182 */     this.another_parent_role_id = _os_.unmarshal_long();
/*  183 */     this.baby_period_info.unmarshal(_os_);
/*  184 */     this.childhood_info.unmarshal(_os_);
/*  185 */     this.home_state = _os_.unmarshal_int();
/*      */     
/*  187 */     int size = _os_.uncompact_uint32();
/*  188 */     if (size >= 12)
/*      */     {
/*  190 */       this.dressed = new HashMap(size * 2);
/*      */     }
/*  192 */     for (; size > 0; size--)
/*      */     {
/*  194 */       int _k_ = 0;
/*  195 */       _k_ = _os_.unmarshal_int();
/*  196 */       xbean.DressedInfo _v_ = new DressedInfo(0, this, "dressed");
/*  197 */       _v_.unmarshal(_os_);
/*  198 */       this.dressed.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  201 */     this.carry_role_id = _os_.unmarshal_long();
/*  202 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  204 */       xbean.AdulthoodInfo _v_ = new AdulthoodInfo(0, this, "adulthood_info");
/*  205 */       _v_.unmarshal(_os_);
/*  206 */       this.adulthood_info.add(_v_);
/*      */     }
/*  208 */     this.position_x = _os_.unmarshal_int();
/*  209 */     this.position_y = _os_.unmarshal_int();
/*  210 */     this.is_discard = _os_.unmarshal_boolean();
/*  211 */     this.discard_time = _os_.unmarshal_long();
/*  212 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  218 */     _xdb_verify_unsafe_();
/*  219 */     int _size_ = 0;
/*  220 */     _size_ += CodedOutputStream.computeInt64Size(1, this.own_role_id);
/*  221 */     _size_ += CodedOutputStream.computeInt32Size(2, this.child_period);
/*      */     try
/*      */     {
/*  224 */       _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.child_name, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  228 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  230 */     _size_ += CodedOutputStream.computeInt32Size(4, this.child_gender);
/*  231 */     _size_ += CodedOutputStream.computeInt64Size(5, this.another_parent_role_id);
/*  232 */     _size_ += CodedOutputStream.computeMessageSize(6, this.baby_period_info);
/*  233 */     _size_ += CodedOutputStream.computeMessageSize(8, this.childhood_info);
/*  234 */     _size_ += CodedOutputStream.computeInt32Size(9, this.home_state);
/*  235 */     for (Map.Entry<Integer, xbean.DressedInfo> _e_ : this.dressed.entrySet())
/*      */     {
/*  237 */       _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getKey()).intValue());
/*  238 */       _size_ += CodedOutputStream.computeMessageSize(10, (ppbio.Message)_e_.getValue());
/*      */     }
/*  240 */     _size_ += CodedOutputStream.computeInt64Size(11, this.carry_role_id);
/*  241 */     for (xbean.AdulthoodInfo _v_ : this.adulthood_info)
/*      */     {
/*  243 */       _size_ += CodedOutputStream.computeMessageSize(12, _v_);
/*      */     }
/*  245 */     _size_ += CodedOutputStream.computeInt32Size(13, this.position_x);
/*  246 */     _size_ += CodedOutputStream.computeInt32Size(14, this.position_y);
/*  247 */     _size_ += CodedOutputStream.computeBoolSize(15, this.is_discard);
/*  248 */     _size_ += CodedOutputStream.computeInt64Size(16, this.discard_time);
/*  249 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  258 */       _output_.writeInt64(1, this.own_role_id);
/*  259 */       _output_.writeInt32(2, this.child_period);
/*  260 */       _output_.writeBytes(3, ByteString.copyFrom(this.child_name, "UTF-16LE"));
/*  261 */       _output_.writeInt32(4, this.child_gender);
/*  262 */       _output_.writeInt64(5, this.another_parent_role_id);
/*  263 */       _output_.writeMessage(6, this.baby_period_info);
/*  264 */       _output_.writeMessage(8, this.childhood_info);
/*  265 */       _output_.writeInt32(9, this.home_state);
/*  266 */       for (Map.Entry<Integer, xbean.DressedInfo> _e_ : this.dressed.entrySet())
/*      */       {
/*  268 */         _output_.writeInt32(10, ((Integer)_e_.getKey()).intValue());
/*  269 */         _output_.writeMessage(10, (ppbio.Message)_e_.getValue());
/*      */       }
/*  271 */       _output_.writeInt64(11, this.carry_role_id);
/*  272 */       for (xbean.AdulthoodInfo _v_ : this.adulthood_info)
/*      */       {
/*  274 */         _output_.writeMessage(12, _v_);
/*      */       }
/*  276 */       _output_.writeInt32(13, this.position_x);
/*  277 */       _output_.writeInt32(14, this.position_y);
/*  278 */       _output_.writeBool(15, this.is_discard);
/*  279 */       _output_.writeInt64(16, this.discard_time);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  283 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  285 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  294 */       boolean done = false;
/*  295 */       while (!done)
/*      */       {
/*  297 */         int tag = _input_.readTag();
/*  298 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  302 */           done = true;
/*  303 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  307 */           this.own_role_id = _input_.readInt64();
/*  308 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  312 */           this.child_period = _input_.readInt32();
/*  313 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  317 */           this.child_name = _input_.readBytes().toString("UTF-16LE");
/*  318 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  322 */           this.child_gender = _input_.readInt32();
/*  323 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  327 */           this.another_parent_role_id = _input_.readInt64();
/*  328 */           break;
/*      */         
/*      */ 
/*      */         case 50: 
/*  332 */           _input_.readMessage(this.baby_period_info);
/*  333 */           break;
/*      */         
/*      */ 
/*      */         case 66: 
/*  337 */           _input_.readMessage(this.childhood_info);
/*  338 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  342 */           this.home_state = _input_.readInt32();
/*  343 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  347 */           int _k_ = 0;
/*  348 */           _k_ = _input_.readInt32();
/*  349 */           int readTag = _input_.readTag();
/*  350 */           if (82 != readTag)
/*      */           {
/*  352 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  354 */           xbean.DressedInfo _v_ = new DressedInfo(0, this, "dressed");
/*  355 */           _input_.readMessage(_v_);
/*  356 */           this.dressed.put(Integer.valueOf(_k_), _v_);
/*  357 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  361 */           this.carry_role_id = _input_.readInt64();
/*  362 */           break;
/*      */         
/*      */ 
/*      */         case 98: 
/*  366 */           xbean.AdulthoodInfo _v_ = new AdulthoodInfo(0, this, "adulthood_info");
/*  367 */           _input_.readMessage(_v_);
/*  368 */           this.adulthood_info.add(_v_);
/*  369 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  373 */           this.position_x = _input_.readInt32();
/*  374 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  378 */           this.position_y = _input_.readInt32();
/*  379 */           break;
/*      */         
/*      */ 
/*      */         case 120: 
/*  383 */           this.is_discard = _input_.readBool();
/*  384 */           break;
/*      */         
/*      */ 
/*      */         case 128: 
/*  388 */           this.discard_time = _input_.readInt64();
/*  389 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  393 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  395 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  404 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  408 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  410 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChildInfo copy()
/*      */   {
/*  416 */     _xdb_verify_unsafe_();
/*  417 */     return new ChildInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChildInfo toData()
/*      */   {
/*  423 */     _xdb_verify_unsafe_();
/*  424 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChildInfo toBean()
/*      */   {
/*  429 */     _xdb_verify_unsafe_();
/*  430 */     return new ChildInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChildInfo toDataIf()
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*  437 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChildInfo toBeanIf()
/*      */   {
/*  442 */     _xdb_verify_unsafe_();
/*  443 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  449 */     _xdb_verify_unsafe_();
/*  450 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getOwn_role_id()
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     return this.own_role_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getChild_period()
/*      */   {
/*  465 */     _xdb_verify_unsafe_();
/*  466 */     return this.child_period;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getChild_name()
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     return this.child_name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getChild_nameOctets()
/*      */   {
/*  481 */     _xdb_verify_unsafe_();
/*  482 */     return Octets.wrap(getChild_name(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getChild_gender()
/*      */   {
/*  489 */     _xdb_verify_unsafe_();
/*  490 */     return this.child_gender;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAnother_parent_role_id()
/*      */   {
/*  497 */     _xdb_verify_unsafe_();
/*  498 */     return this.another_parent_role_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.BabyPeriodInfo getBaby_period_info()
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     return this.baby_period_info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.ChildhoodInfo getChildhood_info()
/*      */   {
/*  513 */     _xdb_verify_unsafe_();
/*  514 */     return this.childhood_info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHome_state()
/*      */   {
/*  521 */     _xdb_verify_unsafe_();
/*  522 */     return this.home_state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.DressedInfo> getDressed()
/*      */   {
/*  529 */     _xdb_verify_unsafe_();
/*  530 */     return Logs.logMap(new LogKey(this, "dressed"), this.dressed);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.DressedInfo> getDressedAsData()
/*      */   {
/*  537 */     _xdb_verify_unsafe_();
/*      */     
/*  539 */     ChildInfo _o_ = this;
/*  540 */     Map<Integer, xbean.DressedInfo> dressed = new HashMap();
/*  541 */     for (Map.Entry<Integer, xbean.DressedInfo> _e_ : _o_.dressed.entrySet())
/*  542 */       dressed.put(_e_.getKey(), new DressedInfo.Data((xbean.DressedInfo)_e_.getValue()));
/*  543 */     return dressed;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCarry_role_id()
/*      */   {
/*  550 */     _xdb_verify_unsafe_();
/*  551 */     return this.carry_role_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.AdulthoodInfo> getAdulthood_info()
/*      */   {
/*  558 */     _xdb_verify_unsafe_();
/*  559 */     return Logs.logList(new LogKey(this, "adulthood_info"), this.adulthood_info);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.AdulthoodInfo> getAdulthood_infoAsData()
/*      */   {
/*  565 */     _xdb_verify_unsafe_();
/*      */     
/*  567 */     ChildInfo _o_ = this;
/*  568 */     List<xbean.AdulthoodInfo> adulthood_info = new ArrayList();
/*  569 */     for (xbean.AdulthoodInfo _v_ : _o_.adulthood_info)
/*  570 */       adulthood_info.add(new AdulthoodInfo.Data(_v_));
/*  571 */     return adulthood_info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPosition_x()
/*      */   {
/*  578 */     _xdb_verify_unsafe_();
/*  579 */     return this.position_x;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPosition_y()
/*      */   {
/*  586 */     _xdb_verify_unsafe_();
/*  587 */     return this.position_y;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_discard()
/*      */   {
/*  594 */     _xdb_verify_unsafe_();
/*  595 */     return this.is_discard;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getDiscard_time()
/*      */   {
/*  602 */     _xdb_verify_unsafe_();
/*  603 */     return this.discard_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOwn_role_id(long _v_)
/*      */   {
/*  610 */     _xdb_verify_unsafe_();
/*  611 */     Logs.logIf(new LogKey(this, "own_role_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  615 */         new LogLong(this, ChildInfo.this.own_role_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  619 */             ChildInfo.this.own_role_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  623 */     });
/*  624 */     this.own_role_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChild_period(int _v_)
/*      */   {
/*  631 */     _xdb_verify_unsafe_();
/*  632 */     Logs.logIf(new LogKey(this, "child_period")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  636 */         new LogInt(this, ChildInfo.this.child_period)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  640 */             ChildInfo.this.child_period = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  644 */     });
/*  645 */     this.child_period = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChild_name(String _v_)
/*      */   {
/*  652 */     _xdb_verify_unsafe_();
/*  653 */     if (null == _v_)
/*  654 */       throw new NullPointerException();
/*  655 */     Logs.logIf(new LogKey(this, "child_name")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  659 */         new xdb.logs.LogString(this, ChildInfo.this.child_name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  663 */             ChildInfo.this.child_name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  667 */     });
/*  668 */     this.child_name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChild_nameOctets(Octets _v_)
/*      */   {
/*  675 */     _xdb_verify_unsafe_();
/*  676 */     setChild_name(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChild_gender(int _v_)
/*      */   {
/*  683 */     _xdb_verify_unsafe_();
/*  684 */     Logs.logIf(new LogKey(this, "child_gender")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  688 */         new LogInt(this, ChildInfo.this.child_gender)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  692 */             ChildInfo.this.child_gender = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  696 */     });
/*  697 */     this.child_gender = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAnother_parent_role_id(long _v_)
/*      */   {
/*  704 */     _xdb_verify_unsafe_();
/*  705 */     Logs.logIf(new LogKey(this, "another_parent_role_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  709 */         new LogLong(this, ChildInfo.this.another_parent_role_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  713 */             ChildInfo.this.another_parent_role_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  717 */     });
/*  718 */     this.another_parent_role_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHome_state(int _v_)
/*      */   {
/*  725 */     _xdb_verify_unsafe_();
/*  726 */     Logs.logIf(new LogKey(this, "home_state")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  730 */         new LogInt(this, ChildInfo.this.home_state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  734 */             ChildInfo.this.home_state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  738 */     });
/*  739 */     this.home_state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCarry_role_id(long _v_)
/*      */   {
/*  746 */     _xdb_verify_unsafe_();
/*  747 */     Logs.logIf(new LogKey(this, "carry_role_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  751 */         new LogLong(this, ChildInfo.this.carry_role_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  755 */             ChildInfo.this.carry_role_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  759 */     });
/*  760 */     this.carry_role_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPosition_x(int _v_)
/*      */   {
/*  767 */     _xdb_verify_unsafe_();
/*  768 */     Logs.logIf(new LogKey(this, "position_x")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  772 */         new LogInt(this, ChildInfo.this.position_x)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  776 */             ChildInfo.this.position_x = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  780 */     });
/*  781 */     this.position_x = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPosition_y(int _v_)
/*      */   {
/*  788 */     _xdb_verify_unsafe_();
/*  789 */     Logs.logIf(new LogKey(this, "position_y")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  793 */         new LogInt(this, ChildInfo.this.position_y)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  797 */             ChildInfo.this.position_y = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  801 */     });
/*  802 */     this.position_y = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_discard(boolean _v_)
/*      */   {
/*  809 */     _xdb_verify_unsafe_();
/*  810 */     Logs.logIf(new LogKey(this, "is_discard")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  814 */         new xdb.logs.LogObject(this, Boolean.valueOf(ChildInfo.this.is_discard))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  818 */             ChildInfo.this.is_discard = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  822 */     });
/*  823 */     this.is_discard = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDiscard_time(long _v_)
/*      */   {
/*  830 */     _xdb_verify_unsafe_();
/*  831 */     Logs.logIf(new LogKey(this, "discard_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  835 */         new LogLong(this, ChildInfo.this.discard_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  839 */             ChildInfo.this.discard_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  843 */     });
/*  844 */     this.discard_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  850 */     _xdb_verify_unsafe_();
/*  851 */     ChildInfo _o_ = null;
/*  852 */     if ((_o1_ instanceof ChildInfo)) { _o_ = (ChildInfo)_o1_;
/*  853 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  854 */       return false;
/*  855 */     if (this.own_role_id != _o_.own_role_id) return false;
/*  856 */     if (this.child_period != _o_.child_period) return false;
/*  857 */     if (!this.child_name.equals(_o_.child_name)) return false;
/*  858 */     if (this.child_gender != _o_.child_gender) return false;
/*  859 */     if (this.another_parent_role_id != _o_.another_parent_role_id) return false;
/*  860 */     if (!this.baby_period_info.equals(_o_.baby_period_info)) return false;
/*  861 */     if (!this.childhood_info.equals(_o_.childhood_info)) return false;
/*  862 */     if (this.home_state != _o_.home_state) return false;
/*  863 */     if (!this.dressed.equals(_o_.dressed)) return false;
/*  864 */     if (this.carry_role_id != _o_.carry_role_id) return false;
/*  865 */     if (!this.adulthood_info.equals(_o_.adulthood_info)) return false;
/*  866 */     if (this.position_x != _o_.position_x) return false;
/*  867 */     if (this.position_y != _o_.position_y) return false;
/*  868 */     if (this.is_discard != _o_.is_discard) return false;
/*  869 */     if (this.discard_time != _o_.discard_time) return false;
/*  870 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  876 */     _xdb_verify_unsafe_();
/*  877 */     int _h_ = 0;
/*  878 */     _h_ = (int)(_h_ + this.own_role_id);
/*  879 */     _h_ += this.child_period;
/*  880 */     _h_ += this.child_name.hashCode();
/*  881 */     _h_ += this.child_gender;
/*  882 */     _h_ = (int)(_h_ + this.another_parent_role_id);
/*  883 */     _h_ += this.baby_period_info.hashCode();
/*  884 */     _h_ += this.childhood_info.hashCode();
/*  885 */     _h_ += this.home_state;
/*  886 */     _h_ += this.dressed.hashCode();
/*  887 */     _h_ = (int)(_h_ + this.carry_role_id);
/*  888 */     _h_ += this.adulthood_info.hashCode();
/*  889 */     _h_ += this.position_x;
/*  890 */     _h_ += this.position_y;
/*  891 */     _h_ += (this.is_discard ? 1231 : 1237);
/*  892 */     _h_ = (int)(_h_ + this.discard_time);
/*  893 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  899 */     _xdb_verify_unsafe_();
/*  900 */     StringBuilder _sb_ = new StringBuilder();
/*  901 */     _sb_.append("(");
/*  902 */     _sb_.append(this.own_role_id);
/*  903 */     _sb_.append(",");
/*  904 */     _sb_.append(this.child_period);
/*  905 */     _sb_.append(",");
/*  906 */     _sb_.append("'").append(this.child_name).append("'");
/*  907 */     _sb_.append(",");
/*  908 */     _sb_.append(this.child_gender);
/*  909 */     _sb_.append(",");
/*  910 */     _sb_.append(this.another_parent_role_id);
/*  911 */     _sb_.append(",");
/*  912 */     _sb_.append(this.baby_period_info);
/*  913 */     _sb_.append(",");
/*  914 */     _sb_.append(this.childhood_info);
/*  915 */     _sb_.append(",");
/*  916 */     _sb_.append(this.home_state);
/*  917 */     _sb_.append(",");
/*  918 */     _sb_.append(this.dressed);
/*  919 */     _sb_.append(",");
/*  920 */     _sb_.append(this.carry_role_id);
/*  921 */     _sb_.append(",");
/*  922 */     _sb_.append(this.adulthood_info);
/*  923 */     _sb_.append(",");
/*  924 */     _sb_.append(this.position_x);
/*  925 */     _sb_.append(",");
/*  926 */     _sb_.append(this.position_y);
/*  927 */     _sb_.append(",");
/*  928 */     _sb_.append(this.is_discard);
/*  929 */     _sb_.append(",");
/*  930 */     _sb_.append(this.discard_time);
/*  931 */     _sb_.append(")");
/*  932 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  938 */     ListenableBean lb = new ListenableBean();
/*  939 */     lb.add(new ListenableChanged().setVarName("own_role_id"));
/*  940 */     lb.add(new ListenableChanged().setVarName("child_period"));
/*  941 */     lb.add(new ListenableChanged().setVarName("child_name"));
/*  942 */     lb.add(new ListenableChanged().setVarName("child_gender"));
/*  943 */     lb.add(new ListenableChanged().setVarName("another_parent_role_id"));
/*  944 */     lb.add(new ListenableChanged().setVarName("baby_period_info"));
/*  945 */     lb.add(new ListenableChanged().setVarName("childhood_info"));
/*  946 */     lb.add(new ListenableChanged().setVarName("home_state"));
/*  947 */     lb.add(new xdb.logs.ListenableMap().setVarName("dressed"));
/*  948 */     lb.add(new ListenableChanged().setVarName("carry_role_id"));
/*  949 */     lb.add(new ListenableChanged().setVarName("adulthood_info"));
/*  950 */     lb.add(new ListenableChanged().setVarName("position_x"));
/*  951 */     lb.add(new ListenableChanged().setVarName("position_y"));
/*  952 */     lb.add(new ListenableChanged().setVarName("is_discard"));
/*  953 */     lb.add(new ListenableChanged().setVarName("discard_time"));
/*  954 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ChildInfo {
/*      */     private Const() {}
/*      */     
/*      */     ChildInfo nThis() {
/*  961 */       return ChildInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  967 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildInfo copy()
/*      */     {
/*  973 */       return ChildInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildInfo toData()
/*      */     {
/*  979 */       return ChildInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ChildInfo toBean()
/*      */     {
/*  984 */       return ChildInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildInfo toDataIf()
/*      */     {
/*  990 */       return ChildInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ChildInfo toBeanIf()
/*      */     {
/*  995 */       return ChildInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOwn_role_id()
/*      */     {
/* 1002 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1003 */       return ChildInfo.this.own_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChild_period()
/*      */     {
/* 1010 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1011 */       return ChildInfo.this.child_period;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getChild_name()
/*      */     {
/* 1018 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1019 */       return ChildInfo.this.child_name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getChild_nameOctets()
/*      */     {
/* 1026 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1027 */       return ChildInfo.this.getChild_nameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChild_gender()
/*      */     {
/* 1034 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1035 */       return ChildInfo.this.child_gender;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAnother_parent_role_id()
/*      */     {
/* 1042 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1043 */       return ChildInfo.this.another_parent_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.BabyPeriodInfo getBaby_period_info()
/*      */     {
/* 1050 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1051 */       return (xbean.BabyPeriodInfo)Consts.toConst(ChildInfo.this.baby_period_info);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.ChildhoodInfo getChildhood_info()
/*      */     {
/* 1058 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1059 */       return (xbean.ChildhoodInfo)Consts.toConst(ChildInfo.this.childhood_info);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHome_state()
/*      */     {
/* 1066 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1067 */       return ChildInfo.this.home_state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.DressedInfo> getDressed()
/*      */     {
/* 1074 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1075 */       return Consts.constMap(ChildInfo.this.dressed);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.DressedInfo> getDressedAsData()
/*      */     {
/* 1082 */       ChildInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1084 */       ChildInfo _o_ = ChildInfo.this;
/* 1085 */       Map<Integer, xbean.DressedInfo> dressed = new HashMap();
/* 1086 */       for (Map.Entry<Integer, xbean.DressedInfo> _e_ : _o_.dressed.entrySet())
/* 1087 */         dressed.put(_e_.getKey(), new DressedInfo.Data((xbean.DressedInfo)_e_.getValue()));
/* 1088 */       return dressed;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCarry_role_id()
/*      */     {
/* 1095 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1096 */       return ChildInfo.this.carry_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.AdulthoodInfo> getAdulthood_info()
/*      */     {
/* 1103 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1104 */       return Consts.constList(ChildInfo.this.adulthood_info);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.AdulthoodInfo> getAdulthood_infoAsData()
/*      */     {
/* 1110 */       ChildInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1112 */       ChildInfo _o_ = ChildInfo.this;
/* 1113 */       List<xbean.AdulthoodInfo> adulthood_info = new ArrayList();
/* 1114 */       for (xbean.AdulthoodInfo _v_ : _o_.adulthood_info)
/* 1115 */         adulthood_info.add(new AdulthoodInfo.Data(_v_));
/* 1116 */       return adulthood_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPosition_x()
/*      */     {
/* 1123 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1124 */       return ChildInfo.this.position_x;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPosition_y()
/*      */     {
/* 1131 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1132 */       return ChildInfo.this.position_y;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_discard()
/*      */     {
/* 1139 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1140 */       return ChildInfo.this.is_discard;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDiscard_time()
/*      */     {
/* 1147 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1148 */       return ChildInfo.this.discard_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOwn_role_id(long _v_)
/*      */     {
/* 1155 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1156 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChild_period(int _v_)
/*      */     {
/* 1163 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1164 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChild_name(String _v_)
/*      */     {
/* 1171 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1172 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChild_nameOctets(Octets _v_)
/*      */     {
/* 1179 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1180 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChild_gender(int _v_)
/*      */     {
/* 1187 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1188 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnother_parent_role_id(long _v_)
/*      */     {
/* 1195 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1196 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHome_state(int _v_)
/*      */     {
/* 1203 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1204 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCarry_role_id(long _v_)
/*      */     {
/* 1211 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1212 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPosition_x(int _v_)
/*      */     {
/* 1219 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1220 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPosition_y(int _v_)
/*      */     {
/* 1227 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1228 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_discard(boolean _v_)
/*      */     {
/* 1235 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1236 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDiscard_time(long _v_)
/*      */     {
/* 1243 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1244 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1250 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1251 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1257 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1258 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1264 */       return ChildInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1270 */       return ChildInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1276 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1277 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1283 */       return ChildInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1289 */       return ChildInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1295 */       ChildInfo.this._xdb_verify_unsafe_();
/* 1296 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1302 */       return ChildInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1308 */       return ChildInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1314 */       return ChildInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1320 */       return ChildInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1326 */       return ChildInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1332 */       return ChildInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1338 */       return ChildInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ChildInfo
/*      */   {
/*      */     private long own_role_id;
/*      */     
/*      */     private int child_period;
/*      */     
/*      */     private String child_name;
/*      */     
/*      */     private int child_gender;
/*      */     
/*      */     private long another_parent_role_id;
/*      */     
/*      */     private xbean.BabyPeriodInfo baby_period_info;
/*      */     
/*      */     private xbean.ChildhoodInfo childhood_info;
/*      */     
/*      */     private int home_state;
/*      */     
/*      */     private HashMap<Integer, xbean.DressedInfo> dressed;
/*      */     
/*      */     private long carry_role_id;
/*      */     
/*      */     private ArrayList<xbean.AdulthoodInfo> adulthood_info;
/*      */     
/*      */     private int position_x;
/*      */     
/*      */     private int position_y;
/*      */     
/*      */     private boolean is_discard;
/*      */     
/*      */     private long discard_time;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1378 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1383 */       this.child_name = "";
/* 1384 */       this.baby_period_info = new BabyPeriodInfo.Data();
/* 1385 */       this.childhood_info = new ChildhoodInfo.Data();
/* 1386 */       this.dressed = new HashMap();
/* 1387 */       this.carry_role_id = -1L;
/* 1388 */       this.adulthood_info = new ArrayList();
/* 1389 */       this.position_x = -1;
/* 1390 */       this.position_y = -1;
/* 1391 */       this.is_discard = false;
/*      */     }
/*      */     
/*      */     Data(xbean.ChildInfo _o1_)
/*      */     {
/* 1396 */       if ((_o1_ instanceof ChildInfo)) { assign((ChildInfo)_o1_);
/* 1397 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1398 */       } else if ((_o1_ instanceof ChildInfo.Const)) assign(((ChildInfo.Const)_o1_).nThis()); else {
/* 1399 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ChildInfo _o_) {
/* 1404 */       this.own_role_id = _o_.own_role_id;
/* 1405 */       this.child_period = _o_.child_period;
/* 1406 */       this.child_name = _o_.child_name;
/* 1407 */       this.child_gender = _o_.child_gender;
/* 1408 */       this.another_parent_role_id = _o_.another_parent_role_id;
/* 1409 */       this.baby_period_info = new BabyPeriodInfo.Data(_o_.baby_period_info);
/* 1410 */       this.childhood_info = new ChildhoodInfo.Data(_o_.childhood_info);
/* 1411 */       this.home_state = _o_.home_state;
/* 1412 */       this.dressed = new HashMap();
/* 1413 */       for (Map.Entry<Integer, xbean.DressedInfo> _e_ : _o_.dressed.entrySet())
/* 1414 */         this.dressed.put(_e_.getKey(), new DressedInfo.Data((xbean.DressedInfo)_e_.getValue()));
/* 1415 */       this.carry_role_id = _o_.carry_role_id;
/* 1416 */       this.adulthood_info = new ArrayList();
/* 1417 */       for (xbean.AdulthoodInfo _v_ : _o_.adulthood_info)
/* 1418 */         this.adulthood_info.add(new AdulthoodInfo.Data(_v_));
/* 1419 */       this.position_x = _o_.position_x;
/* 1420 */       this.position_y = _o_.position_y;
/* 1421 */       this.is_discard = _o_.is_discard;
/* 1422 */       this.discard_time = _o_.discard_time;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1427 */       this.own_role_id = _o_.own_role_id;
/* 1428 */       this.child_period = _o_.child_period;
/* 1429 */       this.child_name = _o_.child_name;
/* 1430 */       this.child_gender = _o_.child_gender;
/* 1431 */       this.another_parent_role_id = _o_.another_parent_role_id;
/* 1432 */       this.baby_period_info = new BabyPeriodInfo.Data(_o_.baby_period_info);
/* 1433 */       this.childhood_info = new ChildhoodInfo.Data(_o_.childhood_info);
/* 1434 */       this.home_state = _o_.home_state;
/* 1435 */       this.dressed = new HashMap();
/* 1436 */       for (Map.Entry<Integer, xbean.DressedInfo> _e_ : _o_.dressed.entrySet())
/* 1437 */         this.dressed.put(_e_.getKey(), new DressedInfo.Data((xbean.DressedInfo)_e_.getValue()));
/* 1438 */       this.carry_role_id = _o_.carry_role_id;
/* 1439 */       this.adulthood_info = new ArrayList();
/* 1440 */       for (xbean.AdulthoodInfo _v_ : _o_.adulthood_info)
/* 1441 */         this.adulthood_info.add(new AdulthoodInfo.Data(_v_));
/* 1442 */       this.position_x = _o_.position_x;
/* 1443 */       this.position_y = _o_.position_y;
/* 1444 */       this.is_discard = _o_.is_discard;
/* 1445 */       this.discard_time = _o_.discard_time;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1451 */       _os_.marshal(this.own_role_id);
/* 1452 */       _os_.marshal(this.child_period);
/* 1453 */       _os_.marshal(this.child_name, "UTF-16LE");
/* 1454 */       _os_.marshal(this.child_gender);
/* 1455 */       _os_.marshal(this.another_parent_role_id);
/* 1456 */       this.baby_period_info.marshal(_os_);
/* 1457 */       this.childhood_info.marshal(_os_);
/* 1458 */       _os_.marshal(this.home_state);
/* 1459 */       _os_.compact_uint32(this.dressed.size());
/* 1460 */       for (Map.Entry<Integer, xbean.DressedInfo> _e_ : this.dressed.entrySet())
/*      */       {
/* 1462 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1463 */         ((xbean.DressedInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1465 */       _os_.marshal(this.carry_role_id);
/* 1466 */       _os_.compact_uint32(this.adulthood_info.size());
/* 1467 */       for (xbean.AdulthoodInfo _v_ : this.adulthood_info)
/*      */       {
/* 1469 */         _v_.marshal(_os_);
/*      */       }
/* 1471 */       _os_.marshal(this.position_x);
/* 1472 */       _os_.marshal(this.position_y);
/* 1473 */       _os_.marshal(this.is_discard);
/* 1474 */       _os_.marshal(this.discard_time);
/* 1475 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1481 */       this.own_role_id = _os_.unmarshal_long();
/* 1482 */       this.child_period = _os_.unmarshal_int();
/* 1483 */       this.child_name = _os_.unmarshal_String("UTF-16LE");
/* 1484 */       this.child_gender = _os_.unmarshal_int();
/* 1485 */       this.another_parent_role_id = _os_.unmarshal_long();
/* 1486 */       this.baby_period_info.unmarshal(_os_);
/* 1487 */       this.childhood_info.unmarshal(_os_);
/* 1488 */       this.home_state = _os_.unmarshal_int();
/*      */       
/* 1490 */       int size = _os_.uncompact_uint32();
/* 1491 */       if (size >= 12)
/*      */       {
/* 1493 */         this.dressed = new HashMap(size * 2);
/*      */       }
/* 1495 */       for (; size > 0; size--)
/*      */       {
/* 1497 */         int _k_ = 0;
/* 1498 */         _k_ = _os_.unmarshal_int();
/* 1499 */         xbean.DressedInfo _v_ = xbean.Pod.newDressedInfoData();
/* 1500 */         _v_.unmarshal(_os_);
/* 1501 */         this.dressed.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1504 */       this.carry_role_id = _os_.unmarshal_long();
/* 1505 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1507 */         xbean.AdulthoodInfo _v_ = xbean.Pod.newAdulthoodInfoData();
/* 1508 */         _v_.unmarshal(_os_);
/* 1509 */         this.adulthood_info.add(_v_);
/*      */       }
/* 1511 */       this.position_x = _os_.unmarshal_int();
/* 1512 */       this.position_y = _os_.unmarshal_int();
/* 1513 */       this.is_discard = _os_.unmarshal_boolean();
/* 1514 */       this.discard_time = _os_.unmarshal_long();
/* 1515 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1521 */       int _size_ = 0;
/* 1522 */       _size_ += CodedOutputStream.computeInt64Size(1, this.own_role_id);
/* 1523 */       _size_ += CodedOutputStream.computeInt32Size(2, this.child_period);
/*      */       try
/*      */       {
/* 1526 */         _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.child_name, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/* 1530 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1532 */       _size_ += CodedOutputStream.computeInt32Size(4, this.child_gender);
/* 1533 */       _size_ += CodedOutputStream.computeInt64Size(5, this.another_parent_role_id);
/* 1534 */       _size_ += CodedOutputStream.computeMessageSize(6, this.baby_period_info);
/* 1535 */       _size_ += CodedOutputStream.computeMessageSize(8, this.childhood_info);
/* 1536 */       _size_ += CodedOutputStream.computeInt32Size(9, this.home_state);
/* 1537 */       for (Map.Entry<Integer, xbean.DressedInfo> _e_ : this.dressed.entrySet())
/*      */       {
/* 1539 */         _size_ += CodedOutputStream.computeInt32Size(10, ((Integer)_e_.getKey()).intValue());
/* 1540 */         _size_ += CodedOutputStream.computeMessageSize(10, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1542 */       _size_ += CodedOutputStream.computeInt64Size(11, this.carry_role_id);
/* 1543 */       for (xbean.AdulthoodInfo _v_ : this.adulthood_info)
/*      */       {
/* 1545 */         _size_ += CodedOutputStream.computeMessageSize(12, _v_);
/*      */       }
/* 1547 */       _size_ += CodedOutputStream.computeInt32Size(13, this.position_x);
/* 1548 */       _size_ += CodedOutputStream.computeInt32Size(14, this.position_y);
/* 1549 */       _size_ += CodedOutputStream.computeBoolSize(15, this.is_discard);
/* 1550 */       _size_ += CodedOutputStream.computeInt64Size(16, this.discard_time);
/* 1551 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1559 */         _output_.writeInt64(1, this.own_role_id);
/* 1560 */         _output_.writeInt32(2, this.child_period);
/* 1561 */         _output_.writeBytes(3, ByteString.copyFrom(this.child_name, "UTF-16LE"));
/* 1562 */         _output_.writeInt32(4, this.child_gender);
/* 1563 */         _output_.writeInt64(5, this.another_parent_role_id);
/* 1564 */         _output_.writeMessage(6, this.baby_period_info);
/* 1565 */         _output_.writeMessage(8, this.childhood_info);
/* 1566 */         _output_.writeInt32(9, this.home_state);
/* 1567 */         for (Map.Entry<Integer, xbean.DressedInfo> _e_ : this.dressed.entrySet())
/*      */         {
/* 1569 */           _output_.writeInt32(10, ((Integer)_e_.getKey()).intValue());
/* 1570 */           _output_.writeMessage(10, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1572 */         _output_.writeInt64(11, this.carry_role_id);
/* 1573 */         for (xbean.AdulthoodInfo _v_ : this.adulthood_info)
/*      */         {
/* 1575 */           _output_.writeMessage(12, _v_);
/*      */         }
/* 1577 */         _output_.writeInt32(13, this.position_x);
/* 1578 */         _output_.writeInt32(14, this.position_y);
/* 1579 */         _output_.writeBool(15, this.is_discard);
/* 1580 */         _output_.writeInt64(16, this.discard_time);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1584 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1586 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1594 */         boolean done = false;
/* 1595 */         while (!done)
/*      */         {
/* 1597 */           int tag = _input_.readTag();
/* 1598 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1602 */             done = true;
/* 1603 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1607 */             this.own_role_id = _input_.readInt64();
/* 1608 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1612 */             this.child_period = _input_.readInt32();
/* 1613 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/* 1617 */             this.child_name = _input_.readBytes().toString("UTF-16LE");
/* 1618 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1622 */             this.child_gender = _input_.readInt32();
/* 1623 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1627 */             this.another_parent_role_id = _input_.readInt64();
/* 1628 */             break;
/*      */           
/*      */ 
/*      */           case 50: 
/* 1632 */             _input_.readMessage(this.baby_period_info);
/* 1633 */             break;
/*      */           
/*      */ 
/*      */           case 66: 
/* 1637 */             _input_.readMessage(this.childhood_info);
/* 1638 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1642 */             this.home_state = _input_.readInt32();
/* 1643 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1647 */             int _k_ = 0;
/* 1648 */             _k_ = _input_.readInt32();
/* 1649 */             int readTag = _input_.readTag();
/* 1650 */             if (82 != readTag)
/*      */             {
/* 1652 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1654 */             xbean.DressedInfo _v_ = xbean.Pod.newDressedInfoData();
/* 1655 */             _input_.readMessage(_v_);
/* 1656 */             this.dressed.put(Integer.valueOf(_k_), _v_);
/* 1657 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1661 */             this.carry_role_id = _input_.readInt64();
/* 1662 */             break;
/*      */           
/*      */ 
/*      */           case 98: 
/* 1666 */             xbean.AdulthoodInfo _v_ = xbean.Pod.newAdulthoodInfoData();
/* 1667 */             _input_.readMessage(_v_);
/* 1668 */             this.adulthood_info.add(_v_);
/* 1669 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 1673 */             this.position_x = _input_.readInt32();
/* 1674 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 1678 */             this.position_y = _input_.readInt32();
/* 1679 */             break;
/*      */           
/*      */ 
/*      */           case 120: 
/* 1683 */             this.is_discard = _input_.readBool();
/* 1684 */             break;
/*      */           
/*      */ 
/*      */           case 128: 
/* 1688 */             this.discard_time = _input_.readInt64();
/* 1689 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1693 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1695 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1704 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1708 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1710 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildInfo copy()
/*      */     {
/* 1716 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildInfo toData()
/*      */     {
/* 1722 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ChildInfo toBean()
/*      */     {
/* 1727 */       return new ChildInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildInfo toDataIf()
/*      */     {
/* 1733 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ChildInfo toBeanIf()
/*      */     {
/* 1738 */       return new ChildInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1744 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1748 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1752 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1756 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1760 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1764 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1768 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOwn_role_id()
/*      */     {
/* 1775 */       return this.own_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChild_period()
/*      */     {
/* 1782 */       return this.child_period;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getChild_name()
/*      */     {
/* 1789 */       return this.child_name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getChild_nameOctets()
/*      */     {
/* 1796 */       return Octets.wrap(getChild_name(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChild_gender()
/*      */     {
/* 1803 */       return this.child_gender;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAnother_parent_role_id()
/*      */     {
/* 1810 */       return this.another_parent_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.BabyPeriodInfo getBaby_period_info()
/*      */     {
/* 1817 */       return this.baby_period_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.ChildhoodInfo getChildhood_info()
/*      */     {
/* 1824 */       return this.childhood_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHome_state()
/*      */     {
/* 1831 */       return this.home_state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.DressedInfo> getDressed()
/*      */     {
/* 1838 */       return this.dressed;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.DressedInfo> getDressedAsData()
/*      */     {
/* 1845 */       return this.dressed;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCarry_role_id()
/*      */     {
/* 1852 */       return this.carry_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.AdulthoodInfo> getAdulthood_info()
/*      */     {
/* 1859 */       return this.adulthood_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.AdulthoodInfo> getAdulthood_infoAsData()
/*      */     {
/* 1866 */       return this.adulthood_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPosition_x()
/*      */     {
/* 1873 */       return this.position_x;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPosition_y()
/*      */     {
/* 1880 */       return this.position_y;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_discard()
/*      */     {
/* 1887 */       return this.is_discard;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDiscard_time()
/*      */     {
/* 1894 */       return this.discard_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOwn_role_id(long _v_)
/*      */     {
/* 1901 */       this.own_role_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChild_period(int _v_)
/*      */     {
/* 1908 */       this.child_period = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChild_name(String _v_)
/*      */     {
/* 1915 */       if (null == _v_)
/* 1916 */         throw new NullPointerException();
/* 1917 */       this.child_name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChild_nameOctets(Octets _v_)
/*      */     {
/* 1924 */       setChild_name(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChild_gender(int _v_)
/*      */     {
/* 1931 */       this.child_gender = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnother_parent_role_id(long _v_)
/*      */     {
/* 1938 */       this.another_parent_role_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHome_state(int _v_)
/*      */     {
/* 1945 */       this.home_state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCarry_role_id(long _v_)
/*      */     {
/* 1952 */       this.carry_role_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPosition_x(int _v_)
/*      */     {
/* 1959 */       this.position_x = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPosition_y(int _v_)
/*      */     {
/* 1966 */       this.position_y = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_discard(boolean _v_)
/*      */     {
/* 1973 */       this.is_discard = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDiscard_time(long _v_)
/*      */     {
/* 1980 */       this.discard_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1986 */       if (!(_o1_ instanceof Data)) return false;
/* 1987 */       Data _o_ = (Data)_o1_;
/* 1988 */       if (this.own_role_id != _o_.own_role_id) return false;
/* 1989 */       if (this.child_period != _o_.child_period) return false;
/* 1990 */       if (!this.child_name.equals(_o_.child_name)) return false;
/* 1991 */       if (this.child_gender != _o_.child_gender) return false;
/* 1992 */       if (this.another_parent_role_id != _o_.another_parent_role_id) return false;
/* 1993 */       if (!this.baby_period_info.equals(_o_.baby_period_info)) return false;
/* 1994 */       if (!this.childhood_info.equals(_o_.childhood_info)) return false;
/* 1995 */       if (this.home_state != _o_.home_state) return false;
/* 1996 */       if (!this.dressed.equals(_o_.dressed)) return false;
/* 1997 */       if (this.carry_role_id != _o_.carry_role_id) return false;
/* 1998 */       if (!this.adulthood_info.equals(_o_.adulthood_info)) return false;
/* 1999 */       if (this.position_x != _o_.position_x) return false;
/* 2000 */       if (this.position_y != _o_.position_y) return false;
/* 2001 */       if (this.is_discard != _o_.is_discard) return false;
/* 2002 */       if (this.discard_time != _o_.discard_time) return false;
/* 2003 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 2009 */       int _h_ = 0;
/* 2010 */       _h_ = (int)(_h_ + this.own_role_id);
/* 2011 */       _h_ += this.child_period;
/* 2012 */       _h_ += this.child_name.hashCode();
/* 2013 */       _h_ += this.child_gender;
/* 2014 */       _h_ = (int)(_h_ + this.another_parent_role_id);
/* 2015 */       _h_ += this.baby_period_info.hashCode();
/* 2016 */       _h_ += this.childhood_info.hashCode();
/* 2017 */       _h_ += this.home_state;
/* 2018 */       _h_ += this.dressed.hashCode();
/* 2019 */       _h_ = (int)(_h_ + this.carry_role_id);
/* 2020 */       _h_ += this.adulthood_info.hashCode();
/* 2021 */       _h_ += this.position_x;
/* 2022 */       _h_ += this.position_y;
/* 2023 */       _h_ += (this.is_discard ? 1231 : 1237);
/* 2024 */       _h_ = (int)(_h_ + this.discard_time);
/* 2025 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2031 */       StringBuilder _sb_ = new StringBuilder();
/* 2032 */       _sb_.append("(");
/* 2033 */       _sb_.append(this.own_role_id);
/* 2034 */       _sb_.append(",");
/* 2035 */       _sb_.append(this.child_period);
/* 2036 */       _sb_.append(",");
/* 2037 */       _sb_.append("'").append(this.child_name).append("'");
/* 2038 */       _sb_.append(",");
/* 2039 */       _sb_.append(this.child_gender);
/* 2040 */       _sb_.append(",");
/* 2041 */       _sb_.append(this.another_parent_role_id);
/* 2042 */       _sb_.append(",");
/* 2043 */       _sb_.append(this.baby_period_info);
/* 2044 */       _sb_.append(",");
/* 2045 */       _sb_.append(this.childhood_info);
/* 2046 */       _sb_.append(",");
/* 2047 */       _sb_.append(this.home_state);
/* 2048 */       _sb_.append(",");
/* 2049 */       _sb_.append(this.dressed);
/* 2050 */       _sb_.append(",");
/* 2051 */       _sb_.append(this.carry_role_id);
/* 2052 */       _sb_.append(",");
/* 2053 */       _sb_.append(this.adulthood_info);
/* 2054 */       _sb_.append(",");
/* 2055 */       _sb_.append(this.position_x);
/* 2056 */       _sb_.append(",");
/* 2057 */       _sb_.append(this.position_y);
/* 2058 */       _sb_.append(",");
/* 2059 */       _sb_.append(this.is_discard);
/* 2060 */       _sb_.append(",");
/* 2061 */       _sb_.append(this.discard_time);
/* 2062 */       _sb_.append(")");
/* 2063 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChildInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */