/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogObject;
/*      */ import xdb.logs.LogString;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class GangMember
/*      */   extends XBean
/*      */   implements xbean.GangMember
/*      */ {
/*      */   private int duty;
/*      */   private long banggong;
/*      */   private long historybanggong;
/*      */   private long gangid;
/*      */   private long jointime;
/*      */   private long forbiddentalkend;
/*      */   private long lastreadannouncementtimestamp;
/*      */   private long redeembanggong;
/*      */   private long nextupdateredeemtimestamp;
/*      */   private int makemifangcount;
/*      */   private int totalmakemifangcount;
/*      */   private long lasthavemifangtime;
/*      */   private long lastgetfulitime;
/*      */   private long lastgetlihetime;
/*      */   private int gongxun;
/*      */   private long gongxun_timestamp;
/*      */   private int issign;
/*      */   private long signtime;
/*      */   private String signstr;
/*      */   private boolean ispassiveleaved;
/*      */   private int weekbanggong;
/*      */   private long addbanggong_time;
/*      */   private int weekitem_banggong_count;
/*      */   private long item_banggong_time;
/*      */   private int yuanbao_redeem_bang_gong;
/*      */   private long create_gang_team_time;
/*      */   private boolean is_in_gang;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   70 */     this.duty = 0;
/*   71 */     this.banggong = 0L;
/*   72 */     this.historybanggong = 0L;
/*   73 */     this.gangid = 0L;
/*   74 */     this.jointime = 0L;
/*   75 */     this.forbiddentalkend = 0L;
/*   76 */     this.lastreadannouncementtimestamp = 0L;
/*   77 */     this.redeembanggong = 0L;
/*   78 */     this.nextupdateredeemtimestamp = 0L;
/*   79 */     this.makemifangcount = 0;
/*   80 */     this.totalmakemifangcount = 0;
/*   81 */     this.lasthavemifangtime = 0L;
/*   82 */     this.lastgetfulitime = 0L;
/*   83 */     this.lastgetlihetime = 0L;
/*   84 */     this.gongxun = 0;
/*   85 */     this.gongxun_timestamp = 0L;
/*   86 */     this.issign = 0;
/*   87 */     this.signtime = 0L;
/*   88 */     this.signstr = "";
/*   89 */     this.ispassiveleaved = false;
/*   90 */     this.weekbanggong = 0;
/*   91 */     this.addbanggong_time = 0L;
/*   92 */     this.weekitem_banggong_count = 0;
/*   93 */     this.item_banggong_time = 0L;
/*   94 */     this.yuanbao_redeem_bang_gong = 0;
/*   95 */     this.create_gang_team_time = 0L;
/*   96 */     this.is_in_gang = true;
/*      */   }
/*      */   
/*      */   GangMember(int __, XBean _xp_, String _vn_)
/*      */   {
/*  101 */     super(_xp_, _vn_);
/*  102 */     this.signstr = "";
/*  103 */     this.ispassiveleaved = false;
/*  104 */     this.create_gang_team_time = 0L;
/*  105 */     this.is_in_gang = true;
/*      */   }
/*      */   
/*      */   public GangMember()
/*      */   {
/*  110 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public GangMember(GangMember _o_)
/*      */   {
/*  115 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   GangMember(xbean.GangMember _o1_, XBean _xp_, String _vn_)
/*      */   {
/*  120 */     super(_xp_, _vn_);
/*  121 */     if ((_o1_ instanceof GangMember)) { assign((GangMember)_o1_);
/*  122 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  123 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  124 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(GangMember _o_) {
/*  129 */     _o_._xdb_verify_unsafe_();
/*  130 */     this.duty = _o_.duty;
/*  131 */     this.banggong = _o_.banggong;
/*  132 */     this.historybanggong = _o_.historybanggong;
/*  133 */     this.gangid = _o_.gangid;
/*  134 */     this.jointime = _o_.jointime;
/*  135 */     this.forbiddentalkend = _o_.forbiddentalkend;
/*  136 */     this.lastreadannouncementtimestamp = _o_.lastreadannouncementtimestamp;
/*  137 */     this.redeembanggong = _o_.redeembanggong;
/*  138 */     this.nextupdateredeemtimestamp = _o_.nextupdateredeemtimestamp;
/*  139 */     this.makemifangcount = _o_.makemifangcount;
/*  140 */     this.totalmakemifangcount = _o_.totalmakemifangcount;
/*  141 */     this.lasthavemifangtime = _o_.lasthavemifangtime;
/*  142 */     this.lastgetfulitime = _o_.lastgetfulitime;
/*  143 */     this.lastgetlihetime = _o_.lastgetlihetime;
/*  144 */     this.gongxun = _o_.gongxun;
/*  145 */     this.gongxun_timestamp = _o_.gongxun_timestamp;
/*  146 */     this.issign = _o_.issign;
/*  147 */     this.signtime = _o_.signtime;
/*  148 */     this.signstr = _o_.signstr;
/*  149 */     this.ispassiveleaved = _o_.ispassiveleaved;
/*  150 */     this.weekbanggong = _o_.weekbanggong;
/*  151 */     this.addbanggong_time = _o_.addbanggong_time;
/*  152 */     this.weekitem_banggong_count = _o_.weekitem_banggong_count;
/*  153 */     this.item_banggong_time = _o_.item_banggong_time;
/*  154 */     this.yuanbao_redeem_bang_gong = _o_.yuanbao_redeem_bang_gong;
/*  155 */     this.create_gang_team_time = _o_.create_gang_team_time;
/*  156 */     this.is_in_gang = _o_.is_in_gang;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  161 */     this.duty = _o_.duty;
/*  162 */     this.banggong = _o_.banggong;
/*  163 */     this.historybanggong = _o_.historybanggong;
/*  164 */     this.gangid = _o_.gangid;
/*  165 */     this.jointime = _o_.jointime;
/*  166 */     this.forbiddentalkend = _o_.forbiddentalkend;
/*  167 */     this.lastreadannouncementtimestamp = _o_.lastreadannouncementtimestamp;
/*  168 */     this.redeembanggong = _o_.redeembanggong;
/*  169 */     this.nextupdateredeemtimestamp = _o_.nextupdateredeemtimestamp;
/*  170 */     this.makemifangcount = _o_.makemifangcount;
/*  171 */     this.totalmakemifangcount = _o_.totalmakemifangcount;
/*  172 */     this.lasthavemifangtime = _o_.lasthavemifangtime;
/*  173 */     this.lastgetfulitime = _o_.lastgetfulitime;
/*  174 */     this.lastgetlihetime = _o_.lastgetlihetime;
/*  175 */     this.gongxun = _o_.gongxun;
/*  176 */     this.gongxun_timestamp = _o_.gongxun_timestamp;
/*  177 */     this.issign = _o_.issign;
/*  178 */     this.signtime = _o_.signtime;
/*  179 */     this.signstr = _o_.signstr;
/*  180 */     this.ispassiveleaved = _o_.ispassiveleaved;
/*  181 */     this.weekbanggong = _o_.weekbanggong;
/*  182 */     this.addbanggong_time = _o_.addbanggong_time;
/*  183 */     this.weekitem_banggong_count = _o_.weekitem_banggong_count;
/*  184 */     this.item_banggong_time = _o_.item_banggong_time;
/*  185 */     this.yuanbao_redeem_bang_gong = _o_.yuanbao_redeem_bang_gong;
/*  186 */     this.create_gang_team_time = _o_.create_gang_team_time;
/*  187 */     this.is_in_gang = _o_.is_in_gang;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  193 */     _xdb_verify_unsafe_();
/*  194 */     _os_.marshal(this.duty);
/*  195 */     _os_.marshal(this.banggong);
/*  196 */     _os_.marshal(this.historybanggong);
/*  197 */     _os_.marshal(this.gangid);
/*  198 */     _os_.marshal(this.jointime);
/*  199 */     _os_.marshal(this.forbiddentalkend);
/*  200 */     _os_.marshal(this.lastreadannouncementtimestamp);
/*  201 */     _os_.marshal(this.redeembanggong);
/*  202 */     _os_.marshal(this.nextupdateredeemtimestamp);
/*  203 */     _os_.marshal(this.makemifangcount);
/*  204 */     _os_.marshal(this.totalmakemifangcount);
/*  205 */     _os_.marshal(this.lasthavemifangtime);
/*  206 */     _os_.marshal(this.lastgetfulitime);
/*  207 */     _os_.marshal(this.lastgetlihetime);
/*  208 */     _os_.marshal(this.gongxun);
/*  209 */     _os_.marshal(this.gongxun_timestamp);
/*  210 */     _os_.marshal(this.issign);
/*  211 */     _os_.marshal(this.signtime);
/*  212 */     _os_.marshal(this.signstr, "UTF-16LE");
/*  213 */     _os_.marshal(this.ispassiveleaved);
/*  214 */     _os_.marshal(this.weekbanggong);
/*  215 */     _os_.marshal(this.addbanggong_time);
/*  216 */     _os_.marshal(this.weekitem_banggong_count);
/*  217 */     _os_.marshal(this.item_banggong_time);
/*  218 */     _os_.marshal(this.yuanbao_redeem_bang_gong);
/*  219 */     _os_.marshal(this.create_gang_team_time);
/*  220 */     _os_.marshal(this.is_in_gang);
/*  221 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  227 */     _xdb_verify_unsafe_();
/*  228 */     this.duty = _os_.unmarshal_int();
/*  229 */     this.banggong = _os_.unmarshal_long();
/*  230 */     this.historybanggong = _os_.unmarshal_long();
/*  231 */     this.gangid = _os_.unmarshal_long();
/*  232 */     this.jointime = _os_.unmarshal_long();
/*  233 */     this.forbiddentalkend = _os_.unmarshal_long();
/*  234 */     this.lastreadannouncementtimestamp = _os_.unmarshal_long();
/*  235 */     this.redeembanggong = _os_.unmarshal_long();
/*  236 */     this.nextupdateredeemtimestamp = _os_.unmarshal_long();
/*  237 */     this.makemifangcount = _os_.unmarshal_int();
/*  238 */     this.totalmakemifangcount = _os_.unmarshal_int();
/*  239 */     this.lasthavemifangtime = _os_.unmarshal_long();
/*  240 */     this.lastgetfulitime = _os_.unmarshal_long();
/*  241 */     this.lastgetlihetime = _os_.unmarshal_long();
/*  242 */     this.gongxun = _os_.unmarshal_int();
/*  243 */     this.gongxun_timestamp = _os_.unmarshal_long();
/*  244 */     this.issign = _os_.unmarshal_int();
/*  245 */     this.signtime = _os_.unmarshal_long();
/*  246 */     this.signstr = _os_.unmarshal_String("UTF-16LE");
/*  247 */     this.ispassiveleaved = _os_.unmarshal_boolean();
/*  248 */     this.weekbanggong = _os_.unmarshal_int();
/*  249 */     this.addbanggong_time = _os_.unmarshal_long();
/*  250 */     this.weekitem_banggong_count = _os_.unmarshal_int();
/*  251 */     this.item_banggong_time = _os_.unmarshal_long();
/*  252 */     this.yuanbao_redeem_bang_gong = _os_.unmarshal_int();
/*  253 */     this.create_gang_team_time = _os_.unmarshal_long();
/*  254 */     this.is_in_gang = _os_.unmarshal_boolean();
/*  255 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     int _size_ = 0;
/*  263 */     _size_ += CodedOutputStream.computeInt32Size(1, this.duty);
/*  264 */     _size_ += CodedOutputStream.computeInt64Size(2, this.banggong);
/*  265 */     _size_ += CodedOutputStream.computeInt64Size(3, this.historybanggong);
/*  266 */     _size_ += CodedOutputStream.computeInt64Size(4, this.gangid);
/*  267 */     _size_ += CodedOutputStream.computeInt64Size(5, this.jointime);
/*  268 */     _size_ += CodedOutputStream.computeInt64Size(6, this.forbiddentalkend);
/*  269 */     _size_ += CodedOutputStream.computeInt64Size(7, this.lastreadannouncementtimestamp);
/*  270 */     _size_ += CodedOutputStream.computeInt64Size(8, this.redeembanggong);
/*  271 */     _size_ += CodedOutputStream.computeInt64Size(9, this.nextupdateredeemtimestamp);
/*  272 */     _size_ += CodedOutputStream.computeInt32Size(10, this.makemifangcount);
/*  273 */     _size_ += CodedOutputStream.computeInt32Size(11, this.totalmakemifangcount);
/*  274 */     _size_ += CodedOutputStream.computeInt64Size(12, this.lasthavemifangtime);
/*  275 */     _size_ += CodedOutputStream.computeInt64Size(13, this.lastgetfulitime);
/*  276 */     _size_ += CodedOutputStream.computeInt64Size(14, this.lastgetlihetime);
/*  277 */     _size_ += CodedOutputStream.computeInt32Size(15, this.gongxun);
/*  278 */     _size_ += CodedOutputStream.computeInt64Size(16, this.gongxun_timestamp);
/*  279 */     _size_ += CodedOutputStream.computeInt32Size(17, this.issign);
/*  280 */     _size_ += CodedOutputStream.computeInt64Size(18, this.signtime);
/*      */     try
/*      */     {
/*  283 */       _size_ += CodedOutputStream.computeBytesSize(19, ByteString.copyFrom(this.signstr, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  287 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  289 */     _size_ += CodedOutputStream.computeBoolSize(20, this.ispassiveleaved);
/*  290 */     _size_ += CodedOutputStream.computeInt32Size(21, this.weekbanggong);
/*  291 */     _size_ += CodedOutputStream.computeInt64Size(22, this.addbanggong_time);
/*  292 */     _size_ += CodedOutputStream.computeInt32Size(23, this.weekitem_banggong_count);
/*  293 */     _size_ += CodedOutputStream.computeInt64Size(24, this.item_banggong_time);
/*  294 */     _size_ += CodedOutputStream.computeInt32Size(25, this.yuanbao_redeem_bang_gong);
/*  295 */     _size_ += CodedOutputStream.computeInt64Size(26, this.create_gang_team_time);
/*  296 */     _size_ += CodedOutputStream.computeBoolSize(27, this.is_in_gang);
/*  297 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  306 */       _output_.writeInt32(1, this.duty);
/*  307 */       _output_.writeInt64(2, this.banggong);
/*  308 */       _output_.writeInt64(3, this.historybanggong);
/*  309 */       _output_.writeInt64(4, this.gangid);
/*  310 */       _output_.writeInt64(5, this.jointime);
/*  311 */       _output_.writeInt64(6, this.forbiddentalkend);
/*  312 */       _output_.writeInt64(7, this.lastreadannouncementtimestamp);
/*  313 */       _output_.writeInt64(8, this.redeembanggong);
/*  314 */       _output_.writeInt64(9, this.nextupdateredeemtimestamp);
/*  315 */       _output_.writeInt32(10, this.makemifangcount);
/*  316 */       _output_.writeInt32(11, this.totalmakemifangcount);
/*  317 */       _output_.writeInt64(12, this.lasthavemifangtime);
/*  318 */       _output_.writeInt64(13, this.lastgetfulitime);
/*  319 */       _output_.writeInt64(14, this.lastgetlihetime);
/*  320 */       _output_.writeInt32(15, this.gongxun);
/*  321 */       _output_.writeInt64(16, this.gongxun_timestamp);
/*  322 */       _output_.writeInt32(17, this.issign);
/*  323 */       _output_.writeInt64(18, this.signtime);
/*  324 */       _output_.writeBytes(19, ByteString.copyFrom(this.signstr, "UTF-16LE"));
/*  325 */       _output_.writeBool(20, this.ispassiveleaved);
/*  326 */       _output_.writeInt32(21, this.weekbanggong);
/*  327 */       _output_.writeInt64(22, this.addbanggong_time);
/*  328 */       _output_.writeInt32(23, this.weekitem_banggong_count);
/*  329 */       _output_.writeInt64(24, this.item_banggong_time);
/*  330 */       _output_.writeInt32(25, this.yuanbao_redeem_bang_gong);
/*  331 */       _output_.writeInt64(26, this.create_gang_team_time);
/*  332 */       _output_.writeBool(27, this.is_in_gang);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  336 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  338 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  347 */       boolean done = false;
/*  348 */       while (!done)
/*      */       {
/*  350 */         int tag = _input_.readTag();
/*  351 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  355 */           done = true;
/*  356 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  360 */           this.duty = _input_.readInt32();
/*  361 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  365 */           this.banggong = _input_.readInt64();
/*  366 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  370 */           this.historybanggong = _input_.readInt64();
/*  371 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  375 */           this.gangid = _input_.readInt64();
/*  376 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  380 */           this.jointime = _input_.readInt64();
/*  381 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  385 */           this.forbiddentalkend = _input_.readInt64();
/*  386 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  390 */           this.lastreadannouncementtimestamp = _input_.readInt64();
/*  391 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  395 */           this.redeembanggong = _input_.readInt64();
/*  396 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  400 */           this.nextupdateredeemtimestamp = _input_.readInt64();
/*  401 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  405 */           this.makemifangcount = _input_.readInt32();
/*  406 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  410 */           this.totalmakemifangcount = _input_.readInt32();
/*  411 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  415 */           this.lasthavemifangtime = _input_.readInt64();
/*  416 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  420 */           this.lastgetfulitime = _input_.readInt64();
/*  421 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  425 */           this.lastgetlihetime = _input_.readInt64();
/*  426 */           break;
/*      */         
/*      */ 
/*      */         case 120: 
/*  430 */           this.gongxun = _input_.readInt32();
/*  431 */           break;
/*      */         
/*      */ 
/*      */         case 128: 
/*  435 */           this.gongxun_timestamp = _input_.readInt64();
/*  436 */           break;
/*      */         
/*      */ 
/*      */         case 136: 
/*  440 */           this.issign = _input_.readInt32();
/*  441 */           break;
/*      */         
/*      */ 
/*      */         case 144: 
/*  445 */           this.signtime = _input_.readInt64();
/*  446 */           break;
/*      */         
/*      */ 
/*      */         case 154: 
/*  450 */           this.signstr = _input_.readBytes().toString("UTF-16LE");
/*  451 */           break;
/*      */         
/*      */ 
/*      */         case 160: 
/*  455 */           this.ispassiveleaved = _input_.readBool();
/*  456 */           break;
/*      */         
/*      */ 
/*      */         case 168: 
/*  460 */           this.weekbanggong = _input_.readInt32();
/*  461 */           break;
/*      */         
/*      */ 
/*      */         case 176: 
/*  465 */           this.addbanggong_time = _input_.readInt64();
/*  466 */           break;
/*      */         
/*      */ 
/*      */         case 184: 
/*  470 */           this.weekitem_banggong_count = _input_.readInt32();
/*  471 */           break;
/*      */         
/*      */ 
/*      */         case 192: 
/*  475 */           this.item_banggong_time = _input_.readInt64();
/*  476 */           break;
/*      */         
/*      */ 
/*      */         case 200: 
/*  480 */           this.yuanbao_redeem_bang_gong = _input_.readInt32();
/*  481 */           break;
/*      */         
/*      */ 
/*      */         case 208: 
/*  485 */           this.create_gang_team_time = _input_.readInt64();
/*  486 */           break;
/*      */         
/*      */ 
/*      */         case 216: 
/*  490 */           this.is_in_gang = _input_.readBool();
/*  491 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  495 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  497 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  506 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  510 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  512 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GangMember copy()
/*      */   {
/*  518 */     _xdb_verify_unsafe_();
/*  519 */     return new GangMember(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GangMember toData()
/*      */   {
/*  525 */     _xdb_verify_unsafe_();
/*  526 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GangMember toBean()
/*      */   {
/*  531 */     _xdb_verify_unsafe_();
/*  532 */     return new GangMember(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GangMember toDataIf()
/*      */   {
/*  538 */     _xdb_verify_unsafe_();
/*  539 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GangMember toBeanIf()
/*      */   {
/*  544 */     _xdb_verify_unsafe_();
/*  545 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  551 */     _xdb_verify_unsafe_();
/*  552 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDuty()
/*      */   {
/*  559 */     _xdb_verify_unsafe_();
/*  560 */     return this.duty;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBanggong()
/*      */   {
/*  567 */     _xdb_verify_unsafe_();
/*  568 */     return this.banggong;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getHistorybanggong()
/*      */   {
/*  575 */     _xdb_verify_unsafe_();
/*  576 */     return this.historybanggong;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGangid()
/*      */   {
/*  583 */     _xdb_verify_unsafe_();
/*  584 */     return this.gangid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getJointime()
/*      */   {
/*  591 */     _xdb_verify_unsafe_();
/*  592 */     return this.jointime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getForbiddentalkend()
/*      */   {
/*  599 */     _xdb_verify_unsafe_();
/*  600 */     return this.forbiddentalkend;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastreadannouncementtimestamp()
/*      */   {
/*  607 */     _xdb_verify_unsafe_();
/*  608 */     return this.lastreadannouncementtimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRedeembanggong()
/*      */   {
/*  615 */     _xdb_verify_unsafe_();
/*  616 */     return this.redeembanggong;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getNextupdateredeemtimestamp()
/*      */   {
/*  623 */     _xdb_verify_unsafe_();
/*  624 */     return this.nextupdateredeemtimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMakemifangcount()
/*      */   {
/*  631 */     _xdb_verify_unsafe_();
/*  632 */     return this.makemifangcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTotalmakemifangcount()
/*      */   {
/*  639 */     _xdb_verify_unsafe_();
/*  640 */     return this.totalmakemifangcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLasthavemifangtime()
/*      */   {
/*  647 */     _xdb_verify_unsafe_();
/*  648 */     return this.lasthavemifangtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastgetfulitime()
/*      */   {
/*  655 */     _xdb_verify_unsafe_();
/*  656 */     return this.lastgetfulitime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastgetlihetime()
/*      */   {
/*  663 */     _xdb_verify_unsafe_();
/*  664 */     return this.lastgetlihetime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGongxun()
/*      */   {
/*  671 */     _xdb_verify_unsafe_();
/*  672 */     return this.gongxun;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGongxun_timestamp()
/*      */   {
/*  679 */     _xdb_verify_unsafe_();
/*  680 */     return this.gongxun_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getIssign()
/*      */   {
/*  687 */     _xdb_verify_unsafe_();
/*  688 */     return this.issign;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSigntime()
/*      */   {
/*  695 */     _xdb_verify_unsafe_();
/*  696 */     return this.signtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getSignstr()
/*      */   {
/*  703 */     _xdb_verify_unsafe_();
/*  704 */     return this.signstr;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getSignstrOctets()
/*      */   {
/*  711 */     _xdb_verify_unsafe_();
/*  712 */     return Octets.wrap(getSignstr(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIspassiveleaved()
/*      */   {
/*  719 */     _xdb_verify_unsafe_();
/*  720 */     return this.ispassiveleaved;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWeekbanggong()
/*      */   {
/*  727 */     _xdb_verify_unsafe_();
/*  728 */     return this.weekbanggong;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAddbanggong_time()
/*      */   {
/*  735 */     _xdb_verify_unsafe_();
/*  736 */     return this.addbanggong_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWeekitem_banggong_count()
/*      */   {
/*  743 */     _xdb_verify_unsafe_();
/*  744 */     return this.weekitem_banggong_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getItem_banggong_time()
/*      */   {
/*  751 */     _xdb_verify_unsafe_();
/*  752 */     return this.item_banggong_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getYuanbao_redeem_bang_gong()
/*      */   {
/*  759 */     _xdb_verify_unsafe_();
/*  760 */     return this.yuanbao_redeem_bang_gong;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCreate_gang_team_time()
/*      */   {
/*  767 */     _xdb_verify_unsafe_();
/*  768 */     return this.create_gang_team_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_in_gang()
/*      */   {
/*  775 */     _xdb_verify_unsafe_();
/*  776 */     return this.is_in_gang;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDuty(int _v_)
/*      */   {
/*  783 */     _xdb_verify_unsafe_();
/*  784 */     Logs.logIf(new LogKey(this, "duty")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  788 */         new LogInt(this, GangMember.this.duty)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  792 */             GangMember.this.duty = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  796 */     });
/*  797 */     this.duty = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBanggong(long _v_)
/*      */   {
/*  804 */     _xdb_verify_unsafe_();
/*  805 */     Logs.logIf(new LogKey(this, "banggong")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  809 */         new LogLong(this, GangMember.this.banggong)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  813 */             GangMember.this.banggong = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  817 */     });
/*  818 */     this.banggong = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHistorybanggong(long _v_)
/*      */   {
/*  825 */     _xdb_verify_unsafe_();
/*  826 */     Logs.logIf(new LogKey(this, "historybanggong")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  830 */         new LogLong(this, GangMember.this.historybanggong)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  834 */             GangMember.this.historybanggong = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  838 */     });
/*  839 */     this.historybanggong = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGangid(long _v_)
/*      */   {
/*  846 */     _xdb_verify_unsafe_();
/*  847 */     Logs.logIf(new LogKey(this, "gangid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  851 */         new LogLong(this, GangMember.this.gangid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  855 */             GangMember.this.gangid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  859 */     });
/*  860 */     this.gangid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setJointime(long _v_)
/*      */   {
/*  867 */     _xdb_verify_unsafe_();
/*  868 */     Logs.logIf(new LogKey(this, "jointime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  872 */         new LogLong(this, GangMember.this.jointime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  876 */             GangMember.this.jointime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  880 */     });
/*  881 */     this.jointime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setForbiddentalkend(long _v_)
/*      */   {
/*  888 */     _xdb_verify_unsafe_();
/*  889 */     Logs.logIf(new LogKey(this, "forbiddentalkend")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  893 */         new LogLong(this, GangMember.this.forbiddentalkend)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  897 */             GangMember.this.forbiddentalkend = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  901 */     });
/*  902 */     this.forbiddentalkend = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastreadannouncementtimestamp(long _v_)
/*      */   {
/*  909 */     _xdb_verify_unsafe_();
/*  910 */     Logs.logIf(new LogKey(this, "lastreadannouncementtimestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  914 */         new LogLong(this, GangMember.this.lastreadannouncementtimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  918 */             GangMember.this.lastreadannouncementtimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  922 */     });
/*  923 */     this.lastreadannouncementtimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRedeembanggong(long _v_)
/*      */   {
/*  930 */     _xdb_verify_unsafe_();
/*  931 */     Logs.logIf(new LogKey(this, "redeembanggong")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  935 */         new LogLong(this, GangMember.this.redeembanggong)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  939 */             GangMember.this.redeembanggong = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  943 */     });
/*  944 */     this.redeembanggong = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNextupdateredeemtimestamp(long _v_)
/*      */   {
/*  951 */     _xdb_verify_unsafe_();
/*  952 */     Logs.logIf(new LogKey(this, "nextupdateredeemtimestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  956 */         new LogLong(this, GangMember.this.nextupdateredeemtimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  960 */             GangMember.this.nextupdateredeemtimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  964 */     });
/*  965 */     this.nextupdateredeemtimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMakemifangcount(int _v_)
/*      */   {
/*  972 */     _xdb_verify_unsafe_();
/*  973 */     Logs.logIf(new LogKey(this, "makemifangcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  977 */         new LogInt(this, GangMember.this.makemifangcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  981 */             GangMember.this.makemifangcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  985 */     });
/*  986 */     this.makemifangcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotalmakemifangcount(int _v_)
/*      */   {
/*  993 */     _xdb_verify_unsafe_();
/*  994 */     Logs.logIf(new LogKey(this, "totalmakemifangcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  998 */         new LogInt(this, GangMember.this.totalmakemifangcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1002 */             GangMember.this.totalmakemifangcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1006 */     });
/* 1007 */     this.totalmakemifangcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLasthavemifangtime(long _v_)
/*      */   {
/* 1014 */     _xdb_verify_unsafe_();
/* 1015 */     Logs.logIf(new LogKey(this, "lasthavemifangtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1019 */         new LogLong(this, GangMember.this.lasthavemifangtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1023 */             GangMember.this.lasthavemifangtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1027 */     });
/* 1028 */     this.lasthavemifangtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastgetfulitime(long _v_)
/*      */   {
/* 1035 */     _xdb_verify_unsafe_();
/* 1036 */     Logs.logIf(new LogKey(this, "lastgetfulitime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1040 */         new LogLong(this, GangMember.this.lastgetfulitime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1044 */             GangMember.this.lastgetfulitime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1048 */     });
/* 1049 */     this.lastgetfulitime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastgetlihetime(long _v_)
/*      */   {
/* 1056 */     _xdb_verify_unsafe_();
/* 1057 */     Logs.logIf(new LogKey(this, "lastgetlihetime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1061 */         new LogLong(this, GangMember.this.lastgetlihetime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1065 */             GangMember.this.lastgetlihetime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1069 */     });
/* 1070 */     this.lastgetlihetime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGongxun(int _v_)
/*      */   {
/* 1077 */     _xdb_verify_unsafe_();
/* 1078 */     Logs.logIf(new LogKey(this, "gongxun")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1082 */         new LogInt(this, GangMember.this.gongxun)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1086 */             GangMember.this.gongxun = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1090 */     });
/* 1091 */     this.gongxun = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGongxun_timestamp(long _v_)
/*      */   {
/* 1098 */     _xdb_verify_unsafe_();
/* 1099 */     Logs.logIf(new LogKey(this, "gongxun_timestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1103 */         new LogLong(this, GangMember.this.gongxun_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1107 */             GangMember.this.gongxun_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1111 */     });
/* 1112 */     this.gongxun_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIssign(int _v_)
/*      */   {
/* 1119 */     _xdb_verify_unsafe_();
/* 1120 */     Logs.logIf(new LogKey(this, "issign")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1124 */         new LogInt(this, GangMember.this.issign)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1128 */             GangMember.this.issign = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1132 */     });
/* 1133 */     this.issign = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSigntime(long _v_)
/*      */   {
/* 1140 */     _xdb_verify_unsafe_();
/* 1141 */     Logs.logIf(new LogKey(this, "signtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1145 */         new LogLong(this, GangMember.this.signtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1149 */             GangMember.this.signtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1153 */     });
/* 1154 */     this.signtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSignstr(String _v_)
/*      */   {
/* 1161 */     _xdb_verify_unsafe_();
/* 1162 */     if (null == _v_)
/* 1163 */       throw new NullPointerException();
/* 1164 */     Logs.logIf(new LogKey(this, "signstr")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1168 */         new LogString(this, GangMember.this.signstr)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1172 */             GangMember.this.signstr = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1176 */     });
/* 1177 */     this.signstr = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSignstrOctets(Octets _v_)
/*      */   {
/* 1184 */     _xdb_verify_unsafe_();
/* 1185 */     setSignstr(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIspassiveleaved(boolean _v_)
/*      */   {
/* 1192 */     _xdb_verify_unsafe_();
/* 1193 */     Logs.logIf(new LogKey(this, "ispassiveleaved")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1197 */         new LogObject(this, Boolean.valueOf(GangMember.this.ispassiveleaved))
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1201 */             GangMember.this.ispassiveleaved = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/* 1205 */     });
/* 1206 */     this.ispassiveleaved = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWeekbanggong(int _v_)
/*      */   {
/* 1213 */     _xdb_verify_unsafe_();
/* 1214 */     Logs.logIf(new LogKey(this, "weekbanggong")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1218 */         new LogInt(this, GangMember.this.weekbanggong)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1222 */             GangMember.this.weekbanggong = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1226 */     });
/* 1227 */     this.weekbanggong = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAddbanggong_time(long _v_)
/*      */   {
/* 1234 */     _xdb_verify_unsafe_();
/* 1235 */     Logs.logIf(new LogKey(this, "addbanggong_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1239 */         new LogLong(this, GangMember.this.addbanggong_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1243 */             GangMember.this.addbanggong_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1247 */     });
/* 1248 */     this.addbanggong_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWeekitem_banggong_count(int _v_)
/*      */   {
/* 1255 */     _xdb_verify_unsafe_();
/* 1256 */     Logs.logIf(new LogKey(this, "weekitem_banggong_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1260 */         new LogInt(this, GangMember.this.weekitem_banggong_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1264 */             GangMember.this.weekitem_banggong_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1268 */     });
/* 1269 */     this.weekitem_banggong_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItem_banggong_time(long _v_)
/*      */   {
/* 1276 */     _xdb_verify_unsafe_();
/* 1277 */     Logs.logIf(new LogKey(this, "item_banggong_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1281 */         new LogLong(this, GangMember.this.item_banggong_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1285 */             GangMember.this.item_banggong_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1289 */     });
/* 1290 */     this.item_banggong_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setYuanbao_redeem_bang_gong(int _v_)
/*      */   {
/* 1297 */     _xdb_verify_unsafe_();
/* 1298 */     Logs.logIf(new LogKey(this, "yuanbao_redeem_bang_gong")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1302 */         new LogInt(this, GangMember.this.yuanbao_redeem_bang_gong)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1306 */             GangMember.this.yuanbao_redeem_bang_gong = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1310 */     });
/* 1311 */     this.yuanbao_redeem_bang_gong = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCreate_gang_team_time(long _v_)
/*      */   {
/* 1318 */     _xdb_verify_unsafe_();
/* 1319 */     Logs.logIf(new LogKey(this, "create_gang_team_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1323 */         new LogLong(this, GangMember.this.create_gang_team_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1327 */             GangMember.this.create_gang_team_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1331 */     });
/* 1332 */     this.create_gang_team_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_in_gang(boolean _v_)
/*      */   {
/* 1339 */     _xdb_verify_unsafe_();
/* 1340 */     Logs.logIf(new LogKey(this, "is_in_gang")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1344 */         new LogObject(this, Boolean.valueOf(GangMember.this.is_in_gang))
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1348 */             GangMember.this.is_in_gang = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/* 1352 */     });
/* 1353 */     this.is_in_gang = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/* 1359 */     _xdb_verify_unsafe_();
/* 1360 */     GangMember _o_ = null;
/* 1361 */     if ((_o1_ instanceof GangMember)) { _o_ = (GangMember)_o1_;
/* 1362 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 1363 */       return false;
/* 1364 */     if (this.duty != _o_.duty) return false;
/* 1365 */     if (this.banggong != _o_.banggong) return false;
/* 1366 */     if (this.historybanggong != _o_.historybanggong) return false;
/* 1367 */     if (this.gangid != _o_.gangid) return false;
/* 1368 */     if (this.jointime != _o_.jointime) return false;
/* 1369 */     if (this.forbiddentalkend != _o_.forbiddentalkend) return false;
/* 1370 */     if (this.lastreadannouncementtimestamp != _o_.lastreadannouncementtimestamp) return false;
/* 1371 */     if (this.redeembanggong != _o_.redeembanggong) return false;
/* 1372 */     if (this.nextupdateredeemtimestamp != _o_.nextupdateredeemtimestamp) return false;
/* 1373 */     if (this.makemifangcount != _o_.makemifangcount) return false;
/* 1374 */     if (this.totalmakemifangcount != _o_.totalmakemifangcount) return false;
/* 1375 */     if (this.lasthavemifangtime != _o_.lasthavemifangtime) return false;
/* 1376 */     if (this.lastgetfulitime != _o_.lastgetfulitime) return false;
/* 1377 */     if (this.lastgetlihetime != _o_.lastgetlihetime) return false;
/* 1378 */     if (this.gongxun != _o_.gongxun) return false;
/* 1379 */     if (this.gongxun_timestamp != _o_.gongxun_timestamp) return false;
/* 1380 */     if (this.issign != _o_.issign) return false;
/* 1381 */     if (this.signtime != _o_.signtime) return false;
/* 1382 */     if (!this.signstr.equals(_o_.signstr)) return false;
/* 1383 */     if (this.ispassiveleaved != _o_.ispassiveleaved) return false;
/* 1384 */     if (this.weekbanggong != _o_.weekbanggong) return false;
/* 1385 */     if (this.addbanggong_time != _o_.addbanggong_time) return false;
/* 1386 */     if (this.weekitem_banggong_count != _o_.weekitem_banggong_count) return false;
/* 1387 */     if (this.item_banggong_time != _o_.item_banggong_time) return false;
/* 1388 */     if (this.yuanbao_redeem_bang_gong != _o_.yuanbao_redeem_bang_gong) return false;
/* 1389 */     if (this.create_gang_team_time != _o_.create_gang_team_time) return false;
/* 1390 */     if (this.is_in_gang != _o_.is_in_gang) return false;
/* 1391 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/* 1397 */     _xdb_verify_unsafe_();
/* 1398 */     int _h_ = 0;
/* 1399 */     _h_ += this.duty;
/* 1400 */     _h_ = (int)(_h_ + this.banggong);
/* 1401 */     _h_ = (int)(_h_ + this.historybanggong);
/* 1402 */     _h_ = (int)(_h_ + this.gangid);
/* 1403 */     _h_ = (int)(_h_ + this.jointime);
/* 1404 */     _h_ = (int)(_h_ + this.forbiddentalkend);
/* 1405 */     _h_ = (int)(_h_ + this.lastreadannouncementtimestamp);
/* 1406 */     _h_ = (int)(_h_ + this.redeembanggong);
/* 1407 */     _h_ = (int)(_h_ + this.nextupdateredeemtimestamp);
/* 1408 */     _h_ += this.makemifangcount;
/* 1409 */     _h_ += this.totalmakemifangcount;
/* 1410 */     _h_ = (int)(_h_ + this.lasthavemifangtime);
/* 1411 */     _h_ = (int)(_h_ + this.lastgetfulitime);
/* 1412 */     _h_ = (int)(_h_ + this.lastgetlihetime);
/* 1413 */     _h_ += this.gongxun;
/* 1414 */     _h_ = (int)(_h_ + this.gongxun_timestamp);
/* 1415 */     _h_ += this.issign;
/* 1416 */     _h_ = (int)(_h_ + this.signtime);
/* 1417 */     _h_ += this.signstr.hashCode();
/* 1418 */     _h_ += (this.ispassiveleaved ? 1231 : 1237);
/* 1419 */     _h_ += this.weekbanggong;
/* 1420 */     _h_ = (int)(_h_ + this.addbanggong_time);
/* 1421 */     _h_ += this.weekitem_banggong_count;
/* 1422 */     _h_ = (int)(_h_ + this.item_banggong_time);
/* 1423 */     _h_ += this.yuanbao_redeem_bang_gong;
/* 1424 */     _h_ = (int)(_h_ + this.create_gang_team_time);
/* 1425 */     _h_ += (this.is_in_gang ? 1231 : 1237);
/* 1426 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1432 */     _xdb_verify_unsafe_();
/* 1433 */     StringBuilder _sb_ = new StringBuilder();
/* 1434 */     _sb_.append("(");
/* 1435 */     _sb_.append(this.duty);
/* 1436 */     _sb_.append(",");
/* 1437 */     _sb_.append(this.banggong);
/* 1438 */     _sb_.append(",");
/* 1439 */     _sb_.append(this.historybanggong);
/* 1440 */     _sb_.append(",");
/* 1441 */     _sb_.append(this.gangid);
/* 1442 */     _sb_.append(",");
/* 1443 */     _sb_.append(this.jointime);
/* 1444 */     _sb_.append(",");
/* 1445 */     _sb_.append(this.forbiddentalkend);
/* 1446 */     _sb_.append(",");
/* 1447 */     _sb_.append(this.lastreadannouncementtimestamp);
/* 1448 */     _sb_.append(",");
/* 1449 */     _sb_.append(this.redeembanggong);
/* 1450 */     _sb_.append(",");
/* 1451 */     _sb_.append(this.nextupdateredeemtimestamp);
/* 1452 */     _sb_.append(",");
/* 1453 */     _sb_.append(this.makemifangcount);
/* 1454 */     _sb_.append(",");
/* 1455 */     _sb_.append(this.totalmakemifangcount);
/* 1456 */     _sb_.append(",");
/* 1457 */     _sb_.append(this.lasthavemifangtime);
/* 1458 */     _sb_.append(",");
/* 1459 */     _sb_.append(this.lastgetfulitime);
/* 1460 */     _sb_.append(",");
/* 1461 */     _sb_.append(this.lastgetlihetime);
/* 1462 */     _sb_.append(",");
/* 1463 */     _sb_.append(this.gongxun);
/* 1464 */     _sb_.append(",");
/* 1465 */     _sb_.append(this.gongxun_timestamp);
/* 1466 */     _sb_.append(",");
/* 1467 */     _sb_.append(this.issign);
/* 1468 */     _sb_.append(",");
/* 1469 */     _sb_.append(this.signtime);
/* 1470 */     _sb_.append(",");
/* 1471 */     _sb_.append("'").append(this.signstr).append("'");
/* 1472 */     _sb_.append(",");
/* 1473 */     _sb_.append(this.ispassiveleaved);
/* 1474 */     _sb_.append(",");
/* 1475 */     _sb_.append(this.weekbanggong);
/* 1476 */     _sb_.append(",");
/* 1477 */     _sb_.append(this.addbanggong_time);
/* 1478 */     _sb_.append(",");
/* 1479 */     _sb_.append(this.weekitem_banggong_count);
/* 1480 */     _sb_.append(",");
/* 1481 */     _sb_.append(this.item_banggong_time);
/* 1482 */     _sb_.append(",");
/* 1483 */     _sb_.append(this.yuanbao_redeem_bang_gong);
/* 1484 */     _sb_.append(",");
/* 1485 */     _sb_.append(this.create_gang_team_time);
/* 1486 */     _sb_.append(",");
/* 1487 */     _sb_.append(this.is_in_gang);
/* 1488 */     _sb_.append(")");
/* 1489 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/* 1495 */     ListenableBean lb = new ListenableBean();
/* 1496 */     lb.add(new ListenableChanged().setVarName("duty"));
/* 1497 */     lb.add(new ListenableChanged().setVarName("banggong"));
/* 1498 */     lb.add(new ListenableChanged().setVarName("historybanggong"));
/* 1499 */     lb.add(new ListenableChanged().setVarName("gangid"));
/* 1500 */     lb.add(new ListenableChanged().setVarName("jointime"));
/* 1501 */     lb.add(new ListenableChanged().setVarName("forbiddentalkend"));
/* 1502 */     lb.add(new ListenableChanged().setVarName("lastreadannouncementtimestamp"));
/* 1503 */     lb.add(new ListenableChanged().setVarName("redeembanggong"));
/* 1504 */     lb.add(new ListenableChanged().setVarName("nextupdateredeemtimestamp"));
/* 1505 */     lb.add(new ListenableChanged().setVarName("makemifangcount"));
/* 1506 */     lb.add(new ListenableChanged().setVarName("totalmakemifangcount"));
/* 1507 */     lb.add(new ListenableChanged().setVarName("lasthavemifangtime"));
/* 1508 */     lb.add(new ListenableChanged().setVarName("lastgetfulitime"));
/* 1509 */     lb.add(new ListenableChanged().setVarName("lastgetlihetime"));
/* 1510 */     lb.add(new ListenableChanged().setVarName("gongxun"));
/* 1511 */     lb.add(new ListenableChanged().setVarName("gongxun_timestamp"));
/* 1512 */     lb.add(new ListenableChanged().setVarName("issign"));
/* 1513 */     lb.add(new ListenableChanged().setVarName("signtime"));
/* 1514 */     lb.add(new ListenableChanged().setVarName("signstr"));
/* 1515 */     lb.add(new ListenableChanged().setVarName("ispassiveleaved"));
/* 1516 */     lb.add(new ListenableChanged().setVarName("weekbanggong"));
/* 1517 */     lb.add(new ListenableChanged().setVarName("addbanggong_time"));
/* 1518 */     lb.add(new ListenableChanged().setVarName("weekitem_banggong_count"));
/* 1519 */     lb.add(new ListenableChanged().setVarName("item_banggong_time"));
/* 1520 */     lb.add(new ListenableChanged().setVarName("yuanbao_redeem_bang_gong"));
/* 1521 */     lb.add(new ListenableChanged().setVarName("create_gang_team_time"));
/* 1522 */     lb.add(new ListenableChanged().setVarName("is_in_gang"));
/* 1523 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.GangMember {
/*      */     private Const() {}
/*      */     
/*      */     GangMember nThis() {
/* 1530 */       return GangMember.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1536 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangMember copy()
/*      */     {
/* 1542 */       return GangMember.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangMember toData()
/*      */     {
/* 1548 */       return GangMember.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.GangMember toBean()
/*      */     {
/* 1553 */       return GangMember.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangMember toDataIf()
/*      */     {
/* 1559 */       return GangMember.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.GangMember toBeanIf()
/*      */     {
/* 1564 */       return GangMember.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDuty()
/*      */     {
/* 1571 */       GangMember.this._xdb_verify_unsafe_();
/* 1572 */       return GangMember.this.duty;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBanggong()
/*      */     {
/* 1579 */       GangMember.this._xdb_verify_unsafe_();
/* 1580 */       return GangMember.this.banggong;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getHistorybanggong()
/*      */     {
/* 1587 */       GangMember.this._xdb_verify_unsafe_();
/* 1588 */       return GangMember.this.historybanggong;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGangid()
/*      */     {
/* 1595 */       GangMember.this._xdb_verify_unsafe_();
/* 1596 */       return GangMember.this.gangid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getJointime()
/*      */     {
/* 1603 */       GangMember.this._xdb_verify_unsafe_();
/* 1604 */       return GangMember.this.jointime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getForbiddentalkend()
/*      */     {
/* 1611 */       GangMember.this._xdb_verify_unsafe_();
/* 1612 */       return GangMember.this.forbiddentalkend;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastreadannouncementtimestamp()
/*      */     {
/* 1619 */       GangMember.this._xdb_verify_unsafe_();
/* 1620 */       return GangMember.this.lastreadannouncementtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRedeembanggong()
/*      */     {
/* 1627 */       GangMember.this._xdb_verify_unsafe_();
/* 1628 */       return GangMember.this.redeembanggong;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNextupdateredeemtimestamp()
/*      */     {
/* 1635 */       GangMember.this._xdb_verify_unsafe_();
/* 1636 */       return GangMember.this.nextupdateredeemtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMakemifangcount()
/*      */     {
/* 1643 */       GangMember.this._xdb_verify_unsafe_();
/* 1644 */       return GangMember.this.makemifangcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotalmakemifangcount()
/*      */     {
/* 1651 */       GangMember.this._xdb_verify_unsafe_();
/* 1652 */       return GangMember.this.totalmakemifangcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLasthavemifangtime()
/*      */     {
/* 1659 */       GangMember.this._xdb_verify_unsafe_();
/* 1660 */       return GangMember.this.lasthavemifangtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastgetfulitime()
/*      */     {
/* 1667 */       GangMember.this._xdb_verify_unsafe_();
/* 1668 */       return GangMember.this.lastgetfulitime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastgetlihetime()
/*      */     {
/* 1675 */       GangMember.this._xdb_verify_unsafe_();
/* 1676 */       return GangMember.this.lastgetlihetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGongxun()
/*      */     {
/* 1683 */       GangMember.this._xdb_verify_unsafe_();
/* 1684 */       return GangMember.this.gongxun;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGongxun_timestamp()
/*      */     {
/* 1691 */       GangMember.this._xdb_verify_unsafe_();
/* 1692 */       return GangMember.this.gongxun_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIssign()
/*      */     {
/* 1699 */       GangMember.this._xdb_verify_unsafe_();
/* 1700 */       return GangMember.this.issign;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSigntime()
/*      */     {
/* 1707 */       GangMember.this._xdb_verify_unsafe_();
/* 1708 */       return GangMember.this.signtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getSignstr()
/*      */     {
/* 1715 */       GangMember.this._xdb_verify_unsafe_();
/* 1716 */       return GangMember.this.signstr;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getSignstrOctets()
/*      */     {
/* 1723 */       GangMember.this._xdb_verify_unsafe_();
/* 1724 */       return GangMember.this.getSignstrOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIspassiveleaved()
/*      */     {
/* 1731 */       GangMember.this._xdb_verify_unsafe_();
/* 1732 */       return GangMember.this.ispassiveleaved;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWeekbanggong()
/*      */     {
/* 1739 */       GangMember.this._xdb_verify_unsafe_();
/* 1740 */       return GangMember.this.weekbanggong;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAddbanggong_time()
/*      */     {
/* 1747 */       GangMember.this._xdb_verify_unsafe_();
/* 1748 */       return GangMember.this.addbanggong_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWeekitem_banggong_count()
/*      */     {
/* 1755 */       GangMember.this._xdb_verify_unsafe_();
/* 1756 */       return GangMember.this.weekitem_banggong_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getItem_banggong_time()
/*      */     {
/* 1763 */       GangMember.this._xdb_verify_unsafe_();
/* 1764 */       return GangMember.this.item_banggong_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getYuanbao_redeem_bang_gong()
/*      */     {
/* 1771 */       GangMember.this._xdb_verify_unsafe_();
/* 1772 */       return GangMember.this.yuanbao_redeem_bang_gong;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreate_gang_team_time()
/*      */     {
/* 1779 */       GangMember.this._xdb_verify_unsafe_();
/* 1780 */       return GangMember.this.create_gang_team_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_in_gang()
/*      */     {
/* 1787 */       GangMember.this._xdb_verify_unsafe_();
/* 1788 */       return GangMember.this.is_in_gang;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDuty(int _v_)
/*      */     {
/* 1795 */       GangMember.this._xdb_verify_unsafe_();
/* 1796 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBanggong(long _v_)
/*      */     {
/* 1803 */       GangMember.this._xdb_verify_unsafe_();
/* 1804 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHistorybanggong(long _v_)
/*      */     {
/* 1811 */       GangMember.this._xdb_verify_unsafe_();
/* 1812 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGangid(long _v_)
/*      */     {
/* 1819 */       GangMember.this._xdb_verify_unsafe_();
/* 1820 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJointime(long _v_)
/*      */     {
/* 1827 */       GangMember.this._xdb_verify_unsafe_();
/* 1828 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setForbiddentalkend(long _v_)
/*      */     {
/* 1835 */       GangMember.this._xdb_verify_unsafe_();
/* 1836 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastreadannouncementtimestamp(long _v_)
/*      */     {
/* 1843 */       GangMember.this._xdb_verify_unsafe_();
/* 1844 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRedeembanggong(long _v_)
/*      */     {
/* 1851 */       GangMember.this._xdb_verify_unsafe_();
/* 1852 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNextupdateredeemtimestamp(long _v_)
/*      */     {
/* 1859 */       GangMember.this._xdb_verify_unsafe_();
/* 1860 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMakemifangcount(int _v_)
/*      */     {
/* 1867 */       GangMember.this._xdb_verify_unsafe_();
/* 1868 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotalmakemifangcount(int _v_)
/*      */     {
/* 1875 */       GangMember.this._xdb_verify_unsafe_();
/* 1876 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLasthavemifangtime(long _v_)
/*      */     {
/* 1883 */       GangMember.this._xdb_verify_unsafe_();
/* 1884 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastgetfulitime(long _v_)
/*      */     {
/* 1891 */       GangMember.this._xdb_verify_unsafe_();
/* 1892 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastgetlihetime(long _v_)
/*      */     {
/* 1899 */       GangMember.this._xdb_verify_unsafe_();
/* 1900 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGongxun(int _v_)
/*      */     {
/* 1907 */       GangMember.this._xdb_verify_unsafe_();
/* 1908 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGongxun_timestamp(long _v_)
/*      */     {
/* 1915 */       GangMember.this._xdb_verify_unsafe_();
/* 1916 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIssign(int _v_)
/*      */     {
/* 1923 */       GangMember.this._xdb_verify_unsafe_();
/* 1924 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSigntime(long _v_)
/*      */     {
/* 1931 */       GangMember.this._xdb_verify_unsafe_();
/* 1932 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSignstr(String _v_)
/*      */     {
/* 1939 */       GangMember.this._xdb_verify_unsafe_();
/* 1940 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSignstrOctets(Octets _v_)
/*      */     {
/* 1947 */       GangMember.this._xdb_verify_unsafe_();
/* 1948 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIspassiveleaved(boolean _v_)
/*      */     {
/* 1955 */       GangMember.this._xdb_verify_unsafe_();
/* 1956 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekbanggong(int _v_)
/*      */     {
/* 1963 */       GangMember.this._xdb_verify_unsafe_();
/* 1964 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAddbanggong_time(long _v_)
/*      */     {
/* 1971 */       GangMember.this._xdb_verify_unsafe_();
/* 1972 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekitem_banggong_count(int _v_)
/*      */     {
/* 1979 */       GangMember.this._xdb_verify_unsafe_();
/* 1980 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_banggong_time(long _v_)
/*      */     {
/* 1987 */       GangMember.this._xdb_verify_unsafe_();
/* 1988 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setYuanbao_redeem_bang_gong(int _v_)
/*      */     {
/* 1995 */       GangMember.this._xdb_verify_unsafe_();
/* 1996 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreate_gang_team_time(long _v_)
/*      */     {
/* 2003 */       GangMember.this._xdb_verify_unsafe_();
/* 2004 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_in_gang(boolean _v_)
/*      */     {
/* 2011 */       GangMember.this._xdb_verify_unsafe_();
/* 2012 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 2018 */       GangMember.this._xdb_verify_unsafe_();
/* 2019 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 2025 */       GangMember.this._xdb_verify_unsafe_();
/* 2026 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 2032 */       return GangMember.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2038 */       return GangMember.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2044 */       GangMember.this._xdb_verify_unsafe_();
/* 2045 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 2051 */       return GangMember.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2057 */       return GangMember.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2063 */       GangMember.this._xdb_verify_unsafe_();
/* 2064 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 2070 */       return GangMember.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2076 */       return GangMember.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 2082 */       return GangMember.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 2088 */       return GangMember.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 2094 */       return GangMember.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 2100 */       return GangMember.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2106 */       return GangMember.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.GangMember
/*      */   {
/*      */     private int duty;
/*      */     
/*      */     private long banggong;
/*      */     
/*      */     private long historybanggong;
/*      */     
/*      */     private long gangid;
/*      */     
/*      */     private long jointime;
/*      */     
/*      */     private long forbiddentalkend;
/*      */     
/*      */     private long lastreadannouncementtimestamp;
/*      */     
/*      */     private long redeembanggong;
/*      */     
/*      */     private long nextupdateredeemtimestamp;
/*      */     
/*      */     private int makemifangcount;
/*      */     
/*      */     private int totalmakemifangcount;
/*      */     
/*      */     private long lasthavemifangtime;
/*      */     
/*      */     private long lastgetfulitime;
/*      */     
/*      */     private long lastgetlihetime;
/*      */     
/*      */     private int gongxun;
/*      */     
/*      */     private long gongxun_timestamp;
/*      */     
/*      */     private int issign;
/*      */     
/*      */     private long signtime;
/*      */     
/*      */     private String signstr;
/*      */     
/*      */     private boolean ispassiveleaved;
/*      */     
/*      */     private int weekbanggong;
/*      */     
/*      */     private long addbanggong_time;
/*      */     
/*      */     private int weekitem_banggong_count;
/*      */     
/*      */     private long item_banggong_time;
/*      */     
/*      */     private int yuanbao_redeem_bang_gong;
/*      */     
/*      */     private long create_gang_team_time;
/*      */     
/*      */     private boolean is_in_gang;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 2170 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 2175 */       this.signstr = "";
/* 2176 */       this.ispassiveleaved = false;
/* 2177 */       this.create_gang_team_time = 0L;
/* 2178 */       this.is_in_gang = true;
/*      */     }
/*      */     
/*      */     Data(xbean.GangMember _o1_)
/*      */     {
/* 2183 */       if ((_o1_ instanceof GangMember)) { assign((GangMember)_o1_);
/* 2184 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 2185 */       } else if ((_o1_ instanceof GangMember.Const)) assign(((GangMember.Const)_o1_).nThis()); else {
/* 2186 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(GangMember _o_) {
/* 2191 */       this.duty = _o_.duty;
/* 2192 */       this.banggong = _o_.banggong;
/* 2193 */       this.historybanggong = _o_.historybanggong;
/* 2194 */       this.gangid = _o_.gangid;
/* 2195 */       this.jointime = _o_.jointime;
/* 2196 */       this.forbiddentalkend = _o_.forbiddentalkend;
/* 2197 */       this.lastreadannouncementtimestamp = _o_.lastreadannouncementtimestamp;
/* 2198 */       this.redeembanggong = _o_.redeembanggong;
/* 2199 */       this.nextupdateredeemtimestamp = _o_.nextupdateredeemtimestamp;
/* 2200 */       this.makemifangcount = _o_.makemifangcount;
/* 2201 */       this.totalmakemifangcount = _o_.totalmakemifangcount;
/* 2202 */       this.lasthavemifangtime = _o_.lasthavemifangtime;
/* 2203 */       this.lastgetfulitime = _o_.lastgetfulitime;
/* 2204 */       this.lastgetlihetime = _o_.lastgetlihetime;
/* 2205 */       this.gongxun = _o_.gongxun;
/* 2206 */       this.gongxun_timestamp = _o_.gongxun_timestamp;
/* 2207 */       this.issign = _o_.issign;
/* 2208 */       this.signtime = _o_.signtime;
/* 2209 */       this.signstr = _o_.signstr;
/* 2210 */       this.ispassiveleaved = _o_.ispassiveleaved;
/* 2211 */       this.weekbanggong = _o_.weekbanggong;
/* 2212 */       this.addbanggong_time = _o_.addbanggong_time;
/* 2213 */       this.weekitem_banggong_count = _o_.weekitem_banggong_count;
/* 2214 */       this.item_banggong_time = _o_.item_banggong_time;
/* 2215 */       this.yuanbao_redeem_bang_gong = _o_.yuanbao_redeem_bang_gong;
/* 2216 */       this.create_gang_team_time = _o_.create_gang_team_time;
/* 2217 */       this.is_in_gang = _o_.is_in_gang;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 2222 */       this.duty = _o_.duty;
/* 2223 */       this.banggong = _o_.banggong;
/* 2224 */       this.historybanggong = _o_.historybanggong;
/* 2225 */       this.gangid = _o_.gangid;
/* 2226 */       this.jointime = _o_.jointime;
/* 2227 */       this.forbiddentalkend = _o_.forbiddentalkend;
/* 2228 */       this.lastreadannouncementtimestamp = _o_.lastreadannouncementtimestamp;
/* 2229 */       this.redeembanggong = _o_.redeembanggong;
/* 2230 */       this.nextupdateredeemtimestamp = _o_.nextupdateredeemtimestamp;
/* 2231 */       this.makemifangcount = _o_.makemifangcount;
/* 2232 */       this.totalmakemifangcount = _o_.totalmakemifangcount;
/* 2233 */       this.lasthavemifangtime = _o_.lasthavemifangtime;
/* 2234 */       this.lastgetfulitime = _o_.lastgetfulitime;
/* 2235 */       this.lastgetlihetime = _o_.lastgetlihetime;
/* 2236 */       this.gongxun = _o_.gongxun;
/* 2237 */       this.gongxun_timestamp = _o_.gongxun_timestamp;
/* 2238 */       this.issign = _o_.issign;
/* 2239 */       this.signtime = _o_.signtime;
/* 2240 */       this.signstr = _o_.signstr;
/* 2241 */       this.ispassiveleaved = _o_.ispassiveleaved;
/* 2242 */       this.weekbanggong = _o_.weekbanggong;
/* 2243 */       this.addbanggong_time = _o_.addbanggong_time;
/* 2244 */       this.weekitem_banggong_count = _o_.weekitem_banggong_count;
/* 2245 */       this.item_banggong_time = _o_.item_banggong_time;
/* 2246 */       this.yuanbao_redeem_bang_gong = _o_.yuanbao_redeem_bang_gong;
/* 2247 */       this.create_gang_team_time = _o_.create_gang_team_time;
/* 2248 */       this.is_in_gang = _o_.is_in_gang;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2254 */       _os_.marshal(this.duty);
/* 2255 */       _os_.marshal(this.banggong);
/* 2256 */       _os_.marshal(this.historybanggong);
/* 2257 */       _os_.marshal(this.gangid);
/* 2258 */       _os_.marshal(this.jointime);
/* 2259 */       _os_.marshal(this.forbiddentalkend);
/* 2260 */       _os_.marshal(this.lastreadannouncementtimestamp);
/* 2261 */       _os_.marshal(this.redeembanggong);
/* 2262 */       _os_.marshal(this.nextupdateredeemtimestamp);
/* 2263 */       _os_.marshal(this.makemifangcount);
/* 2264 */       _os_.marshal(this.totalmakemifangcount);
/* 2265 */       _os_.marshal(this.lasthavemifangtime);
/* 2266 */       _os_.marshal(this.lastgetfulitime);
/* 2267 */       _os_.marshal(this.lastgetlihetime);
/* 2268 */       _os_.marshal(this.gongxun);
/* 2269 */       _os_.marshal(this.gongxun_timestamp);
/* 2270 */       _os_.marshal(this.issign);
/* 2271 */       _os_.marshal(this.signtime);
/* 2272 */       _os_.marshal(this.signstr, "UTF-16LE");
/* 2273 */       _os_.marshal(this.ispassiveleaved);
/* 2274 */       _os_.marshal(this.weekbanggong);
/* 2275 */       _os_.marshal(this.addbanggong_time);
/* 2276 */       _os_.marshal(this.weekitem_banggong_count);
/* 2277 */       _os_.marshal(this.item_banggong_time);
/* 2278 */       _os_.marshal(this.yuanbao_redeem_bang_gong);
/* 2279 */       _os_.marshal(this.create_gang_team_time);
/* 2280 */       _os_.marshal(this.is_in_gang);
/* 2281 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2287 */       this.duty = _os_.unmarshal_int();
/* 2288 */       this.banggong = _os_.unmarshal_long();
/* 2289 */       this.historybanggong = _os_.unmarshal_long();
/* 2290 */       this.gangid = _os_.unmarshal_long();
/* 2291 */       this.jointime = _os_.unmarshal_long();
/* 2292 */       this.forbiddentalkend = _os_.unmarshal_long();
/* 2293 */       this.lastreadannouncementtimestamp = _os_.unmarshal_long();
/* 2294 */       this.redeembanggong = _os_.unmarshal_long();
/* 2295 */       this.nextupdateredeemtimestamp = _os_.unmarshal_long();
/* 2296 */       this.makemifangcount = _os_.unmarshal_int();
/* 2297 */       this.totalmakemifangcount = _os_.unmarshal_int();
/* 2298 */       this.lasthavemifangtime = _os_.unmarshal_long();
/* 2299 */       this.lastgetfulitime = _os_.unmarshal_long();
/* 2300 */       this.lastgetlihetime = _os_.unmarshal_long();
/* 2301 */       this.gongxun = _os_.unmarshal_int();
/* 2302 */       this.gongxun_timestamp = _os_.unmarshal_long();
/* 2303 */       this.issign = _os_.unmarshal_int();
/* 2304 */       this.signtime = _os_.unmarshal_long();
/* 2305 */       this.signstr = _os_.unmarshal_String("UTF-16LE");
/* 2306 */       this.ispassiveleaved = _os_.unmarshal_boolean();
/* 2307 */       this.weekbanggong = _os_.unmarshal_int();
/* 2308 */       this.addbanggong_time = _os_.unmarshal_long();
/* 2309 */       this.weekitem_banggong_count = _os_.unmarshal_int();
/* 2310 */       this.item_banggong_time = _os_.unmarshal_long();
/* 2311 */       this.yuanbao_redeem_bang_gong = _os_.unmarshal_int();
/* 2312 */       this.create_gang_team_time = _os_.unmarshal_long();
/* 2313 */       this.is_in_gang = _os_.unmarshal_boolean();
/* 2314 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 2320 */       int _size_ = 0;
/* 2321 */       _size_ += CodedOutputStream.computeInt32Size(1, this.duty);
/* 2322 */       _size_ += CodedOutputStream.computeInt64Size(2, this.banggong);
/* 2323 */       _size_ += CodedOutputStream.computeInt64Size(3, this.historybanggong);
/* 2324 */       _size_ += CodedOutputStream.computeInt64Size(4, this.gangid);
/* 2325 */       _size_ += CodedOutputStream.computeInt64Size(5, this.jointime);
/* 2326 */       _size_ += CodedOutputStream.computeInt64Size(6, this.forbiddentalkend);
/* 2327 */       _size_ += CodedOutputStream.computeInt64Size(7, this.lastreadannouncementtimestamp);
/* 2328 */       _size_ += CodedOutputStream.computeInt64Size(8, this.redeembanggong);
/* 2329 */       _size_ += CodedOutputStream.computeInt64Size(9, this.nextupdateredeemtimestamp);
/* 2330 */       _size_ += CodedOutputStream.computeInt32Size(10, this.makemifangcount);
/* 2331 */       _size_ += CodedOutputStream.computeInt32Size(11, this.totalmakemifangcount);
/* 2332 */       _size_ += CodedOutputStream.computeInt64Size(12, this.lasthavemifangtime);
/* 2333 */       _size_ += CodedOutputStream.computeInt64Size(13, this.lastgetfulitime);
/* 2334 */       _size_ += CodedOutputStream.computeInt64Size(14, this.lastgetlihetime);
/* 2335 */       _size_ += CodedOutputStream.computeInt32Size(15, this.gongxun);
/* 2336 */       _size_ += CodedOutputStream.computeInt64Size(16, this.gongxun_timestamp);
/* 2337 */       _size_ += CodedOutputStream.computeInt32Size(17, this.issign);
/* 2338 */       _size_ += CodedOutputStream.computeInt64Size(18, this.signtime);
/*      */       try
/*      */       {
/* 2341 */         _size_ += CodedOutputStream.computeBytesSize(19, ByteString.copyFrom(this.signstr, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2345 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 2347 */       _size_ += CodedOutputStream.computeBoolSize(20, this.ispassiveleaved);
/* 2348 */       _size_ += CodedOutputStream.computeInt32Size(21, this.weekbanggong);
/* 2349 */       _size_ += CodedOutputStream.computeInt64Size(22, this.addbanggong_time);
/* 2350 */       _size_ += CodedOutputStream.computeInt32Size(23, this.weekitem_banggong_count);
/* 2351 */       _size_ += CodedOutputStream.computeInt64Size(24, this.item_banggong_time);
/* 2352 */       _size_ += CodedOutputStream.computeInt32Size(25, this.yuanbao_redeem_bang_gong);
/* 2353 */       _size_ += CodedOutputStream.computeInt64Size(26, this.create_gang_team_time);
/* 2354 */       _size_ += CodedOutputStream.computeBoolSize(27, this.is_in_gang);
/* 2355 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2363 */         _output_.writeInt32(1, this.duty);
/* 2364 */         _output_.writeInt64(2, this.banggong);
/* 2365 */         _output_.writeInt64(3, this.historybanggong);
/* 2366 */         _output_.writeInt64(4, this.gangid);
/* 2367 */         _output_.writeInt64(5, this.jointime);
/* 2368 */         _output_.writeInt64(6, this.forbiddentalkend);
/* 2369 */         _output_.writeInt64(7, this.lastreadannouncementtimestamp);
/* 2370 */         _output_.writeInt64(8, this.redeembanggong);
/* 2371 */         _output_.writeInt64(9, this.nextupdateredeemtimestamp);
/* 2372 */         _output_.writeInt32(10, this.makemifangcount);
/* 2373 */         _output_.writeInt32(11, this.totalmakemifangcount);
/* 2374 */         _output_.writeInt64(12, this.lasthavemifangtime);
/* 2375 */         _output_.writeInt64(13, this.lastgetfulitime);
/* 2376 */         _output_.writeInt64(14, this.lastgetlihetime);
/* 2377 */         _output_.writeInt32(15, this.gongxun);
/* 2378 */         _output_.writeInt64(16, this.gongxun_timestamp);
/* 2379 */         _output_.writeInt32(17, this.issign);
/* 2380 */         _output_.writeInt64(18, this.signtime);
/* 2381 */         _output_.writeBytes(19, ByteString.copyFrom(this.signstr, "UTF-16LE"));
/* 2382 */         _output_.writeBool(20, this.ispassiveleaved);
/* 2383 */         _output_.writeInt32(21, this.weekbanggong);
/* 2384 */         _output_.writeInt64(22, this.addbanggong_time);
/* 2385 */         _output_.writeInt32(23, this.weekitem_banggong_count);
/* 2386 */         _output_.writeInt64(24, this.item_banggong_time);
/* 2387 */         _output_.writeInt32(25, this.yuanbao_redeem_bang_gong);
/* 2388 */         _output_.writeInt64(26, this.create_gang_team_time);
/* 2389 */         _output_.writeBool(27, this.is_in_gang);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2393 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2395 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2403 */         boolean done = false;
/* 2404 */         while (!done)
/*      */         {
/* 2406 */           int tag = _input_.readTag();
/* 2407 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 2411 */             done = true;
/* 2412 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 2416 */             this.duty = _input_.readInt32();
/* 2417 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 2421 */             this.banggong = _input_.readInt64();
/* 2422 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 2426 */             this.historybanggong = _input_.readInt64();
/* 2427 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 2431 */             this.gangid = _input_.readInt64();
/* 2432 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 2436 */             this.jointime = _input_.readInt64();
/* 2437 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 2441 */             this.forbiddentalkend = _input_.readInt64();
/* 2442 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 2446 */             this.lastreadannouncementtimestamp = _input_.readInt64();
/* 2447 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 2451 */             this.redeembanggong = _input_.readInt64();
/* 2452 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 2456 */             this.nextupdateredeemtimestamp = _input_.readInt64();
/* 2457 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 2461 */             this.makemifangcount = _input_.readInt32();
/* 2462 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 2466 */             this.totalmakemifangcount = _input_.readInt32();
/* 2467 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 2471 */             this.lasthavemifangtime = _input_.readInt64();
/* 2472 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 2476 */             this.lastgetfulitime = _input_.readInt64();
/* 2477 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 2481 */             this.lastgetlihetime = _input_.readInt64();
/* 2482 */             break;
/*      */           
/*      */ 
/*      */           case 120: 
/* 2486 */             this.gongxun = _input_.readInt32();
/* 2487 */             break;
/*      */           
/*      */ 
/*      */           case 128: 
/* 2491 */             this.gongxun_timestamp = _input_.readInt64();
/* 2492 */             break;
/*      */           
/*      */ 
/*      */           case 136: 
/* 2496 */             this.issign = _input_.readInt32();
/* 2497 */             break;
/*      */           
/*      */ 
/*      */           case 144: 
/* 2501 */             this.signtime = _input_.readInt64();
/* 2502 */             break;
/*      */           
/*      */ 
/*      */           case 154: 
/* 2506 */             this.signstr = _input_.readBytes().toString("UTF-16LE");
/* 2507 */             break;
/*      */           
/*      */ 
/*      */           case 160: 
/* 2511 */             this.ispassiveleaved = _input_.readBool();
/* 2512 */             break;
/*      */           
/*      */ 
/*      */           case 168: 
/* 2516 */             this.weekbanggong = _input_.readInt32();
/* 2517 */             break;
/*      */           
/*      */ 
/*      */           case 176: 
/* 2521 */             this.addbanggong_time = _input_.readInt64();
/* 2522 */             break;
/*      */           
/*      */ 
/*      */           case 184: 
/* 2526 */             this.weekitem_banggong_count = _input_.readInt32();
/* 2527 */             break;
/*      */           
/*      */ 
/*      */           case 192: 
/* 2531 */             this.item_banggong_time = _input_.readInt64();
/* 2532 */             break;
/*      */           
/*      */ 
/*      */           case 200: 
/* 2536 */             this.yuanbao_redeem_bang_gong = _input_.readInt32();
/* 2537 */             break;
/*      */           
/*      */ 
/*      */           case 208: 
/* 2541 */             this.create_gang_team_time = _input_.readInt64();
/* 2542 */             break;
/*      */           
/*      */ 
/*      */           case 216: 
/* 2546 */             this.is_in_gang = _input_.readBool();
/* 2547 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 2551 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 2553 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 2562 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2566 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2568 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangMember copy()
/*      */     {
/* 2574 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangMember toData()
/*      */     {
/* 2580 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.GangMember toBean()
/*      */     {
/* 2585 */       return new GangMember(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GangMember toDataIf()
/*      */     {
/* 2591 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.GangMember toBeanIf()
/*      */     {
/* 2596 */       return new GangMember(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2602 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 2606 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 2610 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 2614 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 2618 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 2622 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 2626 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDuty()
/*      */     {
/* 2633 */       return this.duty;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBanggong()
/*      */     {
/* 2640 */       return this.banggong;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getHistorybanggong()
/*      */     {
/* 2647 */       return this.historybanggong;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGangid()
/*      */     {
/* 2654 */       return this.gangid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getJointime()
/*      */     {
/* 2661 */       return this.jointime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getForbiddentalkend()
/*      */     {
/* 2668 */       return this.forbiddentalkend;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastreadannouncementtimestamp()
/*      */     {
/* 2675 */       return this.lastreadannouncementtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRedeembanggong()
/*      */     {
/* 2682 */       return this.redeembanggong;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNextupdateredeemtimestamp()
/*      */     {
/* 2689 */       return this.nextupdateredeemtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMakemifangcount()
/*      */     {
/* 2696 */       return this.makemifangcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotalmakemifangcount()
/*      */     {
/* 2703 */       return this.totalmakemifangcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLasthavemifangtime()
/*      */     {
/* 2710 */       return this.lasthavemifangtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastgetfulitime()
/*      */     {
/* 2717 */       return this.lastgetfulitime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastgetlihetime()
/*      */     {
/* 2724 */       return this.lastgetlihetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGongxun()
/*      */     {
/* 2731 */       return this.gongxun;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGongxun_timestamp()
/*      */     {
/* 2738 */       return this.gongxun_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIssign()
/*      */     {
/* 2745 */       return this.issign;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSigntime()
/*      */     {
/* 2752 */       return this.signtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getSignstr()
/*      */     {
/* 2759 */       return this.signstr;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getSignstrOctets()
/*      */     {
/* 2766 */       return Octets.wrap(getSignstr(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIspassiveleaved()
/*      */     {
/* 2773 */       return this.ispassiveleaved;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWeekbanggong()
/*      */     {
/* 2780 */       return this.weekbanggong;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAddbanggong_time()
/*      */     {
/* 2787 */       return this.addbanggong_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWeekitem_banggong_count()
/*      */     {
/* 2794 */       return this.weekitem_banggong_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getItem_banggong_time()
/*      */     {
/* 2801 */       return this.item_banggong_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getYuanbao_redeem_bang_gong()
/*      */     {
/* 2808 */       return this.yuanbao_redeem_bang_gong;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreate_gang_team_time()
/*      */     {
/* 2815 */       return this.create_gang_team_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_in_gang()
/*      */     {
/* 2822 */       return this.is_in_gang;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDuty(int _v_)
/*      */     {
/* 2829 */       this.duty = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBanggong(long _v_)
/*      */     {
/* 2836 */       this.banggong = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHistorybanggong(long _v_)
/*      */     {
/* 2843 */       this.historybanggong = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGangid(long _v_)
/*      */     {
/* 2850 */       this.gangid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJointime(long _v_)
/*      */     {
/* 2857 */       this.jointime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setForbiddentalkend(long _v_)
/*      */     {
/* 2864 */       this.forbiddentalkend = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastreadannouncementtimestamp(long _v_)
/*      */     {
/* 2871 */       this.lastreadannouncementtimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRedeembanggong(long _v_)
/*      */     {
/* 2878 */       this.redeembanggong = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNextupdateredeemtimestamp(long _v_)
/*      */     {
/* 2885 */       this.nextupdateredeemtimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMakemifangcount(int _v_)
/*      */     {
/* 2892 */       this.makemifangcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotalmakemifangcount(int _v_)
/*      */     {
/* 2899 */       this.totalmakemifangcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLasthavemifangtime(long _v_)
/*      */     {
/* 2906 */       this.lasthavemifangtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastgetfulitime(long _v_)
/*      */     {
/* 2913 */       this.lastgetfulitime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastgetlihetime(long _v_)
/*      */     {
/* 2920 */       this.lastgetlihetime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGongxun(int _v_)
/*      */     {
/* 2927 */       this.gongxun = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGongxun_timestamp(long _v_)
/*      */     {
/* 2934 */       this.gongxun_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIssign(int _v_)
/*      */     {
/* 2941 */       this.issign = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSigntime(long _v_)
/*      */     {
/* 2948 */       this.signtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSignstr(String _v_)
/*      */     {
/* 2955 */       if (null == _v_)
/* 2956 */         throw new NullPointerException();
/* 2957 */       this.signstr = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSignstrOctets(Octets _v_)
/*      */     {
/* 2964 */       setSignstr(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIspassiveleaved(boolean _v_)
/*      */     {
/* 2971 */       this.ispassiveleaved = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekbanggong(int _v_)
/*      */     {
/* 2978 */       this.weekbanggong = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAddbanggong_time(long _v_)
/*      */     {
/* 2985 */       this.addbanggong_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekitem_banggong_count(int _v_)
/*      */     {
/* 2992 */       this.weekitem_banggong_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItem_banggong_time(long _v_)
/*      */     {
/* 2999 */       this.item_banggong_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setYuanbao_redeem_bang_gong(int _v_)
/*      */     {
/* 3006 */       this.yuanbao_redeem_bang_gong = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreate_gang_team_time(long _v_)
/*      */     {
/* 3013 */       this.create_gang_team_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_in_gang(boolean _v_)
/*      */     {
/* 3020 */       this.is_in_gang = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 3026 */       if (!(_o1_ instanceof Data)) return false;
/* 3027 */       Data _o_ = (Data)_o1_;
/* 3028 */       if (this.duty != _o_.duty) return false;
/* 3029 */       if (this.banggong != _o_.banggong) return false;
/* 3030 */       if (this.historybanggong != _o_.historybanggong) return false;
/* 3031 */       if (this.gangid != _o_.gangid) return false;
/* 3032 */       if (this.jointime != _o_.jointime) return false;
/* 3033 */       if (this.forbiddentalkend != _o_.forbiddentalkend) return false;
/* 3034 */       if (this.lastreadannouncementtimestamp != _o_.lastreadannouncementtimestamp) return false;
/* 3035 */       if (this.redeembanggong != _o_.redeembanggong) return false;
/* 3036 */       if (this.nextupdateredeemtimestamp != _o_.nextupdateredeemtimestamp) return false;
/* 3037 */       if (this.makemifangcount != _o_.makemifangcount) return false;
/* 3038 */       if (this.totalmakemifangcount != _o_.totalmakemifangcount) return false;
/* 3039 */       if (this.lasthavemifangtime != _o_.lasthavemifangtime) return false;
/* 3040 */       if (this.lastgetfulitime != _o_.lastgetfulitime) return false;
/* 3041 */       if (this.lastgetlihetime != _o_.lastgetlihetime) return false;
/* 3042 */       if (this.gongxun != _o_.gongxun) return false;
/* 3043 */       if (this.gongxun_timestamp != _o_.gongxun_timestamp) return false;
/* 3044 */       if (this.issign != _o_.issign) return false;
/* 3045 */       if (this.signtime != _o_.signtime) return false;
/* 3046 */       if (!this.signstr.equals(_o_.signstr)) return false;
/* 3047 */       if (this.ispassiveleaved != _o_.ispassiveleaved) return false;
/* 3048 */       if (this.weekbanggong != _o_.weekbanggong) return false;
/* 3049 */       if (this.addbanggong_time != _o_.addbanggong_time) return false;
/* 3050 */       if (this.weekitem_banggong_count != _o_.weekitem_banggong_count) return false;
/* 3051 */       if (this.item_banggong_time != _o_.item_banggong_time) return false;
/* 3052 */       if (this.yuanbao_redeem_bang_gong != _o_.yuanbao_redeem_bang_gong) return false;
/* 3053 */       if (this.create_gang_team_time != _o_.create_gang_team_time) return false;
/* 3054 */       if (this.is_in_gang != _o_.is_in_gang) return false;
/* 3055 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 3061 */       int _h_ = 0;
/* 3062 */       _h_ += this.duty;
/* 3063 */       _h_ = (int)(_h_ + this.banggong);
/* 3064 */       _h_ = (int)(_h_ + this.historybanggong);
/* 3065 */       _h_ = (int)(_h_ + this.gangid);
/* 3066 */       _h_ = (int)(_h_ + this.jointime);
/* 3067 */       _h_ = (int)(_h_ + this.forbiddentalkend);
/* 3068 */       _h_ = (int)(_h_ + this.lastreadannouncementtimestamp);
/* 3069 */       _h_ = (int)(_h_ + this.redeembanggong);
/* 3070 */       _h_ = (int)(_h_ + this.nextupdateredeemtimestamp);
/* 3071 */       _h_ += this.makemifangcount;
/* 3072 */       _h_ += this.totalmakemifangcount;
/* 3073 */       _h_ = (int)(_h_ + this.lasthavemifangtime);
/* 3074 */       _h_ = (int)(_h_ + this.lastgetfulitime);
/* 3075 */       _h_ = (int)(_h_ + this.lastgetlihetime);
/* 3076 */       _h_ += this.gongxun;
/* 3077 */       _h_ = (int)(_h_ + this.gongxun_timestamp);
/* 3078 */       _h_ += this.issign;
/* 3079 */       _h_ = (int)(_h_ + this.signtime);
/* 3080 */       _h_ += this.signstr.hashCode();
/* 3081 */       _h_ += (this.ispassiveleaved ? 1231 : 1237);
/* 3082 */       _h_ += this.weekbanggong;
/* 3083 */       _h_ = (int)(_h_ + this.addbanggong_time);
/* 3084 */       _h_ += this.weekitem_banggong_count;
/* 3085 */       _h_ = (int)(_h_ + this.item_banggong_time);
/* 3086 */       _h_ += this.yuanbao_redeem_bang_gong;
/* 3087 */       _h_ = (int)(_h_ + this.create_gang_team_time);
/* 3088 */       _h_ += (this.is_in_gang ? 1231 : 1237);
/* 3089 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 3095 */       StringBuilder _sb_ = new StringBuilder();
/* 3096 */       _sb_.append("(");
/* 3097 */       _sb_.append(this.duty);
/* 3098 */       _sb_.append(",");
/* 3099 */       _sb_.append(this.banggong);
/* 3100 */       _sb_.append(",");
/* 3101 */       _sb_.append(this.historybanggong);
/* 3102 */       _sb_.append(",");
/* 3103 */       _sb_.append(this.gangid);
/* 3104 */       _sb_.append(",");
/* 3105 */       _sb_.append(this.jointime);
/* 3106 */       _sb_.append(",");
/* 3107 */       _sb_.append(this.forbiddentalkend);
/* 3108 */       _sb_.append(",");
/* 3109 */       _sb_.append(this.lastreadannouncementtimestamp);
/* 3110 */       _sb_.append(",");
/* 3111 */       _sb_.append(this.redeembanggong);
/* 3112 */       _sb_.append(",");
/* 3113 */       _sb_.append(this.nextupdateredeemtimestamp);
/* 3114 */       _sb_.append(",");
/* 3115 */       _sb_.append(this.makemifangcount);
/* 3116 */       _sb_.append(",");
/* 3117 */       _sb_.append(this.totalmakemifangcount);
/* 3118 */       _sb_.append(",");
/* 3119 */       _sb_.append(this.lasthavemifangtime);
/* 3120 */       _sb_.append(",");
/* 3121 */       _sb_.append(this.lastgetfulitime);
/* 3122 */       _sb_.append(",");
/* 3123 */       _sb_.append(this.lastgetlihetime);
/* 3124 */       _sb_.append(",");
/* 3125 */       _sb_.append(this.gongxun);
/* 3126 */       _sb_.append(",");
/* 3127 */       _sb_.append(this.gongxun_timestamp);
/* 3128 */       _sb_.append(",");
/* 3129 */       _sb_.append(this.issign);
/* 3130 */       _sb_.append(",");
/* 3131 */       _sb_.append(this.signtime);
/* 3132 */       _sb_.append(",");
/* 3133 */       _sb_.append("'").append(this.signstr).append("'");
/* 3134 */       _sb_.append(",");
/* 3135 */       _sb_.append(this.ispassiveleaved);
/* 3136 */       _sb_.append(",");
/* 3137 */       _sb_.append(this.weekbanggong);
/* 3138 */       _sb_.append(",");
/* 3139 */       _sb_.append(this.addbanggong_time);
/* 3140 */       _sb_.append(",");
/* 3141 */       _sb_.append(this.weekitem_banggong_count);
/* 3142 */       _sb_.append(",");
/* 3143 */       _sb_.append(this.item_banggong_time);
/* 3144 */       _sb_.append(",");
/* 3145 */       _sb_.append(this.yuanbao_redeem_bang_gong);
/* 3146 */       _sb_.append(",");
/* 3147 */       _sb_.append(this.create_gang_team_time);
/* 3148 */       _sb_.append(",");
/* 3149 */       _sb_.append(this.is_in_gang);
/* 3150 */       _sb_.append(")");
/* 3151 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GangMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */