/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class MysteryShopInfo extends XBean implements xbean.MysteryShopInfo
/*      */ {
/*      */   private long reset_time;
/*      */   private int refresh_times;
/*      */   private ArrayList<xbean.MysteryGoodsInfo> goods_list;
/*      */   private int used_free_refresh_times;
/*      */   private int can_free_refresh_times;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.reset_time = 0L;
/*   27 */     this.refresh_times = 0;
/*   28 */     this.goods_list.clear();
/*   29 */     this.used_free_refresh_times = 0;
/*   30 */     this.can_free_refresh_times = 0;
/*      */   }
/*      */   
/*      */   MysteryShopInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.reset_time = 0L;
/*   37 */     this.refresh_times = 0;
/*   38 */     this.goods_list = new ArrayList();
/*   39 */     this.used_free_refresh_times = 0;
/*   40 */     this.can_free_refresh_times = 0;
/*      */   }
/*      */   
/*      */   public MysteryShopInfo()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MysteryShopInfo(MysteryShopInfo _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MysteryShopInfo(xbean.MysteryShopInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof MysteryShopInfo)) { assign((MysteryShopInfo)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MysteryShopInfo _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.reset_time = _o_.reset_time;
/*   66 */     this.refresh_times = _o_.refresh_times;
/*   67 */     this.goods_list = new ArrayList();
/*   68 */     for (xbean.MysteryGoodsInfo _v_ : _o_.goods_list)
/*   69 */       this.goods_list.add(new MysteryGoodsInfo(_v_, this, "goods_list"));
/*   70 */     this.used_free_refresh_times = _o_.used_free_refresh_times;
/*   71 */     this.can_free_refresh_times = _o_.can_free_refresh_times;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   76 */     this.reset_time = _o_.reset_time;
/*   77 */     this.refresh_times = _o_.refresh_times;
/*   78 */     this.goods_list = new ArrayList();
/*   79 */     for (xbean.MysteryGoodsInfo _v_ : _o_.goods_list)
/*   80 */       this.goods_list.add(new MysteryGoodsInfo(_v_, this, "goods_list"));
/*   81 */     this.used_free_refresh_times = _o_.used_free_refresh_times;
/*   82 */     this.can_free_refresh_times = _o_.can_free_refresh_times;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   88 */     _xdb_verify_unsafe_();
/*   89 */     _os_.marshal(this.reset_time);
/*   90 */     _os_.marshal(this.refresh_times);
/*   91 */     _os_.compact_uint32(this.goods_list.size());
/*   92 */     for (xbean.MysteryGoodsInfo _v_ : this.goods_list)
/*      */     {
/*   94 */       _v_.marshal(_os_);
/*      */     }
/*   96 */     _os_.marshal(this.used_free_refresh_times);
/*   97 */     _os_.marshal(this.can_free_refresh_times);
/*   98 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  104 */     _xdb_verify_unsafe_();
/*  105 */     this.reset_time = _os_.unmarshal_long();
/*  106 */     this.refresh_times = _os_.unmarshal_int();
/*  107 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  109 */       xbean.MysteryGoodsInfo _v_ = new MysteryGoodsInfo(0, this, "goods_list");
/*  110 */       _v_.unmarshal(_os_);
/*  111 */       this.goods_list.add(_v_);
/*      */     }
/*  113 */     this.used_free_refresh_times = _os_.unmarshal_int();
/*  114 */     this.can_free_refresh_times = _os_.unmarshal_int();
/*  115 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  121 */     _xdb_verify_unsafe_();
/*  122 */     int _size_ = 0;
/*  123 */     _size_ += CodedOutputStream.computeInt64Size(1, this.reset_time);
/*  124 */     _size_ += CodedOutputStream.computeInt32Size(2, this.refresh_times);
/*  125 */     for (xbean.MysteryGoodsInfo _v_ : this.goods_list)
/*      */     {
/*  127 */       _size_ += CodedOutputStream.computeMessageSize(3, _v_);
/*      */     }
/*  129 */     _size_ += CodedOutputStream.computeInt32Size(4, this.used_free_refresh_times);
/*  130 */     _size_ += CodedOutputStream.computeInt32Size(5, this.can_free_refresh_times);
/*  131 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  137 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  140 */       _output_.writeInt64(1, this.reset_time);
/*  141 */       _output_.writeInt32(2, this.refresh_times);
/*  142 */       for (xbean.MysteryGoodsInfo _v_ : this.goods_list)
/*      */       {
/*  144 */         _output_.writeMessage(3, _v_);
/*      */       }
/*  146 */       _output_.writeInt32(4, this.used_free_refresh_times);
/*  147 */       _output_.writeInt32(5, this.can_free_refresh_times);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  151 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  153 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  159 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  162 */       boolean done = false;
/*  163 */       while (!done)
/*      */       {
/*  165 */         int tag = _input_.readTag();
/*  166 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  170 */           done = true;
/*  171 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  175 */           this.reset_time = _input_.readInt64();
/*  176 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  180 */           this.refresh_times = _input_.readInt32();
/*  181 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  185 */           xbean.MysteryGoodsInfo _v_ = new MysteryGoodsInfo(0, this, "goods_list");
/*  186 */           _input_.readMessage(_v_);
/*  187 */           this.goods_list.add(_v_);
/*  188 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  192 */           this.used_free_refresh_times = _input_.readInt32();
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  197 */           this.can_free_refresh_times = _input_.readInt32();
/*  198 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  202 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  204 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  213 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  217 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  219 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MysteryShopInfo copy()
/*      */   {
/*  225 */     _xdb_verify_unsafe_();
/*  226 */     return new MysteryShopInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MysteryShopInfo toData()
/*      */   {
/*  232 */     _xdb_verify_unsafe_();
/*  233 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MysteryShopInfo toBean()
/*      */   {
/*  238 */     _xdb_verify_unsafe_();
/*  239 */     return new MysteryShopInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MysteryShopInfo toDataIf()
/*      */   {
/*  245 */     _xdb_verify_unsafe_();
/*  246 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MysteryShopInfo toBeanIf()
/*      */   {
/*  251 */     _xdb_verify_unsafe_();
/*  252 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  258 */     _xdb_verify_unsafe_();
/*  259 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getReset_time()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return this.reset_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRefresh_times()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return this.refresh_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.MysteryGoodsInfo> getGoods_list()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return xdb.Logs.logList(new LogKey(this, "goods_list"), this.goods_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.MysteryGoodsInfo> getGoods_listAsData()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*      */     
/*  291 */     MysteryShopInfo _o_ = this;
/*  292 */     List<xbean.MysteryGoodsInfo> goods_list = new ArrayList();
/*  293 */     for (xbean.MysteryGoodsInfo _v_ : _o_.goods_list)
/*  294 */       goods_list.add(new MysteryGoodsInfo.Data(_v_));
/*  295 */     return goods_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getUsed_free_refresh_times()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return this.used_free_refresh_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCan_free_refresh_times()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return this.can_free_refresh_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReset_time(long _v_)
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     xdb.Logs.logIf(new LogKey(this, "reset_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  323 */         new xdb.logs.LogLong(this, MysteryShopInfo.this.reset_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  327 */             MysteryShopInfo.this.reset_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  331 */     });
/*  332 */     this.reset_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRefresh_times(int _v_)
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     xdb.Logs.logIf(new LogKey(this, "refresh_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  344 */         new LogInt(this, MysteryShopInfo.this.refresh_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  348 */             MysteryShopInfo.this.refresh_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  352 */     });
/*  353 */     this.refresh_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUsed_free_refresh_times(int _v_)
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*  361 */     xdb.Logs.logIf(new LogKey(this, "used_free_refresh_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  365 */         new LogInt(this, MysteryShopInfo.this.used_free_refresh_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  369 */             MysteryShopInfo.this.used_free_refresh_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  373 */     });
/*  374 */     this.used_free_refresh_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCan_free_refresh_times(int _v_)
/*      */   {
/*  381 */     _xdb_verify_unsafe_();
/*  382 */     xdb.Logs.logIf(new LogKey(this, "can_free_refresh_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  386 */         new LogInt(this, MysteryShopInfo.this.can_free_refresh_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  390 */             MysteryShopInfo.this.can_free_refresh_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  394 */     });
/*  395 */     this.can_free_refresh_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     MysteryShopInfo _o_ = null;
/*  403 */     if ((_o1_ instanceof MysteryShopInfo)) { _o_ = (MysteryShopInfo)_o1_;
/*  404 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  405 */       return false;
/*  406 */     if (this.reset_time != _o_.reset_time) return false;
/*  407 */     if (this.refresh_times != _o_.refresh_times) return false;
/*  408 */     if (!this.goods_list.equals(_o_.goods_list)) return false;
/*  409 */     if (this.used_free_refresh_times != _o_.used_free_refresh_times) return false;
/*  410 */     if (this.can_free_refresh_times != _o_.can_free_refresh_times) return false;
/*  411 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     int _h_ = 0;
/*  419 */     _h_ = (int)(_h_ + this.reset_time);
/*  420 */     _h_ += this.refresh_times;
/*  421 */     _h_ += this.goods_list.hashCode();
/*  422 */     _h_ += this.used_free_refresh_times;
/*  423 */     _h_ += this.can_free_refresh_times;
/*  424 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     StringBuilder _sb_ = new StringBuilder();
/*  432 */     _sb_.append("(");
/*  433 */     _sb_.append(this.reset_time);
/*  434 */     _sb_.append(",");
/*  435 */     _sb_.append(this.refresh_times);
/*  436 */     _sb_.append(",");
/*  437 */     _sb_.append(this.goods_list);
/*  438 */     _sb_.append(",");
/*  439 */     _sb_.append(this.used_free_refresh_times);
/*  440 */     _sb_.append(",");
/*  441 */     _sb_.append(this.can_free_refresh_times);
/*  442 */     _sb_.append(")");
/*  443 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  449 */     ListenableBean lb = new ListenableBean();
/*  450 */     lb.add(new ListenableChanged().setVarName("reset_time"));
/*  451 */     lb.add(new ListenableChanged().setVarName("refresh_times"));
/*  452 */     lb.add(new ListenableChanged().setVarName("goods_list"));
/*  453 */     lb.add(new ListenableChanged().setVarName("used_free_refresh_times"));
/*  454 */     lb.add(new ListenableChanged().setVarName("can_free_refresh_times"));
/*  455 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MysteryShopInfo {
/*      */     private Const() {}
/*      */     
/*      */     MysteryShopInfo nThis() {
/*  462 */       return MysteryShopInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  468 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MysteryShopInfo copy()
/*      */     {
/*  474 */       return MysteryShopInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MysteryShopInfo toData()
/*      */     {
/*  480 */       return MysteryShopInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MysteryShopInfo toBean()
/*      */     {
/*  485 */       return MysteryShopInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MysteryShopInfo toDataIf()
/*      */     {
/*  491 */       return MysteryShopInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MysteryShopInfo toBeanIf()
/*      */     {
/*  496 */       return MysteryShopInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getReset_time()
/*      */     {
/*  503 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*  504 */       return MysteryShopInfo.this.reset_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRefresh_times()
/*      */     {
/*  511 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*  512 */       return MysteryShopInfo.this.refresh_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.MysteryGoodsInfo> getGoods_list()
/*      */     {
/*  519 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*  520 */       return xdb.Consts.constList(MysteryShopInfo.this.goods_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.MysteryGoodsInfo> getGoods_listAsData()
/*      */     {
/*  526 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*      */       
/*  528 */       MysteryShopInfo _o_ = MysteryShopInfo.this;
/*  529 */       List<xbean.MysteryGoodsInfo> goods_list = new ArrayList();
/*  530 */       for (xbean.MysteryGoodsInfo _v_ : _o_.goods_list)
/*  531 */         goods_list.add(new MysteryGoodsInfo.Data(_v_));
/*  532 */       return goods_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUsed_free_refresh_times()
/*      */     {
/*  539 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*  540 */       return MysteryShopInfo.this.used_free_refresh_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCan_free_refresh_times()
/*      */     {
/*  547 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*  548 */       return MysteryShopInfo.this.can_free_refresh_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReset_time(long _v_)
/*      */     {
/*  555 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*  556 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRefresh_times(int _v_)
/*      */     {
/*  563 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*  564 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUsed_free_refresh_times(int _v_)
/*      */     {
/*  571 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*  572 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCan_free_refresh_times(int _v_)
/*      */     {
/*  579 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*  580 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  586 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*  587 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  593 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*  594 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  600 */       return MysteryShopInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  606 */       return MysteryShopInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  612 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*  613 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  619 */       return MysteryShopInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  625 */       return MysteryShopInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  631 */       MysteryShopInfo.this._xdb_verify_unsafe_();
/*  632 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  638 */       return MysteryShopInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  644 */       return MysteryShopInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  650 */       return MysteryShopInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  656 */       return MysteryShopInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  662 */       return MysteryShopInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  668 */       return MysteryShopInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  674 */       return MysteryShopInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MysteryShopInfo
/*      */   {
/*      */     private long reset_time;
/*      */     
/*      */     private int refresh_times;
/*      */     
/*      */     private ArrayList<xbean.MysteryGoodsInfo> goods_list;
/*      */     
/*      */     private int used_free_refresh_times;
/*      */     
/*      */     private int can_free_refresh_times;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  694 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  699 */       this.reset_time = 0L;
/*  700 */       this.refresh_times = 0;
/*  701 */       this.goods_list = new ArrayList();
/*  702 */       this.used_free_refresh_times = 0;
/*  703 */       this.can_free_refresh_times = 0;
/*      */     }
/*      */     
/*      */     Data(xbean.MysteryShopInfo _o1_)
/*      */     {
/*  708 */       if ((_o1_ instanceof MysteryShopInfo)) { assign((MysteryShopInfo)_o1_);
/*  709 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  710 */       } else if ((_o1_ instanceof MysteryShopInfo.Const)) assign(((MysteryShopInfo.Const)_o1_).nThis()); else {
/*  711 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MysteryShopInfo _o_) {
/*  716 */       this.reset_time = _o_.reset_time;
/*  717 */       this.refresh_times = _o_.refresh_times;
/*  718 */       this.goods_list = new ArrayList();
/*  719 */       for (xbean.MysteryGoodsInfo _v_ : _o_.goods_list)
/*  720 */         this.goods_list.add(new MysteryGoodsInfo.Data(_v_));
/*  721 */       this.used_free_refresh_times = _o_.used_free_refresh_times;
/*  722 */       this.can_free_refresh_times = _o_.can_free_refresh_times;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  727 */       this.reset_time = _o_.reset_time;
/*  728 */       this.refresh_times = _o_.refresh_times;
/*  729 */       this.goods_list = new ArrayList();
/*  730 */       for (xbean.MysteryGoodsInfo _v_ : _o_.goods_list)
/*  731 */         this.goods_list.add(new MysteryGoodsInfo.Data(_v_));
/*  732 */       this.used_free_refresh_times = _o_.used_free_refresh_times;
/*  733 */       this.can_free_refresh_times = _o_.can_free_refresh_times;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  739 */       _os_.marshal(this.reset_time);
/*  740 */       _os_.marshal(this.refresh_times);
/*  741 */       _os_.compact_uint32(this.goods_list.size());
/*  742 */       for (xbean.MysteryGoodsInfo _v_ : this.goods_list)
/*      */       {
/*  744 */         _v_.marshal(_os_);
/*      */       }
/*  746 */       _os_.marshal(this.used_free_refresh_times);
/*  747 */       _os_.marshal(this.can_free_refresh_times);
/*  748 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  754 */       this.reset_time = _os_.unmarshal_long();
/*  755 */       this.refresh_times = _os_.unmarshal_int();
/*  756 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  758 */         xbean.MysteryGoodsInfo _v_ = xbean.Pod.newMysteryGoodsInfoData();
/*  759 */         _v_.unmarshal(_os_);
/*  760 */         this.goods_list.add(_v_);
/*      */       }
/*  762 */       this.used_free_refresh_times = _os_.unmarshal_int();
/*  763 */       this.can_free_refresh_times = _os_.unmarshal_int();
/*  764 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  770 */       int _size_ = 0;
/*  771 */       _size_ += CodedOutputStream.computeInt64Size(1, this.reset_time);
/*  772 */       _size_ += CodedOutputStream.computeInt32Size(2, this.refresh_times);
/*  773 */       for (xbean.MysteryGoodsInfo _v_ : this.goods_list)
/*      */       {
/*  775 */         _size_ += CodedOutputStream.computeMessageSize(3, _v_);
/*      */       }
/*  777 */       _size_ += CodedOutputStream.computeInt32Size(4, this.used_free_refresh_times);
/*  778 */       _size_ += CodedOutputStream.computeInt32Size(5, this.can_free_refresh_times);
/*  779 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  787 */         _output_.writeInt64(1, this.reset_time);
/*  788 */         _output_.writeInt32(2, this.refresh_times);
/*  789 */         for (xbean.MysteryGoodsInfo _v_ : this.goods_list)
/*      */         {
/*  791 */           _output_.writeMessage(3, _v_);
/*      */         }
/*  793 */         _output_.writeInt32(4, this.used_free_refresh_times);
/*  794 */         _output_.writeInt32(5, this.can_free_refresh_times);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  798 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  800 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  808 */         boolean done = false;
/*  809 */         while (!done)
/*      */         {
/*  811 */           int tag = _input_.readTag();
/*  812 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  816 */             done = true;
/*  817 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  821 */             this.reset_time = _input_.readInt64();
/*  822 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  826 */             this.refresh_times = _input_.readInt32();
/*  827 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/*  831 */             xbean.MysteryGoodsInfo _v_ = xbean.Pod.newMysteryGoodsInfoData();
/*  832 */             _input_.readMessage(_v_);
/*  833 */             this.goods_list.add(_v_);
/*  834 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  838 */             this.used_free_refresh_times = _input_.readInt32();
/*  839 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  843 */             this.can_free_refresh_times = _input_.readInt32();
/*  844 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  848 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  850 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  859 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  863 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  865 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MysteryShopInfo copy()
/*      */     {
/*  871 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MysteryShopInfo toData()
/*      */     {
/*  877 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MysteryShopInfo toBean()
/*      */     {
/*  882 */       return new MysteryShopInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MysteryShopInfo toDataIf()
/*      */     {
/*  888 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MysteryShopInfo toBeanIf()
/*      */     {
/*  893 */       return new MysteryShopInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  899 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  903 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  907 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  911 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  915 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  919 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  923 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getReset_time()
/*      */     {
/*  930 */       return this.reset_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRefresh_times()
/*      */     {
/*  937 */       return this.refresh_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.MysteryGoodsInfo> getGoods_list()
/*      */     {
/*  944 */       return this.goods_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.MysteryGoodsInfo> getGoods_listAsData()
/*      */     {
/*  951 */       return this.goods_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUsed_free_refresh_times()
/*      */     {
/*  958 */       return this.used_free_refresh_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCan_free_refresh_times()
/*      */     {
/*  965 */       return this.can_free_refresh_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReset_time(long _v_)
/*      */     {
/*  972 */       this.reset_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRefresh_times(int _v_)
/*      */     {
/*  979 */       this.refresh_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUsed_free_refresh_times(int _v_)
/*      */     {
/*  986 */       this.used_free_refresh_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCan_free_refresh_times(int _v_)
/*      */     {
/*  993 */       this.can_free_refresh_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/*  999 */       if (!(_o1_ instanceof Data)) return false;
/* 1000 */       Data _o_ = (Data)_o1_;
/* 1001 */       if (this.reset_time != _o_.reset_time) return false;
/* 1002 */       if (this.refresh_times != _o_.refresh_times) return false;
/* 1003 */       if (!this.goods_list.equals(_o_.goods_list)) return false;
/* 1004 */       if (this.used_free_refresh_times != _o_.used_free_refresh_times) return false;
/* 1005 */       if (this.can_free_refresh_times != _o_.can_free_refresh_times) return false;
/* 1006 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1012 */       int _h_ = 0;
/* 1013 */       _h_ = (int)(_h_ + this.reset_time);
/* 1014 */       _h_ += this.refresh_times;
/* 1015 */       _h_ += this.goods_list.hashCode();
/* 1016 */       _h_ += this.used_free_refresh_times;
/* 1017 */       _h_ += this.can_free_refresh_times;
/* 1018 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1024 */       StringBuilder _sb_ = new StringBuilder();
/* 1025 */       _sb_.append("(");
/* 1026 */       _sb_.append(this.reset_time);
/* 1027 */       _sb_.append(",");
/* 1028 */       _sb_.append(this.refresh_times);
/* 1029 */       _sb_.append(",");
/* 1030 */       _sb_.append(this.goods_list);
/* 1031 */       _sb_.append(",");
/* 1032 */       _sb_.append(this.used_free_refresh_times);
/* 1033 */       _sb_.append(",");
/* 1034 */       _sb_.append(this.can_free_refresh_times);
/* 1035 */       _sb_.append(")");
/* 1036 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MysteryShopInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */