/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class SingleCrossFieldRank extends XBean implements xbean.SingleCrossFieldRank
/*     */ {
/*     */   private int season;
/*     */   private LinkedList<Long> rank_list;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.season = 0;
/*  21 */     this.rank_list.clear();
/*     */   }
/*     */   
/*     */   SingleCrossFieldRank(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.rank_list = new LinkedList();
/*     */   }
/*     */   
/*     */   public SingleCrossFieldRank()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SingleCrossFieldRank(SingleCrossFieldRank _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SingleCrossFieldRank(xbean.SingleCrossFieldRank _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof SingleCrossFieldRank)) { assign((SingleCrossFieldRank)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SingleCrossFieldRank _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.season = _o_.season;
/*  53 */     this.rank_list = new LinkedList();
/*  54 */     this.rank_list.addAll(_o_.rank_list);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.season = _o_.season;
/*  60 */     this.rank_list = new LinkedList();
/*  61 */     this.rank_list.addAll(_o_.rank_list);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _xdb_verify_unsafe_();
/*  68 */     _os_.marshal(this.season);
/*  69 */     _os_.compact_uint32(this.rank_list.size());
/*  70 */     for (Long _v_ : this.rank_list)
/*     */     {
/*  72 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.season = _os_.unmarshal_int();
/*  82 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  84 */       long _v_ = 0L;
/*  85 */       _v_ = _os_.unmarshal_long();
/*  86 */       this.rank_list.add(Long.valueOf(_v_));
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     int _size_ = 0;
/*  96 */     _size_ += CodedOutputStream.computeInt32Size(1, this.season);
/*  97 */     for (Long _v_ : this.rank_list)
/*     */     {
/*  99 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */     }
/* 101 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 110 */       _output_.writeInt32(1, this.season);
/* 111 */       for (Long _v_ : this.rank_list)
/*     */       {
/* 113 */         _output_.writeInt64(2, _v_.longValue());
/*     */       }
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
/* 142 */           this.season = _input_.readInt32();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           long _v_ = 0L;
/* 148 */           _v_ = _input_.readInt64();
/* 149 */           this.rank_list.add(Long.valueOf(_v_));
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
/*     */   public xbean.SingleCrossFieldRank copy()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new SingleCrossFieldRank(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SingleCrossFieldRank toData()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SingleCrossFieldRank toBean()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new SingleCrossFieldRank(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SingleCrossFieldRank toDataIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SingleCrossFieldRank toBeanIf()
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
/*     */   public int getSeason()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return this.season;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getRank_list()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return xdb.Logs.logList(new LogKey(this, "rank_list"), this.rank_list);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getRank_listAsData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/*     */     
/* 235 */     SingleCrossFieldRank _o_ = this;
/* 236 */     List<Long> rank_list = new LinkedList();
/* 237 */     rank_list.addAll(_o_.rank_list);
/* 238 */     return rank_list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSeason(int _v_)
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     xdb.Logs.logIf(new LogKey(this, "season")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 250 */         new xdb.logs.LogInt(this, SingleCrossFieldRank.this.season)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 254 */             SingleCrossFieldRank.this.season = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 258 */     });
/* 259 */     this.season = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     SingleCrossFieldRank _o_ = null;
/* 267 */     if ((_o1_ instanceof SingleCrossFieldRank)) { _o_ = (SingleCrossFieldRank)_o1_;
/* 268 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 269 */       return false;
/* 270 */     if (this.season != _o_.season) return false;
/* 271 */     if (!this.rank_list.equals(_o_.rank_list)) return false;
/* 272 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     int _h_ = 0;
/* 280 */     _h_ += this.season;
/* 281 */     _h_ += this.rank_list.hashCode();
/* 282 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     StringBuilder _sb_ = new StringBuilder();
/* 290 */     _sb_.append("(");
/* 291 */     _sb_.append(this.season);
/* 292 */     _sb_.append(",");
/* 293 */     _sb_.append(this.rank_list);
/* 294 */     _sb_.append(")");
/* 295 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 301 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 302 */     lb.add(new xdb.logs.ListenableChanged().setVarName("season"));
/* 303 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rank_list"));
/* 304 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SingleCrossFieldRank {
/*     */     private Const() {}
/*     */     
/*     */     SingleCrossFieldRank nThis() {
/* 311 */       return SingleCrossFieldRank.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 317 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleCrossFieldRank copy()
/*     */     {
/* 323 */       return SingleCrossFieldRank.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleCrossFieldRank toData()
/*     */     {
/* 329 */       return SingleCrossFieldRank.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SingleCrossFieldRank toBean()
/*     */     {
/* 334 */       return SingleCrossFieldRank.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleCrossFieldRank toDataIf()
/*     */     {
/* 340 */       return SingleCrossFieldRank.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SingleCrossFieldRank toBeanIf()
/*     */     {
/* 345 */       return SingleCrossFieldRank.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSeason()
/*     */     {
/* 352 */       SingleCrossFieldRank.this._xdb_verify_unsafe_();
/* 353 */       return SingleCrossFieldRank.this.season;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRank_list()
/*     */     {
/* 360 */       SingleCrossFieldRank.this._xdb_verify_unsafe_();
/* 361 */       return xdb.Consts.constList(SingleCrossFieldRank.this.rank_list);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getRank_listAsData()
/*     */     {
/* 367 */       SingleCrossFieldRank.this._xdb_verify_unsafe_();
/*     */       
/* 369 */       SingleCrossFieldRank _o_ = SingleCrossFieldRank.this;
/* 370 */       List<Long> rank_list = new LinkedList();
/* 371 */       rank_list.addAll(_o_.rank_list);
/* 372 */       return rank_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSeason(int _v_)
/*     */     {
/* 379 */       SingleCrossFieldRank.this._xdb_verify_unsafe_();
/* 380 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 386 */       SingleCrossFieldRank.this._xdb_verify_unsafe_();
/* 387 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 393 */       SingleCrossFieldRank.this._xdb_verify_unsafe_();
/* 394 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 400 */       return SingleCrossFieldRank.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 406 */       return SingleCrossFieldRank.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 412 */       SingleCrossFieldRank.this._xdb_verify_unsafe_();
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 419 */       return SingleCrossFieldRank.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 425 */       return SingleCrossFieldRank.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 431 */       SingleCrossFieldRank.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 438 */       return SingleCrossFieldRank.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 444 */       return SingleCrossFieldRank.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 450 */       return SingleCrossFieldRank.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 456 */       return SingleCrossFieldRank.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 462 */       return SingleCrossFieldRank.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 468 */       return SingleCrossFieldRank.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 474 */       return SingleCrossFieldRank.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SingleCrossFieldRank
/*     */   {
/*     */     private int season;
/*     */     
/*     */     private LinkedList<Long> rank_list;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 488 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 493 */       this.rank_list = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.SingleCrossFieldRank _o1_)
/*     */     {
/* 498 */       if ((_o1_ instanceof SingleCrossFieldRank)) { assign((SingleCrossFieldRank)_o1_);
/* 499 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 500 */       } else if ((_o1_ instanceof SingleCrossFieldRank.Const)) assign(((SingleCrossFieldRank.Const)_o1_).nThis()); else {
/* 501 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SingleCrossFieldRank _o_) {
/* 506 */       this.season = _o_.season;
/* 507 */       this.rank_list = new LinkedList();
/* 508 */       this.rank_list.addAll(_o_.rank_list);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 513 */       this.season = _o_.season;
/* 514 */       this.rank_list = new LinkedList();
/* 515 */       this.rank_list.addAll(_o_.rank_list);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       _os_.marshal(this.season);
/* 522 */       _os_.compact_uint32(this.rank_list.size());
/* 523 */       for (Long _v_ : this.rank_list)
/*     */       {
/* 525 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 527 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 533 */       this.season = _os_.unmarshal_int();
/* 534 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 536 */         long _v_ = 0L;
/* 537 */         _v_ = _os_.unmarshal_long();
/* 538 */         this.rank_list.add(Long.valueOf(_v_));
/*     */       }
/* 540 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 546 */       int _size_ = 0;
/* 547 */       _size_ += CodedOutputStream.computeInt32Size(1, this.season);
/* 548 */       for (Long _v_ : this.rank_list)
/*     */       {
/* 550 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */       }
/* 552 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 560 */         _output_.writeInt32(1, this.season);
/* 561 */         for (Long _v_ : this.rank_list)
/*     */         {
/* 563 */           _output_.writeInt64(2, _v_.longValue());
/*     */         }
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
/* 591 */             this.season = _input_.readInt32();
/* 592 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 596 */             long _v_ = 0L;
/* 597 */             _v_ = _input_.readInt64();
/* 598 */             this.rank_list.add(Long.valueOf(_v_));
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
/*     */     public xbean.SingleCrossFieldRank copy()
/*     */     {
/* 626 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleCrossFieldRank toData()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SingleCrossFieldRank toBean()
/*     */     {
/* 637 */       return new SingleCrossFieldRank(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleCrossFieldRank toDataIf()
/*     */     {
/* 643 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SingleCrossFieldRank toBeanIf()
/*     */     {
/* 648 */       return new SingleCrossFieldRank(this, null, null);
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
/*     */     public int getSeason()
/*     */     {
/* 685 */       return this.season;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRank_list()
/*     */     {
/* 692 */       return this.rank_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRank_listAsData()
/*     */     {
/* 699 */       return this.rank_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSeason(int _v_)
/*     */     {
/* 706 */       this.season = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 712 */       if (!(_o1_ instanceof Data)) return false;
/* 713 */       Data _o_ = (Data)_o1_;
/* 714 */       if (this.season != _o_.season) return false;
/* 715 */       if (!this.rank_list.equals(_o_.rank_list)) return false;
/* 716 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 722 */       int _h_ = 0;
/* 723 */       _h_ += this.season;
/* 724 */       _h_ += this.rank_list.hashCode();
/* 725 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 731 */       StringBuilder _sb_ = new StringBuilder();
/* 732 */       _sb_.append("(");
/* 733 */       _sb_.append(this.season);
/* 734 */       _sb_.append(",");
/* 735 */       _sb_.append(this.rank_list);
/* 736 */       _sb_.append(")");
/* 737 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SingleCrossFieldRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */