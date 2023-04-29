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
/*     */ public final class AllLostExpInfo extends XBean implements xbean.AllLostExpInfo
/*     */ {
/*     */   private HashMap<Integer, xbean.LostExpInfo> activityid2lostexpinfo;
/*     */   private long lastupdatetime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.activityid2lostexpinfo.clear();
/*  21 */     this.lastupdatetime = 0L;
/*     */   }
/*     */   
/*     */   AllLostExpInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.activityid2lostexpinfo = new HashMap();
/*  28 */     this.lastupdatetime = 0L;
/*     */   }
/*     */   
/*     */   public AllLostExpInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public AllLostExpInfo(AllLostExpInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   AllLostExpInfo(xbean.AllLostExpInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof AllLostExpInfo)) { assign((AllLostExpInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(AllLostExpInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.activityid2lostexpinfo = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.LostExpInfo> _e_ : _o_.activityid2lostexpinfo.entrySet())
/*  55 */       this.activityid2lostexpinfo.put(_e_.getKey(), new LostExpInfo((xbean.LostExpInfo)_e_.getValue(), this, "activityid2lostexpinfo"));
/*  56 */     this.lastupdatetime = _o_.lastupdatetime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.activityid2lostexpinfo = new HashMap();
/*  62 */     for (Map.Entry<Integer, xbean.LostExpInfo> _e_ : _o_.activityid2lostexpinfo.entrySet())
/*  63 */       this.activityid2lostexpinfo.put(_e_.getKey(), new LostExpInfo((xbean.LostExpInfo)_e_.getValue(), this, "activityid2lostexpinfo"));
/*  64 */     this.lastupdatetime = _o_.lastupdatetime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.compact_uint32(this.activityid2lostexpinfo.size());
/*  72 */     for (Map.Entry<Integer, xbean.LostExpInfo> _e_ : this.activityid2lostexpinfo.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  75 */       ((xbean.LostExpInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  77 */     _os_.marshal(this.lastupdatetime);
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*     */     
/*  86 */     int size = _os_.uncompact_uint32();
/*  87 */     if (size >= 12)
/*     */     {
/*  89 */       this.activityid2lostexpinfo = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       int _k_ = 0;
/*  94 */       _k_ = _os_.unmarshal_int();
/*  95 */       xbean.LostExpInfo _v_ = new LostExpInfo(0, this, "activityid2lostexpinfo");
/*  96 */       _v_.unmarshal(_os_);
/*  97 */       this.activityid2lostexpinfo.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 100 */     this.lastupdatetime = _os_.unmarshal_long();
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int _size_ = 0;
/* 109 */     for (Map.Entry<Integer, xbean.LostExpInfo> _e_ : this.activityid2lostexpinfo.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 112 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 114 */     _size_ += CodedOutputStream.computeInt64Size(2, this.lastupdatetime);
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       for (Map.Entry<Integer, xbean.LostExpInfo> _e_ : this.activityid2lostexpinfo.entrySet())
/*     */       {
/* 126 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 127 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 129 */       _output_.writeInt64(2, this.lastupdatetime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 133 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 135 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 144 */       boolean done = false;
/* 145 */       while (!done)
/*     */       {
/* 147 */         int tag = _input_.readTag();
/* 148 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 152 */           done = true;
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 157 */           int _k_ = 0;
/* 158 */           _k_ = _input_.readInt32();
/* 159 */           int readTag = _input_.readTag();
/* 160 */           if (10 != readTag)
/*     */           {
/* 162 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 164 */           xbean.LostExpInfo _v_ = new LostExpInfo(0, this, "activityid2lostexpinfo");
/* 165 */           _input_.readMessage(_v_);
/* 166 */           this.activityid2lostexpinfo.put(Integer.valueOf(_k_), _v_);
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 171 */           this.lastupdatetime = _input_.readInt64();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AllLostExpInfo copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new AllLostExpInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AllLostExpInfo toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AllLostExpInfo toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new AllLostExpInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AllLostExpInfo toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AllLostExpInfo toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.LostExpInfo> getActivityid2lostexpinfo()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return xdb.Logs.logMap(new xdb.LogKey(this, "activityid2lostexpinfo"), this.activityid2lostexpinfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.LostExpInfo> getActivityid2lostexpinfoAsData()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/*     */     
/* 250 */     AllLostExpInfo _o_ = this;
/* 251 */     Map<Integer, xbean.LostExpInfo> activityid2lostexpinfo = new HashMap();
/* 252 */     for (Map.Entry<Integer, xbean.LostExpInfo> _e_ : _o_.activityid2lostexpinfo.entrySet())
/* 253 */       activityid2lostexpinfo.put(_e_.getKey(), new LostExpInfo.Data((xbean.LostExpInfo)_e_.getValue()));
/* 254 */     return activityid2lostexpinfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLastupdatetime()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.lastupdatetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLastupdatetime(long _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new xdb.LogKey(this, "lastupdatetime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogLong(this, AllLostExpInfo.this.lastupdatetime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             AllLostExpInfo.this.lastupdatetime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.lastupdatetime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     AllLostExpInfo _o_ = null;
/* 291 */     if ((_o1_ instanceof AllLostExpInfo)) { _o_ = (AllLostExpInfo)_o1_;
/* 292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 293 */       return false;
/* 294 */     if (!this.activityid2lostexpinfo.equals(_o_.activityid2lostexpinfo)) return false;
/* 295 */     if (this.lastupdatetime != _o_.lastupdatetime) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ += this.activityid2lostexpinfo.hashCode();
/* 305 */     _h_ = (int)(_h_ + this.lastupdatetime);
/* 306 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     StringBuilder _sb_ = new StringBuilder();
/* 314 */     _sb_.append("(");
/* 315 */     _sb_.append(this.activityid2lostexpinfo);
/* 316 */     _sb_.append(",");
/* 317 */     _sb_.append(this.lastupdatetime);
/* 318 */     _sb_.append(")");
/* 319 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 325 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("activityid2lostexpinfo"));
/* 327 */     lb.add(new xdb.logs.ListenableChanged().setVarName("lastupdatetime"));
/* 328 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.AllLostExpInfo {
/*     */     private Const() {}
/*     */     
/*     */     AllLostExpInfo nThis() {
/* 335 */       return AllLostExpInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AllLostExpInfo copy()
/*     */     {
/* 347 */       return AllLostExpInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AllLostExpInfo toData()
/*     */     {
/* 353 */       return AllLostExpInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.AllLostExpInfo toBean()
/*     */     {
/* 358 */       return AllLostExpInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AllLostExpInfo toDataIf()
/*     */     {
/* 364 */       return AllLostExpInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.AllLostExpInfo toBeanIf()
/*     */     {
/* 369 */       return AllLostExpInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.LostExpInfo> getActivityid2lostexpinfo()
/*     */     {
/* 376 */       AllLostExpInfo.this._xdb_verify_unsafe_();
/* 377 */       return xdb.Consts.constMap(AllLostExpInfo.this.activityid2lostexpinfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.LostExpInfo> getActivityid2lostexpinfoAsData()
/*     */     {
/* 384 */       AllLostExpInfo.this._xdb_verify_unsafe_();
/*     */       
/* 386 */       AllLostExpInfo _o_ = AllLostExpInfo.this;
/* 387 */       Map<Integer, xbean.LostExpInfo> activityid2lostexpinfo = new HashMap();
/* 388 */       for (Map.Entry<Integer, xbean.LostExpInfo> _e_ : _o_.activityid2lostexpinfo.entrySet())
/* 389 */         activityid2lostexpinfo.put(_e_.getKey(), new LostExpInfo.Data((xbean.LostExpInfo)_e_.getValue()));
/* 390 */       return activityid2lostexpinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLastupdatetime()
/*     */     {
/* 397 */       AllLostExpInfo.this._xdb_verify_unsafe_();
/* 398 */       return AllLostExpInfo.this.lastupdatetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastupdatetime(long _v_)
/*     */     {
/* 405 */       AllLostExpInfo.this._xdb_verify_unsafe_();
/* 406 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 412 */       AllLostExpInfo.this._xdb_verify_unsafe_();
/* 413 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 419 */       AllLostExpInfo.this._xdb_verify_unsafe_();
/* 420 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 426 */       return AllLostExpInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 432 */       return AllLostExpInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 438 */       AllLostExpInfo.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 445 */       return AllLostExpInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 451 */       return AllLostExpInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 457 */       AllLostExpInfo.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 464 */       return AllLostExpInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 470 */       return AllLostExpInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 476 */       return AllLostExpInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 482 */       return AllLostExpInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 488 */       return AllLostExpInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 494 */       return AllLostExpInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 500 */       return AllLostExpInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.AllLostExpInfo
/*     */   {
/*     */     private HashMap<Integer, xbean.LostExpInfo> activityid2lostexpinfo;
/*     */     
/*     */     private long lastupdatetime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 519 */       this.activityid2lostexpinfo = new HashMap();
/* 520 */       this.lastupdatetime = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.AllLostExpInfo _o1_)
/*     */     {
/* 525 */       if ((_o1_ instanceof AllLostExpInfo)) { assign((AllLostExpInfo)_o1_);
/* 526 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 527 */       } else if ((_o1_ instanceof AllLostExpInfo.Const)) assign(((AllLostExpInfo.Const)_o1_).nThis()); else {
/* 528 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(AllLostExpInfo _o_) {
/* 533 */       this.activityid2lostexpinfo = new HashMap();
/* 534 */       for (Map.Entry<Integer, xbean.LostExpInfo> _e_ : _o_.activityid2lostexpinfo.entrySet())
/* 535 */         this.activityid2lostexpinfo.put(_e_.getKey(), new LostExpInfo.Data((xbean.LostExpInfo)_e_.getValue()));
/* 536 */       this.lastupdatetime = _o_.lastupdatetime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 541 */       this.activityid2lostexpinfo = new HashMap();
/* 542 */       for (Map.Entry<Integer, xbean.LostExpInfo> _e_ : _o_.activityid2lostexpinfo.entrySet())
/* 543 */         this.activityid2lostexpinfo.put(_e_.getKey(), new LostExpInfo.Data((xbean.LostExpInfo)_e_.getValue()));
/* 544 */       this.lastupdatetime = _o_.lastupdatetime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       _os_.compact_uint32(this.activityid2lostexpinfo.size());
/* 551 */       for (Map.Entry<Integer, xbean.LostExpInfo> _e_ : this.activityid2lostexpinfo.entrySet())
/*     */       {
/* 553 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 554 */         ((xbean.LostExpInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 556 */       _os_.marshal(this.lastupdatetime);
/* 557 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 564 */       int size = _os_.uncompact_uint32();
/* 565 */       if (size >= 12)
/*     */       {
/* 567 */         this.activityid2lostexpinfo = new HashMap(size * 2);
/*     */       }
/* 569 */       for (; size > 0; size--)
/*     */       {
/* 571 */         int _k_ = 0;
/* 572 */         _k_ = _os_.unmarshal_int();
/* 573 */         xbean.LostExpInfo _v_ = xbean.Pod.newLostExpInfoData();
/* 574 */         _v_.unmarshal(_os_);
/* 575 */         this.activityid2lostexpinfo.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 578 */       this.lastupdatetime = _os_.unmarshal_long();
/* 579 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 585 */       int _size_ = 0;
/* 586 */       for (Map.Entry<Integer, xbean.LostExpInfo> _e_ : this.activityid2lostexpinfo.entrySet())
/*     */       {
/* 588 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 589 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 591 */       _size_ += CodedOutputStream.computeInt64Size(2, this.lastupdatetime);
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         for (Map.Entry<Integer, xbean.LostExpInfo> _e_ : this.activityid2lostexpinfo.entrySet())
/*     */         {
/* 602 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 603 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 605 */         _output_.writeInt64(2, this.lastupdatetime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             int _k_ = 0;
/* 633 */             _k_ = _input_.readInt32();
/* 634 */             int readTag = _input_.readTag();
/* 635 */             if (10 != readTag)
/*     */             {
/* 637 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 639 */             xbean.LostExpInfo _v_ = xbean.Pod.newLostExpInfoData();
/* 640 */             _input_.readMessage(_v_);
/* 641 */             this.activityid2lostexpinfo.put(Integer.valueOf(_k_), _v_);
/* 642 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 646 */             this.lastupdatetime = _input_.readInt64();
/* 647 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 651 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 653 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 662 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 666 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 668 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AllLostExpInfo copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AllLostExpInfo toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.AllLostExpInfo toBean()
/*     */     {
/* 685 */       return new AllLostExpInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AllLostExpInfo toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.AllLostExpInfo toBeanIf()
/*     */     {
/* 696 */       return new AllLostExpInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 718 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 722 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 726 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.LostExpInfo> getActivityid2lostexpinfo()
/*     */     {
/* 733 */       return this.activityid2lostexpinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.LostExpInfo> getActivityid2lostexpinfoAsData()
/*     */     {
/* 740 */       return this.activityid2lostexpinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLastupdatetime()
/*     */     {
/* 747 */       return this.lastupdatetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastupdatetime(long _v_)
/*     */     {
/* 754 */       this.lastupdatetime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 760 */       if (!(_o1_ instanceof Data)) return false;
/* 761 */       Data _o_ = (Data)_o1_;
/* 762 */       if (!this.activityid2lostexpinfo.equals(_o_.activityid2lostexpinfo)) return false;
/* 763 */       if (this.lastupdatetime != _o_.lastupdatetime) return false;
/* 764 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 770 */       int _h_ = 0;
/* 771 */       _h_ += this.activityid2lostexpinfo.hashCode();
/* 772 */       _h_ = (int)(_h_ + this.lastupdatetime);
/* 773 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 779 */       StringBuilder _sb_ = new StringBuilder();
/* 780 */       _sb_.append("(");
/* 781 */       _sb_.append(this.activityid2lostexpinfo);
/* 782 */       _sb_.append(",");
/* 783 */       _sb_.append(this.lastupdatetime);
/* 784 */       _sb_.append(")");
/* 785 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AllLostExpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */