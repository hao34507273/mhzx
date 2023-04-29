/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class TransferOccupationWing extends XBean implements xbean.TransferOccupationWing
/*     */ {
/*     */   private HashMap<Integer, xbean.WingPlan> wings;
/*     */   private int curplan;
/*     */   private String planname;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.wings.clear();
/*  23 */     this.curplan = 0;
/*  24 */     this.planname = "";
/*     */   }
/*     */   
/*     */   TransferOccupationWing(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.wings = new HashMap();
/*  31 */     this.planname = "";
/*     */   }
/*     */   
/*     */   public TransferOccupationWing()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public TransferOccupationWing(TransferOccupationWing _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   TransferOccupationWing(xbean.TransferOccupationWing _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof TransferOccupationWing)) { assign((TransferOccupationWing)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(TransferOccupationWing _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.wings = new HashMap();
/*  57 */     for (Map.Entry<Integer, xbean.WingPlan> _e_ : _o_.wings.entrySet())
/*  58 */       this.wings.put(_e_.getKey(), new WingPlan((xbean.WingPlan)_e_.getValue(), this, "wings"));
/*  59 */     this.curplan = _o_.curplan;
/*  60 */     this.planname = _o_.planname;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.wings = new HashMap();
/*  66 */     for (Map.Entry<Integer, xbean.WingPlan> _e_ : _o_.wings.entrySet())
/*  67 */       this.wings.put(_e_.getKey(), new WingPlan((xbean.WingPlan)_e_.getValue(), this, "wings"));
/*  68 */     this.curplan = _o_.curplan;
/*  69 */     this.planname = _o_.planname;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     _os_.compact_uint32(this.wings.size());
/*  77 */     for (Map.Entry<Integer, xbean.WingPlan> _e_ : this.wings.entrySet())
/*     */     {
/*  79 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  80 */       ((xbean.WingPlan)_e_.getValue()).marshal(_os_);
/*     */     }
/*  82 */     _os_.marshal(this.curplan);
/*  83 */     _os_.marshal(this.planname, "UTF-16LE");
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
/*  95 */       this.wings = new HashMap(size * 2);
/*     */     }
/*  97 */     for (; size > 0; size--)
/*     */     {
/*  99 */       int _k_ = 0;
/* 100 */       _k_ = _os_.unmarshal_int();
/* 101 */       xbean.WingPlan _v_ = new WingPlan(0, this, "wings");
/* 102 */       _v_.unmarshal(_os_);
/* 103 */       this.wings.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 106 */     this.curplan = _os_.unmarshal_int();
/* 107 */     this.planname = _os_.unmarshal_String("UTF-16LE");
/* 108 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 114 */     _xdb_verify_unsafe_();
/* 115 */     int _size_ = 0;
/* 116 */     for (Map.Entry<Integer, xbean.WingPlan> _e_ : this.wings.entrySet())
/*     */     {
/* 118 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 119 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 121 */     _size_ += CodedOutputStream.computeInt32Size(2, this.curplan);
/*     */     try
/*     */     {
/* 124 */       _size_ += CodedOutputStream.computeBytesSize(3, ppbio.ByteString.copyFrom(this.planname, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/* 128 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 130 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 139 */       for (Map.Entry<Integer, xbean.WingPlan> _e_ : this.wings.entrySet())
/*     */       {
/* 141 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 142 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 144 */       _output_.writeInt32(2, this.curplan);
/* 145 */       _output_.writeBytes(3, ppbio.ByteString.copyFrom(this.planname, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 149 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 151 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 160 */       boolean done = false;
/* 161 */       while (!done)
/*     */       {
/* 163 */         int tag = _input_.readTag();
/* 164 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 168 */           done = true;
/* 169 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 173 */           int _k_ = 0;
/* 174 */           _k_ = _input_.readInt32();
/* 175 */           int readTag = _input_.readTag();
/* 176 */           if (10 != readTag)
/*     */           {
/* 178 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 180 */           xbean.WingPlan _v_ = new WingPlan(0, this, "wings");
/* 181 */           _input_.readMessage(_v_);
/* 182 */           this.wings.put(Integer.valueOf(_k_), _v_);
/* 183 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 187 */           this.curplan = _input_.readInt32();
/* 188 */           break;
/*     */         
/*     */ 
/*     */         case 26: 
/* 192 */           this.planname = _input_.readBytes().toString("UTF-16LE");
/* 193 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 197 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 199 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 208 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 212 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 214 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TransferOccupationWing copy()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new TransferOccupationWing(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TransferOccupationWing toData()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TransferOccupationWing toBean()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new TransferOccupationWing(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TransferOccupationWing toDataIf()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TransferOccupationWing toBeanIf()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.WingPlan> getWings()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return xdb.Logs.logMap(new LogKey(this, "wings"), this.wings);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.WingPlan> getWingsAsData()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/*     */     
/* 271 */     TransferOccupationWing _o_ = this;
/* 272 */     Map<Integer, xbean.WingPlan> wings = new HashMap();
/* 273 */     for (Map.Entry<Integer, xbean.WingPlan> _e_ : _o_.wings.entrySet())
/* 274 */       wings.put(_e_.getKey(), new WingPlan.Data((xbean.WingPlan)_e_.getValue()));
/* 275 */     return wings;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCurplan()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/* 283 */     return this.curplan;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPlanname()
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     return this.planname;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getPlannameOctets()
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     return Octets.wrap(getPlanname(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCurplan(int _v_)
/*     */   {
/* 306 */     _xdb_verify_unsafe_();
/* 307 */     xdb.Logs.logIf(new LogKey(this, "curplan")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 311 */         new xdb.logs.LogInt(this, TransferOccupationWing.this.curplan)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 315 */             TransferOccupationWing.this.curplan = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 319 */     });
/* 320 */     this.curplan = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPlanname(String _v_)
/*     */   {
/* 327 */     _xdb_verify_unsafe_();
/* 328 */     if (null == _v_)
/* 329 */       throw new NullPointerException();
/* 330 */     xdb.Logs.logIf(new LogKey(this, "planname")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 334 */         new xdb.logs.LogString(this, TransferOccupationWing.this.planname)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 338 */             TransferOccupationWing.this.planname = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 342 */     });
/* 343 */     this.planname = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPlannameOctets(Octets _v_)
/*     */   {
/* 350 */     _xdb_verify_unsafe_();
/* 351 */     setPlanname(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 357 */     _xdb_verify_unsafe_();
/* 358 */     TransferOccupationWing _o_ = null;
/* 359 */     if ((_o1_ instanceof TransferOccupationWing)) { _o_ = (TransferOccupationWing)_o1_;
/* 360 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 361 */       return false;
/* 362 */     if (!this.wings.equals(_o_.wings)) return false;
/* 363 */     if (this.curplan != _o_.curplan) return false;
/* 364 */     if (!this.planname.equals(_o_.planname)) return false;
/* 365 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 371 */     _xdb_verify_unsafe_();
/* 372 */     int _h_ = 0;
/* 373 */     _h_ += this.wings.hashCode();
/* 374 */     _h_ += this.curplan;
/* 375 */     _h_ += this.planname.hashCode();
/* 376 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 382 */     _xdb_verify_unsafe_();
/* 383 */     StringBuilder _sb_ = new StringBuilder();
/* 384 */     _sb_.append("(");
/* 385 */     _sb_.append(this.wings);
/* 386 */     _sb_.append(",");
/* 387 */     _sb_.append(this.curplan);
/* 388 */     _sb_.append(",");
/* 389 */     _sb_.append("'").append(this.planname).append("'");
/* 390 */     _sb_.append(")");
/* 391 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 397 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 398 */     lb.add(new xdb.logs.ListenableMap().setVarName("wings"));
/* 399 */     lb.add(new xdb.logs.ListenableChanged().setVarName("curplan"));
/* 400 */     lb.add(new xdb.logs.ListenableChanged().setVarName("planname"));
/* 401 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.TransferOccupationWing {
/*     */     private Const() {}
/*     */     
/*     */     TransferOccupationWing nThis() {
/* 408 */       return TransferOccupationWing.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 414 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationWing copy()
/*     */     {
/* 420 */       return TransferOccupationWing.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationWing toData()
/*     */     {
/* 426 */       return TransferOccupationWing.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.TransferOccupationWing toBean()
/*     */     {
/* 431 */       return TransferOccupationWing.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationWing toDataIf()
/*     */     {
/* 437 */       return TransferOccupationWing.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.TransferOccupationWing toBeanIf()
/*     */     {
/* 442 */       return TransferOccupationWing.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.WingPlan> getWings()
/*     */     {
/* 449 */       TransferOccupationWing.this._xdb_verify_unsafe_();
/* 450 */       return xdb.Consts.constMap(TransferOccupationWing.this.wings);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.WingPlan> getWingsAsData()
/*     */     {
/* 457 */       TransferOccupationWing.this._xdb_verify_unsafe_();
/*     */       
/* 459 */       TransferOccupationWing _o_ = TransferOccupationWing.this;
/* 460 */       Map<Integer, xbean.WingPlan> wings = new HashMap();
/* 461 */       for (Map.Entry<Integer, xbean.WingPlan> _e_ : _o_.wings.entrySet())
/* 462 */         wings.put(_e_.getKey(), new WingPlan.Data((xbean.WingPlan)_e_.getValue()));
/* 463 */       return wings;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurplan()
/*     */     {
/* 470 */       TransferOccupationWing.this._xdb_verify_unsafe_();
/* 471 */       return TransferOccupationWing.this.curplan;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getPlanname()
/*     */     {
/* 478 */       TransferOccupationWing.this._xdb_verify_unsafe_();
/* 479 */       return TransferOccupationWing.this.planname;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getPlannameOctets()
/*     */     {
/* 486 */       TransferOccupationWing.this._xdb_verify_unsafe_();
/* 487 */       return TransferOccupationWing.this.getPlannameOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurplan(int _v_)
/*     */     {
/* 494 */       TransferOccupationWing.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPlanname(String _v_)
/*     */     {
/* 502 */       TransferOccupationWing.this._xdb_verify_unsafe_();
/* 503 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPlannameOctets(Octets _v_)
/*     */     {
/* 510 */       TransferOccupationWing.this._xdb_verify_unsafe_();
/* 511 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 517 */       TransferOccupationWing.this._xdb_verify_unsafe_();
/* 518 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 524 */       TransferOccupationWing.this._xdb_verify_unsafe_();
/* 525 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 531 */       return TransferOccupationWing.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 537 */       return TransferOccupationWing.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 543 */       TransferOccupationWing.this._xdb_verify_unsafe_();
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 550 */       return TransferOccupationWing.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 556 */       return TransferOccupationWing.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 562 */       TransferOccupationWing.this._xdb_verify_unsafe_();
/* 563 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 569 */       return TransferOccupationWing.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 575 */       return TransferOccupationWing.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 581 */       return TransferOccupationWing.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 587 */       return TransferOccupationWing.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 593 */       return TransferOccupationWing.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 599 */       return TransferOccupationWing.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 605 */       return TransferOccupationWing.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.TransferOccupationWing
/*     */   {
/*     */     private HashMap<Integer, xbean.WingPlan> wings;
/*     */     
/*     */     private int curplan;
/*     */     
/*     */     private String planname;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 621 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 626 */       this.wings = new HashMap();
/* 627 */       this.planname = "";
/*     */     }
/*     */     
/*     */     Data(xbean.TransferOccupationWing _o1_)
/*     */     {
/* 632 */       if ((_o1_ instanceof TransferOccupationWing)) { assign((TransferOccupationWing)_o1_);
/* 633 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 634 */       } else if ((_o1_ instanceof TransferOccupationWing.Const)) assign(((TransferOccupationWing.Const)_o1_).nThis()); else {
/* 635 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(TransferOccupationWing _o_) {
/* 640 */       this.wings = new HashMap();
/* 641 */       for (Map.Entry<Integer, xbean.WingPlan> _e_ : _o_.wings.entrySet())
/* 642 */         this.wings.put(_e_.getKey(), new WingPlan.Data((xbean.WingPlan)_e_.getValue()));
/* 643 */       this.curplan = _o_.curplan;
/* 644 */       this.planname = _o_.planname;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 649 */       this.wings = new HashMap();
/* 650 */       for (Map.Entry<Integer, xbean.WingPlan> _e_ : _o_.wings.entrySet())
/* 651 */         this.wings.put(_e_.getKey(), new WingPlan.Data((xbean.WingPlan)_e_.getValue()));
/* 652 */       this.curplan = _o_.curplan;
/* 653 */       this.planname = _o_.planname;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 659 */       _os_.compact_uint32(this.wings.size());
/* 660 */       for (Map.Entry<Integer, xbean.WingPlan> _e_ : this.wings.entrySet())
/*     */       {
/* 662 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 663 */         ((xbean.WingPlan)_e_.getValue()).marshal(_os_);
/*     */       }
/* 665 */       _os_.marshal(this.curplan);
/* 666 */       _os_.marshal(this.planname, "UTF-16LE");
/* 667 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 674 */       int size = _os_.uncompact_uint32();
/* 675 */       if (size >= 12)
/*     */       {
/* 677 */         this.wings = new HashMap(size * 2);
/*     */       }
/* 679 */       for (; size > 0; size--)
/*     */       {
/* 681 */         int _k_ = 0;
/* 682 */         _k_ = _os_.unmarshal_int();
/* 683 */         xbean.WingPlan _v_ = xbean.Pod.newWingPlanData();
/* 684 */         _v_.unmarshal(_os_);
/* 685 */         this.wings.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 688 */       this.curplan = _os_.unmarshal_int();
/* 689 */       this.planname = _os_.unmarshal_String("UTF-16LE");
/* 690 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 696 */       int _size_ = 0;
/* 697 */       for (Map.Entry<Integer, xbean.WingPlan> _e_ : this.wings.entrySet())
/*     */       {
/* 699 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 700 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 702 */       _size_ += CodedOutputStream.computeInt32Size(2, this.curplan);
/*     */       try
/*     */       {
/* 705 */         _size_ += CodedOutputStream.computeBytesSize(3, ppbio.ByteString.copyFrom(this.planname, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 709 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 711 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 719 */         for (Map.Entry<Integer, xbean.WingPlan> _e_ : this.wings.entrySet())
/*     */         {
/* 721 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 722 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 724 */         _output_.writeInt32(2, this.curplan);
/* 725 */         _output_.writeBytes(3, ppbio.ByteString.copyFrom(this.planname, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 729 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 731 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 739 */         boolean done = false;
/* 740 */         while (!done)
/*     */         {
/* 742 */           int tag = _input_.readTag();
/* 743 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 747 */             done = true;
/* 748 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 752 */             int _k_ = 0;
/* 753 */             _k_ = _input_.readInt32();
/* 754 */             int readTag = _input_.readTag();
/* 755 */             if (10 != readTag)
/*     */             {
/* 757 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 759 */             xbean.WingPlan _v_ = xbean.Pod.newWingPlanData();
/* 760 */             _input_.readMessage(_v_);
/* 761 */             this.wings.put(Integer.valueOf(_k_), _v_);
/* 762 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 766 */             this.curplan = _input_.readInt32();
/* 767 */             break;
/*     */           
/*     */ 
/*     */           case 26: 
/* 771 */             this.planname = _input_.readBytes().toString("UTF-16LE");
/* 772 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 776 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 778 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 787 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 791 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 793 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationWing copy()
/*     */     {
/* 799 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationWing toData()
/*     */     {
/* 805 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.TransferOccupationWing toBean()
/*     */     {
/* 810 */       return new TransferOccupationWing(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TransferOccupationWing toDataIf()
/*     */     {
/* 816 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.TransferOccupationWing toBeanIf()
/*     */     {
/* 821 */       return new TransferOccupationWing(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 827 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 831 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 835 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 839 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 843 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 847 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 851 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.WingPlan> getWings()
/*     */     {
/* 858 */       return this.wings;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.WingPlan> getWingsAsData()
/*     */     {
/* 865 */       return this.wings;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurplan()
/*     */     {
/* 872 */       return this.curplan;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getPlanname()
/*     */     {
/* 879 */       return this.planname;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getPlannameOctets()
/*     */     {
/* 886 */       return Octets.wrap(getPlanname(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurplan(int _v_)
/*     */     {
/* 893 */       this.curplan = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPlanname(String _v_)
/*     */     {
/* 900 */       if (null == _v_)
/* 901 */         throw new NullPointerException();
/* 902 */       this.planname = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPlannameOctets(Octets _v_)
/*     */     {
/* 909 */       setPlanname(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 915 */       if (!(_o1_ instanceof Data)) return false;
/* 916 */       Data _o_ = (Data)_o1_;
/* 917 */       if (!this.wings.equals(_o_.wings)) return false;
/* 918 */       if (this.curplan != _o_.curplan) return false;
/* 919 */       if (!this.planname.equals(_o_.planname)) return false;
/* 920 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 926 */       int _h_ = 0;
/* 927 */       _h_ += this.wings.hashCode();
/* 928 */       _h_ += this.curplan;
/* 929 */       _h_ += this.planname.hashCode();
/* 930 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 936 */       StringBuilder _sb_ = new StringBuilder();
/* 937 */       _sb_.append("(");
/* 938 */       _sb_.append(this.wings);
/* 939 */       _sb_.append(",");
/* 940 */       _sb_.append(this.curplan);
/* 941 */       _sb_.append(",");
/* 942 */       _sb_.append("'").append(this.planname).append("'");
/* 943 */       _sb_.append(")");
/* 944 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\TransferOccupationWing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */