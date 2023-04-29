/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class YuanBaoInfo extends XBean implements xbean.YuanBaoInfo
/*      */ {
/*      */   private long awardyuanbao;
/*      */   private long buyyuanbao;
/*      */   private long money;
/*      */   private long totalbuyyuanbao;
/*      */   private long totalawardyuanbao;
/*      */   private SetX<Long> buyorderid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.awardyuanbao = 0L;
/*   29 */     this.buyyuanbao = 0L;
/*   30 */     this.money = 0L;
/*   31 */     this.totalbuyyuanbao = 0L;
/*   32 */     this.totalawardyuanbao = 0L;
/*   33 */     this.buyorderid.clear();
/*      */   }
/*      */   
/*      */   YuanBaoInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.awardyuanbao = 0L;
/*   40 */     this.buyyuanbao = 0L;
/*   41 */     this.money = 0L;
/*   42 */     this.totalbuyyuanbao = 0L;
/*   43 */     this.totalawardyuanbao = 0L;
/*   44 */     this.buyorderid = new SetX();
/*      */   }
/*      */   
/*      */   public YuanBaoInfo()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public YuanBaoInfo(YuanBaoInfo _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   YuanBaoInfo(xbean.YuanBaoInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof YuanBaoInfo)) { assign((YuanBaoInfo)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(YuanBaoInfo _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.awardyuanbao = _o_.awardyuanbao;
/*   70 */     this.buyyuanbao = _o_.buyyuanbao;
/*   71 */     this.money = _o_.money;
/*   72 */     this.totalbuyyuanbao = _o_.totalbuyyuanbao;
/*   73 */     this.totalawardyuanbao = _o_.totalawardyuanbao;
/*   74 */     this.buyorderid = new SetX();
/*   75 */     this.buyorderid.addAll(_o_.buyorderid);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   80 */     this.awardyuanbao = _o_.awardyuanbao;
/*   81 */     this.buyyuanbao = _o_.buyyuanbao;
/*   82 */     this.money = _o_.money;
/*   83 */     this.totalbuyyuanbao = _o_.totalbuyyuanbao;
/*   84 */     this.totalawardyuanbao = _o_.totalawardyuanbao;
/*   85 */     this.buyorderid = new SetX();
/*   86 */     this.buyorderid.addAll(_o_.buyorderid);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   92 */     _xdb_verify_unsafe_();
/*   93 */     _os_.marshal(this.awardyuanbao);
/*   94 */     _os_.marshal(this.buyyuanbao);
/*   95 */     _os_.marshal(this.money);
/*   96 */     _os_.marshal(this.totalbuyyuanbao);
/*   97 */     _os_.marshal(this.totalawardyuanbao);
/*   98 */     _os_.compact_uint32(this.buyorderid.size());
/*   99 */     for (Long _v_ : this.buyorderid)
/*      */     {
/*  101 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  103 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  109 */     _xdb_verify_unsafe_();
/*  110 */     this.awardyuanbao = _os_.unmarshal_long();
/*  111 */     this.buyyuanbao = _os_.unmarshal_long();
/*  112 */     this.money = _os_.unmarshal_long();
/*  113 */     this.totalbuyyuanbao = _os_.unmarshal_long();
/*  114 */     this.totalawardyuanbao = _os_.unmarshal_long();
/*  115 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  117 */       long _v_ = 0L;
/*  118 */       _v_ = _os_.unmarshal_long();
/*  119 */       this.buyorderid.add(Long.valueOf(_v_));
/*      */     }
/*  121 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  127 */     _xdb_verify_unsafe_();
/*  128 */     int _size_ = 0;
/*  129 */     _size_ += CodedOutputStream.computeInt64Size(1, this.awardyuanbao);
/*  130 */     _size_ += CodedOutputStream.computeInt64Size(2, this.buyyuanbao);
/*  131 */     _size_ += CodedOutputStream.computeInt64Size(3, this.money);
/*  132 */     _size_ += CodedOutputStream.computeInt64Size(4, this.totalbuyyuanbao);
/*  133 */     _size_ += CodedOutputStream.computeInt64Size(5, this.totalawardyuanbao);
/*  134 */     for (Long _v_ : this.buyorderid)
/*      */     {
/*  136 */       _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */     }
/*  138 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  147 */       _output_.writeInt64(1, this.awardyuanbao);
/*  148 */       _output_.writeInt64(2, this.buyyuanbao);
/*  149 */       _output_.writeInt64(3, this.money);
/*  150 */       _output_.writeInt64(4, this.totalbuyyuanbao);
/*  151 */       _output_.writeInt64(5, this.totalawardyuanbao);
/*  152 */       for (Long _v_ : this.buyorderid)
/*      */       {
/*  154 */         _output_.writeInt64(6, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  159 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  161 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  167 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  170 */       boolean done = false;
/*  171 */       while (!done)
/*      */       {
/*  173 */         int tag = _input_.readTag();
/*  174 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  178 */           done = true;
/*  179 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  183 */           this.awardyuanbao = _input_.readInt64();
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  188 */           this.buyyuanbao = _input_.readInt64();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  193 */           this.money = _input_.readInt64();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  198 */           this.totalbuyyuanbao = _input_.readInt64();
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  203 */           this.totalawardyuanbao = _input_.readInt64();
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  208 */           long _v_ = 0L;
/*  209 */           _v_ = _input_.readInt64();
/*  210 */           this.buyorderid.add(Long.valueOf(_v_));
/*  211 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  215 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  217 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  226 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  230 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  232 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.YuanBaoInfo copy()
/*      */   {
/*  238 */     _xdb_verify_unsafe_();
/*  239 */     return new YuanBaoInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.YuanBaoInfo toData()
/*      */   {
/*  245 */     _xdb_verify_unsafe_();
/*  246 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.YuanBaoInfo toBean()
/*      */   {
/*  251 */     _xdb_verify_unsafe_();
/*  252 */     return new YuanBaoInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.YuanBaoInfo toDataIf()
/*      */   {
/*  258 */     _xdb_verify_unsafe_();
/*  259 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.YuanBaoInfo toBeanIf()
/*      */   {
/*  264 */     _xdb_verify_unsafe_();
/*  265 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  271 */     _xdb_verify_unsafe_();
/*  272 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAwardyuanbao()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return this.awardyuanbao;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBuyyuanbao()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return this.buyyuanbao;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMoney()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return this.money;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTotalbuyyuanbao()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return this.totalbuyyuanbao;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTotalawardyuanbao()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     return this.totalawardyuanbao;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getBuyorderid()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return xdb.Logs.logSet(new LogKey(this, "buyorderid"), this.buyorderid);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getBuyorderidAsData()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*      */     
/*  328 */     YuanBaoInfo _o_ = this;
/*  329 */     Set<Long> buyorderid = new SetX();
/*  330 */     buyorderid.addAll(_o_.buyorderid);
/*  331 */     return buyorderid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAwardyuanbao(long _v_)
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*  339 */     xdb.Logs.logIf(new LogKey(this, "awardyuanbao")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  343 */         new LogLong(this, YuanBaoInfo.this.awardyuanbao)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  347 */             YuanBaoInfo.this.awardyuanbao = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  351 */     });
/*  352 */     this.awardyuanbao = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBuyyuanbao(long _v_)
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*  360 */     xdb.Logs.logIf(new LogKey(this, "buyyuanbao")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  364 */         new LogLong(this, YuanBaoInfo.this.buyyuanbao)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  368 */             YuanBaoInfo.this.buyyuanbao = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  372 */     });
/*  373 */     this.buyyuanbao = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMoney(long _v_)
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     xdb.Logs.logIf(new LogKey(this, "money")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  385 */         new LogLong(this, YuanBaoInfo.this.money)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  389 */             YuanBaoInfo.this.money = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  393 */     });
/*  394 */     this.money = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotalbuyyuanbao(long _v_)
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     xdb.Logs.logIf(new LogKey(this, "totalbuyyuanbao")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  406 */         new LogLong(this, YuanBaoInfo.this.totalbuyyuanbao)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  410 */             YuanBaoInfo.this.totalbuyyuanbao = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  414 */     });
/*  415 */     this.totalbuyyuanbao = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotalawardyuanbao(long _v_)
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     xdb.Logs.logIf(new LogKey(this, "totalawardyuanbao")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  427 */         new LogLong(this, YuanBaoInfo.this.totalawardyuanbao)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  431 */             YuanBaoInfo.this.totalawardyuanbao = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  435 */     });
/*  436 */     this.totalawardyuanbao = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  442 */     _xdb_verify_unsafe_();
/*  443 */     YuanBaoInfo _o_ = null;
/*  444 */     if ((_o1_ instanceof YuanBaoInfo)) { _o_ = (YuanBaoInfo)_o1_;
/*  445 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  446 */       return false;
/*  447 */     if (this.awardyuanbao != _o_.awardyuanbao) return false;
/*  448 */     if (this.buyyuanbao != _o_.buyyuanbao) return false;
/*  449 */     if (this.money != _o_.money) return false;
/*  450 */     if (this.totalbuyyuanbao != _o_.totalbuyyuanbao) return false;
/*  451 */     if (this.totalawardyuanbao != _o_.totalawardyuanbao) return false;
/*  452 */     if (!this.buyorderid.equals(_o_.buyorderid)) return false;
/*  453 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     int _h_ = 0;
/*  461 */     _h_ = (int)(_h_ + this.awardyuanbao);
/*  462 */     _h_ = (int)(_h_ + this.buyyuanbao);
/*  463 */     _h_ = (int)(_h_ + this.money);
/*  464 */     _h_ = (int)(_h_ + this.totalbuyyuanbao);
/*  465 */     _h_ = (int)(_h_ + this.totalawardyuanbao);
/*  466 */     _h_ += this.buyorderid.hashCode();
/*  467 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     StringBuilder _sb_ = new StringBuilder();
/*  475 */     _sb_.append("(");
/*  476 */     _sb_.append(this.awardyuanbao);
/*  477 */     _sb_.append(",");
/*  478 */     _sb_.append(this.buyyuanbao);
/*  479 */     _sb_.append(",");
/*  480 */     _sb_.append(this.money);
/*  481 */     _sb_.append(",");
/*  482 */     _sb_.append(this.totalbuyyuanbao);
/*  483 */     _sb_.append(",");
/*  484 */     _sb_.append(this.totalawardyuanbao);
/*  485 */     _sb_.append(",");
/*  486 */     _sb_.append(this.buyorderid);
/*  487 */     _sb_.append(")");
/*  488 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  494 */     ListenableBean lb = new ListenableBean();
/*  495 */     lb.add(new ListenableChanged().setVarName("awardyuanbao"));
/*  496 */     lb.add(new ListenableChanged().setVarName("buyyuanbao"));
/*  497 */     lb.add(new ListenableChanged().setVarName("money"));
/*  498 */     lb.add(new ListenableChanged().setVarName("totalbuyyuanbao"));
/*  499 */     lb.add(new ListenableChanged().setVarName("totalawardyuanbao"));
/*  500 */     lb.add(new xdb.logs.ListenableSet().setVarName("buyorderid"));
/*  501 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.YuanBaoInfo {
/*      */     private Const() {}
/*      */     
/*      */     YuanBaoInfo nThis() {
/*  508 */       return YuanBaoInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  514 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.YuanBaoInfo copy()
/*      */     {
/*  520 */       return YuanBaoInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.YuanBaoInfo toData()
/*      */     {
/*  526 */       return YuanBaoInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.YuanBaoInfo toBean()
/*      */     {
/*  531 */       return YuanBaoInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.YuanBaoInfo toDataIf()
/*      */     {
/*  537 */       return YuanBaoInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.YuanBaoInfo toBeanIf()
/*      */     {
/*  542 */       return YuanBaoInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAwardyuanbao()
/*      */     {
/*  549 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  550 */       return YuanBaoInfo.this.awardyuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBuyyuanbao()
/*      */     {
/*  557 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  558 */       return YuanBaoInfo.this.buyyuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMoney()
/*      */     {
/*  565 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  566 */       return YuanBaoInfo.this.money;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotalbuyyuanbao()
/*      */     {
/*  573 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  574 */       return YuanBaoInfo.this.totalbuyyuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotalawardyuanbao()
/*      */     {
/*  581 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  582 */       return YuanBaoInfo.this.totalawardyuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getBuyorderid()
/*      */     {
/*  589 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  590 */       return xdb.Consts.constSet(YuanBaoInfo.this.buyorderid);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getBuyorderidAsData()
/*      */     {
/*  596 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*      */       
/*  598 */       YuanBaoInfo _o_ = YuanBaoInfo.this;
/*  599 */       Set<Long> buyorderid = new SetX();
/*  600 */       buyorderid.addAll(_o_.buyorderid);
/*  601 */       return buyorderid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAwardyuanbao(long _v_)
/*      */     {
/*  608 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  609 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuyyuanbao(long _v_)
/*      */     {
/*  616 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  617 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMoney(long _v_)
/*      */     {
/*  624 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  625 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotalbuyyuanbao(long _v_)
/*      */     {
/*  632 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  633 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotalawardyuanbao(long _v_)
/*      */     {
/*  640 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  641 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  647 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  648 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  654 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  655 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  661 */       return YuanBaoInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  667 */       return YuanBaoInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  673 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  674 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  680 */       return YuanBaoInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  686 */       return YuanBaoInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  692 */       YuanBaoInfo.this._xdb_verify_unsafe_();
/*  693 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  699 */       return YuanBaoInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  705 */       return YuanBaoInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  711 */       return YuanBaoInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  717 */       return YuanBaoInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  723 */       return YuanBaoInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  729 */       return YuanBaoInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  735 */       return YuanBaoInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.YuanBaoInfo
/*      */   {
/*      */     private long awardyuanbao;
/*      */     
/*      */     private long buyyuanbao;
/*      */     
/*      */     private long money;
/*      */     
/*      */     private long totalbuyyuanbao;
/*      */     
/*      */     private long totalawardyuanbao;
/*      */     
/*      */     private HashSet<Long> buyorderid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  757 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  762 */       this.awardyuanbao = 0L;
/*  763 */       this.buyyuanbao = 0L;
/*  764 */       this.money = 0L;
/*  765 */       this.totalbuyyuanbao = 0L;
/*  766 */       this.totalawardyuanbao = 0L;
/*  767 */       this.buyorderid = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.YuanBaoInfo _o1_)
/*      */     {
/*  772 */       if ((_o1_ instanceof YuanBaoInfo)) { assign((YuanBaoInfo)_o1_);
/*  773 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  774 */       } else if ((_o1_ instanceof YuanBaoInfo.Const)) assign(((YuanBaoInfo.Const)_o1_).nThis()); else {
/*  775 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(YuanBaoInfo _o_) {
/*  780 */       this.awardyuanbao = _o_.awardyuanbao;
/*  781 */       this.buyyuanbao = _o_.buyyuanbao;
/*  782 */       this.money = _o_.money;
/*  783 */       this.totalbuyyuanbao = _o_.totalbuyyuanbao;
/*  784 */       this.totalawardyuanbao = _o_.totalawardyuanbao;
/*  785 */       this.buyorderid = new HashSet();
/*  786 */       this.buyorderid.addAll(_o_.buyorderid);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  791 */       this.awardyuanbao = _o_.awardyuanbao;
/*  792 */       this.buyyuanbao = _o_.buyyuanbao;
/*  793 */       this.money = _o_.money;
/*  794 */       this.totalbuyyuanbao = _o_.totalbuyyuanbao;
/*  795 */       this.totalawardyuanbao = _o_.totalawardyuanbao;
/*  796 */       this.buyorderid = new HashSet();
/*  797 */       this.buyorderid.addAll(_o_.buyorderid);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  803 */       _os_.marshal(this.awardyuanbao);
/*  804 */       _os_.marshal(this.buyyuanbao);
/*  805 */       _os_.marshal(this.money);
/*  806 */       _os_.marshal(this.totalbuyyuanbao);
/*  807 */       _os_.marshal(this.totalawardyuanbao);
/*  808 */       _os_.compact_uint32(this.buyorderid.size());
/*  809 */       for (Long _v_ : this.buyorderid)
/*      */       {
/*  811 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  813 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  819 */       this.awardyuanbao = _os_.unmarshal_long();
/*  820 */       this.buyyuanbao = _os_.unmarshal_long();
/*  821 */       this.money = _os_.unmarshal_long();
/*  822 */       this.totalbuyyuanbao = _os_.unmarshal_long();
/*  823 */       this.totalawardyuanbao = _os_.unmarshal_long();
/*  824 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  826 */         long _v_ = 0L;
/*  827 */         _v_ = _os_.unmarshal_long();
/*  828 */         this.buyorderid.add(Long.valueOf(_v_));
/*      */       }
/*  830 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  836 */       int _size_ = 0;
/*  837 */       _size_ += CodedOutputStream.computeInt64Size(1, this.awardyuanbao);
/*  838 */       _size_ += CodedOutputStream.computeInt64Size(2, this.buyyuanbao);
/*  839 */       _size_ += CodedOutputStream.computeInt64Size(3, this.money);
/*  840 */       _size_ += CodedOutputStream.computeInt64Size(4, this.totalbuyyuanbao);
/*  841 */       _size_ += CodedOutputStream.computeInt64Size(5, this.totalawardyuanbao);
/*  842 */       for (Long _v_ : this.buyorderid)
/*      */       {
/*  844 */         _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */       }
/*  846 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  854 */         _output_.writeInt64(1, this.awardyuanbao);
/*  855 */         _output_.writeInt64(2, this.buyyuanbao);
/*  856 */         _output_.writeInt64(3, this.money);
/*  857 */         _output_.writeInt64(4, this.totalbuyyuanbao);
/*  858 */         _output_.writeInt64(5, this.totalawardyuanbao);
/*  859 */         for (Long _v_ : this.buyorderid)
/*      */         {
/*  861 */           _output_.writeInt64(6, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  866 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  868 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  876 */         boolean done = false;
/*  877 */         while (!done)
/*      */         {
/*  879 */           int tag = _input_.readTag();
/*  880 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  884 */             done = true;
/*  885 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  889 */             this.awardyuanbao = _input_.readInt64();
/*  890 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  894 */             this.buyyuanbao = _input_.readInt64();
/*  895 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  899 */             this.money = _input_.readInt64();
/*  900 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  904 */             this.totalbuyyuanbao = _input_.readInt64();
/*  905 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  909 */             this.totalawardyuanbao = _input_.readInt64();
/*  910 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  914 */             long _v_ = 0L;
/*  915 */             _v_ = _input_.readInt64();
/*  916 */             this.buyorderid.add(Long.valueOf(_v_));
/*  917 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  921 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  923 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  932 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  936 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  938 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.YuanBaoInfo copy()
/*      */     {
/*  944 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.YuanBaoInfo toData()
/*      */     {
/*  950 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.YuanBaoInfo toBean()
/*      */     {
/*  955 */       return new YuanBaoInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.YuanBaoInfo toDataIf()
/*      */     {
/*  961 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.YuanBaoInfo toBeanIf()
/*      */     {
/*  966 */       return new YuanBaoInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  972 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  976 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  980 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  984 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  988 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  992 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  996 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAwardyuanbao()
/*      */     {
/* 1003 */       return this.awardyuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBuyyuanbao()
/*      */     {
/* 1010 */       return this.buyyuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMoney()
/*      */     {
/* 1017 */       return this.money;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotalbuyyuanbao()
/*      */     {
/* 1024 */       return this.totalbuyyuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTotalawardyuanbao()
/*      */     {
/* 1031 */       return this.totalawardyuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getBuyorderid()
/*      */     {
/* 1038 */       return this.buyorderid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getBuyorderidAsData()
/*      */     {
/* 1045 */       return this.buyorderid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAwardyuanbao(long _v_)
/*      */     {
/* 1052 */       this.awardyuanbao = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuyyuanbao(long _v_)
/*      */     {
/* 1059 */       this.buyyuanbao = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMoney(long _v_)
/*      */     {
/* 1066 */       this.money = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotalbuyyuanbao(long _v_)
/*      */     {
/* 1073 */       this.totalbuyyuanbao = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotalawardyuanbao(long _v_)
/*      */     {
/* 1080 */       this.totalawardyuanbao = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1086 */       if (!(_o1_ instanceof Data)) return false;
/* 1087 */       Data _o_ = (Data)_o1_;
/* 1088 */       if (this.awardyuanbao != _o_.awardyuanbao) return false;
/* 1089 */       if (this.buyyuanbao != _o_.buyyuanbao) return false;
/* 1090 */       if (this.money != _o_.money) return false;
/* 1091 */       if (this.totalbuyyuanbao != _o_.totalbuyyuanbao) return false;
/* 1092 */       if (this.totalawardyuanbao != _o_.totalawardyuanbao) return false;
/* 1093 */       if (!this.buyorderid.equals(_o_.buyorderid)) return false;
/* 1094 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1100 */       int _h_ = 0;
/* 1101 */       _h_ = (int)(_h_ + this.awardyuanbao);
/* 1102 */       _h_ = (int)(_h_ + this.buyyuanbao);
/* 1103 */       _h_ = (int)(_h_ + this.money);
/* 1104 */       _h_ = (int)(_h_ + this.totalbuyyuanbao);
/* 1105 */       _h_ = (int)(_h_ + this.totalawardyuanbao);
/* 1106 */       _h_ += this.buyorderid.hashCode();
/* 1107 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1113 */       StringBuilder _sb_ = new StringBuilder();
/* 1114 */       _sb_.append("(");
/* 1115 */       _sb_.append(this.awardyuanbao);
/* 1116 */       _sb_.append(",");
/* 1117 */       _sb_.append(this.buyyuanbao);
/* 1118 */       _sb_.append(",");
/* 1119 */       _sb_.append(this.money);
/* 1120 */       _sb_.append(",");
/* 1121 */       _sb_.append(this.totalbuyyuanbao);
/* 1122 */       _sb_.append(",");
/* 1123 */       _sb_.append(this.totalawardyuanbao);
/* 1124 */       _sb_.append(",");
/* 1125 */       _sb_.append(this.buyorderid);
/* 1126 */       _sb_.append(")");
/* 1127 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\YuanBaoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */