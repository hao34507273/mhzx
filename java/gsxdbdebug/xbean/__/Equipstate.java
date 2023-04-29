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
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class Equipstate extends XBean implements xbean.Equipstate
/*     */ {
/*     */   private int state;
/*     */   private HashMap<Integer, Integer> level2makecount;
/*     */   private HashMap<Integer, Integer> eqpid2makecount;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.state = 0;
/*  23 */     this.level2makecount.clear();
/*  24 */     this.eqpid2makecount.clear();
/*     */   }
/*     */   
/*     */   Equipstate(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.level2makecount = new HashMap();
/*  31 */     this.eqpid2makecount = new HashMap();
/*     */   }
/*     */   
/*     */   public Equipstate()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Equipstate(Equipstate _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Equipstate(xbean.Equipstate _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof Equipstate)) { assign((Equipstate)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Equipstate _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.state = _o_.state;
/*  57 */     this.level2makecount = new HashMap();
/*  58 */     for (Map.Entry<Integer, Integer> _e_ : _o_.level2makecount.entrySet())
/*  59 */       this.level2makecount.put(_e_.getKey(), _e_.getValue());
/*  60 */     this.eqpid2makecount = new HashMap();
/*  61 */     for (Map.Entry<Integer, Integer> _e_ : _o_.eqpid2makecount.entrySet()) {
/*  62 */       this.eqpid2makecount.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  67 */     this.state = _o_.state;
/*  68 */     this.level2makecount = new HashMap();
/*  69 */     for (Map.Entry<Integer, Integer> _e_ : _o_.level2makecount.entrySet())
/*  70 */       this.level2makecount.put(_e_.getKey(), _e_.getValue());
/*  71 */     this.eqpid2makecount = new HashMap();
/*  72 */     for (Map.Entry<Integer, Integer> _e_ : _o_.eqpid2makecount.entrySet()) {
/*  73 */       this.eqpid2makecount.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.state);
/*  81 */     _os_.compact_uint32(this.level2makecount.size());
/*  82 */     for (Map.Entry<Integer, Integer> _e_ : this.level2makecount.entrySet())
/*     */     {
/*  84 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  85 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  87 */     _os_.compact_uint32(this.eqpid2makecount.size());
/*  88 */     for (Map.Entry<Integer, Integer> _e_ : this.eqpid2makecount.entrySet())
/*     */     {
/*  90 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  91 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     this.state = _os_.unmarshal_int();
/*     */     
/* 102 */     int size = _os_.uncompact_uint32();
/* 103 */     if (size >= 12)
/*     */     {
/* 105 */       this.level2makecount = new HashMap(size * 2);
/*     */     }
/* 107 */     for (; size > 0; size--)
/*     */     {
/* 109 */       int _k_ = 0;
/* 110 */       _k_ = _os_.unmarshal_int();
/* 111 */       int _v_ = 0;
/* 112 */       _v_ = _os_.unmarshal_int();
/* 113 */       this.level2makecount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/*     */ 
/* 117 */     int size = _os_.uncompact_uint32();
/* 118 */     if (size >= 12)
/*     */     {
/* 120 */       this.eqpid2makecount = new HashMap(size * 2);
/*     */     }
/* 122 */     for (; size > 0; size--)
/*     */     {
/* 124 */       int _k_ = 0;
/* 125 */       _k_ = _os_.unmarshal_int();
/* 126 */       int _v_ = 0;
/* 127 */       _v_ = _os_.unmarshal_int();
/* 128 */       this.eqpid2makecount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 131 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     int _size_ = 0;
/* 139 */     _size_ += CodedOutputStream.computeInt32Size(1, this.state);
/* 140 */     for (Map.Entry<Integer, Integer> _e_ : this.level2makecount.entrySet())
/*     */     {
/* 142 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 143 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 145 */     for (Map.Entry<Integer, Integer> _e_ : this.eqpid2makecount.entrySet())
/*     */     {
/* 147 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 148 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 150 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 156 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 159 */       _output_.writeInt32(1, this.state);
/* 160 */       for (Map.Entry<Integer, Integer> _e_ : this.level2makecount.entrySet())
/*     */       {
/* 162 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 163 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 165 */       for (Map.Entry<Integer, Integer> _e_ : this.eqpid2makecount.entrySet())
/*     */       {
/* 167 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 168 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 173 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 175 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 184 */       boolean done = false;
/* 185 */       while (!done)
/*     */       {
/* 187 */         int tag = _input_.readTag();
/* 188 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 192 */           done = true;
/* 193 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 197 */           this.state = _input_.readInt32();
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
/* 211 */           this.level2makecount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 212 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 216 */           int _k_ = 0;
/* 217 */           _k_ = _input_.readInt32();
/* 218 */           int readTag = _input_.readTag();
/* 219 */           if (24 != readTag)
/*     */           {
/* 221 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 223 */           int _v_ = 0;
/* 224 */           _v_ = _input_.readInt32();
/* 225 */           this.eqpid2makecount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 226 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 230 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 232 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 241 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 245 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 247 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Equipstate copy()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new Equipstate(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Equipstate toData()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Equipstate toBean()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return new Equipstate(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Equipstate toDataIf()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Equipstate toBeanIf()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 286 */     _xdb_verify_unsafe_();
/* 287 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getState()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getLevel2makecount()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     return xdb.Logs.logMap(new LogKey(this, "level2makecount"), this.level2makecount);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getLevel2makecountAsData()
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/*     */     
/* 312 */     Equipstate _o_ = this;
/* 313 */     Map<Integer, Integer> level2makecount = new HashMap();
/* 314 */     for (Map.Entry<Integer, Integer> _e_ : _o_.level2makecount.entrySet())
/* 315 */       level2makecount.put(_e_.getKey(), _e_.getValue());
/* 316 */     return level2makecount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEqpid2makecount()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     return xdb.Logs.logMap(new LogKey(this, "eqpid2makecount"), this.eqpid2makecount);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEqpid2makecountAsData()
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/*     */     
/* 333 */     Equipstate _o_ = this;
/* 334 */     Map<Integer, Integer> eqpid2makecount = new HashMap();
/* 335 */     for (Map.Entry<Integer, Integer> _e_ : _o_.eqpid2makecount.entrySet())
/* 336 */       eqpid2makecount.put(_e_.getKey(), _e_.getValue());
/* 337 */     return eqpid2makecount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setState(int _v_)
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     xdb.Logs.logIf(new LogKey(this, "state")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 349 */         new xdb.logs.LogInt(this, Equipstate.this.state)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 353 */             Equipstate.this.state = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 357 */     });
/* 358 */     this.state = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     Equipstate _o_ = null;
/* 366 */     if ((_o1_ instanceof Equipstate)) { _o_ = (Equipstate)_o1_;
/* 367 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 368 */       return false;
/* 369 */     if (this.state != _o_.state) return false;
/* 370 */     if (!this.level2makecount.equals(_o_.level2makecount)) return false;
/* 371 */     if (!this.eqpid2makecount.equals(_o_.eqpid2makecount)) return false;
/* 372 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 378 */     _xdb_verify_unsafe_();
/* 379 */     int _h_ = 0;
/* 380 */     _h_ += this.state;
/* 381 */     _h_ += this.level2makecount.hashCode();
/* 382 */     _h_ += this.eqpid2makecount.hashCode();
/* 383 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     StringBuilder _sb_ = new StringBuilder();
/* 391 */     _sb_.append("(");
/* 392 */     _sb_.append(this.state);
/* 393 */     _sb_.append(",");
/* 394 */     _sb_.append(this.level2makecount);
/* 395 */     _sb_.append(",");
/* 396 */     _sb_.append(this.eqpid2makecount);
/* 397 */     _sb_.append(")");
/* 398 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 404 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 405 */     lb.add(new xdb.logs.ListenableChanged().setVarName("state"));
/* 406 */     lb.add(new xdb.logs.ListenableMap().setVarName("level2makecount"));
/* 407 */     lb.add(new xdb.logs.ListenableMap().setVarName("eqpid2makecount"));
/* 408 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Equipstate {
/*     */     private Const() {}
/*     */     
/*     */     Equipstate nThis() {
/* 415 */       return Equipstate.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Equipstate copy()
/*     */     {
/* 427 */       return Equipstate.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Equipstate toData()
/*     */     {
/* 433 */       return Equipstate.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Equipstate toBean()
/*     */     {
/* 438 */       return Equipstate.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Equipstate toDataIf()
/*     */     {
/* 444 */       return Equipstate.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Equipstate toBeanIf()
/*     */     {
/* 449 */       return Equipstate.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getState()
/*     */     {
/* 456 */       Equipstate.this._xdb_verify_unsafe_();
/* 457 */       return Equipstate.this.state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getLevel2makecount()
/*     */     {
/* 464 */       Equipstate.this._xdb_verify_unsafe_();
/* 465 */       return xdb.Consts.constMap(Equipstate.this.level2makecount);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getLevel2makecountAsData()
/*     */     {
/* 472 */       Equipstate.this._xdb_verify_unsafe_();
/*     */       
/* 474 */       Equipstate _o_ = Equipstate.this;
/* 475 */       Map<Integer, Integer> level2makecount = new HashMap();
/* 476 */       for (Map.Entry<Integer, Integer> _e_ : _o_.level2makecount.entrySet())
/* 477 */         level2makecount.put(_e_.getKey(), _e_.getValue());
/* 478 */       return level2makecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEqpid2makecount()
/*     */     {
/* 485 */       Equipstate.this._xdb_verify_unsafe_();
/* 486 */       return xdb.Consts.constMap(Equipstate.this.eqpid2makecount);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEqpid2makecountAsData()
/*     */     {
/* 493 */       Equipstate.this._xdb_verify_unsafe_();
/*     */       
/* 495 */       Equipstate _o_ = Equipstate.this;
/* 496 */       Map<Integer, Integer> eqpid2makecount = new HashMap();
/* 497 */       for (Map.Entry<Integer, Integer> _e_ : _o_.eqpid2makecount.entrySet())
/* 498 */         eqpid2makecount.put(_e_.getKey(), _e_.getValue());
/* 499 */       return eqpid2makecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setState(int _v_)
/*     */     {
/* 506 */       Equipstate.this._xdb_verify_unsafe_();
/* 507 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 513 */       Equipstate.this._xdb_verify_unsafe_();
/* 514 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 520 */       Equipstate.this._xdb_verify_unsafe_();
/* 521 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 527 */       return Equipstate.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 533 */       return Equipstate.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 539 */       Equipstate.this._xdb_verify_unsafe_();
/* 540 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 546 */       return Equipstate.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 552 */       return Equipstate.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 558 */       Equipstate.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 565 */       return Equipstate.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 571 */       return Equipstate.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 577 */       return Equipstate.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 583 */       return Equipstate.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 589 */       return Equipstate.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 595 */       return Equipstate.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 601 */       return Equipstate.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Equipstate
/*     */   {
/*     */     private int state;
/*     */     
/*     */     private HashMap<Integer, Integer> level2makecount;
/*     */     
/*     */     private HashMap<Integer, Integer> eqpid2makecount;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 617 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 622 */       this.level2makecount = new HashMap();
/* 623 */       this.eqpid2makecount = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.Equipstate _o1_)
/*     */     {
/* 628 */       if ((_o1_ instanceof Equipstate)) { assign((Equipstate)_o1_);
/* 629 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 630 */       } else if ((_o1_ instanceof Equipstate.Const)) assign(((Equipstate.Const)_o1_).nThis()); else {
/* 631 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Equipstate _o_) {
/* 636 */       this.state = _o_.state;
/* 637 */       this.level2makecount = new HashMap();
/* 638 */       for (Map.Entry<Integer, Integer> _e_ : _o_.level2makecount.entrySet())
/* 639 */         this.level2makecount.put(_e_.getKey(), _e_.getValue());
/* 640 */       this.eqpid2makecount = new HashMap();
/* 641 */       for (Map.Entry<Integer, Integer> _e_ : _o_.eqpid2makecount.entrySet()) {
/* 642 */         this.eqpid2makecount.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 647 */       this.state = _o_.state;
/* 648 */       this.level2makecount = new HashMap();
/* 649 */       for (Map.Entry<Integer, Integer> _e_ : _o_.level2makecount.entrySet())
/* 650 */         this.level2makecount.put(_e_.getKey(), _e_.getValue());
/* 651 */       this.eqpid2makecount = new HashMap();
/* 652 */       for (Map.Entry<Integer, Integer> _e_ : _o_.eqpid2makecount.entrySet()) {
/* 653 */         this.eqpid2makecount.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 659 */       _os_.marshal(this.state);
/* 660 */       _os_.compact_uint32(this.level2makecount.size());
/* 661 */       for (Map.Entry<Integer, Integer> _e_ : this.level2makecount.entrySet())
/*     */       {
/* 663 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 664 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 666 */       _os_.compact_uint32(this.eqpid2makecount.size());
/* 667 */       for (Map.Entry<Integer, Integer> _e_ : this.eqpid2makecount.entrySet())
/*     */       {
/* 669 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 670 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 672 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 678 */       this.state = _os_.unmarshal_int();
/*     */       
/* 680 */       int size = _os_.uncompact_uint32();
/* 681 */       if (size >= 12)
/*     */       {
/* 683 */         this.level2makecount = new HashMap(size * 2);
/*     */       }
/* 685 */       for (; size > 0; size--)
/*     */       {
/* 687 */         int _k_ = 0;
/* 688 */         _k_ = _os_.unmarshal_int();
/* 689 */         int _v_ = 0;
/* 690 */         _v_ = _os_.unmarshal_int();
/* 691 */         this.level2makecount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/*     */ 
/* 695 */       int size = _os_.uncompact_uint32();
/* 696 */       if (size >= 12)
/*     */       {
/* 698 */         this.eqpid2makecount = new HashMap(size * 2);
/*     */       }
/* 700 */       for (; size > 0; size--)
/*     */       {
/* 702 */         int _k_ = 0;
/* 703 */         _k_ = _os_.unmarshal_int();
/* 704 */         int _v_ = 0;
/* 705 */         _v_ = _os_.unmarshal_int();
/* 706 */         this.eqpid2makecount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 709 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 715 */       int _size_ = 0;
/* 716 */       _size_ += CodedOutputStream.computeInt32Size(1, this.state);
/* 717 */       for (Map.Entry<Integer, Integer> _e_ : this.level2makecount.entrySet())
/*     */       {
/* 719 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 720 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 722 */       for (Map.Entry<Integer, Integer> _e_ : this.eqpid2makecount.entrySet())
/*     */       {
/* 724 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 725 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 727 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 735 */         _output_.writeInt32(1, this.state);
/* 736 */         for (Map.Entry<Integer, Integer> _e_ : this.level2makecount.entrySet())
/*     */         {
/* 738 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 739 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 741 */         for (Map.Entry<Integer, Integer> _e_ : this.eqpid2makecount.entrySet())
/*     */         {
/* 743 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 744 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 749 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 751 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 759 */         boolean done = false;
/* 760 */         while (!done)
/*     */         {
/* 762 */           int tag = _input_.readTag();
/* 763 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 767 */             done = true;
/* 768 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 772 */             this.state = _input_.readInt32();
/* 773 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 777 */             int _k_ = 0;
/* 778 */             _k_ = _input_.readInt32();
/* 779 */             int readTag = _input_.readTag();
/* 780 */             if (16 != readTag)
/*     */             {
/* 782 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 784 */             int _v_ = 0;
/* 785 */             _v_ = _input_.readInt32();
/* 786 */             this.level2makecount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 791 */             int _k_ = 0;
/* 792 */             _k_ = _input_.readInt32();
/* 793 */             int readTag = _input_.readTag();
/* 794 */             if (24 != readTag)
/*     */             {
/* 796 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 798 */             int _v_ = 0;
/* 799 */             _v_ = _input_.readInt32();
/* 800 */             this.eqpid2makecount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 801 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 805 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 807 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 816 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 820 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 822 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Equipstate copy()
/*     */     {
/* 828 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Equipstate toData()
/*     */     {
/* 834 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Equipstate toBean()
/*     */     {
/* 839 */       return new Equipstate(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Equipstate toDataIf()
/*     */     {
/* 845 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Equipstate toBeanIf()
/*     */     {
/* 850 */       return new Equipstate(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 856 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 860 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 864 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 868 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 872 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 876 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 880 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getState()
/*     */     {
/* 887 */       return this.state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getLevel2makecount()
/*     */     {
/* 894 */       return this.level2makecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getLevel2makecountAsData()
/*     */     {
/* 901 */       return this.level2makecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEqpid2makecount()
/*     */     {
/* 908 */       return this.eqpid2makecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEqpid2makecountAsData()
/*     */     {
/* 915 */       return this.eqpid2makecount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setState(int _v_)
/*     */     {
/* 922 */       this.state = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 928 */       if (!(_o1_ instanceof Data)) return false;
/* 929 */       Data _o_ = (Data)_o1_;
/* 930 */       if (this.state != _o_.state) return false;
/* 931 */       if (!this.level2makecount.equals(_o_.level2makecount)) return false;
/* 932 */       if (!this.eqpid2makecount.equals(_o_.eqpid2makecount)) return false;
/* 933 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 939 */       int _h_ = 0;
/* 940 */       _h_ += this.state;
/* 941 */       _h_ += this.level2makecount.hashCode();
/* 942 */       _h_ += this.eqpid2makecount.hashCode();
/* 943 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 949 */       StringBuilder _sb_ = new StringBuilder();
/* 950 */       _sb_.append("(");
/* 951 */       _sb_.append(this.state);
/* 952 */       _sb_.append(",");
/* 953 */       _sb_.append(this.level2makecount);
/* 954 */       _sb_.append(",");
/* 955 */       _sb_.append(this.eqpid2makecount);
/* 956 */       _sb_.append(")");
/* 957 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Equipstate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */