/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xbean.Pod;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogString;
/*      */ 
/*      */ public final class CatInfo extends XBean implements xbean.CatInfo
/*      */ {
/*      */   private long id;
/*      */   private int cat_level_cfgid;
/*      */   private String name;
/*      */   private int explore_num;
/*      */   private int total_explore_num;
/*      */   private int vigor;
/*      */   private int state;
/*      */   private long explore_starttime;
/*      */   private long explore_costtime;
/*      */   private long explore_endtime;
/*      */   private int explored_level;
/*      */   private int explored_partner_cfgid;
/*      */   private int partner_cfgid;
/*      */   private int item_cfgid;
/*      */   private long force_recovery_time;
/*      */   private LinkedList<xbean.RoleFeedInfo> records;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   48 */     this.id = 0L;
/*   49 */     this.cat_level_cfgid = 0;
/*   50 */     this.name = "";
/*   51 */     this.explore_num = 0;
/*   52 */     this.total_explore_num = 0;
/*   53 */     this.vigor = 0;
/*   54 */     this.state = 1;
/*   55 */     this.explore_starttime = 0L;
/*   56 */     this.explore_costtime = 0L;
/*   57 */     this.explore_endtime = 0L;
/*   58 */     this.explored_level = 0;
/*   59 */     this.explored_partner_cfgid = 0;
/*   60 */     this.partner_cfgid = 0;
/*   61 */     this.item_cfgid = 0;
/*   62 */     this.force_recovery_time = 0L;
/*   63 */     this.records.clear();
/*      */   }
/*      */   
/*      */   CatInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   68 */     super(_xp_, _vn_);
/*   69 */     this.name = "";
/*   70 */     this.state = 1;
/*   71 */     this.records = new LinkedList();
/*      */   }
/*      */   
/*      */   public CatInfo()
/*      */   {
/*   76 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CatInfo(CatInfo _o_)
/*      */   {
/*   81 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CatInfo(xbean.CatInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   86 */     super(_xp_, _vn_);
/*   87 */     if ((_o1_ instanceof CatInfo)) { assign((CatInfo)_o1_);
/*   88 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   89 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   90 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CatInfo _o_) {
/*   95 */     _o_._xdb_verify_unsafe_();
/*   96 */     this.id = _o_.id;
/*   97 */     this.cat_level_cfgid = _o_.cat_level_cfgid;
/*   98 */     this.name = _o_.name;
/*   99 */     this.explore_num = _o_.explore_num;
/*  100 */     this.total_explore_num = _o_.total_explore_num;
/*  101 */     this.vigor = _o_.vigor;
/*  102 */     this.state = _o_.state;
/*  103 */     this.explore_starttime = _o_.explore_starttime;
/*  104 */     this.explore_costtime = _o_.explore_costtime;
/*  105 */     this.explore_endtime = _o_.explore_endtime;
/*  106 */     this.explored_level = _o_.explored_level;
/*  107 */     this.explored_partner_cfgid = _o_.explored_partner_cfgid;
/*  108 */     this.partner_cfgid = _o_.partner_cfgid;
/*  109 */     this.item_cfgid = _o_.item_cfgid;
/*  110 */     this.force_recovery_time = _o_.force_recovery_time;
/*  111 */     this.records = new LinkedList();
/*  112 */     for (xbean.RoleFeedInfo _v_ : _o_.records) {
/*  113 */       this.records.add(new RoleFeedInfo(_v_, this, "records"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*  118 */     this.id = _o_.id;
/*  119 */     this.cat_level_cfgid = _o_.cat_level_cfgid;
/*  120 */     this.name = _o_.name;
/*  121 */     this.explore_num = _o_.explore_num;
/*  122 */     this.total_explore_num = _o_.total_explore_num;
/*  123 */     this.vigor = _o_.vigor;
/*  124 */     this.state = _o_.state;
/*  125 */     this.explore_starttime = _o_.explore_starttime;
/*  126 */     this.explore_costtime = _o_.explore_costtime;
/*  127 */     this.explore_endtime = _o_.explore_endtime;
/*  128 */     this.explored_level = _o_.explored_level;
/*  129 */     this.explored_partner_cfgid = _o_.explored_partner_cfgid;
/*  130 */     this.partner_cfgid = _o_.partner_cfgid;
/*  131 */     this.item_cfgid = _o_.item_cfgid;
/*  132 */     this.force_recovery_time = _o_.force_recovery_time;
/*  133 */     this.records = new LinkedList();
/*  134 */     for (xbean.RoleFeedInfo _v_ : _o_.records) {
/*  135 */       this.records.add(new RoleFeedInfo(_v_, this, "records"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  141 */     _xdb_verify_unsafe_();
/*  142 */     _os_.marshal(this.id);
/*  143 */     _os_.marshal(this.cat_level_cfgid);
/*  144 */     _os_.marshal(this.name, "UTF-16LE");
/*  145 */     _os_.marshal(this.explore_num);
/*  146 */     _os_.marshal(this.total_explore_num);
/*  147 */     _os_.marshal(this.vigor);
/*  148 */     _os_.marshal(this.state);
/*  149 */     _os_.marshal(this.explore_starttime);
/*  150 */     _os_.marshal(this.explore_costtime);
/*  151 */     _os_.marshal(this.explore_endtime);
/*  152 */     _os_.marshal(this.explored_level);
/*  153 */     _os_.marshal(this.explored_partner_cfgid);
/*  154 */     _os_.marshal(this.partner_cfgid);
/*  155 */     _os_.marshal(this.item_cfgid);
/*  156 */     _os_.marshal(this.force_recovery_time);
/*  157 */     _os_.compact_uint32(this.records.size());
/*  158 */     for (xbean.RoleFeedInfo _v_ : this.records)
/*      */     {
/*  160 */       _v_.marshal(_os_);
/*      */     }
/*  162 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  168 */     _xdb_verify_unsafe_();
/*  169 */     this.id = _os_.unmarshal_long();
/*  170 */     this.cat_level_cfgid = _os_.unmarshal_int();
/*  171 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  172 */     this.explore_num = _os_.unmarshal_int();
/*  173 */     this.total_explore_num = _os_.unmarshal_int();
/*  174 */     this.vigor = _os_.unmarshal_int();
/*  175 */     this.state = _os_.unmarshal_int();
/*  176 */     this.explore_starttime = _os_.unmarshal_long();
/*  177 */     this.explore_costtime = _os_.unmarshal_long();
/*  178 */     this.explore_endtime = _os_.unmarshal_long();
/*  179 */     this.explored_level = _os_.unmarshal_int();
/*  180 */     this.explored_partner_cfgid = _os_.unmarshal_int();
/*  181 */     this.partner_cfgid = _os_.unmarshal_int();
/*  182 */     this.item_cfgid = _os_.unmarshal_int();
/*  183 */     this.force_recovery_time = _os_.unmarshal_long();
/*  184 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  186 */       xbean.RoleFeedInfo _v_ = new RoleFeedInfo(0, this, "records");
/*  187 */       _v_.unmarshal(_os_);
/*  188 */       this.records.add(_v_);
/*      */     }
/*  190 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  196 */     _xdb_verify_unsafe_();
/*  197 */     int _size_ = 0;
/*  198 */     _size_ += CodedOutputStream.computeInt64Size(1, this.id);
/*  199 */     _size_ += CodedOutputStream.computeInt32Size(2, this.cat_level_cfgid);
/*      */     try
/*      */     {
/*  202 */       _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  206 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  208 */     _size_ += CodedOutputStream.computeInt32Size(4, this.explore_num);
/*  209 */     _size_ += CodedOutputStream.computeInt32Size(5, this.total_explore_num);
/*  210 */     _size_ += CodedOutputStream.computeInt32Size(6, this.vigor);
/*  211 */     _size_ += CodedOutputStream.computeInt32Size(7, this.state);
/*  212 */     _size_ += CodedOutputStream.computeInt64Size(8, this.explore_starttime);
/*  213 */     _size_ += CodedOutputStream.computeInt64Size(9, this.explore_costtime);
/*  214 */     _size_ += CodedOutputStream.computeInt64Size(10, this.explore_endtime);
/*  215 */     _size_ += CodedOutputStream.computeInt32Size(11, this.explored_level);
/*  216 */     _size_ += CodedOutputStream.computeInt32Size(12, this.explored_partner_cfgid);
/*  217 */     _size_ += CodedOutputStream.computeInt32Size(13, this.partner_cfgid);
/*  218 */     _size_ += CodedOutputStream.computeInt32Size(14, this.item_cfgid);
/*  219 */     _size_ += CodedOutputStream.computeInt64Size(15, this.force_recovery_time);
/*  220 */     for (xbean.RoleFeedInfo _v_ : this.records)
/*      */     {
/*  222 */       _size_ += CodedOutputStream.computeMessageSize(16, _v_);
/*      */     }
/*  224 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  230 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  233 */       _output_.writeInt64(1, this.id);
/*  234 */       _output_.writeInt32(2, this.cat_level_cfgid);
/*  235 */       _output_.writeBytes(3, ByteString.copyFrom(this.name, "UTF-16LE"));
/*  236 */       _output_.writeInt32(4, this.explore_num);
/*  237 */       _output_.writeInt32(5, this.total_explore_num);
/*  238 */       _output_.writeInt32(6, this.vigor);
/*  239 */       _output_.writeInt32(7, this.state);
/*  240 */       _output_.writeInt64(8, this.explore_starttime);
/*  241 */       _output_.writeInt64(9, this.explore_costtime);
/*  242 */       _output_.writeInt64(10, this.explore_endtime);
/*  243 */       _output_.writeInt32(11, this.explored_level);
/*  244 */       _output_.writeInt32(12, this.explored_partner_cfgid);
/*  245 */       _output_.writeInt32(13, this.partner_cfgid);
/*  246 */       _output_.writeInt32(14, this.item_cfgid);
/*  247 */       _output_.writeInt64(15, this.force_recovery_time);
/*  248 */       for (xbean.RoleFeedInfo _v_ : this.records)
/*      */       {
/*  250 */         _output_.writeMessage(16, _v_);
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  255 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  257 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  263 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  266 */       boolean done = false;
/*  267 */       while (!done)
/*      */       {
/*  269 */         int tag = _input_.readTag();
/*  270 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  274 */           done = true;
/*  275 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  279 */           this.id = _input_.readInt64();
/*  280 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  284 */           this.cat_level_cfgid = _input_.readInt32();
/*  285 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  289 */           this.name = _input_.readBytes().toString("UTF-16LE");
/*  290 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  294 */           this.explore_num = _input_.readInt32();
/*  295 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  299 */           this.total_explore_num = _input_.readInt32();
/*  300 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  304 */           this.vigor = _input_.readInt32();
/*  305 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  309 */           this.state = _input_.readInt32();
/*  310 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  314 */           this.explore_starttime = _input_.readInt64();
/*  315 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  319 */           this.explore_costtime = _input_.readInt64();
/*  320 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  324 */           this.explore_endtime = _input_.readInt64();
/*  325 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  329 */           this.explored_level = _input_.readInt32();
/*  330 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  334 */           this.explored_partner_cfgid = _input_.readInt32();
/*  335 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  339 */           this.partner_cfgid = _input_.readInt32();
/*  340 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  344 */           this.item_cfgid = _input_.readInt32();
/*  345 */           break;
/*      */         
/*      */ 
/*      */         case 120: 
/*  349 */           this.force_recovery_time = _input_.readInt64();
/*  350 */           break;
/*      */         
/*      */ 
/*      */         case 130: 
/*  354 */           xbean.RoleFeedInfo _v_ = new RoleFeedInfo(0, this, "records");
/*  355 */           _input_.readMessage(_v_);
/*  356 */           this.records.add(_v_);
/*  357 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  361 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  363 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  372 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  376 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  378 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CatInfo copy()
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*  385 */     return new CatInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CatInfo toData()
/*      */   {
/*  391 */     _xdb_verify_unsafe_();
/*  392 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CatInfo toBean()
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     return new CatInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CatInfo toDataIf()
/*      */   {
/*  404 */     _xdb_verify_unsafe_();
/*  405 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CatInfo toBeanIf()
/*      */   {
/*  410 */     _xdb_verify_unsafe_();
/*  411 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getId()
/*      */   {
/*  425 */     _xdb_verify_unsafe_();
/*  426 */     return this.id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCat_level_cfgid()
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     return this.cat_level_cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName()
/*      */   {
/*  441 */     _xdb_verify_unsafe_();
/*  442 */     return this.name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getNameOctets()
/*      */   {
/*  449 */     _xdb_verify_unsafe_();
/*  450 */     return Octets.wrap(getName(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getExplore_num()
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     return this.explore_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTotal_explore_num()
/*      */   {
/*  465 */     _xdb_verify_unsafe_();
/*  466 */     return this.total_explore_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getVigor()
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     return this.vigor;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getState()
/*      */   {
/*  481 */     _xdb_verify_unsafe_();
/*  482 */     return this.state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getExplore_starttime()
/*      */   {
/*  489 */     _xdb_verify_unsafe_();
/*  490 */     return this.explore_starttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getExplore_costtime()
/*      */   {
/*  497 */     _xdb_verify_unsafe_();
/*  498 */     return this.explore_costtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getExplore_endtime()
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     return this.explore_endtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getExplored_level()
/*      */   {
/*  513 */     _xdb_verify_unsafe_();
/*  514 */     return this.explored_level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getExplored_partner_cfgid()
/*      */   {
/*  521 */     _xdb_verify_unsafe_();
/*  522 */     return this.explored_partner_cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPartner_cfgid()
/*      */   {
/*  529 */     _xdb_verify_unsafe_();
/*  530 */     return this.partner_cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItem_cfgid()
/*      */   {
/*  537 */     _xdb_verify_unsafe_();
/*  538 */     return this.item_cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getForce_recovery_time()
/*      */   {
/*  545 */     _xdb_verify_unsafe_();
/*  546 */     return this.force_recovery_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.RoleFeedInfo> getRecords()
/*      */   {
/*  553 */     _xdb_verify_unsafe_();
/*  554 */     return Logs.logList(new LogKey(this, "records"), this.records);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.RoleFeedInfo> getRecordsAsData()
/*      */   {
/*  560 */     _xdb_verify_unsafe_();
/*      */     
/*  562 */     CatInfo _o_ = this;
/*  563 */     List<xbean.RoleFeedInfo> records = new LinkedList();
/*  564 */     for (xbean.RoleFeedInfo _v_ : _o_.records)
/*  565 */       records.add(new RoleFeedInfo.Data(_v_));
/*  566 */     return records;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setId(long _v_)
/*      */   {
/*  573 */     _xdb_verify_unsafe_();
/*  574 */     Logs.logIf(new LogKey(this, "id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  578 */         new LogLong(this, CatInfo.this.id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  582 */             CatInfo.this.id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  586 */     });
/*  587 */     this.id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCat_level_cfgid(int _v_)
/*      */   {
/*  594 */     _xdb_verify_unsafe_();
/*  595 */     Logs.logIf(new LogKey(this, "cat_level_cfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  599 */         new LogInt(this, CatInfo.this.cat_level_cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  603 */             CatInfo.this.cat_level_cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  607 */     });
/*  608 */     this.cat_level_cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName(String _v_)
/*      */   {
/*  615 */     _xdb_verify_unsafe_();
/*  616 */     if (null == _v_)
/*  617 */       throw new NullPointerException();
/*  618 */     Logs.logIf(new LogKey(this, "name")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  622 */         new LogString(this, CatInfo.this.name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  626 */             CatInfo.this.name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  630 */     });
/*  631 */     this.name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNameOctets(Octets _v_)
/*      */   {
/*  638 */     _xdb_verify_unsafe_();
/*  639 */     setName(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExplore_num(int _v_)
/*      */   {
/*  646 */     _xdb_verify_unsafe_();
/*  647 */     Logs.logIf(new LogKey(this, "explore_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  651 */         new LogInt(this, CatInfo.this.explore_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  655 */             CatInfo.this.explore_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  659 */     });
/*  660 */     this.explore_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_explore_num(int _v_)
/*      */   {
/*  667 */     _xdb_verify_unsafe_();
/*  668 */     Logs.logIf(new LogKey(this, "total_explore_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  672 */         new LogInt(this, CatInfo.this.total_explore_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  676 */             CatInfo.this.total_explore_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  680 */     });
/*  681 */     this.total_explore_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVigor(int _v_)
/*      */   {
/*  688 */     _xdb_verify_unsafe_();
/*  689 */     Logs.logIf(new LogKey(this, "vigor")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  693 */         new LogInt(this, CatInfo.this.vigor)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  697 */             CatInfo.this.vigor = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  701 */     });
/*  702 */     this.vigor = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setState(int _v_)
/*      */   {
/*  709 */     _xdb_verify_unsafe_();
/*  710 */     Logs.logIf(new LogKey(this, "state")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  714 */         new LogInt(this, CatInfo.this.state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  718 */             CatInfo.this.state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  722 */     });
/*  723 */     this.state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExplore_starttime(long _v_)
/*      */   {
/*  730 */     _xdb_verify_unsafe_();
/*  731 */     Logs.logIf(new LogKey(this, "explore_starttime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  735 */         new LogLong(this, CatInfo.this.explore_starttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  739 */             CatInfo.this.explore_starttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  743 */     });
/*  744 */     this.explore_starttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExplore_costtime(long _v_)
/*      */   {
/*  751 */     _xdb_verify_unsafe_();
/*  752 */     Logs.logIf(new LogKey(this, "explore_costtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  756 */         new LogLong(this, CatInfo.this.explore_costtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  760 */             CatInfo.this.explore_costtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  764 */     });
/*  765 */     this.explore_costtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExplore_endtime(long _v_)
/*      */   {
/*  772 */     _xdb_verify_unsafe_();
/*  773 */     Logs.logIf(new LogKey(this, "explore_endtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  777 */         new LogLong(this, CatInfo.this.explore_endtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  781 */             CatInfo.this.explore_endtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  785 */     });
/*  786 */     this.explore_endtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExplored_level(int _v_)
/*      */   {
/*  793 */     _xdb_verify_unsafe_();
/*  794 */     Logs.logIf(new LogKey(this, "explored_level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  798 */         new LogInt(this, CatInfo.this.explored_level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  802 */             CatInfo.this.explored_level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  806 */     });
/*  807 */     this.explored_level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExplored_partner_cfgid(int _v_)
/*      */   {
/*  814 */     _xdb_verify_unsafe_();
/*  815 */     Logs.logIf(new LogKey(this, "explored_partner_cfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  819 */         new LogInt(this, CatInfo.this.explored_partner_cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  823 */             CatInfo.this.explored_partner_cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  827 */     });
/*  828 */     this.explored_partner_cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPartner_cfgid(int _v_)
/*      */   {
/*  835 */     _xdb_verify_unsafe_();
/*  836 */     Logs.logIf(new LogKey(this, "partner_cfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  840 */         new LogInt(this, CatInfo.this.partner_cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  844 */             CatInfo.this.partner_cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  848 */     });
/*  849 */     this.partner_cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItem_cfgid(int _v_)
/*      */   {
/*  856 */     _xdb_verify_unsafe_();
/*  857 */     Logs.logIf(new LogKey(this, "item_cfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  861 */         new LogInt(this, CatInfo.this.item_cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  865 */             CatInfo.this.item_cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  869 */     });
/*  870 */     this.item_cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setForce_recovery_time(long _v_)
/*      */   {
/*  877 */     _xdb_verify_unsafe_();
/*  878 */     Logs.logIf(new LogKey(this, "force_recovery_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  882 */         new LogLong(this, CatInfo.this.force_recovery_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  886 */             CatInfo.this.force_recovery_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  890 */     });
/*  891 */     this.force_recovery_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  897 */     _xdb_verify_unsafe_();
/*  898 */     CatInfo _o_ = null;
/*  899 */     if ((_o1_ instanceof CatInfo)) { _o_ = (CatInfo)_o1_;
/*  900 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  901 */       return false;
/*  902 */     if (this.id != _o_.id) return false;
/*  903 */     if (this.cat_level_cfgid != _o_.cat_level_cfgid) return false;
/*  904 */     if (!this.name.equals(_o_.name)) return false;
/*  905 */     if (this.explore_num != _o_.explore_num) return false;
/*  906 */     if (this.total_explore_num != _o_.total_explore_num) return false;
/*  907 */     if (this.vigor != _o_.vigor) return false;
/*  908 */     if (this.state != _o_.state) return false;
/*  909 */     if (this.explore_starttime != _o_.explore_starttime) return false;
/*  910 */     if (this.explore_costtime != _o_.explore_costtime) return false;
/*  911 */     if (this.explore_endtime != _o_.explore_endtime) return false;
/*  912 */     if (this.explored_level != _o_.explored_level) return false;
/*  913 */     if (this.explored_partner_cfgid != _o_.explored_partner_cfgid) return false;
/*  914 */     if (this.partner_cfgid != _o_.partner_cfgid) return false;
/*  915 */     if (this.item_cfgid != _o_.item_cfgid) return false;
/*  916 */     if (this.force_recovery_time != _o_.force_recovery_time) return false;
/*  917 */     if (!this.records.equals(_o_.records)) return false;
/*  918 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  924 */     _xdb_verify_unsafe_();
/*  925 */     int _h_ = 0;
/*  926 */     _h_ = (int)(_h_ + this.id);
/*  927 */     _h_ += this.cat_level_cfgid;
/*  928 */     _h_ += this.name.hashCode();
/*  929 */     _h_ += this.explore_num;
/*  930 */     _h_ += this.total_explore_num;
/*  931 */     _h_ += this.vigor;
/*  932 */     _h_ += this.state;
/*  933 */     _h_ = (int)(_h_ + this.explore_starttime);
/*  934 */     _h_ = (int)(_h_ + this.explore_costtime);
/*  935 */     _h_ = (int)(_h_ + this.explore_endtime);
/*  936 */     _h_ += this.explored_level;
/*  937 */     _h_ += this.explored_partner_cfgid;
/*  938 */     _h_ += this.partner_cfgid;
/*  939 */     _h_ += this.item_cfgid;
/*  940 */     _h_ = (int)(_h_ + this.force_recovery_time);
/*  941 */     _h_ += this.records.hashCode();
/*  942 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  948 */     _xdb_verify_unsafe_();
/*  949 */     StringBuilder _sb_ = new StringBuilder();
/*  950 */     _sb_.append("(");
/*  951 */     _sb_.append(this.id);
/*  952 */     _sb_.append(",");
/*  953 */     _sb_.append(this.cat_level_cfgid);
/*  954 */     _sb_.append(",");
/*  955 */     _sb_.append("'").append(this.name).append("'");
/*  956 */     _sb_.append(",");
/*  957 */     _sb_.append(this.explore_num);
/*  958 */     _sb_.append(",");
/*  959 */     _sb_.append(this.total_explore_num);
/*  960 */     _sb_.append(",");
/*  961 */     _sb_.append(this.vigor);
/*  962 */     _sb_.append(",");
/*  963 */     _sb_.append(this.state);
/*  964 */     _sb_.append(",");
/*  965 */     _sb_.append(this.explore_starttime);
/*  966 */     _sb_.append(",");
/*  967 */     _sb_.append(this.explore_costtime);
/*  968 */     _sb_.append(",");
/*  969 */     _sb_.append(this.explore_endtime);
/*  970 */     _sb_.append(",");
/*  971 */     _sb_.append(this.explored_level);
/*  972 */     _sb_.append(",");
/*  973 */     _sb_.append(this.explored_partner_cfgid);
/*  974 */     _sb_.append(",");
/*  975 */     _sb_.append(this.partner_cfgid);
/*  976 */     _sb_.append(",");
/*  977 */     _sb_.append(this.item_cfgid);
/*  978 */     _sb_.append(",");
/*  979 */     _sb_.append(this.force_recovery_time);
/*  980 */     _sb_.append(",");
/*  981 */     _sb_.append(this.records);
/*  982 */     _sb_.append(")");
/*  983 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  989 */     ListenableBean lb = new ListenableBean();
/*  990 */     lb.add(new ListenableChanged().setVarName("id"));
/*  991 */     lb.add(new ListenableChanged().setVarName("cat_level_cfgid"));
/*  992 */     lb.add(new ListenableChanged().setVarName("name"));
/*  993 */     lb.add(new ListenableChanged().setVarName("explore_num"));
/*  994 */     lb.add(new ListenableChanged().setVarName("total_explore_num"));
/*  995 */     lb.add(new ListenableChanged().setVarName("vigor"));
/*  996 */     lb.add(new ListenableChanged().setVarName("state"));
/*  997 */     lb.add(new ListenableChanged().setVarName("explore_starttime"));
/*  998 */     lb.add(new ListenableChanged().setVarName("explore_costtime"));
/*  999 */     lb.add(new ListenableChanged().setVarName("explore_endtime"));
/* 1000 */     lb.add(new ListenableChanged().setVarName("explored_level"));
/* 1001 */     lb.add(new ListenableChanged().setVarName("explored_partner_cfgid"));
/* 1002 */     lb.add(new ListenableChanged().setVarName("partner_cfgid"));
/* 1003 */     lb.add(new ListenableChanged().setVarName("item_cfgid"));
/* 1004 */     lb.add(new ListenableChanged().setVarName("force_recovery_time"));
/* 1005 */     lb.add(new ListenableChanged().setVarName("records"));
/* 1006 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CatInfo {
/*      */     private Const() {}
/*      */     
/*      */     CatInfo nThis() {
/* 1013 */       return CatInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1019 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CatInfo copy()
/*      */     {
/* 1025 */       return CatInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CatInfo toData()
/*      */     {
/* 1031 */       return CatInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CatInfo toBean()
/*      */     {
/* 1036 */       return CatInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CatInfo toDataIf()
/*      */     {
/* 1042 */       return CatInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CatInfo toBeanIf()
/*      */     {
/* 1047 */       return CatInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getId()
/*      */     {
/* 1054 */       CatInfo.this._xdb_verify_unsafe_();
/* 1055 */       return CatInfo.this.id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCat_level_cfgid()
/*      */     {
/* 1062 */       CatInfo.this._xdb_verify_unsafe_();
/* 1063 */       return CatInfo.this.cat_level_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/* 1070 */       CatInfo.this._xdb_verify_unsafe_();
/* 1071 */       return CatInfo.this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/* 1078 */       CatInfo.this._xdb_verify_unsafe_();
/* 1079 */       return CatInfo.this.getNameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExplore_num()
/*      */     {
/* 1086 */       CatInfo.this._xdb_verify_unsafe_();
/* 1087 */       return CatInfo.this.explore_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_explore_num()
/*      */     {
/* 1094 */       CatInfo.this._xdb_verify_unsafe_();
/* 1095 */       return CatInfo.this.total_explore_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVigor()
/*      */     {
/* 1102 */       CatInfo.this._xdb_verify_unsafe_();
/* 1103 */       return CatInfo.this.vigor;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1110 */       CatInfo.this._xdb_verify_unsafe_();
/* 1111 */       return CatInfo.this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExplore_starttime()
/*      */     {
/* 1118 */       CatInfo.this._xdb_verify_unsafe_();
/* 1119 */       return CatInfo.this.explore_starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExplore_costtime()
/*      */     {
/* 1126 */       CatInfo.this._xdb_verify_unsafe_();
/* 1127 */       return CatInfo.this.explore_costtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExplore_endtime()
/*      */     {
/* 1134 */       CatInfo.this._xdb_verify_unsafe_();
/* 1135 */       return CatInfo.this.explore_endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExplored_level()
/*      */     {
/* 1142 */       CatInfo.this._xdb_verify_unsafe_();
/* 1143 */       return CatInfo.this.explored_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExplored_partner_cfgid()
/*      */     {
/* 1150 */       CatInfo.this._xdb_verify_unsafe_();
/* 1151 */       return CatInfo.this.explored_partner_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPartner_cfgid()
/*      */     {
/* 1158 */       CatInfo.this._xdb_verify_unsafe_();
/* 1159 */       return CatInfo.this.partner_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_cfgid()
/*      */     {
/* 1166 */       CatInfo.this._xdb_verify_unsafe_();
/* 1167 */       return CatInfo.this.item_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getForce_recovery_time()
/*      */     {
/* 1174 */       CatInfo.this._xdb_verify_unsafe_();
/* 1175 */       return CatInfo.this.force_recovery_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.RoleFeedInfo> getRecords()
/*      */     {
/* 1182 */       CatInfo.this._xdb_verify_unsafe_();
/* 1183 */       return Consts.constList(CatInfo.this.records);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.RoleFeedInfo> getRecordsAsData()
/*      */     {
/* 1189 */       CatInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1191 */       CatInfo _o_ = CatInfo.this;
/* 1192 */       List<xbean.RoleFeedInfo> records = new LinkedList();
/* 1193 */       for (xbean.RoleFeedInfo _v_ : _o_.records)
/* 1194 */         records.add(new RoleFeedInfo.Data(_v_));
/* 1195 */       return records;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setId(long _v_)
/*      */     {
/* 1202 */       CatInfo.this._xdb_verify_unsafe_();
/* 1203 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCat_level_cfgid(int _v_)
/*      */     {
/* 1210 */       CatInfo.this._xdb_verify_unsafe_();
/* 1211 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/* 1218 */       CatInfo.this._xdb_verify_unsafe_();
/* 1219 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/* 1226 */       CatInfo.this._xdb_verify_unsafe_();
/* 1227 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExplore_num(int _v_)
/*      */     {
/* 1234 */       CatInfo.this._xdb_verify_unsafe_();
/* 1235 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_explore_num(int _v_)
/*      */     {
/* 1242 */       CatInfo.this._xdb_verify_unsafe_();
/* 1243 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVigor(int _v_)
/*      */     {
/* 1250 */       CatInfo.this._xdb_verify_unsafe_();
/* 1251 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 1258 */       CatInfo.this._xdb_verify_unsafe_();
/* 1259 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExplore_starttime(long _v_)
/*      */     {
/* 1266 */       CatInfo.this._xdb_verify_unsafe_();
/* 1267 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExplore_costtime(long _v_)
/*      */     {
/* 1274 */       CatInfo.this._xdb_verify_unsafe_();
/* 1275 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExplore_endtime(long _v_)
/*      */     {
/* 1282 */       CatInfo.this._xdb_verify_unsafe_();
/* 1283 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExplored_level(int _v_)
/*      */     {
/* 1290 */       CatInfo.this._xdb_verify_unsafe_();
/* 1291 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExplored_partner_cfgid(int _v_)
/*      */     {
/* 1298 */       CatInfo.this._xdb_verify_unsafe_();
/* 1299 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPartner_cfgid(int _v_)
/*      */     {
/* 1306 */       CatInfo.this._xdb_verify_unsafe_();
/* 1307 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_cfgid(int _v_)
/*      */     {
/* 1314 */       CatInfo.this._xdb_verify_unsafe_();
/* 1315 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setForce_recovery_time(long _v_)
/*      */     {
/* 1322 */       CatInfo.this._xdb_verify_unsafe_();
/* 1323 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1329 */       CatInfo.this._xdb_verify_unsafe_();
/* 1330 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1336 */       CatInfo.this._xdb_verify_unsafe_();
/* 1337 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1343 */       return CatInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1349 */       return CatInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1355 */       CatInfo.this._xdb_verify_unsafe_();
/* 1356 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1362 */       return CatInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1368 */       return CatInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1374 */       CatInfo.this._xdb_verify_unsafe_();
/* 1375 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1381 */       return CatInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1387 */       return CatInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1393 */       return CatInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1399 */       return CatInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1405 */       return CatInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1411 */       return CatInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1417 */       return CatInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CatInfo
/*      */   {
/*      */     private long id;
/*      */     
/*      */     private int cat_level_cfgid;
/*      */     
/*      */     private String name;
/*      */     
/*      */     private int explore_num;
/*      */     
/*      */     private int total_explore_num;
/*      */     
/*      */     private int vigor;
/*      */     
/*      */     private int state;
/*      */     
/*      */     private long explore_starttime;
/*      */     
/*      */     private long explore_costtime;
/*      */     
/*      */     private long explore_endtime;
/*      */     
/*      */     private int explored_level;
/*      */     
/*      */     private int explored_partner_cfgid;
/*      */     
/*      */     private int partner_cfgid;
/*      */     
/*      */     private int item_cfgid;
/*      */     
/*      */     private long force_recovery_time;
/*      */     
/*      */     private LinkedList<xbean.RoleFeedInfo> records;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1459 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1464 */       this.name = "";
/* 1465 */       this.state = 1;
/* 1466 */       this.records = new LinkedList();
/*      */     }
/*      */     
/*      */     Data(xbean.CatInfo _o1_)
/*      */     {
/* 1471 */       if ((_o1_ instanceof CatInfo)) { assign((CatInfo)_o1_);
/* 1472 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1473 */       } else if ((_o1_ instanceof CatInfo.Const)) assign(((CatInfo.Const)_o1_).nThis()); else {
/* 1474 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CatInfo _o_) {
/* 1479 */       this.id = _o_.id;
/* 1480 */       this.cat_level_cfgid = _o_.cat_level_cfgid;
/* 1481 */       this.name = _o_.name;
/* 1482 */       this.explore_num = _o_.explore_num;
/* 1483 */       this.total_explore_num = _o_.total_explore_num;
/* 1484 */       this.vigor = _o_.vigor;
/* 1485 */       this.state = _o_.state;
/* 1486 */       this.explore_starttime = _o_.explore_starttime;
/* 1487 */       this.explore_costtime = _o_.explore_costtime;
/* 1488 */       this.explore_endtime = _o_.explore_endtime;
/* 1489 */       this.explored_level = _o_.explored_level;
/* 1490 */       this.explored_partner_cfgid = _o_.explored_partner_cfgid;
/* 1491 */       this.partner_cfgid = _o_.partner_cfgid;
/* 1492 */       this.item_cfgid = _o_.item_cfgid;
/* 1493 */       this.force_recovery_time = _o_.force_recovery_time;
/* 1494 */       this.records = new LinkedList();
/* 1495 */       for (xbean.RoleFeedInfo _v_ : _o_.records) {
/* 1496 */         this.records.add(new RoleFeedInfo.Data(_v_));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/* 1501 */       this.id = _o_.id;
/* 1502 */       this.cat_level_cfgid = _o_.cat_level_cfgid;
/* 1503 */       this.name = _o_.name;
/* 1504 */       this.explore_num = _o_.explore_num;
/* 1505 */       this.total_explore_num = _o_.total_explore_num;
/* 1506 */       this.vigor = _o_.vigor;
/* 1507 */       this.state = _o_.state;
/* 1508 */       this.explore_starttime = _o_.explore_starttime;
/* 1509 */       this.explore_costtime = _o_.explore_costtime;
/* 1510 */       this.explore_endtime = _o_.explore_endtime;
/* 1511 */       this.explored_level = _o_.explored_level;
/* 1512 */       this.explored_partner_cfgid = _o_.explored_partner_cfgid;
/* 1513 */       this.partner_cfgid = _o_.partner_cfgid;
/* 1514 */       this.item_cfgid = _o_.item_cfgid;
/* 1515 */       this.force_recovery_time = _o_.force_recovery_time;
/* 1516 */       this.records = new LinkedList();
/* 1517 */       for (xbean.RoleFeedInfo _v_ : _o_.records) {
/* 1518 */         this.records.add(new RoleFeedInfo.Data(_v_));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1524 */       _os_.marshal(this.id);
/* 1525 */       _os_.marshal(this.cat_level_cfgid);
/* 1526 */       _os_.marshal(this.name, "UTF-16LE");
/* 1527 */       _os_.marshal(this.explore_num);
/* 1528 */       _os_.marshal(this.total_explore_num);
/* 1529 */       _os_.marshal(this.vigor);
/* 1530 */       _os_.marshal(this.state);
/* 1531 */       _os_.marshal(this.explore_starttime);
/* 1532 */       _os_.marshal(this.explore_costtime);
/* 1533 */       _os_.marshal(this.explore_endtime);
/* 1534 */       _os_.marshal(this.explored_level);
/* 1535 */       _os_.marshal(this.explored_partner_cfgid);
/* 1536 */       _os_.marshal(this.partner_cfgid);
/* 1537 */       _os_.marshal(this.item_cfgid);
/* 1538 */       _os_.marshal(this.force_recovery_time);
/* 1539 */       _os_.compact_uint32(this.records.size());
/* 1540 */       for (xbean.RoleFeedInfo _v_ : this.records)
/*      */       {
/* 1542 */         _v_.marshal(_os_);
/*      */       }
/* 1544 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1550 */       this.id = _os_.unmarshal_long();
/* 1551 */       this.cat_level_cfgid = _os_.unmarshal_int();
/* 1552 */       this.name = _os_.unmarshal_String("UTF-16LE");
/* 1553 */       this.explore_num = _os_.unmarshal_int();
/* 1554 */       this.total_explore_num = _os_.unmarshal_int();
/* 1555 */       this.vigor = _os_.unmarshal_int();
/* 1556 */       this.state = _os_.unmarshal_int();
/* 1557 */       this.explore_starttime = _os_.unmarshal_long();
/* 1558 */       this.explore_costtime = _os_.unmarshal_long();
/* 1559 */       this.explore_endtime = _os_.unmarshal_long();
/* 1560 */       this.explored_level = _os_.unmarshal_int();
/* 1561 */       this.explored_partner_cfgid = _os_.unmarshal_int();
/* 1562 */       this.partner_cfgid = _os_.unmarshal_int();
/* 1563 */       this.item_cfgid = _os_.unmarshal_int();
/* 1564 */       this.force_recovery_time = _os_.unmarshal_long();
/* 1565 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1567 */         xbean.RoleFeedInfo _v_ = Pod.newRoleFeedInfoData();
/* 1568 */         _v_.unmarshal(_os_);
/* 1569 */         this.records.add(_v_);
/*      */       }
/* 1571 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1577 */       int _size_ = 0;
/* 1578 */       _size_ += CodedOutputStream.computeInt64Size(1, this.id);
/* 1579 */       _size_ += CodedOutputStream.computeInt32Size(2, this.cat_level_cfgid);
/*      */       try
/*      */       {
/* 1582 */         _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1586 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1588 */       _size_ += CodedOutputStream.computeInt32Size(4, this.explore_num);
/* 1589 */       _size_ += CodedOutputStream.computeInt32Size(5, this.total_explore_num);
/* 1590 */       _size_ += CodedOutputStream.computeInt32Size(6, this.vigor);
/* 1591 */       _size_ += CodedOutputStream.computeInt32Size(7, this.state);
/* 1592 */       _size_ += CodedOutputStream.computeInt64Size(8, this.explore_starttime);
/* 1593 */       _size_ += CodedOutputStream.computeInt64Size(9, this.explore_costtime);
/* 1594 */       _size_ += CodedOutputStream.computeInt64Size(10, this.explore_endtime);
/* 1595 */       _size_ += CodedOutputStream.computeInt32Size(11, this.explored_level);
/* 1596 */       _size_ += CodedOutputStream.computeInt32Size(12, this.explored_partner_cfgid);
/* 1597 */       _size_ += CodedOutputStream.computeInt32Size(13, this.partner_cfgid);
/* 1598 */       _size_ += CodedOutputStream.computeInt32Size(14, this.item_cfgid);
/* 1599 */       _size_ += CodedOutputStream.computeInt64Size(15, this.force_recovery_time);
/* 1600 */       for (xbean.RoleFeedInfo _v_ : this.records)
/*      */       {
/* 1602 */         _size_ += CodedOutputStream.computeMessageSize(16, _v_);
/*      */       }
/* 1604 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1612 */         _output_.writeInt64(1, this.id);
/* 1613 */         _output_.writeInt32(2, this.cat_level_cfgid);
/* 1614 */         _output_.writeBytes(3, ByteString.copyFrom(this.name, "UTF-16LE"));
/* 1615 */         _output_.writeInt32(4, this.explore_num);
/* 1616 */         _output_.writeInt32(5, this.total_explore_num);
/* 1617 */         _output_.writeInt32(6, this.vigor);
/* 1618 */         _output_.writeInt32(7, this.state);
/* 1619 */         _output_.writeInt64(8, this.explore_starttime);
/* 1620 */         _output_.writeInt64(9, this.explore_costtime);
/* 1621 */         _output_.writeInt64(10, this.explore_endtime);
/* 1622 */         _output_.writeInt32(11, this.explored_level);
/* 1623 */         _output_.writeInt32(12, this.explored_partner_cfgid);
/* 1624 */         _output_.writeInt32(13, this.partner_cfgid);
/* 1625 */         _output_.writeInt32(14, this.item_cfgid);
/* 1626 */         _output_.writeInt64(15, this.force_recovery_time);
/* 1627 */         for (xbean.RoleFeedInfo _v_ : this.records)
/*      */         {
/* 1629 */           _output_.writeMessage(16, _v_);
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1634 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1636 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1644 */         boolean done = false;
/* 1645 */         while (!done)
/*      */         {
/* 1647 */           int tag = _input_.readTag();
/* 1648 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1652 */             done = true;
/* 1653 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1657 */             this.id = _input_.readInt64();
/* 1658 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1662 */             this.cat_level_cfgid = _input_.readInt32();
/* 1663 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/* 1667 */             this.name = _input_.readBytes().toString("UTF-16LE");
/* 1668 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1672 */             this.explore_num = _input_.readInt32();
/* 1673 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1677 */             this.total_explore_num = _input_.readInt32();
/* 1678 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1682 */             this.vigor = _input_.readInt32();
/* 1683 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1687 */             this.state = _input_.readInt32();
/* 1688 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1692 */             this.explore_starttime = _input_.readInt64();
/* 1693 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1697 */             this.explore_costtime = _input_.readInt64();
/* 1698 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1702 */             this.explore_endtime = _input_.readInt64();
/* 1703 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1707 */             this.explored_level = _input_.readInt32();
/* 1708 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 1712 */             this.explored_partner_cfgid = _input_.readInt32();
/* 1713 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 1717 */             this.partner_cfgid = _input_.readInt32();
/* 1718 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 1722 */             this.item_cfgid = _input_.readInt32();
/* 1723 */             break;
/*      */           
/*      */ 
/*      */           case 120: 
/* 1727 */             this.force_recovery_time = _input_.readInt64();
/* 1728 */             break;
/*      */           
/*      */ 
/*      */           case 130: 
/* 1732 */             xbean.RoleFeedInfo _v_ = Pod.newRoleFeedInfoData();
/* 1733 */             _input_.readMessage(_v_);
/* 1734 */             this.records.add(_v_);
/* 1735 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1739 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1741 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1750 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1754 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1756 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CatInfo copy()
/*      */     {
/* 1762 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CatInfo toData()
/*      */     {
/* 1768 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CatInfo toBean()
/*      */     {
/* 1773 */       return new CatInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CatInfo toDataIf()
/*      */     {
/* 1779 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CatInfo toBeanIf()
/*      */     {
/* 1784 */       return new CatInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1790 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1794 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1798 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1802 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1806 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1810 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1814 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getId()
/*      */     {
/* 1821 */       return this.id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCat_level_cfgid()
/*      */     {
/* 1828 */       return this.cat_level_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/* 1835 */       return this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/* 1842 */       return Octets.wrap(getName(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExplore_num()
/*      */     {
/* 1849 */       return this.explore_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_explore_num()
/*      */     {
/* 1856 */       return this.total_explore_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVigor()
/*      */     {
/* 1863 */       return this.vigor;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1870 */       return this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExplore_starttime()
/*      */     {
/* 1877 */       return this.explore_starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExplore_costtime()
/*      */     {
/* 1884 */       return this.explore_costtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExplore_endtime()
/*      */     {
/* 1891 */       return this.explore_endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExplored_level()
/*      */     {
/* 1898 */       return this.explored_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExplored_partner_cfgid()
/*      */     {
/* 1905 */       return this.explored_partner_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPartner_cfgid()
/*      */     {
/* 1912 */       return this.partner_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItem_cfgid()
/*      */     {
/* 1919 */       return this.item_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getForce_recovery_time()
/*      */     {
/* 1926 */       return this.force_recovery_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.RoleFeedInfo> getRecords()
/*      */     {
/* 1933 */       return this.records;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.RoleFeedInfo> getRecordsAsData()
/*      */     {
/* 1940 */       return this.records;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setId(long _v_)
/*      */     {
/* 1947 */       this.id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCat_level_cfgid(int _v_)
/*      */     {
/* 1954 */       this.cat_level_cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/* 1961 */       if (null == _v_)
/* 1962 */         throw new NullPointerException();
/* 1963 */       this.name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/* 1970 */       setName(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExplore_num(int _v_)
/*      */     {
/* 1977 */       this.explore_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_explore_num(int _v_)
/*      */     {
/* 1984 */       this.total_explore_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVigor(int _v_)
/*      */     {
/* 1991 */       this.vigor = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 1998 */       this.state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExplore_starttime(long _v_)
/*      */     {
/* 2005 */       this.explore_starttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExplore_costtime(long _v_)
/*      */     {
/* 2012 */       this.explore_costtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExplore_endtime(long _v_)
/*      */     {
/* 2019 */       this.explore_endtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExplored_level(int _v_)
/*      */     {
/* 2026 */       this.explored_level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExplored_partner_cfgid(int _v_)
/*      */     {
/* 2033 */       this.explored_partner_cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPartner_cfgid(int _v_)
/*      */     {
/* 2040 */       this.partner_cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_cfgid(int _v_)
/*      */     {
/* 2047 */       this.item_cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setForce_recovery_time(long _v_)
/*      */     {
/* 2054 */       this.force_recovery_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 2060 */       if (!(_o1_ instanceof Data)) return false;
/* 2061 */       Data _o_ = (Data)_o1_;
/* 2062 */       if (this.id != _o_.id) return false;
/* 2063 */       if (this.cat_level_cfgid != _o_.cat_level_cfgid) return false;
/* 2064 */       if (!this.name.equals(_o_.name)) return false;
/* 2065 */       if (this.explore_num != _o_.explore_num) return false;
/* 2066 */       if (this.total_explore_num != _o_.total_explore_num) return false;
/* 2067 */       if (this.vigor != _o_.vigor) return false;
/* 2068 */       if (this.state != _o_.state) return false;
/* 2069 */       if (this.explore_starttime != _o_.explore_starttime) return false;
/* 2070 */       if (this.explore_costtime != _o_.explore_costtime) return false;
/* 2071 */       if (this.explore_endtime != _o_.explore_endtime) return false;
/* 2072 */       if (this.explored_level != _o_.explored_level) return false;
/* 2073 */       if (this.explored_partner_cfgid != _o_.explored_partner_cfgid) return false;
/* 2074 */       if (this.partner_cfgid != _o_.partner_cfgid) return false;
/* 2075 */       if (this.item_cfgid != _o_.item_cfgid) return false;
/* 2076 */       if (this.force_recovery_time != _o_.force_recovery_time) return false;
/* 2077 */       if (!this.records.equals(_o_.records)) return false;
/* 2078 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 2084 */       int _h_ = 0;
/* 2085 */       _h_ = (int)(_h_ + this.id);
/* 2086 */       _h_ += this.cat_level_cfgid;
/* 2087 */       _h_ += this.name.hashCode();
/* 2088 */       _h_ += this.explore_num;
/* 2089 */       _h_ += this.total_explore_num;
/* 2090 */       _h_ += this.vigor;
/* 2091 */       _h_ += this.state;
/* 2092 */       _h_ = (int)(_h_ + this.explore_starttime);
/* 2093 */       _h_ = (int)(_h_ + this.explore_costtime);
/* 2094 */       _h_ = (int)(_h_ + this.explore_endtime);
/* 2095 */       _h_ += this.explored_level;
/* 2096 */       _h_ += this.explored_partner_cfgid;
/* 2097 */       _h_ += this.partner_cfgid;
/* 2098 */       _h_ += this.item_cfgid;
/* 2099 */       _h_ = (int)(_h_ + this.force_recovery_time);
/* 2100 */       _h_ += this.records.hashCode();
/* 2101 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2107 */       StringBuilder _sb_ = new StringBuilder();
/* 2108 */       _sb_.append("(");
/* 2109 */       _sb_.append(this.id);
/* 2110 */       _sb_.append(",");
/* 2111 */       _sb_.append(this.cat_level_cfgid);
/* 2112 */       _sb_.append(",");
/* 2113 */       _sb_.append("'").append(this.name).append("'");
/* 2114 */       _sb_.append(",");
/* 2115 */       _sb_.append(this.explore_num);
/* 2116 */       _sb_.append(",");
/* 2117 */       _sb_.append(this.total_explore_num);
/* 2118 */       _sb_.append(",");
/* 2119 */       _sb_.append(this.vigor);
/* 2120 */       _sb_.append(",");
/* 2121 */       _sb_.append(this.state);
/* 2122 */       _sb_.append(",");
/* 2123 */       _sb_.append(this.explore_starttime);
/* 2124 */       _sb_.append(",");
/* 2125 */       _sb_.append(this.explore_costtime);
/* 2126 */       _sb_.append(",");
/* 2127 */       _sb_.append(this.explore_endtime);
/* 2128 */       _sb_.append(",");
/* 2129 */       _sb_.append(this.explored_level);
/* 2130 */       _sb_.append(",");
/* 2131 */       _sb_.append(this.explored_partner_cfgid);
/* 2132 */       _sb_.append(",");
/* 2133 */       _sb_.append(this.partner_cfgid);
/* 2134 */       _sb_.append(",");
/* 2135 */       _sb_.append(this.item_cfgid);
/* 2136 */       _sb_.append(",");
/* 2137 */       _sb_.append(this.force_recovery_time);
/* 2138 */       _sb_.append(",");
/* 2139 */       _sb_.append(this.records);
/* 2140 */       _sb_.append(")");
/* 2141 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */