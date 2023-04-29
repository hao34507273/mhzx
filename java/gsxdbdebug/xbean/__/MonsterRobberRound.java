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
/*     */ public final class MonsterRobberRound extends XBean implements xbean.MonsterRobberRound
/*     */ {
/*     */   private HashMap<Integer, Integer> deadmonsterandcount;
/*     */   private boolean isaward;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.deadmonsterandcount.clear();
/*  21 */     this.isaward = false;
/*     */   }
/*     */   
/*     */   MonsterRobberRound(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.deadmonsterandcount = new HashMap();
/*  28 */     this.isaward = false;
/*     */   }
/*     */   
/*     */   public MonsterRobberRound()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MonsterRobberRound(MonsterRobberRound _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MonsterRobberRound(xbean.MonsterRobberRound _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof MonsterRobberRound)) { assign((MonsterRobberRound)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MonsterRobberRound _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.deadmonsterandcount = new HashMap();
/*  54 */     for (Map.Entry<Integer, Integer> _e_ : _o_.deadmonsterandcount.entrySet())
/*  55 */       this.deadmonsterandcount.put(_e_.getKey(), _e_.getValue());
/*  56 */     this.isaward = _o_.isaward;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.deadmonsterandcount = new HashMap();
/*  62 */     for (Map.Entry<Integer, Integer> _e_ : _o_.deadmonsterandcount.entrySet())
/*  63 */       this.deadmonsterandcount.put(_e_.getKey(), _e_.getValue());
/*  64 */     this.isaward = _o_.isaward;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.compact_uint32(this.deadmonsterandcount.size());
/*  72 */     for (Map.Entry<Integer, Integer> _e_ : this.deadmonsterandcount.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  75 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  77 */     _os_.marshal(this.isaward);
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
/*  89 */       this.deadmonsterandcount = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       int _k_ = 0;
/*  94 */       _k_ = _os_.unmarshal_int();
/*  95 */       int _v_ = 0;
/*  96 */       _v_ = _os_.unmarshal_int();
/*  97 */       this.deadmonsterandcount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 100 */     this.isaward = _os_.unmarshal_boolean();
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int _size_ = 0;
/* 109 */     for (Map.Entry<Integer, Integer> _e_ : this.deadmonsterandcount.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 112 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 114 */     _size_ += CodedOutputStream.computeBoolSize(2, this.isaward);
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       for (Map.Entry<Integer, Integer> _e_ : this.deadmonsterandcount.entrySet())
/*     */       {
/* 126 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 127 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 129 */       _output_.writeBool(2, this.isaward);
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
/* 160 */           if (8 != readTag)
/*     */           {
/* 162 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 164 */           int _v_ = 0;
/* 165 */           _v_ = _input_.readInt32();
/* 166 */           this.deadmonsterandcount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 171 */           this.isaward = _input_.readBool();
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
/*     */   public xbean.MonsterRobberRound copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new MonsterRobberRound(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MonsterRobberRound toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MonsterRobberRound toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new MonsterRobberRound(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MonsterRobberRound toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MonsterRobberRound toBeanIf()
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
/*     */   public Map<Integer, Integer> getDeadmonsterandcount()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return xdb.Logs.logMap(new xdb.LogKey(this, "deadmonsterandcount"), this.deadmonsterandcount);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getDeadmonsterandcountAsData()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/*     */     
/* 250 */     MonsterRobberRound _o_ = this;
/* 251 */     Map<Integer, Integer> deadmonsterandcount = new HashMap();
/* 252 */     for (Map.Entry<Integer, Integer> _e_ : _o_.deadmonsterandcount.entrySet())
/* 253 */       deadmonsterandcount.put(_e_.getKey(), _e_.getValue());
/* 254 */     return deadmonsterandcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIsaward()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.isaward;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIsaward(boolean _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new xdb.LogKey(this, "isaward")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogObject(this, Boolean.valueOf(MonsterRobberRound.this.isaward))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             MonsterRobberRound.this.isaward = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.isaward = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     MonsterRobberRound _o_ = null;
/* 291 */     if ((_o1_ instanceof MonsterRobberRound)) { _o_ = (MonsterRobberRound)_o1_;
/* 292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 293 */       return false;
/* 294 */     if (!this.deadmonsterandcount.equals(_o_.deadmonsterandcount)) return false;
/* 295 */     if (this.isaward != _o_.isaward) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ += this.deadmonsterandcount.hashCode();
/* 305 */     _h_ += (this.isaward ? 1231 : 1237);
/* 306 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     StringBuilder _sb_ = new StringBuilder();
/* 314 */     _sb_.append("(");
/* 315 */     _sb_.append(this.deadmonsterandcount);
/* 316 */     _sb_.append(",");
/* 317 */     _sb_.append(this.isaward);
/* 318 */     _sb_.append(")");
/* 319 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 325 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("deadmonsterandcount"));
/* 327 */     lb.add(new xdb.logs.ListenableChanged().setVarName("isaward"));
/* 328 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MonsterRobberRound {
/*     */     private Const() {}
/*     */     
/*     */     MonsterRobberRound nThis() {
/* 335 */       return MonsterRobberRound.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MonsterRobberRound copy()
/*     */     {
/* 347 */       return MonsterRobberRound.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MonsterRobberRound toData()
/*     */     {
/* 353 */       return MonsterRobberRound.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MonsterRobberRound toBean()
/*     */     {
/* 358 */       return MonsterRobberRound.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MonsterRobberRound toDataIf()
/*     */     {
/* 364 */       return MonsterRobberRound.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MonsterRobberRound toBeanIf()
/*     */     {
/* 369 */       return MonsterRobberRound.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getDeadmonsterandcount()
/*     */     {
/* 376 */       MonsterRobberRound.this._xdb_verify_unsafe_();
/* 377 */       return xdb.Consts.constMap(MonsterRobberRound.this.deadmonsterandcount);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getDeadmonsterandcountAsData()
/*     */     {
/* 384 */       MonsterRobberRound.this._xdb_verify_unsafe_();
/*     */       
/* 386 */       MonsterRobberRound _o_ = MonsterRobberRound.this;
/* 387 */       Map<Integer, Integer> deadmonsterandcount = new HashMap();
/* 388 */       for (Map.Entry<Integer, Integer> _e_ : _o_.deadmonsterandcount.entrySet())
/* 389 */         deadmonsterandcount.put(_e_.getKey(), _e_.getValue());
/* 390 */       return deadmonsterandcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsaward()
/*     */     {
/* 397 */       MonsterRobberRound.this._xdb_verify_unsafe_();
/* 398 */       return MonsterRobberRound.this.isaward;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsaward(boolean _v_)
/*     */     {
/* 405 */       MonsterRobberRound.this._xdb_verify_unsafe_();
/* 406 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 412 */       MonsterRobberRound.this._xdb_verify_unsafe_();
/* 413 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 419 */       MonsterRobberRound.this._xdb_verify_unsafe_();
/* 420 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 426 */       return MonsterRobberRound.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 432 */       return MonsterRobberRound.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 438 */       MonsterRobberRound.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 445 */       return MonsterRobberRound.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 451 */       return MonsterRobberRound.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 457 */       MonsterRobberRound.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 464 */       return MonsterRobberRound.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 470 */       return MonsterRobberRound.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 476 */       return MonsterRobberRound.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 482 */       return MonsterRobberRound.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 488 */       return MonsterRobberRound.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 494 */       return MonsterRobberRound.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 500 */       return MonsterRobberRound.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MonsterRobberRound
/*     */   {
/*     */     private HashMap<Integer, Integer> deadmonsterandcount;
/*     */     
/*     */     private boolean isaward;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 519 */       this.deadmonsterandcount = new HashMap();
/* 520 */       this.isaward = false;
/*     */     }
/*     */     
/*     */     Data(xbean.MonsterRobberRound _o1_)
/*     */     {
/* 525 */       if ((_o1_ instanceof MonsterRobberRound)) { assign((MonsterRobberRound)_o1_);
/* 526 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 527 */       } else if ((_o1_ instanceof MonsterRobberRound.Const)) assign(((MonsterRobberRound.Const)_o1_).nThis()); else {
/* 528 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MonsterRobberRound _o_) {
/* 533 */       this.deadmonsterandcount = new HashMap();
/* 534 */       for (Map.Entry<Integer, Integer> _e_ : _o_.deadmonsterandcount.entrySet())
/* 535 */         this.deadmonsterandcount.put(_e_.getKey(), _e_.getValue());
/* 536 */       this.isaward = _o_.isaward;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 541 */       this.deadmonsterandcount = new HashMap();
/* 542 */       for (Map.Entry<Integer, Integer> _e_ : _o_.deadmonsterandcount.entrySet())
/* 543 */         this.deadmonsterandcount.put(_e_.getKey(), _e_.getValue());
/* 544 */       this.isaward = _o_.isaward;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       _os_.compact_uint32(this.deadmonsterandcount.size());
/* 551 */       for (Map.Entry<Integer, Integer> _e_ : this.deadmonsterandcount.entrySet())
/*     */       {
/* 553 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 554 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 556 */       _os_.marshal(this.isaward);
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
/* 567 */         this.deadmonsterandcount = new HashMap(size * 2);
/*     */       }
/* 569 */       for (; size > 0; size--)
/*     */       {
/* 571 */         int _k_ = 0;
/* 572 */         _k_ = _os_.unmarshal_int();
/* 573 */         int _v_ = 0;
/* 574 */         _v_ = _os_.unmarshal_int();
/* 575 */         this.deadmonsterandcount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 578 */       this.isaward = _os_.unmarshal_boolean();
/* 579 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 585 */       int _size_ = 0;
/* 586 */       for (Map.Entry<Integer, Integer> _e_ : this.deadmonsterandcount.entrySet())
/*     */       {
/* 588 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 589 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 591 */       _size_ += CodedOutputStream.computeBoolSize(2, this.isaward);
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         for (Map.Entry<Integer, Integer> _e_ : this.deadmonsterandcount.entrySet())
/*     */         {
/* 602 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 603 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 605 */         _output_.writeBool(2, this.isaward);
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
/* 635 */             if (8 != readTag)
/*     */             {
/* 637 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 639 */             int _v_ = 0;
/* 640 */             _v_ = _input_.readInt32();
/* 641 */             this.deadmonsterandcount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 642 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 646 */             this.isaward = _input_.readBool();
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
/*     */     public xbean.MonsterRobberRound copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MonsterRobberRound toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MonsterRobberRound toBean()
/*     */     {
/* 685 */       return new MonsterRobberRound(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MonsterRobberRound toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MonsterRobberRound toBeanIf()
/*     */     {
/* 696 */       return new MonsterRobberRound(this, null, null);
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
/*     */     public Map<Integer, Integer> getDeadmonsterandcount()
/*     */     {
/* 733 */       return this.deadmonsterandcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getDeadmonsterandcountAsData()
/*     */     {
/* 740 */       return this.deadmonsterandcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsaward()
/*     */     {
/* 747 */       return this.isaward;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsaward(boolean _v_)
/*     */     {
/* 754 */       this.isaward = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 760 */       if (!(_o1_ instanceof Data)) return false;
/* 761 */       Data _o_ = (Data)_o1_;
/* 762 */       if (!this.deadmonsterandcount.equals(_o_.deadmonsterandcount)) return false;
/* 763 */       if (this.isaward != _o_.isaward) return false;
/* 764 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 770 */       int _h_ = 0;
/* 771 */       _h_ += this.deadmonsterandcount.hashCode();
/* 772 */       _h_ += (this.isaward ? 1231 : 1237);
/* 773 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 779 */       StringBuilder _sb_ = new StringBuilder();
/* 780 */       _sb_.append("(");
/* 781 */       _sb_.append(this.deadmonsterandcount);
/* 782 */       _sb_.append(",");
/* 783 */       _sb_.append(this.isaward);
/* 784 */       _sb_.append(")");
/* 785 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MonsterRobberRound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */