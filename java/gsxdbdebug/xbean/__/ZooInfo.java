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
/*     */ 
/*     */ public final class ZooInfo extends XBean implements xbean.ZooInfo
/*     */ {
/*     */   private ArrayList<Long> animals;
/*     */   private long clean_check_time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.animals.clear();
/*  21 */     this.clean_check_time = 0L;
/*     */   }
/*     */   
/*     */   ZooInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.animals = new ArrayList();
/*     */   }
/*     */   
/*     */   public ZooInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ZooInfo(ZooInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ZooInfo(xbean.ZooInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof ZooInfo)) { assign((ZooInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ZooInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.animals = new ArrayList();
/*  53 */     this.animals.addAll(_o_.animals);
/*  54 */     this.clean_check_time = _o_.clean_check_time;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.animals = new ArrayList();
/*  60 */     this.animals.addAll(_o_.animals);
/*  61 */     this.clean_check_time = _o_.clean_check_time;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _xdb_verify_unsafe_();
/*  68 */     _os_.compact_uint32(this.animals.size());
/*  69 */     for (Long _v_ : this.animals)
/*     */     {
/*  71 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  73 */     _os_.marshal(this.clean_check_time);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  83 */       long _v_ = 0L;
/*  84 */       _v_ = _os_.unmarshal_long();
/*  85 */       this.animals.add(Long.valueOf(_v_));
/*     */     }
/*  87 */     this.clean_check_time = _os_.unmarshal_long();
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     int _size_ = 0;
/*  96 */     for (Long _v_ : this.animals)
/*     */     {
/*  98 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */     }
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(2, this.clean_check_time);
/* 101 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 110 */       for (Long _v_ : this.animals)
/*     */       {
/* 112 */         _output_.writeInt64(1, _v_.longValue());
/*     */       }
/* 114 */       _output_.writeInt64(2, this.clean_check_time);
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
/* 142 */           long _v_ = 0L;
/* 143 */           _v_ = _input_.readInt64();
/* 144 */           this.animals.add(Long.valueOf(_v_));
/* 145 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 149 */           this.clean_check_time = _input_.readInt64();
/* 150 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 154 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 156 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 165 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 169 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 171 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ZooInfo copy()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new ZooInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ZooInfo toData()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ZooInfo toBean()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new ZooInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ZooInfo toDataIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ZooInfo toBeanIf()
/*     */   {
/* 203 */     _xdb_verify_unsafe_();
/* 204 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 210 */     _xdb_verify_unsafe_();
/* 211 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getAnimals()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return xdb.Logs.logList(new LogKey(this, "animals"), this.animals);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getAnimalsAsData()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/*     */     
/* 227 */     ZooInfo _o_ = this;
/* 228 */     List<Long> animals = new ArrayList();
/* 229 */     animals.addAll(_o_.animals);
/* 230 */     return animals;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getClean_check_time()
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     return this.clean_check_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setClean_check_time(long _v_)
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     xdb.Logs.logIf(new LogKey(this, "clean_check_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 250 */         new xdb.logs.LogLong(this, ZooInfo.this.clean_check_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 254 */             ZooInfo.this.clean_check_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 258 */     });
/* 259 */     this.clean_check_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     ZooInfo _o_ = null;
/* 267 */     if ((_o1_ instanceof ZooInfo)) { _o_ = (ZooInfo)_o1_;
/* 268 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 269 */       return false;
/* 270 */     if (!this.animals.equals(_o_.animals)) return false;
/* 271 */     if (this.clean_check_time != _o_.clean_check_time) return false;
/* 272 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     int _h_ = 0;
/* 280 */     _h_ += this.animals.hashCode();
/* 281 */     _h_ = (int)(_h_ + this.clean_check_time);
/* 282 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     StringBuilder _sb_ = new StringBuilder();
/* 290 */     _sb_.append("(");
/* 291 */     _sb_.append(this.animals);
/* 292 */     _sb_.append(",");
/* 293 */     _sb_.append(this.clean_check_time);
/* 294 */     _sb_.append(")");
/* 295 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 301 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 302 */     lb.add(new xdb.logs.ListenableChanged().setVarName("animals"));
/* 303 */     lb.add(new xdb.logs.ListenableChanged().setVarName("clean_check_time"));
/* 304 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ZooInfo {
/*     */     private Const() {}
/*     */     
/*     */     ZooInfo nThis() {
/* 311 */       return ZooInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 317 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZooInfo copy()
/*     */     {
/* 323 */       return ZooInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZooInfo toData()
/*     */     {
/* 329 */       return ZooInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ZooInfo toBean()
/*     */     {
/* 334 */       return ZooInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZooInfo toDataIf()
/*     */     {
/* 340 */       return ZooInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ZooInfo toBeanIf()
/*     */     {
/* 345 */       return ZooInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAnimals()
/*     */     {
/* 352 */       ZooInfo.this._xdb_verify_unsafe_();
/* 353 */       return xdb.Consts.constList(ZooInfo.this.animals);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getAnimalsAsData()
/*     */     {
/* 359 */       ZooInfo.this._xdb_verify_unsafe_();
/*     */       
/* 361 */       ZooInfo _o_ = ZooInfo.this;
/* 362 */       List<Long> animals = new ArrayList();
/* 363 */       animals.addAll(_o_.animals);
/* 364 */       return animals;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getClean_check_time()
/*     */     {
/* 371 */       ZooInfo.this._xdb_verify_unsafe_();
/* 372 */       return ZooInfo.this.clean_check_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setClean_check_time(long _v_)
/*     */     {
/* 379 */       ZooInfo.this._xdb_verify_unsafe_();
/* 380 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 386 */       ZooInfo.this._xdb_verify_unsafe_();
/* 387 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 393 */       ZooInfo.this._xdb_verify_unsafe_();
/* 394 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 400 */       return ZooInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 406 */       return ZooInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 412 */       ZooInfo.this._xdb_verify_unsafe_();
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 419 */       return ZooInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 425 */       return ZooInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 431 */       ZooInfo.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 438 */       return ZooInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 444 */       return ZooInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 450 */       return ZooInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 456 */       return ZooInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 462 */       return ZooInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 468 */       return ZooInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 474 */       return ZooInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ZooInfo
/*     */   {
/*     */     private ArrayList<Long> animals;
/*     */     
/*     */     private long clean_check_time;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 488 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 493 */       this.animals = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.ZooInfo _o1_)
/*     */     {
/* 498 */       if ((_o1_ instanceof ZooInfo)) { assign((ZooInfo)_o1_);
/* 499 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 500 */       } else if ((_o1_ instanceof ZooInfo.Const)) assign(((ZooInfo.Const)_o1_).nThis()); else {
/* 501 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ZooInfo _o_) {
/* 506 */       this.animals = new ArrayList();
/* 507 */       this.animals.addAll(_o_.animals);
/* 508 */       this.clean_check_time = _o_.clean_check_time;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 513 */       this.animals = new ArrayList();
/* 514 */       this.animals.addAll(_o_.animals);
/* 515 */       this.clean_check_time = _o_.clean_check_time;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       _os_.compact_uint32(this.animals.size());
/* 522 */       for (Long _v_ : this.animals)
/*     */       {
/* 524 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 526 */       _os_.marshal(this.clean_check_time);
/* 527 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 533 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 535 */         long _v_ = 0L;
/* 536 */         _v_ = _os_.unmarshal_long();
/* 537 */         this.animals.add(Long.valueOf(_v_));
/*     */       }
/* 539 */       this.clean_check_time = _os_.unmarshal_long();
/* 540 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 546 */       int _size_ = 0;
/* 547 */       for (Long _v_ : this.animals)
/*     */       {
/* 549 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */       }
/* 551 */       _size_ += CodedOutputStream.computeInt64Size(2, this.clean_check_time);
/* 552 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 560 */         for (Long _v_ : this.animals)
/*     */         {
/* 562 */           _output_.writeInt64(1, _v_.longValue());
/*     */         }
/* 564 */         _output_.writeInt64(2, this.clean_check_time);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 568 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 570 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 578 */         boolean done = false;
/* 579 */         while (!done)
/*     */         {
/* 581 */           int tag = _input_.readTag();
/* 582 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 586 */             done = true;
/* 587 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 591 */             long _v_ = 0L;
/* 592 */             _v_ = _input_.readInt64();
/* 593 */             this.animals.add(Long.valueOf(_v_));
/* 594 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 598 */             this.clean_check_time = _input_.readInt64();
/* 599 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 603 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 605 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 614 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 618 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 620 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZooInfo copy()
/*     */     {
/* 626 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZooInfo toData()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ZooInfo toBean()
/*     */     {
/* 637 */       return new ZooInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZooInfo toDataIf()
/*     */     {
/* 643 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ZooInfo toBeanIf()
/*     */     {
/* 648 */       return new ZooInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 654 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 658 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 662 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 666 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 670 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 674 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 678 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAnimals()
/*     */     {
/* 685 */       return this.animals;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAnimalsAsData()
/*     */     {
/* 692 */       return this.animals;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getClean_check_time()
/*     */     {
/* 699 */       return this.clean_check_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setClean_check_time(long _v_)
/*     */     {
/* 706 */       this.clean_check_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 712 */       if (!(_o1_ instanceof Data)) return false;
/* 713 */       Data _o_ = (Data)_o1_;
/* 714 */       if (!this.animals.equals(_o_.animals)) return false;
/* 715 */       if (this.clean_check_time != _o_.clean_check_time) return false;
/* 716 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 722 */       int _h_ = 0;
/* 723 */       _h_ += this.animals.hashCode();
/* 724 */       _h_ = (int)(_h_ + this.clean_check_time);
/* 725 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 731 */       StringBuilder _sb_ = new StringBuilder();
/* 732 */       _sb_.append("(");
/* 733 */       _sb_.append(this.animals);
/* 734 */       _sb_.append(",");
/* 735 */       _sb_.append(this.clean_check_time);
/* 736 */       _sb_.append(")");
/* 737 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ZooInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */