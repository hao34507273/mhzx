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
/*     */ 
/*     */ public final class FabaoArtifactSessionInfo extends xdb.XBean implements xbean.FabaoArtifactSessionInfo
/*     */ {
/*     */   private HashMap<Integer, Long> sessions;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.sessions.clear();
/*     */   }
/*     */   
/*     */   FabaoArtifactSessionInfo(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.sessions = new HashMap();
/*     */   }
/*     */   
/*     */   public FabaoArtifactSessionInfo()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FabaoArtifactSessionInfo(FabaoArtifactSessionInfo _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FabaoArtifactSessionInfo(xbean.FabaoArtifactSessionInfo _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof FabaoArtifactSessionInfo)) { assign((FabaoArtifactSessionInfo)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FabaoArtifactSessionInfo _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.sessions = new HashMap();
/*  50 */     for (Map.Entry<Integer, Long> _e_ : _o_.sessions.entrySet()) {
/*  51 */       this.sessions.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  56 */     this.sessions = new HashMap();
/*  57 */     for (Map.Entry<Integer, Long> _e_ : _o_.sessions.entrySet()) {
/*  58 */       this.sessions.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.compact_uint32(this.sessions.size());
/*  66 */     for (Map.Entry<Integer, Long> _e_ : this.sessions.entrySet())
/*     */     {
/*  68 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  69 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*     */     
/*  79 */     int size = _os_.uncompact_uint32();
/*  80 */     if (size >= 12)
/*     */     {
/*  82 */       this.sessions = new HashMap(size * 2);
/*     */     }
/*  84 */     for (; size > 0; size--)
/*     */     {
/*  86 */       int _k_ = 0;
/*  87 */       _k_ = _os_.unmarshal_int();
/*  88 */       long _v_ = 0L;
/*  89 */       _v_ = _os_.unmarshal_long();
/*  90 */       this.sessions.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/*     */     
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     int _size_ = 0;
/* 101 */     for (Map.Entry<Integer, Long> _e_ : this.sessions.entrySet())
/*     */     {
/* 103 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 104 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getValue()).longValue());
/*     */     }
/* 106 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 115 */       for (Map.Entry<Integer, Long> _e_ : this.sessions.entrySet())
/*     */       {
/* 117 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 118 */         _output_.writeInt64(1, ((Long)_e_.getValue()).longValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 123 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 125 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 131 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 134 */       boolean done = false;
/* 135 */       while (!done)
/*     */       {
/* 137 */         int tag = _input_.readTag();
/* 138 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 142 */           done = true;
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 147 */           int _k_ = 0;
/* 148 */           _k_ = _input_.readInt32();
/* 149 */           int readTag = _input_.readTag();
/* 150 */           if (8 != readTag)
/*     */           {
/* 152 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 154 */           long _v_ = 0L;
/* 155 */           _v_ = _input_.readInt64();
/* 156 */           this.sessions.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 157 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 161 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 163 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 172 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 176 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 178 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FabaoArtifactSessionInfo copy()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new FabaoArtifactSessionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FabaoArtifactSessionInfo toData()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FabaoArtifactSessionInfo toBean()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new FabaoArtifactSessionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FabaoArtifactSessionInfo toDataIf()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FabaoArtifactSessionInfo toBeanIf()
/*     */   {
/* 210 */     _xdb_verify_unsafe_();
/* 211 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 217 */     _xdb_verify_unsafe_();
/* 218 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Long> getSessions()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return xdb.Logs.logMap(new xdb.LogKey(this, "sessions"), this.sessions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Long> getSessionsAsData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/*     */     
/* 235 */     FabaoArtifactSessionInfo _o_ = this;
/* 236 */     Map<Integer, Long> sessions = new HashMap();
/* 237 */     for (Map.Entry<Integer, Long> _e_ : _o_.sessions.entrySet())
/* 238 */       sessions.put(_e_.getKey(), _e_.getValue());
/* 239 */     return sessions;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     FabaoArtifactSessionInfo _o_ = null;
/* 247 */     if ((_o1_ instanceof FabaoArtifactSessionInfo)) { _o_ = (FabaoArtifactSessionInfo)_o1_;
/* 248 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 249 */       return false;
/* 250 */     if (!this.sessions.equals(_o_.sessions)) return false;
/* 251 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     int _h_ = 0;
/* 259 */     _h_ += this.sessions.hashCode();
/* 260 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     StringBuilder _sb_ = new StringBuilder();
/* 268 */     _sb_.append("(");
/* 269 */     _sb_.append(this.sessions);
/* 270 */     _sb_.append(")");
/* 271 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 277 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 278 */     lb.add(new xdb.logs.ListenableMap().setVarName("sessions"));
/* 279 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FabaoArtifactSessionInfo {
/*     */     private Const() {}
/*     */     
/*     */     FabaoArtifactSessionInfo nThis() {
/* 286 */       return FabaoArtifactSessionInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 292 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactSessionInfo copy()
/*     */     {
/* 298 */       return FabaoArtifactSessionInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactSessionInfo toData()
/*     */     {
/* 304 */       return FabaoArtifactSessionInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FabaoArtifactSessionInfo toBean()
/*     */     {
/* 309 */       return FabaoArtifactSessionInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactSessionInfo toDataIf()
/*     */     {
/* 315 */       return FabaoArtifactSessionInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FabaoArtifactSessionInfo toBeanIf()
/*     */     {
/* 320 */       return FabaoArtifactSessionInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getSessions()
/*     */     {
/* 327 */       FabaoArtifactSessionInfo.this._xdb_verify_unsafe_();
/* 328 */       return xdb.Consts.constMap(FabaoArtifactSessionInfo.this.sessions);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getSessionsAsData()
/*     */     {
/* 335 */       FabaoArtifactSessionInfo.this._xdb_verify_unsafe_();
/*     */       
/* 337 */       FabaoArtifactSessionInfo _o_ = FabaoArtifactSessionInfo.this;
/* 338 */       Map<Integer, Long> sessions = new HashMap();
/* 339 */       for (Map.Entry<Integer, Long> _e_ : _o_.sessions.entrySet())
/* 340 */         sessions.put(_e_.getKey(), _e_.getValue());
/* 341 */       return sessions;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 347 */       FabaoArtifactSessionInfo.this._xdb_verify_unsafe_();
/* 348 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 354 */       FabaoArtifactSessionInfo.this._xdb_verify_unsafe_();
/* 355 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 361 */       return FabaoArtifactSessionInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 367 */       return FabaoArtifactSessionInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 373 */       FabaoArtifactSessionInfo.this._xdb_verify_unsafe_();
/* 374 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 380 */       return FabaoArtifactSessionInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 386 */       return FabaoArtifactSessionInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 392 */       FabaoArtifactSessionInfo.this._xdb_verify_unsafe_();
/* 393 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 399 */       return FabaoArtifactSessionInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 405 */       return FabaoArtifactSessionInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 411 */       return FabaoArtifactSessionInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 417 */       return FabaoArtifactSessionInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 423 */       return FabaoArtifactSessionInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 429 */       return FabaoArtifactSessionInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 435 */       return FabaoArtifactSessionInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FabaoArtifactSessionInfo
/*     */   {
/*     */     private HashMap<Integer, Long> sessions;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 447 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 452 */       this.sessions = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.FabaoArtifactSessionInfo _o1_)
/*     */     {
/* 457 */       if ((_o1_ instanceof FabaoArtifactSessionInfo)) { assign((FabaoArtifactSessionInfo)_o1_);
/* 458 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 459 */       } else if ((_o1_ instanceof FabaoArtifactSessionInfo.Const)) assign(((FabaoArtifactSessionInfo.Const)_o1_).nThis()); else {
/* 460 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FabaoArtifactSessionInfo _o_) {
/* 465 */       this.sessions = new HashMap();
/* 466 */       for (Map.Entry<Integer, Long> _e_ : _o_.sessions.entrySet()) {
/* 467 */         this.sessions.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 472 */       this.sessions = new HashMap();
/* 473 */       for (Map.Entry<Integer, Long> _e_ : _o_.sessions.entrySet()) {
/* 474 */         this.sessions.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 480 */       _os_.compact_uint32(this.sessions.size());
/* 481 */       for (Map.Entry<Integer, Long> _e_ : this.sessions.entrySet())
/*     */       {
/* 483 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 484 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */       }
/* 486 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 493 */       int size = _os_.uncompact_uint32();
/* 494 */       if (size >= 12)
/*     */       {
/* 496 */         this.sessions = new HashMap(size * 2);
/*     */       }
/* 498 */       for (; size > 0; size--)
/*     */       {
/* 500 */         int _k_ = 0;
/* 501 */         _k_ = _os_.unmarshal_int();
/* 502 */         long _v_ = 0L;
/* 503 */         _v_ = _os_.unmarshal_long();
/* 504 */         this.sessions.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */       }
/*     */       
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 513 */       int _size_ = 0;
/* 514 */       for (Map.Entry<Integer, Long> _e_ : this.sessions.entrySet())
/*     */       {
/* 516 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 517 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getValue()).longValue());
/*     */       }
/* 519 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 527 */         for (Map.Entry<Integer, Long> _e_ : this.sessions.entrySet())
/*     */         {
/* 529 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 530 */           _output_.writeInt64(1, ((Long)_e_.getValue()).longValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 535 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 537 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 545 */         boolean done = false;
/* 546 */         while (!done)
/*     */         {
/* 548 */           int tag = _input_.readTag();
/* 549 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 553 */             done = true;
/* 554 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 558 */             int _k_ = 0;
/* 559 */             _k_ = _input_.readInt32();
/* 560 */             int readTag = _input_.readTag();
/* 561 */             if (8 != readTag)
/*     */             {
/* 563 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 565 */             long _v_ = 0L;
/* 566 */             _v_ = _input_.readInt64();
/* 567 */             this.sessions.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 568 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 572 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 574 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 583 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 587 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 589 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactSessionInfo copy()
/*     */     {
/* 595 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactSessionInfo toData()
/*     */     {
/* 601 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FabaoArtifactSessionInfo toBean()
/*     */     {
/* 606 */       return new FabaoArtifactSessionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FabaoArtifactSessionInfo toDataIf()
/*     */     {
/* 612 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FabaoArtifactSessionInfo toBeanIf()
/*     */     {
/* 617 */       return new FabaoArtifactSessionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 627 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 631 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 635 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 639 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 643 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 647 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getSessions()
/*     */     {
/* 654 */       return this.sessions;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getSessionsAsData()
/*     */     {
/* 661 */       return this.sessions;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 667 */       if (!(_o1_ instanceof Data)) return false;
/* 668 */       Data _o_ = (Data)_o1_;
/* 669 */       if (!this.sessions.equals(_o_.sessions)) return false;
/* 670 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 676 */       int _h_ = 0;
/* 677 */       _h_ += this.sessions.hashCode();
/* 678 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 684 */       StringBuilder _sb_ = new StringBuilder();
/* 685 */       _sb_.append("(");
/* 686 */       _sb_.append(this.sessions);
/* 687 */       _sb_.append(")");
/* 688 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FabaoArtifactSessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */