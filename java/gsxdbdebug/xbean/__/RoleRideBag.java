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
/*     */ public final class RoleRideBag extends XBean implements xbean.RoleRideBag
/*     */ {
/*     */   private int mountid;
/*     */   private HashMap<Integer, xbean.RideInfo> ridemap;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.mountid = 0;
/*  21 */     this.ridemap.clear();
/*     */   }
/*     */   
/*     */   RoleRideBag(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.ridemap = new HashMap();
/*     */   }
/*     */   
/*     */   public RoleRideBag()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleRideBag(RoleRideBag _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleRideBag(xbean.RoleRideBag _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof RoleRideBag)) { assign((RoleRideBag)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleRideBag _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.mountid = _o_.mountid;
/*  53 */     this.ridemap = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.RideInfo> _e_ : _o_.ridemap.entrySet()) {
/*  55 */       this.ridemap.put(_e_.getKey(), new RideInfo((xbean.RideInfo)_e_.getValue(), this, "ridemap"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  60 */     this.mountid = _o_.mountid;
/*  61 */     this.ridemap = new HashMap();
/*  62 */     for (Map.Entry<Integer, xbean.RideInfo> _e_ : _o_.ridemap.entrySet()) {
/*  63 */       this.ridemap.put(_e_.getKey(), new RideInfo((xbean.RideInfo)_e_.getValue(), this, "ridemap"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.mountid);
/*  71 */     _os_.compact_uint32(this.ridemap.size());
/*  72 */     for (Map.Entry<Integer, xbean.RideInfo> _e_ : this.ridemap.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  75 */       ((xbean.RideInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     this.mountid = _os_.unmarshal_int();
/*     */     
/*  86 */     int size = _os_.uncompact_uint32();
/*  87 */     if (size >= 12)
/*     */     {
/*  89 */       this.ridemap = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       int _k_ = 0;
/*  94 */       _k_ = _os_.unmarshal_int();
/*  95 */       xbean.RideInfo _v_ = new RideInfo(0, this, "ridemap");
/*  96 */       _v_.unmarshal(_os_);
/*  97 */       this.ridemap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     _size_ += CodedOutputStream.computeInt32Size(1, this.mountid);
/* 109 */     for (Map.Entry<Integer, xbean.RideInfo> _e_ : this.ridemap.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 112 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 114 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       _output_.writeInt32(1, this.mountid);
/* 124 */       for (Map.Entry<Integer, xbean.RideInfo> _e_ : this.ridemap.entrySet())
/*     */       {
/* 126 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 127 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 132 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 134 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 143 */       boolean done = false;
/* 144 */       while (!done)
/*     */       {
/* 146 */         int tag = _input_.readTag();
/* 147 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 151 */           done = true;
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 156 */           this.mountid = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 161 */           int _k_ = 0;
/* 162 */           _k_ = _input_.readInt32();
/* 163 */           int readTag = _input_.readTag();
/* 164 */           if (18 != readTag)
/*     */           {
/* 166 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 168 */           xbean.RideInfo _v_ = new RideInfo(0, this, "ridemap");
/* 169 */           _input_.readMessage(_v_);
/* 170 */           this.ridemap.put(Integer.valueOf(_k_), _v_);
/* 171 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 175 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 177 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 186 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 190 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 192 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleRideBag copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new RoleRideBag(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleRideBag toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleRideBag toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new RoleRideBag(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleRideBag toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleRideBag toBeanIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMountid()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return this.mountid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.RideInfo> getRidemap()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return xdb.Logs.logMap(new xdb.LogKey(this, "ridemap"), this.ridemap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.RideInfo> getRidemapAsData()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/*     */     
/* 257 */     RoleRideBag _o_ = this;
/* 258 */     Map<Integer, xbean.RideInfo> ridemap = new HashMap();
/* 259 */     for (Map.Entry<Integer, xbean.RideInfo> _e_ : _o_.ridemap.entrySet())
/* 260 */       ridemap.put(_e_.getKey(), new RideInfo.Data((xbean.RideInfo)_e_.getValue()));
/* 261 */     return ridemap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMountid(int _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "mountid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogInt(this, RoleRideBag.this.mountid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             RoleRideBag.this.mountid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.mountid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     RoleRideBag _o_ = null;
/* 290 */     if ((_o1_ instanceof RoleRideBag)) { _o_ = (RoleRideBag)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (this.mountid != _o_.mountid) return false;
/* 294 */     if (!this.ridemap.equals(_o_.ridemap)) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ += this.mountid;
/* 304 */     _h_ += this.ridemap.hashCode();
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.mountid);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.ridemap);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableChanged().setVarName("mountid"));
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("ridemap"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleRideBag {
/*     */     private Const() {}
/*     */     
/*     */     RoleRideBag nThis() {
/* 334 */       return RoleRideBag.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleRideBag copy()
/*     */     {
/* 346 */       return RoleRideBag.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleRideBag toData()
/*     */     {
/* 352 */       return RoleRideBag.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleRideBag toBean()
/*     */     {
/* 357 */       return RoleRideBag.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleRideBag toDataIf()
/*     */     {
/* 363 */       return RoleRideBag.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleRideBag toBeanIf()
/*     */     {
/* 368 */       return RoleRideBag.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMountid()
/*     */     {
/* 375 */       RoleRideBag.this._xdb_verify_unsafe_();
/* 376 */       return RoleRideBag.this.mountid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RideInfo> getRidemap()
/*     */     {
/* 383 */       RoleRideBag.this._xdb_verify_unsafe_();
/* 384 */       return xdb.Consts.constMap(RoleRideBag.this.ridemap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RideInfo> getRidemapAsData()
/*     */     {
/* 391 */       RoleRideBag.this._xdb_verify_unsafe_();
/*     */       
/* 393 */       RoleRideBag _o_ = RoleRideBag.this;
/* 394 */       Map<Integer, xbean.RideInfo> ridemap = new HashMap();
/* 395 */       for (Map.Entry<Integer, xbean.RideInfo> _e_ : _o_.ridemap.entrySet())
/* 396 */         ridemap.put(_e_.getKey(), new RideInfo.Data((xbean.RideInfo)_e_.getValue()));
/* 397 */       return ridemap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMountid(int _v_)
/*     */     {
/* 404 */       RoleRideBag.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       RoleRideBag.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       RoleRideBag.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return RoleRideBag.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return RoleRideBag.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       RoleRideBag.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return RoleRideBag.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return RoleRideBag.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       RoleRideBag.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return RoleRideBag.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return RoleRideBag.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return RoleRideBag.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return RoleRideBag.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return RoleRideBag.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return RoleRideBag.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return RoleRideBag.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleRideBag
/*     */   {
/*     */     private int mountid;
/*     */     
/*     */     private HashMap<Integer, xbean.RideInfo> ridemap;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.ridemap = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.RoleRideBag _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof RoleRideBag)) { assign((RoleRideBag)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof RoleRideBag.Const)) assign(((RoleRideBag.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleRideBag _o_) {
/* 531 */       this.mountid = _o_.mountid;
/* 532 */       this.ridemap = new HashMap();
/* 533 */       for (Map.Entry<Integer, xbean.RideInfo> _e_ : _o_.ridemap.entrySet()) {
/* 534 */         this.ridemap.put(_e_.getKey(), new RideInfo.Data((xbean.RideInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 539 */       this.mountid = _o_.mountid;
/* 540 */       this.ridemap = new HashMap();
/* 541 */       for (Map.Entry<Integer, xbean.RideInfo> _e_ : _o_.ridemap.entrySet()) {
/* 542 */         this.ridemap.put(_e_.getKey(), new RideInfo.Data((xbean.RideInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.marshal(this.mountid);
/* 549 */       _os_.compact_uint32(this.ridemap.size());
/* 550 */       for (Map.Entry<Integer, xbean.RideInfo> _e_ : this.ridemap.entrySet())
/*     */       {
/* 552 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 553 */         ((xbean.RideInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 561 */       this.mountid = _os_.unmarshal_int();
/*     */       
/* 563 */       int size = _os_.uncompact_uint32();
/* 564 */       if (size >= 12)
/*     */       {
/* 566 */         this.ridemap = new HashMap(size * 2);
/*     */       }
/* 568 */       for (; size > 0; size--)
/*     */       {
/* 570 */         int _k_ = 0;
/* 571 */         _k_ = _os_.unmarshal_int();
/* 572 */         xbean.RideInfo _v_ = xbean.Pod.newRideInfoData();
/* 573 */         _v_.unmarshal(_os_);
/* 574 */         this.ridemap.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       _size_ += CodedOutputStream.computeInt32Size(1, this.mountid);
/* 585 */       for (Map.Entry<Integer, xbean.RideInfo> _e_ : this.ridemap.entrySet())
/*     */       {
/* 587 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 588 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 590 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 598 */         _output_.writeInt32(1, this.mountid);
/* 599 */         for (Map.Entry<Integer, xbean.RideInfo> _e_ : this.ridemap.entrySet())
/*     */         {
/* 601 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 602 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 607 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 609 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 617 */         boolean done = false;
/* 618 */         while (!done)
/*     */         {
/* 620 */           int tag = _input_.readTag();
/* 621 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 625 */             done = true;
/* 626 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 630 */             this.mountid = _input_.readInt32();
/* 631 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 635 */             int _k_ = 0;
/* 636 */             _k_ = _input_.readInt32();
/* 637 */             int readTag = _input_.readTag();
/* 638 */             if (18 != readTag)
/*     */             {
/* 640 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 642 */             xbean.RideInfo _v_ = xbean.Pod.newRideInfoData();
/* 643 */             _input_.readMessage(_v_);
/* 644 */             this.ridemap.put(Integer.valueOf(_k_), _v_);
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleRideBag copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleRideBag toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleRideBag toBean()
/*     */     {
/* 683 */       return new RoleRideBag(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleRideBag toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleRideBag toBeanIf()
/*     */     {
/* 694 */       return new RoleRideBag(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMountid()
/*     */     {
/* 731 */       return this.mountid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RideInfo> getRidemap()
/*     */     {
/* 738 */       return this.ridemap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RideInfo> getRidemapAsData()
/*     */     {
/* 745 */       return this.ridemap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMountid(int _v_)
/*     */     {
/* 752 */       this.mountid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (this.mountid != _o_.mountid) return false;
/* 761 */       if (!this.ridemap.equals(_o_.ridemap)) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ += this.mountid;
/* 770 */       _h_ += this.ridemap.hashCode();
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.mountid);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.ridemap);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleRideBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */