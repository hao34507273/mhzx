/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class CrossBattleKnockoutLocalRankInfo extends XBean implements xbean.CrossBattleKnockoutLocalRankInfo
/*     */ {
/*     */   private boolean is_server_buff_install;
/*     */   private SetX<Integer> valid_zone_id_set;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.is_server_buff_install = false;
/*  21 */     this.valid_zone_id_set.clear();
/*     */   }
/*     */   
/*     */   CrossBattleKnockoutLocalRankInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.is_server_buff_install = false;
/*  28 */     this.valid_zone_id_set = new SetX();
/*     */   }
/*     */   
/*     */   public CrossBattleKnockoutLocalRankInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CrossBattleKnockoutLocalRankInfo(CrossBattleKnockoutLocalRankInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CrossBattleKnockoutLocalRankInfo(xbean.CrossBattleKnockoutLocalRankInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof CrossBattleKnockoutLocalRankInfo)) { assign((CrossBattleKnockoutLocalRankInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CrossBattleKnockoutLocalRankInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.is_server_buff_install = _o_.is_server_buff_install;
/*  54 */     this.valid_zone_id_set = new SetX();
/*  55 */     this.valid_zone_id_set.addAll(_o_.valid_zone_id_set);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.is_server_buff_install = _o_.is_server_buff_install;
/*  61 */     this.valid_zone_id_set = new SetX();
/*  62 */     this.valid_zone_id_set.addAll(_o_.valid_zone_id_set);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  68 */     _xdb_verify_unsafe_();
/*  69 */     _os_.marshal(this.is_server_buff_install);
/*  70 */     _os_.compact_uint32(this.valid_zone_id_set.size());
/*  71 */     for (Integer _v_ : this.valid_zone_id_set)
/*     */     {
/*  73 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     _xdb_verify_unsafe_();
/*  82 */     this.is_server_buff_install = _os_.unmarshal_boolean();
/*  83 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  85 */       int _v_ = 0;
/*  86 */       _v_ = _os_.unmarshal_int();
/*  87 */       this.valid_zone_id_set.add(Integer.valueOf(_v_));
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     int _size_ = 0;
/*  97 */     _size_ += CodedOutputStream.computeBoolSize(1, this.is_server_buff_install);
/*  98 */     for (Integer _v_ : this.valid_zone_id_set)
/*     */     {
/* 100 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */     }
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeBool(1, this.is_server_buff_install);
/* 112 */       for (Integer _v_ : this.valid_zone_id_set)
/*     */       {
/* 114 */         _output_.writeInt32(2, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 119 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 121 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 127 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 130 */       boolean done = false;
/* 131 */       while (!done)
/*     */       {
/* 133 */         int tag = _input_.readTag();
/* 134 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 138 */           done = true;
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 143 */           this.is_server_buff_install = _input_.readBool();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 148 */           int _v_ = 0;
/* 149 */           _v_ = _input_.readInt32();
/* 150 */           this.valid_zone_id_set.add(Integer.valueOf(_v_));
/* 151 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 155 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 157 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 166 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 170 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 172 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossBattleKnockoutLocalRankInfo copy()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new CrossBattleKnockoutLocalRankInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossBattleKnockoutLocalRankInfo toData()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossBattleKnockoutLocalRankInfo toBean()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new CrossBattleKnockoutLocalRankInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossBattleKnockoutLocalRankInfo toDataIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossBattleKnockoutLocalRankInfo toBeanIf()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIs_server_buff_install()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return this.is_server_buff_install;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getValid_zone_id_set()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return xdb.Logs.logSet(new xdb.LogKey(this, "valid_zone_id_set"), this.valid_zone_id_set);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getValid_zone_id_setAsData()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/*     */     
/* 236 */     CrossBattleKnockoutLocalRankInfo _o_ = this;
/* 237 */     Set<Integer> valid_zone_id_set = new SetX();
/* 238 */     valid_zone_id_set.addAll(_o_.valid_zone_id_set);
/* 239 */     return valid_zone_id_set;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIs_server_buff_install(boolean _v_)
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     xdb.Logs.logIf(new xdb.LogKey(this, "is_server_buff_install")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 251 */         new xdb.logs.LogObject(this, Boolean.valueOf(CrossBattleKnockoutLocalRankInfo.this.is_server_buff_install))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 255 */             CrossBattleKnockoutLocalRankInfo.this.is_server_buff_install = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 259 */     });
/* 260 */     this.is_server_buff_install = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     CrossBattleKnockoutLocalRankInfo _o_ = null;
/* 268 */     if ((_o1_ instanceof CrossBattleKnockoutLocalRankInfo)) { _o_ = (CrossBattleKnockoutLocalRankInfo)_o1_;
/* 269 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 270 */       return false;
/* 271 */     if (this.is_server_buff_install != _o_.is_server_buff_install) return false;
/* 272 */     if (!this.valid_zone_id_set.equals(_o_.valid_zone_id_set)) return false;
/* 273 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     int _h_ = 0;
/* 281 */     _h_ += (this.is_server_buff_install ? 1231 : 1237);
/* 282 */     _h_ += this.valid_zone_id_set.hashCode();
/* 283 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     StringBuilder _sb_ = new StringBuilder();
/* 291 */     _sb_.append("(");
/* 292 */     _sb_.append(this.is_server_buff_install);
/* 293 */     _sb_.append(",");
/* 294 */     _sb_.append(this.valid_zone_id_set);
/* 295 */     _sb_.append(")");
/* 296 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 302 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 303 */     lb.add(new xdb.logs.ListenableChanged().setVarName("is_server_buff_install"));
/* 304 */     lb.add(new xdb.logs.ListenableSet().setVarName("valid_zone_id_set"));
/* 305 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CrossBattleKnockoutLocalRankInfo {
/*     */     private Const() {}
/*     */     
/*     */     CrossBattleKnockoutLocalRankInfo nThis() {
/* 312 */       return CrossBattleKnockoutLocalRankInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 318 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleKnockoutLocalRankInfo copy()
/*     */     {
/* 324 */       return CrossBattleKnockoutLocalRankInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleKnockoutLocalRankInfo toData()
/*     */     {
/* 330 */       return CrossBattleKnockoutLocalRankInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CrossBattleKnockoutLocalRankInfo toBean()
/*     */     {
/* 335 */       return CrossBattleKnockoutLocalRankInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleKnockoutLocalRankInfo toDataIf()
/*     */     {
/* 341 */       return CrossBattleKnockoutLocalRankInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CrossBattleKnockoutLocalRankInfo toBeanIf()
/*     */     {
/* 346 */       return CrossBattleKnockoutLocalRankInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_server_buff_install()
/*     */     {
/* 353 */       CrossBattleKnockoutLocalRankInfo.this._xdb_verify_unsafe_();
/* 354 */       return CrossBattleKnockoutLocalRankInfo.this.is_server_buff_install;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getValid_zone_id_set()
/*     */     {
/* 361 */       CrossBattleKnockoutLocalRankInfo.this._xdb_verify_unsafe_();
/* 362 */       return xdb.Consts.constSet(CrossBattleKnockoutLocalRankInfo.this.valid_zone_id_set);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getValid_zone_id_setAsData()
/*     */     {
/* 368 */       CrossBattleKnockoutLocalRankInfo.this._xdb_verify_unsafe_();
/*     */       
/* 370 */       CrossBattleKnockoutLocalRankInfo _o_ = CrossBattleKnockoutLocalRankInfo.this;
/* 371 */       Set<Integer> valid_zone_id_set = new SetX();
/* 372 */       valid_zone_id_set.addAll(_o_.valid_zone_id_set);
/* 373 */       return valid_zone_id_set;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_server_buff_install(boolean _v_)
/*     */     {
/* 380 */       CrossBattleKnockoutLocalRankInfo.this._xdb_verify_unsafe_();
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 387 */       CrossBattleKnockoutLocalRankInfo.this._xdb_verify_unsafe_();
/* 388 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 394 */       CrossBattleKnockoutLocalRankInfo.this._xdb_verify_unsafe_();
/* 395 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 401 */       return CrossBattleKnockoutLocalRankInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 407 */       return CrossBattleKnockoutLocalRankInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 413 */       CrossBattleKnockoutLocalRankInfo.this._xdb_verify_unsafe_();
/* 414 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 420 */       return CrossBattleKnockoutLocalRankInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 426 */       return CrossBattleKnockoutLocalRankInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 432 */       CrossBattleKnockoutLocalRankInfo.this._xdb_verify_unsafe_();
/* 433 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 439 */       return CrossBattleKnockoutLocalRankInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 445 */       return CrossBattleKnockoutLocalRankInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 451 */       return CrossBattleKnockoutLocalRankInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 457 */       return CrossBattleKnockoutLocalRankInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 463 */       return CrossBattleKnockoutLocalRankInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 469 */       return CrossBattleKnockoutLocalRankInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 475 */       return CrossBattleKnockoutLocalRankInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CrossBattleKnockoutLocalRankInfo
/*     */   {
/*     */     private boolean is_server_buff_install;
/*     */     
/*     */     private HashSet<Integer> valid_zone_id_set;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 489 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 494 */       this.is_server_buff_install = false;
/* 495 */       this.valid_zone_id_set = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.CrossBattleKnockoutLocalRankInfo _o1_)
/*     */     {
/* 500 */       if ((_o1_ instanceof CrossBattleKnockoutLocalRankInfo)) { assign((CrossBattleKnockoutLocalRankInfo)_o1_);
/* 501 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 502 */       } else if ((_o1_ instanceof CrossBattleKnockoutLocalRankInfo.Const)) assign(((CrossBattleKnockoutLocalRankInfo.Const)_o1_).nThis()); else {
/* 503 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CrossBattleKnockoutLocalRankInfo _o_) {
/* 508 */       this.is_server_buff_install = _o_.is_server_buff_install;
/* 509 */       this.valid_zone_id_set = new HashSet();
/* 510 */       this.valid_zone_id_set.addAll(_o_.valid_zone_id_set);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 515 */       this.is_server_buff_install = _o_.is_server_buff_install;
/* 516 */       this.valid_zone_id_set = new HashSet();
/* 517 */       this.valid_zone_id_set.addAll(_o_.valid_zone_id_set);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 523 */       _os_.marshal(this.is_server_buff_install);
/* 524 */       _os_.compact_uint32(this.valid_zone_id_set.size());
/* 525 */       for (Integer _v_ : this.valid_zone_id_set)
/*     */       {
/* 527 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 529 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 535 */       this.is_server_buff_install = _os_.unmarshal_boolean();
/* 536 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 538 */         int _v_ = 0;
/* 539 */         _v_ = _os_.unmarshal_int();
/* 540 */         this.valid_zone_id_set.add(Integer.valueOf(_v_));
/*     */       }
/* 542 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 548 */       int _size_ = 0;
/* 549 */       _size_ += CodedOutputStream.computeBoolSize(1, this.is_server_buff_install);
/* 550 */       for (Integer _v_ : this.valid_zone_id_set)
/*     */       {
/* 552 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 554 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 562 */         _output_.writeBool(1, this.is_server_buff_install);
/* 563 */         for (Integer _v_ : this.valid_zone_id_set)
/*     */         {
/* 565 */           _output_.writeInt32(2, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 570 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 572 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 580 */         boolean done = false;
/* 581 */         while (!done)
/*     */         {
/* 583 */           int tag = _input_.readTag();
/* 584 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 588 */             done = true;
/* 589 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 593 */             this.is_server_buff_install = _input_.readBool();
/* 594 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 598 */             int _v_ = 0;
/* 599 */             _v_ = _input_.readInt32();
/* 600 */             this.valid_zone_id_set.add(Integer.valueOf(_v_));
/* 601 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 605 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 607 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 616 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 620 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 622 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleKnockoutLocalRankInfo copy()
/*     */     {
/* 628 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleKnockoutLocalRankInfo toData()
/*     */     {
/* 634 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CrossBattleKnockoutLocalRankInfo toBean()
/*     */     {
/* 639 */       return new CrossBattleKnockoutLocalRankInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleKnockoutLocalRankInfo toDataIf()
/*     */     {
/* 645 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CrossBattleKnockoutLocalRankInfo toBeanIf()
/*     */     {
/* 650 */       return new CrossBattleKnockoutLocalRankInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 656 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 660 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 664 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 668 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 672 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 676 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 680 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_server_buff_install()
/*     */     {
/* 687 */       return this.is_server_buff_install;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getValid_zone_id_set()
/*     */     {
/* 694 */       return this.valid_zone_id_set;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getValid_zone_id_setAsData()
/*     */     {
/* 701 */       return this.valid_zone_id_set;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_server_buff_install(boolean _v_)
/*     */     {
/* 708 */       this.is_server_buff_install = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 714 */       if (!(_o1_ instanceof Data)) return false;
/* 715 */       Data _o_ = (Data)_o1_;
/* 716 */       if (this.is_server_buff_install != _o_.is_server_buff_install) return false;
/* 717 */       if (!this.valid_zone_id_set.equals(_o_.valid_zone_id_set)) return false;
/* 718 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 724 */       int _h_ = 0;
/* 725 */       _h_ += (this.is_server_buff_install ? 1231 : 1237);
/* 726 */       _h_ += this.valid_zone_id_set.hashCode();
/* 727 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 733 */       StringBuilder _sb_ = new StringBuilder();
/* 734 */       _sb_.append("(");
/* 735 */       _sb_.append(this.is_server_buff_install);
/* 736 */       _sb_.append(",");
/* 737 */       _sb_.append(this.valid_zone_id_set);
/* 738 */       _sb_.append(")");
/* 739 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossBattleKnockoutLocalRankInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */