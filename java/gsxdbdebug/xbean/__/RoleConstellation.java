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
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class RoleConstellation extends XBean implements xbean.RoleConstellation
/*     */ {
/*     */   private HashMap<Integer, Integer> award_constellations;
/*     */   private int set_times;
/*     */   private int constellation;
/*     */   private int sum_exp;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.award_constellations.clear();
/*  25 */     this.set_times = 0;
/*  26 */     this.constellation = -1;
/*  27 */     this.sum_exp = 0;
/*     */   }
/*     */   
/*     */   RoleConstellation(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.award_constellations = new HashMap();
/*  34 */     this.set_times = 0;
/*  35 */     this.constellation = -1;
/*  36 */     this.sum_exp = 0;
/*     */   }
/*     */   
/*     */   public RoleConstellation()
/*     */   {
/*  41 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleConstellation(RoleConstellation _o_)
/*     */   {
/*  46 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleConstellation(xbean.RoleConstellation _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  51 */     super(_xp_, _vn_);
/*  52 */     if ((_o1_ instanceof RoleConstellation)) { assign((RoleConstellation)_o1_);
/*  53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  55 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleConstellation _o_) {
/*  60 */     _o_._xdb_verify_unsafe_();
/*  61 */     this.award_constellations = new HashMap();
/*  62 */     for (Map.Entry<Integer, Integer> _e_ : _o_.award_constellations.entrySet())
/*  63 */       this.award_constellations.put(_e_.getKey(), _e_.getValue());
/*  64 */     this.set_times = _o_.set_times;
/*  65 */     this.constellation = _o_.constellation;
/*  66 */     this.sum_exp = _o_.sum_exp;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  71 */     this.award_constellations = new HashMap();
/*  72 */     for (Map.Entry<Integer, Integer> _e_ : _o_.award_constellations.entrySet())
/*  73 */       this.award_constellations.put(_e_.getKey(), _e_.getValue());
/*  74 */     this.set_times = _o_.set_times;
/*  75 */     this.constellation = _o_.constellation;
/*  76 */     this.sum_exp = _o_.sum_exp;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     _os_.compact_uint32(this.award_constellations.size());
/*  84 */     for (Map.Entry<Integer, Integer> _e_ : this.award_constellations.entrySet())
/*     */     {
/*  86 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  87 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  89 */     _os_.marshal(this.set_times);
/*  90 */     _os_.marshal(this.constellation);
/*  91 */     _os_.marshal(this.sum_exp);
/*  92 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  98 */     _xdb_verify_unsafe_();
/*     */     
/* 100 */     int size = _os_.uncompact_uint32();
/* 101 */     if (size >= 12)
/*     */     {
/* 103 */       this.award_constellations = new HashMap(size * 2);
/*     */     }
/* 105 */     for (; size > 0; size--)
/*     */     {
/* 107 */       int _k_ = 0;
/* 108 */       _k_ = _os_.unmarshal_int();
/* 109 */       int _v_ = 0;
/* 110 */       _v_ = _os_.unmarshal_int();
/* 111 */       this.award_constellations.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 114 */     this.set_times = _os_.unmarshal_int();
/* 115 */     this.constellation = _os_.unmarshal_int();
/* 116 */     this.sum_exp = _os_.unmarshal_int();
/* 117 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 123 */     _xdb_verify_unsafe_();
/* 124 */     int _size_ = 0;
/* 125 */     for (Map.Entry<Integer, Integer> _e_ : this.award_constellations.entrySet())
/*     */     {
/* 127 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 128 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 130 */     _size_ += CodedOutputStream.computeInt32Size(2, this.set_times);
/* 131 */     _size_ += CodedOutputStream.computeInt32Size(3, this.constellation);
/* 132 */     _size_ += CodedOutputStream.computeInt32Size(4, this.sum_exp);
/* 133 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 139 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 142 */       for (Map.Entry<Integer, Integer> _e_ : this.award_constellations.entrySet())
/*     */       {
/* 144 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 145 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 147 */       _output_.writeInt32(2, this.set_times);
/* 148 */       _output_.writeInt32(3, this.constellation);
/* 149 */       _output_.writeInt32(4, this.sum_exp);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 153 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 155 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 161 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 164 */       boolean done = false;
/* 165 */       while (!done)
/*     */       {
/* 167 */         int tag = _input_.readTag();
/* 168 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 172 */           done = true;
/* 173 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 177 */           int _k_ = 0;
/* 178 */           _k_ = _input_.readInt32();
/* 179 */           int readTag = _input_.readTag();
/* 180 */           if (8 != readTag)
/*     */           {
/* 182 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 184 */           int _v_ = 0;
/* 185 */           _v_ = _input_.readInt32();
/* 186 */           this.award_constellations.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 187 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 191 */           this.set_times = _input_.readInt32();
/* 192 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 196 */           this.constellation = _input_.readInt32();
/* 197 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 201 */           this.sum_exp = _input_.readInt32();
/* 202 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 206 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 208 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 217 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 221 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 223 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleConstellation copy()
/*     */   {
/* 229 */     _xdb_verify_unsafe_();
/* 230 */     return new RoleConstellation(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleConstellation toData()
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleConstellation toBean()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return new RoleConstellation(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleConstellation toDataIf()
/*     */   {
/* 249 */     _xdb_verify_unsafe_();
/* 250 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleConstellation toBeanIf()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/* 263 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getAward_constellations()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/* 271 */     return xdb.Logs.logMap(new LogKey(this, "award_constellations"), this.award_constellations);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getAward_constellationsAsData()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/*     */     
/* 280 */     RoleConstellation _o_ = this;
/* 281 */     Map<Integer, Integer> award_constellations = new HashMap();
/* 282 */     for (Map.Entry<Integer, Integer> _e_ : _o_.award_constellations.entrySet())
/* 283 */       award_constellations.put(_e_.getKey(), _e_.getValue());
/* 284 */     return award_constellations;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSet_times()
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/* 292 */     return this.set_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getConstellation()
/*     */   {
/* 299 */     _xdb_verify_unsafe_();
/* 300 */     return this.constellation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSum_exp()
/*     */   {
/* 307 */     _xdb_verify_unsafe_();
/* 308 */     return this.sum_exp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSet_times(int _v_)
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     xdb.Logs.logIf(new LogKey(this, "set_times")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 320 */         new xdb.logs.LogInt(this, RoleConstellation.this.set_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 324 */             RoleConstellation.this.set_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 328 */     });
/* 329 */     this.set_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setConstellation(int _v_)
/*     */   {
/* 336 */     _xdb_verify_unsafe_();
/* 337 */     xdb.Logs.logIf(new LogKey(this, "constellation")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 341 */         new xdb.logs.LogInt(this, RoleConstellation.this.constellation)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 345 */             RoleConstellation.this.constellation = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 349 */     });
/* 350 */     this.constellation = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSum_exp(int _v_)
/*     */   {
/* 357 */     _xdb_verify_unsafe_();
/* 358 */     xdb.Logs.logIf(new LogKey(this, "sum_exp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 362 */         new xdb.logs.LogInt(this, RoleConstellation.this.sum_exp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 366 */             RoleConstellation.this.sum_exp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 370 */     });
/* 371 */     this.sum_exp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 377 */     _xdb_verify_unsafe_();
/* 378 */     RoleConstellation _o_ = null;
/* 379 */     if ((_o1_ instanceof RoleConstellation)) { _o_ = (RoleConstellation)_o1_;
/* 380 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 381 */       return false;
/* 382 */     if (!this.award_constellations.equals(_o_.award_constellations)) return false;
/* 383 */     if (this.set_times != _o_.set_times) return false;
/* 384 */     if (this.constellation != _o_.constellation) return false;
/* 385 */     if (this.sum_exp != _o_.sum_exp) return false;
/* 386 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 392 */     _xdb_verify_unsafe_();
/* 393 */     int _h_ = 0;
/* 394 */     _h_ += this.award_constellations.hashCode();
/* 395 */     _h_ += this.set_times;
/* 396 */     _h_ += this.constellation;
/* 397 */     _h_ += this.sum_exp;
/* 398 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 404 */     _xdb_verify_unsafe_();
/* 405 */     StringBuilder _sb_ = new StringBuilder();
/* 406 */     _sb_.append("(");
/* 407 */     _sb_.append(this.award_constellations);
/* 408 */     _sb_.append(",");
/* 409 */     _sb_.append(this.set_times);
/* 410 */     _sb_.append(",");
/* 411 */     _sb_.append(this.constellation);
/* 412 */     _sb_.append(",");
/* 413 */     _sb_.append(this.sum_exp);
/* 414 */     _sb_.append(")");
/* 415 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 421 */     ListenableBean lb = new ListenableBean();
/* 422 */     lb.add(new xdb.logs.ListenableMap().setVarName("award_constellations"));
/* 423 */     lb.add(new xdb.logs.ListenableChanged().setVarName("set_times"));
/* 424 */     lb.add(new xdb.logs.ListenableChanged().setVarName("constellation"));
/* 425 */     lb.add(new xdb.logs.ListenableChanged().setVarName("sum_exp"));
/* 426 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleConstellation {
/*     */     private Const() {}
/*     */     
/*     */     RoleConstellation nThis() {
/* 433 */       return RoleConstellation.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleConstellation copy()
/*     */     {
/* 445 */       return RoleConstellation.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleConstellation toData()
/*     */     {
/* 451 */       return RoleConstellation.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleConstellation toBean()
/*     */     {
/* 456 */       return RoleConstellation.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleConstellation toDataIf()
/*     */     {
/* 462 */       return RoleConstellation.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleConstellation toBeanIf()
/*     */     {
/* 467 */       return RoleConstellation.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getAward_constellations()
/*     */     {
/* 474 */       RoleConstellation.this._xdb_verify_unsafe_();
/* 475 */       return xdb.Consts.constMap(RoleConstellation.this.award_constellations);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getAward_constellationsAsData()
/*     */     {
/* 482 */       RoleConstellation.this._xdb_verify_unsafe_();
/*     */       
/* 484 */       RoleConstellation _o_ = RoleConstellation.this;
/* 485 */       Map<Integer, Integer> award_constellations = new HashMap();
/* 486 */       for (Map.Entry<Integer, Integer> _e_ : _o_.award_constellations.entrySet())
/* 487 */         award_constellations.put(_e_.getKey(), _e_.getValue());
/* 488 */       return award_constellations;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSet_times()
/*     */     {
/* 495 */       RoleConstellation.this._xdb_verify_unsafe_();
/* 496 */       return RoleConstellation.this.set_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getConstellation()
/*     */     {
/* 503 */       RoleConstellation.this._xdb_verify_unsafe_();
/* 504 */       return RoleConstellation.this.constellation;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSum_exp()
/*     */     {
/* 511 */       RoleConstellation.this._xdb_verify_unsafe_();
/* 512 */       return RoleConstellation.this.sum_exp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSet_times(int _v_)
/*     */     {
/* 519 */       RoleConstellation.this._xdb_verify_unsafe_();
/* 520 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setConstellation(int _v_)
/*     */     {
/* 527 */       RoleConstellation.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSum_exp(int _v_)
/*     */     {
/* 535 */       RoleConstellation.this._xdb_verify_unsafe_();
/* 536 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 542 */       RoleConstellation.this._xdb_verify_unsafe_();
/* 543 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 549 */       RoleConstellation.this._xdb_verify_unsafe_();
/* 550 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 556 */       return RoleConstellation.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 562 */       return RoleConstellation.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 568 */       RoleConstellation.this._xdb_verify_unsafe_();
/* 569 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 575 */       return RoleConstellation.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 581 */       return RoleConstellation.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 587 */       RoleConstellation.this._xdb_verify_unsafe_();
/* 588 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 594 */       return RoleConstellation.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 600 */       return RoleConstellation.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 606 */       return RoleConstellation.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 612 */       return RoleConstellation.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 618 */       return RoleConstellation.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 624 */       return RoleConstellation.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 630 */       return RoleConstellation.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleConstellation
/*     */   {
/*     */     private HashMap<Integer, Integer> award_constellations;
/*     */     
/*     */     private int set_times;
/*     */     
/*     */     private int constellation;
/*     */     
/*     */     private int sum_exp;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 648 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 653 */       this.award_constellations = new HashMap();
/* 654 */       this.set_times = 0;
/* 655 */       this.constellation = -1;
/* 656 */       this.sum_exp = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.RoleConstellation _o1_)
/*     */     {
/* 661 */       if ((_o1_ instanceof RoleConstellation)) { assign((RoleConstellation)_o1_);
/* 662 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 663 */       } else if ((_o1_ instanceof RoleConstellation.Const)) assign(((RoleConstellation.Const)_o1_).nThis()); else {
/* 664 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleConstellation _o_) {
/* 669 */       this.award_constellations = new HashMap();
/* 670 */       for (Map.Entry<Integer, Integer> _e_ : _o_.award_constellations.entrySet())
/* 671 */         this.award_constellations.put(_e_.getKey(), _e_.getValue());
/* 672 */       this.set_times = _o_.set_times;
/* 673 */       this.constellation = _o_.constellation;
/* 674 */       this.sum_exp = _o_.sum_exp;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 679 */       this.award_constellations = new HashMap();
/* 680 */       for (Map.Entry<Integer, Integer> _e_ : _o_.award_constellations.entrySet())
/* 681 */         this.award_constellations.put(_e_.getKey(), _e_.getValue());
/* 682 */       this.set_times = _o_.set_times;
/* 683 */       this.constellation = _o_.constellation;
/* 684 */       this.sum_exp = _o_.sum_exp;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 690 */       _os_.compact_uint32(this.award_constellations.size());
/* 691 */       for (Map.Entry<Integer, Integer> _e_ : this.award_constellations.entrySet())
/*     */       {
/* 693 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 694 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 696 */       _os_.marshal(this.set_times);
/* 697 */       _os_.marshal(this.constellation);
/* 698 */       _os_.marshal(this.sum_exp);
/* 699 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 706 */       int size = _os_.uncompact_uint32();
/* 707 */       if (size >= 12)
/*     */       {
/* 709 */         this.award_constellations = new HashMap(size * 2);
/*     */       }
/* 711 */       for (; size > 0; size--)
/*     */       {
/* 713 */         int _k_ = 0;
/* 714 */         _k_ = _os_.unmarshal_int();
/* 715 */         int _v_ = 0;
/* 716 */         _v_ = _os_.unmarshal_int();
/* 717 */         this.award_constellations.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 720 */       this.set_times = _os_.unmarshal_int();
/* 721 */       this.constellation = _os_.unmarshal_int();
/* 722 */       this.sum_exp = _os_.unmarshal_int();
/* 723 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 729 */       int _size_ = 0;
/* 730 */       for (Map.Entry<Integer, Integer> _e_ : this.award_constellations.entrySet())
/*     */       {
/* 732 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 733 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 735 */       _size_ += CodedOutputStream.computeInt32Size(2, this.set_times);
/* 736 */       _size_ += CodedOutputStream.computeInt32Size(3, this.constellation);
/* 737 */       _size_ += CodedOutputStream.computeInt32Size(4, this.sum_exp);
/* 738 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 746 */         for (Map.Entry<Integer, Integer> _e_ : this.award_constellations.entrySet())
/*     */         {
/* 748 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 749 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 751 */         _output_.writeInt32(2, this.set_times);
/* 752 */         _output_.writeInt32(3, this.constellation);
/* 753 */         _output_.writeInt32(4, this.sum_exp);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 757 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 759 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 767 */         boolean done = false;
/* 768 */         while (!done)
/*     */         {
/* 770 */           int tag = _input_.readTag();
/* 771 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 775 */             done = true;
/* 776 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 780 */             int _k_ = 0;
/* 781 */             _k_ = _input_.readInt32();
/* 782 */             int readTag = _input_.readTag();
/* 783 */             if (8 != readTag)
/*     */             {
/* 785 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 787 */             int _v_ = 0;
/* 788 */             _v_ = _input_.readInt32();
/* 789 */             this.award_constellations.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 790 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 794 */             this.set_times = _input_.readInt32();
/* 795 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 799 */             this.constellation = _input_.readInt32();
/* 800 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 804 */             this.sum_exp = _input_.readInt32();
/* 805 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 809 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 811 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 820 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 824 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 826 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleConstellation copy()
/*     */     {
/* 832 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleConstellation toData()
/*     */     {
/* 838 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleConstellation toBean()
/*     */     {
/* 843 */       return new RoleConstellation(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleConstellation toDataIf()
/*     */     {
/* 849 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleConstellation toBeanIf()
/*     */     {
/* 854 */       return new RoleConstellation(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 860 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 864 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 868 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 872 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 876 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 880 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 884 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getAward_constellations()
/*     */     {
/* 891 */       return this.award_constellations;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getAward_constellationsAsData()
/*     */     {
/* 898 */       return this.award_constellations;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSet_times()
/*     */     {
/* 905 */       return this.set_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getConstellation()
/*     */     {
/* 912 */       return this.constellation;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSum_exp()
/*     */     {
/* 919 */       return this.sum_exp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSet_times(int _v_)
/*     */     {
/* 926 */       this.set_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setConstellation(int _v_)
/*     */     {
/* 933 */       this.constellation = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSum_exp(int _v_)
/*     */     {
/* 940 */       this.sum_exp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 946 */       if (!(_o1_ instanceof Data)) return false;
/* 947 */       Data _o_ = (Data)_o1_;
/* 948 */       if (!this.award_constellations.equals(_o_.award_constellations)) return false;
/* 949 */       if (this.set_times != _o_.set_times) return false;
/* 950 */       if (this.constellation != _o_.constellation) return false;
/* 951 */       if (this.sum_exp != _o_.sum_exp) return false;
/* 952 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 958 */       int _h_ = 0;
/* 959 */       _h_ += this.award_constellations.hashCode();
/* 960 */       _h_ += this.set_times;
/* 961 */       _h_ += this.constellation;
/* 962 */       _h_ += this.sum_exp;
/* 963 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 969 */       StringBuilder _sb_ = new StringBuilder();
/* 970 */       _sb_.append("(");
/* 971 */       _sb_.append(this.award_constellations);
/* 972 */       _sb_.append(",");
/* 973 */       _sb_.append(this.set_times);
/* 974 */       _sb_.append(",");
/* 975 */       _sb_.append(this.constellation);
/* 976 */       _sb_.append(",");
/* 977 */       _sb_.append(this.sum_exp);
/* 978 */       _sb_.append(")");
/* 979 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleConstellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */