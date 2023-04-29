/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class RoleFloorActivityInfo extends XBean implements xbean.RoleFloorActivityInfo
/*     */ {
/*     */   private HashMap<Integer, xbean.RoleFloorInfo> activityinfo;
/*     */   private HashMap<Integer, Integer> helpdata;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.activityinfo.clear();
/*  21 */     this.helpdata.clear();
/*     */   }
/*     */   
/*     */   RoleFloorActivityInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.activityinfo = new HashMap();
/*  28 */     this.helpdata = new HashMap();
/*     */   }
/*     */   
/*     */   public RoleFloorActivityInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleFloorActivityInfo(RoleFloorActivityInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleFloorActivityInfo(xbean.RoleFloorActivityInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof RoleFloorActivityInfo)) { assign((RoleFloorActivityInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleFloorActivityInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.activityinfo = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.RoleFloorInfo> _e_ : _o_.activityinfo.entrySet())
/*  55 */       this.activityinfo.put(_e_.getKey(), new RoleFloorInfo((xbean.RoleFloorInfo)_e_.getValue(), this, "activityinfo"));
/*  56 */     this.helpdata = new HashMap();
/*  57 */     for (Map.Entry<Integer, Integer> _e_ : _o_.helpdata.entrySet()) {
/*  58 */       this.helpdata.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  63 */     this.activityinfo = new HashMap();
/*  64 */     for (Map.Entry<Integer, xbean.RoleFloorInfo> _e_ : _o_.activityinfo.entrySet())
/*  65 */       this.activityinfo.put(_e_.getKey(), new RoleFloorInfo((xbean.RoleFloorInfo)_e_.getValue(), this, "activityinfo"));
/*  66 */     this.helpdata = new HashMap();
/*  67 */     for (Map.Entry<Integer, Integer> _e_ : _o_.helpdata.entrySet()) {
/*  68 */       this.helpdata.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.compact_uint32(this.activityinfo.size());
/*  76 */     for (Map.Entry<Integer, xbean.RoleFloorInfo> _e_ : this.activityinfo.entrySet())
/*     */     {
/*  78 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  79 */       ((xbean.RoleFloorInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  81 */     _os_.compact_uint32(this.helpdata.size());
/*  82 */     for (Map.Entry<Integer, Integer> _e_ : this.helpdata.entrySet())
/*     */     {
/*  84 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  85 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*     */     
/*  95 */     int size = _os_.uncompact_uint32();
/*  96 */     if (size >= 12)
/*     */     {
/*  98 */       this.activityinfo = new HashMap(size * 2);
/*     */     }
/* 100 */     for (; size > 0; size--)
/*     */     {
/* 102 */       int _k_ = 0;
/* 103 */       _k_ = _os_.unmarshal_int();
/* 104 */       xbean.RoleFloorInfo _v_ = new RoleFloorInfo(0, this, "activityinfo");
/* 105 */       _v_.unmarshal(_os_);
/* 106 */       this.activityinfo.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*     */ 
/* 110 */     int size = _os_.uncompact_uint32();
/* 111 */     if (size >= 12)
/*     */     {
/* 113 */       this.helpdata = new HashMap(size * 2);
/*     */     }
/* 115 */     for (; size > 0; size--)
/*     */     {
/* 117 */       int _k_ = 0;
/* 118 */       _k_ = _os_.unmarshal_int();
/* 119 */       int _v_ = 0;
/* 120 */       _v_ = _os_.unmarshal_int();
/* 121 */       this.helpdata.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 124 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/* 131 */     int _size_ = 0;
/* 132 */     for (Map.Entry<Integer, xbean.RoleFloorInfo> _e_ : this.activityinfo.entrySet())
/*     */     {
/* 134 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 135 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 137 */     for (Map.Entry<Integer, Integer> _e_ : this.helpdata.entrySet())
/*     */     {
/* 139 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 140 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 142 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 148 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 151 */       for (Map.Entry<Integer, xbean.RoleFloorInfo> _e_ : this.activityinfo.entrySet())
/*     */       {
/* 153 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 154 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 156 */       for (Map.Entry<Integer, Integer> _e_ : this.helpdata.entrySet())
/*     */       {
/* 158 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 159 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 166 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 175 */       boolean done = false;
/* 176 */       while (!done)
/*     */       {
/* 178 */         int tag = _input_.readTag();
/* 179 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 183 */           done = true;
/* 184 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 188 */           int _k_ = 0;
/* 189 */           _k_ = _input_.readInt32();
/* 190 */           int readTag = _input_.readTag();
/* 191 */           if (10 != readTag)
/*     */           {
/* 193 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 195 */           xbean.RoleFloorInfo _v_ = new RoleFloorInfo(0, this, "activityinfo");
/* 196 */           _input_.readMessage(_v_);
/* 197 */           this.activityinfo.put(Integer.valueOf(_k_), _v_);
/* 198 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 202 */           int _k_ = 0;
/* 203 */           _k_ = _input_.readInt32();
/* 204 */           int readTag = _input_.readTag();
/* 205 */           if (16 != readTag)
/*     */           {
/* 207 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 209 */           int _v_ = 0;
/* 210 */           _v_ = _input_.readInt32();
/* 211 */           this.helpdata.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 212 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 216 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 218 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 227 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 231 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 233 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleFloorActivityInfo copy()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new RoleFloorActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleFloorActivityInfo toData()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleFloorActivityInfo toBean()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return new RoleFloorActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleFloorActivityInfo toDataIf()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleFloorActivityInfo toBeanIf()
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.RoleFloorInfo> getActivityinfo()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return xdb.Logs.logMap(new xdb.LogKey(this, "activityinfo"), this.activityinfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.RoleFloorInfo> getActivityinfoAsData()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/*     */     
/* 290 */     RoleFloorActivityInfo _o_ = this;
/* 291 */     Map<Integer, xbean.RoleFloorInfo> activityinfo = new HashMap();
/* 292 */     for (Map.Entry<Integer, xbean.RoleFloorInfo> _e_ : _o_.activityinfo.entrySet())
/* 293 */       activityinfo.put(_e_.getKey(), new RoleFloorInfo.Data((xbean.RoleFloorInfo)_e_.getValue()));
/* 294 */     return activityinfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getHelpdata()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     return xdb.Logs.logMap(new xdb.LogKey(this, "helpdata"), this.helpdata);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getHelpdataAsData()
/*     */   {
/* 309 */     _xdb_verify_unsafe_();
/*     */     
/* 311 */     RoleFloorActivityInfo _o_ = this;
/* 312 */     Map<Integer, Integer> helpdata = new HashMap();
/* 313 */     for (Map.Entry<Integer, Integer> _e_ : _o_.helpdata.entrySet())
/* 314 */       helpdata.put(_e_.getKey(), _e_.getValue());
/* 315 */     return helpdata;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     RoleFloorActivityInfo _o_ = null;
/* 323 */     if ((_o1_ instanceof RoleFloorActivityInfo)) { _o_ = (RoleFloorActivityInfo)_o1_;
/* 324 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 325 */       return false;
/* 326 */     if (!this.activityinfo.equals(_o_.activityinfo)) return false;
/* 327 */     if (!this.helpdata.equals(_o_.helpdata)) return false;
/* 328 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 334 */     _xdb_verify_unsafe_();
/* 335 */     int _h_ = 0;
/* 336 */     _h_ += this.activityinfo.hashCode();
/* 337 */     _h_ += this.helpdata.hashCode();
/* 338 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     StringBuilder _sb_ = new StringBuilder();
/* 346 */     _sb_.append("(");
/* 347 */     _sb_.append(this.activityinfo);
/* 348 */     _sb_.append(",");
/* 349 */     _sb_.append(this.helpdata);
/* 350 */     _sb_.append(")");
/* 351 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 357 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 358 */     lb.add(new xdb.logs.ListenableMap().setVarName("activityinfo"));
/* 359 */     lb.add(new xdb.logs.ListenableMap().setVarName("helpdata"));
/* 360 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleFloorActivityInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoleFloorActivityInfo nThis() {
/* 367 */       return RoleFloorActivityInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 373 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFloorActivityInfo copy()
/*     */     {
/* 379 */       return RoleFloorActivityInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFloorActivityInfo toData()
/*     */     {
/* 385 */       return RoleFloorActivityInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleFloorActivityInfo toBean()
/*     */     {
/* 390 */       return RoleFloorActivityInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFloorActivityInfo toDataIf()
/*     */     {
/* 396 */       return RoleFloorActivityInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleFloorActivityInfo toBeanIf()
/*     */     {
/* 401 */       return RoleFloorActivityInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RoleFloorInfo> getActivityinfo()
/*     */     {
/* 408 */       RoleFloorActivityInfo.this._xdb_verify_unsafe_();
/* 409 */       return xdb.Consts.constMap(RoleFloorActivityInfo.this.activityinfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RoleFloorInfo> getActivityinfoAsData()
/*     */     {
/* 416 */       RoleFloorActivityInfo.this._xdb_verify_unsafe_();
/*     */       
/* 418 */       RoleFloorActivityInfo _o_ = RoleFloorActivityInfo.this;
/* 419 */       Map<Integer, xbean.RoleFloorInfo> activityinfo = new HashMap();
/* 420 */       for (Map.Entry<Integer, xbean.RoleFloorInfo> _e_ : _o_.activityinfo.entrySet())
/* 421 */         activityinfo.put(_e_.getKey(), new RoleFloorInfo.Data((xbean.RoleFloorInfo)_e_.getValue()));
/* 422 */       return activityinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getHelpdata()
/*     */     {
/* 429 */       RoleFloorActivityInfo.this._xdb_verify_unsafe_();
/* 430 */       return xdb.Consts.constMap(RoleFloorActivityInfo.this.helpdata);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getHelpdataAsData()
/*     */     {
/* 437 */       RoleFloorActivityInfo.this._xdb_verify_unsafe_();
/*     */       
/* 439 */       RoleFloorActivityInfo _o_ = RoleFloorActivityInfo.this;
/* 440 */       Map<Integer, Integer> helpdata = new HashMap();
/* 441 */       for (Map.Entry<Integer, Integer> _e_ : _o_.helpdata.entrySet())
/* 442 */         helpdata.put(_e_.getKey(), _e_.getValue());
/* 443 */       return helpdata;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 449 */       RoleFloorActivityInfo.this._xdb_verify_unsafe_();
/* 450 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 456 */       RoleFloorActivityInfo.this._xdb_verify_unsafe_();
/* 457 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 463 */       return RoleFloorActivityInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 469 */       return RoleFloorActivityInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 475 */       RoleFloorActivityInfo.this._xdb_verify_unsafe_();
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 482 */       return RoleFloorActivityInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 488 */       return RoleFloorActivityInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 494 */       RoleFloorActivityInfo.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 501 */       return RoleFloorActivityInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 507 */       return RoleFloorActivityInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 513 */       return RoleFloorActivityInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 519 */       return RoleFloorActivityInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 525 */       return RoleFloorActivityInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 531 */       return RoleFloorActivityInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 537 */       return RoleFloorActivityInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleFloorActivityInfo
/*     */   {
/*     */     private HashMap<Integer, xbean.RoleFloorInfo> activityinfo;
/*     */     
/*     */     private HashMap<Integer, Integer> helpdata;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 556 */       this.activityinfo = new HashMap();
/* 557 */       this.helpdata = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.RoleFloorActivityInfo _o1_)
/*     */     {
/* 562 */       if ((_o1_ instanceof RoleFloorActivityInfo)) { assign((RoleFloorActivityInfo)_o1_);
/* 563 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 564 */       } else if ((_o1_ instanceof RoleFloorActivityInfo.Const)) assign(((RoleFloorActivityInfo.Const)_o1_).nThis()); else {
/* 565 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleFloorActivityInfo _o_) {
/* 570 */       this.activityinfo = new HashMap();
/* 571 */       for (Map.Entry<Integer, xbean.RoleFloorInfo> _e_ : _o_.activityinfo.entrySet())
/* 572 */         this.activityinfo.put(_e_.getKey(), new RoleFloorInfo.Data((xbean.RoleFloorInfo)_e_.getValue()));
/* 573 */       this.helpdata = new HashMap();
/* 574 */       for (Map.Entry<Integer, Integer> _e_ : _o_.helpdata.entrySet()) {
/* 575 */         this.helpdata.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 580 */       this.activityinfo = new HashMap();
/* 581 */       for (Map.Entry<Integer, xbean.RoleFloorInfo> _e_ : _o_.activityinfo.entrySet())
/* 582 */         this.activityinfo.put(_e_.getKey(), new RoleFloorInfo.Data((xbean.RoleFloorInfo)_e_.getValue()));
/* 583 */       this.helpdata = new HashMap();
/* 584 */       for (Map.Entry<Integer, Integer> _e_ : _o_.helpdata.entrySet()) {
/* 585 */         this.helpdata.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 591 */       _os_.compact_uint32(this.activityinfo.size());
/* 592 */       for (Map.Entry<Integer, xbean.RoleFloorInfo> _e_ : this.activityinfo.entrySet())
/*     */       {
/* 594 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 595 */         ((xbean.RoleFloorInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 597 */       _os_.compact_uint32(this.helpdata.size());
/* 598 */       for (Map.Entry<Integer, Integer> _e_ : this.helpdata.entrySet())
/*     */       {
/* 600 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 601 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 603 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 610 */       int size = _os_.uncompact_uint32();
/* 611 */       if (size >= 12)
/*     */       {
/* 613 */         this.activityinfo = new HashMap(size * 2);
/*     */       }
/* 615 */       for (; size > 0; size--)
/*     */       {
/* 617 */         int _k_ = 0;
/* 618 */         _k_ = _os_.unmarshal_int();
/* 619 */         xbean.RoleFloorInfo _v_ = xbean.Pod.newRoleFloorInfoData();
/* 620 */         _v_.unmarshal(_os_);
/* 621 */         this.activityinfo.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/*     */ 
/* 625 */       int size = _os_.uncompact_uint32();
/* 626 */       if (size >= 12)
/*     */       {
/* 628 */         this.helpdata = new HashMap(size * 2);
/*     */       }
/* 630 */       for (; size > 0; size--)
/*     */       {
/* 632 */         int _k_ = 0;
/* 633 */         _k_ = _os_.unmarshal_int();
/* 634 */         int _v_ = 0;
/* 635 */         _v_ = _os_.unmarshal_int();
/* 636 */         this.helpdata.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 639 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 645 */       int _size_ = 0;
/* 646 */       for (Map.Entry<Integer, xbean.RoleFloorInfo> _e_ : this.activityinfo.entrySet())
/*     */       {
/* 648 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 649 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 651 */       for (Map.Entry<Integer, Integer> _e_ : this.helpdata.entrySet())
/*     */       {
/* 653 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 654 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 656 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 664 */         for (Map.Entry<Integer, xbean.RoleFloorInfo> _e_ : this.activityinfo.entrySet())
/*     */         {
/* 666 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 667 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 669 */         for (Map.Entry<Integer, Integer> _e_ : this.helpdata.entrySet())
/*     */         {
/* 671 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 672 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 677 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 679 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 687 */         boolean done = false;
/* 688 */         while (!done)
/*     */         {
/* 690 */           int tag = _input_.readTag();
/* 691 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 695 */             done = true;
/* 696 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 700 */             int _k_ = 0;
/* 701 */             _k_ = _input_.readInt32();
/* 702 */             int readTag = _input_.readTag();
/* 703 */             if (10 != readTag)
/*     */             {
/* 705 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 707 */             xbean.RoleFloorInfo _v_ = xbean.Pod.newRoleFloorInfoData();
/* 708 */             _input_.readMessage(_v_);
/* 709 */             this.activityinfo.put(Integer.valueOf(_k_), _v_);
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 714 */             int _k_ = 0;
/* 715 */             _k_ = _input_.readInt32();
/* 716 */             int readTag = _input_.readTag();
/* 717 */             if (16 != readTag)
/*     */             {
/* 719 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 721 */             int _v_ = 0;
/* 722 */             _v_ = _input_.readInt32();
/* 723 */             this.helpdata.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 724 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 728 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 730 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 739 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 743 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 745 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFloorActivityInfo copy()
/*     */     {
/* 751 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFloorActivityInfo toData()
/*     */     {
/* 757 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleFloorActivityInfo toBean()
/*     */     {
/* 762 */       return new RoleFloorActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFloorActivityInfo toDataIf()
/*     */     {
/* 768 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleFloorActivityInfo toBeanIf()
/*     */     {
/* 773 */       return new RoleFloorActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 795 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 799 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 803 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RoleFloorInfo> getActivityinfo()
/*     */     {
/* 810 */       return this.activityinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RoleFloorInfo> getActivityinfoAsData()
/*     */     {
/* 817 */       return this.activityinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getHelpdata()
/*     */     {
/* 824 */       return this.helpdata;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getHelpdataAsData()
/*     */     {
/* 831 */       return this.helpdata;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 837 */       if (!(_o1_ instanceof Data)) return false;
/* 838 */       Data _o_ = (Data)_o1_;
/* 839 */       if (!this.activityinfo.equals(_o_.activityinfo)) return false;
/* 840 */       if (!this.helpdata.equals(_o_.helpdata)) return false;
/* 841 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 847 */       int _h_ = 0;
/* 848 */       _h_ += this.activityinfo.hashCode();
/* 849 */       _h_ += this.helpdata.hashCode();
/* 850 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 856 */       StringBuilder _sb_ = new StringBuilder();
/* 857 */       _sb_.append("(");
/* 858 */       _sb_.append(this.activityinfo);
/* 859 */       _sb_.append(",");
/* 860 */       _sb_.append(this.helpdata);
/* 861 */       _sb_.append(")");
/* 862 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleFloorActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */