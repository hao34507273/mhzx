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
/*     */ public final class DayTargetInfo extends XBean implements xbean.DayTargetInfo
/*     */ {
/*     */   private long lastcleartime;
/*     */   private HashMap<Integer, xbean.TargetInfo> targets;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.lastcleartime = 0L;
/*  21 */     this.targets.clear();
/*     */   }
/*     */   
/*     */   DayTargetInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.targets = new HashMap();
/*     */   }
/*     */   
/*     */   public DayTargetInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public DayTargetInfo(DayTargetInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   DayTargetInfo(xbean.DayTargetInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof DayTargetInfo)) { assign((DayTargetInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(DayTargetInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.lastcleartime = _o_.lastcleartime;
/*  53 */     this.targets = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.TargetInfo> _e_ : _o_.targets.entrySet()) {
/*  55 */       this.targets.put(_e_.getKey(), new TargetInfo((xbean.TargetInfo)_e_.getValue(), this, "targets"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  60 */     this.lastcleartime = _o_.lastcleartime;
/*  61 */     this.targets = new HashMap();
/*  62 */     for (Map.Entry<Integer, xbean.TargetInfo> _e_ : _o_.targets.entrySet()) {
/*  63 */       this.targets.put(_e_.getKey(), new TargetInfo((xbean.TargetInfo)_e_.getValue(), this, "targets"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.lastcleartime);
/*  71 */     _os_.compact_uint32(this.targets.size());
/*  72 */     for (Map.Entry<Integer, xbean.TargetInfo> _e_ : this.targets.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  75 */       ((xbean.TargetInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     this.lastcleartime = _os_.unmarshal_long();
/*     */     
/*  86 */     int size = _os_.uncompact_uint32();
/*  87 */     if (size >= 12)
/*     */     {
/*  89 */       this.targets = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       int _k_ = 0;
/*  94 */       _k_ = _os_.unmarshal_int();
/*  95 */       xbean.TargetInfo _v_ = new TargetInfo(0, this, "targets");
/*  96 */       _v_.unmarshal(_os_);
/*  97 */       this.targets.put(Integer.valueOf(_k_), _v_);
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
/* 108 */     _size_ += CodedOutputStream.computeInt64Size(1, this.lastcleartime);
/* 109 */     for (Map.Entry<Integer, xbean.TargetInfo> _e_ : this.targets.entrySet())
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
/* 123 */       _output_.writeInt64(1, this.lastcleartime);
/* 124 */       for (Map.Entry<Integer, xbean.TargetInfo> _e_ : this.targets.entrySet())
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
/* 156 */           this.lastcleartime = _input_.readInt64();
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
/* 168 */           xbean.TargetInfo _v_ = new TargetInfo(0, this, "targets");
/* 169 */           _input_.readMessage(_v_);
/* 170 */           this.targets.put(Integer.valueOf(_k_), _v_);
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
/*     */   public xbean.DayTargetInfo copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new DayTargetInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DayTargetInfo toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DayTargetInfo toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new DayTargetInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DayTargetInfo toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DayTargetInfo toBeanIf()
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
/*     */   public long getLastcleartime()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return this.lastcleartime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.TargetInfo> getTargets()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return xdb.Logs.logMap(new xdb.LogKey(this, "targets"), this.targets);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.TargetInfo> getTargetsAsData()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/*     */     
/* 257 */     DayTargetInfo _o_ = this;
/* 258 */     Map<Integer, xbean.TargetInfo> targets = new HashMap();
/* 259 */     for (Map.Entry<Integer, xbean.TargetInfo> _e_ : _o_.targets.entrySet())
/* 260 */       targets.put(_e_.getKey(), new TargetInfo.Data((xbean.TargetInfo)_e_.getValue()));
/* 261 */     return targets;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLastcleartime(long _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "lastcleartime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogLong(this, DayTargetInfo.this.lastcleartime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             DayTargetInfo.this.lastcleartime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.lastcleartime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     DayTargetInfo _o_ = null;
/* 290 */     if ((_o1_ instanceof DayTargetInfo)) { _o_ = (DayTargetInfo)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (this.lastcleartime != _o_.lastcleartime) return false;
/* 294 */     if (!this.targets.equals(_o_.targets)) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ = (int)(_h_ + this.lastcleartime);
/* 304 */     _h_ += this.targets.hashCode();
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.lastcleartime);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.targets);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableChanged().setVarName("lastcleartime"));
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("targets"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.DayTargetInfo {
/*     */     private Const() {}
/*     */     
/*     */     DayTargetInfo nThis() {
/* 334 */       return DayTargetInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DayTargetInfo copy()
/*     */     {
/* 346 */       return DayTargetInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DayTargetInfo toData()
/*     */     {
/* 352 */       return DayTargetInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.DayTargetInfo toBean()
/*     */     {
/* 357 */       return DayTargetInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DayTargetInfo toDataIf()
/*     */     {
/* 363 */       return DayTargetInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.DayTargetInfo toBeanIf()
/*     */     {
/* 368 */       return DayTargetInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLastcleartime()
/*     */     {
/* 375 */       DayTargetInfo.this._xdb_verify_unsafe_();
/* 376 */       return DayTargetInfo.this.lastcleartime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TargetInfo> getTargets()
/*     */     {
/* 383 */       DayTargetInfo.this._xdb_verify_unsafe_();
/* 384 */       return xdb.Consts.constMap(DayTargetInfo.this.targets);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TargetInfo> getTargetsAsData()
/*     */     {
/* 391 */       DayTargetInfo.this._xdb_verify_unsafe_();
/*     */       
/* 393 */       DayTargetInfo _o_ = DayTargetInfo.this;
/* 394 */       Map<Integer, xbean.TargetInfo> targets = new HashMap();
/* 395 */       for (Map.Entry<Integer, xbean.TargetInfo> _e_ : _o_.targets.entrySet())
/* 396 */         targets.put(_e_.getKey(), new TargetInfo.Data((xbean.TargetInfo)_e_.getValue()));
/* 397 */       return targets;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastcleartime(long _v_)
/*     */     {
/* 404 */       DayTargetInfo.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       DayTargetInfo.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       DayTargetInfo.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return DayTargetInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return DayTargetInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       DayTargetInfo.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return DayTargetInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return DayTargetInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       DayTargetInfo.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return DayTargetInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return DayTargetInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return DayTargetInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return DayTargetInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return DayTargetInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return DayTargetInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return DayTargetInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.DayTargetInfo
/*     */   {
/*     */     private long lastcleartime;
/*     */     
/*     */     private HashMap<Integer, xbean.TargetInfo> targets;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.targets = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.DayTargetInfo _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof DayTargetInfo)) { assign((DayTargetInfo)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof DayTargetInfo.Const)) assign(((DayTargetInfo.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(DayTargetInfo _o_) {
/* 531 */       this.lastcleartime = _o_.lastcleartime;
/* 532 */       this.targets = new HashMap();
/* 533 */       for (Map.Entry<Integer, xbean.TargetInfo> _e_ : _o_.targets.entrySet()) {
/* 534 */         this.targets.put(_e_.getKey(), new TargetInfo.Data((xbean.TargetInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 539 */       this.lastcleartime = _o_.lastcleartime;
/* 540 */       this.targets = new HashMap();
/* 541 */       for (Map.Entry<Integer, xbean.TargetInfo> _e_ : _o_.targets.entrySet()) {
/* 542 */         this.targets.put(_e_.getKey(), new TargetInfo.Data((xbean.TargetInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.marshal(this.lastcleartime);
/* 549 */       _os_.compact_uint32(this.targets.size());
/* 550 */       for (Map.Entry<Integer, xbean.TargetInfo> _e_ : this.targets.entrySet())
/*     */       {
/* 552 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 553 */         ((xbean.TargetInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 561 */       this.lastcleartime = _os_.unmarshal_long();
/*     */       
/* 563 */       int size = _os_.uncompact_uint32();
/* 564 */       if (size >= 12)
/*     */       {
/* 566 */         this.targets = new HashMap(size * 2);
/*     */       }
/* 568 */       for (; size > 0; size--)
/*     */       {
/* 570 */         int _k_ = 0;
/* 571 */         _k_ = _os_.unmarshal_int();
/* 572 */         xbean.TargetInfo _v_ = xbean.Pod.newTargetInfoData();
/* 573 */         _v_.unmarshal(_os_);
/* 574 */         this.targets.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       _size_ += CodedOutputStream.computeInt64Size(1, this.lastcleartime);
/* 585 */       for (Map.Entry<Integer, xbean.TargetInfo> _e_ : this.targets.entrySet())
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
/* 598 */         _output_.writeInt64(1, this.lastcleartime);
/* 599 */         for (Map.Entry<Integer, xbean.TargetInfo> _e_ : this.targets.entrySet())
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
/* 630 */             this.lastcleartime = _input_.readInt64();
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
/* 642 */             xbean.TargetInfo _v_ = xbean.Pod.newTargetInfoData();
/* 643 */             _input_.readMessage(_v_);
/* 644 */             this.targets.put(Integer.valueOf(_k_), _v_);
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
/*     */     public xbean.DayTargetInfo copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DayTargetInfo toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.DayTargetInfo toBean()
/*     */     {
/* 683 */       return new DayTargetInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DayTargetInfo toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.DayTargetInfo toBeanIf()
/*     */     {
/* 694 */       return new DayTargetInfo(this, null, null);
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
/*     */     public long getLastcleartime()
/*     */     {
/* 731 */       return this.lastcleartime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TargetInfo> getTargets()
/*     */     {
/* 738 */       return this.targets;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TargetInfo> getTargetsAsData()
/*     */     {
/* 745 */       return this.targets;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastcleartime(long _v_)
/*     */     {
/* 752 */       this.lastcleartime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (this.lastcleartime != _o_.lastcleartime) return false;
/* 761 */       if (!this.targets.equals(_o_.targets)) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ = (int)(_h_ + this.lastcleartime);
/* 770 */       _h_ += this.targets.hashCode();
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.lastcleartime);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.targets);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DayTargetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */