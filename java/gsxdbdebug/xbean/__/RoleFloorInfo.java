/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class RoleFloorInfo extends xdb.XBean implements xbean.RoleFloorInfo
/*     */ {
/*     */   private HashMap<Integer, xbean.RoleSingleFloorInfo> floor2info;
/*     */   private SetX<Integer> historyfloors;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.floor2info.clear();
/*  21 */     this.historyfloors.clear();
/*     */   }
/*     */   
/*     */   RoleFloorInfo(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.floor2info = new HashMap();
/*  28 */     this.historyfloors = new SetX();
/*     */   }
/*     */   
/*     */   public RoleFloorInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleFloorInfo(RoleFloorInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleFloorInfo(xbean.RoleFloorInfo _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof RoleFloorInfo)) { assign((RoleFloorInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleFloorInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.floor2info = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.RoleSingleFloorInfo> _e_ : _o_.floor2info.entrySet())
/*  55 */       this.floor2info.put(_e_.getKey(), new RoleSingleFloorInfo((xbean.RoleSingleFloorInfo)_e_.getValue(), this, "floor2info"));
/*  56 */     this.historyfloors = new SetX();
/*  57 */     this.historyfloors.addAll(_o_.historyfloors);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.floor2info = new HashMap();
/*  63 */     for (Map.Entry<Integer, xbean.RoleSingleFloorInfo> _e_ : _o_.floor2info.entrySet())
/*  64 */       this.floor2info.put(_e_.getKey(), new RoleSingleFloorInfo((xbean.RoleSingleFloorInfo)_e_.getValue(), this, "floor2info"));
/*  65 */     this.historyfloors = new SetX();
/*  66 */     this.historyfloors.addAll(_o_.historyfloors);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.compact_uint32(this.floor2info.size());
/*  74 */     for (Map.Entry<Integer, xbean.RoleSingleFloorInfo> _e_ : this.floor2info.entrySet())
/*     */     {
/*  76 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  77 */       ((xbean.RoleSingleFloorInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  79 */     _os_.compact_uint32(this.historyfloors.size());
/*  80 */     for (Integer _v_ : this.historyfloors)
/*     */     {
/*  82 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*     */     
/*  92 */     int size = _os_.uncompact_uint32();
/*  93 */     if (size >= 12)
/*     */     {
/*  95 */       this.floor2info = new HashMap(size * 2);
/*     */     }
/*  97 */     for (; size > 0; size--)
/*     */     {
/*  99 */       int _k_ = 0;
/* 100 */       _k_ = _os_.unmarshal_int();
/* 101 */       xbean.RoleSingleFloorInfo _v_ = new RoleSingleFloorInfo(0, this, "floor2info");
/* 102 */       _v_.unmarshal(_os_);
/* 103 */       this.floor2info.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 106 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 108 */       int _v_ = 0;
/* 109 */       _v_ = _os_.unmarshal_int();
/* 110 */       this.historyfloors.add(Integer.valueOf(_v_));
/*     */     }
/* 112 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/* 119 */     int _size_ = 0;
/* 120 */     for (Map.Entry<Integer, xbean.RoleSingleFloorInfo> _e_ : this.floor2info.entrySet())
/*     */     {
/* 122 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 123 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 125 */     for (Integer _v_ : this.historyfloors)
/*     */     {
/* 127 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */     }
/* 129 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 138 */       for (Map.Entry<Integer, xbean.RoleSingleFloorInfo> _e_ : this.floor2info.entrySet())
/*     */       {
/* 140 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 141 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 143 */       for (Integer _v_ : this.historyfloors)
/*     */       {
/* 145 */         _output_.writeInt32(2, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 161 */       boolean done = false;
/* 162 */       while (!done)
/*     */       {
/* 164 */         int tag = _input_.readTag();
/* 165 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 169 */           done = true;
/* 170 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 174 */           int _k_ = 0;
/* 175 */           _k_ = _input_.readInt32();
/* 176 */           int readTag = _input_.readTag();
/* 177 */           if (10 != readTag)
/*     */           {
/* 179 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 181 */           xbean.RoleSingleFloorInfo _v_ = new RoleSingleFloorInfo(0, this, "floor2info");
/* 182 */           _input_.readMessage(_v_);
/* 183 */           this.floor2info.put(Integer.valueOf(_k_), _v_);
/* 184 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 188 */           int _v_ = 0;
/* 189 */           _v_ = _input_.readInt32();
/* 190 */           this.historyfloors.add(Integer.valueOf(_v_));
/* 191 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 195 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 197 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 206 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 210 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 212 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleFloorInfo copy()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new RoleFloorInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleFloorInfo toData()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleFloorInfo toBean()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new RoleFloorInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleFloorInfo toDataIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleFloorInfo toBeanIf()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Integer, xbean.RoleSingleFloorInfo> getFloor2info()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return xdb.Logs.logMap(new xdb.LogKey(this, "floor2info"), this.floor2info);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Integer, xbean.RoleSingleFloorInfo> getFloor2infoAsData()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/*     */     
/* 269 */     RoleFloorInfo _o_ = this;
/* 270 */     java.util.Map<Integer, xbean.RoleSingleFloorInfo> floor2info = new HashMap();
/* 271 */     for (Map.Entry<Integer, xbean.RoleSingleFloorInfo> _e_ : _o_.floor2info.entrySet())
/* 272 */       floor2info.put(_e_.getKey(), new RoleSingleFloorInfo.Data((xbean.RoleSingleFloorInfo)_e_.getValue()));
/* 273 */     return floor2info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getHistoryfloors()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return xdb.Logs.logSet(new xdb.LogKey(this, "historyfloors"), this.historyfloors);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getHistoryfloorsAsData()
/*     */   {
/* 287 */     _xdb_verify_unsafe_();
/*     */     
/* 289 */     RoleFloorInfo _o_ = this;
/* 290 */     Set<Integer> historyfloors = new SetX();
/* 291 */     historyfloors.addAll(_o_.historyfloors);
/* 292 */     return historyfloors;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     RoleFloorInfo _o_ = null;
/* 300 */     if ((_o1_ instanceof RoleFloorInfo)) { _o_ = (RoleFloorInfo)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (!this.floor2info.equals(_o_.floor2info)) return false;
/* 304 */     if (!this.historyfloors.equals(_o_.historyfloors)) return false;
/* 305 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     int _h_ = 0;
/* 313 */     _h_ += this.floor2info.hashCode();
/* 314 */     _h_ += this.historyfloors.hashCode();
/* 315 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     StringBuilder _sb_ = new StringBuilder();
/* 323 */     _sb_.append("(");
/* 324 */     _sb_.append(this.floor2info);
/* 325 */     _sb_.append(",");
/* 326 */     _sb_.append(this.historyfloors);
/* 327 */     _sb_.append(")");
/* 328 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 334 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 335 */     lb.add(new xdb.logs.ListenableMap().setVarName("floor2info"));
/* 336 */     lb.add(new xdb.logs.ListenableSet().setVarName("historyfloors"));
/* 337 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleFloorInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoleFloorInfo nThis() {
/* 344 */       return RoleFloorInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 350 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFloorInfo copy()
/*     */     {
/* 356 */       return RoleFloorInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFloorInfo toData()
/*     */     {
/* 362 */       return RoleFloorInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleFloorInfo toBean()
/*     */     {
/* 367 */       return RoleFloorInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFloorInfo toDataIf()
/*     */     {
/* 373 */       return RoleFloorInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleFloorInfo toBeanIf()
/*     */     {
/* 378 */       return RoleFloorInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, xbean.RoleSingleFloorInfo> getFloor2info()
/*     */     {
/* 385 */       RoleFloorInfo.this._xdb_verify_unsafe_();
/* 386 */       return xdb.Consts.constMap(RoleFloorInfo.this.floor2info);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, xbean.RoleSingleFloorInfo> getFloor2infoAsData()
/*     */     {
/* 393 */       RoleFloorInfo.this._xdb_verify_unsafe_();
/*     */       
/* 395 */       RoleFloorInfo _o_ = RoleFloorInfo.this;
/* 396 */       java.util.Map<Integer, xbean.RoleSingleFloorInfo> floor2info = new HashMap();
/* 397 */       for (Map.Entry<Integer, xbean.RoleSingleFloorInfo> _e_ : _o_.floor2info.entrySet())
/* 398 */         floor2info.put(_e_.getKey(), new RoleSingleFloorInfo.Data((xbean.RoleSingleFloorInfo)_e_.getValue()));
/* 399 */       return floor2info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getHistoryfloors()
/*     */     {
/* 406 */       RoleFloorInfo.this._xdb_verify_unsafe_();
/* 407 */       return xdb.Consts.constSet(RoleFloorInfo.this.historyfloors);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getHistoryfloorsAsData()
/*     */     {
/* 413 */       RoleFloorInfo.this._xdb_verify_unsafe_();
/*     */       
/* 415 */       RoleFloorInfo _o_ = RoleFloorInfo.this;
/* 416 */       Set<Integer> historyfloors = new SetX();
/* 417 */       historyfloors.addAll(_o_.historyfloors);
/* 418 */       return historyfloors;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 424 */       RoleFloorInfo.this._xdb_verify_unsafe_();
/* 425 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 431 */       RoleFloorInfo.this._xdb_verify_unsafe_();
/* 432 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 438 */       return RoleFloorInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 444 */       return RoleFloorInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 450 */       RoleFloorInfo.this._xdb_verify_unsafe_();
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 457 */       return RoleFloorInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 463 */       return RoleFloorInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 469 */       RoleFloorInfo.this._xdb_verify_unsafe_();
/* 470 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 476 */       return RoleFloorInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 482 */       return RoleFloorInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 488 */       return RoleFloorInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 494 */       return RoleFloorInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 500 */       return RoleFloorInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 506 */       return RoleFloorInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 512 */       return RoleFloorInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleFloorInfo
/*     */   {
/*     */     private HashMap<Integer, xbean.RoleSingleFloorInfo> floor2info;
/*     */     
/*     */     private HashSet<Integer> historyfloors;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 526 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 531 */       this.floor2info = new HashMap();
/* 532 */       this.historyfloors = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.RoleFloorInfo _o1_)
/*     */     {
/* 537 */       if ((_o1_ instanceof RoleFloorInfo)) { assign((RoleFloorInfo)_o1_);
/* 538 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 539 */       } else if ((_o1_ instanceof RoleFloorInfo.Const)) assign(((RoleFloorInfo.Const)_o1_).nThis()); else {
/* 540 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleFloorInfo _o_) {
/* 545 */       this.floor2info = new HashMap();
/* 546 */       for (Map.Entry<Integer, xbean.RoleSingleFloorInfo> _e_ : _o_.floor2info.entrySet())
/* 547 */         this.floor2info.put(_e_.getKey(), new RoleSingleFloorInfo.Data((xbean.RoleSingleFloorInfo)_e_.getValue()));
/* 548 */       this.historyfloors = new HashSet();
/* 549 */       this.historyfloors.addAll(_o_.historyfloors);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 554 */       this.floor2info = new HashMap();
/* 555 */       for (Map.Entry<Integer, xbean.RoleSingleFloorInfo> _e_ : _o_.floor2info.entrySet())
/* 556 */         this.floor2info.put(_e_.getKey(), new RoleSingleFloorInfo.Data((xbean.RoleSingleFloorInfo)_e_.getValue()));
/* 557 */       this.historyfloors = new HashSet();
/* 558 */       this.historyfloors.addAll(_o_.historyfloors);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 564 */       _os_.compact_uint32(this.floor2info.size());
/* 565 */       for (Map.Entry<Integer, xbean.RoleSingleFloorInfo> _e_ : this.floor2info.entrySet())
/*     */       {
/* 567 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 568 */         ((xbean.RoleSingleFloorInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 570 */       _os_.compact_uint32(this.historyfloors.size());
/* 571 */       for (Integer _v_ : this.historyfloors)
/*     */       {
/* 573 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 575 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       int size = _os_.uncompact_uint32();
/* 583 */       if (size >= 12)
/*     */       {
/* 585 */         this.floor2info = new HashMap(size * 2);
/*     */       }
/* 587 */       for (; size > 0; size--)
/*     */       {
/* 589 */         int _k_ = 0;
/* 590 */         _k_ = _os_.unmarshal_int();
/* 591 */         xbean.RoleSingleFloorInfo _v_ = xbean.Pod.newRoleSingleFloorInfoData();
/* 592 */         _v_.unmarshal(_os_);
/* 593 */         this.floor2info.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 596 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 598 */         int _v_ = 0;
/* 599 */         _v_ = _os_.unmarshal_int();
/* 600 */         this.historyfloors.add(Integer.valueOf(_v_));
/*     */       }
/* 602 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 608 */       int _size_ = 0;
/* 609 */       for (Map.Entry<Integer, xbean.RoleSingleFloorInfo> _e_ : this.floor2info.entrySet())
/*     */       {
/* 611 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 612 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 614 */       for (Integer _v_ : this.historyfloors)
/*     */       {
/* 616 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 618 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 626 */         for (Map.Entry<Integer, xbean.RoleSingleFloorInfo> _e_ : this.floor2info.entrySet())
/*     */         {
/* 628 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 629 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 631 */         for (Integer _v_ : this.historyfloors)
/*     */         {
/* 633 */           _output_.writeInt32(2, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 638 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 640 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 648 */         boolean done = false;
/* 649 */         while (!done)
/*     */         {
/* 651 */           int tag = _input_.readTag();
/* 652 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 656 */             done = true;
/* 657 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 661 */             int _k_ = 0;
/* 662 */             _k_ = _input_.readInt32();
/* 663 */             int readTag = _input_.readTag();
/* 664 */             if (10 != readTag)
/*     */             {
/* 666 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 668 */             xbean.RoleSingleFloorInfo _v_ = xbean.Pod.newRoleSingleFloorInfoData();
/* 669 */             _input_.readMessage(_v_);
/* 670 */             this.floor2info.put(Integer.valueOf(_k_), _v_);
/* 671 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 675 */             int _v_ = 0;
/* 676 */             _v_ = _input_.readInt32();
/* 677 */             this.historyfloors.add(Integer.valueOf(_v_));
/* 678 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 682 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 684 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 693 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 697 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 699 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFloorInfo copy()
/*     */     {
/* 705 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFloorInfo toData()
/*     */     {
/* 711 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleFloorInfo toBean()
/*     */     {
/* 716 */       return new RoleFloorInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFloorInfo toDataIf()
/*     */     {
/* 722 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleFloorInfo toBeanIf()
/*     */     {
/* 727 */       return new RoleFloorInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 733 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 737 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 741 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 745 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 749 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 753 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 757 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, xbean.RoleSingleFloorInfo> getFloor2info()
/*     */     {
/* 764 */       return this.floor2info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, xbean.RoleSingleFloorInfo> getFloor2infoAsData()
/*     */     {
/* 771 */       return this.floor2info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getHistoryfloors()
/*     */     {
/* 778 */       return this.historyfloors;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getHistoryfloorsAsData()
/*     */     {
/* 785 */       return this.historyfloors;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 791 */       if (!(_o1_ instanceof Data)) return false;
/* 792 */       Data _o_ = (Data)_o1_;
/* 793 */       if (!this.floor2info.equals(_o_.floor2info)) return false;
/* 794 */       if (!this.historyfloors.equals(_o_.historyfloors)) return false;
/* 795 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 801 */       int _h_ = 0;
/* 802 */       _h_ += this.floor2info.hashCode();
/* 803 */       _h_ += this.historyfloors.hashCode();
/* 804 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 810 */       StringBuilder _sb_ = new StringBuilder();
/* 811 */       _sb_.append("(");
/* 812 */       _sb_.append(this.floor2info);
/* 813 */       _sb_.append(",");
/* 814 */       _sb_.append(this.historyfloors);
/* 815 */       _sb_.append(")");
/* 816 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleFloorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */