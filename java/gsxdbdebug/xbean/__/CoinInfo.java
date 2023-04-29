/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class CoinInfo extends XBean implements xbean.CoinInfo
/*      */ {
/*      */   private long src_total;
/*      */   private long src_total_cost;
/*      */   private long src_reset_time;
/*      */   private long dst_total;
/*      */   private long dst_total_cost;
/*      */   private long dst_reset_time;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.src_total = 0L;
/*   29 */     this.src_total_cost = 0L;
/*   30 */     this.src_reset_time = 0L;
/*   31 */     this.dst_total = 0L;
/*   32 */     this.dst_total_cost = 0L;
/*   33 */     this.dst_reset_time = 0L;
/*      */   }
/*      */   
/*      */   CoinInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.src_total = 0L;
/*   40 */     this.src_total_cost = 0L;
/*   41 */     this.src_reset_time = 0L;
/*   42 */     this.dst_total = 0L;
/*   43 */     this.dst_total_cost = 0L;
/*   44 */     this.dst_reset_time = 0L;
/*      */   }
/*      */   
/*      */   public CoinInfo()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CoinInfo(CoinInfo _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CoinInfo(xbean.CoinInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof CoinInfo)) { assign((CoinInfo)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CoinInfo _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.src_total = _o_.src_total;
/*   70 */     this.src_total_cost = _o_.src_total_cost;
/*   71 */     this.src_reset_time = _o_.src_reset_time;
/*   72 */     this.dst_total = _o_.dst_total;
/*   73 */     this.dst_total_cost = _o_.dst_total_cost;
/*   74 */     this.dst_reset_time = _o_.dst_reset_time;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   79 */     this.src_total = _o_.src_total;
/*   80 */     this.src_total_cost = _o_.src_total_cost;
/*   81 */     this.src_reset_time = _o_.src_reset_time;
/*   82 */     this.dst_total = _o_.dst_total;
/*   83 */     this.dst_total_cost = _o_.dst_total_cost;
/*   84 */     this.dst_reset_time = _o_.dst_reset_time;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     _os_.marshal(this.src_total);
/*   92 */     _os_.marshal(this.src_total_cost);
/*   93 */     _os_.marshal(this.src_reset_time);
/*   94 */     _os_.marshal(this.dst_total);
/*   95 */     _os_.marshal(this.dst_total_cost);
/*   96 */     _os_.marshal(this.dst_reset_time);
/*   97 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  103 */     _xdb_verify_unsafe_();
/*  104 */     this.src_total = _os_.unmarshal_long();
/*  105 */     this.src_total_cost = _os_.unmarshal_long();
/*  106 */     this.src_reset_time = _os_.unmarshal_long();
/*  107 */     this.dst_total = _os_.unmarshal_long();
/*  108 */     this.dst_total_cost = _os_.unmarshal_long();
/*  109 */     this.dst_reset_time = _os_.unmarshal_long();
/*  110 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  116 */     _xdb_verify_unsafe_();
/*  117 */     int _size_ = 0;
/*  118 */     _size_ += CodedOutputStream.computeInt64Size(1, this.src_total);
/*  119 */     _size_ += CodedOutputStream.computeInt64Size(2, this.src_total_cost);
/*  120 */     _size_ += CodedOutputStream.computeInt64Size(3, this.src_reset_time);
/*  121 */     _size_ += CodedOutputStream.computeInt64Size(4, this.dst_total);
/*  122 */     _size_ += CodedOutputStream.computeInt64Size(5, this.dst_total_cost);
/*  123 */     _size_ += CodedOutputStream.computeInt64Size(6, this.dst_reset_time);
/*  124 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  130 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  133 */       _output_.writeInt64(1, this.src_total);
/*  134 */       _output_.writeInt64(2, this.src_total_cost);
/*  135 */       _output_.writeInt64(3, this.src_reset_time);
/*  136 */       _output_.writeInt64(4, this.dst_total);
/*  137 */       _output_.writeInt64(5, this.dst_total_cost);
/*  138 */       _output_.writeInt64(6, this.dst_reset_time);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  142 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  144 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  150 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  153 */       boolean done = false;
/*  154 */       while (!done)
/*      */       {
/*  156 */         int tag = _input_.readTag();
/*  157 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  161 */           done = true;
/*  162 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  166 */           this.src_total = _input_.readInt64();
/*  167 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  171 */           this.src_total_cost = _input_.readInt64();
/*  172 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  176 */           this.src_reset_time = _input_.readInt64();
/*  177 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  181 */           this.dst_total = _input_.readInt64();
/*  182 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  186 */           this.dst_total_cost = _input_.readInt64();
/*  187 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  191 */           this.dst_reset_time = _input_.readInt64();
/*  192 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  196 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  198 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  207 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  211 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  213 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CoinInfo copy()
/*      */   {
/*  219 */     _xdb_verify_unsafe_();
/*  220 */     return new CoinInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CoinInfo toData()
/*      */   {
/*  226 */     _xdb_verify_unsafe_();
/*  227 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CoinInfo toBean()
/*      */   {
/*  232 */     _xdb_verify_unsafe_();
/*  233 */     return new CoinInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CoinInfo toDataIf()
/*      */   {
/*  239 */     _xdb_verify_unsafe_();
/*  240 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CoinInfo toBeanIf()
/*      */   {
/*  245 */     _xdb_verify_unsafe_();
/*  246 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  252 */     _xdb_verify_unsafe_();
/*  253 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSrc_total()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return this.src_total;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSrc_total_cost()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return this.src_total_cost;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSrc_reset_time()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return this.src_reset_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getDst_total()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return this.dst_total;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getDst_total_cost()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return this.dst_total_cost;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getDst_reset_time()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this.dst_reset_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSrc_total(long _v_)
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     Logs.logIf(new LogKey(this, "src_total")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  313 */         new LogLong(this, CoinInfo.this.src_total)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  317 */             CoinInfo.this.src_total = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  321 */     });
/*  322 */     this.src_total = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSrc_total_cost(long _v_)
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     Logs.logIf(new LogKey(this, "src_total_cost")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  334 */         new LogLong(this, CoinInfo.this.src_total_cost)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  338 */             CoinInfo.this.src_total_cost = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  342 */     });
/*  343 */     this.src_total_cost = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSrc_reset_time(long _v_)
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     Logs.logIf(new LogKey(this, "src_reset_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  355 */         new LogLong(this, CoinInfo.this.src_reset_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  359 */             CoinInfo.this.src_reset_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  363 */     });
/*  364 */     this.src_reset_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDst_total(long _v_)
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     Logs.logIf(new LogKey(this, "dst_total")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  376 */         new LogLong(this, CoinInfo.this.dst_total)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  380 */             CoinInfo.this.dst_total = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  384 */     });
/*  385 */     this.dst_total = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDst_total_cost(long _v_)
/*      */   {
/*  392 */     _xdb_verify_unsafe_();
/*  393 */     Logs.logIf(new LogKey(this, "dst_total_cost")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  397 */         new LogLong(this, CoinInfo.this.dst_total_cost)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  401 */             CoinInfo.this.dst_total_cost = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  405 */     });
/*  406 */     this.dst_total_cost = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDst_reset_time(long _v_)
/*      */   {
/*  413 */     _xdb_verify_unsafe_();
/*  414 */     Logs.logIf(new LogKey(this, "dst_reset_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  418 */         new LogLong(this, CoinInfo.this.dst_reset_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  422 */             CoinInfo.this.dst_reset_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  426 */     });
/*  427 */     this.dst_reset_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     CoinInfo _o_ = null;
/*  435 */     if ((_o1_ instanceof CoinInfo)) { _o_ = (CoinInfo)_o1_;
/*  436 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  437 */       return false;
/*  438 */     if (this.src_total != _o_.src_total) return false;
/*  439 */     if (this.src_total_cost != _o_.src_total_cost) return false;
/*  440 */     if (this.src_reset_time != _o_.src_reset_time) return false;
/*  441 */     if (this.dst_total != _o_.dst_total) return false;
/*  442 */     if (this.dst_total_cost != _o_.dst_total_cost) return false;
/*  443 */     if (this.dst_reset_time != _o_.dst_reset_time) return false;
/*  444 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     int _h_ = 0;
/*  452 */     _h_ = (int)(_h_ + this.src_total);
/*  453 */     _h_ = (int)(_h_ + this.src_total_cost);
/*  454 */     _h_ = (int)(_h_ + this.src_reset_time);
/*  455 */     _h_ = (int)(_h_ + this.dst_total);
/*  456 */     _h_ = (int)(_h_ + this.dst_total_cost);
/*  457 */     _h_ = (int)(_h_ + this.dst_reset_time);
/*  458 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*  465 */     StringBuilder _sb_ = new StringBuilder();
/*  466 */     _sb_.append("(");
/*  467 */     _sb_.append(this.src_total);
/*  468 */     _sb_.append(",");
/*  469 */     _sb_.append(this.src_total_cost);
/*  470 */     _sb_.append(",");
/*  471 */     _sb_.append(this.src_reset_time);
/*  472 */     _sb_.append(",");
/*  473 */     _sb_.append(this.dst_total);
/*  474 */     _sb_.append(",");
/*  475 */     _sb_.append(this.dst_total_cost);
/*  476 */     _sb_.append(",");
/*  477 */     _sb_.append(this.dst_reset_time);
/*  478 */     _sb_.append(")");
/*  479 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  485 */     ListenableBean lb = new ListenableBean();
/*  486 */     lb.add(new ListenableChanged().setVarName("src_total"));
/*  487 */     lb.add(new ListenableChanged().setVarName("src_total_cost"));
/*  488 */     lb.add(new ListenableChanged().setVarName("src_reset_time"));
/*  489 */     lb.add(new ListenableChanged().setVarName("dst_total"));
/*  490 */     lb.add(new ListenableChanged().setVarName("dst_total_cost"));
/*  491 */     lb.add(new ListenableChanged().setVarName("dst_reset_time"));
/*  492 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CoinInfo {
/*      */     private Const() {}
/*      */     
/*      */     CoinInfo nThis() {
/*  499 */       return CoinInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  505 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CoinInfo copy()
/*      */     {
/*  511 */       return CoinInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CoinInfo toData()
/*      */     {
/*  517 */       return CoinInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CoinInfo toBean()
/*      */     {
/*  522 */       return CoinInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CoinInfo toDataIf()
/*      */     {
/*  528 */       return CoinInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CoinInfo toBeanIf()
/*      */     {
/*  533 */       return CoinInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSrc_total()
/*      */     {
/*  540 */       CoinInfo.this._xdb_verify_unsafe_();
/*  541 */       return CoinInfo.this.src_total;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSrc_total_cost()
/*      */     {
/*  548 */       CoinInfo.this._xdb_verify_unsafe_();
/*  549 */       return CoinInfo.this.src_total_cost;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSrc_reset_time()
/*      */     {
/*  556 */       CoinInfo.this._xdb_verify_unsafe_();
/*  557 */       return CoinInfo.this.src_reset_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDst_total()
/*      */     {
/*  564 */       CoinInfo.this._xdb_verify_unsafe_();
/*  565 */       return CoinInfo.this.dst_total;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDst_total_cost()
/*      */     {
/*  572 */       CoinInfo.this._xdb_verify_unsafe_();
/*  573 */       return CoinInfo.this.dst_total_cost;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDst_reset_time()
/*      */     {
/*  580 */       CoinInfo.this._xdb_verify_unsafe_();
/*  581 */       return CoinInfo.this.dst_reset_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSrc_total(long _v_)
/*      */     {
/*  588 */       CoinInfo.this._xdb_verify_unsafe_();
/*  589 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSrc_total_cost(long _v_)
/*      */     {
/*  596 */       CoinInfo.this._xdb_verify_unsafe_();
/*  597 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSrc_reset_time(long _v_)
/*      */     {
/*  604 */       CoinInfo.this._xdb_verify_unsafe_();
/*  605 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDst_total(long _v_)
/*      */     {
/*  612 */       CoinInfo.this._xdb_verify_unsafe_();
/*  613 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDst_total_cost(long _v_)
/*      */     {
/*  620 */       CoinInfo.this._xdb_verify_unsafe_();
/*  621 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDst_reset_time(long _v_)
/*      */     {
/*  628 */       CoinInfo.this._xdb_verify_unsafe_();
/*  629 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  635 */       CoinInfo.this._xdb_verify_unsafe_();
/*  636 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  642 */       CoinInfo.this._xdb_verify_unsafe_();
/*  643 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  649 */       return CoinInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  655 */       return CoinInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  661 */       CoinInfo.this._xdb_verify_unsafe_();
/*  662 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  668 */       return CoinInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  674 */       return CoinInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  680 */       CoinInfo.this._xdb_verify_unsafe_();
/*  681 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  687 */       return CoinInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  693 */       return CoinInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  699 */       return CoinInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  705 */       return CoinInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  711 */       return CoinInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  717 */       return CoinInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  723 */       return CoinInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CoinInfo
/*      */   {
/*      */     private long src_total;
/*      */     
/*      */     private long src_total_cost;
/*      */     
/*      */     private long src_reset_time;
/*      */     
/*      */     private long dst_total;
/*      */     
/*      */     private long dst_total_cost;
/*      */     
/*      */     private long dst_reset_time;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  745 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  750 */       this.src_total = 0L;
/*  751 */       this.src_total_cost = 0L;
/*  752 */       this.src_reset_time = 0L;
/*  753 */       this.dst_total = 0L;
/*  754 */       this.dst_total_cost = 0L;
/*  755 */       this.dst_reset_time = 0L;
/*      */     }
/*      */     
/*      */     Data(xbean.CoinInfo _o1_)
/*      */     {
/*  760 */       if ((_o1_ instanceof CoinInfo)) { assign((CoinInfo)_o1_);
/*  761 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  762 */       } else if ((_o1_ instanceof CoinInfo.Const)) assign(((CoinInfo.Const)_o1_).nThis()); else {
/*  763 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CoinInfo _o_) {
/*  768 */       this.src_total = _o_.src_total;
/*  769 */       this.src_total_cost = _o_.src_total_cost;
/*  770 */       this.src_reset_time = _o_.src_reset_time;
/*  771 */       this.dst_total = _o_.dst_total;
/*  772 */       this.dst_total_cost = _o_.dst_total_cost;
/*  773 */       this.dst_reset_time = _o_.dst_reset_time;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  778 */       this.src_total = _o_.src_total;
/*  779 */       this.src_total_cost = _o_.src_total_cost;
/*  780 */       this.src_reset_time = _o_.src_reset_time;
/*  781 */       this.dst_total = _o_.dst_total;
/*  782 */       this.dst_total_cost = _o_.dst_total_cost;
/*  783 */       this.dst_reset_time = _o_.dst_reset_time;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  789 */       _os_.marshal(this.src_total);
/*  790 */       _os_.marshal(this.src_total_cost);
/*  791 */       _os_.marshal(this.src_reset_time);
/*  792 */       _os_.marshal(this.dst_total);
/*  793 */       _os_.marshal(this.dst_total_cost);
/*  794 */       _os_.marshal(this.dst_reset_time);
/*  795 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  801 */       this.src_total = _os_.unmarshal_long();
/*  802 */       this.src_total_cost = _os_.unmarshal_long();
/*  803 */       this.src_reset_time = _os_.unmarshal_long();
/*  804 */       this.dst_total = _os_.unmarshal_long();
/*  805 */       this.dst_total_cost = _os_.unmarshal_long();
/*  806 */       this.dst_reset_time = _os_.unmarshal_long();
/*  807 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  813 */       int _size_ = 0;
/*  814 */       _size_ += CodedOutputStream.computeInt64Size(1, this.src_total);
/*  815 */       _size_ += CodedOutputStream.computeInt64Size(2, this.src_total_cost);
/*  816 */       _size_ += CodedOutputStream.computeInt64Size(3, this.src_reset_time);
/*  817 */       _size_ += CodedOutputStream.computeInt64Size(4, this.dst_total);
/*  818 */       _size_ += CodedOutputStream.computeInt64Size(5, this.dst_total_cost);
/*  819 */       _size_ += CodedOutputStream.computeInt64Size(6, this.dst_reset_time);
/*  820 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  828 */         _output_.writeInt64(1, this.src_total);
/*  829 */         _output_.writeInt64(2, this.src_total_cost);
/*  830 */         _output_.writeInt64(3, this.src_reset_time);
/*  831 */         _output_.writeInt64(4, this.dst_total);
/*  832 */         _output_.writeInt64(5, this.dst_total_cost);
/*  833 */         _output_.writeInt64(6, this.dst_reset_time);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  837 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  839 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  847 */         boolean done = false;
/*  848 */         while (!done)
/*      */         {
/*  850 */           int tag = _input_.readTag();
/*  851 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  855 */             done = true;
/*  856 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  860 */             this.src_total = _input_.readInt64();
/*  861 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  865 */             this.src_total_cost = _input_.readInt64();
/*  866 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  870 */             this.src_reset_time = _input_.readInt64();
/*  871 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  875 */             this.dst_total = _input_.readInt64();
/*  876 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  880 */             this.dst_total_cost = _input_.readInt64();
/*  881 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  885 */             this.dst_reset_time = _input_.readInt64();
/*  886 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  890 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  892 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  901 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  905 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  907 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CoinInfo copy()
/*      */     {
/*  913 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CoinInfo toData()
/*      */     {
/*  919 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CoinInfo toBean()
/*      */     {
/*  924 */       return new CoinInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CoinInfo toDataIf()
/*      */     {
/*  930 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CoinInfo toBeanIf()
/*      */     {
/*  935 */       return new CoinInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  949 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  953 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/*  957 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  961 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  965 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSrc_total()
/*      */     {
/*  972 */       return this.src_total;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSrc_total_cost()
/*      */     {
/*  979 */       return this.src_total_cost;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSrc_reset_time()
/*      */     {
/*  986 */       return this.src_reset_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDst_total()
/*      */     {
/*  993 */       return this.dst_total;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDst_total_cost()
/*      */     {
/* 1000 */       return this.dst_total_cost;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDst_reset_time()
/*      */     {
/* 1007 */       return this.dst_reset_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSrc_total(long _v_)
/*      */     {
/* 1014 */       this.src_total = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSrc_total_cost(long _v_)
/*      */     {
/* 1021 */       this.src_total_cost = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSrc_reset_time(long _v_)
/*      */     {
/* 1028 */       this.src_reset_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDst_total(long _v_)
/*      */     {
/* 1035 */       this.dst_total = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDst_total_cost(long _v_)
/*      */     {
/* 1042 */       this.dst_total_cost = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDst_reset_time(long _v_)
/*      */     {
/* 1049 */       this.dst_reset_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1055 */       if (!(_o1_ instanceof Data)) return false;
/* 1056 */       Data _o_ = (Data)_o1_;
/* 1057 */       if (this.src_total != _o_.src_total) return false;
/* 1058 */       if (this.src_total_cost != _o_.src_total_cost) return false;
/* 1059 */       if (this.src_reset_time != _o_.src_reset_time) return false;
/* 1060 */       if (this.dst_total != _o_.dst_total) return false;
/* 1061 */       if (this.dst_total_cost != _o_.dst_total_cost) return false;
/* 1062 */       if (this.dst_reset_time != _o_.dst_reset_time) return false;
/* 1063 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1069 */       int _h_ = 0;
/* 1070 */       _h_ = (int)(_h_ + this.src_total);
/* 1071 */       _h_ = (int)(_h_ + this.src_total_cost);
/* 1072 */       _h_ = (int)(_h_ + this.src_reset_time);
/* 1073 */       _h_ = (int)(_h_ + this.dst_total);
/* 1074 */       _h_ = (int)(_h_ + this.dst_total_cost);
/* 1075 */       _h_ = (int)(_h_ + this.dst_reset_time);
/* 1076 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1082 */       StringBuilder _sb_ = new StringBuilder();
/* 1083 */       _sb_.append("(");
/* 1084 */       _sb_.append(this.src_total);
/* 1085 */       _sb_.append(",");
/* 1086 */       _sb_.append(this.src_total_cost);
/* 1087 */       _sb_.append(",");
/* 1088 */       _sb_.append(this.src_reset_time);
/* 1089 */       _sb_.append(",");
/* 1090 */       _sb_.append(this.dst_total);
/* 1091 */       _sb_.append(",");
/* 1092 */       _sb_.append(this.dst_total_cost);
/* 1093 */       _sb_.append(",");
/* 1094 */       _sb_.append(this.dst_reset_time);
/* 1095 */       _sb_.append(")");
/* 1096 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CoinInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */