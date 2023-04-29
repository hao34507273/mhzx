/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.LinkedList;
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
/*      */ public final class CakeDetailData extends XBean implements xbean.CakeDetailData
/*      */ {
/*      */   private int cakeid;
/*      */   private int state;
/*      */   private long cookstarttime;
/*      */   private int nextcakeid;
/*      */   private LinkedList<xbean.CakeHistoryData> history;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.cakeid = 0;
/*   27 */     this.state = 0;
/*   28 */     this.cookstarttime = 0L;
/*   29 */     this.nextcakeid = 0;
/*   30 */     this.history.clear();
/*      */   }
/*      */   
/*      */   CakeDetailData(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.history = new LinkedList();
/*      */   }
/*      */   
/*      */   public CakeDetailData()
/*      */   {
/*   41 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CakeDetailData(CakeDetailData _o_)
/*      */   {
/*   46 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CakeDetailData(xbean.CakeDetailData _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   51 */     super(_xp_, _vn_);
/*   52 */     if ((_o1_ instanceof CakeDetailData)) { assign((CakeDetailData)_o1_);
/*   53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   55 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CakeDetailData _o_) {
/*   60 */     _o_._xdb_verify_unsafe_();
/*   61 */     this.cakeid = _o_.cakeid;
/*   62 */     this.state = _o_.state;
/*   63 */     this.cookstarttime = _o_.cookstarttime;
/*   64 */     this.nextcakeid = _o_.nextcakeid;
/*   65 */     this.history = new LinkedList();
/*   66 */     for (xbean.CakeHistoryData _v_ : _o_.history) {
/*   67 */       this.history.add(new CakeHistoryData(_v_, this, "history"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   72 */     this.cakeid = _o_.cakeid;
/*   73 */     this.state = _o_.state;
/*   74 */     this.cookstarttime = _o_.cookstarttime;
/*   75 */     this.nextcakeid = _o_.nextcakeid;
/*   76 */     this.history = new LinkedList();
/*   77 */     for (xbean.CakeHistoryData _v_ : _o_.history) {
/*   78 */       this.history.add(new CakeHistoryData(_v_, this, "history"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.marshal(this.cakeid);
/*   86 */     _os_.marshal(this.state);
/*   87 */     _os_.marshal(this.cookstarttime);
/*   88 */     _os_.marshal(this.nextcakeid);
/*   89 */     _os_.compact_uint32(this.history.size());
/*   90 */     for (xbean.CakeHistoryData _v_ : this.history)
/*      */     {
/*   92 */       _v_.marshal(_os_);
/*      */     }
/*   94 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  100 */     _xdb_verify_unsafe_();
/*  101 */     this.cakeid = _os_.unmarshal_int();
/*  102 */     this.state = _os_.unmarshal_int();
/*  103 */     this.cookstarttime = _os_.unmarshal_long();
/*  104 */     this.nextcakeid = _os_.unmarshal_int();
/*  105 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  107 */       xbean.CakeHistoryData _v_ = new CakeHistoryData(0, this, "history");
/*  108 */       _v_.unmarshal(_os_);
/*  109 */       this.history.add(_v_);
/*      */     }
/*  111 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  117 */     _xdb_verify_unsafe_();
/*  118 */     int _size_ = 0;
/*  119 */     _size_ += CodedOutputStream.computeInt32Size(1, this.cakeid);
/*  120 */     _size_ += CodedOutputStream.computeInt32Size(2, this.state);
/*  121 */     _size_ += CodedOutputStream.computeInt64Size(3, this.cookstarttime);
/*  122 */     _size_ += CodedOutputStream.computeInt32Size(4, this.nextcakeid);
/*  123 */     for (xbean.CakeHistoryData _v_ : this.history)
/*      */     {
/*  125 */       _size_ += CodedOutputStream.computeMessageSize(5, _v_);
/*      */     }
/*  127 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  133 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  136 */       _output_.writeInt32(1, this.cakeid);
/*  137 */       _output_.writeInt32(2, this.state);
/*  138 */       _output_.writeInt64(3, this.cookstarttime);
/*  139 */       _output_.writeInt32(4, this.nextcakeid);
/*  140 */       for (xbean.CakeHistoryData _v_ : this.history)
/*      */       {
/*  142 */         _output_.writeMessage(5, _v_);
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  147 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  149 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  155 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  158 */       boolean done = false;
/*  159 */       while (!done)
/*      */       {
/*  161 */         int tag = _input_.readTag();
/*  162 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  166 */           done = true;
/*  167 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  171 */           this.cakeid = _input_.readInt32();
/*  172 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  176 */           this.state = _input_.readInt32();
/*  177 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  181 */           this.cookstarttime = _input_.readInt64();
/*  182 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  186 */           this.nextcakeid = _input_.readInt32();
/*  187 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  191 */           xbean.CakeHistoryData _v_ = new CakeHistoryData(0, this, "history");
/*  192 */           _input_.readMessage(_v_);
/*  193 */           this.history.add(_v_);
/*  194 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  198 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  200 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  209 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  213 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  215 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CakeDetailData copy()
/*      */   {
/*  221 */     _xdb_verify_unsafe_();
/*  222 */     return new CakeDetailData(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CakeDetailData toData()
/*      */   {
/*  228 */     _xdb_verify_unsafe_();
/*  229 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CakeDetailData toBean()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new CakeDetailData(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CakeDetailData toDataIf()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CakeDetailData toBeanIf()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCakeid()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return this.cakeid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getState()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return this.state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCookstarttime()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return this.cookstarttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNextcakeid()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return this.nextcakeid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.CakeHistoryData> getHistory()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return xdb.Logs.logList(new LogKey(this, "history"), this.history);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.CakeHistoryData> getHistoryAsData()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*      */     
/*  303 */     CakeDetailData _o_ = this;
/*  304 */     List<xbean.CakeHistoryData> history = new LinkedList();
/*  305 */     for (xbean.CakeHistoryData _v_ : _o_.history)
/*  306 */       history.add(new CakeHistoryData.Data(_v_));
/*  307 */     return history;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCakeid(int _v_)
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     xdb.Logs.logIf(new LogKey(this, "cakeid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  319 */         new LogInt(this, CakeDetailData.this.cakeid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  323 */             CakeDetailData.this.cakeid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  327 */     });
/*  328 */     this.cakeid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setState(int _v_)
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     xdb.Logs.logIf(new LogKey(this, "state")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  340 */         new LogInt(this, CakeDetailData.this.state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  344 */             CakeDetailData.this.state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  348 */     });
/*  349 */     this.state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCookstarttime(long _v_)
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     xdb.Logs.logIf(new LogKey(this, "cookstarttime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  361 */         new xdb.logs.LogLong(this, CakeDetailData.this.cookstarttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  365 */             CakeDetailData.this.cookstarttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  369 */     });
/*  370 */     this.cookstarttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNextcakeid(int _v_)
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     xdb.Logs.logIf(new LogKey(this, "nextcakeid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  382 */         new LogInt(this, CakeDetailData.this.nextcakeid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  386 */             CakeDetailData.this.nextcakeid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  390 */     });
/*  391 */     this.nextcakeid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     CakeDetailData _o_ = null;
/*  399 */     if ((_o1_ instanceof CakeDetailData)) { _o_ = (CakeDetailData)_o1_;
/*  400 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  401 */       return false;
/*  402 */     if (this.cakeid != _o_.cakeid) return false;
/*  403 */     if (this.state != _o_.state) return false;
/*  404 */     if (this.cookstarttime != _o_.cookstarttime) return false;
/*  405 */     if (this.nextcakeid != _o_.nextcakeid) return false;
/*  406 */     if (!this.history.equals(_o_.history)) return false;
/*  407 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  413 */     _xdb_verify_unsafe_();
/*  414 */     int _h_ = 0;
/*  415 */     _h_ += this.cakeid;
/*  416 */     _h_ += this.state;
/*  417 */     _h_ = (int)(_h_ + this.cookstarttime);
/*  418 */     _h_ += this.nextcakeid;
/*  419 */     _h_ += this.history.hashCode();
/*  420 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  426 */     _xdb_verify_unsafe_();
/*  427 */     StringBuilder _sb_ = new StringBuilder();
/*  428 */     _sb_.append("(");
/*  429 */     _sb_.append(this.cakeid);
/*  430 */     _sb_.append(",");
/*  431 */     _sb_.append(this.state);
/*  432 */     _sb_.append(",");
/*  433 */     _sb_.append(this.cookstarttime);
/*  434 */     _sb_.append(",");
/*  435 */     _sb_.append(this.nextcakeid);
/*  436 */     _sb_.append(",");
/*  437 */     _sb_.append(this.history);
/*  438 */     _sb_.append(")");
/*  439 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  445 */     ListenableBean lb = new ListenableBean();
/*  446 */     lb.add(new ListenableChanged().setVarName("cakeid"));
/*  447 */     lb.add(new ListenableChanged().setVarName("state"));
/*  448 */     lb.add(new ListenableChanged().setVarName("cookstarttime"));
/*  449 */     lb.add(new ListenableChanged().setVarName("nextcakeid"));
/*  450 */     lb.add(new ListenableChanged().setVarName("history"));
/*  451 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CakeDetailData {
/*      */     private Const() {}
/*      */     
/*      */     CakeDetailData nThis() {
/*  458 */       return CakeDetailData.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  464 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeDetailData copy()
/*      */     {
/*  470 */       return CakeDetailData.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeDetailData toData()
/*      */     {
/*  476 */       return CakeDetailData.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CakeDetailData toBean()
/*      */     {
/*  481 */       return CakeDetailData.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeDetailData toDataIf()
/*      */     {
/*  487 */       return CakeDetailData.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CakeDetailData toBeanIf()
/*      */     {
/*  492 */       return CakeDetailData.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCakeid()
/*      */     {
/*  499 */       CakeDetailData.this._xdb_verify_unsafe_();
/*  500 */       return CakeDetailData.this.cakeid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/*  507 */       CakeDetailData.this._xdb_verify_unsafe_();
/*  508 */       return CakeDetailData.this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCookstarttime()
/*      */     {
/*  515 */       CakeDetailData.this._xdb_verify_unsafe_();
/*  516 */       return CakeDetailData.this.cookstarttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNextcakeid()
/*      */     {
/*  523 */       CakeDetailData.this._xdb_verify_unsafe_();
/*  524 */       return CakeDetailData.this.nextcakeid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.CakeHistoryData> getHistory()
/*      */     {
/*  531 */       CakeDetailData.this._xdb_verify_unsafe_();
/*  532 */       return xdb.Consts.constList(CakeDetailData.this.history);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.CakeHistoryData> getHistoryAsData()
/*      */     {
/*  538 */       CakeDetailData.this._xdb_verify_unsafe_();
/*      */       
/*  540 */       CakeDetailData _o_ = CakeDetailData.this;
/*  541 */       List<xbean.CakeHistoryData> history = new LinkedList();
/*  542 */       for (xbean.CakeHistoryData _v_ : _o_.history)
/*  543 */         history.add(new CakeHistoryData.Data(_v_));
/*  544 */       return history;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCakeid(int _v_)
/*      */     {
/*  551 */       CakeDetailData.this._xdb_verify_unsafe_();
/*  552 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/*  559 */       CakeDetailData.this._xdb_verify_unsafe_();
/*  560 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCookstarttime(long _v_)
/*      */     {
/*  567 */       CakeDetailData.this._xdb_verify_unsafe_();
/*  568 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNextcakeid(int _v_)
/*      */     {
/*  575 */       CakeDetailData.this._xdb_verify_unsafe_();
/*  576 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  582 */       CakeDetailData.this._xdb_verify_unsafe_();
/*  583 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  589 */       CakeDetailData.this._xdb_verify_unsafe_();
/*  590 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  596 */       return CakeDetailData.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  602 */       return CakeDetailData.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  608 */       CakeDetailData.this._xdb_verify_unsafe_();
/*  609 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  615 */       return CakeDetailData.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  621 */       return CakeDetailData.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  627 */       CakeDetailData.this._xdb_verify_unsafe_();
/*  628 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  634 */       return CakeDetailData.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  640 */       return CakeDetailData.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  646 */       return CakeDetailData.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  652 */       return CakeDetailData.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  658 */       return CakeDetailData.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  664 */       return CakeDetailData.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  670 */       return CakeDetailData.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CakeDetailData
/*      */   {
/*      */     private int cakeid;
/*      */     
/*      */     private int state;
/*      */     
/*      */     private long cookstarttime;
/*      */     
/*      */     private int nextcakeid;
/*      */     
/*      */     private LinkedList<xbean.CakeHistoryData> history;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  690 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  695 */       this.history = new LinkedList();
/*      */     }
/*      */     
/*      */     Data(xbean.CakeDetailData _o1_)
/*      */     {
/*  700 */       if ((_o1_ instanceof CakeDetailData)) { assign((CakeDetailData)_o1_);
/*  701 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  702 */       } else if ((_o1_ instanceof CakeDetailData.Const)) assign(((CakeDetailData.Const)_o1_).nThis()); else {
/*  703 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CakeDetailData _o_) {
/*  708 */       this.cakeid = _o_.cakeid;
/*  709 */       this.state = _o_.state;
/*  710 */       this.cookstarttime = _o_.cookstarttime;
/*  711 */       this.nextcakeid = _o_.nextcakeid;
/*  712 */       this.history = new LinkedList();
/*  713 */       for (xbean.CakeHistoryData _v_ : _o_.history) {
/*  714 */         this.history.add(new CakeHistoryData.Data(_v_));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  719 */       this.cakeid = _o_.cakeid;
/*  720 */       this.state = _o_.state;
/*  721 */       this.cookstarttime = _o_.cookstarttime;
/*  722 */       this.nextcakeid = _o_.nextcakeid;
/*  723 */       this.history = new LinkedList();
/*  724 */       for (xbean.CakeHistoryData _v_ : _o_.history) {
/*  725 */         this.history.add(new CakeHistoryData.Data(_v_));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  731 */       _os_.marshal(this.cakeid);
/*  732 */       _os_.marshal(this.state);
/*  733 */       _os_.marshal(this.cookstarttime);
/*  734 */       _os_.marshal(this.nextcakeid);
/*  735 */       _os_.compact_uint32(this.history.size());
/*  736 */       for (xbean.CakeHistoryData _v_ : this.history)
/*      */       {
/*  738 */         _v_.marshal(_os_);
/*      */       }
/*  740 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  746 */       this.cakeid = _os_.unmarshal_int();
/*  747 */       this.state = _os_.unmarshal_int();
/*  748 */       this.cookstarttime = _os_.unmarshal_long();
/*  749 */       this.nextcakeid = _os_.unmarshal_int();
/*  750 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  752 */         xbean.CakeHistoryData _v_ = xbean.Pod.newCakeHistoryDataData();
/*  753 */         _v_.unmarshal(_os_);
/*  754 */         this.history.add(_v_);
/*      */       }
/*  756 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  762 */       int _size_ = 0;
/*  763 */       _size_ += CodedOutputStream.computeInt32Size(1, this.cakeid);
/*  764 */       _size_ += CodedOutputStream.computeInt32Size(2, this.state);
/*  765 */       _size_ += CodedOutputStream.computeInt64Size(3, this.cookstarttime);
/*  766 */       _size_ += CodedOutputStream.computeInt32Size(4, this.nextcakeid);
/*  767 */       for (xbean.CakeHistoryData _v_ : this.history)
/*      */       {
/*  769 */         _size_ += CodedOutputStream.computeMessageSize(5, _v_);
/*      */       }
/*  771 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  779 */         _output_.writeInt32(1, this.cakeid);
/*  780 */         _output_.writeInt32(2, this.state);
/*  781 */         _output_.writeInt64(3, this.cookstarttime);
/*  782 */         _output_.writeInt32(4, this.nextcakeid);
/*  783 */         for (xbean.CakeHistoryData _v_ : this.history)
/*      */         {
/*  785 */           _output_.writeMessage(5, _v_);
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  790 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  792 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  800 */         boolean done = false;
/*  801 */         while (!done)
/*      */         {
/*  803 */           int tag = _input_.readTag();
/*  804 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  808 */             done = true;
/*  809 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  813 */             this.cakeid = _input_.readInt32();
/*  814 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  818 */             this.state = _input_.readInt32();
/*  819 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  823 */             this.cookstarttime = _input_.readInt64();
/*  824 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  828 */             this.nextcakeid = _input_.readInt32();
/*  829 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/*  833 */             xbean.CakeHistoryData _v_ = xbean.Pod.newCakeHistoryDataData();
/*  834 */             _input_.readMessage(_v_);
/*  835 */             this.history.add(_v_);
/*  836 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  840 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  842 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  851 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  855 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  857 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeDetailData copy()
/*      */     {
/*  863 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeDetailData toData()
/*      */     {
/*  869 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CakeDetailData toBean()
/*      */     {
/*  874 */       return new CakeDetailData(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeDetailData toDataIf()
/*      */     {
/*  880 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CakeDetailData toBeanIf()
/*      */     {
/*  885 */       return new CakeDetailData(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  891 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  895 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  899 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  903 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  907 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  911 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  915 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCakeid()
/*      */     {
/*  922 */       return this.cakeid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/*  929 */       return this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCookstarttime()
/*      */     {
/*  936 */       return this.cookstarttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNextcakeid()
/*      */     {
/*  943 */       return this.nextcakeid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.CakeHistoryData> getHistory()
/*      */     {
/*  950 */       return this.history;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.CakeHistoryData> getHistoryAsData()
/*      */     {
/*  957 */       return this.history;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCakeid(int _v_)
/*      */     {
/*  964 */       this.cakeid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/*  971 */       this.state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCookstarttime(long _v_)
/*      */     {
/*  978 */       this.cookstarttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNextcakeid(int _v_)
/*      */     {
/*  985 */       this.nextcakeid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/*  991 */       if (!(_o1_ instanceof Data)) return false;
/*  992 */       Data _o_ = (Data)_o1_;
/*  993 */       if (this.cakeid != _o_.cakeid) return false;
/*  994 */       if (this.state != _o_.state) return false;
/*  995 */       if (this.cookstarttime != _o_.cookstarttime) return false;
/*  996 */       if (this.nextcakeid != _o_.nextcakeid) return false;
/*  997 */       if (!this.history.equals(_o_.history)) return false;
/*  998 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1004 */       int _h_ = 0;
/* 1005 */       _h_ += this.cakeid;
/* 1006 */       _h_ += this.state;
/* 1007 */       _h_ = (int)(_h_ + this.cookstarttime);
/* 1008 */       _h_ += this.nextcakeid;
/* 1009 */       _h_ += this.history.hashCode();
/* 1010 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1016 */       StringBuilder _sb_ = new StringBuilder();
/* 1017 */       _sb_.append("(");
/* 1018 */       _sb_.append(this.cakeid);
/* 1019 */       _sb_.append(",");
/* 1020 */       _sb_.append(this.state);
/* 1021 */       _sb_.append(",");
/* 1022 */       _sb_.append(this.cookstarttime);
/* 1023 */       _sb_.append(",");
/* 1024 */       _sb_.append(this.nextcakeid);
/* 1025 */       _sb_.append(",");
/* 1026 */       _sb_.append(this.history);
/* 1027 */       _sb_.append(")");
/* 1028 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CakeDetailData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */