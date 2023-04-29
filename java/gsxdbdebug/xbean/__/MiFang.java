/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class MiFang extends XBean implements xbean.MiFang
/*     */ {
/*     */   private int mifangcfgid;
/*     */   private long mifangcfgstarttime;
/*     */   private long mifangcfgendtime;
/*     */   private ArrayList<Integer> mifangyaocailist;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.mifangcfgid = 0;
/*  25 */     this.mifangcfgstarttime = 0L;
/*  26 */     this.mifangcfgendtime = 0L;
/*  27 */     this.mifangyaocailist.clear();
/*     */   }
/*     */   
/*     */   MiFang(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.mifangyaocailist = new ArrayList();
/*     */   }
/*     */   
/*     */   public MiFang()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MiFang(MiFang _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MiFang(xbean.MiFang _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof MiFang)) { assign((MiFang)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MiFang _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.mifangcfgid = _o_.mifangcfgid;
/*  59 */     this.mifangcfgstarttime = _o_.mifangcfgstarttime;
/*  60 */     this.mifangcfgendtime = _o_.mifangcfgendtime;
/*  61 */     this.mifangyaocailist = new ArrayList();
/*  62 */     this.mifangyaocailist.addAll(_o_.mifangyaocailist);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.mifangcfgid = _o_.mifangcfgid;
/*  68 */     this.mifangcfgstarttime = _o_.mifangcfgstarttime;
/*  69 */     this.mifangcfgendtime = _o_.mifangcfgendtime;
/*  70 */     this.mifangyaocailist = new ArrayList();
/*  71 */     this.mifangyaocailist.addAll(_o_.mifangyaocailist);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     _os_.marshal(this.mifangcfgid);
/*  79 */     _os_.marshal(this.mifangcfgstarttime);
/*  80 */     _os_.marshal(this.mifangcfgendtime);
/*  81 */     _os_.compact_uint32(this.mifangyaocailist.size());
/*  82 */     for (Integer _v_ : this.mifangyaocailist)
/*     */     {
/*  84 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     this.mifangcfgid = _os_.unmarshal_int();
/*  94 */     this.mifangcfgstarttime = _os_.unmarshal_long();
/*  95 */     this.mifangcfgendtime = _os_.unmarshal_long();
/*  96 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  98 */       int _v_ = 0;
/*  99 */       _v_ = _os_.unmarshal_int();
/* 100 */       this.mifangyaocailist.add(Integer.valueOf(_v_));
/*     */     }
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/* 109 */     int _size_ = 0;
/* 110 */     _size_ += CodedOutputStream.computeInt32Size(1, this.mifangcfgid);
/* 111 */     _size_ += CodedOutputStream.computeInt64Size(2, this.mifangcfgstarttime);
/* 112 */     _size_ += CodedOutputStream.computeInt64Size(3, this.mifangcfgendtime);
/* 113 */     for (Integer _v_ : this.mifangyaocailist)
/*     */     {
/* 115 */       _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*     */     }
/* 117 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 123 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 126 */       _output_.writeInt32(1, this.mifangcfgid);
/* 127 */       _output_.writeInt64(2, this.mifangcfgstarttime);
/* 128 */       _output_.writeInt64(3, this.mifangcfgendtime);
/* 129 */       for (Integer _v_ : this.mifangyaocailist)
/*     */       {
/* 131 */         _output_.writeInt32(4, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 136 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 138 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 144 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 147 */       boolean done = false;
/* 148 */       while (!done)
/*     */       {
/* 150 */         int tag = _input_.readTag();
/* 151 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 155 */           done = true;
/* 156 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 160 */           this.mifangcfgid = _input_.readInt32();
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 165 */           this.mifangcfgstarttime = _input_.readInt64();
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 170 */           this.mifangcfgendtime = _input_.readInt64();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 175 */           int _v_ = 0;
/* 176 */           _v_ = _input_.readInt32();
/* 177 */           this.mifangyaocailist.add(Integer.valueOf(_v_));
/* 178 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 182 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 184 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 193 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 197 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 199 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MiFang copy()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new MiFang(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MiFang toData()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MiFang toBean()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new MiFang(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MiFang toDataIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MiFang toBeanIf()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMifangcfgid()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return this.mifangcfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getMifangcfgstarttime()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return this.mifangcfgstarttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getMifangcfgendtime()
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/* 263 */     return this.mifangcfgendtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getMifangyaocailist()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/* 271 */     return xdb.Logs.logList(new LogKey(this, "mifangyaocailist"), this.mifangyaocailist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getMifangyaocailistAsData()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/*     */     
/* 279 */     MiFang _o_ = this;
/* 280 */     List<Integer> mifangyaocailist = new ArrayList();
/* 281 */     mifangyaocailist.addAll(_o_.mifangyaocailist);
/* 282 */     return mifangyaocailist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMifangcfgid(int _v_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     xdb.Logs.logIf(new LogKey(this, "mifangcfgid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 294 */         new xdb.logs.LogInt(this, MiFang.this.mifangcfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 298 */             MiFang.this.mifangcfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 302 */     });
/* 303 */     this.mifangcfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMifangcfgstarttime(long _v_)
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/* 311 */     xdb.Logs.logIf(new LogKey(this, "mifangcfgstarttime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 315 */         new xdb.logs.LogLong(this, MiFang.this.mifangcfgstarttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 319 */             MiFang.this.mifangcfgstarttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 323 */     });
/* 324 */     this.mifangcfgstarttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMifangcfgendtime(long _v_)
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/* 332 */     xdb.Logs.logIf(new LogKey(this, "mifangcfgendtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 336 */         new xdb.logs.LogLong(this, MiFang.this.mifangcfgendtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 340 */             MiFang.this.mifangcfgendtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 344 */     });
/* 345 */     this.mifangcfgendtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 351 */     _xdb_verify_unsafe_();
/* 352 */     MiFang _o_ = null;
/* 353 */     if ((_o1_ instanceof MiFang)) { _o_ = (MiFang)_o1_;
/* 354 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 355 */       return false;
/* 356 */     if (this.mifangcfgid != _o_.mifangcfgid) return false;
/* 357 */     if (this.mifangcfgstarttime != _o_.mifangcfgstarttime) return false;
/* 358 */     if (this.mifangcfgendtime != _o_.mifangcfgendtime) return false;
/* 359 */     if (!this.mifangyaocailist.equals(_o_.mifangyaocailist)) return false;
/* 360 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 366 */     _xdb_verify_unsafe_();
/* 367 */     int _h_ = 0;
/* 368 */     _h_ += this.mifangcfgid;
/* 369 */     _h_ = (int)(_h_ + this.mifangcfgstarttime);
/* 370 */     _h_ = (int)(_h_ + this.mifangcfgendtime);
/* 371 */     _h_ += this.mifangyaocailist.hashCode();
/* 372 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 378 */     _xdb_verify_unsafe_();
/* 379 */     StringBuilder _sb_ = new StringBuilder();
/* 380 */     _sb_.append("(");
/* 381 */     _sb_.append(this.mifangcfgid);
/* 382 */     _sb_.append(",");
/* 383 */     _sb_.append(this.mifangcfgstarttime);
/* 384 */     _sb_.append(",");
/* 385 */     _sb_.append(this.mifangcfgendtime);
/* 386 */     _sb_.append(",");
/* 387 */     _sb_.append(this.mifangyaocailist);
/* 388 */     _sb_.append(")");
/* 389 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 395 */     ListenableBean lb = new ListenableBean();
/* 396 */     lb.add(new ListenableChanged().setVarName("mifangcfgid"));
/* 397 */     lb.add(new ListenableChanged().setVarName("mifangcfgstarttime"));
/* 398 */     lb.add(new ListenableChanged().setVarName("mifangcfgendtime"));
/* 399 */     lb.add(new ListenableChanged().setVarName("mifangyaocailist"));
/* 400 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MiFang {
/*     */     private Const() {}
/*     */     
/*     */     MiFang nThis() {
/* 407 */       return MiFang.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MiFang copy()
/*     */     {
/* 419 */       return MiFang.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MiFang toData()
/*     */     {
/* 425 */       return MiFang.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MiFang toBean()
/*     */     {
/* 430 */       return MiFang.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MiFang toDataIf()
/*     */     {
/* 436 */       return MiFang.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MiFang toBeanIf()
/*     */     {
/* 441 */       return MiFang.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMifangcfgid()
/*     */     {
/* 448 */       MiFang.this._xdb_verify_unsafe_();
/* 449 */       return MiFang.this.mifangcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMifangcfgstarttime()
/*     */     {
/* 456 */       MiFang.this._xdb_verify_unsafe_();
/* 457 */       return MiFang.this.mifangcfgstarttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMifangcfgendtime()
/*     */     {
/* 464 */       MiFang.this._xdb_verify_unsafe_();
/* 465 */       return MiFang.this.mifangcfgendtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getMifangyaocailist()
/*     */     {
/* 472 */       MiFang.this._xdb_verify_unsafe_();
/* 473 */       return xdb.Consts.constList(MiFang.this.mifangyaocailist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getMifangyaocailistAsData()
/*     */     {
/* 479 */       MiFang.this._xdb_verify_unsafe_();
/*     */       
/* 481 */       MiFang _o_ = MiFang.this;
/* 482 */       List<Integer> mifangyaocailist = new ArrayList();
/* 483 */       mifangyaocailist.addAll(_o_.mifangyaocailist);
/* 484 */       return mifangyaocailist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMifangcfgid(int _v_)
/*     */     {
/* 491 */       MiFang.this._xdb_verify_unsafe_();
/* 492 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMifangcfgstarttime(long _v_)
/*     */     {
/* 499 */       MiFang.this._xdb_verify_unsafe_();
/* 500 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMifangcfgendtime(long _v_)
/*     */     {
/* 507 */       MiFang.this._xdb_verify_unsafe_();
/* 508 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 514 */       MiFang.this._xdb_verify_unsafe_();
/* 515 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 521 */       MiFang.this._xdb_verify_unsafe_();
/* 522 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 528 */       return MiFang.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 534 */       return MiFang.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 540 */       MiFang.this._xdb_verify_unsafe_();
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 547 */       return MiFang.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 553 */       return MiFang.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 559 */       MiFang.this._xdb_verify_unsafe_();
/* 560 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 566 */       return MiFang.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 572 */       return MiFang.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 578 */       return MiFang.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 584 */       return MiFang.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 590 */       return MiFang.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 596 */       return MiFang.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 602 */       return MiFang.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MiFang
/*     */   {
/*     */     private int mifangcfgid;
/*     */     
/*     */     private long mifangcfgstarttime;
/*     */     
/*     */     private long mifangcfgendtime;
/*     */     
/*     */     private ArrayList<Integer> mifangyaocailist;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 620 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 625 */       this.mifangyaocailist = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.MiFang _o1_)
/*     */     {
/* 630 */       if ((_o1_ instanceof MiFang)) { assign((MiFang)_o1_);
/* 631 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 632 */       } else if ((_o1_ instanceof MiFang.Const)) assign(((MiFang.Const)_o1_).nThis()); else {
/* 633 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MiFang _o_) {
/* 638 */       this.mifangcfgid = _o_.mifangcfgid;
/* 639 */       this.mifangcfgstarttime = _o_.mifangcfgstarttime;
/* 640 */       this.mifangcfgendtime = _o_.mifangcfgendtime;
/* 641 */       this.mifangyaocailist = new ArrayList();
/* 642 */       this.mifangyaocailist.addAll(_o_.mifangyaocailist);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 647 */       this.mifangcfgid = _o_.mifangcfgid;
/* 648 */       this.mifangcfgstarttime = _o_.mifangcfgstarttime;
/* 649 */       this.mifangcfgendtime = _o_.mifangcfgendtime;
/* 650 */       this.mifangyaocailist = new ArrayList();
/* 651 */       this.mifangyaocailist.addAll(_o_.mifangyaocailist);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 657 */       _os_.marshal(this.mifangcfgid);
/* 658 */       _os_.marshal(this.mifangcfgstarttime);
/* 659 */       _os_.marshal(this.mifangcfgendtime);
/* 660 */       _os_.compact_uint32(this.mifangyaocailist.size());
/* 661 */       for (Integer _v_ : this.mifangyaocailist)
/*     */       {
/* 663 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 665 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 671 */       this.mifangcfgid = _os_.unmarshal_int();
/* 672 */       this.mifangcfgstarttime = _os_.unmarshal_long();
/* 673 */       this.mifangcfgendtime = _os_.unmarshal_long();
/* 674 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 676 */         int _v_ = 0;
/* 677 */         _v_ = _os_.unmarshal_int();
/* 678 */         this.mifangyaocailist.add(Integer.valueOf(_v_));
/*     */       }
/* 680 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 686 */       int _size_ = 0;
/* 687 */       _size_ += CodedOutputStream.computeInt32Size(1, this.mifangcfgid);
/* 688 */       _size_ += CodedOutputStream.computeInt64Size(2, this.mifangcfgstarttime);
/* 689 */       _size_ += CodedOutputStream.computeInt64Size(3, this.mifangcfgendtime);
/* 690 */       for (Integer _v_ : this.mifangyaocailist)
/*     */       {
/* 692 */         _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*     */       }
/* 694 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 702 */         _output_.writeInt32(1, this.mifangcfgid);
/* 703 */         _output_.writeInt64(2, this.mifangcfgstarttime);
/* 704 */         _output_.writeInt64(3, this.mifangcfgendtime);
/* 705 */         for (Integer _v_ : this.mifangyaocailist)
/*     */         {
/* 707 */           _output_.writeInt32(4, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 712 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 714 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 722 */         boolean done = false;
/* 723 */         while (!done)
/*     */         {
/* 725 */           int tag = _input_.readTag();
/* 726 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 730 */             done = true;
/* 731 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 735 */             this.mifangcfgid = _input_.readInt32();
/* 736 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 740 */             this.mifangcfgstarttime = _input_.readInt64();
/* 741 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 745 */             this.mifangcfgendtime = _input_.readInt64();
/* 746 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 750 */             int _v_ = 0;
/* 751 */             _v_ = _input_.readInt32();
/* 752 */             this.mifangyaocailist.add(Integer.valueOf(_v_));
/* 753 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 757 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 759 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 768 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 772 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 774 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MiFang copy()
/*     */     {
/* 780 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MiFang toData()
/*     */     {
/* 786 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MiFang toBean()
/*     */     {
/* 791 */       return new MiFang(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MiFang toDataIf()
/*     */     {
/* 797 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MiFang toBeanIf()
/*     */     {
/* 802 */       return new MiFang(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 808 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 812 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 816 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 820 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 824 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 828 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 832 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMifangcfgid()
/*     */     {
/* 839 */       return this.mifangcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMifangcfgstarttime()
/*     */     {
/* 846 */       return this.mifangcfgstarttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMifangcfgendtime()
/*     */     {
/* 853 */       return this.mifangcfgendtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getMifangyaocailist()
/*     */     {
/* 860 */       return this.mifangyaocailist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getMifangyaocailistAsData()
/*     */     {
/* 867 */       return this.mifangyaocailist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMifangcfgid(int _v_)
/*     */     {
/* 874 */       this.mifangcfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMifangcfgstarttime(long _v_)
/*     */     {
/* 881 */       this.mifangcfgstarttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMifangcfgendtime(long _v_)
/*     */     {
/* 888 */       this.mifangcfgendtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 894 */       if (!(_o1_ instanceof Data)) return false;
/* 895 */       Data _o_ = (Data)_o1_;
/* 896 */       if (this.mifangcfgid != _o_.mifangcfgid) return false;
/* 897 */       if (this.mifangcfgstarttime != _o_.mifangcfgstarttime) return false;
/* 898 */       if (this.mifangcfgendtime != _o_.mifangcfgendtime) return false;
/* 899 */       if (!this.mifangyaocailist.equals(_o_.mifangyaocailist)) return false;
/* 900 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 906 */       int _h_ = 0;
/* 907 */       _h_ += this.mifangcfgid;
/* 908 */       _h_ = (int)(_h_ + this.mifangcfgstarttime);
/* 909 */       _h_ = (int)(_h_ + this.mifangcfgendtime);
/* 910 */       _h_ += this.mifangyaocailist.hashCode();
/* 911 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 917 */       StringBuilder _sb_ = new StringBuilder();
/* 918 */       _sb_.append("(");
/* 919 */       _sb_.append(this.mifangcfgid);
/* 920 */       _sb_.append(",");
/* 921 */       _sb_.append(this.mifangcfgstarttime);
/* 922 */       _sb_.append(",");
/* 923 */       _sb_.append(this.mifangcfgendtime);
/* 924 */       _sb_.append(",");
/* 925 */       _sb_.append(this.mifangyaocailist);
/* 926 */       _sb_.append(")");
/* 927 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MiFang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */