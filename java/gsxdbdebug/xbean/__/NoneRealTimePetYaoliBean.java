/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class NoneRealTimePetYaoliBean extends XBean implements xbean.NoneRealTimePetYaoliBean
/*     */ {
/*     */   private long petid;
/*     */   private long roleid;
/*     */   private int petyaoli;
/*     */   private long changeyaolitime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.petid = 0L;
/*  25 */     this.roleid = 0L;
/*  26 */     this.petyaoli = 0;
/*  27 */     this.changeyaolitime = 0L;
/*     */   }
/*     */   
/*     */   NoneRealTimePetYaoliBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public NoneRealTimePetYaoliBean()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public NoneRealTimePetYaoliBean(NoneRealTimePetYaoliBean _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   NoneRealTimePetYaoliBean(xbean.NoneRealTimePetYaoliBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof NoneRealTimePetYaoliBean)) { assign((NoneRealTimePetYaoliBean)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(NoneRealTimePetYaoliBean _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.petid = _o_.petid;
/*  58 */     this.roleid = _o_.roleid;
/*  59 */     this.petyaoli = _o_.petyaoli;
/*  60 */     this.changeyaolitime = _o_.changeyaolitime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.petid = _o_.petid;
/*  66 */     this.roleid = _o_.roleid;
/*  67 */     this.petyaoli = _o_.petyaoli;
/*  68 */     this.changeyaolitime = _o_.changeyaolitime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.petid);
/*  76 */     _os_.marshal(this.roleid);
/*  77 */     _os_.marshal(this.petyaoli);
/*  78 */     _os_.marshal(this.changeyaolitime);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.petid = _os_.unmarshal_long();
/*  87 */     this.roleid = _os_.unmarshal_long();
/*  88 */     this.petyaoli = _os_.unmarshal_int();
/*  89 */     this.changeyaolitime = _os_.unmarshal_long();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt64Size(1, this.petid);
/*  99 */     _size_ += CodedOutputStream.computeInt64Size(2, this.roleid);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(3, this.petyaoli);
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(4, this.changeyaolitime);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt64(1, this.petid);
/* 112 */       _output_.writeInt64(2, this.roleid);
/* 113 */       _output_.writeInt32(3, this.petyaoli);
/* 114 */       _output_.writeInt64(4, this.changeyaolitime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 118 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 120 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       boolean done = false;
/* 130 */       while (!done)
/*     */       {
/* 132 */         int tag = _input_.readTag();
/* 133 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 137 */           done = true;
/* 138 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 142 */           this.petid = _input_.readInt64();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.roleid = _input_.readInt64();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.petyaoli = _input_.readInt32();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.changeyaolitime = _input_.readInt64();
/* 158 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 162 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 164 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 173 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 177 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 179 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.NoneRealTimePetYaoliBean copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new NoneRealTimePetYaoliBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.NoneRealTimePetYaoliBean toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.NoneRealTimePetYaoliBean toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new NoneRealTimePetYaoliBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.NoneRealTimePetYaoliBean toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.NoneRealTimePetYaoliBean toBeanIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getPetid()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.petid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPetyaoli()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.petyaoli;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getChangeyaolitime()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.changeyaolitime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPetid(long _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "petid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new LogLong(this, NoneRealTimePetYaoliBean.this.petid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             NoneRealTimePetYaoliBean.this.petid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.petid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleid(long _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new LogLong(this, NoneRealTimePetYaoliBean.this.roleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             NoneRealTimePetYaoliBean.this.roleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.roleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPetyaoli(int _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "petyaoli")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 305 */         new xdb.logs.LogInt(this, NoneRealTimePetYaoliBean.this.petyaoli)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             NoneRealTimePetYaoliBean.this.petyaoli = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.petyaoli = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setChangeyaolitime(long _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "changeyaolitime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new LogLong(this, NoneRealTimePetYaoliBean.this.changeyaolitime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             NoneRealTimePetYaoliBean.this.changeyaolitime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.changeyaolitime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     NoneRealTimePetYaoliBean _o_ = null;
/* 343 */     if ((_o1_ instanceof NoneRealTimePetYaoliBean)) { _o_ = (NoneRealTimePetYaoliBean)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.petid != _o_.petid) return false;
/* 347 */     if (this.roleid != _o_.roleid) return false;
/* 348 */     if (this.petyaoli != _o_.petyaoli) return false;
/* 349 */     if (this.changeyaolitime != _o_.changeyaolitime) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ = (int)(_h_ + this.petid);
/* 359 */     _h_ = (int)(_h_ + this.roleid);
/* 360 */     _h_ += this.petyaoli;
/* 361 */     _h_ = (int)(_h_ + this.changeyaolitime);
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.petid);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.roleid);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.petyaoli);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.changeyaolitime);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("petid"));
/* 387 */     lb.add(new ListenableChanged().setVarName("roleid"));
/* 388 */     lb.add(new ListenableChanged().setVarName("petyaoli"));
/* 389 */     lb.add(new ListenableChanged().setVarName("changeyaolitime"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.NoneRealTimePetYaoliBean {
/*     */     private Const() {}
/*     */     
/*     */     NoneRealTimePetYaoliBean nThis() {
/* 397 */       return NoneRealTimePetYaoliBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealTimePetYaoliBean copy()
/*     */     {
/* 409 */       return NoneRealTimePetYaoliBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealTimePetYaoliBean toData()
/*     */     {
/* 415 */       return NoneRealTimePetYaoliBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.NoneRealTimePetYaoliBean toBean()
/*     */     {
/* 420 */       return NoneRealTimePetYaoliBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealTimePetYaoliBean toDataIf()
/*     */     {
/* 426 */       return NoneRealTimePetYaoliBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.NoneRealTimePetYaoliBean toBeanIf()
/*     */     {
/* 431 */       return NoneRealTimePetYaoliBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPetid()
/*     */     {
/* 438 */       NoneRealTimePetYaoliBean.this._xdb_verify_unsafe_();
/* 439 */       return NoneRealTimePetYaoliBean.this.petid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 446 */       NoneRealTimePetYaoliBean.this._xdb_verify_unsafe_();
/* 447 */       return NoneRealTimePetYaoliBean.this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPetyaoli()
/*     */     {
/* 454 */       NoneRealTimePetYaoliBean.this._xdb_verify_unsafe_();
/* 455 */       return NoneRealTimePetYaoliBean.this.petyaoli;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getChangeyaolitime()
/*     */     {
/* 462 */       NoneRealTimePetYaoliBean.this._xdb_verify_unsafe_();
/* 463 */       return NoneRealTimePetYaoliBean.this.changeyaolitime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPetid(long _v_)
/*     */     {
/* 470 */       NoneRealTimePetYaoliBean.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 478 */       NoneRealTimePetYaoliBean.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPetyaoli(int _v_)
/*     */     {
/* 486 */       NoneRealTimePetYaoliBean.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChangeyaolitime(long _v_)
/*     */     {
/* 494 */       NoneRealTimePetYaoliBean.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       NoneRealTimePetYaoliBean.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       NoneRealTimePetYaoliBean.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return NoneRealTimePetYaoliBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return NoneRealTimePetYaoliBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       NoneRealTimePetYaoliBean.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return NoneRealTimePetYaoliBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return NoneRealTimePetYaoliBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       NoneRealTimePetYaoliBean.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return NoneRealTimePetYaoliBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return NoneRealTimePetYaoliBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return NoneRealTimePetYaoliBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return NoneRealTimePetYaoliBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return NoneRealTimePetYaoliBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return NoneRealTimePetYaoliBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return NoneRealTimePetYaoliBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.NoneRealTimePetYaoliBean
/*     */   {
/*     */     private long petid;
/*     */     
/*     */     private long roleid;
/*     */     
/*     */     private int petyaoli;
/*     */     
/*     */     private long changeyaolitime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 607 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.NoneRealTimePetYaoliBean _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof NoneRealTimePetYaoliBean)) { assign((NoneRealTimePetYaoliBean)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof NoneRealTimePetYaoliBean.Const)) assign(((NoneRealTimePetYaoliBean.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(NoneRealTimePetYaoliBean _o_) {
/* 624 */       this.petid = _o_.petid;
/* 625 */       this.roleid = _o_.roleid;
/* 626 */       this.petyaoli = _o_.petyaoli;
/* 627 */       this.changeyaolitime = _o_.changeyaolitime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.petid = _o_.petid;
/* 633 */       this.roleid = _o_.roleid;
/* 634 */       this.petyaoli = _o_.petyaoli;
/* 635 */       this.changeyaolitime = _o_.changeyaolitime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.petid);
/* 642 */       _os_.marshal(this.roleid);
/* 643 */       _os_.marshal(this.petyaoli);
/* 644 */       _os_.marshal(this.changeyaolitime);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.petid = _os_.unmarshal_long();
/* 652 */       this.roleid = _os_.unmarshal_long();
/* 653 */       this.petyaoli = _os_.unmarshal_int();
/* 654 */       this.changeyaolitime = _os_.unmarshal_long();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt64Size(1, this.petid);
/* 663 */       _size_ += CodedOutputStream.computeInt64Size(2, this.roleid);
/* 664 */       _size_ += CodedOutputStream.computeInt32Size(3, this.petyaoli);
/* 665 */       _size_ += CodedOutputStream.computeInt64Size(4, this.changeyaolitime);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt64(1, this.petid);
/* 675 */         _output_.writeInt64(2, this.roleid);
/* 676 */         _output_.writeInt32(3, this.petyaoli);
/* 677 */         _output_.writeInt64(4, this.changeyaolitime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 681 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 683 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 691 */         boolean done = false;
/* 692 */         while (!done)
/*     */         {
/* 694 */           int tag = _input_.readTag();
/* 695 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 699 */             done = true;
/* 700 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 704 */             this.petid = _input_.readInt64();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.roleid = _input_.readInt64();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.petyaoli = _input_.readInt32();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.changeyaolitime = _input_.readInt64();
/* 720 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 724 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 726 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 735 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 739 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 741 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealTimePetYaoliBean copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealTimePetYaoliBean toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.NoneRealTimePetYaoliBean toBean()
/*     */     {
/* 758 */       return new NoneRealTimePetYaoliBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealTimePetYaoliBean toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.NoneRealTimePetYaoliBean toBeanIf()
/*     */     {
/* 769 */       return new NoneRealTimePetYaoliBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 775 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 795 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 799 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPetid()
/*     */     {
/* 806 */       return this.petid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 813 */       return this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPetyaoli()
/*     */     {
/* 820 */       return this.petyaoli;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getChangeyaolitime()
/*     */     {
/* 827 */       return this.changeyaolitime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPetid(long _v_)
/*     */     {
/* 834 */       this.petid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 841 */       this.roleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPetyaoli(int _v_)
/*     */     {
/* 848 */       this.petyaoli = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChangeyaolitime(long _v_)
/*     */     {
/* 855 */       this.changeyaolitime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.petid != _o_.petid) return false;
/* 864 */       if (this.roleid != _o_.roleid) return false;
/* 865 */       if (this.petyaoli != _o_.petyaoli) return false;
/* 866 */       if (this.changeyaolitime != _o_.changeyaolitime) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ = (int)(_h_ + this.petid);
/* 875 */       _h_ = (int)(_h_ + this.roleid);
/* 876 */       _h_ += this.petyaoli;
/* 877 */       _h_ = (int)(_h_ + this.changeyaolitime);
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.petid);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.roleid);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.petyaoli);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.changeyaolitime);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\NoneRealTimePetYaoliBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */